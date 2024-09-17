package br.com.codecompany.rysys.fgl.parser.transform;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.codecompany.rysys.fgl.parser.type.FglRysysDate;
import br.com.codecompany.rysys.fgl.parser.type.FglRysysFloat;
import br.com.codecompany.rysys.fgl.parser.type.FglRysysInteger;
import br.com.codecompany.rysys.fgl.parser.type.FglRysysString;
import br.com.codecompany.rysys.fgl.parser.type.FglRysysType;
import br.com.codecompany.rysys.fgl.parser.type.TypeNotSupportedException;

public class Function {

	private static final Logger log = LoggerFactory.getLogger(Function.class);
	
	public static final String GLOBAL = "__GLOBAL_DEFINITIONS__";
	
	private static final Pattern CHAR_PATTERN = Pattern.compile("char\\((\\d+)\\)");
	
	private String name;
	private int startLine;
	private int endLine;
	
	// ultima linha de declaracao de variavel
	private int lastVarDeclarationLine = 0;
	
	// variaveis da funcao: <nome, variavel>
	private Map<String, Variable> variables = new LinkedHashMap<String, Variable>();
	
	// retornos da funcao: <linha, objeto retorno>
	private Map<Integer, Return> returns = new LinkedHashMap<Integer, Return>();
	
	// whenevers da funcao: <linha, objeto whenever>
	private Map<Integer, Whenever> whenevers = new LinkedHashMap<Integer, Whenever>();	

	public String getName() {
		return name;
	}

	public int getStartLine() {
		return startLine;
	}

	public int getEndLine() {
		return endLine;
	}

	public void setEndLine(int endLine) {
		this.endLine = endLine;
	}

	public Collection<Variable> getVariables() {
		return variables.values();
	}
	
	public Collection<Whenever> getWhenevers() {
		return whenevers.values();
	}
	
	public Collection<Return> getReturns() {
		return returns.values();
	}
	
	public Function(String name, int startLine) {
		this.name = name;
		this.startLine = startLine;
		lastVarDeclarationLine = startLine + 1;
	}
	
	public void addVariable(Variable variable) {
		variables.put(variable.getName(), variable);
		if (variable.getEndLine() > lastVarDeclarationLine) {
			lastVarDeclarationLine = variable.getEndLine(); 
		}
	}
	
	public int getWheneverInsertionLine() {
		return isGlobal(this)? -1 : lastVarDeclarationLine + 1;
	}
	
	public void addWhenever(int lineNumber,Whenever whenever) {
		whenevers.put(lineNumber, whenever);
	}	
	
	public void addReturn(int lineNumber, Return r) {
		returns.put(lineNumber, r);
	}
	
	public Return getReturn(int lineNumber) {
		return returns.get(lineNumber);
	}
	
	public Whenever getWhenever(int lineNumber) {
		return whenevers.get(lineNumber);
	}	
	
	public boolean containsLine(int line) {
		return line >= startLine && line <= endLine;
	}
	
	public FglRysysType getRysysType(String name) {
		FglRysysType type = null;
		Variable variable = variables.get(name);
		
		// variavel nao encontrada, verifica se eh um valor constante
		if (variable == null) {
			type = constantValue(name);
			// variavel nao existe na funcao
			if (type == null) {
				throw new VariableNotFoundException("Variable '" + name
						+ "' not found in context");
			}
		}
		
		// variavel encontrada, mas tipo nao encontrado
		// pelo tipo encontra o tipo rysys e o tamanho
		if (type == null) {
			type = getType(variable.getType());
		}
		
		if (type == null) {
			throw new TypeNotSupportedException("Error analyzing variable "
					+ variable + ". Type '" + variable.getType()
					+ "' is not supported. "
					+ "Valid types are: char(n), date, float, integer");
		}

		log.debug("Rysys type for '" + variable + "' is " + type);

		return type;
	}
	
	// se o valor for constante, retorna o tipo correspondente
	private FglRysysType constantValue(String value) {
		FglRysysType type = null;
		// tipo inteiro?
		try {
			Integer.parseInt(value);
			type = new FglRysysInteger();
		} catch (NumberFormatException e) {
			// tipo float?
			try {
				Float.parseFloat(value);
				type = new FglRysysFloat();
			} catch (NumberFormatException e1) {
				// tipo string?
				if (value.startsWith("\"") && value.endsWith("\"")) {					
					type = new FglRysysString(value.length());
				}
			}	
		}
		return type;
	}
	
	// retorna o tipo de acordo com seu nome
	private FglRysysType getType(String type) {
		// FGL nao eh case sensitive
		type = String.valueOf(type).toLowerCase();

		FglRysysType fglType = null;

		if (type.startsWith("char(")) {
			Matcher matcher = CHAR_PATTERN.matcher(type);
			if (matcher.matches()) {
				fglType = new FglRysysString(Integer.valueOf(matcher.group(1)));
			}
		} else if ("integer".equals(type)) {
			fglType = new FglRysysInteger();
		} else if ("float".equals(type)) {
			fglType = new FglRysysFloat();
		} else if ("date".equals(type)) {
			fglType = new FglRysysDate();
		}

		return fglType;
	}	
	
	public static boolean isGlobal(Function function) {
		return GLOBAL.equals(function.name);
	}
	
	@Override
	public String toString() {
		return name + (isGlobal(this)? "" : 
			"{" + startLine + "-" + endLine + "}");
	}
}
