package br.com.codecompany.rysys.api.annotation;

public class InvalidPrecisionException extends RuntimeException {

	private static final long serialVersionUID = -4637262465808171081L;
	
	public InvalidPrecisionException(String message) {
		super(message);
	}
}
