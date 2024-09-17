package br.com.codecompany.rysys.fgl.parser.transform;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.codecompany.rysys.fgl.parser.type.FglRysysType;

public class Context {

	private static final Logger log = LoggerFactory.getLogger(Context.class);
	
	private static Context INSTANCE = new Context();
	
	// funcoes
	private Map<String, Function> functions = new LinkedHashMap<String, Function>();

	private Context() {
		// funcao 'fake' para guardar as variaveis globais
		functions.put(Function.GLOBAL, new Function(Function.GLOBAL, 0));
	}

	public static Context getInstance() {
		return INSTANCE;
	}

	public Collection<Function> getFunctions() {
		return functions.values();
	}
	
	public Function getGlobalFunction() {
		return functions.get(Function.GLOBAL);
	}
	
	public void addFunction(Function function) {
		functions.put(function.getName(), function);
	}
	
	// retorna a funcao de acordo com a linha
	private Function getFunctionByLineNumber(int lineNumber) {
		Function result = null;
		for (Function function : functions.values()) {
			if (function.containsLine(lineNumber)) {
				result = function;
				break;
			}
		}
		if (result == null) {
			result = functions.get(Function.GLOBAL);
		}
		
		if (result == null) {
			throw new FunctionNotFoundException("No function which contains line " + 
					lineNumber + " found");
		}
		return result;
	}

	public Return getReturn(int lineNumber) {
		Function function = getFunctionByLineNumber(lineNumber);
		return function.getReturn(lineNumber);
	}
	
	public Whenever getWhenever(int lineNumber) {
		Function function = getFunctionByLineNumber(lineNumber);
		return function.getWhenever(lineNumber);
	}	
	
	public FglRysysType getRysysType(String variableName, int lineNumber) {
		log.debug("Looking for function which contains line " + lineNumber + "...");
		Function function = getFunctionByLineNumber(lineNumber);
		log.debug("Function found: " + function);
		
		FglRysysType type = null;
		try {
			log.debug("Looking for definition of '" + variableName +
					"' in function '" + function.getName() + "' scope");
			// variavel definida na funcao?
			type = function.getRysysType(variableName);	
			log.info("Definition of '" + variableName +	
					"' found in function '" + function.getName() + "' scope");
		} catch (VariableNotFoundException e) {
			// variavel nao definida na funcao
			log.info("Variable '" + variableName + "' not defined in function '" +
					function.getName() + "' scope. Trying GLOBAL definitions...");
			type = getGlobalFunction().getRysysType(variableName);	
			log.info("Definition of '" + variableName +	
					"' found in GLOBAL scope");			
		}
		
		return type;
	}
	
	public String dump() {
		StringBuilder result = new StringBuilder("\n");
		for (Function function : functions.values()) {
			if (!Function.isGlobal(function)) {
				result.append("FUNCTION ");
			}
			result.append(function);
			result.append("\n");
			result.append("  Variables:\n");
			for (Variable variable : function.getVariables()) {
				result.append("    ");
				result.append(variable);
				result.append("\n");
			}
			if (!Function.isGlobal(function)) {
				result.append("  Last declaration line: " + function.getWheneverInsertionLine());
				result.append("\n");
			}
			if (!Function.isGlobal(function)) {
				result.append("  Whenevers:\n");
				for (Whenever w : function.getWhenevers()) {
					result.append("    ");
					result.append(w);
					result.append("\n");
				}
			}
			if (!Function.isGlobal(function)) {
				result.append("  Returns:\n");
				for (Return r : function.getReturns()) {
					result.append("    ");
					result.append(r);
					result.append("\n");
				}
			}
		}
		return result.toString();
	}
}
