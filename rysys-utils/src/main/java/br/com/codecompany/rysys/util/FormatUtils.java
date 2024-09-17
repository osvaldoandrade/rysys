package br.com.codecompany.rysys.util;

import org.apache.commons.lang.StringUtils;

public class FormatUtils {
	
	/**
	 * <b>This method returns a specified portion of a string. The range is
	 * specified by a initial position and a length. </b>
	 * 
	 * <pre>
	 * 
	 * Example:  substring( &quot;0123456789abcdef&quot;, 2, 4 ) = 2345
	 * </pre>
	 * 
	 * See also java.lang.String.substring()
	 * 
	 * @param String
	 *            sSource - source string
	 * @param int iPosition - initial position (zero based)
	 * @param int length - length of the substring
	 * @return String - portion of the source string
	 */
	public static final String substring(String text, int position,
			int length) {
		if (text == null || position >= text.length()) {
			return "";
		}

		String result = StringUtils.substring(text, position, position
				+ length);
		if (result.length() < length) {
			result = result
					+ StringUtils.repeat(" ", length - result.length());
		}
		return result;
	}
	
	/**
	 * Preenche à direita do String com o caractere/tamanho passado como
	 * parâmetro.
	 */
	public static final String fillRight(Object value, char cFillValue,
			int iLength) {
		if (value == null) {
			return null;
		} else {
			String sValue = String.valueOf(value);
			if (sValue.length() >= iLength) {
				return sValue.substring(0, iLength);
			} else {
				return StringUtils.rightPad(sValue, iLength, cFillValue);
			}
		}
	}
	
	/**
	 * Preenche à esquerda do String com o caractere/tamanho passado como
	 * parâmetro.
	 */
	public static final String fillLeft(Object value, char cFillValue,
			int iLength) {
		if (value == null) {
			return null;
		} else {
			String sValue = String.valueOf(value);
			if (sValue.length() >= iLength) {
				return sValue.substring(0, iLength);
			} else {
				return StringUtils.leftPad(sValue, iLength, cFillValue);
			}
		}
	}

	public static final String fillLeft(Object value, int iLength) {
		return fillLeft(value, '0', iLength);
	}
}
