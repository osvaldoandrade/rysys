package br.com.codecompany.rysys.core.driver;

/**
 *
 * @author osvaldo
 */
public class InvalidDriverException extends RuntimeException {

	private static final long serialVersionUID = -5552841548266922578L;
	
	public InvalidDriverException(String message) {
		super(message);
	}

}