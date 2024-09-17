package br.com.codecompany.rysys.api.function;

public class InvalidFunctionNameException extends RuntimeException {

	private static final long serialVersionUID = 1494409336360884L;

	public InvalidFunctionNameException(String message) {
		super(message);
	}
}
