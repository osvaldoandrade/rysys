package br.com.codecompany.rysys.iso8583.sirot.protocol;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.commons.lang.ArrayUtils;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelPipelineCoverage;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.WriteCompletionEvent;
import org.jboss.netty.handler.timeout.IdleStateAwareChannelHandler;
import org.jboss.netty.handler.timeout.IdleStateEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.codecompany.rysys.core.driver.TimeoutException;
import br.com.codecompany.rysys.iso8583.sirot.SirotAdapter;
import br.com.codecompany.rysys.iso8583.util.Iso8583MessageUtils;

import com.solab.iso8583.IsoMessage;

@ChannelPipelineCoverage("one")
public class SirotMessageDecoder extends IdleStateAwareChannelHandler {
	
	private Logger log = LoggerFactory.getLogger(SirotMessageDecoder.class);

	private SirotAdapter adapter;
	private List<IsoMessage> receivedMessages;
    private final ChannelBuffer buffer = ChannelBuffers.dynamicBuffer();
    private final BlockingQueue<List<IsoMessage>> answer = 
    	new LinkedBlockingQueue<List<IsoMessage>>();
	private TimerTask readTimeoutTask = new TimerTask() {
	    // esse metodo dispara quando o quando o timeout for atingido
		public void run() {
			throw new TimeoutException("Timeout reached while reading from channel. " +
    				"Current timeout is " + adapter.getTimeout() + " ms");
		}    		
	};
	private TimerTask writeTimeoutTask = new TimerTask() {
	    // esse metodo dispara quando o quando o timeout for atingido
		public void run() {
			throw new TimeoutException("Timeout reached while writing to channel. " +
    				"Current timeout is " + adapter.getTimeout() + " ms");
		}    		
	};
	
    public SirotMessageDecoder(SirotAdapter adapter) {
    	this.adapter = adapter;
	}
    
    public List<IsoMessage> getResponse() {
    	readTimer = new Timer();
    	// inicia a contagem do timeout
    	readTimer.schedule(readTimeoutTask, adapter.getTimeout());
        for (;;) {
            try {
            	List<IsoMessage> list = answer.take();
            	readTimer.cancel();
                return list;
            } catch (InterruptedException e) {
                // Ignore.
            }
        }
    }

	private Timer readTimer = null;    
    private Timer writeTimer = null;
    
    @Override
    public void writeRequested(ChannelHandlerContext ctx, MessageEvent e)
    		throws Exception {
    	writeTimer = new Timer();
    	// inicia a contagem do timeout    	
    	writeTimer.schedule(writeTimeoutTask, adapter.getTimeout());
    	super.writeRequested(ctx, e);
    }
    
    @Override
    public void writeComplete(ChannelHandlerContext ctx, WriteCompletionEvent e)
    		throws Exception {    	
    	writeTimer.cancel();
    	super.writeComplete(ctx, e);
    }
    
    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e)
    		throws Exception {
    	
    	// reset messages
    	receivedMessages = null;
    	
    	// get bytes from channel
    	ChannelBuffer m = (ChannelBuffer) e.getMessage();
    	buffer.writeBytes(m);
    	
    	// copia para um array temporário
		int length = buffer.readableBytes();
		byte[] bytes = new byte[length];		
		buffer.getBytes(buffer.readerIndex(), bytes);
		
		log.debug("Message received from server. Current buffer is [{}]", new String(bytes));
		
		if (finished(bytes)) {
			buffer.readBytes(bytes);
			answer.offer(receivedMessages);			
		}
    }
    
    @Override
    public void channelIdle(ChannelHandlerContext ctx, IdleStateEvent e) {
    	long last = e.getLastActivityTimeMillis();
    	long now = System.currentTimeMillis();
    	long idle = now - last;
    	Integer frequency = adapter.getPingFrequency();
		if (idle >= frequency && frequency > 0) {
    		log.info("Channel is idle for {} ms. Pinging the server...", idle);
	    	byte[] ping = adapter.pingMessage();
	    	if (ping != null && ping.length > 0) {
	    		ctx.getChannel().write(ChannelBuffers.copiedBuffer(ping));
	    	}
	    	else {
	    		log.warn("Ping message is null or empty. Ping ignored");
	    	}
    	}
    }
    
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e)
    		throws Exception {
    	Throwable cause = e.getCause();
    	log.error("The channel has been closed due to errors", cause);
    	
    	e.getChannel().close();    	
    	ctx.sendUpstream(e); 
    	if (cause instanceof Exception) {
    		throw (Exception) cause;
    	}
    	else {
    		throw new Exception(cause);
    	}
    }
	
	// check if all messages have been read
	private boolean finished(byte[] messages) {
		boolean completed = false;
		
		// all messages received are complete?
		List<byte[]> messagesAsBytes = breakInParts(messages);
		boolean something = messagesAsBytes != null
				&& messagesAsBytes.size() > 0;

		if (something) {
			// convert bytes to messages
			List<IsoMessage> list = parse(messagesAsBytes);
			
			// all messages have been received?
			if (list != null && list.size() > 0) {
				completed = adapter.getBurst().isFinished(list);
			}
			
			// all completed?
			if (completed) {
				// messages sorted
				receivedMessages = adapter.getBurst().sort(list);
			}
			
			log.debug("All messages have been received? {}", completed? "yes" : "no");			
		}

		return completed;
	}
	
	// convert byte[] to IsoMessage
	private List<IsoMessage> parse(List<byte[]> messages) {
		List<IsoMessage> list = new ArrayList<IsoMessage>();
		int size = messages.size();
		
		log.debug("Parsing {} messages", size);
		
		for (int i = 0; i < size; i++) {
			byte[] bytes  = messages.get(i);
			try {
				log.debug("Parsing message {} of {}: {}", 
						new Object[]{i+1, size, new String(bytes)});
				
				IsoMessage msg = adapter.parseMessage(bytes,
						adapter.getHeaderSize());
				
				log.debug("Message {} of {} successfully parsed!", i+1, size);
				if (log.isDebugEnabled()) {
					for (int j = 0; j <= 128; j++) {
						if (msg.hasField(j)) {
							log.debug("   Bit {} = [{}]", j, msg.getField(j));
						}
					}
				}

				if (adapter.isPing(msg)) {
					log.info("Message #{} is a ping message");
				}
				else {
					list.add(msg);
				}
				
			} catch (ParseException e) {
				log.error("Error parsing message from EIS", e);
				throw new IllegalArgumentException("Invalid message: "
						+ new String(bytes));
			}			
		}
		
		return list;
	}
	
	// breaks the messages and return only the ones that contain header and body
	private List<byte[]> breakInParts(byte[] bytes) {
		List<byte[]> list = new ArrayList<byte[]>();

		if (bytes == null || bytes.length <= adapter.getHeaderSize()) {
			log.debug("Size is too small: {} bytes",
					bytes != null ? bytes.length : bytes);
		} else {
			int beginIndex = 0;
			int endIndex = 0;
			int number = 1;

			log.debug("Breaking message in parts({} bytes): [{}]",
					bytes.length, new String(bytes));

			// inspect original array
			while (endIndex < bytes.length) {
				if (bytes.length > adapter.getHeaderSize()) {
					// extract data size from header (bytes 11 and 12)
					int bodyLength = ((bytes[11 + beginIndex] & 0xff) << 8)
							| (bytes[12 + beginIndex] & 0xff);
					log.debug("Part #{} body's length is {} bytes", number,
							bodyLength);
	
					// that's the message size, including header
					int messageLength = adapter.getHeaderSize() + bodyLength;
					endIndex = beginIndex + messageLength;
	
					if (endIndex > bytes.length) {
						log.debug("Part #{} is missing {} bytes", 
								number, endIndex-bytes.length);
						// this message is not complete yet
						break;
					}
	
					log.trace("Part #" + number	+ ": extracting bytes from {} to {}",
							beginIndex,	endIndex);
					byte[] part = ArrayUtils.subarray(bytes, beginIndex, endIndex);
	
					if (log.isTraceEnabled()) {
						Iso8583MessageUtils.traceExtraction(bytes, beginIndex, endIndex);
					}
	
					log.debug("Part #" + number + " extracted! ({} bytes): [{}]\n",
							part.length, new String(part));
					if (log.isDebugEnabled()) {
						byte[] remaining = ArrayUtils.subarray(bytes, endIndex, bytes.length);
						log.debug("Remaining message: [{}]", new String(remaining));
					}
	
					list.add(part);
	
					beginIndex = endIndex;
					number++;
					
					log.debug("{} of {} bytes processed", endIndex, bytes.length);
				}
				else {
					log.info("Message must have at least {} bytes in index to be processed", 
							adapter.getHeaderSize());
				}
			}
		}

		return list;
	}		
}