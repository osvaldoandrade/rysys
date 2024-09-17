package br.com.codecompany.rysys.api.function;

import java.util.Map;

public interface IndexedParameterSupport extends Function {
	public Parameter addParameter(int index, Parameter parameter);
	public Parameter getParameter(int index);
	public Map<Integer, Parameter> getParametersMap();
}
