package br.com.codecompany.rysys.iso8583.driver;

public class InvalidHeaderException extends RuntimeException {

	private static final long serialVersionUID = -7167204550565042969L;
	
	public InvalidHeaderException(String message) {
		super(message);
	}	
}
