package br.com.codecompany.rysys.iso8583.driver;

public class MalformedMessageException extends RuntimeException {

	private static final long serialVersionUID = -7814635733944658780L;

	public MalformedMessageException(String message) {
		super(message);
	}
}
