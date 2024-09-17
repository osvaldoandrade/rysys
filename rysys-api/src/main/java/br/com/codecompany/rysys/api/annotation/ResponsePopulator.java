package br.com.codecompany.rysys.api.annotation;

import static br.com.codecompany.rysys.api.annotation.AnnotationConstants.DIRECTION;
import br.com.codecompany.rysys.api.executor.ExecutionResult;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.codecompany.rysys.api.util.AnnotationUtils;

public abstract class ResponsePopulator extends Populator {

	private static final Logger log = LoggerFactory.getLogger(ResponsePopulator.class);
	
	public ResponsePopulator(ParserInfo info) {
		super(info);
	}

	// preenche o valor do campo de acordo com as anotações presentes
	private void fillValue(Object objectToFill, Field field,
			String stringToParse) {
		try {
			field.setAccessible(true);
			Object value = parse(field, stringToParse);
			log.debug("Filling field '" + objectToFill.getClass().getSimpleName() +
					"." + field.getName() + "' with value [" + value + "]");
			field.set(objectToFill, value);
		} catch (Exception e) {
			log.error("Could not fill field '" + objectToFill.getClass().getSimpleName() +
					"." + field.getName() + "'", e);
		}
	}

	// preenche o valor do campo de acordo com as anotações presentes
	private void fill(Object objectToFill, Field field,
			Object value) {
		try {
			field.setAccessible(true);
			log.debug("Filling field '" + objectToFill.getClass().getSimpleName() +
					"." + field.getName() + "' with value [" + value + "]");
			field.set(objectToFill, value);
		} catch (Exception e) {
			log.error("Could not fill field '" + objectToFill.getClass().getSimpleName() +
					"." + field.getName() + "'", e);
		}
	}
	
	// extrai os valores da string e popula nos campos correspondentes
	public void populate(Object objectToPopulate, String stringToParse) {

		// adiciona o objeto sendo processado na pilha
		context.pushCurrentObject(objectToPopulate);

		if (context.isAutoCalculateBeginIndex()) {
            log.info("Property autoCalculateBeginIndex=true. Calculating fields' positions");
        }
		stringToParse = unwrapData(stringToParse);
		List<Field> fields = prepare(objectToPopulate);
		for (Field field : fields) {
			fillValue(objectToPopulate, field, stringToParse);
		}

		// restaura o estado anterior da pilha
		context.popCurrentObject();
	}

	private List<Field> prepare(Object objectToPopulate) throws ClassNotAnnotatedException {
		Class<? extends Annotation> annotation = annotationToCheck();
		if (!AnnotationUtils.isAnnotated(objectToPopulate.getClass(), annotation)) {
			throw new ClassNotAnnotatedException("Class '" +
					objectToPopulate.getClass().getSimpleName() +
					"' does not contain @" + annotation.getSimpleName() +
					" annotation");
		}
		prepareFields(objectToPopulate);
		List<Field> fields = new ArrayList<Field>(inFieldsMap.keySet());
		if (fields.size() == 0) {
			log.warn("No fields found in class '" + 
					objectToPopulate.getClass().getSimpleName() + "' with " +
					DIRECTION + "=" + Direction.FROM_EIS);
		}
		return fields;
	}

	// popula os campos do objetos a partir do ExecutionResult
	public void populate(Object objectToPopulate, ExecutionResult result) {
		// adiciona o objeto sendo processado na pilha
		context.pushCurrentObject(objectToPopulate);

		// os resultados serao populados de acordo com a ordem do atributo 'index'
		List<Field> fields = prepare(objectToPopulate);
		if (fields.size() != result.size()) {
			throw new IllegalArgumentException("Total of annotated fields (" +
					fields.size() + ") must be equals to " +
					"total of result elements (" + result.size() + ")");
		}

		for (int i = 0; i < fields.size(); i++) {
			Field field = fields.get(i);
			Object value = result.getResultAt(i);
			fill(objectToPopulate, field, value);
		}

		// restaura o estado anterior da pilha
		context.popCurrentObject();
	}
	
	// remove o cabecalho, se necessario
	protected abstract String unwrapData(String stringToParse);

	// recupera o parser da anotacao e processa
	private Object parse(Field targetField, String sourceString) {
		Object result = null;
		// verifica se existe parser cadastrado para esse campo
		FieldParser parser = createParser(targetField, inFieldsMap);
		if (parser != null) {
			// permite acesso ao populator de dentro do parser.
			// util para campos do tipo Collection, Array, etc.
			if (parser instanceof ResponsePopulatorSupport) {
                try {
                    // cria um novo ResponsePopulator para o parser, preservando
                    // a instancia atual de RequestPopulator
                    ResponsePopulator populator = this.getClass().newInstance();
                    ((ResponsePopulatorSupport) parser).setResponsePopulator(populator);
				}
				catch(Exception e) {
					throw new RuntimeException("Error creating populator for " +
							parser.getClass().getName(), e);
				}
			}
			result = parser.parse(sourceString, inFieldsMap.get(targetField), context);
		}
		return result;
	}
}
