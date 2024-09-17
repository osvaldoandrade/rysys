package br.com.codecompany.rysys.api.annotation;

import br.com.codecompany.rysys.api.function.Parameter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.codecompany.rysys.api.util.AnnotationUtils;
import br.com.codecompany.rysys.util.ToStringUtils;

public abstract class RequestPopulator extends Populator {

    private static final Logger log = LoggerFactory.getLogger(RequestPopulator.class);

    // field's names and values
    private LinkedHashMap<String, String> fieldsMap = new LinkedHashMap<String, String>();

    public Map<String, String> extractFieldsAsMap(Object objectToExtract) {
        extractFieldsAsString(objectToExtract);
        return Collections.unmodifiableMap(fieldsMap);
    }

    public RequestPopulator(ParserInfo info) {
        super(info);
    }

    // retorna o valor do campo de acordo com as anotações presentes
    private String extractValue(Object objectToExtract, Field field) {
        String value = "";

        try {
            value = unparse(objectToExtract, field);
        } catch (Exception e) {
            log.error("Could not extract value from field '" +
                    objectToExtract.getClass().getSimpleName() + "." +
                    field.getName() + "'", e);
        }

        return value;
    }

    // percorre todos os campos e transforma em string de acordo com a ordem
    // e FieldParser configurados
    public String extractFieldsAsString(Object objectToExtract) {
        if (context.isIgnoreNullFields()) {
            log.warn("Property ignoreNullFields=true. " +
                    "Resulting string can be misplaced");
        }

        prepare(objectToExtract);
        String result = "";
		StringBuffer buffer = new StringBuffer();

        fieldsMap = new LinkedHashMap<String, String>();

        // percorre todos os campos e extrai o valor string, concatenando
        List<Field> fields = new ArrayList<Field>(outFieldsMap.keySet());
        for (int i = 0; i < fields.size(); i++) {
            Field field = fields.get(i);
            String value = extractValue(objectToExtract, field);
            buffer.append(value);
            if (i < fields.size() - 1) {
                buffer.append(separatorToken());
            }
            fieldsMap.put(field.getName(), value);
        }

        result = buffer.toString();

        if (log.isDebugEnabled()) {
            log.debug("Fields parsed: " + ToStringUtils.toString(fieldsMap));
            log.debug("Fields as single string:\n[" + result + "]");
        }

        return wrapData(result);
    }

	private void prepare(Object objectToExtract) throws ClassNotAnnotatedException {
		Class<? extends Annotation> annotation = annotationToCheck();
		if (!AnnotationUtils.isAnnotated(objectToExtract.getClass(), annotation)) {
			throw new ClassNotAnnotatedException("Class '" + objectToExtract.getClass().getSimpleName() + "' does not contain @" + annotation.getSimpleName() + " annotation");
		}
		prepareFields(objectToExtract);
	}

    // retorna uma lista contendo os valores dos campos anotados de
	// acordo com a ordem configurada
	public List<Object> extractFieldsAsList(Object objectToExtract) {
		List<Object> parameters = new ArrayList<Object>();
		prepare(objectToExtract);
		// percorre todos os campos e extrai o valor
        List<Field> fields = new ArrayList<Field>(outFieldsMap.keySet());
        for (Field field : fields) {
			try {
				field.setAccessible(true);
				Object object = field.get(objectToExtract);
				parameters.add(object);
			} catch (Exception e) {
			log.error("Could not extract value from field '" +
					objectToExtract.getClass().getSimpleName() +
					"." + field.getName() + "'", e);
			}
		}
		return parameters;
	}
	
    // retorna o token utilizado para separar os parametros
    protected abstract String separatorToken();

    // adiciona cabecalho ao resultado, se necessario
    protected abstract String wrapData(String result);

    protected String unparse(Object objectToExtract, Field sourceField) {
        String result = "";
        // verifica se existe parser cadastrado para esse campo
        FieldParser parser = createParser(sourceField, outFieldsMap);
        if (parser != null) {
            // permite acesso ao populator de dentro do parser.
            // util para campos do tipo Collection, Array, etc.
            if (parser instanceof RequestPopulatorSupport) {
				try {
					// cria um novo RequestPopulator para o parser, preservando
					// a instancia atual de RequestPopulator
					RequestPopulator populator = this.getClass().newInstance();
					((RequestPopulatorSupport) parser).setRequestPopulator(populator);
				}
				catch(Exception e) {
					throw new RuntimeException("Error creating populator for " +
							parser.getClass().getName(), e);
				}
            }
            try {
                sourceField.setAccessible(true);
                Object value = sourceField.get(objectToExtract);
				result = parser.unparse(value, outFieldsMap.get(sourceField), context);
				log.debug("Extracting value from field '" + objectToExtract.getClass().getSimpleName() +
						"." + sourceField.getName() + "' [" + value + "] --> [" + result + "]");
            } catch (Exception e) {
                log.error("Could not retrieve value from field " + objectToExtract.getClass().getSimpleName() +
                        "." + sourceField.getName() + "'", e);
            }
        }
        return result;
    }
}
