package br.com.codecompany.rysys.api.annotation;

import java.lang.annotation.Annotation;

// responsavel pelo preenchimento/recuperacao do valor do campo
// o FieldParser deve ser informado na anotacao correspondente
public interface FieldParser {
	public Object parse(String stringToParse, Annotation annotation, PopulatorContext context);
	public String unparse(Object fieldValue, Annotation annotation, PopulatorContext context);
}
