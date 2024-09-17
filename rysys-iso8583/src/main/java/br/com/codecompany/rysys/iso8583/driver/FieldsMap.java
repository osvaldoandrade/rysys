package br.com.codecompany.rysys.iso8583.driver;

import java.util.HashMap;

import com.solab.iso8583.IsoType;
import com.solab.iso8583.parse.FieldParseInfo;

// configura os tipos dos campos da mensagem
public interface FieldsMap {
	public HashMap<Integer, FieldParseInfo> getParseMap();
	public IsoType getType(int index);
	public int getLength(int index);
}
