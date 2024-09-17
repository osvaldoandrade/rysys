package br.com.codecompany.rysys.api.annotation;

public class ClassNotAnnotatedException extends RuntimeException {
	
	private static final long serialVersionUID = -4514635777567658891L;
	
	public ClassNotAnnotatedException(String message) {
		super(message);
	}
}
