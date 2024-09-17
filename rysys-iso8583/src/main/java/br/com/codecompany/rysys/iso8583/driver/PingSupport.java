package br.com.codecompany.rysys.iso8583.driver;

import com.solab.iso8583.IsoMessage;

public interface PingSupport {
	
	public boolean isPing(IsoMessage msg);
	
	public byte[] pingMessage();	
}
