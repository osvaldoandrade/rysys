package br.com.codecompany.rysys.api.function;

public class InvalidFunctionTypeException extends RuntimeException {

	private static final long serialVersionUID = -4513734969677672712L;

	public InvalidFunctionTypeException(String message) {
		super(message);
	}
}
