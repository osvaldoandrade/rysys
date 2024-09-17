package br.com.codecompany.rysys.api.annotation.parser;

import static br.com.codecompany.rysys.api.annotation.AnnotationConstants.LENGTH;
import static br.com.codecompany.rysys.api.annotation.AnnotationConstants.MASK;
import static br.com.codecompany.rysys.api.annotation.AnnotationConstants.FORCE_ZERO_TO_NULL;

import java.lang.annotation.Annotation;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.codecompany.rysys.api.annotation.InvalidDateMaskException;
import br.com.codecompany.rysys.api.annotation.PopulatorContext;
import br.com.codecompany.rysys.api.util.AnnotationUtils;
import br.com.codecompany.rysys.util.FormatUtils;

public class DateFieldParser extends TextFieldParser {

	private static final Logger log = LoggerFactory.getLogger(TextFieldParser.class);

	@Override
	public Object parse(String stringToParse, Annotation annotation, PopulatorContext context) {
		Date result = null;
		
		String mask = AnnotationUtils.getStringValue(annotation, MASK);
		if ("".equals(mask.trim())) {
			throw new InvalidDateMaskException("Date mask can not be empty " +
					"in annotation " +	annotation);
		}
		
		String value = String.valueOf(super.parse(stringToParse, annotation, context));
		boolean force = AnnotationUtils.getBooleanValue(annotation, FORCE_ZERO_TO_NULL);
		
		long number = -1;
		try {
			number = Long.valueOf(value.trim());
		} catch (Exception e) {
			// invalid date
		}

		if (force && number == 0) {
			log.warn("Date forced to null: '{}'", value);
			result = null;
		}
		else {
			DateFormat dateFormat = new SimpleDateFormat(mask);
			try {
				result = (Date) dateFormat.parseObject(value);
			} catch (ParseException e) {
				log.error("Error parsing date '" + value +
						"' using mask '" + mask + "'", e);
			}
		} 

		return result;
	}

	@Override
	public String unparse(Object fieldValue, Annotation annotation, PopulatorContext context) {
		String mask = AnnotationUtils.getStringValue(annotation, MASK);
		if ("".equals(mask.trim())) {
			throw new InvalidDateMaskException("Date mask can not be empty " +
					"in annotation " +	annotation);
		}
		
		Date date = (Date) fieldValue;
		String formatted = "";

		if (date != null) {
			DateFormat dateFormat = new SimpleDateFormat(mask);
			formatted = dateFormat.format(date);
		}
		else if (context.isIgnoreNullFields()) {
			log.debug("Null Field ignored: '" + fieldValue + "'");
			return formatted;
		}
		
		int length = AnnotationUtils.getIntValue(annotation, LENGTH);

		// caso o atributo 'length' nao seja informado (<=0),
		// usa o tamanho do valor da propriedade
		if (length <= 0) {
			length = formatted.length();
			log.debug("Length attribute ignored. " +
					"Using property value's length ({})", length);
		}

		return FormatUtils.fillLeft(formatted, '0', length);
	}
}
