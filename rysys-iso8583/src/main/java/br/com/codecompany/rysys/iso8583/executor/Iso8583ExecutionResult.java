package br.com.codecompany.rysys.iso8583.executor;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.codecompany.rysys.api.executor.ExecutionResult;
import br.com.codecompany.rysys.api.executor.NoResultException;

public class Iso8583ExecutionResult implements ExecutionResult {

	private static Logger log = LoggerFactory.getLogger(Iso8583ExecutionResult.class);
	
	private List<Map<Integer, String>> values;

	public Iso8583ExecutionResult(List<Map<Integer, String>> result) {
		this.values = result;
	}
	
	public Object getResultAt(int index) {
    	if (values == null) {
    		throw new NoResultException("There is no result for this execution");
    	}
    	else {
    		Object value = values.get(index);
        	if (value == null) {
        		throw new NoResultException("There is no result in index " + index);
        	}    		
	        return values;
    	}
	}

	public boolean isError() {
		return values == null;
	}

	public int size() {
		return values == null? 0 : values.size();
	}

	@Override
	public String toString() {
		return String.valueOf(values);
	}
	
	// retorna o resultado da concatenacao do valor do bit n de
	// cada uma das mensagens
	public String join(int bit) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < values.size(); i++) {
			Map<Integer, String> map = values.get(i);
			String value = map.get(bit);
			if (value != null) {
				builder.append(value);
			}
			else {
				log.warn("Value of bit {} of element {} is null. Ignored", bit, i);
			}			
		}
		return builder.toString();
	}
}
