package br.com.codecompany.rysys.api.annotation.parser;

import br.com.codecompany.rysys.api.annotation.FieldParser;
import br.com.codecompany.rysys.api.annotation.Direction;
import static br.com.codecompany.rysys.api.annotation.AnnotationConstants.COLLECTION_START;
import static br.com.codecompany.rysys.api.annotation.AnnotationConstants.COLLECTION_TYPE;
import static br.com.codecompany.rysys.api.annotation.AnnotationConstants.DIRECTION;
import static br.com.codecompany.rysys.api.annotation.AnnotationConstants.ELEMENT_OFFSET;
import static br.com.codecompany.rysys.api.annotation.AnnotationConstants.ELEMENT_TYPE;
import static br.com.codecompany.rysys.api.annotation.AnnotationConstants.TOTAL_ELEMENTS_BEGIN_INDEX;
import static br.com.codecompany.rysys.api.annotation.AnnotationConstants.TOTAL_ELEMENTS_LENGTH;
import static br.com.codecompany.rysys.api.annotation.AnnotationConstants.APPEND_COLLECTION_SIZE;
import static br.com.codecompany.rysys.api.annotation.AnnotationConstants.TOTAL_FROM_PROPERTY;

import java.lang.annotation.Annotation;
import java.util.Collection;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.codecompany.rysys.api.annotation.PopulatorContext;
import br.com.codecompany.rysys.api.annotation.RequestPopulator;
import br.com.codecompany.rysys.api.annotation.RequestPopulatorSupport;
import br.com.codecompany.rysys.api.annotation.ResponsePopulator;
import br.com.codecompany.rysys.api.annotation.ResponsePopulatorSupport;
import br.com.codecompany.rysys.api.util.AnnotationUtils;
import br.com.codecompany.rysys.util.FormatUtils;
import br.com.codecompany.rysys.util.ReflectionUtils;

public class CollectionFieldParser implements RequestPopulatorSupport, 
	ResponsePopulatorSupport, FieldParser {

	private static final Logger log = LoggerFactory.getLogger(CollectionFieldParser.class);
	
	private RequestPopulator requestPopulator;
	private ResponsePopulator responsePopulator;
	
	public void setRequestPopulator(RequestPopulator requestPopulator) {
		this.requestPopulator = requestPopulator;
	}
	
	public void setResponsePopulator(ResponsePopulator responsePopulator) {
		this.responsePopulator = responsePopulator;
	}
	
	@SuppressWarnings("unchecked")
	public Object parse(String stringToParse, Annotation annotation, PopulatorContext context) {
		Collection collection = null;		
		try {
			// o total de elementos vem de uma propriedade?
			boolean totalFromProperty = false;

            // classe da colecao
			Class<?> collectionType = 
				AnnotationUtils.getClassValue(annotation, COLLECTION_TYPE);
			Class<Collection> collectionClass = (Class<Collection>) collectionType;			
			log.debug("Creating collection of type " + collectionClass.getName());
			collection = (Collection) collectionClass.newInstance();

			// o total de elementos vem de uma propriedade?
			String property = AnnotationUtils.getStringValue(annotation, TOTAL_FROM_PROPERTY);
			if (property != null && !"".equals(property.trim())) {
				totalFromProperty = true;
			}

            // o total de elementos pode vir do contexto ou direto da anotacao
			int totalStart = AnnotationUtils.getIntValue(annotation, TOTAL_ELEMENTS_BEGIN_INDEX);
			if (totalStart < 0 && !context.isAutoCalculateBeginIndex() && !totalFromProperty) {
				throw new IllegalArgumentException("Attribute '" + TOTAL_ELEMENTS_BEGIN_INDEX + 
						"' must have value >= 0 for fields with " +
						DIRECTION + "=" + Direction.FROM_EIS + " in annotation " +
						annotation);
			}

			// o inicio do parsing sera feito em funcao do ultimo campo processado
			if (context.isAutoCalculateBeginIndex()) {
				totalStart = context.getNextBeginIndex();
				log.debug("Using a calculated beginIndex: {}", totalStart);
			}

			// total de elementos da colecao
			int size = 0;
			
			// total de posicoes que juntas armazenam o total de elementos da colecao
			int totalLength = 0;

			// o total de elementos vem de uma propriedade
			if (totalFromProperty) {
				log.debug("Extracting collection size from property '{}'", property);
				Object object = ReflectionUtils.getValue(context.peekCurrentObject(), property);
				try {
					size = Integer.valueOf(String.valueOf(object));
				} catch (NumberFormatException e) {
					throw new IllegalArgumentException("Value of property '" +
							"' is not an integer", e);
				}
				totalLength = 0;
			}
			else {
				// total de posicoes que juntas armazenam o total de elementos da colecao
				totalLength = AnnotationUtils.getIntValue(annotation, TOTAL_ELEMENTS_LENGTH);
				if (totalLength < 1) {
					throw new IllegalArgumentException("Attribute '" + TOTAL_ELEMENTS_LENGTH +
							"' must have value > 0 for fields with " +
							DIRECTION + "=" + Direction.FROM_EIS + " in annotation " +
							annotation);
				}

				// extrai o total de elementos de acordo com os atribtos apropiados
				String sizeAsString = FormatUtils.substring(stringToParse, totalStart, totalLength);

				log.debug("Extracting collection size from string");
				TextFieldParser.debugExtration(log, stringToParse, sizeAsString, totalStart, totalLength);

				// total de elementos
				size = Integer.valueOf(sizeAsString);
			}

			log.debug("Collection size is {}", size);

            // classe dos elementos
			Class<?> elementType = AnnotationUtils.getClassValue(annotation, ELEMENT_TYPE);
			log.debug("Adding " + size + " elements of type " + elementType.getSimpleName() +
					" to " + collectionClass.getName());

            // o offset eh necessario caso o elemento nao seja do tipo DataDescriptor
            // caso contrario, o offset serah calculado a partir da anotacao do elemento
			int offset = AnnotationUtils.getIntValue(annotation, ELEMENT_OFFSET);
			if (offset <= 0 && ReflectionUtils.isPrimitive(elementType)) {
				throw new IllegalArgumentException("Attribute '" + ELEMENT_OFFSET + 
						"' must have value > 0 for fields with " +
						DIRECTION + "=" + Direction.FROM_EIS + " in annotation " +
						annotation);
			}
            if (context.isAutoCalculateBeginIndex()) {
                log.debug("Offset value ignored (autoCalculateBeginIndex=true)");
            }
			
			// posicao do primeiro registro
			int collectionStart = AnnotationUtils.getIntValue(annotation, COLLECTION_START);
			if (collectionStart < 0) {
				collectionStart = totalStart + totalLength;
			}			
			int elementStart = collectionStart;
            log.debug("Collection starts at position {}", elementStart);

            // se o elemento da colecao nao for do tipo DataDescriptor,
            // o contexto do parser atual sera compartilhado com o
            // do parser de elementos
            if (!ReflectionUtils.isPrimitive(collectionType)) {
                context.setBeginIndex(elementStart);
                responsePopulator.setContext(context);
                log.debug("Elements are not primitives, sharing context");
            }

            // popula a colecao
			for (int i = 0; i < size; i++) {
				Object element = null;				
                String elementAsString = FormatUtils.substring(stringToParse, elementStart, offset);
                
                if (ReflectionUtils.isPrimitive(elementType)) {
                    // exibe a extracao (debug)
                    TextFieldParser.debugExtration(log, stringToParse, elementAsString, elementStart, offset);

                    log.debug("Converting [" + elementAsString + "] (" + elementAsString.length() +
                        " chars)" + " to " + elementType.getSimpleName());

					element = ReflectionUtils.createPrimitive(elementType, elementAsString);
                    // se o elemnto for String o trim serah forcado
					if (element instanceof String) {
						String newValue = ((String) element).trim();
						log.debug("Triming string collection element: '{}' --> '{}'",
								element, newValue);
						element = newValue;
					}
                    // calcula o proximo indice inicial
                    context.read(elementStart, offset);
				}
				else {
					try {                        
						element = elementType.newInstance();
                        // neste caso se o contexto eh compartilhado, e a string
                        // completa serah utilizada no parsing do elemento
                        if (context.isAutoCalculateBeginIndex()) {
                            elementAsString = stringToParse;
                        }
                        responsePopulator.populate(element, elementAsString);
					} catch (Exception e) {
						log.error("Cold not create element. Check if class " +
								elementType.getSimpleName() + " has a default constructor", e);
					}
				}

                elementStart += offset;
				collection.add(element);
                log.debug("Element {} added to collection", i);
			}
			
		} catch (Exception e) {
			log.error("Could not create/populate collection", e);
		}
		
		return collection;
	}

	public String unparse(Object fieldValue, Annotation annotation, PopulatorContext context) {
		StringBuffer buffer = new StringBuffer();
		Collection<?> list = (Collection<?>) fieldValue;
		Class<?> elementClass = AnnotationUtils.getClassValue(annotation, ELEMENT_TYPE);

		if (fieldValue != null) {
			// coloca o tamanho da lista na string?
			boolean append = AnnotationUtils.getBooleanValue(annotation, APPEND_COLLECTION_SIZE);
			if (append) {
				int totalLength = AnnotationUtils.getIntValue(annotation, TOTAL_ELEMENTS_LENGTH);
				if (totalLength <= 0) {
					throw new IllegalArgumentException("Attribute '" + TOTAL_ELEMENTS_LENGTH +
							"' must have value > 0 for fields with " +
							DIRECTION + "=" + Direction.TO_EIS + " in annotation " +
							annotation);
				}
				String sizeAsString = String.valueOf(list.size());
				// total de elementos lista
				buffer.append(StringUtils.leftPad(sizeAsString, totalLength, '0'));
				if (list.size() > 0) {
					if (sizeAsString.length() > totalLength) {
						throw new IllegalArgumentException("Collection size (" + sizeAsString +
								") greater than allowed by '" + TOTAL_ELEMENTS_LENGTH +
								"' (" + totalLength + ") in annotation " +
								annotation);
					}
				}
				else {
					log.debug("Empty list found for annotation " + annotation);
				}
			}

			// concatena a representacao como string de todos
			// os elementos da collection
			if (ReflectionUtils.isPrimitive(elementClass)) {
				// tamanho final de cada um dos elementos
				int offset = AnnotationUtils.getIntValue(annotation, ELEMENT_OFFSET);
				if (offset <= 0) {
					throw new IllegalArgumentException("Attribute '" + ELEMENT_OFFSET +
							"' must have value > 0 for collecion of primitives with " +
							DIRECTION + "=" + Direction.TO_EIS + " in annotation " +
							annotation);
				}
				for (Object element : list) {
					String value = String.valueOf(element);
					if (ReflectionUtils.isNumeric(elementClass)) {
						value = StringUtils.leftPad(value, offset, '0');
					}
					else {
						value = StringUtils.rightPad(value, offset);
					}
					buffer.append(value);
				}
			}
			// referencia um objeto que deve estar anotado
			else {
				for (Object element : list) {
					// nao eh necessario calcular o tamanho dos elementos, pois
					// ele sera calculado a partir das anotacoes da classe
					buffer.append(requestPopulator.extractFieldsAsString(element));
				}
			}
		}
		else {
			log.debug("Null Field ignored: '" + fieldValue + "'");
		}
		
		return buffer.toString();
	}
}
