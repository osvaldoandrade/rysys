package br.com.codecompany.rysys.api.annotation;

public class InvalidOrderException extends RuntimeException {

	private static final long serialVersionUID = 5990778627760051045L;

	public InvalidOrderException(String message) {
		super(message);
	}

}
