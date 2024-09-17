package br.com.codecompany.rysys.fgl.function;

import br.com.codecompany.rysys.api.executor.Protocol;
import br.com.codecompany.rysys.api.function.AbstractParameterFuncion;
import br.com.codecompany.rysys.api.function.CommandType;
import br.com.codecompany.rysys.api.function.Parameter;
import br.com.codecompany.rysys.api.function.Types;
import br.com.codecompany.rysys.fgl.executor.FglProtocol;
import br.com.codecompany.rysys.fgl.util.FglMessageUtils;

public class FglFunction extends AbstractParameterFuncion {

	private int type;
	private String module;
	private Protocol protocol = new FglProtocol();

	public FglFunction(String name, Object... optionalParams) {
		super(name);

		if (optionalParams == null || optionalParams.length == 0
				|| "".equalsIgnoreCase(String.valueOf(optionalParams[0]))) {
			throw new RuntimeException("Module name is needed for "
					+ FglFunction.class.getSimpleName()
					+ ". Usage: FunctionFactory.getFunction(EisType.FGL, "
					+ "<function_name>, <module_name>");
		}

		this.module = String.valueOf(optionalParams[0]);
		this.type = CommandType.FUNCTION_CALL;
	}

	public int getType() {
		return type;
	}

	public String getModule() {
		return module;
	}

	public int objectToType(Object object) {
		return Types.objectToType(object, Types.FGL_TYPES);
	}

	// adiciona os parametros a partir de uma string
	// no formato tipo1;valor1;tipo2;valor2...
	public void setParameters(Object data) {
		Parameter[] params = FglMessageUtils.parseParameters(String.valueOf(data));
		for (Parameter parameter : params) {
			addParameter(parameter);
		}
	}

	public Protocol getProtocol() {
		return protocol;
	}
}
