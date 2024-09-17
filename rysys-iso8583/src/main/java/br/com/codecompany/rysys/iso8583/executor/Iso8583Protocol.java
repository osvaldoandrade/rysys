package br.com.codecompany.rysys.iso8583.executor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import br.com.codecompany.rysys.api.executor.Protocol;
import br.com.codecompany.rysys.iso8583.function.Iso8583Function;

public class Iso8583Protocol implements Protocol<Iso8583Function, Iso8583ExecutionResult> {
	
	@SuppressWarnings("unchecked")
	public Iso8583ExecutionResult extractResult(Serializable response) {
		return new Iso8583ExecutionResult((List<Map<Integer, String>>) response);
	}

	public Serializable extractCommand(Iso8583Function function) {
		return (Serializable) function.getParametersAsMap();
	}
}
