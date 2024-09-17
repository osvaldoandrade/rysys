package br.com.codecompany.rysys.iso8583.sirot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.codecompany.rysys.iso8583.driver.FieldsMap;
import br.com.codecompany.rysys.iso8583.driver.Iso1987AFieldsMap;
import br.com.codecompany.rysys.iso8583.driver.MalformedMessageException;
import br.com.codecompany.rysys.iso8583.util.Iso8583MessageUtils;

import com.solab.iso8583.IsoMessage;
import com.solab.iso8583.IsoType;
import com.solab.iso8583.IsoValue;

public class SirotIsoMessage extends IsoMessage {
	
	private static final int TRANSMISSION_CHANNEL_BIT = 33;
	
	private static Logger log = LoggerFactory.getLogger(SirotIsoMessage.class);
	
	private SirotHeader header = null;
	private FieldsMap fieldsMap = new Iso1987AFieldsMap();
	
	public SirotIsoMessage(String type) {
		this.setType(Iso8583MessageUtils.parseType(type));
	}
	
	public void setValue(int index, String value) {
		if (index >= 2 && index <= 128) {
			int length = 0;
			IsoType isoType = fieldsMap.getType(index);
			if (isoType.needsLength()) {
				length = fieldsMap.getLength(index);
			}
			super.setValue(index, value, isoType, length);
		}
		else if (index != 0) {
			log.info("Setting on field {} ignored. Field index must " +
					"follow the rule: 2<=index<=128", index);
		}
	}
	
	public byte[] writeInternal() {
		int transmissionChannel = -1;
		IsoValue<?> value = super.getField(TRANSMISSION_CHANNEL_BIT);
		if (value == null) {
			throw new MalformedMessageException("Transmission channel (bit " + 
					TRANSMISSION_CHANNEL_BIT +	") was not informed");
		}
		try {
			String bitValue = String.valueOf(value.getValue());
			transmissionChannel = Integer.parseInt(bitValue);
		} catch (NumberFormatException e) {
			throw new MalformedMessageException("Invalid transmission channel: " 
					+ transmissionChannel);
		}
		//ATTENTION! super.isoHeader must be null, always!!!!!!
		byte[] body = super.writeInternal();
		header = new SirotHeader(body.length, transmissionChannel);
		return Iso8583MessageUtils.concat(header.asByteArray(), body);
	}
	
	public SirotHeader getHeader() {
		return header;
	}
}
