package br.com.codecompany.rysys.api.annotation;

public class NoPropertyAnnotatedException extends RuntimeException {

	private static final long serialVersionUID = -7814635733567658703L;

	public NoPropertyAnnotatedException(String message) {
		super(message);
	}
}
