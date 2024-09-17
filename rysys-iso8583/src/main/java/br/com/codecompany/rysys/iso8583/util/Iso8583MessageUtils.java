package br.com.codecompany.rysys.iso8583.util;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.solab.iso8583.IsoMessage;

/**
 * <code>Coletânia de métodos estáticos de uso geral</code>.
 */
public final class Iso8583MessageUtils implements Serializable {

	private static final long serialVersionUID = 6803589092467328052L;
	
	private static final Logger log = LoggerFactory.getLogger(Iso8583MessageUtils.class);

	// descricao do mapa de bits
	public static Map<Integer,String> descriptionMap = 
		Collections.synchronizedMap(new HashMap<Integer,String>());
	
	static {
		descriptionMap.put(0, "MESSAGE CODE");
		descriptionMap.put(3, "PROCESSING CODE");
		descriptionMap.put(33, "TRANSMISSION CHANNEL");
		descriptionMap.put(39, "RETURN CODE");
//		descriptionMap.put(41, "TIMESTAMP");
		descriptionMap.put(62, "DATA RECEIVED");
		descriptionMap.put(63, "DATA SENT");
		descriptionMap.put(71, "BURST MODE");
		descriptionMap.put(72, "BURST CONTINUE/END");
//		descriptionMap.put(100, "RECEPTION CHANNEL");
		descriptionMap.put(120, "ERROR MESSAGE");		
	}
	
	// join two arrays
	public static final byte[] concat(byte[] a, byte[] b) {
		final int alen = a.length;
		final int blen = b.length;

		if (alen == 0) {
			return b;
		}
		if (blen == 0) {
			return a;
		}

		final byte[] result = (byte[]) Array.newInstance(a.getClass()
				.getComponentType(), alen + blen);
		System.arraycopy(a, 0, result, 0, alen);
		System.arraycopy(b, 0, result, alen, blen);

		return result;
	}
	
	public static final boolean isPrintable(char c) {
		return (c >= 32);
	}
	
	/** Parses a message type expressed as a hex string and returns the integer number.
	 * For example, "0200" or "200" return the number 512 (0x200) */
	public static int parseType(String type) {
		if (type.length() % 2 == 1) {
			type = "0" + type;
		}
		if (type.length() != 4) {
			return -1;
		}
		
		return ((type.charAt(0) - 48) << 12) | ((type.charAt(1) - 48) << 8)
			| ((type.charAt(2) - 48) << 4) | (type.charAt(3) - 48);
	}
	
	// highlight extracted part of array
	public static final void traceExtraction(byte[] bytes, int beginIndex, int endIndex) {
		StringBuilder indexes = new StringBuilder();
		StringBuilder values = new StringBuilder();
		StringBuilder marks = new StringBuilder();

		for (int i = 0; i < bytes.length; i++) {
			indexes.append("[");
			indexes.append(StringUtils.leftPad("" + i, 4, "0"));
			indexes.append("]");

			values.append("[");
			char c = (char) bytes[i];
			String value = isPrintable(c) ? c + "" : "?";
			values.append(StringUtils.leftPad(value, 4, " "));
			values.append("]");

			// print selection mark
			if (beginIndex > -1 && endIndex > -1) {
				if (i == beginIndex) {
					marks.append("|<----");
				} else if (i == endIndex - 1) {
					marks.append("---->|");
				} else if (i > beginIndex && i < endIndex - 1) {
					marks.append("------");
				} else if (i < beginIndex) {
					marks.append("      ");
				}
			}
		}

		log.trace(indexes.toString());
		log.trace(values.toString());
		log.trace(marks.toString());
	}	
	
	public static final Map<Integer, String> createMap(IsoMessage isoMessage) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		for (int i = 0; i <= 128; i++) {
			if (isoMessage.hasField(i)) {
				String value = String.valueOf(isoMessage.getObjectValue(i));
				map.put(i, value);
			}
		}
		return map;
	}		
}

