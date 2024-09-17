package br.com.codecompany.rysys.api.executor;

public class NoResultException extends RuntimeException {

	private static final long serialVersionUID = 6626051457795055645L;

	public NoResultException(String message) {
		super(message);
	}

}
