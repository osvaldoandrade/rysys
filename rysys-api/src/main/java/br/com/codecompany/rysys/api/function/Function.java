package br.com.codecompany.rysys.api.function;

import br.com.codecompany.rysys.api.executor.ExecutionResult;
import br.com.codecompany.rysys.api.executor.Protocol;
import javax.resource.cci.Connection;

public interface Function {
	public String getName();
	public Protocol getProtocol();
	public ExecutionResult invoke(Connection connection);
}
