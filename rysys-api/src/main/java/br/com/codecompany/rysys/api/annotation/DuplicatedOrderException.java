package br.com.codecompany.rysys.api.annotation;

public class DuplicatedOrderException extends RuntimeException {

	private static final long serialVersionUID = 8852344959914603283L;

	public DuplicatedOrderException(String message) {
		super(message);
	}

}
