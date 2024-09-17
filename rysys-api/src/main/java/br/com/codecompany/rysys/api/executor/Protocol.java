package br.com.codecompany.rysys.api.executor;

import java.io.Serializable;

import br.com.codecompany.rysys.api.function.Function;

public interface Protocol<F extends Function, R extends ExecutionResult> {
	public Serializable extractCommand(F function);
	public R extractResult(Serializable response);
}
