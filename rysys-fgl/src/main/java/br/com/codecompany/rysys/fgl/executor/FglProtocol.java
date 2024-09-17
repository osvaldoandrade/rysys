package br.com.codecompany.rysys.fgl.executor;

import static br.com.codecompany.rysys.util.Constants.PARAMETER_SEPARATOR;

import java.io.Serializable;
import java.util.List;

import br.com.codecompany.rysys.api.executor.Protocol;
import br.com.codecompany.rysys.api.function.Parameter;
import br.com.codecompany.rysys.fgl.function.FglFunction;

public class FglProtocol implements Protocol<FglFunction, FglExecutionResult> {

	public Serializable extractCommand(FglFunction function) {
		StringBuffer result = new StringBuffer();
		result.append(function.getType()).append(PARAMETER_SEPARATOR);
		result.append(function.getModule()).append(PARAMETER_SEPARATOR);
		result.append(function.getName()).append(PARAMETER_SEPARATOR);

		int parametersSize = function.getParameters().size();

		result.append(String.valueOf(parametersSize)).append(
				PARAMETER_SEPARATOR);
		
		if (parametersSize > 0) {
			List<Parameter> lstParameters = function.getParameters();
			int i = 0;
			for (i = 0; i < lstParameters.size() - 1; i++) {
				Parameter param = lstParameters.get(i);
				result.append(param.getType()).append(PARAMETER_SEPARATOR);
				result.append(param.getValue()).append(PARAMETER_SEPARATOR);
			}

			Parameter param = lstParameters.get(i);
			result.append(param.getType()).append(PARAMETER_SEPARATOR);
			result.append(param.getValue());
		}

		return result.toString();
	}

	public FglExecutionResult extractResult(Serializable response) {
		return new FglExecutionResult(response);
	}
}
