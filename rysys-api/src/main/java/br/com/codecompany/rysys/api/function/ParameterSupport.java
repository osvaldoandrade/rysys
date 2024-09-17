package br.com.codecompany.rysys.api.function;

import java.util.List;

public interface ParameterSupport extends Function {
	public void addParameter(Parameter parameter);
	public List<Parameter> getParameters();
}
