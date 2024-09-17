package br.com.codecompany.rysys.api.annotation;

public class InvalidLengthException extends RuntimeException {

	private static final long serialVersionUID = 5990778628360051058L;

	public InvalidLengthException(String message) {
		super(message);
	}
}
