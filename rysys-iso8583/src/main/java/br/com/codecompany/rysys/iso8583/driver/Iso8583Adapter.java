package br.com.codecompany.rysys.iso8583.driver;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.codecompany.rysys.core.driver.AbstractConnectionDriver;
import br.com.codecompany.rysys.core.driver.ConnectionException;
import br.com.codecompany.rysys.iso8583.util.Iso8583MessageUtils;

import com.solab.iso8583.IsoMessage;
import com.solab.iso8583.MessageFactory;

public abstract class Iso8583Adapter extends AbstractConnectionDriver {

	// FIXME deve vir por parametro?
	public static final int MAX_MESSAGE_SIZE = 2048;

	private static final int J8583_HEADER_SIZE = 0;

	private static Logger log = LoggerFactory.getLogger(Iso8583Adapter.class);
	
	private final MessageFactory factory = new MessageFactory();

	public abstract void populateParserMap(MessageFactory factory);
	
	public abstract Burst getBurst();
	
	public abstract int getHeaderSize();
	
	public abstract IsoMessage createMessage(Map<Integer, String> fields);
	
	//public abstract List<IsoMessage> sendAndReceive(ByteBuffer buffer) throws Exception;
	public abstract List<IsoMessage> sendAndReceive(byte[] buffer) throws Exception;
	
	public Iso8583Adapter() {
		populateParserMap(factory);
	}
	
	private List<IsoMessage> sendAndReceive(Map<Integer,String> fields) throws Exception {
		IsoMessage request = createMessage(fields);		
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		request.write(stream, J8583_HEADER_SIZE);
		byte[] bytes = stream.toByteArray();
		return sendAndReceive(bytes);		
	}

	// no transaction support
	public String getBeginTransactionCommand() {
		return null;
	}

	// no transaction support	
	public String getCommitCommand() {
		return null;
	}

	// no transaction support	
	public String getRollbackCommand() {
		return null;
	}

	public void connect() throws ConnectionException {

	}

	public void disconnect() {

	}

	@SuppressWarnings("unchecked")
	public Serializable execute(Serializable command)
			throws ConnectionException {
		
		if (!(command instanceof Map)) {
			throw new IllegalArgumentException("Invalid command syntax. " +
					"Please provide a Map<Integer,String>");
		}
		
		Map<Integer,String> fields = (Map<Integer, String>) command;
		List<Map<Integer, String>> list = new ArrayList<Map<Integer, String>>();
		try {
			List<IsoMessage> messages = sendAndReceive(fields);
			for (IsoMessage isoMessage : messages) {
				Map<Integer, String> map = Iso8583MessageUtils.createMap(isoMessage);
				if (!map.isEmpty()) {
					list.add(map);
				}
				else {
					log.warn("Message {} produced a empty map", isoMessage);
				}
			}
		} catch (Exception e) {
			throw new ConnectionException(e);
		}
		
		return (Serializable) list;
	}

	public IsoMessage parseMessage(byte[] bytes, int headerSize) throws ParseException {
		return factory.parseMessage(bytes, headerSize);
	}
}