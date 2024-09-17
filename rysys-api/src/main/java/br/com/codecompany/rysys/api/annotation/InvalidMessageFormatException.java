package br.com.codecompany.rysys.api.annotation;

public class InvalidMessageFormatException extends RuntimeException {

	private static final long serialVersionUID = 1528893474133736710L;

	public InvalidMessageFormatException(String message) {
		super(message);
	}

}
