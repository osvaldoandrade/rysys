package br.com.codecompany.rysys.cobol.executor;

import br.com.codecompany.rysys.api.annotation.InvalidMessageFormatException;
import br.com.codecompany.rysys.api.executor.Protocol;
import br.com.codecompany.rysys.api.executor.xml.XmlProtocol;
import br.com.codecompany.rysys.api.function.EisType;
import java.io.Serializable;

import br.com.codecompany.rysys.api.function.ParameterSupport;
import br.com.codecompany.rysys.cobol.function.CobolFunction;

public class CobolProtocol extends XmlProtocol implements Protocol<CobolFunction, CobolExecutionResult> {

	public Serializable extractCommand(CobolFunction function) {
		return toXML(function);
	}

	public CobolExecutionResult extractResult(Serializable response) {
		return new CobolExecutionResult(response);
	}

	protected void checkParametersSize(int parametersSize) {
		if (parametersSize > 1) {
			throw new InvalidMessageFormatException(
				"Cobol functions must have zero or one " +
				"parameters (found " + parametersSize + ")");
		}
	}

	@Override
	protected int adapterType(ParameterSupport function) {
		return EisType.COBOL.intValue();
	}

	@Override
	protected int commandType(ParameterSupport function) {
		return ((CobolFunction) function).getCommandType();
	}

	@Override
	protected String libraryPath(ParameterSupport function) {
		return ((CobolFunction) function).getModuleName();
	}
}
