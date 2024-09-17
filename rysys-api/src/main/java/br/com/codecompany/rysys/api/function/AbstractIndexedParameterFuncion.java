package br.com.codecompany.rysys.api.function;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractIndexedParameterFuncion extends AbstractFunction implements IndexedParameterSupport {

	protected Map<Integer, Parameter> parameters = new HashMap<Integer, Parameter>();

	public AbstractIndexedParameterFuncion(String name, Object... optionalParams) {
		super(name, optionalParams);
	}

	public Parameter addParameter(int index, Parameter parameter) {
		return parameters.put(index, parameter);
	}

	public Parameter getParameter(int index) {
		return parameters.get(index);
	}

	public Map<Integer, Parameter> getParametersMap() {
		return Collections.unmodifiableMap(parameters);
	}

	public abstract void setParameters(Map<Integer, Object> values);
}
