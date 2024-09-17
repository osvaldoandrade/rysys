package br.com.codecompany.rysys.iso8583.sirot;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.codecompany.rysys.iso8583.driver.Burst;
import br.com.codecompany.rysys.iso8583.driver.MalformedMessageException;

import com.solab.iso8583.IsoMessage;
import com.solab.iso8583.IsoValue;

public class SirotBurst implements Burst {

	private static Logger log = LoggerFactory.getLogger(SirotBurst.class);
	
	public List<IsoMessage> sort(List<IsoMessage> messages) {
		return messages;
	}
	
	public boolean isFinished(List<IsoMessage> list) {
		boolean lastMsgReceived = false;
		
		for (int i = 0; i < list.size(); i++) {
			IsoMessage message = list.get(i);
			if (done(message.getField(71), message.getField(72), list.size())) {
				lastMsgReceived = true;
				if (i != list.size() - 1) {
					log.info("This message was supossed to be the last one in the list " +
							"of received messages. Please check if it's ok: {}", message);
				}
			}
		}
		
		return lastMsgReceived;
	}

	private boolean done(IsoValue<?> bit71, IsoValue<?> bit72, int totalMessages) {
		boolean done = false;
		
		int int71 = -1;
		int int72 = -1;
		String string71 = String.valueOf(bit71.getValue());
		String string72 = String.valueOf(bit72.getValue());
		
		try {
			int71 = Integer.parseInt(string71);			
		} catch (NumberFormatException e) {
			throw new MalformedMessageException("Could not convert value of bit 71 (" + 
					string71 + ") to string");
		}
		
		try {
			int72 = Integer.parseInt(string72);			
		} catch (NumberFormatException e) {
			throw new MalformedMessageException("Could not convert value of bit 72 (" + 
					string72 + ") to string");
		}		

		// opcao 1: sem rajada (bit 71 = 0 e bit 72 = 0)
		if (int71 == 0 && int72 == 0) {
			done = true;
			log.debug("Processing done, no burst");
		}
		
		// opcao 2: com rajada 9999 (finalizado)
		else if (int72 == 9999) {
			done = true;
			log.debug("Processing done, end of burst found: {}", int72);
		}
		// opcao 2: com rajada 9999 (nao finalizado)
		else if (int72 == 0) {
			done = false;
		}
		
		// opcao 3: com bit 72 indicando total de mensagens
		else if (int72 >= 0) {
			done = (int72 == totalMessages-1);
			if (done) {
				log.debug("Processing done, end of burst found: {}", int72);
			}
		}
		
		return done; 
	}
}
