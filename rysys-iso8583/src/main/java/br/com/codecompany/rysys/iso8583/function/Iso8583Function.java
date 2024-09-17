package br.com.codecompany.rysys.iso8583.function;

import br.com.codecompany.rysys.api.executor.Protocol;
import br.com.codecompany.rysys.api.function.AbstractIndexedParameterFuncion;
import br.com.codecompany.rysys.api.function.Parameter;
import java.util.Map;

import br.com.codecompany.rysys.iso8583.executor.Iso8583Protocol;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class Iso8583Function extends AbstractIndexedParameterFuncion {

	private Protocol protocol = new Iso8583Protocol();

	public Iso8583Function(String name) {
		super(name);
		//return parameters.get(Iso8583Constants.PROCESSING_CODE).getName();
	}

	public Map<Integer, String> getParametersAsMap() {
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
		for (int i = 0; i < parameters.size(); i++) {
			Parameter parameter = parameters.get(i);
			map.put(i, String.valueOf(parameter.getValue()));
		}
		return map;
	}

	public Protocol getProtocol() {
		return protocol;
	}

	public void setParameters(Map<Integer, Object> values) {
		for (Entry<Integer, Object> entry : values.entrySet()) {
			addParameter(entry.getKey(), new Parameter(entry.getValue()));
		}
	}
}
