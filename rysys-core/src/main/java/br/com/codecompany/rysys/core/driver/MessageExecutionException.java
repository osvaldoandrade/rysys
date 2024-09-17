package br.com.codecompany.rysys.core.driver;

public class MessageExecutionException extends RuntimeException {

	private static final long serialVersionUID = -439081816857525707L;

	public MessageExecutionException(String message) {
		super(message);
	}

	public MessageExecutionException(Throwable cause) {
		super(cause);
	}
}
