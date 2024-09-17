package br.com.codecompany.rysys.core.driver;

public class ConnectionException extends Exception {

	private static final long serialVersionUID = 7973508994440812825L;

	public ConnectionException(Exception e) {
		super(e);
	}

	public ConnectionException(String message, Exception e) {
		super(message, e);
	}

	public ConnectionException(String message) {
		super(message);
	}

}
