package br.com.codecompany.rysys.api.annotation.parser;

import br.com.codecompany.rysys.api.annotation.FieldParser;
import static br.com.codecompany.rysys.api.annotation.AnnotationConstants.BEGIN_INDEX;
import static br.com.codecompany.rysys.api.annotation.AnnotationConstants.FILLER;
import static br.com.codecompany.rysys.api.annotation.AnnotationConstants.LENGTH;
import static br.com.codecompany.rysys.api.annotation.AnnotationConstants.TRIM;

import java.lang.annotation.Annotation;

import br.com.codecompany.rysys.api.annotation.PopulatorContext;
import br.com.codecompany.rysys.api.util.AnnotationUtils;
import br.com.codecompany.rysys.util.FormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TextFieldParser implements FieldParser {

	private static Logger log = LoggerFactory.getLogger(TextFieldParser.class);

	@Override
	public Object parse(String stringToParse, Annotation annotation, PopulatorContext context) {
		int start = AnnotationUtils.getIntValue(annotation, BEGIN_INDEX);

		// o inicio do parsing sera feito em funcao do ultimo campo processado
		if (context.isAutoCalculateBeginIndex()) {
			start = context.getNextBeginIndex();
			log.debug("Using a calculated beginIndex: {}", start);
		}

		int length = AnnotationUtils.getIntValue(annotation, LENGTH);

		// caso o atributo 'length' nao seja informado (<=0),
		// usa o tamanho do valor da propriedade
		if (length <= 0) {
			length = stringToParse.length();
			log.debug("Length attribute ignored. " +
					"Using property value's length ({})", length);
		}

		String value = FormatUtils.substring(stringToParse, start, length);

        // exibe a extracao (debug)
        debugExtration(log, stringToParse, value, start, length);

		// calcula o proximo indice inicial
		context.read(start, length);

		if (AnnotationUtils.exists(annotation, TRIM)) {
			if (AnnotationUtils.getBooleanValue(annotation, TRIM)) {
				value = value.trim();
			}
		}
		
		return value;
	}

	@Override
	public String unparse(Object fieldValue, Annotation annotation, PopulatorContext context) {
		int length = AnnotationUtils.getIntValue(annotation, LENGTH);
		char filler = AnnotationUtils.getCharValue(annotation, FILLER);

		if (fieldValue != null) {
			return FormatUtils.fillRight(fieldValue, filler, length);
		}
		else {
			if (context.isIgnoreNullFields()) {
				return "";
			} else {
				return FormatUtils.fillRight("", filler, length);
			}
		}
	}

    public static final void debugExtration(Logger log, String stringToParse,
            String elementAsString, int elementStart, int length) {
        if (log.isDebugEnabled()) {
            String message = "Extracting substring (start=" +
                    elementStart + ", length=" + length + "): " +
                    stringToParse.substring(0,elementStart) + "[" +
                    elementAsString + "]";
            if ((elementStart + length) < stringToParse.length()) {
                message += stringToParse.substring(elementStart + length);
            }
            log.debug(message);
        }
    }
}
