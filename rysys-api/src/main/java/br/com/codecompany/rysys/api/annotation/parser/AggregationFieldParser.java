package br.com.codecompany.rysys.api.annotation.parser;

import br.com.codecompany.rysys.api.annotation.FieldParser;
import br.com.codecompany.rysys.api.annotation.PopulatorContext;
import br.com.codecompany.rysys.api.annotation.RequestPopulator;
import br.com.codecompany.rysys.api.annotation.RequestPopulatorSupport;
import br.com.codecompany.rysys.api.annotation.ResponsePopulator;
import br.com.codecompany.rysys.api.annotation.ResponsePopulatorSupport;
import br.com.codecompany.rysys.api.util.AnnotationUtils;
import java.lang.annotation.Annotation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static br.com.codecompany.rysys.api.annotation.AnnotationConstants.BEGIN_INDEX;
import static br.com.codecompany.rysys.api.annotation.AnnotationConstants.TYPE;

public class AggregationFieldParser implements RequestPopulatorSupport,
	ResponsePopulatorSupport, FieldParser {

    private static Logger log = LoggerFactory.getLogger(AggregationFieldParser.class);

	private RequestPopulator requestPopulator;
	private ResponsePopulator responsePopulator;
	
	public void setRequestPopulator(RequestPopulator requestPopulator) {
		this.requestPopulator = requestPopulator;
	}

	public void setResponsePopulator(ResponsePopulator responsePopulator) {
		this.responsePopulator = responsePopulator;
	}
    
    public Object parse(String stringToParse, Annotation annotation, PopulatorContext context) {

        String objectAsString = stringToParse;
        int start = AnnotationUtils.getIntValue(annotation, BEGIN_INDEX);
		// o inicio do parsing sera feito em funcao do ultimo campo processado
		if (context.isAutoCalculateBeginIndex()) {
			start = context.getNextBeginIndex();
			log.warn("Using a calculated beginIndex: {}", start);
		}
        else {
            objectAsString = stringToParse.substring(start-1);
        }

        // classe do objeto
        Class<?> type = AnnotationUtils.getClassValue(annotation, TYPE);
        log.debug("Creating instance of type {}", type.getName());

        Object object = null;
        try {
            object = type.newInstance();
            responsePopulator.setContext(context);
            // o contexto do parser atual sera compartilhado com o
            // do parser de objeto da agregacao
            responsePopulator.populate(object, objectAsString);
        } catch (Exception e) {
            log.error("Cold not create element. Check if class " +
                    type.getSimpleName() + " has a default constructor", e);
        }

        return object;
    }

    public String unparse(Object fieldValue, Annotation annotation, PopulatorContext context) {
        return requestPopulator.extractFieldsAsString(fieldValue);
    }
}
