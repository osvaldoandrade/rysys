package br.com.codecompany.rysys.api.executor;

public class ProtocolException extends RuntimeException {

	public ProtocolException(String message) {
		super(message);
	}

	public ProtocolException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
