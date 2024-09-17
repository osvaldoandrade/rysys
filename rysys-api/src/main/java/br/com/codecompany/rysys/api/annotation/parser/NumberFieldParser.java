package br.com.codecompany.rysys.api.annotation.parser;

import static br.com.codecompany.rysys.api.annotation.AnnotationConstants.FILLER;
import static br.com.codecompany.rysys.api.annotation.AnnotationConstants.LENGTH;
import static br.com.codecompany.rysys.api.annotation.AnnotationConstants.PRECISION;

import java.lang.annotation.Annotation;

import br.com.codecompany.rysys.api.annotation.InvalidPrecisionException;
import br.com.codecompany.rysys.api.annotation.PopulatorContext;
import br.com.codecompany.rysys.api.util.AnnotationUtils;

public abstract class NumberFieldParser extends TextFieldParser {

	@Override
	public Object parse(String stringToParse, Annotation annotation, PopulatorContext context) {
		String value = String.valueOf(super.parse(stringToParse, annotation, context));
		int precision = precision(annotation);
		
		return formatNumber(value, precision);
	}

	@Override
	public String unparse(Object fieldValue, Annotation annotation, PopulatorContext context) {
		int length = AnnotationUtils.getIntValue(annotation, LENGTH);
		char filler = AnnotationUtils.getCharValue(annotation, FILLER);
		int precision = precision(annotation);

		if (fieldValue != null) {
			return formatNumber(fieldValue, length, precision, filler);
		}
		else {
			if (context.isIgnoreNullFields()) {
				return "";
			} else {
				return formatNumber("", length, precision, filler);
			}
		}
	}
	
	protected int precision(Annotation annotation) {
		int precision = 0;
		if (AnnotationUtils.exists(annotation, PRECISION)) {
			precision = AnnotationUtils.getIntValue(annotation, PRECISION);
			if (precision < 0) {
				throw new InvalidPrecisionException("Value of attribute '" +
						PRECISION + "' can not be negative in annotation " + annotation);
			}
		}
		return precision;
	}
    
	protected abstract Number formatNumber(String numberAsString, int precision);
	
    protected abstract String formatNumber(Object value, int length, int precision, char filler);	
}
