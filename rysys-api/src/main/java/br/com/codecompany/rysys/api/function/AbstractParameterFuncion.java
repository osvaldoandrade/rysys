package br.com.codecompany.rysys.api.function;

import br.com.codecompany.rysys.api.annotation.GenericRequestPopulator;
import br.com.codecompany.rysys.api.annotation.GenericResponsePopulator;
import br.com.codecompany.rysys.api.annotation.PopulatorHelper;
import br.com.codecompany.rysys.api.executor.ExecutionResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.resource.cci.Connection;

public abstract class AbstractParameterFuncion extends AbstractFunction implements ParameterSupport {

	protected List<Parameter> parameters = new ArrayList<Parameter>();

	public AbstractParameterFuncion(String name, Object... optionalParams) {
		super(name, optionalParams);
	}

	public void addParameterValue(Object value) {
		parameters.add(new Parameter(value));
	}

	public void addParameter(Parameter parameter) {
		parameters.add(parameter);
	}

	public List<Parameter> getParameters() {
		return Collections.unmodifiableList(parameters);
	}

	public Object invoke(Connection connection, Object annotatedParameter,
			ParserConfig config) {

		GenericRequestPopulator reqPopulator = new GenericRequestPopulator();
		GenericResponsePopulator resPopulator = new GenericResponsePopulator();
		PopulatorHelper helper = new PopulatorHelper(reqPopulator, resPopulator);
		helper.setIgnoreNullFields(config.isIgnoreNullFields());
		helper.setAutoCalculateBeginIndex(config.isAutoCalculateBeginIndex());
		helper.setFieldsToIgnore(config.getFieldsToIgnore());
		String fieldsAsString = helper.extractFieldsAsString(annotatedParameter);
		setParameters(fieldsAsString);

		ExecutionResult executionResult = super.invoke(connection);
		String result = (String) executionResult.getResultAt(0);
		return helper.populateFields(annotatedParameter, result);
	}

	public Object invoke(Connection connection, Object annotatedParameter) {
		return invoke(connection, annotatedParameter, ParserConfig.DEFAULT_CONFIG);
	}

	public abstract void setParameters(Object parameters);
}
