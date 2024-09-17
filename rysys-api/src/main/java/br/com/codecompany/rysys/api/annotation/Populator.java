package br.com.codecompany.rysys.api.annotation;

import static br.com.codecompany.rysys.api.annotation.AnnotationConstants.DIRECTION;
import static br.com.codecompany.rysys.api.annotation.AnnotationConstants.INDEX;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.codecompany.rysys.api.util.AnnotationUtils;
import br.com.codecompany.rysys.util.ReflectionUtils;
import br.com.codecompany.rysys.util.ToStringUtils;

public abstract class Populator implements FieldIgnorer {

	private static final Logger log = LoggerFactory.getLogger(Populator.class);
	
	// contexto com os parâmetros que serão passados para os parsers
	protected PopulatorContext context = new PopulatorContext();
	
	// mapa contendo os campos anotados e suas anotacoes. As anotacoes validas
	// sao informadas no construtor da classe
	
	// mapa dos campos que sao utilizados no result
	protected Map<Field,Annotation> inFieldsMap;
	
	// mapa dos campos que sao utilizados no request
	protected Map<Field,Annotation> outFieldsMap;

	// parser utilizado para cada anotacao
	private ParserInfo parserInfo = null;

	// retorna as informacoes de parsing
	protected ParserInfo getParserInfo() {
		return parserInfo;
	}
	
	// a classe a ser processada deve ser anotada com essa anotacao
	protected abstract Class<? extends Annotation> annotationToCheck(); 

	public Populator(ParserInfo info) {
		this.parserInfo = info;		
		if (log.isDebugEnabled()) {
			log.debug("Instance of " + this.getClass().getSimpleName() + 
					" created. Valid annotations are: " + parserInfo.validAnnotations());
		}
	}

	public boolean isAutoCalculateBeginIndex() {
		return context.isAutoCalculateBeginIndex();
	}

	public void setAutoCalculateBeginIndex(boolean autoCalculateBeginIndex) {
		context.setAutoCalculateBeginIndex(autoCalculateBeginIndex);
	}

	public boolean isIgnoreNullFields() {
		return context.isIgnoreNullFields();
	}

	public void setIgnoreNullFields(boolean ignoreNullFields) {
		context.setIgnoreNullFields(ignoreNullFields);
	}

	public String[] getFieldsToIgnore() {
		return context.getFieldsToIgnore();
	}

	public void setFieldsToIgnore(String... fieldsToIgnore) {
		context.setFieldsToIgnore(fieldsToIgnore);
	}

	public Object getCurrentObject() {
		return context.peekCurrentObject();
	}

	public void setCurrentObject(Object currentObject) {
		context.pushCurrentObject(currentObject);
	}

    public PopulatorContext getContext() {
        return context;
    }

    public void setContext(PopulatorContext context) {
        this.context = context;
    }

	protected void prepareFields(Object object) {
		inFieldsMap = new LinkedHashMap<Field, Annotation>();
		outFieldsMap = new LinkedHashMap<Field, Annotation>();
		
		// apenas por precaucao
		if (getFieldsToIgnore() == null) {
			setFieldsToIgnore(new String[]{});
		}
		
		// popula os mapas FROM_EIS e TO_EIS, de acordo com 
		// o valor BOUND_TYPE da anotacao
		Field[] all = ReflectionUtils.allFields(object);
		for (Field field : all) {
			Annotation annotation = validAnnotation(object, field);
			if (annotation != null) {
				String name = field.getName();
				Direction direction = (Direction) 
					AnnotationUtils.getEnumValue(annotation, DIRECTION);
				int index = AnnotationUtils.getIntValue(annotation, INDEX);
				if (direction.isTO() && index == -1) {
					throw new OrderNotSpecifiedException("Attribute '" + INDEX +
							"' is mandatory for fields with " + DIRECTION + "=" + Direction.TO_EIS +
							" (field = " + object.getClass().getSimpleName() + "." + field.getName() + ")");
				}
				if (!ArrayUtils.contains(getFieldsToIgnore(), name)) {
					if (direction.isFROM()) {
						inFieldsMap.put(field, annotation);
					}
					if (direction.isTO()) {
						outFieldsMap.put(field, annotation);
					}
				}
				else {
					log.info("Field '" + name + "' ignored");
				}
			}
		}
		// ordena os campos de acordo com o valor 'index' da anotacao
		// (necessario apenas para campos 'TO_EIS')
		outFieldsMap = sortHashMapByValues(object, outFieldsMap);
		
		if (log.isDebugEnabled()) {
			log.debug("Fields reorganized for class '" + object.getClass().getSimpleName() + "'\n" +
					"FROM_EIS fields: " + ToStringUtils.toString(inFieldsMap.keySet()) + "\n" +
					"  TO_EIS fields: " + ToStringUtils.toString(outFieldsMap.keySet()));
		}
		
		if (inFieldsMap.size() == 0) {
			log.info("No FROM_EIS fields found for class '" + object.getClass().getSimpleName() + "'");
		}
		if (outFieldsMap.size() == 0) {
			log.info("No TO_EIS fields found for class '" + object.getClass().getSimpleName() + "'");
		}		
	}
	
	// cria uma instancia de FieldParser de acordo com o valor 'parser' da anotacao
	@SuppressWarnings("unchecked")
	protected FieldParser createParser(Field field, Map<Field,Annotation> map) {
		FieldParser parser = null;
		if (map.isEmpty()) {
			throw new RuntimeException("Field list is empty. " +
                    "Method orderFields() must be executed first.");
		}
		else {
			Annotation annotation = map.get(field);
			try {
				Class<? extends FieldParser> parserClass =
						getParserInfo().getParser(annotation.annotationType());
				parser = (FieldParser) parserClass.newInstance();
				log.debug("Parser found for '{}': '{}'",
						annotation.annotationType().getSimpleName(),
						parserClass.getSimpleName());
			} catch (Exception e) {
				log.error("Could not retrieve apropriate parser for {}",
						annotation.annotationType().getSimpleName(), e);
			} 
		}
		return parser;
	}

	// verifica se a anotação é válida para efetuar o parsing
	private boolean isValid(Class<?> clazz) {
		boolean valid = false;
		for (Class<? extends Annotation> annotation : parserInfo.validAnnotations()) {
			String name1 = annotation.getClass().getName();
			String name2 = clazz.getClass().getName();
			if (name1.equals(name2)) {
				valid = true;
				break;
			}
		}
		return valid;
	}

	// recupera a anotacao valida para o campo
	// as anotacoes validas sao passadoas no construtor
	private Annotation validAnnotation(Object object, Field field) {
		Annotation valid = null;
		Annotation[] annotations = field.getAnnotations();
		for (Annotation annotation : annotations) {
			if (isValid(annotation.getClass())) {
				log.debug("Valid annotation found for field '" +
						object.getClass().getSimpleName() + "." + 
						field.getName() + "': @" +
                        annotation.annotationType().getSimpleName());
			}
			valid = annotation;
			break;
		}
		return valid;
	}
	
	private Map<Field,Annotation> sortHashMapByValues(Object objectToAnalyze, Map<Field,Annotation> passedMap) {		
		Set<Integer> used = new LinkedHashSet<Integer>();
		
		List<Field> mapKeys = new ArrayList<Field>(passedMap.keySet());
		List<Annotation> mapValues = new ArrayList<Annotation>(passedMap.values());
		Collections.sort(mapValues, new AnnotationComparator());
		Collections.sort(mapKeys, new FieldComparator());

		Map<Field,Annotation> someMap = new LinkedHashMap<Field,Annotation>();
		Iterator<Annotation> valueIt = mapValues.iterator();
		while (valueIt.hasNext()) {
			Annotation val = valueIt.next();
			int index = AnnotationUtils.getIntValue(val, INDEX);
			
			// verifica se o indice ja existe, de acordo com o tipo de bound
			// a ordem eh importante apenas nos tipos FROM_EIS e FROM_TO_EIS
			Direction direction = (Direction) AnnotationUtils.getEnumValue(val, DIRECTION);
			if (direction.isFROM() && index != -1) {
				if (!used.add(index)) {
					throw new DuplicatedOrderException(objectToAnalyze + " contains one or more " +
							"annotations with duplicated index (" + INDEX + "=" + index + "," +
							DIRECTION + "=" + direction + ")");
				}
			}
			
			Iterator<Field> keyIt = mapKeys.iterator();
			while (keyIt.hasNext()) {
				Field key = keyIt.next();
				if (passedMap.get(key).equals(val)) {
					passedMap.remove(key);
					mapKeys.remove(key);
					someMap.put(key, val);
					break;
				}
			}
		}
		return someMap;
	} 
	
	private class AnnotationComparator implements Comparator<Annotation> {
		public int compare(Annotation o1, Annotation o2) {
			int order1 = AnnotationUtils.getIntValue(o1, INDEX);
			int order2 = AnnotationUtils.getIntValue(o2, INDEX);
			return new Integer(order1).compareTo(order2);
		}		
	}
	
	private class FieldComparator implements Comparator<Field> {
		public int compare(Field f1, Field f2) {
			return f1.getName().compareTo(f2.getName());
		}		
	}
}
