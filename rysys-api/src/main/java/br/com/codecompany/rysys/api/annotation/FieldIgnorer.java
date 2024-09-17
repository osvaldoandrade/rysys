package br.com.codecompany.rysys.api.annotation;

// campos anotados que serao ignorados no populate/extract
public interface FieldIgnorer {
	public String[] getFieldsToIgnore();
	public void setFieldsToIgnore(String... fieldsToIgnore);
}
