package br.com.codecompany.rysys.api.annotation;

public class InvalidDateMaskException extends RuntimeException {

	private static final long serialVersionUID = 5023879985956187249L;
	
	public InvalidDateMaskException(String message) {
		super(message);
	}

}
