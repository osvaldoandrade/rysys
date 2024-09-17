package br.com.codecompany.rysys.api.annotation;

public class OrderNotSpecifiedException extends RuntimeException {

	private static final long serialVersionUID = -6967423287462606799L;
	
	public OrderNotSpecifiedException(String message) {
		super(message);
	}

}
