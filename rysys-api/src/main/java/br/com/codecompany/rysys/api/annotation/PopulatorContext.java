package br.com.codecompany.rysys.api.annotation;

import java.util.Stack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PopulatorContext {

	private static Logger log = LoggerFactory.getLogger(PopulatorContext.class);

	// ignora campos nulos na extracao
    private boolean ignoreNullFields = true;

	// campos anotados que serao ignorados
	private String[] fieldsToIgnore = {};

	// indica que o valor da propriedade 'beginIndex' sera
	// extraido do ultimo campo processado (FROM_EIS). Nesse caso,
	// o atributo 'index' sera utilizado
	private boolean autoCalculateBeginIndex = false;

	// pilha dos objetos processados
	private Stack<Object> processedObjects = new Stack<Object>();

	private int nextBeginIndex = 0;

	public String[] getFieldsToIgnore() {
		return fieldsToIgnore;
	}

	public void setFieldsToIgnore(String[] fieldsToIgnore) {
		this.fieldsToIgnore = fieldsToIgnore;
	}

	public boolean isIgnoreNullFields() {
		return ignoreNullFields;
	}

	public void setIgnoreNullFields(boolean ignoreNullFields) {
		this.ignoreNullFields = ignoreNullFields;
	}

	public boolean isAutoCalculateBeginIndex() {
		return autoCalculateBeginIndex;
	}

	public void setAutoCalculateBeginIndex(boolean autoCalculateBeginIndex) {
		this.autoCalculateBeginIndex = autoCalculateBeginIndex;
	}

	public int getNextBeginIndex() {
		return nextBeginIndex;
	}

	public void read(int beginIndex, int length) {
		nextBeginIndex = beginIndex + length;
		log.debug("String read. Next begin index is {}", nextBeginIndex);
	}

    public void setBeginIndex(int nextBeginIndex) {
        this.nextBeginIndex = nextBeginIndex;
        log.debug("Begin updated. Next begin index is {}", nextBeginIndex);
    }

	public Object peekCurrentObject() {
		return processedObjects.peek();
	}

	public void pushCurrentObject(Object currentObject) {
		processedObjects.push(currentObject);
		log.debug("Current object is: {}", currentObject.getClass().getName());
	}

	public Object popCurrentObject() {
		return processedObjects.pop();
	}
}
