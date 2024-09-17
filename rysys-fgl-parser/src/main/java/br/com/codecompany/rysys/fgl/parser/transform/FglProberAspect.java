package br.com.codecompany.rysys.fgl.parser.transform;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import antlr.Token;
import antlr.TokenStreamException;
import br.com.codecompany.rysys.fgl.parser.FGLParser;
import br.com.codecompany.rysys.fgl.parser.FGLTokenTypes;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;

@Aspect
public class FglProberAspect {

	private static Logger log = LoggerFactory.getLogger(FglProberAspect.class);
	
	private static final int NO_SCOPE = 0;
	private static final int TYPE_SCOPE = 1;
	private static final int IDENT_SCOPE = 2;
	private static final int RETURN_SCOPE = 3;
	private static final int WHENEVER_SCOPE = 4;
	
	private int scope = NO_SCOPE;	
	private List<Token> identTokenMembers = new ArrayList<Token>();
	private List<Token> typeTokenMembers = new ArrayList<Token>();
	private List<Token> returnTokenMembers = new ArrayList<Token>();
	private List<Token> wheneverTokenMembers = new ArrayList<Token>();
	private boolean insideRecord = false;
	private Function currentFunction = Context.getInstance().getGlobalFunction();

	private void reset() {
		scope = NO_SCOPE;
		identTokenMembers = new ArrayList<Token>();
		typeTokenMembers = new ArrayList<Token>();
	}

	@Before("call(public void br.com.codecompany.rysys.fgl.parser.FGLParser.match(int)) && " +
	"args(tokenType) && target(parser)")
	public void beforeMatch(FGLParser parser, int tokenType) {
		try {
			Token token = parser.LT(1);
			
			// processando um registro?
			if (tokenType == FGLTokenTypes.RECORD) {
				insideRecord = !insideRecord;
				// concatena o token de fim de registro
				if (!insideRecord) {
					log.trace("Token acepted (end of record): " + token); 
					typeTokenMembers.add(token);
				}				
				log.trace(insideRecord? "Record start" : "Record end");
			}
			
			switch (scope) {
				case IDENT_SCOPE:
					identTokenMembers.add(token);
					log.trace("Token acepted (identifier): " + token);
					break;
				case TYPE_SCOPE:
					log.trace("Token acepted (type): " + token);
					if (token.getType() != FGLTokenTypes.RECORD) {
						typeTokenMembers.add(token);
					}
					break;
				case RETURN_SCOPE:
					log.trace("Token acepted (return): " + token);
					returnTokenMembers.add(token);
					break;
				case WHENEVER_SCOPE:
					log.trace("Token acepted (whenever): " + token);
					wheneverTokenMembers.add(token);
					break;					
				case NO_SCOPE:
					log.trace("Token ignored: " + token + " (record=" + insideRecord);
					break;				
				default:
					break;
			}					
		} catch (TokenStreamException e) {
			log.error("Error reading token", e);
		}
	}

	@After("execution(public void br.com.codecompany.rysys.fgl.parser.FGLParser.variableDeclaration())")
	public void afterVariableDeclaration() {
		if (!insideRecord) {
			if (identTokenMembers.size() > 0 && typeTokenMembers.size() > 0) {
				Variable variable = new Variable(identTokenMembers, typeTokenMembers);
				log.debug("Variable found: " + variable + 
						". Current function is " + currentFunction.getName());
				currentFunction.addVariable(variable);
			}
			reset();
		}
	}

	@Before("execution(public void br.com.codecompany.rysys.fgl.parser.FGLParser.constantIdentifier())")
	public void beforeConstantIdentifier() {
		if (scope == NO_SCOPE) {
			scope = IDENT_SCOPE;
		}
		// qualquer coisa dentro do 'record' serah ignorada
		if (insideRecord) {
			scope = NO_SCOPE;
		}
	}

	@Before("execution(public void br.com.codecompany.rysys.fgl.parser.FGLParser.type())")
	public void beforeType() {
		scope = TYPE_SCOPE;
		// qualquer coisa dentro do 'record' serah ignorada
		if (insideRecord) {
			scope = NO_SCOPE;
		}
	}

	@After("execution(public void br.com.codecompany.rysys.fgl.parser.FGLParser.type())")
	public void afterType() {
		scope = NO_SCOPE;
	}

	@Before("execution(public void br.com.codecompany.rysys.fgl.parser.FGLParser.returnStatement())")
	public void beforeReturnStatement() {
		scope = RETURN_SCOPE;	
	}

	@After("execution(public void br.com.codecompany.rysys.fgl.parser.FGLParser.returnStatement())")
	public void afterReturnStatement() {
		Return r = new Return(returnTokenMembers);
		currentFunction.addReturn(r.getStartLine(), r);
		log.debug("Return statement found: '" + r + 
				"'. Current function is " + currentFunction.getName());
		scope = NO_SCOPE;
		returnTokenMembers = new ArrayList<Token>();
	}

	@Before("execution(public void br.com.codecompany.rysys.fgl.parser.FGLParser.wheneverStatement())")
	public void beforeWheneverStatement() {
		scope = WHENEVER_SCOPE;	
	}

	@After("execution(public void br.com.codecompany.rysys.fgl.parser.FGLParser.wheneverStatement())")
	public void afterWheneverStatemen() {
		Whenever w = new Whenever(wheneverTokenMembers);
		currentFunction.addWhenever(w.getStartLine(), w);
		log.debug("Whenever statement found: '" + w + 
				"'. Current function is " + currentFunction.getName());
		scope = NO_SCOPE;
		wheneverTokenMembers = new ArrayList<Token>();
	}	

	@Before("execution(public void br.com.codecompany.rysys.fgl.parser.FGLParser.functionStart(String, int)) " +
	"&& args(name, start)")
	public void beforeFunctionStart(String name, int start) {
		log.debug("Function start found: '" + name + "'");
		Function function = new Function(name, start);
		currentFunction = function;
	}

	@After("execution(public void br.com.codecompany.rysys.fgl.parser.FGLParser.functionEnd(int)) && args(end)")
	public void afterFunctionEnd(int end) {
		currentFunction.setEndLine(end);
		log.debug("Function end found. Adding " + currentFunction + " to map...");
		Context.getInstance().addFunction(currentFunction);
	}
}
