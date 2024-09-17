package br.com.codecompany.rysys.api.executor;

public class FunctionExecutionException extends RuntimeException {

	private static final long serialVersionUID = -2212553526129867988L;

	public FunctionExecutionException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
