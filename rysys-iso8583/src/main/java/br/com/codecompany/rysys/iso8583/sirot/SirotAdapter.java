package br.com.codecompany.rysys.iso8583.sirot;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Executors;

import org.apache.commons.lang.StringUtils;
import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.codecompany.rysys.core.driver.ConnectionException;
import br.com.codecompany.rysys.iso8583.driver.Burst;
import br.com.codecompany.rysys.iso8583.driver.Iso1987AFieldsMap;
import br.com.codecompany.rysys.iso8583.driver.Iso8583Adapter;
import br.com.codecompany.rysys.iso8583.driver.MalformedMessageException;
import br.com.codecompany.rysys.iso8583.driver.PingSupport;
import br.com.codecompany.rysys.iso8583.sirot.protocol.SirotMessageDecoder;
import br.com.codecompany.rysys.iso8583.sirot.protocol.SirotPipelineFactory;
import br.com.codecompany.rysys.iso8583.util.Iso8583MessageUtils;

import com.solab.iso8583.IsoMessage;
import com.solab.iso8583.MessageFactory;
import com.solab.iso8583.parse.FieldParseInfo;

public class SirotAdapter extends Iso8583Adapter implements PingSupport {

	private static Logger log = LoggerFactory.getLogger(SirotAdapter.class);
	
	private Burst burst = new SirotBurst();
	
	public Burst getBurst() {
		return burst;
	}
	
	public int getHeaderSize() {
		return SirotHeader.HEADER_SIZE;
	}
	
	//public List<IsoMessage> sendAndReceive(ByteBuffer buffer) throws Exception {
	public List<IsoMessage> sendAndReceive(byte[] buffer) throws Exception {
		
		List<IsoMessage> receivedMessages = null;
	    
        if (connectFuture.isSuccess()) {        	
        	// Wrap the message in a channel buffer
        	ChannelBuffer buf = ChannelBuffers.copiedBuffer(buffer);
        	
            // Send the message
        	log.debug("Writing message to channel...");
            lastWriteFuture = channel.write(buf);
            log.debug("Done!");
            
            log.debug("Reading message from channel");
            SirotMessageDecoder decoder = (SirotMessageDecoder) channel.getPipeline().getLast();
            receivedMessages = decoder.getResponse();
            log.debug("Done!");
        }
        else {
        	log.error("Error retrieving channel", connectFuture.getCause());   	
        }
        
		return receivedMessages;
	}
	
	public IsoMessage createMessage(Map<Integer, String> fields) {		
		String bit0 = fields.get(0);
		if (bit0 == null) {
			throw new MalformedMessageException("Bit 0 has not been informed");
		}
		else {
			bit0 = StringUtils.leftPad(bit0, 4, "0");
		}
		log.debug("Creating message of type {}", bit0);
		
		SirotIsoMessage request = new SirotIsoMessage(bit0);
		for (Entry<Integer, String> entry : fields.entrySet()) {
			request.setValue(entry.getKey(), entry.getValue());
		}

		return request;
	}	
	
	// cria parserMap para todas as possiveis mensagens de retorno
	// isso é necessário pois o j8583 não permite especificar o mesmo
	// mapa de bits para todos os tipos de mensagem
	public void populateParserMap(MessageFactory factory) {
		
		// utiliza o mesmo mapa para todos os retornos possiveis
		HashMap<Integer, FieldParseInfo> parserMap = new Iso1987AFieldsMap().getParseMap();

		// Message Type Indicator structure:
		// 0xxx --> version of ISO 8583 (0 for 1987 version)
		// x?xx --> class of the Message
		// xx?x --> function of the Message
		// xxx? --> who began the communication (message origin)
		
		// message class (1 to 9)
		for (int i = 1; i <= 9; i++) {
			// message function (0 to 4, 8 to 9)
			for (int j = 0; j <= 9; j++) {
				if (j <= 4 || j >= 8) {
					// message origin (0 to 5)
					for (int k = 0; k <= 5; k++) {
						String stringType = "0" + String.valueOf(i) + 
							String.valueOf(j) + String.valueOf(k);
						int integerType = Iso8583MessageUtils.parseType(stringType);
						factory.setParseMap(integerType, parserMap);						
					}
				}
			}
		}
	}	

	public boolean isPing(IsoMessage msg) {
		return false;
	}
	
	public byte[] pingMessage() {
		return null;
	}
	
	@Override
	public void connect() throws ConnectionException {
		log.debug("Opening resources...");
        
		// Configure the client.
        bootstrap = new ClientBootstrap(
                new NioClientSocketChannelFactory(
                        Executors.newCachedThreadPool(),
                        Executors.newCachedThreadPool()));

        bootstrap.setPipelineFactory(new SirotPipelineFactory(this));
        
        bootstrap.setOption("tcpNoDelay", true);
        bootstrap.setOption("keepAlive", true);
        bootstrap.setOption("connectTimeoutMillis", getTimeout());
        
        // Make a new connection.
        connectFuture =
            bootstrap.connect(new InetSocketAddress(getHostname(),getPort()));
        
        // Wait until the connection is made successfully.
        channel = connectFuture.awaitUninterruptibly().getChannel();
        
        log.debug("Done!");
	}
	
	private ClientBootstrap bootstrap;
	private ChannelFuture connectFuture;
	private Channel channel;
	private ChannelFuture lastWriteFuture;
	
	@Override
	public void disconnect() {
		log.info("Closing resources...");
		
        // Wait until all messages are flushed before closing the channel.
        if (lastWriteFuture != null) {
            lastWriteFuture.awaitUninterruptibly();
        }
        if (connectFuture != null) {
        	connectFuture.awaitUninterruptibly();
        }    
        
        // Close the connection.  Make sure the close operation ends because
        // all I/O operations are asynchronous in Netty.
        if (channel != null) {
        	channel.close().awaitUninterruptibly();
        }
        
        // Shut down all thread pools to exit.
        bootstrap.releaseExternalResources();
        
        log.info("Done!");
	}
}
