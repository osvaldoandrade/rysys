package br.com.codecompany.rysys.core.driver;

public class TimeoutException extends RuntimeException {

	private static final long serialVersionUID = 1031275738952945570L;

	public TimeoutException(String message) {
		super(message);
	}
}
