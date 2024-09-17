package br.com.codecompany.rysys.api.annotation;

import br.com.codecompany.rysys.api.executor.ExecutionResult;
import java.util.List;
import java.util.Map;

// usada para preencher os objetos de request/response
public class PopulatorHelper implements FieldIgnorer {
	
	private RequestPopulator requestPopulator;
	private ResponsePopulator responsePopulator;
	
	public PopulatorHelper(RequestPopulator requestPopulator, ResponsePopulator responsePopulator) {
		this.requestPopulator = requestPopulator;
		this.responsePopulator = responsePopulator;
	}

	public Object populateFields(Object objectToFill, ExecutionResult result) {
		responsePopulator.populate(objectToFill, result);
		return objectToFill;
	}

	public Object populateFields(Object objectToFill, String stringToParse) {
		responsePopulator.populate(objectToFill, stringToParse);
		return objectToFill;
	}	
	
	public List<Object> extractFieldsAsList(Object objectToExtract) {
		return requestPopulator.extractFieldsAsList(objectToExtract);
	}
	
	public Map<String,String> extractFieldsAsMap(Object objectToExtract) {
		return requestPopulator.extractFieldsAsMap(objectToExtract);
	}

	public String extractFieldsAsString(Object objectToExtract) {
		return requestPopulator.extractFieldsAsString(objectToExtract);
	}

	public String[] getFieldsToIgnore() {
		return requestPopulator.getFieldsToIgnore();
	}

	public void setFieldsToIgnore(String... fieldsToIgnore) {
		requestPopulator.setFieldsToIgnore(fieldsToIgnore);
		responsePopulator.setFieldsToIgnore(fieldsToIgnore);
	}

	public boolean isIgnoreNullFields() {
		return requestPopulator.isIgnoreNullFields();
	}

	public void setIgnoreNullFields(boolean ignoreNullFields) {
		requestPopulator.setIgnoreNullFields(ignoreNullFields);
		responsePopulator.setIgnoreNullFields(ignoreNullFields);
	}

	public boolean isAutoCalculateBeginIndex() {
		return responsePopulator.isAutoCalculateBeginIndex();
	}

	public void setAutoCalculateBeginIndex(boolean autoCalculateBeginIndex) {
		requestPopulator.setAutoCalculateBeginIndex(autoCalculateBeginIndex);
		responsePopulator.setAutoCalculateBeginIndex(autoCalculateBeginIndex);
	}
}