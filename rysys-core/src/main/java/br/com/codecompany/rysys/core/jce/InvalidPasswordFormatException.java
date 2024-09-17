package br.com.codecompany.rysys.core.jce;

public class InvalidPasswordFormatException extends RuntimeException {

	private static final long serialVersionUID = -2384842662052486611L;

	public InvalidPasswordFormatException(String message) {
		super(message);
	}

}
