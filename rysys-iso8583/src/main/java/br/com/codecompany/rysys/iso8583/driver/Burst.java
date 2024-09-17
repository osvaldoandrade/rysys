package br.com.codecompany.rysys.iso8583.driver;

import java.util.List;

import com.solab.iso8583.IsoMessage;

public interface Burst {
	// em modo rajada, verifica se ainda existem pacotes
	public boolean isFinished(List<IsoMessage> list);
	
	// used for sort messages received in burst mode
	public List<IsoMessage> sort(List<IsoMessage> messages);
}
