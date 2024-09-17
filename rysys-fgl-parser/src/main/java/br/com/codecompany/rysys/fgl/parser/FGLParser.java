package br.com.codecompany.rysys.fgl.parser;

// $ANTLR 2.7.7 (2006-11-01): "fgl.g" -> "FGLParser.java"$

import antlr.LLkParser;
import antlr.NoViableAltException;
import antlr.ParserSharedInputState;
import antlr.RecognitionException;
import antlr.Token;
import antlr.TokenBuffer;
import antlr.TokenStream;
import antlr.TokenStreamException;
import antlr.collections.impl.BitSet;

public class FGLParser extends LLkParser implements FGLTokenTypes {

	protected FGLParser(TokenBuffer tokenBuf, int k) {
		super(tokenBuf, k);
		tokenNames = _tokenNames;
	}

	public FGLParser(TokenBuffer tokenBuf) {
		this(tokenBuf, 2);
	}

	protected FGLParser(TokenStream lexer, int k) {
		super(lexer, k);
		tokenNames = _tokenNames;
	}

	public FGLParser(TokenStream lexer) {
		this(lexer, 2);
	}

	public FGLParser(ParserSharedInputState state) {
		super(state, 2);
		tokenNames = _tokenNames;
	}

	public final void compilation_unit() throws RecognitionException,
			TokenStreamException {

		{
			switch (LA(1)) {
			case DATABASE: {
				databaseDeclaration();
				break;
			}
			case EOF:
			case MAIN:
			case FUNCTION:
			case GLOBALS:
			case DEFINE:
			case REPORT: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		{
			_loop4: do {
				if ((LA(1) == GLOBALS)) {
					globalDeclaration();
				} else {
					break _loop4;
				}

			} while (true);
		}
		{
			if ((_tokenSet_0.member(LA(1))) && (_tokenSet_1.member(LA(2)))) {
				typeDeclarations();
			} else if ((_tokenSet_2.member(LA(1)))
					&& (_tokenSet_1.member(LA(2)))) {
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}

		}
		{
			switch (LA(1)) {
			case MAIN: {
				mainBlock();
				break;
			}
			case EOF:
			case FUNCTION:
			case REPORT: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		functionOrReportDefinitions();
		match(Token.EOF_TYPE);
	}

	public final void databaseDeclaration() throws RecognitionException,
			TokenStreamException {

		match(DATABASE);
		{
			constantIdentifier();
			{
				switch (LA(1)) {
				case ATSYMBOL: {
					match(ATSYMBOL);
					constantIdentifier();
					break;
				}
				case EOF:
				case IDENT:
				case MAIN:
				case END:
				case DEFER:
				case RETURN:
				case FUNCTION:
				case GLOBALS:
				case DEFINE:
				case SEMI:
				case RUN:
				case LET:
				case CALL:
				case GOTO:
				case PREPARE:
				case IF:
				case ELSE:
				case WHILE:
				case FOR:
				case FOREACH:
				case CASE:
				case WHEN:
				case OTHERWISE:
				case SLEEP:
				case CONSTRUCT:
				case DISPLAY:
				case INPUT:
				case MENU:
				case REPORT:
				case EXIT:
				case CONTINUE:
				case ALLOCATE:
				case LOCATE:
				case DEALLOCATE:
				case RESIZE:
				case FREE:
				case INITIALIZE:
				case VALIDATE:
				case START:
				case PAGE:
				case TERMINATE:
				case FINISH:
				case PAUSE:
				case NEED:
				case PRINT:
				case SKIP:
				case OUTPUT:
				case BEFORE:
				case AFTER:
				case ON:
				case NEXT:
				case ERROR:
				case MESSAGE:
				case PROMPT:
				case INSERT:
				case DELETE:
				case COMMAND:
				case SHOW:
				case HIDE:
				case FIRST:
				case OPTIONS:
				case CLEAR:
				case CLOSE:
				case CURRENT:
				case OPEN:
				case SCROLL:
				case DECLARE:
				case UPDATE:
				case FETCH:
				case FLUSH:
				case PUT:
				case DROP:
				case CREATE:
				case LOCK:
				case SELECT:
				case LOAD:
				case UNLOAD:
				case SET:
				case EXECUTE:
				case EXCLUSIVE:
				case DATABASE:
				case BEGIN:
				case COMMIT:
				case ROLLBACK:
				case WHENEVER: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
		}
		{
			switch (LA(1)) {
			case EXCLUSIVE: {
				match(EXCLUSIVE);
				break;
			}
			case EOF:
			case IDENT:
			case MAIN:
			case END:
			case DEFER:
			case RETURN:
			case FUNCTION:
			case GLOBALS:
			case DEFINE:
			case SEMI:
			case RUN:
			case LET:
			case CALL:
			case GOTO:
			case PREPARE:
			case IF:
			case ELSE:
			case WHILE:
			case FOR:
			case FOREACH:
			case CASE:
			case WHEN:
			case OTHERWISE:
			case SLEEP:
			case CONSTRUCT:
			case DISPLAY:
			case INPUT:
			case MENU:
			case REPORT:
			case EXIT:
			case CONTINUE:
			case ALLOCATE:
			case LOCATE:
			case DEALLOCATE:
			case RESIZE:
			case FREE:
			case INITIALIZE:
			case VALIDATE:
			case START:
			case PAGE:
			case TERMINATE:
			case FINISH:
			case PAUSE:
			case NEED:
			case PRINT:
			case SKIP:
			case OUTPUT:
			case BEFORE:
			case AFTER:
			case ON:
			case NEXT:
			case ERROR:
			case MESSAGE:
			case PROMPT:
			case INSERT:
			case DELETE:
			case COMMAND:
			case SHOW:
			case HIDE:
			case FIRST:
			case OPTIONS:
			case CLEAR:
			case CLOSE:
			case CURRENT:
			case OPEN:
			case SCROLL:
			case DECLARE:
			case UPDATE:
			case FETCH:
			case FLUSH:
			case PUT:
			case DROP:
			case CREATE:
			case LOCK:
			case SELECT:
			case LOAD:
			case UNLOAD:
			case SET:
			case EXECUTE:
			case DATABASE:
			case BEGIN:
			case COMMIT:
			case ROLLBACK:
			case WHENEVER: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		{
			switch (LA(1)) {
			case SEMI: {
				match(SEMI);
				break;
			}
			case EOF:
			case IDENT:
			case MAIN:
			case END:
			case DEFER:
			case RETURN:
			case FUNCTION:
			case GLOBALS:
			case DEFINE:
			case RUN:
			case LET:
			case CALL:
			case GOTO:
			case PREPARE:
			case IF:
			case ELSE:
			case WHILE:
			case FOR:
			case FOREACH:
			case CASE:
			case WHEN:
			case OTHERWISE:
			case SLEEP:
			case CONSTRUCT:
			case DISPLAY:
			case INPUT:
			case MENU:
			case REPORT:
			case EXIT:
			case CONTINUE:
			case ALLOCATE:
			case LOCATE:
			case DEALLOCATE:
			case RESIZE:
			case FREE:
			case INITIALIZE:
			case VALIDATE:
			case START:
			case PAGE:
			case TERMINATE:
			case FINISH:
			case PAUSE:
			case NEED:
			case PRINT:
			case SKIP:
			case OUTPUT:
			case BEFORE:
			case AFTER:
			case ON:
			case NEXT:
			case ERROR:
			case MESSAGE:
			case PROMPT:
			case INSERT:
			case DELETE:
			case COMMAND:
			case SHOW:
			case HIDE:
			case FIRST:
			case OPTIONS:
			case CLEAR:
			case CLOSE:
			case CURRENT:
			case OPEN:
			case SCROLL:
			case DECLARE:
			case UPDATE:
			case FETCH:
			case FLUSH:
			case PUT:
			case DROP:
			case CREATE:
			case LOCK:
			case SELECT:
			case LOAD:
			case UNLOAD:
			case SET:
			case EXECUTE:
			case DATABASE:
			case BEGIN:
			case COMMIT:
			case ROLLBACK:
			case WHENEVER: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
	}

	public final void globalDeclaration() throws RecognitionException,
			TokenStreamException {

		match(GLOBALS);
		{
			switch (LA(1)) {
			case STRING_LITERAL: {
				string();
				break;
			}
			case END:
			case DEFINE: {
				eol();
				typeDeclarations();
				match(END);
				match(GLOBALS);
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		eol();
	}

	public final void typeDeclarations() throws RecognitionException,
			TokenStreamException {

		{
			_loop31: do {
				if ((LA(1) == DEFINE)) {
					typeDeclaration();
				} else {
					break _loop31;
				}

			} while (true);
		}
	}

	public final void mainBlock() throws RecognitionException,
			TokenStreamException {

		match(MAIN);
		eol();
		typeDeclarations();
		mainStatements();
		match(END);
		match(MAIN);
		eol();
	}

	public final void functionOrReportDefinitions()
			throws RecognitionException, TokenStreamException {

		{
			_loop16: do {
				switch (LA(1)) {
				case REPORT: {
					reportDefinition();
					break;
				}
				case FUNCTION: {
					functionDefinition();
					break;
				}
				default: {
					break _loop16;
				}
				}
			} while (true);
		}
	}

	public final void identifier() throws RecognitionException,
			TokenStreamException {

		match(IDENT);
	}

	public final void mainStatements() throws RecognitionException,
			TokenStreamException {

		{
			_loop10: do {
				switch (LA(1)) {
				case DEFER: {
					deferStatement();
					break;
				}
				case IDENT:
				case RETURN:
				case RUN:
				case LET:
				case CALL:
				case GOTO:
				case PREPARE:
				case IF:
				case WHILE:
				case FOR:
				case FOREACH:
				case CASE:
				case SLEEP:
				case CONSTRUCT:
				case DISPLAY:
				case INPUT:
				case MENU:
				case EXIT:
				case CONTINUE:
				case ALLOCATE:
				case LOCATE:
				case DEALLOCATE:
				case RESIZE:
				case FREE:
				case INITIALIZE:
				case VALIDATE:
				case START:
				case TERMINATE:
				case FINISH:
				case PAUSE:
				case NEED:
				case PRINT:
				case SKIP:
				case OUTPUT:
				case NEXT:
				case ERROR:
				case MESSAGE:
				case PROMPT:
				case INSERT:
				case DELETE:
				case SHOW:
				case HIDE:
				case OPTIONS:
				case CLEAR:
				case CLOSE:
				case CURRENT:
				case OPEN:
				case SCROLL:
				case DECLARE:
				case UPDATE:
				case FETCH:
				case FLUSH:
				case PUT:
				case DROP:
				case CREATE:
				case LOCK:
				case SELECT:
				case LOAD:
				case UNLOAD:
				case SET:
				case EXECUTE:
				case DATABASE:
				case BEGIN:
				case COMMIT:
				case ROLLBACK:
				case WHENEVER: {
					codeBlock();
					break;
				}
				default: {
					break _loop10;
				}
				}
			} while (true);
		}
	}

	public final void deferStatement() throws RecognitionException,
			TokenStreamException {

		match(DEFER);
		{
			switch (LA(1)) {
			case INTERRUPT: {
				match(INTERRUPT);
				break;
			}
			case QUIT: {
				match(QUIT);
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		eol();
	}

	public final void codeBlock() throws RecognitionException,
			TokenStreamException {

		{
			int _cnt92 = 0;
			_loop92: do {
				if ((_tokenSet_3.member(LA(1))) && (_tokenSet_4.member(LA(2)))) {
					statement();
				} else if ((LA(1) == DATABASE) && (_tokenSet_5.member(LA(2)))) {
					databaseDeclaration();
				} else {
					if (_cnt92 >= 1) {
						break _loop92;
					} else {
						throw new NoViableAltException(LT(1), getFilename());
					}
				}

				_cnt92++;
			} while (true);
		}
	}

	public final void eol() throws RecognitionException, TokenStreamException {

	}

	public final void reportDefinition() throws RecognitionException,
			TokenStreamException {

		match(REPORT);
		identifier();
		parameterList();
		{
			if ((_tokenSet_6.member(LA(1))) && (_tokenSet_7.member(LA(2)))) {
				typeDeclarations();
			} else if ((_tokenSet_8.member(LA(1)))
					&& (_tokenSet_9.member(LA(2)))) {
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}

		}
		{
			switch (LA(1)) {
			case OUTPUT: {
				outputReport();
				break;
			}
			case END:
			case ORDER:
			case FORMAT: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		{
			switch (LA(1)) {
			case ORDER: {
				match(ORDER);
				{
					switch (LA(1)) {
					case EXTERNAL: {
						match(EXTERNAL);
						break;
					}
					case BY: {
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
				match(BY);
				variableList();
				break;
			}
			case END:
			case FORMAT: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		{
			switch (LA(1)) {
			case FORMAT: {
				formatReport();
				break;
			}
			case END: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		match(END);
		match(REPORT);
	}

	public final void functionDefinition() throws RecognitionException,
			TokenStreamException {

		match(FUNCTION);
		functionIdentifier();
		parameterList();
		eol();
		typeDeclarations();
		{
			switch (LA(1)) {
			case IDENT:
			case RETURN:
			case RUN:
			case LET:
			case CALL:
			case GOTO:
			case PREPARE:
			case IF:
			case WHILE:
			case FOR:
			case FOREACH:
			case CASE:
			case SLEEP:
			case CONSTRUCT:
			case DISPLAY:
			case INPUT:
			case MENU:
			case EXIT:
			case CONTINUE:
			case ALLOCATE:
			case LOCATE:
			case DEALLOCATE:
			case RESIZE:
			case FREE:
			case INITIALIZE:
			case VALIDATE:
			case START:
			case TERMINATE:
			case FINISH:
			case PAUSE:
			case NEED:
			case PRINT:
			case SKIP:
			case OUTPUT:
			case NEXT:
			case ERROR:
			case MESSAGE:
			case PROMPT:
			case INSERT:
			case DELETE:
			case SHOW:
			case HIDE:
			case OPTIONS:
			case CLEAR:
			case CLOSE:
			case CURRENT:
			case OPEN:
			case SCROLL:
			case DECLARE:
			case UPDATE:
			case FETCH:
			case FLUSH:
			case PUT:
			case DROP:
			case CREATE:
			case LOCK:
			case SELECT:
			case LOAD:
			case UNLOAD:
			case SET:
			case EXECUTE:
			case DATABASE:
			case BEGIN:
			case COMMIT:
			case ROLLBACK:
			case WHENEVER: {
				codeBlock();
				break;
			}
			case END: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		match(END);
		match(FUNCTION);
		eol();
	}

	public final void returnStatement() throws RecognitionException,
			TokenStreamException {

		match(RETURN);
		{
			if ((_tokenSet_10.member(LA(1))) && (_tokenSet_11.member(LA(2)))) {
				variableOrConstantList();
			} else if ((_tokenSet_12.member(LA(1)))	&& (_tokenSet_13.member(LA(2)))) {
				
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}
		}
	}

	public final void variableOrConstantList() throws RecognitionException,
			TokenStreamException {

		{
			expression();
		}
		{
			_loop312: do {
				if ((LA(1) == COMMA)) {
					match(COMMA);
					{
						expression();
					}
				} else {					
					break _loop312;
				}

			} while (true);
		}
	}

	public final void functionIdentifier() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case DAY: {
			match(DAY);
			break;
		}
		case YEAR: {
			match(YEAR);
			break;
		}
		case MONTH: {
			match(MONTH);
			break;
		}
		case COLUMN: {
			match(COLUMN);
			break;
		}
		case SUM: {
			match(SUM);
			break;
		}
		case AVG: {
			match(AVG);
			break;
		}
		case MIN: {
			match(MIN);
			break;
		}
		case MAX: {
			match(MAX);
			break;
		}
		case EXTEND: {
			match(EXTEND);
			break;
		}
		case DATE: {
			match(DATE);
			break;
		}
		case INFIELD: {
			match(INFIELD);
			break;
		}
		case PREPARE: {
			match(PREPARE);
			break;
		}
		default:
			if ((LA(1) == TODAY) && (_tokenSet_14.member(LA(2)))) {
				match(TODAY);
			} else if ((LA(1) == WEEKDAY) && (_tokenSet_14.member(LA(2)))) {
				match(WEEKDAY);
			} else if ((LA(1) == MDY) && (_tokenSet_14.member(LA(2)))) {
				match(MDY);
			} else if ((LA(1) == COUNT) && (_tokenSet_14.member(LA(2)))) {
				match(COUNT);
			} else if ((LA(1) == TIME) && (_tokenSet_14.member(LA(2)))) {
				match(TIME);
			} else if ((_tokenSet_5.member(LA(1)))
					&& (_tokenSet_14.member(LA(2)))) {
				constantIdentifier();
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}
		}
	}

	public final void parameterList() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case IDENT:
		case END:
		case RETURN:
		case DEFINE:
		case RUN:
		case LET:
		case CALL:
		case GOTO:
		case PREPARE:
		case IF:
		case WHILE:
		case FOR:
		case FOREACH:
		case CASE:
		case SLEEP:
		case CONSTRUCT:
		case DISPLAY:
		case INPUT:
		case MENU:
		case EXIT:
		case CONTINUE:
		case ALLOCATE:
		case LOCATE:
		case DEALLOCATE:
		case RESIZE:
		case FREE:
		case INITIALIZE:
		case VALIDATE:
		case START:
		case TERMINATE:
		case FINISH:
		case PAUSE:
		case NEED:
		case PRINT:
		case SKIP:
		case OUTPUT:
		case NEXT:
		case ERROR:
		case MESSAGE:
		case PROMPT:
		case INSERT:
		case DELETE:
		case SHOW:
		case HIDE:
		case ORDER:
		case OPTIONS:
		case CLEAR:
		case CLOSE:
		case CURRENT:
		case OPEN:
		case SCROLL:
		case DECLARE:
		case UPDATE:
		case FETCH:
		case FLUSH:
		case PUT:
		case DROP:
		case CREATE:
		case LOCK:
		case SELECT:
		case LOAD:
		case UNLOAD:
		case SET:
		case EXECUTE:
		case DATABASE:
		case BEGIN:
		case COMMIT:
		case ROLLBACK:
		case WHENEVER:
		case FORMAT: {
			empty();
			break;
		}
		case LPAREN: {
			match(LPAREN);
			{
				_loop23: do {
					if ((LA(1) == IDENT)) {
						parameterGroup();
					} else {
						break _loop23;
					}

				} while (true);
			}
			match(RPAREN);
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void empty() throws RecognitionException, TokenStreamException {

	}

	public final void parameterGroup() throws RecognitionException,
			TokenStreamException {

		identifier();
		{
			_loop26: do {
				if ((LA(1) == COMMA)) {
					match(COMMA);
					identifier();
				} else {
					break _loop26;
				}

			} while (true);
		}
	}

	public final void string() throws RecognitionException,
			TokenStreamException {

		match(STRING_LITERAL);
	}

	public final void typeDeclaration() throws RecognitionException,
			TokenStreamException {

		match(DEFINE);
		variableDeclaration();
		{
			_loop34: do {
				if ((LA(1) == COMMA)) {
					match(COMMA);
					variableDeclaration();
				} else {
					break _loop34;
				}

			} while (true);
		}
	}

	public final void variableDeclaration() throws RecognitionException,
			TokenStreamException {

		if ((_tokenSet_5.member(LA(1))) && (_tokenSet_15.member(LA(2)))) {
			constantIdentifier();
			{
				_loop37: do {
					if ((LA(1) == COMMA)) {
						match(COMMA);
						constantIdentifier();
					} else {
						break _loop37;
					}

				} while (true);
			}
			type();
		} else if ((_tokenSet_5.member(LA(1))) && (_tokenSet_16.member(LA(2)))) {
			constantIdentifier();
			type();
			{
				_loop39: do {
					if ((LA(1) == COMMA) && (_tokenSet_5.member(LA(2)))) {
						match(COMMA);
						constantIdentifier();
						type();
					} else {
						break _loop39;
					}

				} while (true);
			}
		} else {
			throw new NoViableAltException(LT(1), getFilename());
		}

	}

	public final void constantIdentifier() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case ACCEPT: {
			match(ACCEPT);
			break;
		}
		case ASCII: {
			match(ASCII);
			break;
		}
		case COUNT: {
			match(COUNT);
			break;
		}
		case CURRENT: {
			match(CURRENT);
			break;
		}
		case FALSE: {
			match(FALSE);
			break;
		}
		case FIRST: {
			match(FIRST);
			break;
		}
		case FOUND: {
			match(FOUND);
			break;
		}
		case GROUP: {
			match(GROUP);
			break;
		}
		case HIDE: {
			match(HIDE);
			break;
		}
		case INDEX: {
			match(INDEX);
			break;
		}
		case INT_FLAG: {
			match(INT_FLAG);
			break;
		}
		case INTERRUPT: {
			match(INTERRUPT);
			break;
		}
		case LAST: {
			match(LAST);
			break;
		}
		case LENGTH: {
			match(LENGTH);
			break;
		}
		case LINENO: {
			match(LINENO);
			break;
		}
		case MDY: {
			match(MDY);
			break;
		}
		case NO: {
			match(NO);
			break;
		}
		case NOT: {
			match(NOT);
			break;
		}
		case NOTFOUND: {
			match(NOTFOUND);
			break;
		}
		case NULL: {
			match(NULL);
			break;
		}
		case PAGENO: {
			match(PAGENO);
			break;
		}
		case REAL: {
			match(REAL);
			break;
		}
		case SIZE: {
			match(SIZE);
			break;
		}
		case SQL: {
			match(SQL);
			break;
		}
		case STATUS: {
			match(STATUS);
			break;
		}
		case TEMP: {
			match(TEMP);
			break;
		}
		case TIME: {
			match(TIME);
			break;
		}
		case TODAY: {
			match(TODAY);
			break;
		}
		case TRUE: {
			match(TRUE);
			break;
		}
		case USER: {
			match(USER);
			break;
		}
		case WAIT: {
			match(WAIT);
			break;
		}
		case WEEKDAY: {
			match(WEEKDAY);
			break;
		}
		case WORK: {
			match(WORK);
			break;
		}
		case IDENT: {
			identifier();
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void type() throws RecognitionException, TokenStreamException {

		switch (LA(1)) {
		case BIGINT:
		case INTEGER:
		case INT:
		case SMALLINT:
		case REAL:
		case SMALLFLOAT:
		case DECIMAL:
		case DEC:
		case NUMERIC:
		case MONEY:
		case FLOAT:
		case DOUBLE:
		case VARCHAR:
		case NVARCHAR:
		case CHAR:
		case NCHAR:
		case CHARACTER:
		case DATE:
		case DATETIME:
		case INTERVAL: {
			typeIdentifier();
			break;
		}
		case LIKE: {
			indirectType();
			break;
		}
		case ASSOCIATE: {
			associateType();
			break;
		}
		case TEXT:
		case BYTE: {
			largeType();
			break;
		}
		case RECORD:
		case ARRAY:
		case DYNAMIC: {
			structuredType();
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void typeIdentifier() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case VARCHAR:
		case NVARCHAR:
		case CHAR:
		case NCHAR:
		case CHARACTER: {
			charType();
			break;
		}
		case BIGINT:
		case INTEGER:
		case INT:
		case SMALLINT:
		case REAL:
		case SMALLFLOAT:
		case DECIMAL:
		case DEC:
		case NUMERIC:
		case MONEY:
		case FLOAT:
		case DOUBLE: {
			numberType();
			break;
		}
		case DATE:
		case DATETIME:
		case INTERVAL: {
			timeType();
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void indirectType() throws RecognitionException,
			TokenStreamException {

		match(LIKE);
		tableIdentifier();
		match(DOT);
		identifier();
	}

	public final void associateType() throws RecognitionException,
			TokenStreamException {

		match(ASSOCIATE);
		type();
		match(WITH);
		type();
	}

	public final void largeType() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case TEXT: {
			match(TEXT);
			break;
		}
		case BYTE: {
			match(BYTE);
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void structuredType() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case RECORD: {
			recordType();
			break;
		}
		case ARRAY: {
			arrayType();
			break;
		}
		case DYNAMIC: {
			dynArrayType();
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void tableIdentifier() throws RecognitionException,
			TokenStreamException {

		tableQualifier();
		constantIdentifier();
	}

	public final void charType() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case VARCHAR:
		case NVARCHAR: {
			{
				switch (LA(1)) {
				case VARCHAR: {
					match(VARCHAR);
					break;
				}
				case NVARCHAR: {
					match(NVARCHAR);
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(LPAREN);
			numericConstant();
			{
				switch (LA(1)) {
				case COMMA: {
					match(COMMA);
					numericConstant();
					break;
				}
				case RPAREN: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(RPAREN);
			break;
		}
		case CHAR:
		case NCHAR:
		case CHARACTER: {
			{
				switch (LA(1)) {
				case CHAR: {
					match(CHAR);
					break;
				}
				case NCHAR: {
					match(NCHAR);
					break;
				}
				case CHARACTER: {
					match(CHARACTER);
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			{
				switch (LA(1)) {
				case LPAREN: {
					match(LPAREN);
					numericConstant();
					match(RPAREN);
					break;
				}
				case EOF:
				case IDENT:
				case MAIN:
				case END:
				case DEFER:
				case RETURN:
				case FUNCTION:
				case RPAREN:
				case COMMA:
				case DEFINE:
				case WITH:
				case RUN:
				case LET:
				case CALL:
				case GOTO:
				case NOT:
				case PREPARE:
				case IF:
				case WHILE:
				case FOR:
				case FOREACH:
				case CASE:
				case SLEEP:
				case CONSTRUCT:
				case DISPLAY:
				case INPUT:
				case MENU:
				case REPORT:
				case EXIT:
				case CONTINUE:
				case ALLOCATE:
				case LOCATE:
				case DEALLOCATE:
				case RESIZE:
				case FREE:
				case INITIALIZE:
				case VALIDATE:
				case START:
				case TERMINATE:
				case FINISH:
				case PAUSE:
				case NEED:
				case PRINT:
				case SKIP:
				case OUTPUT:
				case NEXT:
				case ERROR:
				case MESSAGE:
				case PROMPT:
				case INSERT:
				case DELETE:
				case SHOW:
				case HIDE:
				case ORDER:
				case OPTIONS:
				case CLEAR:
				case CLOSE:
				case CURRENT:
				case OPEN:
				case SCROLL:
				case DECLARE:
				case UPDATE:
				case FETCH:
				case FLUSH:
				case PUT:
				case DROP:
				case CREATE:
				case LOCK:
				case SELECT:
				case LOAD:
				case UNLOAD:
				case SET:
				case EXECUTE:
				case DATABASE:
				case BEGIN:
				case COMMIT:
				case ROLLBACK:
				case WHENEVER:
				case FORMAT: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void numberType() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case BIGINT: {
			match(BIGINT);
			break;
		}
		case INTEGER: {
			match(INTEGER);
			break;
		}
		case INT: {
			match(INT);
			break;
		}
		case SMALLINT: {
			match(SMALLINT);
			break;
		}
		case REAL: {
			match(REAL);
			break;
		}
		case SMALLFLOAT: {
			match(SMALLFLOAT);
			break;
		}
		case DECIMAL:
		case DEC:
		case NUMERIC:
		case MONEY: {
			{
				switch (LA(1)) {
				case DECIMAL: {
					match(DECIMAL);
					break;
				}
				case DEC: {
					match(DEC);
					break;
				}
				case NUMERIC: {
					match(NUMERIC);
					break;
				}
				case MONEY: {
					match(MONEY);
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			{
				switch (LA(1)) {
				case LPAREN: {
					match(LPAREN);
					numericConstant();
					{
						switch (LA(1)) {
						case COMMA: {
							match(COMMA);
							numericConstant();
							break;
						}
						case RPAREN: {
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
					match(RPAREN);
					break;
				}
				case EOF:
				case IDENT:
				case MAIN:
				case END:
				case DEFER:
				case RETURN:
				case FUNCTION:
				case RPAREN:
				case COMMA:
				case DEFINE:
				case WITH:
				case RUN:
				case LET:
				case CALL:
				case GOTO:
				case NOT:
				case PREPARE:
				case IF:
				case WHILE:
				case FOR:
				case FOREACH:
				case CASE:
				case SLEEP:
				case CONSTRUCT:
				case DISPLAY:
				case INPUT:
				case MENU:
				case REPORT:
				case EXIT:
				case CONTINUE:
				case ALLOCATE:
				case LOCATE:
				case DEALLOCATE:
				case RESIZE:
				case FREE:
				case INITIALIZE:
				case VALIDATE:
				case START:
				case TERMINATE:
				case FINISH:
				case PAUSE:
				case NEED:
				case PRINT:
				case SKIP:
				case OUTPUT:
				case NEXT:
				case ERROR:
				case MESSAGE:
				case PROMPT:
				case INSERT:
				case DELETE:
				case SHOW:
				case HIDE:
				case ORDER:
				case OPTIONS:
				case CLEAR:
				case CLOSE:
				case CURRENT:
				case OPEN:
				case SCROLL:
				case DECLARE:
				case UPDATE:
				case FETCH:
				case FLUSH:
				case PUT:
				case DROP:
				case CREATE:
				case LOCK:
				case SELECT:
				case LOAD:
				case UNLOAD:
				case SET:
				case EXECUTE:
				case DATABASE:
				case BEGIN:
				case COMMIT:
				case ROLLBACK:
				case WHENEVER:
				case FORMAT: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			break;
		}
		case FLOAT:
		case DOUBLE: {
			{
				switch (LA(1)) {
				case FLOAT: {
					match(FLOAT);
					break;
				}
				case DOUBLE: {
					match(DOUBLE);
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			{
				switch (LA(1)) {
				case LPAREN: {
					match(LPAREN);
					numericConstant();
					match(RPAREN);
					break;
				}
				case EOF:
				case IDENT:
				case MAIN:
				case END:
				case DEFER:
				case RETURN:
				case FUNCTION:
				case RPAREN:
				case COMMA:
				case DEFINE:
				case WITH:
				case RUN:
				case LET:
				case CALL:
				case GOTO:
				case NOT:
				case PREPARE:
				case IF:
				case WHILE:
				case FOR:
				case FOREACH:
				case CASE:
				case SLEEP:
				case CONSTRUCT:
				case DISPLAY:
				case INPUT:
				case MENU:
				case REPORT:
				case EXIT:
				case CONTINUE:
				case ALLOCATE:
				case LOCATE:
				case DEALLOCATE:
				case RESIZE:
				case FREE:
				case INITIALIZE:
				case VALIDATE:
				case START:
				case TERMINATE:
				case FINISH:
				case PAUSE:
				case NEED:
				case PRINT:
				case SKIP:
				case OUTPUT:
				case NEXT:
				case ERROR:
				case MESSAGE:
				case PROMPT:
				case INSERT:
				case DELETE:
				case SHOW:
				case HIDE:
				case ORDER:
				case OPTIONS:
				case CLEAR:
				case CLOSE:
				case CURRENT:
				case OPEN:
				case SCROLL:
				case DECLARE:
				case UPDATE:
				case FETCH:
				case FLUSH:
				case PUT:
				case DROP:
				case CREATE:
				case LOCK:
				case SELECT:
				case LOAD:
				case UNLOAD:
				case SET:
				case EXECUTE:
				case DATABASE:
				case BEGIN:
				case COMMIT:
				case ROLLBACK:
				case WHENEVER:
				case FORMAT: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void timeType() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case DATE: {
			match(DATE);
			break;
		}
		case DATETIME: {
			match(DATETIME);
			datetimeQualifier();
			break;
		}
		case INTERVAL: {
			match(INTERVAL);
			intervalQualifier();
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void numericConstant() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case NUM_INT:
		case NUM_REAL: {
			unsignedNumber();
			break;
		}
		case PLUS:
		case MINUS: {
			sign();
			unsignedNumber();
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void datetimeQualifier() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case YEAR: {
			match(YEAR);
			match(TO);
			yearQualifier();
			break;
		}
		case MONTH: {
			match(MONTH);
			match(TO);
			monthQualifier();
			break;
		}
		case DAY: {
			match(DAY);
			match(TO);
			dayQualifier();
			break;
		}
		case HOUR: {
			match(HOUR);
			match(TO);
			hourQualifier();
			break;
		}
		case MINUTE: {
			match(MINUTE);
			match(TO);
			minuteQualifier();
			break;
		}
		case SECOND: {
			match(SECOND);
			match(TO);
			secondQualifier();
			break;
		}
		case FRACTION: {
			match(FRACTION);
			match(TO);
			fractionQualifier();
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void intervalQualifier() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case YEAR: {
			match(YEAR);
			{
				switch (LA(1)) {
				case LPAREN: {
					match(LPAREN);
					numericConstant();
					match(RPAREN);
					break;
				}
				case TO: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(TO);
			yearQualifier();
			break;
		}
		case MONTH: {
			match(MONTH);
			{
				switch (LA(1)) {
				case LPAREN: {
					match(LPAREN);
					numericConstant();
					match(RPAREN);
					break;
				}
				case TO: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(TO);
			monthQualifier();
			break;
		}
		case DAY: {
			match(DAY);
			{
				switch (LA(1)) {
				case LPAREN: {
					match(LPAREN);
					numericConstant();
					match(RPAREN);
					break;
				}
				case TO: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(TO);
			dayQualifier();
			break;
		}
		case HOUR: {
			match(HOUR);
			{
				switch (LA(1)) {
				case LPAREN: {
					match(LPAREN);
					numericConstant();
					match(RPAREN);
					break;
				}
				case TO: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(TO);
			hourQualifier();
			break;
		}
		case MINUTE: {
			match(MINUTE);
			{
				switch (LA(1)) {
				case LPAREN: {
					match(LPAREN);
					numericConstant();
					match(RPAREN);
					break;
				}
				case TO: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(TO);
			minuteQualifier();
			break;
		}
		case SECOND: {
			match(SECOND);
			{
				switch (LA(1)) {
				case LPAREN: {
					match(LPAREN);
					numericConstant();
					match(RPAREN);
					break;
				}
				case TO: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(TO);
			secondQualifier();
			break;
		}
		case FRACTION: {
			match(FRACTION);
			match(TO);
			fractionQualifier();
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void yearQualifier() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case YEAR: {
			match(YEAR);
			break;
		}
		case MONTH:
		case DAY:
		case HOUR:
		case MINUTE:
		case SECOND:
		case FRACTION: {
			monthQualifier();
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void monthQualifier() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case MONTH: {
			match(MONTH);
			break;
		}
		case DAY:
		case HOUR:
		case MINUTE:
		case SECOND:
		case FRACTION: {
			dayQualifier();
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void dayQualifier() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case DAY: {
			match(DAY);
			break;
		}
		case HOUR:
		case MINUTE:
		case SECOND:
		case FRACTION: {
			hourQualifier();
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void hourQualifier() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case HOUR: {
			match(HOUR);
			break;
		}
		case MINUTE:
		case SECOND:
		case FRACTION: {
			minuteQualifier();
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void minuteQualifier() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case MINUTE: {
			match(MINUTE);
			break;
		}
		case SECOND:
		case FRACTION: {
			secondQualifier();
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void secondQualifier() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case SECOND: {
			match(SECOND);
			break;
		}
		case FRACTION: {
			fractionQualifier();
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void fractionQualifier() throws RecognitionException,
			TokenStreamException {

		match(FRACTION);
		{
			if ((LA(1) == LPAREN) && (_tokenSet_17.member(LA(2)))) {
				match(LPAREN);
				numericConstant();
				match(RPAREN);
			} else if ((_tokenSet_18.member(LA(1)))
					&& (_tokenSet_19.member(LA(2)))) {
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}

		}
	}

	public final void unitType() throws RecognitionException,
			TokenStreamException {

		yearQualifier();
	}

	public final void recordType() throws RecognitionException,
			TokenStreamException {

		match(RECORD);
		{
			switch (LA(1)) {
			case IDENT:
			case INTERRUPT:
			case REAL:
			case TRUE:
			case FALSE:
			case NOT:
			case NULL:
			case LENGTH:
			case COUNT:
			case USER:
			case GROUP:
			case TODAY:
			case WEEKDAY:
			case MDY:
			case TIME:
			case PAGENO:
			case LINENO:
			case HIDE:
			case FIRST:
			case LAST:
			case NO:
			case ACCEPT:
			case SQL:
			case CURRENT:
			case TEMP:
			case SIZE:
			case INDEX:
			case WAIT:
			case WORK:
			case FOUND:
			case ASCII:
			case INT_FLAG:
			case NOTFOUND:
			case STATUS: {
				eol();
				{
					variableDeclaration();
					{
						_loop79: do {
							if ((LA(1) == COMMA)) {
								match(COMMA);
								variableDeclaration();
							} else {
								break _loop79;
							}

						} while (true);
					}
				}
				match(END);
				match(RECORD);
				break;
			}
			case LIKE: {
				{
					match(LIKE);
					tableIdentifier();
					match(DOT);
					match(STAR);
				}
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
	}

	public final void arrayType() throws RecognitionException,
			TokenStreamException {

		match(ARRAY);
		arrayIndexer();
		match(OF);
		{
			switch (LA(1)) {
			case RECORD: {
				recordType();
				break;
			}
			case BIGINT:
			case INTEGER:
			case INT:
			case SMALLINT:
			case REAL:
			case SMALLFLOAT:
			case DECIMAL:
			case DEC:
			case NUMERIC:
			case MONEY:
			case FLOAT:
			case DOUBLE:
			case VARCHAR:
			case NVARCHAR:
			case CHAR:
			case NCHAR:
			case CHARACTER:
			case DATE:
			case DATETIME:
			case INTERVAL: {
				typeIdentifier();
				break;
			}
			case TEXT:
			case BYTE: {
				largeType();
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
	}

	public final void dynArrayType() throws RecognitionException,
			TokenStreamException {

		match(DYNAMIC);
		match(ARRAY);
		match(WITH);
		numericConstant();
		match(DIMENSIONS);
		match(OF);
		{
			switch (LA(1)) {
			case RECORD: {
				recordType();
				break;
			}
			case BIGINT:
			case INTEGER:
			case INT:
			case SMALLINT:
			case REAL:
			case SMALLFLOAT:
			case DECIMAL:
			case DEC:
			case NUMERIC:
			case MONEY:
			case FLOAT:
			case DOUBLE:
			case VARCHAR:
			case NVARCHAR:
			case CHAR:
			case NCHAR:
			case CHARACTER:
			case DATE:
			case DATETIME:
			case INTERVAL: {
				typeIdentifier();
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
	}

	public final void arrayIndexer() throws RecognitionException,
			TokenStreamException {

		match(LBRACK);
		numericConstant();
		{
			if ((LA(1) == COMMA) && (_tokenSet_17.member(LA(2)))) {
				match(COMMA);
				numericConstant();
			} else if ((LA(1) == COMMA) && (_tokenSet_17.member(LA(2)))) {
				match(COMMA);
				numericConstant();
				match(COMMA);
				numericConstant();
			} else if ((LA(1) == RBRACK)) {
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}

		}
		match(RBRACK);
	}

	public final void statement() throws RecognitionException,
			TokenStreamException {

		{
			switch (LA(1)) {
			case IDENT: {
				label();
				match(COLON);
				break;
			}
			case RETURN:
			case RUN:
			case LET:
			case CALL:
			case GOTO:
			case PREPARE:
			case IF:
			case WHILE:
			case FOR:
			case FOREACH:
			case CASE:
			case SLEEP:
			case CONSTRUCT:
			case DISPLAY:
			case INPUT:
			case MENU:
			case EXIT:
			case CONTINUE:
			case ALLOCATE:
			case LOCATE:
			case DEALLOCATE:
			case RESIZE:
			case FREE:
			case INITIALIZE:
			case VALIDATE:
			case START:
			case TERMINATE:
			case FINISH:
			case PAUSE:
			case NEED:
			case PRINT:
			case SKIP:
			case OUTPUT:
			case NEXT:
			case ERROR:
			case MESSAGE:
			case PROMPT:
			case INSERT:
			case DELETE:
			case SHOW:
			case HIDE:
			case OPTIONS:
			case CLEAR:
			case CLOSE:
			case CURRENT:
			case OPEN:
			case SCROLL:
			case DECLARE:
			case UPDATE:
			case FETCH:
			case FLUSH:
			case PUT:
			case DROP:
			case CREATE:
			case LOCK:
			case SELECT:
			case LOAD:
			case UNLOAD:
			case SET:
			case EXECUTE:
			case BEGIN:
			case COMMIT:
			case ROLLBACK:
			case WHENEVER: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		unlabelledStatement();
	}

	public final void label() throws RecognitionException, TokenStreamException {

		identifier();
	}

	public final void unlabelledStatement() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case RETURN:
		case RUN:
		case LET:
		case CALL:
		case GOTO:
		case PREPARE:
		case SLEEP:
		case CONSTRUCT:
		case DISPLAY:
		case INPUT:
		case MENU:
		case EXIT:
		case CONTINUE:
		case ALLOCATE:
		case LOCATE:
		case DEALLOCATE:
		case RESIZE:
		case FREE:
		case INITIALIZE:
		case VALIDATE:
		case START:
		case TERMINATE:
		case FINISH:
		case PAUSE:
		case NEED:
		case PRINT:
		case SKIP:
		case OUTPUT:
		case NEXT:
		case ERROR:
		case MESSAGE:
		case PROMPT:
		case INSERT:
		case DELETE:
		case SHOW:
		case HIDE:
		case OPTIONS:
		case CLEAR:
		case CLOSE:
		case CURRENT:
		case OPEN:
		case SCROLL:
		case DECLARE:
		case UPDATE:
		case FETCH:
		case FLUSH:
		case PUT:
		case DROP:
		case CREATE:
		case LOCK:
		case SELECT:
		case LOAD:
		case UNLOAD:
		case SET:
		case EXECUTE:
		case BEGIN:
		case COMMIT:
		case ROLLBACK:
		case WHENEVER: {
			simpleStatement();
			break;
		}
		case IF:
		case WHILE:
		case FOR:
		case FOREACH:
		case CASE: {
			structuredStatement();
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void simpleStatement() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case LET: {
			assignmentStatement();
			break;
		}
		case CALL: {
			procedureStatement();
			break;
		}
		default:
			if ((_tokenSet_20.member(LA(1))) && (_tokenSet_21.member(LA(2)))) {
				sqlStatements();
				{
					switch (LA(1)) {
					case SEMI: {
						match(SEMI);
						break;
					}
					case IDENT:
					case END:
					case DEFER:
					case RETURN:
					case RUN:
					case LET:
					case CALL:
					case GOTO:
					case PREPARE:
					case IF:
					case ELSE:
					case WHILE:
					case FOR:
					case FOREACH:
					case CASE:
					case WHEN:
					case OTHERWISE:
					case SLEEP:
					case CONSTRUCT:
					case DISPLAY:
					case INPUT:
					case MENU:
					case EXIT:
					case CONTINUE:
					case ALLOCATE:
					case LOCATE:
					case DEALLOCATE:
					case RESIZE:
					case FREE:
					case INITIALIZE:
					case VALIDATE:
					case START:
					case PAGE:
					case TERMINATE:
					case FINISH:
					case PAUSE:
					case NEED:
					case PRINT:
					case SKIP:
					case OUTPUT:
					case BEFORE:
					case AFTER:
					case ON:
					case NEXT:
					case ERROR:
					case MESSAGE:
					case PROMPT:
					case INSERT:
					case DELETE:
					case COMMAND:
					case SHOW:
					case HIDE:
					case FIRST:
					case OPTIONS:
					case CLEAR:
					case CLOSE:
					case CURRENT:
					case OPEN:
					case SCROLL:
					case DECLARE:
					case UPDATE:
					case FETCH:
					case FLUSH:
					case PUT:
					case DROP:
					case CREATE:
					case LOCK:
					case SELECT:
					case LOAD:
					case UNLOAD:
					case SET:
					case EXECUTE:
					case DATABASE:
					case BEGIN:
					case COMMIT:
					case ROLLBACK:
					case WHENEVER: {
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
			} else if ((_tokenSet_22.member(LA(1)))
					&& (_tokenSet_23.member(LA(2)))) {
				otherFGLStatement();
			} else if ((_tokenSet_24.member(LA(1)))
					&& (LA(2) == MENU || LA(2) == OPTION)) {
				menuInsideStatement();
			} else if ((_tokenSet_25.member(LA(1)))
					&& (LA(2) == CONSTRUCT || LA(2) == FIELD)) {
				constructInsideStatement();
			} else if ((LA(1) == EXIT || LA(1) == CONTINUE)
					&& (LA(2) == DISPLAY)) {
				displayInsideStatement();
			} else if ((_tokenSet_25.member(LA(1)))
					&& (LA(2) == INPUT || LA(2) == FIELD)) {
				inputInsideStatement();
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}
		}
	}

	public final void structuredStatement() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case IF:
		case CASE: {
			conditionalStatement();
			break;
		}
		case WHILE:
		case FOR:
		case FOREACH: {
			repetetiveStatement();
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void assignmentStatement() throws RecognitionException,
			TokenStreamException {

		match(LET);
		variable();
		match(EQUAL);
		expression();
		{
			_loop103: do {
				if ((LA(1) == COMMA)) {
					match(COMMA);
					expression();
				} else {
					break _loop103;
				}

			} while (true);
		}
	}

	public final void procedureStatement() throws RecognitionException,
			TokenStreamException {

		match(CALL);
		procedureIdentifier();
		{
			switch (LA(1)) {
			case LPAREN: {
				match(LPAREN);
				{
					switch (LA(1)) {
					case IDENT:
					case INTERRUPT:
					case LPAREN:
					case REAL:
					case DATE:
					case YEAR:
					case MONTH:
					case DAY:
					case STAR:
					case STRING_LITERAL:
					case TRUE:
					case FALSE:
					case NOT:
					case NULL:
					case PLUS:
					case MINUS:
					case LENGTH:
					case AVG:
					case COUNT:
					case MAX:
					case MIN:
					case SUM:
					case USER:
					case GROUP:
					case TODAY:
					case WEEKDAY:
					case MDY:
					case COLUMN:
					case EXTEND:
					case TIME:
					case INFIELD:
					case PREPARE:
					case PAGENO:
					case LINENO:
					case HIDE:
					case FIRST:
					case LAST:
					case NO:
					case ACCEPT:
					case SQL:
					case CURRENT:
					case TEMP:
					case SIZE:
					case INDEX:
					case WAIT:
					case WORK:
					case FOUND:
					case NUM_INT:
					case NUM_REAL:
					case ASCII:
					case INT_FLAG:
					case NOTFOUND:
					case STATUS: {
						actualParameter();
						{
							_loop108: do {
								if ((LA(1) == COMMA)) {
									match(COMMA);
									actualParameter();
								} else {
									break _loop108;
								}

							} while (true);
						}
						break;
					}
					case RPAREN: {
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
				match(RPAREN);
				break;
			}
			case IDENT:
			case END:
			case DEFER:
			case RETURN:
			case RUN:
			case RETURNING:
			case LET:
			case CALL:
			case GOTO:
			case PREPARE:
			case IF:
			case ELSE:
			case WHILE:
			case FOR:
			case FOREACH:
			case CASE:
			case WHEN:
			case OTHERWISE:
			case SLEEP:
			case CONSTRUCT:
			case DISPLAY:
			case INPUT:
			case MENU:
			case EXIT:
			case CONTINUE:
			case ALLOCATE:
			case LOCATE:
			case DEALLOCATE:
			case RESIZE:
			case FREE:
			case INITIALIZE:
			case VALIDATE:
			case START:
			case PAGE:
			case TERMINATE:
			case FINISH:
			case PAUSE:
			case NEED:
			case PRINT:
			case SKIP:
			case OUTPUT:
			case BEFORE:
			case AFTER:
			case ON:
			case NEXT:
			case ERROR:
			case MESSAGE:
			case PROMPT:
			case INSERT:
			case DELETE:
			case COMMAND:
			case SHOW:
			case HIDE:
			case FIRST:
			case OPTIONS:
			case CLEAR:
			case CLOSE:
			case CURRENT:
			case OPEN:
			case SCROLL:
			case DECLARE:
			case UPDATE:
			case FETCH:
			case FLUSH:
			case PUT:
			case DROP:
			case CREATE:
			case LOCK:
			case SELECT:
			case LOAD:
			case UNLOAD:
			case SET:
			case EXECUTE:
			case DATABASE:
			case BEGIN:
			case COMMIT:
			case ROLLBACK:
			case WHENEVER: {
				empty();
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		{
			switch (LA(1)) {
			case RETURNING: {
				match(RETURNING);
				variable();
				{
					_loop111: do {
						if ((LA(1) == COMMA)) {
							match(COMMA);
							variable();
						} else {
							break _loop111;
						}

					} while (true);
				}
				break;
			}
			case IDENT:
			case END:
			case DEFER:
			case RETURN:
			case RUN:
			case LET:
			case CALL:
			case GOTO:
			case PREPARE:
			case IF:
			case ELSE:
			case WHILE:
			case FOR:
			case FOREACH:
			case CASE:
			case WHEN:
			case OTHERWISE:
			case SLEEP:
			case CONSTRUCT:
			case DISPLAY:
			case INPUT:
			case MENU:
			case EXIT:
			case CONTINUE:
			case ALLOCATE:
			case LOCATE:
			case DEALLOCATE:
			case RESIZE:
			case FREE:
			case INITIALIZE:
			case VALIDATE:
			case START:
			case PAGE:
			case TERMINATE:
			case FINISH:
			case PAUSE:
			case NEED:
			case PRINT:
			case SKIP:
			case OUTPUT:
			case BEFORE:
			case AFTER:
			case ON:
			case NEXT:
			case ERROR:
			case MESSAGE:
			case PROMPT:
			case INSERT:
			case DELETE:
			case COMMAND:
			case SHOW:
			case HIDE:
			case FIRST:
			case OPTIONS:
			case CLEAR:
			case CLOSE:
			case CURRENT:
			case OPEN:
			case SCROLL:
			case DECLARE:
			case UPDATE:
			case FETCH:
			case FLUSH:
			case PUT:
			case DROP:
			case CREATE:
			case LOCK:
			case SELECT:
			case LOAD:
			case UNLOAD:
			case SET:
			case EXECUTE:
			case DATABASE:
			case BEGIN:
			case COMMIT:
			case ROLLBACK:
			case WHENEVER: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
	}

	public final void sqlStatements() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case DROP:
		case CREATE: {
			dataDefinitionStatement();
			break;
		}
		case PREPARE:
		case FREE:
		case LOCK:
		case EXECUTE: {
			dynamicManagementStatement();
			break;
		}
		case BEGIN:
		case COMMIT:
		case ROLLBACK:
		case WHENEVER: {
			dataIntegrityStatement();
			break;
		}
		default:
			if ((_tokenSet_26.member(LA(1))) && (_tokenSet_27.member(LA(2)))) {
				cursorManipulationStatement();
			} else if ((_tokenSet_28.member(LA(1)))
					&& (_tokenSet_29.member(LA(2)))) {
				dataManipulationStatement();
			} else if ((LA(1) == UPDATE || LA(1) == SET)
					&& (_tokenSet_30.member(LA(2)))) {
				queryOptimizationStatement();
			} else if ((LA(1) == CLOSE) && (LA(2) == DATABASE)) {
				clientServerStatement();
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}
		}
	}

	public final void otherFGLStatement() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case RETURN:
		case RUN:
		case GOTO:
		case SLEEP:
		case EXIT:
		case CONTINUE: {
			otherProgramFlowStatement();
			break;
		}
		case ALLOCATE:
		case LOCATE:
		case DEALLOCATE:
		case RESIZE:
		case FREE:
		case INITIALIZE:
		case VALIDATE: {
			otherStorageStatement();
			break;
		}
		case START:
		case TERMINATE:
		case FINISH:
		case PAUSE:
		case NEED:
		case PRINT:
		case SKIP:
		case OUTPUT: {
			reportStatement();
			break;
		}
		case CONSTRUCT:
		case DISPLAY:
		case INPUT:
		case MENU:
		case ERROR:
		case MESSAGE:
		case PROMPT:
		case OPTIONS:
		case CLEAR:
		case CLOSE:
		case CURRENT:
		case OPEN:
		case SCROLL: {
			screenStatement();
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void menuInsideStatement() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case NEXT: {
			match(NEXT);
			match(OPTION);
			{
				switch (LA(1)) {
				case IDENT:
				case INTERRUPT:
				case LPAREN:
				case REAL:
				case DATE:
				case YEAR:
				case MONTH:
				case DAY:
				case STRING_LITERAL:
				case TRUE:
				case FALSE:
				case NOT:
				case NULL:
				case PLUS:
				case MINUS:
				case LENGTH:
				case AVG:
				case COUNT:
				case MAX:
				case MIN:
				case SUM:
				case USER:
				case GROUP:
				case TODAY:
				case WEEKDAY:
				case MDY:
				case COLUMN:
				case EXTEND:
				case TIME:
				case INFIELD:
				case PREPARE:
				case PAGENO:
				case LINENO:
				case HIDE:
				case FIRST:
				case LAST:
				case NO:
				case ACCEPT:
				case SQL:
				case CURRENT:
				case TEMP:
				case SIZE:
				case INDEX:
				case WAIT:
				case WORK:
				case FOUND:
				case NUM_INT:
				case NUM_REAL:
				case ASCII:
				case INT_FLAG:
				case NOTFOUND:
				case STATUS: {
					expression();
					break;
				}
				case ALL: {
					match(ALL);
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			{
				_loop486: do {
					if ((LA(1) == COMMA)) {
						match(COMMA);
						expression();
					} else {
						break _loop486;
					}

				} while (true);
			}
			break;
		}
		case SHOW: {
			match(SHOW);
			match(OPTION);
			{
				switch (LA(1)) {
				case IDENT:
				case INTERRUPT:
				case LPAREN:
				case REAL:
				case DATE:
				case YEAR:
				case MONTH:
				case DAY:
				case STRING_LITERAL:
				case TRUE:
				case FALSE:
				case NOT:
				case NULL:
				case PLUS:
				case MINUS:
				case LENGTH:
				case AVG:
				case COUNT:
				case MAX:
				case MIN:
				case SUM:
				case USER:
				case GROUP:
				case TODAY:
				case WEEKDAY:
				case MDY:
				case COLUMN:
				case EXTEND:
				case TIME:
				case INFIELD:
				case PREPARE:
				case PAGENO:
				case LINENO:
				case HIDE:
				case FIRST:
				case LAST:
				case NO:
				case ACCEPT:
				case SQL:
				case CURRENT:
				case TEMP:
				case SIZE:
				case INDEX:
				case WAIT:
				case WORK:
				case FOUND:
				case NUM_INT:
				case NUM_REAL:
				case ASCII:
				case INT_FLAG:
				case NOTFOUND:
				case STATUS: {
					expression();
					break;
				}
				case ALL: {
					match(ALL);
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			{
				_loop489: do {
					if ((LA(1) == COMMA)) {
						match(COMMA);
						expression();
					} else {
						break _loop489;
					}

				} while (true);
			}
			break;
		}
		case HIDE: {
			match(HIDE);
			match(OPTION);
			{
				switch (LA(1)) {
				case IDENT:
				case INTERRUPT:
				case LPAREN:
				case REAL:
				case DATE:
				case YEAR:
				case MONTH:
				case DAY:
				case STRING_LITERAL:
				case TRUE:
				case FALSE:
				case NOT:
				case NULL:
				case PLUS:
				case MINUS:
				case LENGTH:
				case AVG:
				case COUNT:
				case MAX:
				case MIN:
				case SUM:
				case USER:
				case GROUP:
				case TODAY:
				case WEEKDAY:
				case MDY:
				case COLUMN:
				case EXTEND:
				case TIME:
				case INFIELD:
				case PREPARE:
				case PAGENO:
				case LINENO:
				case HIDE:
				case FIRST:
				case LAST:
				case NO:
				case ACCEPT:
				case SQL:
				case CURRENT:
				case TEMP:
				case SIZE:
				case INDEX:
				case WAIT:
				case WORK:
				case FOUND:
				case NUM_INT:
				case NUM_REAL:
				case ASCII:
				case INT_FLAG:
				case NOTFOUND:
				case STATUS: {
					expression();
					break;
				}
				case ALL: {
					match(ALL);
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			{
				_loop492: do {
					if ((LA(1) == COMMA)) {
						match(COMMA);
						expression();
					} else {
						break _loop492;
					}

				} while (true);
			}
			break;
		}
		case CONTINUE: {
			match(CONTINUE);
			match(MENU);
			break;
		}
		case EXIT: {
			match(EXIT);
			match(MENU);
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void constructInsideStatement() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case NEXT: {
			match(NEXT);
			match(FIELD);
			{
				switch (LA(1)) {
				case IDENT: {
					fieldName();
					break;
				}
				case NEXT: {
					match(NEXT);
					break;
				}
				case PREVIOUS: {
					match(PREVIOUS);
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			eol();
			break;
		}
		case CONTINUE: {
			match(CONTINUE);
			match(CONSTRUCT);
			eol();
			break;
		}
		case EXIT: {
			match(EXIT);
			match(CONSTRUCT);
			eol();
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void displayInsideStatement() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case CONTINUE: {
			match(CONTINUE);
			match(DISPLAY);
			break;
		}
		case EXIT: {
			match(EXIT);
			match(DISPLAY);
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void inputInsideStatement() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case NEXT: {
			match(NEXT);
			match(FIELD);
			{
				switch (LA(1)) {
				case IDENT: {
					fieldName();
					break;
				}
				case NEXT: {
					match(NEXT);
					break;
				}
				case PREVIOUS: {
					match(PREVIOUS);
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			break;
		}
		case CONTINUE: {
			match(CONTINUE);
			match(INPUT);
			break;
		}
		case EXIT: {
			match(EXIT);
			match(INPUT);
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void runStatement() throws RecognitionException,
			TokenStreamException {

		match(RUN);
		{
			switch (LA(1)) {
			case IDENT:
			case INTERRUPT:
			case REAL:
			case TRUE:
			case FALSE:
			case NOT:
			case NULL:
			case LENGTH:
			case COUNT:
			case USER:
			case GROUP:
			case TODAY:
			case WEEKDAY:
			case MDY:
			case TIME:
			case PAGENO:
			case LINENO:
			case HIDE:
			case FIRST:
			case LAST:
			case NO:
			case ACCEPT:
			case SQL:
			case CURRENT:
			case TEMP:
			case SIZE:
			case INDEX:
			case WAIT:
			case WORK:
			case FOUND:
			case ASCII:
			case INT_FLAG:
			case NOTFOUND:
			case STATUS: {
				variable();
				break;
			}
			case STRING_LITERAL: {
				string();
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		{
			if ((LA(1) == IN) && (LA(2) == FORM)) {
				match(IN);
				match(FORM);
				match(MODE);
			} else if ((LA(1) == IN) && (LA(2) == LINE)) {
				match(IN);
				match(LINE);
				match(MODE);
			} else if ((_tokenSet_31.member(LA(1)))) {
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}

		}
		{
			switch (LA(1)) {
			case WITHOUT: {
				match(WITHOUT);
				match(WAITING);
				break;
			}
			case RETURNING: {
				match(RETURNING);
				variable();
				break;
			}
			case IDENT:
			case END:
			case DEFER:
			case RETURN:
			case RUN:
			case LET:
			case CALL:
			case GOTO:
			case PREPARE:
			case IF:
			case ELSE:
			case WHILE:
			case FOR:
			case FOREACH:
			case CASE:
			case WHEN:
			case OTHERWISE:
			case SLEEP:
			case CONSTRUCT:
			case DISPLAY:
			case INPUT:
			case MENU:
			case EXIT:
			case CONTINUE:
			case ALLOCATE:
			case LOCATE:
			case DEALLOCATE:
			case RESIZE:
			case FREE:
			case INITIALIZE:
			case VALIDATE:
			case START:
			case PAGE:
			case TERMINATE:
			case FINISH:
			case PAUSE:
			case NEED:
			case PRINT:
			case SKIP:
			case OUTPUT:
			case BEFORE:
			case AFTER:
			case ON:
			case NEXT:
			case ERROR:
			case MESSAGE:
			case PROMPT:
			case INSERT:
			case DELETE:
			case COMMAND:
			case SHOW:
			case HIDE:
			case FIRST:
			case OPTIONS:
			case CLEAR:
			case CLOSE:
			case CURRENT:
			case OPEN:
			case SCROLL:
			case DECLARE:
			case UPDATE:
			case FETCH:
			case FLUSH:
			case PUT:
			case DROP:
			case CREATE:
			case LOCK:
			case SELECT:
			case LOAD:
			case UNLOAD:
			case SET:
			case EXECUTE:
			case DATABASE:
			case BEGIN:
			case COMMIT:
			case ROLLBACK:
			case WHENEVER: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
	}

	public final void variable() throws RecognitionException,
			TokenStreamException {

		if ((_tokenSet_5.member(LA(1))) && (_tokenSet_32.member(LA(2)))) {
			entireVariable();
		} else if ((_tokenSet_5.member(LA(1))) && (_tokenSet_33.member(LA(2)))) {
			componentVariable();
		} else {
			throw new NoViableAltException(LT(1), getFilename());
		}

	}

	public final void expression() throws RecognitionException,
			TokenStreamException {

		simpleExpression();
		{
			_loop234: do {
				switch (LA(1)) {
				case CLIPPED: {
					match(CLIPPED);
					break;
				}
				case USING: {
					match(USING);
					string();
					break;
				}
				default: {
					break _loop234;
				}
				}
			} while (true);
		}
	}

	public final void procedureIdentifier() throws RecognitionException,
			TokenStreamException {

		functionIdentifier();
	}

	public final void actualParameter() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case STAR: {
			match(STAR);
			break;
		}
		case IDENT:
		case INTERRUPT:
		case LPAREN:
		case REAL:
		case DATE:
		case YEAR:
		case MONTH:
		case DAY:
		case STRING_LITERAL:
		case TRUE:
		case FALSE:
		case NOT:
		case NULL:
		case PLUS:
		case MINUS:
		case LENGTH:
		case AVG:
		case COUNT:
		case MAX:
		case MIN:
		case SUM:
		case USER:
		case GROUP:
		case TODAY:
		case WEEKDAY:
		case MDY:
		case COLUMN:
		case EXTEND:
		case TIME:
		case INFIELD:
		case PREPARE:
		case PAGENO:
		case LINENO:
		case HIDE:
		case FIRST:
		case LAST:
		case NO:
		case ACCEPT:
		case SQL:
		case CURRENT:
		case TEMP:
		case SIZE:
		case INDEX:
		case WAIT:
		case WORK:
		case FOUND:
		case NUM_INT:
		case NUM_REAL:
		case ASCII:
		case INT_FLAG:
		case NOTFOUND:
		case STATUS: {
			expression();
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void gotoStatement() throws RecognitionException,
			TokenStreamException {

		match(GOTO);
		{
			switch (LA(1)) {
			case COLON: {
				match(COLON);
				break;
			}
			case IDENT: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		label();
		eol();
	}

	public final void condition() throws RecognitionException,
			TokenStreamException {

		if ((LA(1) == TRUE) && (_tokenSet_34.member(LA(2)))) {
			match(TRUE);
		} else if ((LA(1) == FALSE) && (_tokenSet_34.member(LA(2)))) {
			match(FALSE);
		} else if ((_tokenSet_35.member(LA(1))) && (_tokenSet_36.member(LA(2)))) {
			logicalTerm();
			{
				_loop119: do {
					if ((LA(1) == OR) && (_tokenSet_35.member(LA(2)))) {
						match(OR);
						logicalTerm();
					} else {
						break _loop119;
					}

				} while (true);
			}
		} else {
			throw new NoViableAltException(LT(1), getFilename());
		}

	}

	public final void logicalTerm() throws RecognitionException,
			TokenStreamException {

		logicalFactor();
		{
			_loop122: do {
				if ((LA(1) == AND) && (_tokenSet_35.member(LA(2)))) {
					match(AND);
					logicalFactor();
				} else {
					break _loop122;
				}

			} while (true);
		}
	}

	public final void logicalFactor() throws RecognitionException,
			TokenStreamException {

		boolean synPredMatched126 = false;
		if (((_tokenSet_37.member(LA(1))) && (_tokenSet_38.member(LA(2))))) {
			int _m126 = mark();
			synPredMatched126 = true;
			inputState.guessing++;
			try {
				{
					sqlExpression();
					{
						switch (LA(1)) {
						case NOT: {
							match(NOT);
							break;
						}
						case IN: {
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
					match(IN);
				}
			} catch (RecognitionException pe) {
				synPredMatched126 = false;
			}
			rewind(_m126);
			inputState.guessing--;
		}
		if (synPredMatched126) {
			sqlExpression();
			{
				switch (LA(1)) {
				case NOT: {
					match(NOT);
					break;
				}
				case IN: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(IN);
			expressionSet();
		} else {
			boolean synPredMatched130 = false;
			if (((_tokenSet_37.member(LA(1))) && (_tokenSet_39.member(LA(2))))) {
				int _m130 = mark();
				synPredMatched130 = true;
				inputState.guessing++;
				try {
					{
						sqlExpression();
						{
							switch (LA(1)) {
							case NOT: {
								match(NOT);
								break;
							}
							case LIKE: {
								break;
							}
							default: {
								throw new NoViableAltException(LT(1),
										getFilename());
							}
							}
						}
						match(LIKE);
					}
				} catch (RecognitionException pe) {
					synPredMatched130 = false;
				}
				rewind(_m130);
				inputState.guessing--;
			}
			if (synPredMatched130) {
				sqlExpression();
				{
					switch (LA(1)) {
					case NOT: {
						match(NOT);
						break;
					}
					case LIKE: {
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
				match(LIKE);
				sqlExpression();
				{
					switch (LA(1)) {
					case ESC: {
						match(ESC);
						match(QUOTED_STRING);
						break;
					}
					case IDENT:
					case END:
					case DEFER:
					case RETURN:
					case RPAREN:
					case WITH:
					case SEMI:
					case RUN:
					case LET:
					case CALL:
					case GOTO:
					case OR:
					case AND:
					case GROUP:
					case PREPARE:
					case IF:
					case ELSE:
					case WHILE:
					case FOR:
					case FOREACH:
					case INTO:
					case CASE:
					case WHEN:
					case OTHERWISE:
					case SLEEP:
					case CONSTRUCT:
					case DISPLAY:
					case INPUT:
					case MENU:
					case EXIT:
					case CONTINUE:
					case ALLOCATE:
					case LOCATE:
					case DEALLOCATE:
					case RESIZE:
					case FREE:
					case INITIALIZE:
					case VALIDATE:
					case START:
					case PAGE:
					case TERMINATE:
					case FINISH:
					case PAUSE:
					case NEED:
					case PRINT:
					case SKIP:
					case OUTPUT:
					case BEFORE:
					case AFTER:
					case ON:
					case NEXT:
					case ERROR:
					case MESSAGE:
					case PROMPT:
					case INSERT:
					case DELETE:
					case COMMAND:
					case SHOW:
					case HIDE:
					case FIRST:
					case ORDER:
					case OPTIONS:
					case CLEAR:
					case CLOSE:
					case CURRENT:
					case OPEN:
					case SCROLL:
					case DECLARE:
					case UPDATE:
					case FETCH:
					case FLUSH:
					case PUT:
					case DROP:
					case CREATE:
					case LOCK:
					case SELECT:
					case UNION:
					case HAVING:
					case LOAD:
					case UNLOAD:
					case SET:
					case EXECUTE:
					case DATABASE:
					case BEGIN:
					case COMMIT:
					case ROLLBACK:
					case WHENEVER: {
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
			} else {
				boolean synPredMatched135 = false;
				if (((_tokenSet_37.member(LA(1))) && (_tokenSet_40
						.member(LA(2))))) {
					int _m135 = mark();
					synPredMatched135 = true;
					inputState.guessing++;
					try {
						{
							sqlExpression();
							{
								switch (LA(1)) {
								case NOT: {
									match(NOT);
									break;
								}
								case BETWEEN: {
									break;
								}
								default: {
									throw new NoViableAltException(LT(1),
											getFilename());
								}
								}
							}
							match(BETWEEN);
						}
					} catch (RecognitionException pe) {
						synPredMatched135 = false;
					}
					rewind(_m135);
					inputState.guessing--;
				}
				if (synPredMatched135) {
					sqlExpression();
					{
						switch (LA(1)) {
						case NOT: {
							match(NOT);
							break;
						}
						case BETWEEN: {
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
					match(BETWEEN);
					sqlExpression();
					match(AND);
					sqlExpression();
				} else {
					boolean synPredMatched139 = false;
					if (((_tokenSet_37.member(LA(1))) && (_tokenSet_41
							.member(LA(2))))) {
						int _m139 = mark();
						synPredMatched139 = true;
						inputState.guessing++;
						try {
							{
								sqlExpression();
								match(IS);
								{
									switch (LA(1)) {
									case NOT: {
										match(NOT);
										break;
									}
									case NULL: {
										break;
									}
									default: {
										throw new NoViableAltException(LT(1),
												getFilename());
									}
									}
								}
								match(NULL);
							}
						} catch (RecognitionException pe) {
							synPredMatched139 = false;
						}
						rewind(_m139);
						inputState.guessing--;
					}
					if (synPredMatched139) {
						sqlExpression();
						match(IS);
						{
							switch (LA(1)) {
							case NOT: {
								match(NOT);
								break;
							}
							case NULL: {
								break;
							}
							default: {
								throw new NoViableAltException(LT(1),
										getFilename());
							}
							}
						}
						match(NULL);
					} else {
						boolean synPredMatched142 = false;
						if (((_tokenSet_35.member(LA(1))) && (_tokenSet_42
								.member(LA(2))))) {
							int _m142 = mark();
							synPredMatched142 = true;
							inputState.guessing++;
							try {
								{
									quantifiedFactor();
								}
							} catch (RecognitionException pe) {
								synPredMatched142 = false;
							}
							rewind(_m142);
							inputState.guessing--;
						}
						if (synPredMatched142) {
							quantifiedFactor();
						} else {
							boolean synPredMatched144 = false;
							if (((LA(1) == NOT) && (_tokenSet_35.member(LA(2))))) {
								int _m144 = mark();
								synPredMatched144 = true;
								inputState.guessing++;
								try {
									{
										match(NOT);
										condition();
									}
								} catch (RecognitionException pe) {
									synPredMatched144 = false;
								}
								rewind(_m144);
								inputState.guessing--;
							}
							if (synPredMatched144) {
								match(NOT);
								condition();
							} else if ((LA(1) == LPAREN)
									&& (_tokenSet_35.member(LA(2)))) {
								{
									match(LPAREN);
									condition();
									match(RPAREN);
								}
							} else if ((_tokenSet_37.member(LA(1)))
									&& (_tokenSet_43.member(LA(2)))) {
								sqlExpression();
								relationalOperator();
								sqlExpression();
							} else {
								throw new NoViableAltException(LT(1),
										getFilename());
							}
						}
					}
				}
			}
		}
	}

	public final void sqlExpression() throws RecognitionException,
			TokenStreamException {

		sqlTerm();
		{
			_loop162: do {
				if ((LA(1) == PLUS || LA(1) == MINUS)
						&& (_tokenSet_37.member(LA(2)))) {
					{
						switch (LA(1)) {
						case PLUS: {
							match(PLUS);
							break;
						}
						case MINUS: {
							match(MINUS);
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
					sqlTerm();
				} else {
					break _loop162;
				}

			} while (true);
		}
	}

	public final void expressionSet() throws RecognitionException,
			TokenStreamException {

		boolean synPredMatched157 = false;
		if (((_tokenSet_37.member(LA(1))) && (_tokenSet_44.member(LA(2))))) {
			int _m157 = mark();
			synPredMatched157 = true;
			inputState.guessing++;
			try {
				{
					sqlExpression();
				}
			} catch (RecognitionException pe) {
				synPredMatched157 = false;
			}
			rewind(_m157);
			inputState.guessing--;
		}
		if (synPredMatched157) {
			sqlExpression();
		} else if ((LA(1) == LPAREN) && (LA(2) == SELECT)) {
			subquery();
		} else {
			throw new NoViableAltException(LT(1), getFilename());
		}

	}

	public final void quantifiedFactor() throws RecognitionException,
			TokenStreamException {

		boolean synPredMatched149 = false;
		if (((_tokenSet_37.member(LA(1))) && (_tokenSet_43.member(LA(2))))) {
			int _m149 = mark();
			synPredMatched149 = true;
			inputState.guessing++;
			try {
				{
					sqlExpression();
					relationalOperator();
					{
						switch (LA(1)) {
						case ALL: {
							match(ALL);
							break;
						}
						case ANY: {
							match(ANY);
							break;
						}
						case LPAREN: {
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
					subquery();
				}
			} catch (RecognitionException pe) {
				synPredMatched149 = false;
			}
			rewind(_m149);
			inputState.guessing--;
		}
		if (synPredMatched149) {
			sqlExpression();
			relationalOperator();
			{
				switch (LA(1)) {
				case ALL: {
					match(ALL);
					break;
				}
				case ANY: {
					match(ANY);
					break;
				}
				case LPAREN: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			subquery();
		} else {
			boolean synPredMatched153 = false;
			if (((LA(1) == NOT || LA(1) == EXISTS) && (LA(2) == LPAREN || LA(2) == EXISTS))) {
				int _m153 = mark();
				synPredMatched153 = true;
				inputState.guessing++;
				try {
					{
						{
							switch (LA(1)) {
							case NOT: {
								match(NOT);
								break;
							}
							case EXISTS: {
								break;
							}
							default: {
								throw new NoViableAltException(LT(1),
										getFilename());
							}
							}
						}
						match(EXISTS);
						subquery();
					}
				} catch (RecognitionException pe) {
					synPredMatched153 = false;
				}
				rewind(_m153);
				inputState.guessing--;
			}
			if (synPredMatched153) {
				{
					switch (LA(1)) {
					case NOT: {
						match(NOT);
						break;
					}
					case EXISTS: {
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
				match(EXISTS);
				subquery();
			} else if ((LA(1) == LPAREN) && (LA(2) == SELECT)) {
				subquery();
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}
		}
	}

	public final void relationalOperator() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case EQUAL: {
			match(EQUAL);
			break;
		}
		case NOT_EQUAL: {
			match(NOT_EQUAL);
			break;
		}
		case LE: {
			match(LE);
			break;
		}
		case LT: {
			match(LT);
			break;
		}
		case GE: {
			match(GE);
			break;
		}
		case GT: {
			match(GT);
			break;
		}
		case NOT:
		case MATCHES: {
			{
				switch (LA(1)) {
				case NOT: {
					match(NOT);
					break;
				}
				case MATCHES: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(MATCHES);
			break;
		}
		case LIKE: {
			match(LIKE);
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void subquery() throws RecognitionException,
			TokenStreamException {

		match(LPAREN);
		sqlSelectStatement();
		match(RPAREN);
	}

	public final void sqlSelectStatement() throws RecognitionException,
			TokenStreamException {

		mainSelectStatement();
	}

	public final void sqlTerm() throws RecognitionException,
			TokenStreamException {

		sqlFactor();
		{
			_loop168: do {
				if ((_tokenSet_45.member(LA(1)))
						&& (_tokenSet_37.member(LA(2)))) {
					{
						switch (LA(1)) {
						case STAR: {
							sqlMultiply();
							break;
						}
						case DIV: {
							match(DIV);
							break;
						}
						case SLASH: {
							match(SLASH);
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
					sqlFactor();
				} else {
					break _loop168;
				}

			} while (true);
		}
	}

	public final void sqlAlias() throws RecognitionException,
			TokenStreamException {

		{
			switch (LA(1)) {
			case AS: {
				match(AS);
				break;
			}
			case IDENT: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		identifier();
	}

	public final void sqlFactor() throws RecognitionException,
			TokenStreamException {

		sqlFactor2();
		{
			_loop172: do {
				if ((LA(1) == DOUBLEVERTBAR) && (_tokenSet_37.member(LA(2)))) {
					match(DOUBLEVERTBAR);
					sqlFactor2();
				} else {
					break _loop172;
				}

			} while (true);
		}
	}

	public final void sqlMultiply() throws RecognitionException,
			TokenStreamException {

		match(STAR);
	}

	public final void sqlFactor2() throws RecognitionException,
			TokenStreamException {

		boolean synPredMatched176 = false;
		if (((_tokenSet_46.member(LA(1))) && (_tokenSet_47.member(LA(2))))) {
			int _m176 = mark();
			synPredMatched176 = true;
			inputState.guessing++;
			try {
				{
					sqlVariable();
					{
						if ((LA(1) == UNITS)) {
							match(UNITS);
							unitType();
						} else {
						}

					}
				}
			} catch (RecognitionException pe) {
				synPredMatched176 = false;
			}
			rewind(_m176);
			inputState.guessing--;
		}
		if (synPredMatched176) {
			sqlVariable();
			{
				switch (LA(1)) {
				case UNITS: {
					match(UNITS);
					unitType();
					break;
				}
				case IDENT:
				case END:
				case DEFER:
				case RETURN:
				case RPAREN:
				case COMMA:
				case WITH:
				case LIKE:
				case STAR:
				case SEMI:
				case RUN:
				case IN:
				case LET:
				case EQUAL:
				case CALL:
				case GOTO:
				case OR:
				case AND:
				case NOT:
				case ESC:
				case BETWEEN:
				case IS:
				case PLUS:
				case MINUS:
				case AS:
				case DIV:
				case SLASH:
				case DOUBLEVERTBAR:
				case NOT_EQUAL:
				case LE:
				case LT:
				case GE:
				case GT:
				case MATCHES:
				case GROUP:
				case PREPARE:
				case IF:
				case ELSE:
				case WHILE:
				case FOR:
				case FOREACH:
				case INTO:
				case CASE:
				case WHEN:
				case OTHERWISE:
				case SLEEP:
				case CONSTRUCT:
				case DISPLAY:
				case INPUT:
				case MENU:
				case EXIT:
				case CONTINUE:
				case ALLOCATE:
				case LOCATE:
				case DEALLOCATE:
				case RESIZE:
				case FREE:
				case INITIALIZE:
				case VALIDATE:
				case START:
				case PAGE:
				case TERMINATE:
				case FINISH:
				case PAUSE:
				case NEED:
				case PRINT:
				case SKIP:
				case OUTPUT:
				case BEFORE:
				case AFTER:
				case ON:
				case NEXT:
				case FROM:
				case ERROR:
				case MESSAGE:
				case PROMPT:
				case INSERT:
				case DELETE:
				case COMMAND:
				case SHOW:
				case HIDE:
				case FIRST:
				case ORDER:
				case OPTIONS:
				case CLEAR:
				case CLOSE:
				case CURRENT:
				case OPEN:
				case SCROLL:
				case DECLARE:
				case UPDATE:
				case FETCH:
				case FLUSH:
				case PUT:
				case DROP:
				case CREATE:
				case LOCK:
				case SELECT:
				case UNION:
				case HAVING:
				case LOAD:
				case UNLOAD:
				case SET:
				case EXECUTE:
				case DATABASE:
				case BEGIN:
				case COMMIT:
				case ROLLBACK:
				case WHENEVER: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
		} else {
			boolean synPredMatched180 = false;
			if (((_tokenSet_48.member(LA(1))) && (_tokenSet_49.member(LA(2))))) {
				int _m180 = mark();
				synPredMatched180 = true;
				inputState.guessing++;
				try {
					{
						sqlLiteral();
						{
							if ((LA(1) == UNITS)) {
								match(UNITS);
								unitType();
							} else {
							}

						}
					}
				} catch (RecognitionException pe) {
					synPredMatched180 = false;
				}
				rewind(_m180);
				inputState.guessing--;
			}
			if (synPredMatched180) {
				sqlLiteral();
				{
					switch (LA(1)) {
					case UNITS: {
						match(UNITS);
						unitType();
						break;
					}
					case IDENT:
					case END:
					case DEFER:
					case RETURN:
					case RPAREN:
					case COMMA:
					case WITH:
					case LIKE:
					case STAR:
					case SEMI:
					case RUN:
					case IN:
					case LET:
					case EQUAL:
					case CALL:
					case GOTO:
					case OR:
					case AND:
					case NOT:
					case ESC:
					case BETWEEN:
					case IS:
					case PLUS:
					case MINUS:
					case AS:
					case DIV:
					case SLASH:
					case DOUBLEVERTBAR:
					case NOT_EQUAL:
					case LE:
					case LT:
					case GE:
					case GT:
					case MATCHES:
					case GROUP:
					case PREPARE:
					case IF:
					case ELSE:
					case WHILE:
					case FOR:
					case FOREACH:
					case INTO:
					case CASE:
					case WHEN:
					case OTHERWISE:
					case SLEEP:
					case CONSTRUCT:
					case DISPLAY:
					case INPUT:
					case MENU:
					case EXIT:
					case CONTINUE:
					case ALLOCATE:
					case LOCATE:
					case DEALLOCATE:
					case RESIZE:
					case FREE:
					case INITIALIZE:
					case VALIDATE:
					case START:
					case PAGE:
					case TERMINATE:
					case FINISH:
					case PAUSE:
					case NEED:
					case PRINT:
					case SKIP:
					case OUTPUT:
					case BEFORE:
					case AFTER:
					case ON:
					case NEXT:
					case FROM:
					case ERROR:
					case MESSAGE:
					case PROMPT:
					case INSERT:
					case DELETE:
					case COMMAND:
					case SHOW:
					case HIDE:
					case FIRST:
					case ORDER:
					case OPTIONS:
					case CLEAR:
					case CLOSE:
					case CURRENT:
					case OPEN:
					case SCROLL:
					case DECLARE:
					case UPDATE:
					case FETCH:
					case FLUSH:
					case PUT:
					case DROP:
					case CREATE:
					case LOCK:
					case SELECT:
					case UNION:
					case HAVING:
					case LOAD:
					case UNLOAD:
					case SET:
					case EXECUTE:
					case DATABASE:
					case BEGIN:
					case COMMIT:
					case ROLLBACK:
					case WHENEVER: {
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
			} else {
				boolean synPredMatched187 = false;
				if ((((LA(1) >= AVG && LA(1) <= SUM)) && (LA(2) == LPAREN))) {
					int _m187 = mark();
					synPredMatched187 = true;
					inputState.guessing++;
					try {
						{
							groupFunction();
							match(LPAREN);
							{
								switch (LA(1)) {
								case ALL: {
									match(ALL);
									break;
								}
								case DISTINCT: {
									match(DISTINCT);
									break;
								}
								default:
									if ((LA(1) == STAR)
											&& (_tokenSet_50.member(LA(2)))) {
										match(STAR);
									} else if ((_tokenSet_50.member(LA(1))) && (true)) {
									} else {
										throw new NoViableAltException(LT(1),
												getFilename());
									}
								}
							}
							{
								switch (LA(1)) {
								case IDENT:
								case INTERRUPT:
								case LPAREN:
								case REAL:
								case DATE:
								case YEAR:
								case MONTH:
								case DAY:
								case STAR:
								case STRING_LITERAL:
								case TRUE:
								case FALSE:
								case NOT:
								case NULL:
								case PLUS:
								case MINUS:
								case MOD:
								case LENGTH:
								case AVG:
								case COUNT:
								case MAX:
								case MIN:
								case SUM:
								case DECODE:
								case NVL:
								case USER:
								case GROUP:
								case TODAY:
								case WEEKDAY:
								case MDY:
								case TIME:
								case PAGENO:
								case LINENO:
								case HIDE:
								case FIRST:
								case LAST:
								case NO:
								case ACCEPT:
								case SQL:
								case CURRENT:
								case TEMP:
								case SIZE:
								case INDEX:
								case WAIT:
								case WORK:
								case FOUND:
								case NUM_INT:
								case NUM_REAL:
								case ASCII:
								case INT_FLAG:
								case NOTFOUND:
								case STATUS: {
									sqlExpression();
									{
										_loop186: do {
											if ((LA(1) == COMMA)) {
												match(COMMA);
												sqlExpression();
											} else {
												break _loop186;
											}

										} while (true);
									}
									break;
								}
								case RPAREN: {
									break;
								}
								default: {
									throw new NoViableAltException(LT(1),
											getFilename());
								}
								}
							}
							match(RPAREN);
						}
					} catch (RecognitionException pe) {
						synPredMatched187 = false;
					}
					rewind(_m187);
					inputState.guessing--;
				}
				if (synPredMatched187) {
					groupFunction();
					match(LPAREN);
					{
						switch (LA(1)) {
						case ALL: {
							match(ALL);
							break;
						}
						case DISTINCT: {
							match(DISTINCT);
							break;
						}
						default:
							if ((LA(1) == STAR) && (_tokenSet_50.member(LA(2)))) {
								match(STAR);
							} else if ((_tokenSet_50.member(LA(1)))
									&& (_tokenSet_51.member(LA(2)))) {
							} else {
								throw new NoViableAltException(LT(1),
										getFilename());
							}
						}
					}
					{
						switch (LA(1)) {
						case IDENT:
						case INTERRUPT:
						case LPAREN:
						case REAL:
						case DATE:
						case YEAR:
						case MONTH:
						case DAY:
						case STAR:
						case STRING_LITERAL:
						case TRUE:
						case FALSE:
						case NOT:
						case NULL:
						case PLUS:
						case MINUS:
						case MOD:
						case LENGTH:
						case AVG:
						case COUNT:
						case MAX:
						case MIN:
						case SUM:
						case DECODE:
						case NVL:
						case USER:
						case GROUP:
						case TODAY:
						case WEEKDAY:
						case MDY:
						case TIME:
						case PAGENO:
						case LINENO:
						case HIDE:
						case FIRST:
						case LAST:
						case NO:
						case ACCEPT:
						case SQL:
						case CURRENT:
						case TEMP:
						case SIZE:
						case INDEX:
						case WAIT:
						case WORK:
						case FOUND:
						case NUM_INT:
						case NUM_REAL:
						case ASCII:
						case INT_FLAG:
						case NOTFOUND:
						case STATUS: {
							sqlExpression();
							{
								_loop191: do {
									if ((LA(1) == COMMA)) {
										match(COMMA);
										sqlExpression();
									} else {
										break _loop191;
									}

								} while (true);
							}
							break;
						}
						case RPAREN: {
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
					match(RPAREN);
				} else {
					boolean synPredMatched196 = false;
					if (((_tokenSet_52.member(LA(1))) && (LA(2) == LPAREN))) {
						int _m196 = mark();
						synPredMatched196 = true;
						inputState.guessing++;
						try {
							{
								sqlFunction();
								{
									match(LPAREN);
									sqlExpression();
									{
										_loop195: do {
											if ((LA(1) == COMMA)) {
												match(COMMA);
												sqlExpression();
											} else {
												break _loop195;
											}

										} while (true);
									}
									match(RPAREN);
								}
							}
						} catch (RecognitionException pe) {
							synPredMatched196 = false;
						}
						rewind(_m196);
						inputState.guessing--;
					}
					if (synPredMatched196) {
						sqlFunction();
						{
							match(LPAREN);
							sqlExpression();
							{
								_loop199: do {
									if ((LA(1) == COMMA)) {
										match(COMMA);
										sqlExpression();
									} else {
										break _loop199;
									}

								} while (true);
							}
							match(RPAREN);
						}
					} else {
						boolean synPredMatched202 = false;
						if (((LA(1) == PLUS || LA(1) == MINUS))) {
							int _m202 = mark();
							synPredMatched202 = true;
							inputState.guessing++;
							try {
								{
									{
										switch (LA(1)) {
										case PLUS: {
											match(PLUS);
											break;
										}
										case MINUS: {
											match(MINUS);
											break;
										}
										default: {
											throw new NoViableAltException(
													LT(1), getFilename());
										}
										}
									}
									sqlExpression();
								}
							} catch (RecognitionException pe) {
								synPredMatched202 = false;
							}
							rewind(_m202);
							inputState.guessing--;
						}
						if (synPredMatched202) {
							{
								switch (LA(1)) {
								case PLUS: {
									match(PLUS);
									break;
								}
								case MINUS: {
									match(MINUS);
									break;
								}
								default: {
									throw new NoViableAltException(LT(1),
											getFilename());
								}
								}
							}
							sqlExpression();
						} else {
							boolean synPredMatched205 = false;
							if (((LA(1) == LPAREN) && (_tokenSet_37
									.member(LA(2))))) {
								int _m205 = mark();
								synPredMatched205 = true;
								inputState.guessing++;
								try {
									{
										match(LPAREN);
										sqlExpression();
										match(RPAREN);
									}
								} catch (RecognitionException pe) {
									synPredMatched205 = false;
								}
								rewind(_m205);
								inputState.guessing--;
							}
							if (synPredMatched205) {
								match(LPAREN);
								sqlExpression();
								match(RPAREN);
							} else if ((LA(1) == LPAREN)
									&& (_tokenSet_37.member(LA(2)))) {
								sqlExpressionList();
							} else {
								throw new NoViableAltException(LT(1),
										getFilename());
							}
						}
					}
				}
			}
		}
	}

	public final void sqlVariable() throws RecognitionException,
			TokenStreamException {

		columnsTableId();
	}

	public final void sqlLiteral() throws RecognitionException,
			TokenStreamException {

		{
			if ((_tokenSet_48.member(LA(1))) && (_tokenSet_49.member(LA(2)))) {
				unsignedConstant();
			} else if ((LA(1) == STRING_LITERAL)
					&& (_tokenSet_49.member(LA(2)))) {
				string();
			} else if ((LA(1) == NULL) && (_tokenSet_49.member(LA(2)))) {
				match(NULL);
			} else if ((LA(1) == FALSE) && (_tokenSet_49.member(LA(2)))) {
				match(FALSE);
			} else if ((LA(1) == TRUE) && (_tokenSet_49.member(LA(2)))) {
				match(TRUE);
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}

		}
	}

	public final void groupFunction() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case AVG: {
			match(AVG);
			break;
		}
		case COUNT: {
			match(COUNT);
			break;
		}
		case MAX: {
			match(MAX);
			break;
		}
		case MIN: {
			match(MIN);
			break;
		}
		case SUM: {
			match(SUM);
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void sqlFunction() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case MOD: {
			numberFunction();
			break;
		}
		case DATE:
		case YEAR:
		case MONTH:
		case DAY: {
			dateFunction();
			break;
		}
		default:
			if ((LA(1) == LENGTH) && (LA(2) == LPAREN)) {
				charFunction();
			} else if ((_tokenSet_53.member(LA(1))) && (LA(2) == LPAREN)) {
				otherFunction();
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}
		}
	}

	public final void sqlExpressionList() throws RecognitionException,
			TokenStreamException {

		match(LPAREN);
		sqlExpression();
		{
			int _cnt208 = 0;
			_loop208: do {
				if ((LA(1) == COMMA)) {
					match(COMMA);
					sqlExpression();
				} else {
					if (_cnt208 >= 1) {
						break _loop208;
					} else {
						throw new NoViableAltException(LT(1), getFilename());
					}
				}

				_cnt208++;
			} while (true);
		}
		match(RPAREN);
	}

	public final void unsignedConstant() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case NUM_INT:
		case NUM_REAL: {
			unsignedNumber();
			break;
		}
		case STRING_LITERAL: {
			string();
			break;
		}
		default:
			if ((_tokenSet_5.member(LA(1))) && (_tokenSet_49.member(LA(2)))) {
				constantIdentifier();
			} else if ((LA(1) == NULL) && (_tokenSet_49.member(LA(2)))) {
				match(NULL);
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}
		}
	}

	public final void columnsTableId() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case STAR: {
			match(STAR);
			break;
		}
		case IDENT:
		case INTERRUPT:
		case REAL:
		case STRING_LITERAL:
		case TRUE:
		case FALSE:
		case NOT:
		case NULL:
		case LENGTH:
		case COUNT:
		case USER:
		case GROUP:
		case TODAY:
		case WEEKDAY:
		case MDY:
		case TIME:
		case PAGENO:
		case LINENO:
		case HIDE:
		case FIRST:
		case LAST:
		case NO:
		case ACCEPT:
		case SQL:
		case CURRENT:
		case TEMP:
		case SIZE:
		case INDEX:
		case WAIT:
		case WORK:
		case FOUND:
		case ASCII:
		case INT_FLAG:
		case NOTFOUND:
		case STATUS: {
			{
				tableIdentifier();
				{
					switch (LA(1)) {
					case LBRACK: {
						indexingVariable();
						break;
					}
					case IDENT:
					case END:
					case DEFER:
					case RETURN:
					case RPAREN:
					case COMMA:
					case WITH:
					case LIKE:
					case DOT:
					case STAR:
					case SEMI:
					case RUN:
					case IN:
					case LET:
					case EQUAL:
					case CALL:
					case GOTO:
					case OR:
					case AND:
					case NOT:
					case ESC:
					case BETWEEN:
					case IS:
					case PLUS:
					case MINUS:
					case AS:
					case DIV:
					case SLASH:
					case DOUBLEVERTBAR:
					case UNITS:
					case NOT_EQUAL:
					case LE:
					case LT:
					case GE:
					case GT:
					case MATCHES:
					case GROUP:
					case PREPARE:
					case IF:
					case ELSE:
					case WHILE:
					case FOR:
					case FOREACH:
					case INTO:
					case CASE:
					case WHEN:
					case OTHERWISE:
					case SLEEP:
					case CONSTRUCT:
					case DISPLAY:
					case INPUT:
					case MENU:
					case EXIT:
					case CONTINUE:
					case ALLOCATE:
					case LOCATE:
					case DEALLOCATE:
					case RESIZE:
					case FREE:
					case INITIALIZE:
					case VALIDATE:
					case START:
					case PAGE:
					case TERMINATE:
					case FINISH:
					case PAUSE:
					case NEED:
					case PRINT:
					case SKIP:
					case OUTPUT:
					case BEFORE:
					case AFTER:
					case ON:
					case NEXT:
					case ATTRIBUTE:
					case ATTRIBUTES:
					case FROM:
					case HELP:
					case ERROR:
					case MESSAGE:
					case PROMPT:
					case INSERT:
					case DELETE:
					case COMMAND:
					case SHOW:
					case HIDE:
					case FIRST:
					case ORDER:
					case OPTIONS:
					case CLEAR:
					case CLOSE:
					case CURRENT:
					case OPEN:
					case SCROLL:
					case DECLARE:
					case UPDATE:
					case FETCH:
					case FLUSH:
					case PUT:
					case DROP:
					case CREATE:
					case LOCK:
					case SELECT:
					case UNION:
					case HAVING:
					case LOAD:
					case UNLOAD:
					case SET:
					case EXECUTE:
					case DATABASE:
					case BEGIN:
					case COMMIT:
					case ROLLBACK:
					case WHENEVER: {
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
			}
			{
				if ((LA(1) == DOT) && (LA(2) == STAR)) {
					match(DOT);
					match(STAR);
				} else if ((LA(1) == DOT) && (_tokenSet_46.member(LA(2)))) {
					match(DOT);
					columnsTableId();
				} else if ((_tokenSet_54.member(LA(1)))) {
				} else {
					throw new NoViableAltException(LT(1), getFilename());
				}

			}
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void numberFunction() throws RecognitionException,
			TokenStreamException {

		match(MOD);
	}

	public final void charFunction() throws RecognitionException,
			TokenStreamException {

		match(LENGTH);
	}

	public final void dateFunction() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case YEAR: {
			match(YEAR);
			break;
		}
		case DATE: {
			match(DATE);
			break;
		}
		case DAY: {
			match(DAY);
			break;
		}
		case MONTH: {
			match(MONTH);
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void otherFunction() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case DECODE: {
			match(DECODE);
			break;
		}
		case NVL: {
			match(NVL);
			break;
		}
		case IDENT:
		case INTERRUPT:
		case REAL:
		case TRUE:
		case FALSE:
		case NOT:
		case NULL:
		case LENGTH:
		case COUNT:
		case USER:
		case GROUP:
		case TODAY:
		case WEEKDAY:
		case MDY:
		case TIME:
		case PAGENO:
		case LINENO:
		case HIDE:
		case FIRST:
		case LAST:
		case NO:
		case ACCEPT:
		case SQL:
		case CURRENT:
		case TEMP:
		case SIZE:
		case INDEX:
		case WAIT:
		case WORK:
		case FOUND:
		case ASCII:
		case INT_FLAG:
		case NOTFOUND:
		case STATUS: {
			constantIdentifier();
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void sqlPseudoColumn() throws RecognitionException,
			TokenStreamException {

		match(USER);
	}

	public final void ifCondition() throws RecognitionException,
			TokenStreamException {

		if ((LA(1) == TRUE) && (_tokenSet_55.member(LA(2)))) {
			match(TRUE);
		} else if ((LA(1) == FALSE) && (_tokenSet_55.member(LA(2)))) {
			match(FALSE);
		} else if ((_tokenSet_10.member(LA(1))) && (_tokenSet_56.member(LA(2)))) {
			ifCondition2();
			{
				_loop225: do {
					if ((_tokenSet_57.member(LA(1)))
							&& (_tokenSet_58.member(LA(2)))) {
						relationalOperator();
						ifCondition2();
					} else {
						break _loop225;
					}

				} while (true);
			}
		} else {
			throw new NoViableAltException(LT(1), getFilename());
		}

	}

	public final void ifCondition2() throws RecognitionException,
			TokenStreamException {

		ifLogicalTerm();
		{
			_loop228: do {
				if ((LA(1) == OR) && (_tokenSet_10.member(LA(2)))) {
					match(OR);
					ifLogicalTerm();
				} else {
					break _loop228;
				}

			} while (true);
		}
	}

	public final void ifLogicalTerm() throws RecognitionException,
			TokenStreamException {

		ifLogicalFactor();
		{
			_loop231: do {
				if ((LA(1) == AND) && (_tokenSet_10.member(LA(2)))) {
					match(AND);
					ifLogicalFactor();
				} else {
					break _loop231;
				}

			} while (true);
		}
	}

	public final void ifLogicalFactor() throws RecognitionException,
			TokenStreamException {

		boolean synPredMatched238 = false;
		if (((_tokenSet_10.member(LA(1))) && (_tokenSet_59.member(LA(2))))) {
			int _m238 = mark();
			synPredMatched238 = true;
			inputState.guessing++;
			try {
				{
					simpleExpression();
					match(IS);
					{
						switch (LA(1)) {
						case NOT: {
							match(NOT);
							break;
						}
						case NULL: {
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
					match(NULL);
				}
			} catch (RecognitionException pe) {
				synPredMatched238 = false;
			}
			rewind(_m238);
			inputState.guessing--;
		}
		if (synPredMatched238) {
			simpleExpression();
			match(IS);
			{
				switch (LA(1)) {
				case NOT: {
					match(NOT);
					break;
				}
				case NULL: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(NULL);
		} else {
			boolean synPredMatched241 = false;
			if (((LA(1) == NOT) && (_tokenSet_10.member(LA(2))))) {
				int _m241 = mark();
				synPredMatched241 = true;
				inputState.guessing++;
				try {
					{
						match(NOT);
						ifCondition();
					}
				} catch (RecognitionException pe) {
					synPredMatched241 = false;
				}
				rewind(_m241);
				inputState.guessing--;
			}
			if (synPredMatched241) {
				match(NOT);
				ifCondition();
			} else if ((LA(1) == LPAREN) && (_tokenSet_10.member(LA(2)))) {
				match(LPAREN);
				ifCondition();
				match(RPAREN);
			} else {
				boolean synPredMatched243 = false;
				if (((_tokenSet_10.member(LA(1))) && (_tokenSet_60
						.member(LA(2))))) {
					int _m243 = mark();
					synPredMatched243 = true;
					inputState.guessing++;
					try {
						{
							simpleExpression();
						}
					} catch (RecognitionException pe) {
						synPredMatched243 = false;
					}
					rewind(_m243);
					inputState.guessing--;
				}
				if (synPredMatched243) {
					simpleExpression();
				} else {
					throw new NoViableAltException(LT(1), getFilename());
				}
			}
		}
	}

	public final void simpleExpression() throws RecognitionException,
			TokenStreamException {

		{
			if ((LA(1) == PLUS || LA(1) == MINUS)
					&& (_tokenSet_10.member(LA(2)))) {
				sign();
			} else if ((_tokenSet_10.member(LA(1)))
					&& (_tokenSet_61.member(LA(2)))) {
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}

		}
		term();
		{
			_loop247: do {
				if ((LA(1) == PLUS || LA(1) == MINUS)
						&& (_tokenSet_10.member(LA(2)))) {
					addingOperator();
					term();
				} else {
					break _loop247;
				}

			} while (true);
		}
	}

	public final void sign() throws RecognitionException, TokenStreamException {

		switch (LA(1)) {
		case PLUS: {
			match(PLUS);
			break;
		}
		case MINUS: {
			match(MINUS);
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void term() throws RecognitionException, TokenStreamException {

		factor();
		{
			_loop251: do {
				if ((_tokenSet_62.member(LA(1)))) {
					multiplyingOperator();
					factor();
				} else {
					break _loop251;
				}

			} while (true);
		}
	}

	public final void addingOperator() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case PLUS: {
			match(PLUS);
			break;
		}
		case MINUS: {
			match(MINUS);
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void factor() throws RecognitionException,
			TokenStreamException {

		{
			if ((_tokenSet_63.member(LA(1))) && (_tokenSet_64.member(LA(2)))) {
				{
					if ((LA(1) == GROUP) && (_tokenSet_63.member(LA(2)))) {
						match(GROUP);
					} else if ((_tokenSet_63.member(LA(1)))
							&& (_tokenSet_64.member(LA(2)))) {
					} else {
						throw new NoViableAltException(LT(1), getFilename());
					}

				}
				functionDesignator();
			} else if ((_tokenSet_5.member(LA(1)))
					&& (_tokenSet_61.member(LA(2)))) {
				variable();
			} else if ((_tokenSet_65.member(LA(1)))
					&& (_tokenSet_64.member(LA(2)))) {
				constant();
			} else if ((LA(1) == LPAREN)) {
				match(LPAREN);
				expression();
				match(RPAREN);
			} else if ((LA(1) == NOT) && (_tokenSet_10.member(LA(2)))) {
				match(NOT);
				factor();
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}

		}
		{
			if ((LA(1) == UNITS) && (_tokenSet_66.member(LA(2)))) {
				match(UNITS);
				unitType();
			} else if ((_tokenSet_64.member(LA(1)))
					&& (_tokenSet_67.member(LA(2)))) {
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}

		}
	}

	public final void multiplyingOperator() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case STAR: {
			match(STAR);
			break;
		}
		case SLASH: {
			match(SLASH);
			break;
		}
		case DIV: {
			match(DIV);
			break;
		}
		case MOD: {
			match(MOD);
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void functionDesignator() throws RecognitionException,
			TokenStreamException {

		functionIdentifier();
		{
			if ((LA(1) == LPAREN) && (_tokenSet_68.member(LA(2)))) {
				match(LPAREN);
				{
					switch (LA(1)) {
					case IDENT:
					case INTERRUPT:
					case LPAREN:
					case REAL:
					case DATE:
					case YEAR:
					case MONTH:
					case DAY:
					case STAR:
					case STRING_LITERAL:
					case TRUE:
					case FALSE:
					case NOT:
					case NULL:
					case PLUS:
					case MINUS:
					case LENGTH:
					case AVG:
					case COUNT:
					case MAX:
					case MIN:
					case SUM:
					case USER:
					case GROUP:
					case TODAY:
					case WEEKDAY:
					case MDY:
					case COLUMN:
					case EXTEND:
					case TIME:
					case INFIELD:
					case PREPARE:
					case PAGENO:
					case LINENO:
					case HIDE:
					case FIRST:
					case LAST:
					case NO:
					case ACCEPT:
					case SQL:
					case CURRENT:
					case TEMP:
					case SIZE:
					case INDEX:
					case WAIT:
					case WORK:
					case FOUND:
					case NUM_INT:
					case NUM_REAL:
					case ASCII:
					case INT_FLAG:
					case NOTFOUND:
					case STATUS: {
						actualParameter();
						{
							_loop261: do {
								if ((LA(1) == COMMA)) {
									match(COMMA);
									actualParameter();
								} else {
									break _loop261;
								}

							} while (true);
						}
						break;
					}
					case RPAREN: {
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
				match(RPAREN);
			} else if ((_tokenSet_64.member(LA(1)))
					&& (_tokenSet_67.member(LA(2)))) {
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}

		}
	}

	public final void constant() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case IDENT:
		case INTERRUPT:
		case REAL:
		case TRUE:
		case FALSE:
		case NOT:
		case NULL:
		case LENGTH:
		case COUNT:
		case USER:
		case GROUP:
		case TODAY:
		case WEEKDAY:
		case MDY:
		case TIME:
		case PAGENO:
		case LINENO:
		case HIDE:
		case FIRST:
		case LAST:
		case NO:
		case ACCEPT:
		case SQL:
		case CURRENT:
		case TEMP:
		case SIZE:
		case INDEX:
		case WAIT:
		case WORK:
		case FOUND:
		case ASCII:
		case INT_FLAG:
		case NOTFOUND:
		case STATUS: {
			constantIdentifier();
			break;
		}
		case STRING_LITERAL: {
			string();
			break;
		}
		default:
			if ((_tokenSet_17.member(LA(1))) && (_tokenSet_64.member(LA(2)))) {
				numericConstant();
			} else if ((LA(1) == PLUS || LA(1) == MINUS) && (LA(2) == IDENT)) {
				sign();
				identifier();
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}
		}
	}

	public final void unsignedNumber() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case NUM_INT: {
			unsignedInteger();
			break;
		}
		case NUM_REAL: {
			unsignedReal();
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void entireVariable() throws RecognitionException,
			TokenStreamException {

		variableIdentifier();
	}

	public final void componentVariable() throws RecognitionException,
			TokenStreamException {

		{
			recordVariable();
			{
				if ((LA(1) == LBRACK)) {
					indexingVariable();
				} else if ((_tokenSet_69.member(LA(1)))) {
				} else {
					throw new NoViableAltException(LT(1), getFilename());
				}

			}
		}
		{
			if ((LA(1) == DOT) && (LA(2) == STAR)) {
				{
					match(DOT);
					match(STAR);
				}
			} else if ((LA(1) == DOT) && (_tokenSet_5.member(LA(2)))) {
				{
					match(DOT);
					componentVariable();
					{
						if ((LA(1) == THROUGH || LA(1) == THRU)
								&& (_tokenSet_5.member(LA(2)))) {
							{
								switch (LA(1)) {
								case THROUGH: {
									match(THROUGH);
									break;
								}
								case THRU: {
									match(THRU);
									break;
								}
								default: {
									throw new NoViableAltException(LT(1),
											getFilename());
								}
								}
							}
							componentVariable();
						} else if ((_tokenSet_70.member(LA(1)))
								&& (_tokenSet_71.member(LA(2)))) {
						} else {
							throw new NoViableAltException(LT(1), getFilename());
						}

					}
				}
			} else if ((_tokenSet_70.member(LA(1)))) {
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}

		}
	}

	public final void variableIdentifier() throws RecognitionException,
			TokenStreamException {

		constantIdentifier();
	}

	public final void indexingVariable() throws RecognitionException,
			TokenStreamException {

		match(LBRACK);
		expression();
		{
			_loop271: do {
				if ((LA(1) == COMMA)) {
					match(COMMA);
					expression();
				} else {
					break _loop271;
				}

			} while (true);
		}
		match(RBRACK);
	}

	public final void recordVariable() throws RecognitionException,
			TokenStreamException {

		constantIdentifier();
	}

	public final void fieldIdentifier() throws RecognitionException,
			TokenStreamException {

		constantIdentifier();
	}

	public final void conditionalStatement() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case IF: {
			ifStatement();
			break;
		}
		case CASE: {
			caseStatement();
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void repetetiveStatement() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case WHILE: {
			whileStatement();
			break;
		}
		case FOREACH: {
			forEachStatement();
			break;
		}
		case FOR: {
			forStatement();
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void ifStatement() throws RecognitionException,
			TokenStreamException {

		match(IF);
		ifCondition();
		match(THEN);
		{
			switch (LA(1)) {
			case IDENT:
			case RETURN:
			case RUN:
			case LET:
			case CALL:
			case GOTO:
			case PREPARE:
			case IF:
			case WHILE:
			case FOR:
			case FOREACH:
			case CASE:
			case SLEEP:
			case CONSTRUCT:
			case DISPLAY:
			case INPUT:
			case MENU:
			case EXIT:
			case CONTINUE:
			case ALLOCATE:
			case LOCATE:
			case DEALLOCATE:
			case RESIZE:
			case FREE:
			case INITIALIZE:
			case VALIDATE:
			case START:
			case TERMINATE:
			case FINISH:
			case PAUSE:
			case NEED:
			case PRINT:
			case SKIP:
			case OUTPUT:
			case NEXT:
			case ERROR:
			case MESSAGE:
			case PROMPT:
			case INSERT:
			case DELETE:
			case SHOW:
			case HIDE:
			case OPTIONS:
			case CLEAR:
			case CLOSE:
			case CURRENT:
			case OPEN:
			case SCROLL:
			case DECLARE:
			case UPDATE:
			case FETCH:
			case FLUSH:
			case PUT:
			case DROP:
			case CREATE:
			case LOCK:
			case SELECT:
			case LOAD:
			case UNLOAD:
			case SET:
			case EXECUTE:
			case DATABASE:
			case BEGIN:
			case COMMIT:
			case ROLLBACK:
			case WHENEVER: {
				codeBlock();
				break;
			}
			case END:
			case ELSE: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		{
			switch (LA(1)) {
			case ELSE: {
				match(ELSE);
				{
					switch (LA(1)) {
					case IDENT:
					case RETURN:
					case RUN:
					case LET:
					case CALL:
					case GOTO:
					case PREPARE:
					case IF:
					case WHILE:
					case FOR:
					case FOREACH:
					case CASE:
					case SLEEP:
					case CONSTRUCT:
					case DISPLAY:
					case INPUT:
					case MENU:
					case EXIT:
					case CONTINUE:
					case ALLOCATE:
					case LOCATE:
					case DEALLOCATE:
					case RESIZE:
					case FREE:
					case INITIALIZE:
					case VALIDATE:
					case START:
					case TERMINATE:
					case FINISH:
					case PAUSE:
					case NEED:
					case PRINT:
					case SKIP:
					case OUTPUT:
					case NEXT:
					case ERROR:
					case MESSAGE:
					case PROMPT:
					case INSERT:
					case DELETE:
					case SHOW:
					case HIDE:
					case OPTIONS:
					case CLEAR:
					case CLOSE:
					case CURRENT:
					case OPEN:
					case SCROLL:
					case DECLARE:
					case UPDATE:
					case FETCH:
					case FLUSH:
					case PUT:
					case DROP:
					case CREATE:
					case LOCK:
					case SELECT:
					case LOAD:
					case UNLOAD:
					case SET:
					case EXECUTE:
					case DATABASE:
					case BEGIN:
					case COMMIT:
					case ROLLBACK:
					case WHENEVER: {
						codeBlock();
						break;
					}
					case END: {
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
				break;
			}
			case END: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		match(END);
		match(IF);
	}

	public final void caseStatement() throws RecognitionException,
			TokenStreamException {

		if ((LA(1) == CASE) && (_tokenSet_10.member(LA(2)))) {
			match(CASE);
			expression();
			{
				_loop316: do {
					if ((LA(1) == WHEN)) {
						match(WHEN);
						expression();
						{
							switch (LA(1)) {
							case IDENT:
							case RETURN:
							case RUN:
							case LET:
							case CALL:
							case GOTO:
							case PREPARE:
							case IF:
							case WHILE:
							case FOR:
							case FOREACH:
							case CASE:
							case SLEEP:
							case CONSTRUCT:
							case DISPLAY:
							case INPUT:
							case MENU:
							case EXIT:
							case CONTINUE:
							case ALLOCATE:
							case LOCATE:
							case DEALLOCATE:
							case RESIZE:
							case FREE:
							case INITIALIZE:
							case VALIDATE:
							case START:
							case TERMINATE:
							case FINISH:
							case PAUSE:
							case NEED:
							case PRINT:
							case SKIP:
							case OUTPUT:
							case NEXT:
							case ERROR:
							case MESSAGE:
							case PROMPT:
							case INSERT:
							case DELETE:
							case SHOW:
							case HIDE:
							case OPTIONS:
							case CLEAR:
							case CLOSE:
							case CURRENT:
							case OPEN:
							case SCROLL:
							case DECLARE:
							case UPDATE:
							case FETCH:
							case FLUSH:
							case PUT:
							case DROP:
							case CREATE:
							case LOCK:
							case SELECT:
							case LOAD:
							case UNLOAD:
							case SET:
							case EXECUTE:
							case DATABASE:
							case BEGIN:
							case COMMIT:
							case ROLLBACK:
							case WHENEVER: {
								codeBlock();
								break;
							}
							case END:
							case WHEN:
							case OTHERWISE: {
								break;
							}
							default: {
								throw new NoViableAltException(LT(1),
										getFilename());
							}
							}
						}
					} else {
						break _loop316;
					}

				} while (true);
			}
			{
				switch (LA(1)) {
				case OTHERWISE: {
					match(OTHERWISE);
					{
						switch (LA(1)) {
						case IDENT:
						case RETURN:
						case RUN:
						case LET:
						case CALL:
						case GOTO:
						case PREPARE:
						case IF:
						case WHILE:
						case FOR:
						case FOREACH:
						case CASE:
						case SLEEP:
						case CONSTRUCT:
						case DISPLAY:
						case INPUT:
						case MENU:
						case EXIT:
						case CONTINUE:
						case ALLOCATE:
						case LOCATE:
						case DEALLOCATE:
						case RESIZE:
						case FREE:
						case INITIALIZE:
						case VALIDATE:
						case START:
						case TERMINATE:
						case FINISH:
						case PAUSE:
						case NEED:
						case PRINT:
						case SKIP:
						case OUTPUT:
						case NEXT:
						case ERROR:
						case MESSAGE:
						case PROMPT:
						case INSERT:
						case DELETE:
						case SHOW:
						case HIDE:
						case OPTIONS:
						case CLEAR:
						case CLOSE:
						case CURRENT:
						case OPEN:
						case SCROLL:
						case DECLARE:
						case UPDATE:
						case FETCH:
						case FLUSH:
						case PUT:
						case DROP:
						case CREATE:
						case LOCK:
						case SELECT:
						case LOAD:
						case UNLOAD:
						case SET:
						case EXECUTE:
						case DATABASE:
						case BEGIN:
						case COMMIT:
						case ROLLBACK:
						case WHENEVER: {
							codeBlock();
							break;
						}
						case END: {
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
					break;
				}
				case END: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(END);
			match(CASE);
		} else if ((LA(1) == CASE) && (_tokenSet_72.member(LA(2)))) {
			match(CASE);
			{
				_loop320: do {
					if ((LA(1) == WHEN)) {
						match(WHEN);
						ifCondition();
						codeBlock();
					} else {
						break _loop320;
					}

				} while (true);
			}
			{
				switch (LA(1)) {
				case OTHERWISE: {
					match(OTHERWISE);
					codeBlock();
					break;
				}
				case END: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(END);
			match(CASE);
		} else {
			throw new NoViableAltException(LT(1), getFilename());
		}

	}

	public final void whileStatement() throws RecognitionException,
			TokenStreamException {

		match(WHILE);
		ifCondition();
		{
			switch (LA(1)) {
			case IDENT:
			case RETURN:
			case RUN:
			case LET:
			case CALL:
			case GOTO:
			case PREPARE:
			case IF:
			case WHILE:
			case FOR:
			case FOREACH:
			case CASE:
			case SLEEP:
			case CONSTRUCT:
			case DISPLAY:
			case INPUT:
			case MENU:
			case EXIT:
			case CONTINUE:
			case ALLOCATE:
			case LOCATE:
			case DEALLOCATE:
			case RESIZE:
			case FREE:
			case INITIALIZE:
			case VALIDATE:
			case START:
			case TERMINATE:
			case FINISH:
			case PAUSE:
			case NEED:
			case PRINT:
			case SKIP:
			case OUTPUT:
			case NEXT:
			case ERROR:
			case MESSAGE:
			case PROMPT:
			case INSERT:
			case DELETE:
			case SHOW:
			case HIDE:
			case OPTIONS:
			case CLEAR:
			case CLOSE:
			case CURRENT:
			case OPEN:
			case SCROLL:
			case DECLARE:
			case UPDATE:
			case FETCH:
			case FLUSH:
			case PUT:
			case DROP:
			case CREATE:
			case LOCK:
			case SELECT:
			case LOAD:
			case UNLOAD:
			case SET:
			case EXECUTE:
			case DATABASE:
			case BEGIN:
			case COMMIT:
			case ROLLBACK:
			case WHENEVER: {
				codeBlock();
				break;
			}
			case END: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		match(END);
		match(WHILE);
	}

	public final void forEachStatement() throws RecognitionException,
			TokenStreamException {

		match(FOREACH);
		identifier();
		{
			switch (LA(1)) {
			case USING: {
				match(USING);
				variableList();
				break;
			}
			case IDENT:
			case END:
			case RETURN:
			case WITH:
			case RUN:
			case LET:
			case CALL:
			case GOTO:
			case PREPARE:
			case IF:
			case WHILE:
			case FOR:
			case FOREACH:
			case INTO:
			case CASE:
			case SLEEP:
			case CONSTRUCT:
			case DISPLAY:
			case INPUT:
			case MENU:
			case EXIT:
			case CONTINUE:
			case ALLOCATE:
			case LOCATE:
			case DEALLOCATE:
			case RESIZE:
			case FREE:
			case INITIALIZE:
			case VALIDATE:
			case START:
			case TERMINATE:
			case FINISH:
			case PAUSE:
			case NEED:
			case PRINT:
			case SKIP:
			case OUTPUT:
			case NEXT:
			case ERROR:
			case MESSAGE:
			case PROMPT:
			case INSERT:
			case DELETE:
			case SHOW:
			case HIDE:
			case OPTIONS:
			case CLEAR:
			case CLOSE:
			case CURRENT:
			case OPEN:
			case SCROLL:
			case DECLARE:
			case UPDATE:
			case FETCH:
			case FLUSH:
			case PUT:
			case DROP:
			case CREATE:
			case LOCK:
			case SELECT:
			case LOAD:
			case UNLOAD:
			case SET:
			case EXECUTE:
			case DATABASE:
			case BEGIN:
			case COMMIT:
			case ROLLBACK:
			case WHENEVER: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		{
			switch (LA(1)) {
			case INTO: {
				match(INTO);
				variableList();
				break;
			}
			case IDENT:
			case END:
			case RETURN:
			case WITH:
			case RUN:
			case LET:
			case CALL:
			case GOTO:
			case PREPARE:
			case IF:
			case WHILE:
			case FOR:
			case FOREACH:
			case CASE:
			case SLEEP:
			case CONSTRUCT:
			case DISPLAY:
			case INPUT:
			case MENU:
			case EXIT:
			case CONTINUE:
			case ALLOCATE:
			case LOCATE:
			case DEALLOCATE:
			case RESIZE:
			case FREE:
			case INITIALIZE:
			case VALIDATE:
			case START:
			case TERMINATE:
			case FINISH:
			case PAUSE:
			case NEED:
			case PRINT:
			case SKIP:
			case OUTPUT:
			case NEXT:
			case ERROR:
			case MESSAGE:
			case PROMPT:
			case INSERT:
			case DELETE:
			case SHOW:
			case HIDE:
			case OPTIONS:
			case CLEAR:
			case CLOSE:
			case CURRENT:
			case OPEN:
			case SCROLL:
			case DECLARE:
			case UPDATE:
			case FETCH:
			case FLUSH:
			case PUT:
			case DROP:
			case CREATE:
			case LOCK:
			case SELECT:
			case LOAD:
			case UNLOAD:
			case SET:
			case EXECUTE:
			case DATABASE:
			case BEGIN:
			case COMMIT:
			case ROLLBACK:
			case WHENEVER: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		{
			switch (LA(1)) {
			case WITH: {
				match(WITH);
				match(REOPTIMIZATION);
				break;
			}
			case IDENT:
			case END:
			case RETURN:
			case RUN:
			case LET:
			case CALL:
			case GOTO:
			case PREPARE:
			case IF:
			case WHILE:
			case FOR:
			case FOREACH:
			case CASE:
			case SLEEP:
			case CONSTRUCT:
			case DISPLAY:
			case INPUT:
			case MENU:
			case EXIT:
			case CONTINUE:
			case ALLOCATE:
			case LOCATE:
			case DEALLOCATE:
			case RESIZE:
			case FREE:
			case INITIALIZE:
			case VALIDATE:
			case START:
			case TERMINATE:
			case FINISH:
			case PAUSE:
			case NEED:
			case PRINT:
			case SKIP:
			case OUTPUT:
			case NEXT:
			case ERROR:
			case MESSAGE:
			case PROMPT:
			case INSERT:
			case DELETE:
			case SHOW:
			case HIDE:
			case OPTIONS:
			case CLEAR:
			case CLOSE:
			case CURRENT:
			case OPEN:
			case SCROLL:
			case DECLARE:
			case UPDATE:
			case FETCH:
			case FLUSH:
			case PUT:
			case DROP:
			case CREATE:
			case LOCK:
			case SELECT:
			case LOAD:
			case UNLOAD:
			case SET:
			case EXECUTE:
			case DATABASE:
			case BEGIN:
			case COMMIT:
			case ROLLBACK:
			case WHENEVER: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		eol();
		{
			switch (LA(1)) {
			case IDENT:
			case RETURN:
			case RUN:
			case LET:
			case CALL:
			case GOTO:
			case PREPARE:
			case IF:
			case WHILE:
			case FOR:
			case FOREACH:
			case CASE:
			case SLEEP:
			case CONSTRUCT:
			case DISPLAY:
			case INPUT:
			case MENU:
			case EXIT:
			case CONTINUE:
			case ALLOCATE:
			case LOCATE:
			case DEALLOCATE:
			case RESIZE:
			case FREE:
			case INITIALIZE:
			case VALIDATE:
			case START:
			case TERMINATE:
			case FINISH:
			case PAUSE:
			case NEED:
			case PRINT:
			case SKIP:
			case OUTPUT:
			case NEXT:
			case ERROR:
			case MESSAGE:
			case PROMPT:
			case INSERT:
			case DELETE:
			case SHOW:
			case HIDE:
			case OPTIONS:
			case CLEAR:
			case CLOSE:
			case CURRENT:
			case OPEN:
			case SCROLL:
			case DECLARE:
			case UPDATE:
			case FETCH:
			case FLUSH:
			case PUT:
			case DROP:
			case CREATE:
			case LOCK:
			case SELECT:
			case LOAD:
			case UNLOAD:
			case SET:
			case EXECUTE:
			case DATABASE:
			case BEGIN:
			case COMMIT:
			case ROLLBACK:
			case WHENEVER: {
				codeBlock();
				break;
			}
			case END: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		match(END);
		match(FOREACH);
		eol();
	}

	public final void forStatement() throws RecognitionException,
			TokenStreamException {

		match(FOR);
		controlVariable();
		match(EQUAL);
		forList();
		{
			switch (LA(1)) {
			case STEP: {
				match(STEP);
				numericConstant();
				break;
			}
			case IDENT:
			case END:
			case RETURN:
			case RUN:
			case LET:
			case CALL:
			case GOTO:
			case PREPARE:
			case IF:
			case WHILE:
			case FOR:
			case FOREACH:
			case CASE:
			case SLEEP:
			case CONSTRUCT:
			case DISPLAY:
			case INPUT:
			case MENU:
			case EXIT:
			case CONTINUE:
			case ALLOCATE:
			case LOCATE:
			case DEALLOCATE:
			case RESIZE:
			case FREE:
			case INITIALIZE:
			case VALIDATE:
			case START:
			case TERMINATE:
			case FINISH:
			case PAUSE:
			case NEED:
			case PRINT:
			case SKIP:
			case OUTPUT:
			case NEXT:
			case ERROR:
			case MESSAGE:
			case PROMPT:
			case INSERT:
			case DELETE:
			case SHOW:
			case HIDE:
			case OPTIONS:
			case CLEAR:
			case CLOSE:
			case CURRENT:
			case OPEN:
			case SCROLL:
			case DECLARE:
			case UPDATE:
			case FETCH:
			case FLUSH:
			case PUT:
			case DROP:
			case CREATE:
			case LOCK:
			case SELECT:
			case LOAD:
			case UNLOAD:
			case SET:
			case EXECUTE:
			case DATABASE:
			case BEGIN:
			case COMMIT:
			case ROLLBACK:
			case WHENEVER: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		eol();
		{
			switch (LA(1)) {
			case IDENT:
			case RETURN:
			case RUN:
			case LET:
			case CALL:
			case GOTO:
			case PREPARE:
			case IF:
			case WHILE:
			case FOR:
			case FOREACH:
			case CASE:
			case SLEEP:
			case CONSTRUCT:
			case DISPLAY:
			case INPUT:
			case MENU:
			case EXIT:
			case CONTINUE:
			case ALLOCATE:
			case LOCATE:
			case DEALLOCATE:
			case RESIZE:
			case FREE:
			case INITIALIZE:
			case VALIDATE:
			case START:
			case TERMINATE:
			case FINISH:
			case PAUSE:
			case NEED:
			case PRINT:
			case SKIP:
			case OUTPUT:
			case NEXT:
			case ERROR:
			case MESSAGE:
			case PROMPT:
			case INSERT:
			case DELETE:
			case SHOW:
			case HIDE:
			case OPTIONS:
			case CLEAR:
			case CLOSE:
			case CURRENT:
			case OPEN:
			case SCROLL:
			case DECLARE:
			case UPDATE:
			case FETCH:
			case FLUSH:
			case PUT:
			case DROP:
			case CREATE:
			case LOCK:
			case SELECT:
			case LOAD:
			case UNLOAD:
			case SET:
			case EXECUTE:
			case DATABASE:
			case BEGIN:
			case COMMIT:
			case ROLLBACK:
			case WHENEVER: {
				codeBlock();
				break;
			}
			case END: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		match(END);
		match(FOR);
		eol();
	}

	public final void controlVariable() throws RecognitionException,
			TokenStreamException {

		identifier();
	}

	public final void forList() throws RecognitionException,
			TokenStreamException {

		initialValue();
		match(TO);
		finalValue();
	}

	public final void initialValue() throws RecognitionException,
			TokenStreamException {

		expression();
	}

	public final void finalValue() throws RecognitionException,
			TokenStreamException {

		expression();
	}

	public final void variableList() throws RecognitionException,
			TokenStreamException {

		{
			switch (LA(1)) {
			case STRING_LITERAL: {
				string();
				break;
			}
			case IDENT:
			case INTERRUPT:
			case REAL:
			case TRUE:
			case FALSE:
			case NOT:
			case NULL:
			case LENGTH:
			case COUNT:
			case USER:
			case GROUP:
			case TODAY:
			case WEEKDAY:
			case MDY:
			case TIME:
			case PAGENO:
			case LINENO:
			case HIDE:
			case FIRST:
			case LAST:
			case NO:
			case ACCEPT:
			case SQL:
			case CURRENT:
			case TEMP:
			case SIZE:
			case INDEX:
			case WAIT:
			case WORK:
			case FOUND:
			case ASCII:
			case INT_FLAG:
			case NOTFOUND:
			case STATUS: {
				variable();
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		{
			_loop307: do {
				if ((LA(1) == COMMA)) {
					match(COMMA);
					{
						switch (LA(1)) {
						case STRING_LITERAL: {
							string();
							break;
						}
						case IDENT:
						case INTERRUPT:
						case REAL:
						case TRUE:
						case FALSE:
						case NOT:
						case NULL:
						case LENGTH:
						case COUNT:
						case USER:
						case GROUP:
						case TODAY:
						case WEEKDAY:
						case MDY:
						case TIME:
						case PAGENO:
						case LINENO:
						case HIDE:
						case FIRST:
						case LAST:
						case NO:
						case ACCEPT:
						case SQL:
						case CURRENT:
						case TEMP:
						case SIZE:
						case INDEX:
						case WAIT:
						case WORK:
						case FOUND:
						case ASCII:
						case INT_FLAG:
						case NOTFOUND:
						case STATUS: {
							variable();
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
				} else {
					break _loop307;
				}

			} while (true);
		}
	}

	public final void otherProgramFlowStatement() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case RUN: {
			runStatement();
			break;
		}
		case GOTO: {
			gotoStatement();
			break;
		}
		case SLEEP: {
			match(SLEEP);
			expression();
			break;
		}
		case EXIT: {
			exitStatements();
			break;
		}
		case CONTINUE: {
			continueStatements();
			break;
		}
		case RETURN: {
			returnStatement();
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void otherStorageStatement() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case ALLOCATE: {
			match(ALLOCATE);
			match(ARRAY);
			identifier();
			arrayIndexer();
			break;
		}
		case LOCATE: {
			match(LOCATE);
			variableList();
			match(IN);
			{
				switch (LA(1)) {
				case MEMORY: {
					match(MEMORY);
					break;
				}
				case FILE: {
					match(FILE);
					{
						if ((_tokenSet_5.member(LA(1)))
								&& (_tokenSet_73.member(LA(2)))) {
							variable();
						} else if ((LA(1) == STRING_LITERAL)) {
							string();
						} else if ((_tokenSet_12.member(LA(1)))
								&& (_tokenSet_13.member(LA(2)))) {
						} else {
							throw new NoViableAltException(LT(1), getFilename());
						}

					}
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			break;
		}
		case DEALLOCATE: {
			match(DEALLOCATE);
			match(ARRAY);
			identifier();
			break;
		}
		case RESIZE: {
			match(RESIZE);
			match(ARRAY);
			identifier();
			arrayIndexer();
			break;
		}
		case FREE: {
			match(FREE);
			variable();
			{
				_loop332: do {
					if ((LA(1) == COMMA)) {
						match(COMMA);
						variable();
					} else {
						break _loop332;
					}

				} while (true);
			}
			break;
		}
		case INITIALIZE: {
			match(INITIALIZE);
			variable();
			{
				_loop334: do {
					if ((LA(1) == COMMA)) {
						match(COMMA);
						variable();
					} else {
						break _loop334;
					}

				} while (true);
			}
			{
				switch (LA(1)) {
				case TO: {
					match(TO);
					match(NULL);
					break;
				}
				case LIKE: {
					match(LIKE);
					expression();
					{
						_loop337: do {
							if ((LA(1) == COMMA)) {
								match(COMMA);
								expression();
							} else {
								break _loop337;
							}

						} while (true);
					}
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			break;
		}
		case VALIDATE: {
			match(VALIDATE);
			variable();
			{
				_loop339: do {
					if ((LA(1) == COMMA)) {
						match(COMMA);
						variable();
					} else {
						break _loop339;
					}

				} while (true);
			}
			match(LIKE);
			expression();
			{
				_loop341: do {
					if ((LA(1) == COMMA)) {
						match(COMMA);
						expression();
					} else {
						break _loop341;
					}

				} while (true);
			}
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void reportStatement() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case START: {
			match(START);
			match(REPORT);
			constantIdentifier();
			{
				switch (LA(1)) {
				case TO: {
					match(TO);
					{
						switch (LA(1)) {
						case IDENT:
						case INTERRUPT:
						case LPAREN:
						case REAL:
						case DATE:
						case YEAR:
						case MONTH:
						case DAY:
						case STRING_LITERAL:
						case TRUE:
						case FALSE:
						case NOT:
						case NULL:
						case PLUS:
						case MINUS:
						case LENGTH:
						case AVG:
						case COUNT:
						case MAX:
						case MIN:
						case SUM:
						case USER:
						case GROUP:
						case TODAY:
						case WEEKDAY:
						case MDY:
						case COLUMN:
						case EXTEND:
						case TIME:
						case INFIELD:
						case PREPARE:
						case PAGENO:
						case LINENO:
						case HIDE:
						case FIRST:
						case LAST:
						case NO:
						case ACCEPT:
						case SQL:
						case CURRENT:
						case TEMP:
						case SIZE:
						case INDEX:
						case WAIT:
						case WORK:
						case FOUND:
						case NUM_INT:
						case NUM_REAL:
						case ASCII:
						case INT_FLAG:
						case NOTFOUND:
						case STATUS: {
							expression();
							break;
						}
						case PIPE: {
							match(PIPE);
							expression();
							break;
						}
						case PRINTER: {
							match(PRINTER);
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
					break;
				}
				case IDENT:
				case END:
				case DEFER:
				case RETURN:
				case WITH:
				case RUN:
				case LET:
				case CALL:
				case GOTO:
				case PREPARE:
				case IF:
				case ELSE:
				case WHILE:
				case FOR:
				case FOREACH:
				case CASE:
				case WHEN:
				case OTHERWISE:
				case SLEEP:
				case CONSTRUCT:
				case DISPLAY:
				case INPUT:
				case MENU:
				case EXIT:
				case CONTINUE:
				case ALLOCATE:
				case LOCATE:
				case DEALLOCATE:
				case RESIZE:
				case FREE:
				case INITIALIZE:
				case VALIDATE:
				case START:
				case PAGE:
				case TERMINATE:
				case FINISH:
				case PAUSE:
				case NEED:
				case PRINT:
				case SKIP:
				case OUTPUT:
				case BEFORE:
				case AFTER:
				case ON:
				case NEXT:
				case ERROR:
				case MESSAGE:
				case PROMPT:
				case INSERT:
				case DELETE:
				case COMMAND:
				case SHOW:
				case HIDE:
				case FIRST:
				case OPTIONS:
				case CLEAR:
				case CLOSE:
				case CURRENT:
				case OPEN:
				case SCROLL:
				case DECLARE:
				case UPDATE:
				case FETCH:
				case FLUSH:
				case PUT:
				case DROP:
				case CREATE:
				case LOCK:
				case SELECT:
				case LOAD:
				case UNLOAD:
				case SET:
				case EXECUTE:
				case DATABASE:
				case BEGIN:
				case COMMIT:
				case ROLLBACK:
				case WHENEVER: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			{
				switch (LA(1)) {
				case WITH: {
					match(WITH);
					{
						_loop360: do {
							switch (LA(1)) {
							case LEFT: {
								{
									match(LEFT);
									match(MARGIN);
									numericConstant();
								}
								break;
							}
							case RIGHT: {
								{
									match(RIGHT);
									match(MARGIN);
									numericConstant();
								}
								break;
							}
							case BOTTOM: {
								{
									match(BOTTOM);
									match(MARGIN);
									numericConstant();
								}
								break;
							}
							default:
								if ((LA(1) == TOP) && (LA(2) == MARGIN)) {
									{
										match(TOP);
										match(MARGIN);
										numericConstant();
									}
								} else if ((LA(1) == PAGE) && (LA(2) == LENGTH)) {
									{
										match(PAGE);
										match(LENGTH);
										numericConstant();
									}
								} else if ((LA(1) == TOP) && (LA(2) == OF)) {
									{
										match(TOP);
										match(OF);
										match(PAGE);
										string();
									}
								} else {
									break _loop360;
								}
							}
						} while (true);
					}
					break;
				}
				case IDENT:
				case END:
				case DEFER:
				case RETURN:
				case RUN:
				case LET:
				case CALL:
				case GOTO:
				case PREPARE:
				case IF:
				case ELSE:
				case WHILE:
				case FOR:
				case FOREACH:
				case CASE:
				case WHEN:
				case OTHERWISE:
				case SLEEP:
				case CONSTRUCT:
				case DISPLAY:
				case INPUT:
				case MENU:
				case EXIT:
				case CONTINUE:
				case ALLOCATE:
				case LOCATE:
				case DEALLOCATE:
				case RESIZE:
				case FREE:
				case INITIALIZE:
				case VALIDATE:
				case START:
				case PAGE:
				case TERMINATE:
				case FINISH:
				case PAUSE:
				case NEED:
				case PRINT:
				case SKIP:
				case OUTPUT:
				case BEFORE:
				case AFTER:
				case ON:
				case NEXT:
				case ERROR:
				case MESSAGE:
				case PROMPT:
				case INSERT:
				case DELETE:
				case COMMAND:
				case SHOW:
				case HIDE:
				case FIRST:
				case OPTIONS:
				case CLEAR:
				case CLOSE:
				case CURRENT:
				case OPEN:
				case SCROLL:
				case DECLARE:
				case UPDATE:
				case FETCH:
				case FLUSH:
				case PUT:
				case DROP:
				case CREATE:
				case LOCK:
				case SELECT:
				case LOAD:
				case UNLOAD:
				case SET:
				case EXECUTE:
				case DATABASE:
				case BEGIN:
				case COMMIT:
				case ROLLBACK:
				case WHENEVER: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			break;
		}
		case TERMINATE: {
			match(TERMINATE);
			match(REPORT);
			constantIdentifier();
			break;
		}
		case FINISH: {
			match(FINISH);
			match(REPORT);
			constantIdentifier();
			break;
		}
		case PAUSE: {
			match(PAUSE);
			{
				switch (LA(1)) {
				case STRING_LITERAL: {
					string();
					break;
				}
				case IDENT:
				case END:
				case DEFER:
				case RETURN:
				case RUN:
				case LET:
				case CALL:
				case GOTO:
				case PREPARE:
				case IF:
				case ELSE:
				case WHILE:
				case FOR:
				case FOREACH:
				case CASE:
				case WHEN:
				case OTHERWISE:
				case SLEEP:
				case CONSTRUCT:
				case DISPLAY:
				case INPUT:
				case MENU:
				case EXIT:
				case CONTINUE:
				case ALLOCATE:
				case LOCATE:
				case DEALLOCATE:
				case RESIZE:
				case FREE:
				case INITIALIZE:
				case VALIDATE:
				case START:
				case PAGE:
				case TERMINATE:
				case FINISH:
				case PAUSE:
				case NEED:
				case PRINT:
				case SKIP:
				case OUTPUT:
				case BEFORE:
				case AFTER:
				case ON:
				case NEXT:
				case ERROR:
				case MESSAGE:
				case PROMPT:
				case INSERT:
				case DELETE:
				case COMMAND:
				case SHOW:
				case HIDE:
				case FIRST:
				case OPTIONS:
				case CLEAR:
				case CLOSE:
				case CURRENT:
				case OPEN:
				case SCROLL:
				case DECLARE:
				case UPDATE:
				case FETCH:
				case FLUSH:
				case PUT:
				case DROP:
				case CREATE:
				case LOCK:
				case SELECT:
				case LOAD:
				case UNLOAD:
				case SET:
				case EXECUTE:
				case DATABASE:
				case BEGIN:
				case COMMIT:
				case ROLLBACK:
				case WHENEVER: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			break;
		}
		case NEED: {
			match(NEED);
			expression();
			match(LINES);
			break;
		}
		case PRINT: {
			match(PRINT);
			{
				if ((_tokenSet_74.member(LA(1)))
						&& (_tokenSet_75.member(LA(2)))) {
					{
						if ((_tokenSet_76.member(LA(1)))
								&& (_tokenSet_77.member(LA(2)))) {
							printExpressionList();
						} else if ((_tokenSet_78.member(LA(1)))
								&& (_tokenSet_13.member(LA(2)))) {
						} else {
							throw new NoViableAltException(LT(1), getFilename());
						}

					}
					{
						switch (LA(1)) {
						case SEMI: {
							match(SEMI);
							break;
						}
						case IDENT:
						case END:
						case DEFER:
						case RETURN:
						case RUN:
						case LET:
						case CALL:
						case GOTO:
						case PREPARE:
						case IF:
						case ELSE:
						case WHILE:
						case FOR:
						case FOREACH:
						case CASE:
						case WHEN:
						case OTHERWISE:
						case SLEEP:
						case CONSTRUCT:
						case DISPLAY:
						case INPUT:
						case MENU:
						case EXIT:
						case CONTINUE:
						case ALLOCATE:
						case LOCATE:
						case DEALLOCATE:
						case RESIZE:
						case FREE:
						case INITIALIZE:
						case VALIDATE:
						case START:
						case PAGE:
						case TERMINATE:
						case FINISH:
						case PAUSE:
						case NEED:
						case PRINT:
						case SKIP:
						case OUTPUT:
						case BEFORE:
						case AFTER:
						case ON:
						case NEXT:
						case ERROR:
						case MESSAGE:
						case PROMPT:
						case INSERT:
						case DELETE:
						case COMMAND:
						case SHOW:
						case HIDE:
						case FIRST:
						case OPTIONS:
						case CLEAR:
						case CLOSE:
						case CURRENT:
						case OPEN:
						case SCROLL:
						case DECLARE:
						case UPDATE:
						case FETCH:
						case FLUSH:
						case PUT:
						case DROP:
						case CREATE:
						case LOCK:
						case SELECT:
						case LOAD:
						case UNLOAD:
						case SET:
						case EXECUTE:
						case DATABASE:
						case BEGIN:
						case COMMIT:
						case ROLLBACK:
						case WHENEVER: {
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
				} else if ((LA(1) == FILE)) {
					match(FILE);
					string();
				} else if ((_tokenSet_12.member(LA(1)))
						&& (_tokenSet_13.member(LA(2)))) {
				} else {
					throw new NoViableAltException(LT(1), getFilename());
				}

			}
			break;
		}
		case SKIP: {
			match(SKIP);
			{
				switch (LA(1)) {
				case IDENT:
				case INTERRUPT:
				case LPAREN:
				case REAL:
				case DATE:
				case YEAR:
				case MONTH:
				case DAY:
				case STRING_LITERAL:
				case TRUE:
				case FALSE:
				case NOT:
				case NULL:
				case PLUS:
				case MINUS:
				case LENGTH:
				case AVG:
				case COUNT:
				case MAX:
				case MIN:
				case SUM:
				case USER:
				case GROUP:
				case TODAY:
				case WEEKDAY:
				case MDY:
				case COLUMN:
				case EXTEND:
				case TIME:
				case INFIELD:
				case PREPARE:
				case PAGENO:
				case LINENO:
				case HIDE:
				case FIRST:
				case LAST:
				case NO:
				case ACCEPT:
				case SQL:
				case CURRENT:
				case TEMP:
				case SIZE:
				case INDEX:
				case WAIT:
				case WORK:
				case FOUND:
				case NUM_INT:
				case NUM_REAL:
				case ASCII:
				case INT_FLAG:
				case NOTFOUND:
				case STATUS: {
					expression();
					{
						switch (LA(1)) {
						case LINE: {
							match(LINE);
							break;
						}
						case LINES: {
							match(LINES);
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
					break;
				}
				case TO: {
					match(TO);
					match(TOP);
					match(OF);
					match(PAGE);
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			break;
		}
		case OUTPUT: {
			match(OUTPUT);
			match(TO);
			match(REPORT);
			constantIdentifier();
			match(LPAREN);
			{
				switch (LA(1)) {
				case IDENT:
				case INTERRUPT:
				case LPAREN:
				case REAL:
				case DATE:
				case YEAR:
				case MONTH:
				case DAY:
				case STRING_LITERAL:
				case TRUE:
				case FALSE:
				case NOT:
				case NULL:
				case PLUS:
				case MINUS:
				case LENGTH:
				case AVG:
				case COUNT:
				case MAX:
				case MIN:
				case SUM:
				case USER:
				case GROUP:
				case TODAY:
				case WEEKDAY:
				case MDY:
				case COLUMN:
				case EXTEND:
				case TIME:
				case INFIELD:
				case PREPARE:
				case PAGENO:
				case LINENO:
				case HIDE:
				case FIRST:
				case LAST:
				case NO:
				case ACCEPT:
				case SQL:
				case CURRENT:
				case TEMP:
				case SIZE:
				case INDEX:
				case WAIT:
				case WORK:
				case FOUND:
				case NUM_INT:
				case NUM_REAL:
				case ASCII:
				case INT_FLAG:
				case NOTFOUND:
				case STATUS: {
					expression();
					{
						_loop369: do {
							if ((LA(1) == COMMA)) {
								match(COMMA);
								expression();
							} else {
								break _loop369;
							}

						} while (true);
					}
					break;
				}
				case RPAREN: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(RPAREN);
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void screenStatement() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case CLEAR: {
			match(CLEAR);
			{
				switch (LA(1)) {
				case FORM: {
					match(FORM);
					break;
				}
				case IDENT:
				case INTERRUPT:
				case LPAREN:
				case REAL:
				case DATE:
				case YEAR:
				case MONTH:
				case DAY:
				case STRING_LITERAL:
				case TRUE:
				case FALSE:
				case NOT:
				case NULL:
				case PLUS:
				case MINUS:
				case LENGTH:
				case AVG:
				case COUNT:
				case MAX:
				case MIN:
				case SUM:
				case USER:
				case GROUP:
				case TODAY:
				case WEEKDAY:
				case MDY:
				case COLUMN:
				case EXTEND:
				case TIME:
				case INFIELD:
				case PREPARE:
				case PAGENO:
				case LINENO:
				case HIDE:
				case FIRST:
				case LAST:
				case NO:
				case ACCEPT:
				case SQL:
				case CURRENT:
				case TEMP:
				case SIZE:
				case INDEX:
				case WAIT:
				case WORK:
				case FOUND:
				case NUM_INT:
				case NUM_REAL:
				case ASCII:
				case INT_FLAG:
				case NOTFOUND:
				case STATUS: {
					fieldList();
					break;
				}
				default:
					if ((LA(1) == WINDOW) && (LA(2) == IDENT)) {
						match(WINDOW);
						identifier();
					} else if ((LA(1) == WINDOW || LA(1) == SCREEN)
							&& (_tokenSet_79.member(LA(2)))) {
						{
							switch (LA(1)) {
							case WINDOW: {
								match(WINDOW);
								break;
							}
							case SCREEN: {
								break;
							}
							default: {
								throw new NoViableAltException(LT(1),
										getFilename());
							}
							}
						}
						match(SCREEN);
					} else {
						throw new NoViableAltException(LT(1), getFilename());
					}
				}
			}
			break;
		}
		case CONSTRUCT: {
			constructStatement();
			break;
		}
		case CURRENT: {
			match(CURRENT);
			match(WINDOW);
			match(IS);
			{
				switch (LA(1)) {
				case SCREEN: {
					match(SCREEN);
					break;
				}
				case IDENT: {
					identifier();
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			eol();
			break;
		}
		case ERROR: {
			errorStatement();
			break;
		}
		case MESSAGE: {
			messageStatement();
			break;
		}
		case PROMPT: {
			promptStatement();
			break;
		}
		case MENU: {
			menuStatement();
			break;
		}
		case OPTIONS: {
			optionsStatement();
			break;
		}
		case SCROLL: {
			match(SCROLL);
			fieldList();
			{
				_loop527: do {
					if ((LA(1) == COMMA)) {
						match(COMMA);
						fieldList();
					} else {
						break _loop527;
					}

				} while (true);
			}
			{
				switch (LA(1)) {
				case UP: {
					match(UP);
					break;
				}
				case DOWN: {
					match(DOWN);
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			{
				switch (LA(1)) {
				case BY: {
					match(BY);
					numericConstant();
					break;
				}
				case IDENT:
				case END:
				case DEFER:
				case RETURN:
				case RUN:
				case LET:
				case CALL:
				case GOTO:
				case PREPARE:
				case IF:
				case ELSE:
				case WHILE:
				case FOR:
				case FOREACH:
				case CASE:
				case WHEN:
				case OTHERWISE:
				case SLEEP:
				case CONSTRUCT:
				case DISPLAY:
				case INPUT:
				case MENU:
				case EXIT:
				case CONTINUE:
				case ALLOCATE:
				case LOCATE:
				case DEALLOCATE:
				case RESIZE:
				case FREE:
				case INITIALIZE:
				case VALIDATE:
				case START:
				case PAGE:
				case TERMINATE:
				case FINISH:
				case PAUSE:
				case NEED:
				case PRINT:
				case SKIP:
				case OUTPUT:
				case BEFORE:
				case AFTER:
				case ON:
				case NEXT:
				case ERROR:
				case MESSAGE:
				case PROMPT:
				case INSERT:
				case DELETE:
				case COMMAND:
				case SHOW:
				case HIDE:
				case FIRST:
				case OPTIONS:
				case CLEAR:
				case CLOSE:
				case CURRENT:
				case OPEN:
				case SCROLL:
				case DECLARE:
				case UPDATE:
				case FETCH:
				case FLUSH:
				case PUT:
				case DROP:
				case CREATE:
				case LOCK:
				case SELECT:
				case LOAD:
				case UNLOAD:
				case SET:
				case EXECUTE:
				case DATABASE:
				case BEGIN:
				case COMMIT:
				case ROLLBACK:
				case WHENEVER: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			break;
		}
		default:
			if ((LA(1) == CLOSE) && (LA(2) == WINDOW)) {
				match(CLOSE);
				match(WINDOW);
				identifier();
				eol();
			} else if ((LA(1) == CLOSE) && (LA(2) == FORM)) {
				match(CLOSE);
				match(FORM);
				identifier();
				eol();
			} else if ((LA(1) == DISPLAY) && (_tokenSet_80.member(LA(2)))) {
				displayStatement();
			} else if ((LA(1) == DISPLAY) && (LA(2) == ARRAY)) {
				displayArrayStatement();
			} else if ((LA(1) == DISPLAY) && (LA(2) == FORM)) {
				match(DISPLAY);
				match(FORM);
				identifier();
				{
					switch (LA(1)) {
					case ATTRIBUTE:
					case ATTRIBUTES: {
						attributeList();
						break;
					}
					case IDENT:
					case END:
					case DEFER:
					case RETURN:
					case RUN:
					case LET:
					case CALL:
					case GOTO:
					case PREPARE:
					case IF:
					case ELSE:
					case WHILE:
					case FOR:
					case FOREACH:
					case CASE:
					case WHEN:
					case OTHERWISE:
					case SLEEP:
					case CONSTRUCT:
					case DISPLAY:
					case INPUT:
					case MENU:
					case EXIT:
					case CONTINUE:
					case ALLOCATE:
					case LOCATE:
					case DEALLOCATE:
					case RESIZE:
					case FREE:
					case INITIALIZE:
					case VALIDATE:
					case START:
					case PAGE:
					case TERMINATE:
					case FINISH:
					case PAUSE:
					case NEED:
					case PRINT:
					case SKIP:
					case OUTPUT:
					case BEFORE:
					case AFTER:
					case ON:
					case NEXT:
					case ERROR:
					case MESSAGE:
					case PROMPT:
					case INSERT:
					case DELETE:
					case COMMAND:
					case SHOW:
					case HIDE:
					case FIRST:
					case OPTIONS:
					case CLEAR:
					case CLOSE:
					case CURRENT:
					case OPEN:
					case SCROLL:
					case DECLARE:
					case UPDATE:
					case FETCH:
					case FLUSH:
					case PUT:
					case DROP:
					case CREATE:
					case LOCK:
					case SELECT:
					case LOAD:
					case UNLOAD:
					case SET:
					case EXECUTE:
					case DATABASE:
					case BEGIN:
					case COMMIT:
					case ROLLBACK:
					case WHENEVER: {
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
				eol();
			} else if ((LA(1) == INPUT) && (_tokenSet_80.member(LA(2)))) {
				inputStatement();
			} else if ((LA(1) == INPUT) && (LA(2) == ARRAY)) {
				inputArrayStatement();
			} else if ((LA(1) == OPEN) && (LA(2) == FORM)) {
				match(OPEN);
				match(FORM);
				expression();
				match(FROM);
				expression();
			} else if ((LA(1) == OPEN) && (LA(2) == WINDOW)) {
				match(OPEN);
				match(WINDOW);
				expression();
				match(AT);
				expression();
				match(COMMA);
				expression();
				{
					if ((LA(1) == WITH) && (LA(2) == FORM)) {
						match(WITH);
						match(FORM);
						expression();
					} else if ((LA(1) == WITH) && (_tokenSet_10.member(LA(2)))) {
						match(WITH);
						expression();
						match(ROWS);
						match(COMMA);
						expression();
						match(COLUMNS);
					} else {
						throw new NoViableAltException(LT(1), getFilename());
					}

				}
				{
					switch (LA(1)) {
					case ATTRIBUTE:
					case ATTRIBUTES: {
						windowAttributeList();
						break;
					}
					case IDENT:
					case END:
					case DEFER:
					case RETURN:
					case RUN:
					case LET:
					case CALL:
					case GOTO:
					case PREPARE:
					case IF:
					case ELSE:
					case WHILE:
					case FOR:
					case FOREACH:
					case CASE:
					case WHEN:
					case OTHERWISE:
					case SLEEP:
					case CONSTRUCT:
					case DISPLAY:
					case INPUT:
					case MENU:
					case EXIT:
					case CONTINUE:
					case ALLOCATE:
					case LOCATE:
					case DEALLOCATE:
					case RESIZE:
					case FREE:
					case INITIALIZE:
					case VALIDATE:
					case START:
					case PAGE:
					case TERMINATE:
					case FINISH:
					case PAUSE:
					case NEED:
					case PRINT:
					case SKIP:
					case OUTPUT:
					case BEFORE:
					case AFTER:
					case ON:
					case NEXT:
					case ERROR:
					case MESSAGE:
					case PROMPT:
					case INSERT:
					case DELETE:
					case COMMAND:
					case SHOW:
					case HIDE:
					case FIRST:
					case OPTIONS:
					case CLEAR:
					case CLOSE:
					case CURRENT:
					case OPEN:
					case SCROLL:
					case DECLARE:
					case UPDATE:
					case FETCH:
					case FLUSH:
					case PUT:
					case DROP:
					case CREATE:
					case LOCK:
					case SELECT:
					case LOAD:
					case UNLOAD:
					case SET:
					case EXECUTE:
					case DATABASE:
					case BEGIN:
					case COMMIT:
					case ROLLBACK:
					case WHENEVER: {
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}
		}
	}

	public final void exitStatements() throws RecognitionException,
			TokenStreamException {

		if ((LA(1) == EXIT) && (_tokenSet_81.member(LA(2)))) {
			match(EXIT);
			exitTypes();
		} else if ((LA(1) == EXIT) && (LA(2) == PROGRAM)) {
			match(EXIT);
			match(PROGRAM);
			{
				if ((LA(1) == LPAREN) && (_tokenSet_10.member(LA(2)))) {
					match(LPAREN);
					expression();
					match(RPAREN);
				} else if ((_tokenSet_10.member(LA(1)))
						&& (_tokenSet_82.member(LA(2)))) {
					expression();
				} else if ((_tokenSet_12.member(LA(1)))
						&& (_tokenSet_13.member(LA(2)))) {
				} else {
					throw new NoViableAltException(LT(1), getFilename());
				}

			}
		} else {
			throw new NoViableAltException(LT(1), getFilename());
		}

	}

	public final void continueStatements() throws RecognitionException,
			TokenStreamException {

		match(CONTINUE);
		exitTypes();
		eol();
	}

	public final void exitTypes() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case FOREACH: {
			match(FOREACH);
			break;
		}
		case FOR: {
			match(FOR);
			break;
		}
		case CASE: {
			match(CASE);
			break;
		}
		case CONSTRUCT: {
			match(CONSTRUCT);
			break;
		}
		case DISPLAY: {
			match(DISPLAY);
			break;
		}
		case INPUT: {
			match(INPUT);
			break;
		}
		case MENU: {
			match(MENU);
			break;
		}
		case REPORT: {
			match(REPORT);
			break;
		}
		case WHILE: {
			match(WHILE);
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void printExpressionItem() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case BYTE: {
			match(BYTE);
			variable();
			break;
		}
		case TEXT: {
			match(TEXT);
			variable();
			break;
		}
		default:
			if ((LA(1) == COLUMN) && (_tokenSet_10.member(LA(2)))) {
				match(COLUMN);
				expression();
			} else if ((LA(1) == PAGENO) && (_tokenSet_83.member(LA(2)))) {
				match(PAGENO);
			} else if ((LA(1) == LINENO) && (_tokenSet_83.member(LA(2)))) {
				match(LINENO);
			} else if ((_tokenSet_10.member(LA(1)))
					&& (_tokenSet_77.member(LA(2)))) {
				expression();
				{
					switch (LA(1)) {
					case SPACE: {
						match(SPACE);
						break;
					}
					case SPACES: {
						match(SPACES);
						break;
					}
					case IDENT:
					case END:
					case DEFER:
					case RETURN:
					case COMMA:
					case SEMI:
					case RUN:
					case LET:
					case CALL:
					case GOTO:
					case PREPARE:
					case IF:
					case ELSE:
					case WHILE:
					case FOR:
					case FOREACH:
					case CASE:
					case WHEN:
					case OTHERWISE:
					case SLEEP:
					case CONSTRUCT:
					case DISPLAY:
					case INPUT:
					case MENU:
					case EXIT:
					case CONTINUE:
					case ALLOCATE:
					case LOCATE:
					case DEALLOCATE:
					case RESIZE:
					case FREE:
					case INITIALIZE:
					case VALIDATE:
					case WORDWRAP:
					case START:
					case PAGE:
					case TERMINATE:
					case FINISH:
					case PAUSE:
					case NEED:
					case PRINT:
					case SKIP:
					case OUTPUT:
					case BEFORE:
					case AFTER:
					case ON:
					case NEXT:
					case ERROR:
					case MESSAGE:
					case PROMPT:
					case INSERT:
					case DELETE:
					case COMMAND:
					case SHOW:
					case HIDE:
					case FIRST:
					case OPTIONS:
					case CLEAR:
					case CLOSE:
					case CURRENT:
					case OPEN:
					case SCROLL:
					case DECLARE:
					case UPDATE:
					case FETCH:
					case FLUSH:
					case PUT:
					case DROP:
					case CREATE:
					case LOCK:
					case SELECT:
					case LOAD:
					case UNLOAD:
					case SET:
					case EXECUTE:
					case DATABASE:
					case BEGIN:
					case COMMIT:
					case ROLLBACK:
					case WHENEVER: {
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
				{
					switch (LA(1)) {
					case WORDWRAP: {
						match(WORDWRAP);
						{
							switch (LA(1)) {
							case RIGHT: {
								match(RIGHT);
								match(MARGIN);
								numericConstant();
								break;
							}
							case IDENT:
							case END:
							case DEFER:
							case RETURN:
							case COMMA:
							case SEMI:
							case RUN:
							case LET:
							case CALL:
							case GOTO:
							case PREPARE:
							case IF:
							case ELSE:
							case WHILE:
							case FOR:
							case FOREACH:
							case CASE:
							case WHEN:
							case OTHERWISE:
							case SLEEP:
							case CONSTRUCT:
							case DISPLAY:
							case INPUT:
							case MENU:
							case EXIT:
							case CONTINUE:
							case ALLOCATE:
							case LOCATE:
							case DEALLOCATE:
							case RESIZE:
							case FREE:
							case INITIALIZE:
							case VALIDATE:
							case START:
							case PAGE:
							case TERMINATE:
							case FINISH:
							case PAUSE:
							case NEED:
							case PRINT:
							case SKIP:
							case OUTPUT:
							case BEFORE:
							case AFTER:
							case ON:
							case NEXT:
							case ERROR:
							case MESSAGE:
							case PROMPT:
							case INSERT:
							case DELETE:
							case COMMAND:
							case SHOW:
							case HIDE:
							case FIRST:
							case OPTIONS:
							case CLEAR:
							case CLOSE:
							case CURRENT:
							case OPEN:
							case SCROLL:
							case DECLARE:
							case UPDATE:
							case FETCH:
							case FLUSH:
							case PUT:
							case DROP:
							case CREATE:
							case LOCK:
							case SELECT:
							case LOAD:
							case UNLOAD:
							case SET:
							case EXECUTE:
							case DATABASE:
							case BEGIN:
							case COMMIT:
							case ROLLBACK:
							case WHENEVER: {
								break;
							}
							default: {
								throw new NoViableAltException(LT(1),
										getFilename());
							}
							}
						}
						break;
					}
					case IDENT:
					case END:
					case DEFER:
					case RETURN:
					case COMMA:
					case SEMI:
					case RUN:
					case LET:
					case CALL:
					case GOTO:
					case PREPARE:
					case IF:
					case ELSE:
					case WHILE:
					case FOR:
					case FOREACH:
					case CASE:
					case WHEN:
					case OTHERWISE:
					case SLEEP:
					case CONSTRUCT:
					case DISPLAY:
					case INPUT:
					case MENU:
					case EXIT:
					case CONTINUE:
					case ALLOCATE:
					case LOCATE:
					case DEALLOCATE:
					case RESIZE:
					case FREE:
					case INITIALIZE:
					case VALIDATE:
					case START:
					case PAGE:
					case TERMINATE:
					case FINISH:
					case PAUSE:
					case NEED:
					case PRINT:
					case SKIP:
					case OUTPUT:
					case BEFORE:
					case AFTER:
					case ON:
					case NEXT:
					case ERROR:
					case MESSAGE:
					case PROMPT:
					case INSERT:
					case DELETE:
					case COMMAND:
					case SHOW:
					case HIDE:
					case FIRST:
					case OPTIONS:
					case CLEAR:
					case CLOSE:
					case CURRENT:
					case OPEN:
					case SCROLL:
					case DECLARE:
					case UPDATE:
					case FETCH:
					case FLUSH:
					case PUT:
					case DROP:
					case CREATE:
					case LOCK:
					case SELECT:
					case LOAD:
					case UNLOAD:
					case SET:
					case EXECUTE:
					case DATABASE:
					case BEGIN:
					case COMMIT:
					case ROLLBACK:
					case WHENEVER: {
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}
		}
	}

	public final void printExpressionList() throws RecognitionException,
			TokenStreamException {

		printExpressionItem();
		{
			_loop348: do {
				if ((LA(1) == COMMA)) {
					match(COMMA);
					printExpressionItem();
				} else {
					break _loop348;
				}

			} while (true);
		}
	}

	public final void thruNotation() throws RecognitionException,
			TokenStreamException {

		{
			switch (LA(1)) {
			case THROUGH:
			case THRU: {
				{
					switch (LA(1)) {
					case THROUGH: {
						match(THROUGH);
						break;
					}
					case THRU: {
						match(THRU);
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
				{
					switch (LA(1)) {
					case SAME: {
						match(SAME);
						match(DOT);
						break;
					}
					case IDENT: {
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
				identifier();
				break;
			}
			case IDENT:
			case END:
			case DEFER:
			case RETURN:
			case RUN:
			case LET:
			case CALL:
			case GOTO:
			case PREPARE:
			case IF:
			case ELSE:
			case WHILE:
			case FOR:
			case FOREACH:
			case CASE:
			case WHEN:
			case OTHERWISE:
			case SLEEP:
			case CONSTRUCT:
			case DISPLAY:
			case INPUT:
			case MENU:
			case EXIT:
			case CONTINUE:
			case ALLOCATE:
			case LOCATE:
			case DEALLOCATE:
			case RESIZE:
			case FREE:
			case INITIALIZE:
			case VALIDATE:
			case START:
			case PAGE:
			case TERMINATE:
			case FINISH:
			case PAUSE:
			case NEED:
			case PRINT:
			case SKIP:
			case OUTPUT:
			case BEFORE:
			case AFTER:
			case ON:
			case NEXT:
			case ERROR:
			case MESSAGE:
			case PROMPT:
			case INSERT:
			case DELETE:
			case COMMAND:
			case SHOW:
			case HIDE:
			case FIRST:
			case OPTIONS:
			case CLEAR:
			case CLOSE:
			case CURRENT:
			case OPEN:
			case SCROLL:
			case DECLARE:
			case UPDATE:
			case FETCH:
			case FLUSH:
			case PUT:
			case DROP:
			case CREATE:
			case LOCK:
			case SELECT:
			case LOAD:
			case UNLOAD:
			case SET:
			case EXECUTE:
			case DATABASE:
			case BEGIN:
			case COMMIT:
			case ROLLBACK:
			case WHENEVER: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
	}

	public final void fieldName() throws RecognitionException,
			TokenStreamException {

		if ((LA(1) == IDENT) && (_tokenSet_73.member(LA(2)))) {
			{
				if ((LA(1) == IDENT) && (LA(2) == DOT || LA(2) == LBRACK)) {
					{
						identifier();
						{
							switch (LA(1)) {
							case LBRACK: {
								match(LBRACK);
								numericConstant();
								match(RBRACK);
								break;
							}
							case DOT: {
								break;
							}
							default: {
								throw new NoViableAltException(LT(1),
										getFilename());
							}
							}
						}
					}
					match(DOT);
				} else if ((LA(1) == IDENT) && (_tokenSet_12.member(LA(2)))) {
				} else {
					throw new NoViableAltException(LT(1), getFilename());
				}

			}
			identifier();
		} else if ((LA(1) == IDENT) && (LA(2) == DOT || LA(2) == LBRACK)) {
			{
				identifier();
				{
					switch (LA(1)) {
					case LBRACK: {
						match(LBRACK);
						numericConstant();
						match(RBRACK);
						break;
					}
					case DOT: {
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
			}
			match(DOT);
			{
				switch (LA(1)) {
				case STAR: {
					match(STAR);
					break;
				}
				case IDENT: {
					identifier();
					thruNotation();
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
		} else {
			throw new NoViableAltException(LT(1), getFilename());
		}

	}

	public final void fieldList() throws RecognitionException,
			TokenStreamException {

		expression();
		{
			_loop383: do {
				if ((LA(1) == COMMA) && (_tokenSet_10.member(LA(2)))) {
					match(COMMA);
					expression();
				} else {
					break _loop383;
				}

			} while (true);
		}
	}

	public final void keyList() throws RecognitionException,
			TokenStreamException {

		expression();
		{
			_loop386: do {
				if ((LA(1) == COMMA)) {
					match(COMMA);
					expression();
				} else {
					break _loop386;
				}

			} while (true);
		}
	}

	public final void constructEvents() throws RecognitionException,
			TokenStreamException {

		if ((LA(1) == BEFORE) && (LA(2) == CONSTRUCT)) {
			match(BEFORE);
			match(CONSTRUCT);
		} else if ((LA(1) == AFTER) && (LA(2) == CONSTRUCT)) {
			match(AFTER);
			match(CONSTRUCT);
		} else if ((LA(1) == BEFORE) && (LA(2) == FIELD)) {
			match(BEFORE);
			match(FIELD);
			fieldList();
		} else if ((LA(1) == AFTER) && (LA(2) == FIELD)) {
			match(AFTER);
			match(FIELD);
			fieldList();
		} else if ((LA(1) == ON)) {
			match(ON);
			match(KEY);
			match(LPAREN);
			{
				keyList();
			}
			match(RPAREN);
		} else {
			throw new NoViableAltException(LT(1), getFilename());
		}

	}

	public final void specialAttribute() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case REVERSE: {
			match(REVERSE);
			break;
		}
		case BLINK: {
			match(BLINK);
			break;
		}
		case UNDERLINE: {
			match(UNDERLINE);
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void attribute() throws RecognitionException,
			TokenStreamException {

		{
			switch (LA(1)) {
			case BLACK: {
				match(BLACK);
				break;
			}
			case BLUE: {
				match(BLUE);
				break;
			}
			case CYAN: {
				match(CYAN);
				break;
			}
			case GREEN: {
				match(GREEN);
				break;
			}
			case MAGENTA: {
				match(MAGENTA);
				break;
			}
			case RED: {
				match(RED);
				break;
			}
			case WHITE: {
				match(WHITE);
				break;
			}
			case YELLOW: {
				match(YELLOW);
				break;
			}
			case BOLD: {
				match(BOLD);
				break;
			}
			case DIM: {
				match(DIM);
				break;
			}
			case NORMAL: {
				match(NORMAL);
				break;
			}
			case INVISIBLE: {
				match(INVISIBLE);
				break;
			}
			case REVERSE:
			case BLINK:
			case UNDERLINE: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		specialAttribute();
		{
			_loop395: do {
				if ((LA(1) == COMMA)) {
					match(COMMA);
					specialAttribute();
				} else {
					break _loop395;
				}

			} while (true);
		}
	}

	public final void attributeList() throws RecognitionException,
			TokenStreamException {

		{
			switch (LA(1)) {
			case ATTRIBUTE: {
				match(ATTRIBUTE);
				break;
			}
			case ATTRIBUTES: {
				match(ATTRIBUTES);
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		match(LPAREN);
		attribute();
		match(RPAREN);
	}

	public final void constructGroupStatement() throws RecognitionException,
			TokenStreamException {

		constructEvents();
		{
			int _cnt400 = 0;
			_loop400: do {
				if ((_tokenSet_84.member(LA(1)))) {
					codeBlock();
				} else {
					if (_cnt400 >= 1) {
						break _loop400;
					} else {
						throw new NoViableAltException(LT(1), getFilename());
					}
				}

				_cnt400++;
			} while (true);
		}
	}

	public final void constructStatement() throws RecognitionException,
			TokenStreamException {

		match(CONSTRUCT);
		{
			switch (LA(1)) {
			case BY: {
				match(BY);
				match(NAME);
				variable();
				match(ON);
				columnsList();
				break;
			}
			case IDENT:
			case INTERRUPT:
			case REAL:
			case TRUE:
			case FALSE:
			case NOT:
			case NULL:
			case LENGTH:
			case COUNT:
			case USER:
			case GROUP:
			case TODAY:
			case WEEKDAY:
			case MDY:
			case TIME:
			case PAGENO:
			case LINENO:
			case HIDE:
			case FIRST:
			case LAST:
			case NO:
			case ACCEPT:
			case SQL:
			case CURRENT:
			case TEMP:
			case SIZE:
			case INDEX:
			case WAIT:
			case WORK:
			case FOUND:
			case ASCII:
			case INT_FLAG:
			case NOTFOUND:
			case STATUS: {
				variable();
				match(ON);
				columnsList();
				match(FROM);
				fieldList();
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		{
			switch (LA(1)) {
			case ATTRIBUTE:
			case ATTRIBUTES: {
				attributeList();
				break;
			}
			case IDENT:
			case END:
			case DEFER:
			case RETURN:
			case RUN:
			case LET:
			case CALL:
			case GOTO:
			case PREPARE:
			case IF:
			case ELSE:
			case WHILE:
			case FOR:
			case FOREACH:
			case CASE:
			case WHEN:
			case OTHERWISE:
			case SLEEP:
			case CONSTRUCT:
			case DISPLAY:
			case INPUT:
			case MENU:
			case EXIT:
			case CONTINUE:
			case ALLOCATE:
			case LOCATE:
			case DEALLOCATE:
			case RESIZE:
			case FREE:
			case INITIALIZE:
			case VALIDATE:
			case START:
			case PAGE:
			case TERMINATE:
			case FINISH:
			case PAUSE:
			case NEED:
			case PRINT:
			case SKIP:
			case OUTPUT:
			case BEFORE:
			case AFTER:
			case ON:
			case NEXT:
			case HELP:
			case ERROR:
			case MESSAGE:
			case PROMPT:
			case INSERT:
			case DELETE:
			case COMMAND:
			case SHOW:
			case HIDE:
			case FIRST:
			case OPTIONS:
			case CLEAR:
			case CLOSE:
			case CURRENT:
			case OPEN:
			case SCROLL:
			case DECLARE:
			case UPDATE:
			case FETCH:
			case FLUSH:
			case PUT:
			case DROP:
			case CREATE:
			case LOCK:
			case SELECT:
			case LOAD:
			case UNLOAD:
			case SET:
			case EXECUTE:
			case DATABASE:
			case BEGIN:
			case COMMIT:
			case ROLLBACK:
			case WHENEVER: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		{
			switch (LA(1)) {
			case HELP: {
				match(HELP);
				numericConstant();
				break;
			}
			case IDENT:
			case END:
			case DEFER:
			case RETURN:
			case RUN:
			case LET:
			case CALL:
			case GOTO:
			case PREPARE:
			case IF:
			case ELSE:
			case WHILE:
			case FOR:
			case FOREACH:
			case CASE:
			case WHEN:
			case OTHERWISE:
			case SLEEP:
			case CONSTRUCT:
			case DISPLAY:
			case INPUT:
			case MENU:
			case EXIT:
			case CONTINUE:
			case ALLOCATE:
			case LOCATE:
			case DEALLOCATE:
			case RESIZE:
			case FREE:
			case INITIALIZE:
			case VALIDATE:
			case START:
			case PAGE:
			case TERMINATE:
			case FINISH:
			case PAUSE:
			case NEED:
			case PRINT:
			case SKIP:
			case OUTPUT:
			case BEFORE:
			case AFTER:
			case ON:
			case NEXT:
			case ERROR:
			case MESSAGE:
			case PROMPT:
			case INSERT:
			case DELETE:
			case COMMAND:
			case SHOW:
			case HIDE:
			case FIRST:
			case OPTIONS:
			case CLEAR:
			case CLOSE:
			case CURRENT:
			case OPEN:
			case SCROLL:
			case DECLARE:
			case UPDATE:
			case FETCH:
			case FLUSH:
			case PUT:
			case DROP:
			case CREATE:
			case LOCK:
			case SELECT:
			case LOAD:
			case UNLOAD:
			case SET:
			case EXECUTE:
			case DATABASE:
			case BEGIN:
			case COMMIT:
			case ROLLBACK:
			case WHENEVER: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		{
			if ((_tokenSet_85.member(LA(1))) && (_tokenSet_86.member(LA(2)))) {
				{
					int _cnt407 = 0;
					_loop407: do {
						if ((_tokenSet_85.member(LA(1)))) {
							constructGroupStatement();
						} else {
							if (_cnt407 >= 1) {
								break _loop407;
							} else {
								throw new NoViableAltException(LT(1),
										getFilename());
							}
						}

						_cnt407++;
					} while (true);
				}
				match(END);
				match(CONSTRUCT);
			} else if ((_tokenSet_12.member(LA(1)))
					&& (_tokenSet_13.member(LA(2)))) {
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}

		}
	}

	public final void columnsList() throws RecognitionException,
			TokenStreamException {

		columnsTableId();
		{
			_loop546: do {
				if ((LA(1) == COMMA)) {
					match(COMMA);
					columnsTableId();
				} else {
					break _loop546;
				}

			} while (true);
		}
	}

	public final void displayArrayStatement() throws RecognitionException,
			TokenStreamException {

		match(DISPLAY);
		match(ARRAY);
		expression();
		match(TO);
		expression();
		{
			switch (LA(1)) {
			case ATTRIBUTE:
			case ATTRIBUTES: {
				attributeList();
				break;
			}
			case IDENT:
			case END:
			case DEFER:
			case RETURN:
			case RUN:
			case LET:
			case CALL:
			case GOTO:
			case PREPARE:
			case IF:
			case ELSE:
			case WHILE:
			case FOR:
			case FOREACH:
			case CASE:
			case WHEN:
			case OTHERWISE:
			case SLEEP:
			case CONSTRUCT:
			case DISPLAY:
			case INPUT:
			case MENU:
			case EXIT:
			case CONTINUE:
			case ALLOCATE:
			case LOCATE:
			case DEALLOCATE:
			case RESIZE:
			case FREE:
			case INITIALIZE:
			case VALIDATE:
			case START:
			case PAGE:
			case TERMINATE:
			case FINISH:
			case PAUSE:
			case NEED:
			case PRINT:
			case SKIP:
			case OUTPUT:
			case BEFORE:
			case AFTER:
			case ON:
			case NEXT:
			case ERROR:
			case MESSAGE:
			case PROMPT:
			case INSERT:
			case DELETE:
			case COMMAND:
			case SHOW:
			case HIDE:
			case FIRST:
			case OPTIONS:
			case CLEAR:
			case CLOSE:
			case CURRENT:
			case OPEN:
			case SCROLL:
			case DECLARE:
			case UPDATE:
			case FETCH:
			case FLUSH:
			case PUT:
			case DROP:
			case CREATE:
			case LOCK:
			case SELECT:
			case LOAD:
			case UNLOAD:
			case SET:
			case EXECUTE:
			case DATABASE:
			case BEGIN:
			case COMMIT:
			case ROLLBACK:
			case WHENEVER: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		{
			_loop411: do {
				if ((LA(1) == ON) && (LA(2) == KEY)) {
					displayEvents();
				} else {
					break _loop411;
				}

			} while (true);
		}
		{
			if ((LA(1) == END) && (LA(2) == DISPLAY)) {
				match(END);
				match(DISPLAY);
			} else if ((_tokenSet_12.member(LA(1)))
					&& (_tokenSet_13.member(LA(2)))) {
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}

		}
	}

	public final void displayEvents() throws RecognitionException,
			TokenStreamException {

		match(ON);
		match(KEY);
		match(LPAREN);
		keyList();
		match(RPAREN);
		{
			{
				int _cnt417 = 0;
				_loop417: do {
					if ((_tokenSet_84.member(LA(1)))
							&& (_tokenSet_4.member(LA(2)))) {
						codeBlock();
					} else {
						if (_cnt417 >= 1) {
							break _loop417;
						} else {
							throw new NoViableAltException(LT(1), getFilename());
						}
					}

					_cnt417++;
				} while (true);
			}
		}
	}

	public final void displayStatement() throws RecognitionException,
			TokenStreamException {

		match(DISPLAY);
		{
			switch (LA(1)) {
			case BY: {
				match(BY);
				match(NAME);
				{
					expression();
					{
						_loop422: do {
							if ((LA(1) == COMMA)) {
								match(COMMA);
								expression();
							} else {
								break _loop422;
							}

						} while (true);
					}
				}
				break;
			}
			case IDENT:
			case INTERRUPT:
			case LPAREN:
			case REAL:
			case DATE:
			case YEAR:
			case MONTH:
			case DAY:
			case STRING_LITERAL:
			case TRUE:
			case FALSE:
			case NOT:
			case NULL:
			case PLUS:
			case MINUS:
			case LENGTH:
			case AVG:
			case COUNT:
			case MAX:
			case MIN:
			case SUM:
			case USER:
			case GROUP:
			case TODAY:
			case WEEKDAY:
			case MDY:
			case COLUMN:
			case EXTEND:
			case TIME:
			case INFIELD:
			case PREPARE:
			case PAGENO:
			case LINENO:
			case HIDE:
			case FIRST:
			case LAST:
			case NO:
			case ACCEPT:
			case SQL:
			case CURRENT:
			case TEMP:
			case SIZE:
			case INDEX:
			case WAIT:
			case WORK:
			case FOUND:
			case NUM_INT:
			case NUM_REAL:
			case ASCII:
			case INT_FLAG:
			case NOTFOUND:
			case STATUS: {
				{
					expression();
					{
						_loop425: do {
							if ((LA(1) == COMMA)) {
								match(COMMA);
								expression();
							} else {
								break _loop425;
							}

						} while (true);
					}
				}
				{
					switch (LA(1)) {
					case TO: {
						match(TO);
						fieldList();
						break;
					}
					case AT: {
						match(AT);
						expression();
						match(COMMA);
						expression();
						break;
					}
					case IDENT:
					case END:
					case DEFER:
					case RETURN:
					case RUN:
					case LET:
					case CALL:
					case GOTO:
					case PREPARE:
					case IF:
					case ELSE:
					case WHILE:
					case FOR:
					case FOREACH:
					case CASE:
					case WHEN:
					case OTHERWISE:
					case SLEEP:
					case CONSTRUCT:
					case DISPLAY:
					case INPUT:
					case MENU:
					case EXIT:
					case CONTINUE:
					case ALLOCATE:
					case LOCATE:
					case DEALLOCATE:
					case RESIZE:
					case FREE:
					case INITIALIZE:
					case VALIDATE:
					case START:
					case PAGE:
					case TERMINATE:
					case FINISH:
					case PAUSE:
					case NEED:
					case PRINT:
					case SKIP:
					case OUTPUT:
					case BEFORE:
					case AFTER:
					case ON:
					case NEXT:
					case ATTRIBUTE:
					case ATTRIBUTES:
					case ERROR:
					case MESSAGE:
					case PROMPT:
					case INSERT:
					case DELETE:
					case COMMAND:
					case SHOW:
					case HIDE:
					case FIRST:
					case OPTIONS:
					case CLEAR:
					case CLOSE:
					case CURRENT:
					case OPEN:
					case SCROLL:
					case DECLARE:
					case UPDATE:
					case FETCH:
					case FLUSH:
					case PUT:
					case DROP:
					case CREATE:
					case LOCK:
					case SELECT:
					case LOAD:
					case UNLOAD:
					case SET:
					case EXECUTE:
					case DATABASE:
					case BEGIN:
					case COMMIT:
					case ROLLBACK:
					case WHENEVER: {
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		{
			switch (LA(1)) {
			case ATTRIBUTE:
			case ATTRIBUTES: {
				attributeList();
				break;
			}
			case IDENT:
			case END:
			case DEFER:
			case RETURN:
			case RUN:
			case LET:
			case CALL:
			case GOTO:
			case PREPARE:
			case IF:
			case ELSE:
			case WHILE:
			case FOR:
			case FOREACH:
			case CASE:
			case WHEN:
			case OTHERWISE:
			case SLEEP:
			case CONSTRUCT:
			case DISPLAY:
			case INPUT:
			case MENU:
			case EXIT:
			case CONTINUE:
			case ALLOCATE:
			case LOCATE:
			case DEALLOCATE:
			case RESIZE:
			case FREE:
			case INITIALIZE:
			case VALIDATE:
			case START:
			case PAGE:
			case TERMINATE:
			case FINISH:
			case PAUSE:
			case NEED:
			case PRINT:
			case SKIP:
			case OUTPUT:
			case BEFORE:
			case AFTER:
			case ON:
			case NEXT:
			case ERROR:
			case MESSAGE:
			case PROMPT:
			case INSERT:
			case DELETE:
			case COMMAND:
			case SHOW:
			case HIDE:
			case FIRST:
			case OPTIONS:
			case CLEAR:
			case CLOSE:
			case CURRENT:
			case OPEN:
			case SCROLL:
			case DECLARE:
			case UPDATE:
			case FETCH:
			case FLUSH:
			case PUT:
			case DROP:
			case CREATE:
			case LOCK:
			case SELECT:
			case LOAD:
			case UNLOAD:
			case SET:
			case EXECUTE:
			case DATABASE:
			case BEGIN:
			case COMMIT:
			case ROLLBACK:
			case WHENEVER: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		eol();
	}

	public final void errorStatement() throws RecognitionException,
			TokenStreamException {

		match(ERROR);
		expression();
		{
			_loop430: do {
				if ((LA(1) == COMMA)) {
					match(COMMA);
					expression();
				} else {
					break _loop430;
				}

			} while (true);
		}
		{
			switch (LA(1)) {
			case ATTRIBUTE:
			case ATTRIBUTES: {
				attributeList();
				break;
			}
			case IDENT:
			case END:
			case DEFER:
			case RETURN:
			case RUN:
			case LET:
			case CALL:
			case GOTO:
			case PREPARE:
			case IF:
			case ELSE:
			case WHILE:
			case FOR:
			case FOREACH:
			case CASE:
			case WHEN:
			case OTHERWISE:
			case SLEEP:
			case CONSTRUCT:
			case DISPLAY:
			case INPUT:
			case MENU:
			case EXIT:
			case CONTINUE:
			case ALLOCATE:
			case LOCATE:
			case DEALLOCATE:
			case RESIZE:
			case FREE:
			case INITIALIZE:
			case VALIDATE:
			case START:
			case PAGE:
			case TERMINATE:
			case FINISH:
			case PAUSE:
			case NEED:
			case PRINT:
			case SKIP:
			case OUTPUT:
			case BEFORE:
			case AFTER:
			case ON:
			case NEXT:
			case ERROR:
			case MESSAGE:
			case PROMPT:
			case INSERT:
			case DELETE:
			case COMMAND:
			case SHOW:
			case HIDE:
			case FIRST:
			case OPTIONS:
			case CLEAR:
			case CLOSE:
			case CURRENT:
			case OPEN:
			case SCROLL:
			case DECLARE:
			case UPDATE:
			case FETCH:
			case FLUSH:
			case PUT:
			case DROP:
			case CREATE:
			case LOCK:
			case SELECT:
			case LOAD:
			case UNLOAD:
			case SET:
			case EXECUTE:
			case DATABASE:
			case BEGIN:
			case COMMIT:
			case ROLLBACK:
			case WHENEVER: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
	}

	public final void messageStatement() throws RecognitionException,
			TokenStreamException {

		match(MESSAGE);
		expression();
		{
			_loop434: do {
				if ((LA(1) == COMMA)) {
					match(COMMA);
					expression();
				} else {
					break _loop434;
				}

			} while (true);
		}
		{
			switch (LA(1)) {
			case ATTRIBUTE:
			case ATTRIBUTES: {
				attributeList();
				break;
			}
			case IDENT:
			case END:
			case DEFER:
			case RETURN:
			case RUN:
			case LET:
			case CALL:
			case GOTO:
			case PREPARE:
			case IF:
			case ELSE:
			case WHILE:
			case FOR:
			case FOREACH:
			case CASE:
			case WHEN:
			case OTHERWISE:
			case SLEEP:
			case CONSTRUCT:
			case DISPLAY:
			case INPUT:
			case MENU:
			case EXIT:
			case CONTINUE:
			case ALLOCATE:
			case LOCATE:
			case DEALLOCATE:
			case RESIZE:
			case FREE:
			case INITIALIZE:
			case VALIDATE:
			case START:
			case PAGE:
			case TERMINATE:
			case FINISH:
			case PAUSE:
			case NEED:
			case PRINT:
			case SKIP:
			case OUTPUT:
			case BEFORE:
			case AFTER:
			case ON:
			case NEXT:
			case ERROR:
			case MESSAGE:
			case PROMPT:
			case INSERT:
			case DELETE:
			case COMMAND:
			case SHOW:
			case HIDE:
			case FIRST:
			case OPTIONS:
			case CLEAR:
			case CLOSE:
			case CURRENT:
			case OPEN:
			case SCROLL:
			case DECLARE:
			case UPDATE:
			case FETCH:
			case FLUSH:
			case PUT:
			case DROP:
			case CREATE:
			case LOCK:
			case SELECT:
			case LOAD:
			case UNLOAD:
			case SET:
			case EXECUTE:
			case DATABASE:
			case BEGIN:
			case COMMIT:
			case ROLLBACK:
			case WHENEVER: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
	}

	public final void promptStatement() throws RecognitionException,
			TokenStreamException {

		match(PROMPT);
		expression();
		{
			_loop438: do {
				if ((LA(1) == COMMA)) {
					match(COMMA);
					expression();
				} else {
					break _loop438;
				}

			} while (true);
		}
		{
			switch (LA(1)) {
			case ATTRIBUTE:
			case ATTRIBUTES: {
				attributeList();
				break;
			}
			case FOR: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		match(FOR);
		{
			switch (LA(1)) {
			case CHAR: {
				match(CHAR);
				break;
			}
			case IDENT:
			case INTERRUPT:
			case REAL:
			case TRUE:
			case FALSE:
			case NOT:
			case NULL:
			case LENGTH:
			case COUNT:
			case USER:
			case GROUP:
			case TODAY:
			case WEEKDAY:
			case MDY:
			case TIME:
			case PAGENO:
			case LINENO:
			case HIDE:
			case FIRST:
			case LAST:
			case NO:
			case ACCEPT:
			case SQL:
			case CURRENT:
			case TEMP:
			case SIZE:
			case INDEX:
			case WAIT:
			case WORK:
			case FOUND:
			case ASCII:
			case INT_FLAG:
			case NOTFOUND:
			case STATUS: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		variable();
		{
			switch (LA(1)) {
			case HELP: {
				match(HELP);
				numericConstant();
				break;
			}
			case IDENT:
			case END:
			case DEFER:
			case RETURN:
			case RUN:
			case LET:
			case CALL:
			case GOTO:
			case PREPARE:
			case IF:
			case ELSE:
			case WHILE:
			case FOR:
			case FOREACH:
			case CASE:
			case WHEN:
			case OTHERWISE:
			case SLEEP:
			case CONSTRUCT:
			case DISPLAY:
			case INPUT:
			case MENU:
			case EXIT:
			case CONTINUE:
			case ALLOCATE:
			case LOCATE:
			case DEALLOCATE:
			case RESIZE:
			case FREE:
			case INITIALIZE:
			case VALIDATE:
			case START:
			case PAGE:
			case TERMINATE:
			case FINISH:
			case PAUSE:
			case NEED:
			case PRINT:
			case SKIP:
			case OUTPUT:
			case BEFORE:
			case AFTER:
			case ON:
			case NEXT:
			case ATTRIBUTE:
			case ATTRIBUTES:
			case ERROR:
			case MESSAGE:
			case PROMPT:
			case INSERT:
			case DELETE:
			case COMMAND:
			case SHOW:
			case HIDE:
			case FIRST:
			case OPTIONS:
			case CLEAR:
			case CLOSE:
			case CURRENT:
			case OPEN:
			case SCROLL:
			case DECLARE:
			case UPDATE:
			case FETCH:
			case FLUSH:
			case PUT:
			case DROP:
			case CREATE:
			case LOCK:
			case SELECT:
			case LOAD:
			case UNLOAD:
			case SET:
			case EXECUTE:
			case DATABASE:
			case BEGIN:
			case COMMIT:
			case ROLLBACK:
			case WHENEVER: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		{
			switch (LA(1)) {
			case ATTRIBUTE:
			case ATTRIBUTES: {
				attributeList();
				break;
			}
			case IDENT:
			case END:
			case DEFER:
			case RETURN:
			case RUN:
			case LET:
			case CALL:
			case GOTO:
			case PREPARE:
			case IF:
			case ELSE:
			case WHILE:
			case FOR:
			case FOREACH:
			case CASE:
			case WHEN:
			case OTHERWISE:
			case SLEEP:
			case CONSTRUCT:
			case DISPLAY:
			case INPUT:
			case MENU:
			case EXIT:
			case CONTINUE:
			case ALLOCATE:
			case LOCATE:
			case DEALLOCATE:
			case RESIZE:
			case FREE:
			case INITIALIZE:
			case VALIDATE:
			case START:
			case PAGE:
			case TERMINATE:
			case FINISH:
			case PAUSE:
			case NEED:
			case PRINT:
			case SKIP:
			case OUTPUT:
			case BEFORE:
			case AFTER:
			case ON:
			case NEXT:
			case ERROR:
			case MESSAGE:
			case PROMPT:
			case INSERT:
			case DELETE:
			case COMMAND:
			case SHOW:
			case HIDE:
			case FIRST:
			case OPTIONS:
			case CLEAR:
			case CLOSE:
			case CURRENT:
			case OPEN:
			case SCROLL:
			case DECLARE:
			case UPDATE:
			case FETCH:
			case FLUSH:
			case PUT:
			case DROP:
			case CREATE:
			case LOCK:
			case SELECT:
			case LOAD:
			case UNLOAD:
			case SET:
			case EXECUTE:
			case DATABASE:
			case BEGIN:
			case COMMIT:
			case ROLLBACK:
			case WHENEVER: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		{
			if ((LA(1) == END || LA(1) == ON)
					&& (LA(2) == KEY || LA(2) == PROMPT)) {
				{
					_loop447: do {
						if ((LA(1) == ON)) {
							match(ON);
							match(KEY);
							match(LPAREN);
							{
								keyList();
							}
							match(RPAREN);
							{
								switch (LA(1)) {
								case IDENT:
								case RETURN:
								case RUN:
								case LET:
								case CALL:
								case GOTO:
								case PREPARE:
								case IF:
								case WHILE:
								case FOR:
								case FOREACH:
								case CASE:
								case SLEEP:
								case CONSTRUCT:
								case DISPLAY:
								case INPUT:
								case MENU:
								case EXIT:
								case CONTINUE:
								case ALLOCATE:
								case LOCATE:
								case DEALLOCATE:
								case RESIZE:
								case FREE:
								case INITIALIZE:
								case VALIDATE:
								case START:
								case TERMINATE:
								case FINISH:
								case PAUSE:
								case NEED:
								case PRINT:
								case SKIP:
								case OUTPUT:
								case NEXT:
								case ERROR:
								case MESSAGE:
								case PROMPT:
								case INSERT:
								case DELETE:
								case SHOW:
								case HIDE:
								case OPTIONS:
								case CLEAR:
								case CLOSE:
								case CURRENT:
								case OPEN:
								case SCROLL:
								case DECLARE:
								case UPDATE:
								case FETCH:
								case FLUSH:
								case PUT:
								case DROP:
								case CREATE:
								case LOCK:
								case SELECT:
								case LOAD:
								case UNLOAD:
								case SET:
								case EXECUTE:
								case DATABASE:
								case BEGIN:
								case COMMIT:
								case ROLLBACK:
								case WHENEVER: {
									codeBlock();
									break;
								}
								case END:
								case ON: {
									break;
								}
								default: {
									throw new NoViableAltException(LT(1),
											getFilename());
								}
								}
							}
						} else {
							break _loop447;
						}

					} while (true);
				}
				match(END);
				match(PROMPT);
			} else if ((_tokenSet_12.member(LA(1)))
					&& (_tokenSet_13.member(LA(2)))) {
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}

		}
	}

	public final void inputEvents() throws RecognitionException,
			TokenStreamException {

		if ((LA(1) == BEFORE || LA(1) == AFTER) && (_tokenSet_87.member(LA(2)))) {
			{
				switch (LA(1)) {
				case BEFORE: {
					match(BEFORE);
					break;
				}
				case AFTER: {
					match(AFTER);
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			{
				switch (LA(1)) {
				case INPUT: {
					match(INPUT);
					break;
				}
				case ROW: {
					match(ROW);
					break;
				}
				case INSERT: {
					match(INSERT);
					break;
				}
				case DELETE: {
					match(DELETE);
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
		} else if ((LA(1) == BEFORE) && (LA(2) == FIELD)) {
			match(BEFORE);
			match(FIELD);
			fieldList();
		} else if ((LA(1) == AFTER) && (LA(2) == FIELD)) {
			match(AFTER);
			match(FIELD);
			fieldList();
		} else if ((LA(1) == ON)) {
			match(ON);
			match(KEY);
			match(LPAREN);
			keyList();
			match(RPAREN);
		} else {
			throw new NoViableAltException(LT(1), getFilename());
		}

	}

	public final void inputGroupStatement() throws RecognitionException,
			TokenStreamException {

		inputEvents();
		{
			_loop455: do {
				if ((_tokenSet_84.member(LA(1)))) {
					codeBlock();
				} else {
					break _loop455;
				}

			} while (true);
		}
	}

	public final void inputStatement() throws RecognitionException,
			TokenStreamException {

		match(INPUT);
		{
			switch (LA(1)) {
			case BY: {
				match(BY);
				match(NAME);
				expression();
				{
					_loop459: do {
						if ((LA(1) == COMMA)) {
							match(COMMA);
							expression();
						} else {
							break _loop459;
						}

					} while (true);
				}
				{
					switch (LA(1)) {
					case WITHOUT: {
						match(WITHOUT);
						match(DEFAULTS);
						break;
					}
					case IDENT:
					case END:
					case DEFER:
					case RETURN:
					case RUN:
					case LET:
					case CALL:
					case GOTO:
					case PREPARE:
					case IF:
					case ELSE:
					case WHILE:
					case FOR:
					case FOREACH:
					case CASE:
					case WHEN:
					case OTHERWISE:
					case SLEEP:
					case CONSTRUCT:
					case DISPLAY:
					case INPUT:
					case MENU:
					case EXIT:
					case CONTINUE:
					case ALLOCATE:
					case LOCATE:
					case DEALLOCATE:
					case RESIZE:
					case FREE:
					case INITIALIZE:
					case VALIDATE:
					case START:
					case PAGE:
					case TERMINATE:
					case FINISH:
					case PAUSE:
					case NEED:
					case PRINT:
					case SKIP:
					case OUTPUT:
					case BEFORE:
					case AFTER:
					case ON:
					case NEXT:
					case ATTRIBUTE:
					case ATTRIBUTES:
					case HELP:
					case ERROR:
					case MESSAGE:
					case PROMPT:
					case INSERT:
					case DELETE:
					case COMMAND:
					case SHOW:
					case HIDE:
					case FIRST:
					case OPTIONS:
					case CLEAR:
					case CLOSE:
					case CURRENT:
					case OPEN:
					case SCROLL:
					case DECLARE:
					case UPDATE:
					case FETCH:
					case FLUSH:
					case PUT:
					case DROP:
					case CREATE:
					case LOCK:
					case SELECT:
					case LOAD:
					case UNLOAD:
					case SET:
					case EXECUTE:
					case DATABASE:
					case BEGIN:
					case COMMIT:
					case ROLLBACK:
					case WHENEVER: {
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
				break;
			}
			case IDENT:
			case INTERRUPT:
			case LPAREN:
			case REAL:
			case DATE:
			case YEAR:
			case MONTH:
			case DAY:
			case STRING_LITERAL:
			case TRUE:
			case FALSE:
			case NOT:
			case NULL:
			case PLUS:
			case MINUS:
			case LENGTH:
			case AVG:
			case COUNT:
			case MAX:
			case MIN:
			case SUM:
			case USER:
			case GROUP:
			case TODAY:
			case WEEKDAY:
			case MDY:
			case COLUMN:
			case EXTEND:
			case TIME:
			case INFIELD:
			case PREPARE:
			case PAGENO:
			case LINENO:
			case HIDE:
			case FIRST:
			case LAST:
			case NO:
			case ACCEPT:
			case SQL:
			case CURRENT:
			case TEMP:
			case SIZE:
			case INDEX:
			case WAIT:
			case WORK:
			case FOUND:
			case NUM_INT:
			case NUM_REAL:
			case ASCII:
			case INT_FLAG:
			case NOTFOUND:
			case STATUS: {
				expression();
				{
					_loop462: do {
						if ((LA(1) == COMMA)) {
							match(COMMA);
							expression();
						} else {
							break _loop462;
						}

					} while (true);
				}
				{
					switch (LA(1)) {
					case WITHOUT: {
						match(WITHOUT);
						match(DEFAULTS);
						break;
					}
					case FROM: {
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
				match(FROM);
				fieldList();
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		{
			switch (LA(1)) {
			case ATTRIBUTE:
			case ATTRIBUTES: {
				attributeList();
				break;
			}
			case IDENT:
			case END:
			case DEFER:
			case RETURN:
			case RUN:
			case LET:
			case CALL:
			case GOTO:
			case PREPARE:
			case IF:
			case ELSE:
			case WHILE:
			case FOR:
			case FOREACH:
			case CASE:
			case WHEN:
			case OTHERWISE:
			case SLEEP:
			case CONSTRUCT:
			case DISPLAY:
			case INPUT:
			case MENU:
			case EXIT:
			case CONTINUE:
			case ALLOCATE:
			case LOCATE:
			case DEALLOCATE:
			case RESIZE:
			case FREE:
			case INITIALIZE:
			case VALIDATE:
			case START:
			case PAGE:
			case TERMINATE:
			case FINISH:
			case PAUSE:
			case NEED:
			case PRINT:
			case SKIP:
			case OUTPUT:
			case BEFORE:
			case AFTER:
			case ON:
			case NEXT:
			case HELP:
			case ERROR:
			case MESSAGE:
			case PROMPT:
			case INSERT:
			case DELETE:
			case COMMAND:
			case SHOW:
			case HIDE:
			case FIRST:
			case OPTIONS:
			case CLEAR:
			case CLOSE:
			case CURRENT:
			case OPEN:
			case SCROLL:
			case DECLARE:
			case UPDATE:
			case FETCH:
			case FLUSH:
			case PUT:
			case DROP:
			case CREATE:
			case LOCK:
			case SELECT:
			case LOAD:
			case UNLOAD:
			case SET:
			case EXECUTE:
			case DATABASE:
			case BEGIN:
			case COMMIT:
			case ROLLBACK:
			case WHENEVER: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		{
			switch (LA(1)) {
			case HELP: {
				match(HELP);
				numericConstant();
				break;
			}
			case IDENT:
			case END:
			case DEFER:
			case RETURN:
			case RUN:
			case LET:
			case CALL:
			case GOTO:
			case PREPARE:
			case IF:
			case ELSE:
			case WHILE:
			case FOR:
			case FOREACH:
			case CASE:
			case WHEN:
			case OTHERWISE:
			case SLEEP:
			case CONSTRUCT:
			case DISPLAY:
			case INPUT:
			case MENU:
			case EXIT:
			case CONTINUE:
			case ALLOCATE:
			case LOCATE:
			case DEALLOCATE:
			case RESIZE:
			case FREE:
			case INITIALIZE:
			case VALIDATE:
			case START:
			case PAGE:
			case TERMINATE:
			case FINISH:
			case PAUSE:
			case NEED:
			case PRINT:
			case SKIP:
			case OUTPUT:
			case BEFORE:
			case AFTER:
			case ON:
			case NEXT:
			case ERROR:
			case MESSAGE:
			case PROMPT:
			case INSERT:
			case DELETE:
			case COMMAND:
			case SHOW:
			case HIDE:
			case FIRST:
			case OPTIONS:
			case CLEAR:
			case CLOSE:
			case CURRENT:
			case OPEN:
			case SCROLL:
			case DECLARE:
			case UPDATE:
			case FETCH:
			case FLUSH:
			case PUT:
			case DROP:
			case CREATE:
			case LOCK:
			case SELECT:
			case LOAD:
			case UNLOAD:
			case SET:
			case EXECUTE:
			case DATABASE:
			case BEGIN:
			case COMMIT:
			case ROLLBACK:
			case WHENEVER: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		{
			if ((_tokenSet_85.member(LA(1))) && (_tokenSet_88.member(LA(2)))) {
				{
					int _cnt468 = 0;
					_loop468: do {
						if ((_tokenSet_85.member(LA(1)))) {
							inputGroupStatement();
						} else {
							if (_cnt468 >= 1) {
								break _loop468;
							} else {
								throw new NoViableAltException(LT(1),
										getFilename());
							}
						}

						_cnt468++;
					} while (true);
				}
				match(END);
				match(INPUT);
			} else if ((_tokenSet_12.member(LA(1)))
					&& (_tokenSet_13.member(LA(2)))) {
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}

		}
	}

	public final void inputArrayStatement() throws RecognitionException,
			TokenStreamException {

		match(INPUT);
		match(ARRAY);
		expression();
		{
			switch (LA(1)) {
			case WITHOUT: {
				match(WITHOUT);
				match(DEFAULTS);
				break;
			}
			case FROM: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		match(FROM);
		expression();
		{
			_loop472: do {
				if ((LA(1) == COMMA)) {
					match(COMMA);
					expression();
				} else {
					break _loop472;
				}

			} while (true);
		}
		{
			switch (LA(1)) {
			case HELP: {
				match(HELP);
				numericConstant();
				break;
			}
			case IDENT:
			case END:
			case DEFER:
			case RETURN:
			case RUN:
			case LET:
			case CALL:
			case GOTO:
			case PREPARE:
			case IF:
			case ELSE:
			case WHILE:
			case FOR:
			case FOREACH:
			case CASE:
			case WHEN:
			case OTHERWISE:
			case SLEEP:
			case CONSTRUCT:
			case DISPLAY:
			case INPUT:
			case MENU:
			case EXIT:
			case CONTINUE:
			case ALLOCATE:
			case LOCATE:
			case DEALLOCATE:
			case RESIZE:
			case FREE:
			case INITIALIZE:
			case VALIDATE:
			case START:
			case PAGE:
			case TERMINATE:
			case FINISH:
			case PAUSE:
			case NEED:
			case PRINT:
			case SKIP:
			case OUTPUT:
			case BEFORE:
			case AFTER:
			case ON:
			case NEXT:
			case ATTRIBUTE:
			case ATTRIBUTES:
			case ERROR:
			case MESSAGE:
			case PROMPT:
			case INSERT:
			case DELETE:
			case COMMAND:
			case SHOW:
			case HIDE:
			case FIRST:
			case OPTIONS:
			case CLEAR:
			case CLOSE:
			case CURRENT:
			case OPEN:
			case SCROLL:
			case DECLARE:
			case UPDATE:
			case FETCH:
			case FLUSH:
			case PUT:
			case DROP:
			case CREATE:
			case LOCK:
			case SELECT:
			case LOAD:
			case UNLOAD:
			case SET:
			case EXECUTE:
			case DATABASE:
			case BEGIN:
			case COMMIT:
			case ROLLBACK:
			case WHENEVER: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		{
			switch (LA(1)) {
			case ATTRIBUTE:
			case ATTRIBUTES: {
				attributeList();
				break;
			}
			case IDENT:
			case END:
			case DEFER:
			case RETURN:
			case RUN:
			case LET:
			case CALL:
			case GOTO:
			case PREPARE:
			case IF:
			case ELSE:
			case WHILE:
			case FOR:
			case FOREACH:
			case CASE:
			case WHEN:
			case OTHERWISE:
			case SLEEP:
			case CONSTRUCT:
			case DISPLAY:
			case INPUT:
			case MENU:
			case EXIT:
			case CONTINUE:
			case ALLOCATE:
			case LOCATE:
			case DEALLOCATE:
			case RESIZE:
			case FREE:
			case INITIALIZE:
			case VALIDATE:
			case START:
			case PAGE:
			case TERMINATE:
			case FINISH:
			case PAUSE:
			case NEED:
			case PRINT:
			case SKIP:
			case OUTPUT:
			case BEFORE:
			case AFTER:
			case ON:
			case NEXT:
			case ERROR:
			case MESSAGE:
			case PROMPT:
			case INSERT:
			case DELETE:
			case COMMAND:
			case SHOW:
			case HIDE:
			case FIRST:
			case OPTIONS:
			case CLEAR:
			case CLOSE:
			case CURRENT:
			case OPEN:
			case SCROLL:
			case DECLARE:
			case UPDATE:
			case FETCH:
			case FLUSH:
			case PUT:
			case DROP:
			case CREATE:
			case LOCK:
			case SELECT:
			case LOAD:
			case UNLOAD:
			case SET:
			case EXECUTE:
			case DATABASE:
			case BEGIN:
			case COMMIT:
			case ROLLBACK:
			case WHENEVER: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		{
			if ((_tokenSet_85.member(LA(1))) && (_tokenSet_88.member(LA(2)))) {
				{
					int _cnt477 = 0;
					_loop477: do {
						if ((_tokenSet_85.member(LA(1)))) {
							inputGroupStatement();
						} else {
							if (_cnt477 >= 1) {
								break _loop477;
							} else {
								throw new NoViableAltException(LT(1),
										getFilename());
							}
						}

						_cnt477++;
					} while (true);
				}
				match(END);
				match(INPUT);
			} else if ((_tokenSet_12.member(LA(1)))
					&& (_tokenSet_13.member(LA(2)))) {
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}

		}
	}

	public final void menuEvents() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case BEFORE: {
			match(BEFORE);
			match(MENU);
			break;
		}
		case COMMAND: {
			match(COMMAND);
			{
				{
					switch (LA(1)) {
					case KEY: {
						match(KEY);
						match(LPAREN);
						keyList();
						match(RPAREN);
						break;
					}
					case IDENT:
					case INTERRUPT:
					case LPAREN:
					case REAL:
					case DATE:
					case YEAR:
					case MONTH:
					case DAY:
					case STRING_LITERAL:
					case TRUE:
					case FALSE:
					case NOT:
					case NULL:
					case PLUS:
					case MINUS:
					case LENGTH:
					case AVG:
					case COUNT:
					case MAX:
					case MIN:
					case SUM:
					case USER:
					case GROUP:
					case TODAY:
					case WEEKDAY:
					case MDY:
					case COLUMN:
					case EXTEND:
					case TIME:
					case INFIELD:
					case PREPARE:
					case PAGENO:
					case LINENO:
					case HIDE:
					case FIRST:
					case LAST:
					case NO:
					case ACCEPT:
					case SQL:
					case CURRENT:
					case TEMP:
					case SIZE:
					case INDEX:
					case WAIT:
					case WORK:
					case FOUND:
					case NUM_INT:
					case NUM_REAL:
					case ASCII:
					case INT_FLAG:
					case NOTFOUND:
					case STATUS: {
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
				expression();
				{
					if ((_tokenSet_10.member(LA(1)))
							&& (_tokenSet_89.member(LA(2)))) {
						expression();
					} else if ((_tokenSet_90.member(LA(1)))
							&& (_tokenSet_91.member(LA(2)))) {
					} else {
						throw new NoViableAltException(LT(1), getFilename());
					}

				}
				{
					switch (LA(1)) {
					case HELP: {
						match(HELP);
						numericConstant();
						break;
					}
					case IDENT:
					case END:
					case RETURN:
					case RUN:
					case LET:
					case CALL:
					case GOTO:
					case PREPARE:
					case IF:
					case WHILE:
					case FOR:
					case FOREACH:
					case CASE:
					case SLEEP:
					case CONSTRUCT:
					case DISPLAY:
					case INPUT:
					case MENU:
					case EXIT:
					case CONTINUE:
					case ALLOCATE:
					case LOCATE:
					case DEALLOCATE:
					case RESIZE:
					case FREE:
					case INITIALIZE:
					case VALIDATE:
					case START:
					case TERMINATE:
					case FINISH:
					case PAUSE:
					case NEED:
					case PRINT:
					case SKIP:
					case OUTPUT:
					case BEFORE:
					case NEXT:
					case ERROR:
					case MESSAGE:
					case PROMPT:
					case INSERT:
					case DELETE:
					case COMMAND:
					case SHOW:
					case HIDE:
					case OPTIONS:
					case CLEAR:
					case CLOSE:
					case CURRENT:
					case OPEN:
					case SCROLL:
					case DECLARE:
					case UPDATE:
					case FETCH:
					case FLUSH:
					case PUT:
					case DROP:
					case CREATE:
					case LOCK:
					case SELECT:
					case LOAD:
					case UNLOAD:
					case SET:
					case EXECUTE:
					case DATABASE:
					case BEGIN:
					case COMMIT:
					case ROLLBACK:
					case WHENEVER: {
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
			}
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void menuGroupStatement() throws RecognitionException,
			TokenStreamException {

		menuEvents();
		{
			switch (LA(1)) {
			case IDENT:
			case RETURN:
			case RUN:
			case LET:
			case CALL:
			case GOTO:
			case PREPARE:
			case IF:
			case WHILE:
			case FOR:
			case FOREACH:
			case CASE:
			case SLEEP:
			case CONSTRUCT:
			case DISPLAY:
			case INPUT:
			case MENU:
			case EXIT:
			case CONTINUE:
			case ALLOCATE:
			case LOCATE:
			case DEALLOCATE:
			case RESIZE:
			case FREE:
			case INITIALIZE:
			case VALIDATE:
			case START:
			case TERMINATE:
			case FINISH:
			case PAUSE:
			case NEED:
			case PRINT:
			case SKIP:
			case OUTPUT:
			case NEXT:
			case ERROR:
			case MESSAGE:
			case PROMPT:
			case INSERT:
			case DELETE:
			case SHOW:
			case HIDE:
			case OPTIONS:
			case CLEAR:
			case CLOSE:
			case CURRENT:
			case OPEN:
			case SCROLL:
			case DECLARE:
			case UPDATE:
			case FETCH:
			case FLUSH:
			case PUT:
			case DROP:
			case CREATE:
			case LOCK:
			case SELECT:
			case LOAD:
			case UNLOAD:
			case SET:
			case EXECUTE:
			case DATABASE:
			case BEGIN:
			case COMMIT:
			case ROLLBACK:
			case WHENEVER: {
				codeBlock();
				break;
			}
			case END:
			case BEFORE:
			case COMMAND: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
	}

	public final void menuStatement() throws RecognitionException,
			TokenStreamException {

		match(MENU);
		expression();
		{
			_loop497: do {
				if ((LA(1) == BEFORE || LA(1) == COMMAND)) {
					menuGroupStatement();
				} else {
					break _loop497;
				}

			} while (true);
		}
		match(END);
		match(MENU);
	}

	public final void reservedLinePosition() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case FIRST: {
			match(FIRST);
			{
				switch (LA(1)) {
				case PLUS: {
					match(PLUS);
					numericConstant();
					break;
				}
				case RPAREN:
				case COMMA: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			break;
		}
		case PLUS:
		case MINUS:
		case NUM_INT:
		case NUM_REAL: {
			numericConstant();
			break;
		}
		case LAST: {
			match(LAST);
			{
				switch (LA(1)) {
				case MINUS: {
					match(MINUS);
					numericConstant();
					break;
				}
				case RPAREN:
				case COMMA: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void specialWindowAttribute() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case BLACK:
		case BLUE:
		case CYAN:
		case GREEN:
		case MAGENTA:
		case RED:
		case WHITE:
		case YELLOW:
		case BOLD:
		case DIM:
		case NORMAL:
		case INVISIBLE: {
			{
				switch (LA(1)) {
				case BLACK: {
					match(BLACK);
					break;
				}
				case BLUE: {
					match(BLUE);
					break;
				}
				case CYAN: {
					match(CYAN);
					break;
				}
				case GREEN: {
					match(GREEN);
					break;
				}
				case MAGENTA: {
					match(MAGENTA);
					break;
				}
				case RED: {
					match(RED);
					break;
				}
				case WHITE: {
					match(WHITE);
					break;
				}
				case YELLOW: {
					match(YELLOW);
					break;
				}
				case BOLD: {
					match(BOLD);
					break;
				}
				case DIM: {
					match(DIM);
					break;
				}
				case NORMAL: {
					match(NORMAL);
					break;
				}
				case INVISIBLE: {
					match(INVISIBLE);
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			break;
		}
		case REVERSE: {
			match(REVERSE);
			break;
		}
		case BORDER: {
			match(BORDER);
			break;
		}
		case FORM:
		case MENU:
		case MESSAGE:
		case PROMPT: {
			{
				switch (LA(1)) {
				case PROMPT: {
					match(PROMPT);
					break;
				}
				case FORM: {
					match(FORM);
					break;
				}
				case MENU: {
					match(MENU);
					break;
				}
				case MESSAGE: {
					match(MESSAGE);
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(LINE);
			{
				reservedLinePosition();
			}
			break;
		}
		case COMMENT: {
			match(COMMENT);
			match(LINE);
			{
				switch (LA(1)) {
				case PLUS:
				case MINUS:
				case FIRST:
				case LAST:
				case NUM_INT:
				case NUM_REAL: {
					reservedLinePosition();
					break;
				}
				case OFF: {
					match(OFF);
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void windowAttribute() throws RecognitionException,
			TokenStreamException {

		specialWindowAttribute();
		{
			_loop508: do {
				if ((LA(1) == COMMA)) {
					match(COMMA);
					specialWindowAttribute();
				} else {
					break _loop508;
				}

			} while (true);
		}
	}

	public final void windowAttributeList() throws RecognitionException,
			TokenStreamException {

		{
			switch (LA(1)) {
			case ATTRIBUTE: {
				match(ATTRIBUTE);
				break;
			}
			case ATTRIBUTES: {
				match(ATTRIBUTES);
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		match(LPAREN);
		windowAttribute();
		match(RPAREN);
	}

	public final void optionStatement() throws RecognitionException,
			TokenStreamException {

		{
			switch (LA(1)) {
			case MESSAGE: {
				match(MESSAGE);
				match(LINE);
				expression();
				break;
			}
			case PROMPT: {
				match(PROMPT);
				match(LINE);
				expression();
				break;
			}
			case MENU: {
				match(MENU);
				match(LINE);
				expression();
				break;
			}
			case COMMENT: {
				match(COMMENT);
				match(LINE);
				expression();
				break;
			}
			case ERROR: {
				match(ERROR);
				match(LINE);
				expression();
				break;
			}
			case FORM: {
				match(FORM);
				match(LINE);
				expression();
				break;
			}
			case INSERT: {
				match(INSERT);
				match(KEY);
				expression();
				break;
			}
			case DELETE: {
				match(DELETE);
				match(KEY);
				expression();
				break;
			}
			case NEXT: {
				match(NEXT);
				match(KEY);
				expression();
				break;
			}
			case PREVIOUS: {
				match(PREVIOUS);
				match(KEY);
				expression();
				break;
			}
			case ACCEPT: {
				match(ACCEPT);
				match(KEY);
				expression();
				break;
			}
			case DISPLAY: {
				match(DISPLAY);
				attributeList();
				break;
			}
			case SQL: {
				match(SQL);
				match(INTERRUPT);
				{
					switch (LA(1)) {
					case ON: {
						match(ON);
						break;
					}
					case OFF: {
						match(OFF);
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
				break;
			}
			case FIELD: {
				match(FIELD);
				match(ORDER);
				{
					switch (LA(1)) {
					case CONSTRAINED: {
						match(CONSTRAINED);
						break;
					}
					case UNCONSTRAINED: {
						match(UNCONSTRAINED);
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
				break;
			}
			default:
				if ((LA(1) == INPUT) && (LA(2) == WRAP || LA(2) == NO)) {
					match(INPUT);
					{
						switch (LA(1)) {
						case WRAP: {
							match(WRAP);
							break;
						}
						case NO: {
							match(NO);
							match(WRAP);
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
				} else if ((LA(1) == HELP) && (LA(2) == FILE)) {
					match(HELP);
					match(FILE);
					expression();
				} else if ((LA(1) == HELP) && (LA(2) == KEY)) {
					match(HELP);
					match(KEY);
					expression();
				} else if ((LA(1) == INPUT)
						&& (LA(2) == ATTRIBUTE || LA(2) == ATTRIBUTES)) {
					match(INPUT);
					attributeList();
				} else {
					throw new NoViableAltException(LT(1), getFilename());
				}
			}
		}
	}

	public final void optionsStatement() throws RecognitionException,
			TokenStreamException {

		match(OPTIONS);
		optionStatement();
		{
			_loop518: do {
				if ((LA(1) == COMMA)) {
					match(COMMA);
					optionStatement();
				} else {
					break _loop518;
				}

			} while (true);
		}
	}

	public final void cursorManipulationStatement()
			throws RecognitionException, TokenStreamException {

		switch (LA(1)) {
		case CLOSE: {
			match(CLOSE);
			cursorName();
			eol();
			break;
		}
		case DECLARE: {
			match(DECLARE);
			cursorName();
			{
				switch (LA(1)) {
				case CURSOR: {
					match(CURSOR);
					{
						switch (LA(1)) {
						case WITH: {
							match(WITH);
							match(HOLD);
							break;
						}
						case FOR: {
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
					match(FOR);
					{
						switch (LA(1)) {
						case SELECT: {
							sqlSelectStatement();
							{
								if ((LA(1) == FOR) && (LA(2) == UPDATE)) {
									match(FOR);
									match(UPDATE);
									{
										switch (LA(1)) {
										case OF: {
											match(OF);
											columnsList();
											break;
										}
										case IDENT:
										case END:
										case DEFER:
										case RETURN:
										case SEMI:
										case RUN:
										case LET:
										case CALL:
										case GOTO:
										case PREPARE:
										case IF:
										case ELSE:
										case WHILE:
										case FOR:
										case FOREACH:
										case CASE:
										case WHEN:
										case OTHERWISE:
										case SLEEP:
										case CONSTRUCT:
										case DISPLAY:
										case INPUT:
										case MENU:
										case EXIT:
										case CONTINUE:
										case ALLOCATE:
										case LOCATE:
										case DEALLOCATE:
										case RESIZE:
										case FREE:
										case INITIALIZE:
										case VALIDATE:
										case START:
										case PAGE:
										case TERMINATE:
										case FINISH:
										case PAUSE:
										case NEED:
										case PRINT:
										case SKIP:
										case OUTPUT:
										case BEFORE:
										case AFTER:
										case ON:
										case NEXT:
										case ERROR:
										case MESSAGE:
										case PROMPT:
										case INSERT:
										case DELETE:
										case COMMAND:
										case SHOW:
										case HIDE:
										case FIRST:
										case OPTIONS:
										case CLEAR:
										case CLOSE:
										case CURRENT:
										case OPEN:
										case SCROLL:
										case DECLARE:
										case UPDATE:
										case FETCH:
										case FLUSH:
										case PUT:
										case DROP:
										case CREATE:
										case LOCK:
										case SELECT:
										case LOAD:
										case UNLOAD:
										case SET:
										case EXECUTE:
										case DATABASE:
										case BEGIN:
										case COMMIT:
										case ROLLBACK:
										case WHENEVER: {
											break;
										}
										default: {
											throw new NoViableAltException(
													LT(1), getFilename());
										}
										}
									}
								} else if ((_tokenSet_78.member(LA(1)))
										&& (_tokenSet_13.member(LA(2)))) {
								} else {
									throw new NoViableAltException(LT(1),
											getFilename());
								}

							}
							break;
						}
						case INSERT: {
							sqlInsertStatement();
							break;
						}
						case IDENT:
						case INTERRUPT:
						case REAL:
						case TRUE:
						case FALSE:
						case NOT:
						case NULL:
						case LENGTH:
						case COUNT:
						case USER:
						case GROUP:
						case TODAY:
						case WEEKDAY:
						case MDY:
						case TIME:
						case PAGENO:
						case LINENO:
						case HIDE:
						case FIRST:
						case LAST:
						case NO:
						case ACCEPT:
						case SQL:
						case CURRENT:
						case TEMP:
						case SIZE:
						case INDEX:
						case WAIT:
						case WORK:
						case FOUND:
						case ASCII:
						case INT_FLAG:
						case NOTFOUND:
						case STATUS: {
							statementId();
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
					break;
				}
				case SCROLL: {
					match(SCROLL);
					match(CURSOR);
					{
						switch (LA(1)) {
						case WITH: {
							match(WITH);
							match(HOLD);
							break;
						}
						case FOR: {
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
					match(FOR);
					{
						switch (LA(1)) {
						case SELECT: {
							sqlSelectStatement();
							break;
						}
						case IDENT:
						case INTERRUPT:
						case REAL:
						case TRUE:
						case FALSE:
						case NOT:
						case NULL:
						case LENGTH:
						case COUNT:
						case USER:
						case GROUP:
						case TODAY:
						case WEEKDAY:
						case MDY:
						case TIME:
						case PAGENO:
						case LINENO:
						case HIDE:
						case FIRST:
						case LAST:
						case NO:
						case ACCEPT:
						case SQL:
						case CURRENT:
						case TEMP:
						case SIZE:
						case INDEX:
						case WAIT:
						case WORK:
						case FOUND:
						case ASCII:
						case INT_FLAG:
						case NOTFOUND:
						case STATUS: {
							statementId();
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			break;
		}
		case FETCH: {
			match(FETCH);
			{
				switch (LA(1)) {
				case NEXT: {
					match(NEXT);
					break;
				}
				case PREVIOUS:
				case PRIOR: {
					{
						switch (LA(1)) {
						case PREVIOUS: {
							match(PREVIOUS);
							break;
						}
						case PRIOR: {
							match(PRIOR);
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
					break;
				}
				case FIRST: {
					match(FIRST);
					break;
				}
				case LAST: {
					match(LAST);
					break;
				}
				case CURRENT: {
					match(CURRENT);
					break;
				}
				case RELATIVE: {
					match(RELATIVE);
					expression();
					break;
				}
				case ABSOLUTE: {
					match(ABSOLUTE);
					expression();
					break;
				}
				case IDENT: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			cursorName();
			{
				switch (LA(1)) {
				case INTO: {
					match(INTO);
					variableList();
					break;
				}
				case IDENT:
				case END:
				case DEFER:
				case RETURN:
				case SEMI:
				case RUN:
				case LET:
				case CALL:
				case GOTO:
				case PREPARE:
				case IF:
				case ELSE:
				case WHILE:
				case FOR:
				case FOREACH:
				case CASE:
				case WHEN:
				case OTHERWISE:
				case SLEEP:
				case CONSTRUCT:
				case DISPLAY:
				case INPUT:
				case MENU:
				case EXIT:
				case CONTINUE:
				case ALLOCATE:
				case LOCATE:
				case DEALLOCATE:
				case RESIZE:
				case FREE:
				case INITIALIZE:
				case VALIDATE:
				case START:
				case PAGE:
				case TERMINATE:
				case FINISH:
				case PAUSE:
				case NEED:
				case PRINT:
				case SKIP:
				case OUTPUT:
				case BEFORE:
				case AFTER:
				case ON:
				case NEXT:
				case ERROR:
				case MESSAGE:
				case PROMPT:
				case INSERT:
				case DELETE:
				case COMMAND:
				case SHOW:
				case HIDE:
				case FIRST:
				case OPTIONS:
				case CLEAR:
				case CLOSE:
				case CURRENT:
				case OPEN:
				case SCROLL:
				case DECLARE:
				case UPDATE:
				case FETCH:
				case FLUSH:
				case PUT:
				case DROP:
				case CREATE:
				case LOCK:
				case SELECT:
				case LOAD:
				case UNLOAD:
				case SET:
				case EXECUTE:
				case DATABASE:
				case BEGIN:
				case COMMIT:
				case ROLLBACK:
				case WHENEVER: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			break;
		}
		case FLUSH: {
			match(FLUSH);
			cursorName();
			eol();
			break;
		}
		case OPEN: {
			match(OPEN);
			cursorName();
			{
				switch (LA(1)) {
				case USING: {
					match(USING);
					variableList();
					break;
				}
				case IDENT:
				case END:
				case DEFER:
				case RETURN:
				case SEMI:
				case RUN:
				case LET:
				case CALL:
				case GOTO:
				case PREPARE:
				case IF:
				case ELSE:
				case WHILE:
				case FOR:
				case FOREACH:
				case CASE:
				case WHEN:
				case OTHERWISE:
				case SLEEP:
				case CONSTRUCT:
				case DISPLAY:
				case INPUT:
				case MENU:
				case EXIT:
				case CONTINUE:
				case ALLOCATE:
				case LOCATE:
				case DEALLOCATE:
				case RESIZE:
				case FREE:
				case INITIALIZE:
				case VALIDATE:
				case START:
				case PAGE:
				case TERMINATE:
				case FINISH:
				case PAUSE:
				case NEED:
				case PRINT:
				case SKIP:
				case OUTPUT:
				case BEFORE:
				case AFTER:
				case ON:
				case NEXT:
				case ERROR:
				case MESSAGE:
				case PROMPT:
				case INSERT:
				case DELETE:
				case COMMAND:
				case SHOW:
				case HIDE:
				case FIRST:
				case OPTIONS:
				case CLEAR:
				case CLOSE:
				case CURRENT:
				case OPEN:
				case SCROLL:
				case DECLARE:
				case UPDATE:
				case FETCH:
				case FLUSH:
				case PUT:
				case DROP:
				case CREATE:
				case LOCK:
				case SELECT:
				case LOAD:
				case UNLOAD:
				case SET:
				case EXECUTE:
				case DATABASE:
				case BEGIN:
				case COMMIT:
				case ROLLBACK:
				case WHENEVER: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			break;
		}
		case PUT: {
			match(PUT);
			cursorName();
			{
				switch (LA(1)) {
				case FROM: {
					match(FROM);
					variableOrConstantList();
					break;
				}
				case IDENT:
				case END:
				case DEFER:
				case RETURN:
				case SEMI:
				case RUN:
				case LET:
				case CALL:
				case GOTO:
				case PREPARE:
				case IF:
				case ELSE:
				case WHILE:
				case FOR:
				case FOREACH:
				case CASE:
				case WHEN:
				case OTHERWISE:
				case SLEEP:
				case CONSTRUCT:
				case DISPLAY:
				case INPUT:
				case MENU:
				case EXIT:
				case CONTINUE:
				case ALLOCATE:
				case LOCATE:
				case DEALLOCATE:
				case RESIZE:
				case FREE:
				case INITIALIZE:
				case VALIDATE:
				case START:
				case PAGE:
				case TERMINATE:
				case FINISH:
				case PAUSE:
				case NEED:
				case PRINT:
				case SKIP:
				case OUTPUT:
				case BEFORE:
				case AFTER:
				case ON:
				case NEXT:
				case ERROR:
				case MESSAGE:
				case PROMPT:
				case INSERT:
				case DELETE:
				case COMMAND:
				case SHOW:
				case HIDE:
				case FIRST:
				case OPTIONS:
				case CLEAR:
				case CLOSE:
				case CURRENT:
				case OPEN:
				case SCROLL:
				case DECLARE:
				case UPDATE:
				case FETCH:
				case FLUSH:
				case PUT:
				case DROP:
				case CREATE:
				case LOCK:
				case SELECT:
				case LOAD:
				case UNLOAD:
				case SET:
				case EXECUTE:
				case DATABASE:
				case BEGIN:
				case COMMIT:
				case ROLLBACK:
				case WHENEVER: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void dataDefinitionStatement() throws RecognitionException,
			TokenStreamException {

		if ((LA(1) == DROP) && (LA(2) == TABLE)) {
			match(DROP);
			match(TABLE);
			constantIdentifier();
		} else if ((LA(1) == CREATE) && (LA(2) == TABLE || LA(2) == TEMP)) {
			match(CREATE);
			{
				switch (LA(1)) {
				case TEMP: {
					match(TEMP);
					break;
				}
				case TABLE: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(TABLE);
			constantIdentifier();
			match(LPAREN);
			columnItem();
			{
				_loop563: do {
					if ((LA(1) == COMMA)) {
						match(COMMA);
						columnItem();
					} else {
						break _loop563;
					}

				} while (true);
			}
			match(RPAREN);
			{
				switch (LA(1)) {
				case WITH: {
					match(WITH);
					match(NO);
					match(LOG);
					break;
				}
				case IDENT:
				case END:
				case DEFER:
				case RETURN:
				case SEMI:
				case RUN:
				case IN:
				case LET:
				case CALL:
				case GOTO:
				case PREPARE:
				case IF:
				case ELSE:
				case WHILE:
				case FOR:
				case FOREACH:
				case CASE:
				case WHEN:
				case OTHERWISE:
				case SLEEP:
				case CONSTRUCT:
				case DISPLAY:
				case INPUT:
				case MENU:
				case EXIT:
				case CONTINUE:
				case ALLOCATE:
				case LOCATE:
				case DEALLOCATE:
				case RESIZE:
				case FREE:
				case INITIALIZE:
				case VALIDATE:
				case START:
				case PAGE:
				case TERMINATE:
				case FINISH:
				case PAUSE:
				case NEED:
				case PRINT:
				case SKIP:
				case OUTPUT:
				case BEFORE:
				case AFTER:
				case ON:
				case NEXT:
				case ERROR:
				case MESSAGE:
				case PROMPT:
				case INSERT:
				case DELETE:
				case COMMAND:
				case SHOW:
				case HIDE:
				case FIRST:
				case OPTIONS:
				case CLEAR:
				case CLOSE:
				case CURRENT:
				case OPEN:
				case SCROLL:
				case DECLARE:
				case UPDATE:
				case FETCH:
				case FLUSH:
				case PUT:
				case DROP:
				case CREATE:
				case EXTENT:
				case LOCK:
				case SELECT:
				case LOAD:
				case UNLOAD:
				case SET:
				case EXECUTE:
				case DATABASE:
				case BEGIN:
				case COMMIT:
				case ROLLBACK:
				case WHENEVER: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			{
				switch (LA(1)) {
				case IN: {
					match(IN);
					constantIdentifier();
					break;
				}
				case IDENT:
				case END:
				case DEFER:
				case RETURN:
				case SEMI:
				case RUN:
				case LET:
				case CALL:
				case GOTO:
				case PREPARE:
				case IF:
				case ELSE:
				case WHILE:
				case FOR:
				case FOREACH:
				case CASE:
				case WHEN:
				case OTHERWISE:
				case SLEEP:
				case CONSTRUCT:
				case DISPLAY:
				case INPUT:
				case MENU:
				case EXIT:
				case CONTINUE:
				case ALLOCATE:
				case LOCATE:
				case DEALLOCATE:
				case RESIZE:
				case FREE:
				case INITIALIZE:
				case VALIDATE:
				case START:
				case PAGE:
				case TERMINATE:
				case FINISH:
				case PAUSE:
				case NEED:
				case PRINT:
				case SKIP:
				case OUTPUT:
				case BEFORE:
				case AFTER:
				case ON:
				case NEXT:
				case ERROR:
				case MESSAGE:
				case PROMPT:
				case INSERT:
				case DELETE:
				case COMMAND:
				case SHOW:
				case HIDE:
				case FIRST:
				case OPTIONS:
				case CLEAR:
				case CLOSE:
				case CURRENT:
				case OPEN:
				case SCROLL:
				case DECLARE:
				case UPDATE:
				case FETCH:
				case FLUSH:
				case PUT:
				case DROP:
				case CREATE:
				case EXTENT:
				case LOCK:
				case SELECT:
				case LOAD:
				case UNLOAD:
				case SET:
				case EXECUTE:
				case DATABASE:
				case BEGIN:
				case COMMIT:
				case ROLLBACK:
				case WHENEVER: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			{
				switch (LA(1)) {
				case EXTENT: {
					match(EXTENT);
					match(SIZE);
					numericConstant();
					break;
				}
				case IDENT:
				case END:
				case DEFER:
				case RETURN:
				case SEMI:
				case RUN:
				case LET:
				case CALL:
				case GOTO:
				case PREPARE:
				case IF:
				case ELSE:
				case WHILE:
				case FOR:
				case FOREACH:
				case CASE:
				case WHEN:
				case OTHERWISE:
				case SLEEP:
				case CONSTRUCT:
				case DISPLAY:
				case INPUT:
				case MENU:
				case EXIT:
				case CONTINUE:
				case ALLOCATE:
				case LOCATE:
				case DEALLOCATE:
				case RESIZE:
				case FREE:
				case INITIALIZE:
				case VALIDATE:
				case START:
				case PAGE:
				case TERMINATE:
				case FINISH:
				case PAUSE:
				case NEED:
				case PRINT:
				case SKIP:
				case OUTPUT:
				case BEFORE:
				case AFTER:
				case ON:
				case NEXT:
				case ERROR:
				case MESSAGE:
				case PROMPT:
				case INSERT:
				case DELETE:
				case COMMAND:
				case SHOW:
				case HIDE:
				case FIRST:
				case OPTIONS:
				case CLEAR:
				case CLOSE:
				case CURRENT:
				case OPEN:
				case SCROLL:
				case DECLARE:
				case UPDATE:
				case FETCH:
				case FLUSH:
				case PUT:
				case DROP:
				case CREATE:
				case LOCK:
				case SELECT:
				case LOAD:
				case UNLOAD:
				case SET:
				case EXECUTE:
				case DATABASE:
				case BEGIN:
				case COMMIT:
				case ROLLBACK:
				case WHENEVER: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			{
				if ((LA(1) == NEXT) && (LA(2) == SIZE)) {
					match(NEXT);
					match(SIZE);
					numericConstant();
				} else if ((_tokenSet_78.member(LA(1)))
						&& (_tokenSet_92.member(LA(2)))) {
				} else {
					throw new NoViableAltException(LT(1), getFilename());
				}

			}
			{
				if ((LA(1) == LOCK) && (LA(2) == MODE)) {
					match(LOCK);
					match(MODE);
					match(LPAREN);
					{
						switch (LA(1)) {
						case PAGE: {
							match(PAGE);
							break;
						}
						case ROW: {
							match(ROW);
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
					match(RPAREN);
				} else if ((_tokenSet_78.member(LA(1)))
						&& (_tokenSet_13.member(LA(2)))) {
				} else {
					throw new NoViableAltException(LT(1), getFilename());
				}

			}
		} else if ((LA(1) == CREATE) && (_tokenSet_93.member(LA(2)))) {
			match(CREATE);
			{
				switch (LA(1)) {
				case UNIQUE: {
					match(UNIQUE);
					break;
				}
				case CLUSTER:
				case INDEX: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			{
				switch (LA(1)) {
				case CLUSTER: {
					match(CLUSTER);
					break;
				}
				case INDEX: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(INDEX);
			constantIdentifier();
			match(ON);
			constantIdentifier();
			match(LPAREN);
			constantIdentifier();
			{
				switch (LA(1)) {
				case ASC: {
					match(ASC);
					break;
				}
				case DESC: {
					match(DESC);
					break;
				}
				case RPAREN:
				case COMMA: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			{
				_loop575: do {
					if ((LA(1) == COMMA)) {
						match(COMMA);
						constantIdentifier();
						{
							switch (LA(1)) {
							case ASC: {
								match(ASC);
								break;
							}
							case DESC: {
								match(DESC);
								break;
							}
							case RPAREN:
							case COMMA: {
								break;
							}
							default: {
								throw new NoViableAltException(LT(1),
										getFilename());
							}
							}
						}
					} else {
						break _loop575;
					}

				} while (true);
			}
			match(RPAREN);
		} else if ((LA(1) == DROP) && (LA(2) == INDEX)) {
			match(DROP);
			match(INDEX);
			constantIdentifier();
		} else {
			throw new NoViableAltException(LT(1), getFilename());
		}

	}

	public final void dataManipulationStatement() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case INSERT: {
			sqlInsertStatement();
			break;
		}
		case DELETE: {
			sqlDeleteStatement();
			break;
		}
		case SELECT: {
			sqlSelectStatement();
			break;
		}
		case UPDATE: {
			sqlUpdateStatement();
			break;
		}
		case LOAD: {
			sqlLoadStatement();
			break;
		}
		case UNLOAD: {
			sqlUnLoadStatement();
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void dynamicManagementStatement() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case PREPARE: {
			match(PREPARE);
			cursorName();
			match(FROM);
			expression();
			break;
		}
		case EXECUTE: {
			match(EXECUTE);
			cursorName();
			{
				switch (LA(1)) {
				case USING: {
					match(USING);
					variableList();
					break;
				}
				case IDENT:
				case END:
				case DEFER:
				case RETURN:
				case SEMI:
				case RUN:
				case LET:
				case CALL:
				case GOTO:
				case PREPARE:
				case IF:
				case ELSE:
				case WHILE:
				case FOR:
				case FOREACH:
				case CASE:
				case WHEN:
				case OTHERWISE:
				case SLEEP:
				case CONSTRUCT:
				case DISPLAY:
				case INPUT:
				case MENU:
				case EXIT:
				case CONTINUE:
				case ALLOCATE:
				case LOCATE:
				case DEALLOCATE:
				case RESIZE:
				case FREE:
				case INITIALIZE:
				case VALIDATE:
				case START:
				case PAGE:
				case TERMINATE:
				case FINISH:
				case PAUSE:
				case NEED:
				case PRINT:
				case SKIP:
				case OUTPUT:
				case BEFORE:
				case AFTER:
				case ON:
				case NEXT:
				case ERROR:
				case MESSAGE:
				case PROMPT:
				case INSERT:
				case DELETE:
				case COMMAND:
				case SHOW:
				case HIDE:
				case FIRST:
				case OPTIONS:
				case CLEAR:
				case CLOSE:
				case CURRENT:
				case OPEN:
				case SCROLL:
				case DECLARE:
				case UPDATE:
				case FETCH:
				case FLUSH:
				case PUT:
				case DROP:
				case CREATE:
				case LOCK:
				case SELECT:
				case LOAD:
				case UNLOAD:
				case SET:
				case EXECUTE:
				case DATABASE:
				case BEGIN:
				case COMMIT:
				case ROLLBACK:
				case WHENEVER: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			break;
		}
		case FREE: {
			match(FREE);
			{
				if ((LA(1) == IDENT) && (_tokenSet_78.member(LA(2)))) {
					cursorName();
				} else if ((_tokenSet_5.member(LA(1)))
						&& (_tokenSet_78.member(LA(2)))) {
					statementId();
				} else {
					throw new NoViableAltException(LT(1), getFilename());
				}

			}
			break;
		}
		case LOCK: {
			match(LOCK);
			match(TABLE);
			expression();
			match(IN);
			{
				switch (LA(1)) {
				case SHARE: {
					match(SHARE);
					break;
				}
				case EXCLUSIVE: {
					match(EXCLUSIVE);
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(MODE);
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void queryOptimizationStatement() throws RecognitionException,
			TokenStreamException {

		if ((LA(1) == UPDATE)) {
			match(UPDATE);
			match(STATISTICS);
			{
				if ((LA(1) == FOR) && (LA(2) == TABLE)) {
					match(FOR);
					match(TABLE);
					tableIdentifier();
				} else if ((_tokenSet_78.member(LA(1)))
						&& (_tokenSet_13.member(LA(2)))) {
				} else {
					throw new NoViableAltException(LT(1), getFilename());
				}

			}
		} else if ((LA(1) == SET) && (LA(2) == LOCK)) {
			match(SET);
			match(LOCK);
			match(MODE);
			match(TO);
			{
				switch (LA(1)) {
				case WAIT: {
					match(WAIT);
					{
						switch (LA(1)) {
						case SECONDS: {
							match(SECONDS);
							break;
						}
						case IDENT:
						case END:
						case DEFER:
						case RETURN:
						case SEMI:
						case RUN:
						case LET:
						case CALL:
						case GOTO:
						case PREPARE:
						case IF:
						case ELSE:
						case WHILE:
						case FOR:
						case FOREACH:
						case CASE:
						case WHEN:
						case OTHERWISE:
						case SLEEP:
						case CONSTRUCT:
						case DISPLAY:
						case INPUT:
						case MENU:
						case EXIT:
						case CONTINUE:
						case ALLOCATE:
						case LOCATE:
						case DEALLOCATE:
						case RESIZE:
						case FREE:
						case INITIALIZE:
						case VALIDATE:
						case START:
						case PAGE:
						case TERMINATE:
						case FINISH:
						case PAUSE:
						case NEED:
						case PRINT:
						case SKIP:
						case OUTPUT:
						case BEFORE:
						case AFTER:
						case ON:
						case NEXT:
						case ERROR:
						case MESSAGE:
						case PROMPT:
						case INSERT:
						case DELETE:
						case COMMAND:
						case SHOW:
						case HIDE:
						case FIRST:
						case OPTIONS:
						case CLEAR:
						case CLOSE:
						case CURRENT:
						case OPEN:
						case SCROLL:
						case DECLARE:
						case UPDATE:
						case FETCH:
						case FLUSH:
						case PUT:
						case DROP:
						case CREATE:
						case LOCK:
						case SELECT:
						case LOAD:
						case UNLOAD:
						case SET:
						case EXECUTE:
						case DATABASE:
						case BEGIN:
						case COMMIT:
						case ROLLBACK:
						case WHENEVER: {
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
					break;
				}
				case NOT: {
					match(NOT);
					match(WAIT);
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
		} else if ((LA(1) == SET) && (LA(2) == EXPLAIN)) {
			match(SET);
			match(EXPLAIN);
			{
				switch (LA(1)) {
				case ON: {
					match(ON);
					break;
				}
				case OFF: {
					match(OFF);
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
		} else if ((LA(1) == SET) && (LA(2) == ISOLATION)) {
			match(SET);
			match(ISOLATION);
			match(TO);
			{
				switch (LA(1)) {
				case CURSOR: {
					match(CURSOR);
					match(STABILITY);
					break;
				}
				case DIRTY:
				case COMMITTED:
				case REPEATABLE: {
					{
						switch (LA(1)) {
						case DIRTY: {
							match(DIRTY);
							break;
						}
						case COMMITTED: {
							match(COMMITTED);
							break;
						}
						case REPEATABLE: {
							match(REPEATABLE);
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
					match(READ);
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
		} else if ((LA(1) == SET) && (LA(2) == LOG || LA(2) == BUFFERED)) {
			match(SET);
			{
				switch (LA(1)) {
				case BUFFERED: {
					match(BUFFERED);
					break;
				}
				case LOG: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(LOG);
		} else {
			throw new NoViableAltException(LT(1), getFilename());
		}

	}

	public final void dataIntegrityStatement() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case WHENEVER: {
			wheneverStatement();
			break;
		}
		case BEGIN: {
			match(BEGIN);
			match(WORK);
			break;
		}
		case COMMIT: {
			match(COMMIT);
			match(WORK);
			break;
		}
		case ROLLBACK: {
			match(ROLLBACK);
			match(WORK);
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void clientServerStatement() throws RecognitionException,
			TokenStreamException {

		match(CLOSE);
		match(DATABASE);
	}

	public final void cursorName() throws RecognitionException,
			TokenStreamException {

		identifier();
	}

	public final void sqlInsertStatement() throws RecognitionException,
			TokenStreamException {

		match(INSERT);
		match(INTO);
		tableIdentifier();
		{
			switch (LA(1)) {
			case LPAREN: {
				match(LPAREN);
				columnsList();
				match(RPAREN);
				break;
			}
			case SELECT:
			case VALUES: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		{
			switch (LA(1)) {
			case VALUES: {
				match(VALUES);
				match(LPAREN);
				expression();
				{
					_loop649: do {
						if ((LA(1) == COMMA)) {
							match(COMMA);
							expression();
						} else {
							break _loop649;
						}

					} while (true);
				}
				match(RPAREN);
				break;
			}
			case SELECT: {
				simpleSelectStatement();
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
	}

	public final void statementId() throws RecognitionException,
			TokenStreamException {

		constantIdentifier();
	}

	public final void dataType() throws RecognitionException,
			TokenStreamException {

		type();
	}

	public final void columnItem() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case IDENT:
		case INTERRUPT:
		case REAL:
		case TRUE:
		case FALSE:
		case NOT:
		case NULL:
		case LENGTH:
		case COUNT:
		case USER:
		case GROUP:
		case TODAY:
		case WEEKDAY:
		case MDY:
		case TIME:
		case PAGENO:
		case LINENO:
		case HIDE:
		case FIRST:
		case LAST:
		case NO:
		case ACCEPT:
		case SQL:
		case CURRENT:
		case TEMP:
		case SIZE:
		case INDEX:
		case WAIT:
		case WORK:
		case FOUND:
		case ASCII:
		case INT_FLAG:
		case NOTFOUND:
		case STATUS: {
			constantIdentifier();
			{
				if ((_tokenSet_16.member(LA(1)))
						&& (_tokenSet_94.member(LA(2)))) {
					dataType();
				} else if ((LA(1) == TEXT || LA(1) == BYTE)
						&& (_tokenSet_95.member(LA(2)))) {
					{
						switch (LA(1)) {
						case BYTE: {
							match(BYTE);
							break;
						}
						case TEXT: {
							match(TEXT);
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
					{
						switch (LA(1)) {
						case IN: {
							match(IN);
							{
								switch (LA(1)) {
								case TABLE: {
									match(TABLE);
									break;
								}
								case IDENT:
								case INTERRUPT:
								case REAL:
								case TRUE:
								case FALSE:
								case NOT:
								case NULL:
								case LENGTH:
								case COUNT:
								case USER:
								case GROUP:
								case TODAY:
								case WEEKDAY:
								case MDY:
								case TIME:
								case PAGENO:
								case LINENO:
								case HIDE:
								case FIRST:
								case LAST:
								case NO:
								case ACCEPT:
								case SQL:
								case CURRENT:
								case TEMP:
								case SIZE:
								case INDEX:
								case WAIT:
								case WORK:
								case FOUND:
								case ASCII:
								case INT_FLAG:
								case NOTFOUND:
								case STATUS: {
									constantIdentifier();
									break;
								}
								default: {
									throw new NoViableAltException(LT(1),
											getFilename());
								}
								}
							}
							break;
						}
						case RPAREN:
						case COMMA:
						case NOT: {
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
				} else {
					throw new NoViableAltException(LT(1), getFilename());
				}

			}
			{
				switch (LA(1)) {
				case NOT: {
					match(NOT);
					match(NULL);
					break;
				}
				case RPAREN:
				case COMMA: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			break;
		}
		case UNIQUE: {
			match(UNIQUE);
			match(LPAREN);
			{
				switch (LA(1)) {
				case IDENT:
				case INTERRUPT:
				case REAL:
				case TRUE:
				case FALSE:
				case NOT:
				case NULL:
				case LENGTH:
				case COUNT:
				case USER:
				case GROUP:
				case TODAY:
				case WEEKDAY:
				case MDY:
				case TIME:
				case PAGENO:
				case LINENO:
				case HIDE:
				case FIRST:
				case LAST:
				case NO:
				case ACCEPT:
				case SQL:
				case CURRENT:
				case TEMP:
				case SIZE:
				case INDEX:
				case WAIT:
				case WORK:
				case FOUND:
				case ASCII:
				case INT_FLAG:
				case NOTFOUND:
				case STATUS: {
					constantIdentifier();
					{
						_loop558: do {
							if ((LA(1) == COMMA)) {
								match(COMMA);
								constantIdentifier();
							} else {
								break _loop558;
							}

						} while (true);
					}
					break;
				}
				case RPAREN: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			match(RPAREN);
			{
				switch (LA(1)) {
				case CONSTRAINT: {
					match(CONSTRAINT);
					constantIdentifier();
					break;
				}
				case RPAREN:
				case COMMA: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void sqlDeleteStatement() throws RecognitionException,
			TokenStreamException {

		match(DELETE);
		match(FROM);
		tableIdentifier();
		{
			switch (LA(1)) {
			case WHERE: {
				match(WHERE);
				{
					if ((_tokenSet_35.member(LA(1)))
							&& (_tokenSet_96.member(LA(2)))) {
						condition();
					} else if ((LA(1) == CURRENT) && (LA(2) == OF)) {
						match(CURRENT);
						match(OF);
						cursorName();
					} else {
						throw new NoViableAltException(LT(1), getFilename());
					}

				}
				break;
			}
			case IDENT:
			case END:
			case DEFER:
			case RETURN:
			case SEMI:
			case RUN:
			case LET:
			case CALL:
			case GOTO:
			case PREPARE:
			case IF:
			case ELSE:
			case WHILE:
			case FOR:
			case FOREACH:
			case CASE:
			case WHEN:
			case OTHERWISE:
			case SLEEP:
			case CONSTRUCT:
			case DISPLAY:
			case INPUT:
			case MENU:
			case EXIT:
			case CONTINUE:
			case ALLOCATE:
			case LOCATE:
			case DEALLOCATE:
			case RESIZE:
			case FREE:
			case INITIALIZE:
			case VALIDATE:
			case START:
			case PAGE:
			case TERMINATE:
			case FINISH:
			case PAUSE:
			case NEED:
			case PRINT:
			case SKIP:
			case OUTPUT:
			case BEFORE:
			case AFTER:
			case ON:
			case NEXT:
			case ERROR:
			case MESSAGE:
			case PROMPT:
			case INSERT:
			case DELETE:
			case COMMAND:
			case SHOW:
			case HIDE:
			case FIRST:
			case OPTIONS:
			case CLEAR:
			case CLOSE:
			case CURRENT:
			case OPEN:
			case SCROLL:
			case DECLARE:
			case UPDATE:
			case FETCH:
			case FLUSH:
			case PUT:
			case DROP:
			case CREATE:
			case LOCK:
			case SELECT:
			case LOAD:
			case UNLOAD:
			case SET:
			case EXECUTE:
			case DATABASE:
			case BEGIN:
			case COMMIT:
			case ROLLBACK:
			case WHENEVER: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		eol();
	}

	public final void sqlUpdateStatement() throws RecognitionException,
			TokenStreamException {

		match(UPDATE);
		tableIdentifier();
		match(SET);
		{
			if ((_tokenSet_46.member(LA(1))) && (_tokenSet_97.member(LA(2)))) {
				{
					columnsTableId();
					match(EQUAL);
					expression();
					{
						_loop654: do {
							if ((LA(1) == COMMA)) {
								match(COMMA);
								columnsTableId();
								match(EQUAL);
								expression();
							} else {
								break _loop654;
							}

						} while (true);
					}
				}
			} else if ((_tokenSet_98.member(LA(1)))
					&& (_tokenSet_99.member(LA(2)))) {
				{
					{
						switch (LA(1)) {
						case LPAREN: {
							match(LPAREN);
							columnsList();
							match(RPAREN);
							break;
						}
						case IDENT:
						case STAR: {
							{
								switch (LA(1)) {
								case IDENT: {
									aliasName();
									match(DOT);
									break;
								}
								case STAR: {
									break;
								}
								default: {
									throw new NoViableAltException(LT(1),
											getFilename());
								}
								}
							}
							match(STAR);
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
					match(EQUAL);
					{
						switch (LA(1)) {
						case LPAREN: {
							match(LPAREN);
							expression();
							{
								_loop660: do {
									if ((LA(1) == COMMA)) {
										match(COMMA);
										expression();
									} else {
										break _loop660;
									}

								} while (true);
							}
							match(RPAREN);
							break;
						}
						case IDENT:
						case STAR: {
							{
								switch (LA(1)) {
								case IDENT: {
									aliasName();
									match(DOT);
									break;
								}
								case STAR: {
									break;
								}
								default: {
									throw new NoViableAltException(LT(1),
											getFilename());
								}
								}
							}
							match(STAR);
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
				}
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}

		}
		{
			switch (LA(1)) {
			case WHERE: {
				match(WHERE);
				{
					if ((_tokenSet_35.member(LA(1)))
							&& (_tokenSet_96.member(LA(2)))) {
						condition();
					} else if ((LA(1) == CURRENT) && (LA(2) == OF)) {
						match(CURRENT);
						match(OF);
						cursorName();
					} else {
						throw new NoViableAltException(LT(1), getFilename());
					}

				}
				break;
			}
			case IDENT:
			case END:
			case DEFER:
			case RETURN:
			case SEMI:
			case RUN:
			case LET:
			case CALL:
			case GOTO:
			case PREPARE:
			case IF:
			case ELSE:
			case WHILE:
			case FOR:
			case FOREACH:
			case CASE:
			case WHEN:
			case OTHERWISE:
			case SLEEP:
			case CONSTRUCT:
			case DISPLAY:
			case INPUT:
			case MENU:
			case EXIT:
			case CONTINUE:
			case ALLOCATE:
			case LOCATE:
			case DEALLOCATE:
			case RESIZE:
			case FREE:
			case INITIALIZE:
			case VALIDATE:
			case START:
			case PAGE:
			case TERMINATE:
			case FINISH:
			case PAUSE:
			case NEED:
			case PRINT:
			case SKIP:
			case OUTPUT:
			case BEFORE:
			case AFTER:
			case ON:
			case NEXT:
			case ERROR:
			case MESSAGE:
			case PROMPT:
			case INSERT:
			case DELETE:
			case COMMAND:
			case SHOW:
			case HIDE:
			case FIRST:
			case OPTIONS:
			case CLEAR:
			case CLOSE:
			case CURRENT:
			case OPEN:
			case SCROLL:
			case DECLARE:
			case UPDATE:
			case FETCH:
			case FLUSH:
			case PUT:
			case DROP:
			case CREATE:
			case LOCK:
			case SELECT:
			case LOAD:
			case UNLOAD:
			case SET:
			case EXECUTE:
			case DATABASE:
			case BEGIN:
			case COMMIT:
			case ROLLBACK:
			case WHENEVER: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
	}

	public final void sqlLoadStatement() throws RecognitionException,
			TokenStreamException {

		match(LOAD);
		match(FROM);
		{
			switch (LA(1)) {
			case IDENT:
			case INTERRUPT:
			case REAL:
			case TRUE:
			case FALSE:
			case NOT:
			case NULL:
			case LENGTH:
			case COUNT:
			case USER:
			case GROUP:
			case TODAY:
			case WEEKDAY:
			case MDY:
			case TIME:
			case PAGENO:
			case LINENO:
			case HIDE:
			case FIRST:
			case LAST:
			case NO:
			case ACCEPT:
			case SQL:
			case CURRENT:
			case TEMP:
			case SIZE:
			case INDEX:
			case WAIT:
			case WORK:
			case FOUND:
			case ASCII:
			case INT_FLAG:
			case NOTFOUND:
			case STATUS: {
				variable();
				break;
			}
			case STRING_LITERAL: {
				string();
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		{
			switch (LA(1)) {
			case DELIMITER: {
				match(DELIMITER);
				{
					switch (LA(1)) {
					case IDENT:
					case INTERRUPT:
					case REAL:
					case TRUE:
					case FALSE:
					case NOT:
					case NULL:
					case LENGTH:
					case COUNT:
					case USER:
					case GROUP:
					case TODAY:
					case WEEKDAY:
					case MDY:
					case TIME:
					case PAGENO:
					case LINENO:
					case HIDE:
					case FIRST:
					case LAST:
					case NO:
					case ACCEPT:
					case SQL:
					case CURRENT:
					case TEMP:
					case SIZE:
					case INDEX:
					case WAIT:
					case WORK:
					case FOUND:
					case ASCII:
					case INT_FLAG:
					case NOTFOUND:
					case STATUS: {
						variable();
						break;
					}
					case STRING_LITERAL: {
						string();
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
				break;
			}
			case INSERT: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		{
			if ((LA(1) == INSERT) && (LA(2) == INTO)) {
				match(INSERT);
				match(INTO);
				tableIdentifier();
				{
					switch (LA(1)) {
					case LPAREN: {
						match(LPAREN);
						columnsList();
						match(RPAREN);
						break;
					}
					case IDENT:
					case END:
					case DEFER:
					case RETURN:
					case SEMI:
					case RUN:
					case LET:
					case CALL:
					case GOTO:
					case PREPARE:
					case IF:
					case ELSE:
					case WHILE:
					case FOR:
					case FOREACH:
					case CASE:
					case WHEN:
					case OTHERWISE:
					case SLEEP:
					case CONSTRUCT:
					case DISPLAY:
					case INPUT:
					case MENU:
					case EXIT:
					case CONTINUE:
					case ALLOCATE:
					case LOCATE:
					case DEALLOCATE:
					case RESIZE:
					case FREE:
					case INITIALIZE:
					case VALIDATE:
					case START:
					case PAGE:
					case TERMINATE:
					case FINISH:
					case PAUSE:
					case NEED:
					case PRINT:
					case SKIP:
					case OUTPUT:
					case BEFORE:
					case AFTER:
					case ON:
					case NEXT:
					case ERROR:
					case MESSAGE:
					case PROMPT:
					case INSERT:
					case DELETE:
					case COMMAND:
					case SHOW:
					case HIDE:
					case FIRST:
					case OPTIONS:
					case CLEAR:
					case CLOSE:
					case CURRENT:
					case OPEN:
					case SCROLL:
					case DECLARE:
					case UPDATE:
					case FETCH:
					case FLUSH:
					case PUT:
					case DROP:
					case CREATE:
					case LOCK:
					case SELECT:
					case LOAD:
					case UNLOAD:
					case SET:
					case EXECUTE:
					case DATABASE:
					case BEGIN:
					case COMMIT:
					case ROLLBACK:
					case WHENEVER: {
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
			} else if ((LA(1) == INSERT) && (LA(2) == INTO)) {
				sqlInsertStatement();
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}

		}
		eol();
	}

	public final void sqlUnLoadStatement() throws RecognitionException,
			TokenStreamException {

		match(UNLOAD);
		match(TO);
		{
			switch (LA(1)) {
			case IDENT:
			case INTERRUPT:
			case REAL:
			case TRUE:
			case FALSE:
			case NOT:
			case NULL:
			case LENGTH:
			case COUNT:
			case USER:
			case GROUP:
			case TODAY:
			case WEEKDAY:
			case MDY:
			case TIME:
			case PAGENO:
			case LINENO:
			case HIDE:
			case FIRST:
			case LAST:
			case NO:
			case ACCEPT:
			case SQL:
			case CURRENT:
			case TEMP:
			case SIZE:
			case INDEX:
			case WAIT:
			case WORK:
			case FOUND:
			case ASCII:
			case INT_FLAG:
			case NOTFOUND:
			case STATUS: {
				variable();
				break;
			}
			case STRING_LITERAL: {
				string();
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		{
			switch (LA(1)) {
			case DELIMITER: {
				match(DELIMITER);
				{
					switch (LA(1)) {
					case IDENT:
					case INTERRUPT:
					case REAL:
					case TRUE:
					case FALSE:
					case NOT:
					case NULL:
					case LENGTH:
					case COUNT:
					case USER:
					case GROUP:
					case TODAY:
					case WEEKDAY:
					case MDY:
					case TIME:
					case PAGENO:
					case LINENO:
					case HIDE:
					case FIRST:
					case LAST:
					case NO:
					case ACCEPT:
					case SQL:
					case CURRENT:
					case TEMP:
					case SIZE:
					case INDEX:
					case WAIT:
					case WORK:
					case FOUND:
					case ASCII:
					case INT_FLAG:
					case NOTFOUND:
					case STATUS: {
						variable();
						break;
					}
					case STRING_LITERAL: {
						string();
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
				break;
			}
			case SELECT: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		sqlSelectStatement();
		eol();
	}

	public final void mainSelectStatement() throws RecognitionException,
			TokenStreamException {

		headSelectStatement();
		{
			switch (LA(1)) {
			case INTO: {
				match(INTO);
				variableList();
				break;
			}
			case FROM: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		fromSelectStatement();
		{
			switch (LA(1)) {
			case WHERE: {
				whereStatement();
				break;
			}
			case IDENT:
			case END:
			case DEFER:
			case RETURN:
			case RPAREN:
			case WITH:
			case SEMI:
			case RUN:
			case LET:
			case CALL:
			case GOTO:
			case GROUP:
			case PREPARE:
			case IF:
			case ELSE:
			case WHILE:
			case FOR:
			case FOREACH:
			case INTO:
			case CASE:
			case WHEN:
			case OTHERWISE:
			case SLEEP:
			case CONSTRUCT:
			case DISPLAY:
			case INPUT:
			case MENU:
			case EXIT:
			case CONTINUE:
			case ALLOCATE:
			case LOCATE:
			case DEALLOCATE:
			case RESIZE:
			case FREE:
			case INITIALIZE:
			case VALIDATE:
			case START:
			case PAGE:
			case TERMINATE:
			case FINISH:
			case PAUSE:
			case NEED:
			case PRINT:
			case SKIP:
			case OUTPUT:
			case BEFORE:
			case AFTER:
			case ON:
			case NEXT:
			case ERROR:
			case MESSAGE:
			case PROMPT:
			case INSERT:
			case DELETE:
			case COMMAND:
			case SHOW:
			case HIDE:
			case FIRST:
			case ORDER:
			case OPTIONS:
			case CLEAR:
			case CLOSE:
			case CURRENT:
			case OPEN:
			case SCROLL:
			case DECLARE:
			case UPDATE:
			case FETCH:
			case FLUSH:
			case PUT:
			case DROP:
			case CREATE:
			case LOCK:
			case SELECT:
			case UNION:
			case HAVING:
			case LOAD:
			case UNLOAD:
			case SET:
			case EXECUTE:
			case DATABASE:
			case BEGIN:
			case COMMIT:
			case ROLLBACK:
			case WHENEVER: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		{
			switch (LA(1)) {
			case GROUP: {
				groupByStatement();
				break;
			}
			case IDENT:
			case END:
			case DEFER:
			case RETURN:
			case RPAREN:
			case WITH:
			case SEMI:
			case RUN:
			case LET:
			case CALL:
			case GOTO:
			case PREPARE:
			case IF:
			case ELSE:
			case WHILE:
			case FOR:
			case FOREACH:
			case INTO:
			case CASE:
			case WHEN:
			case OTHERWISE:
			case SLEEP:
			case CONSTRUCT:
			case DISPLAY:
			case INPUT:
			case MENU:
			case EXIT:
			case CONTINUE:
			case ALLOCATE:
			case LOCATE:
			case DEALLOCATE:
			case RESIZE:
			case FREE:
			case INITIALIZE:
			case VALIDATE:
			case START:
			case PAGE:
			case TERMINATE:
			case FINISH:
			case PAUSE:
			case NEED:
			case PRINT:
			case SKIP:
			case OUTPUT:
			case BEFORE:
			case AFTER:
			case ON:
			case NEXT:
			case ERROR:
			case MESSAGE:
			case PROMPT:
			case INSERT:
			case DELETE:
			case COMMAND:
			case SHOW:
			case HIDE:
			case FIRST:
			case ORDER:
			case OPTIONS:
			case CLEAR:
			case CLOSE:
			case CURRENT:
			case OPEN:
			case SCROLL:
			case DECLARE:
			case UPDATE:
			case FETCH:
			case FLUSH:
			case PUT:
			case DROP:
			case CREATE:
			case LOCK:
			case SELECT:
			case UNION:
			case HAVING:
			case LOAD:
			case UNLOAD:
			case SET:
			case EXECUTE:
			case DATABASE:
			case BEGIN:
			case COMMIT:
			case ROLLBACK:
			case WHENEVER: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		{
			switch (LA(1)) {
			case HAVING: {
				havingStatement();
				break;
			}
			case IDENT:
			case END:
			case DEFER:
			case RETURN:
			case RPAREN:
			case WITH:
			case SEMI:
			case RUN:
			case LET:
			case CALL:
			case GOTO:
			case PREPARE:
			case IF:
			case ELSE:
			case WHILE:
			case FOR:
			case FOREACH:
			case INTO:
			case CASE:
			case WHEN:
			case OTHERWISE:
			case SLEEP:
			case CONSTRUCT:
			case DISPLAY:
			case INPUT:
			case MENU:
			case EXIT:
			case CONTINUE:
			case ALLOCATE:
			case LOCATE:
			case DEALLOCATE:
			case RESIZE:
			case FREE:
			case INITIALIZE:
			case VALIDATE:
			case START:
			case PAGE:
			case TERMINATE:
			case FINISH:
			case PAUSE:
			case NEED:
			case PRINT:
			case SKIP:
			case OUTPUT:
			case BEFORE:
			case AFTER:
			case ON:
			case NEXT:
			case ERROR:
			case MESSAGE:
			case PROMPT:
			case INSERT:
			case DELETE:
			case COMMAND:
			case SHOW:
			case HIDE:
			case FIRST:
			case ORDER:
			case OPTIONS:
			case CLEAR:
			case CLOSE:
			case CURRENT:
			case OPEN:
			case SCROLL:
			case DECLARE:
			case UPDATE:
			case FETCH:
			case FLUSH:
			case PUT:
			case DROP:
			case CREATE:
			case LOCK:
			case SELECT:
			case UNION:
			case LOAD:
			case UNLOAD:
			case SET:
			case EXECUTE:
			case DATABASE:
			case BEGIN:
			case COMMIT:
			case ROLLBACK:
			case WHENEVER: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		{
			switch (LA(1)) {
			case UNION: {
				unionSelectStatement();
				break;
			}
			case IDENT:
			case END:
			case DEFER:
			case RETURN:
			case RPAREN:
			case WITH:
			case SEMI:
			case RUN:
			case LET:
			case CALL:
			case GOTO:
			case PREPARE:
			case IF:
			case ELSE:
			case WHILE:
			case FOR:
			case FOREACH:
			case INTO:
			case CASE:
			case WHEN:
			case OTHERWISE:
			case SLEEP:
			case CONSTRUCT:
			case DISPLAY:
			case INPUT:
			case MENU:
			case EXIT:
			case CONTINUE:
			case ALLOCATE:
			case LOCATE:
			case DEALLOCATE:
			case RESIZE:
			case FREE:
			case INITIALIZE:
			case VALIDATE:
			case START:
			case PAGE:
			case TERMINATE:
			case FINISH:
			case PAUSE:
			case NEED:
			case PRINT:
			case SKIP:
			case OUTPUT:
			case BEFORE:
			case AFTER:
			case ON:
			case NEXT:
			case ERROR:
			case MESSAGE:
			case PROMPT:
			case INSERT:
			case DELETE:
			case COMMAND:
			case SHOW:
			case HIDE:
			case FIRST:
			case ORDER:
			case OPTIONS:
			case CLEAR:
			case CLOSE:
			case CURRENT:
			case OPEN:
			case SCROLL:
			case DECLARE:
			case UPDATE:
			case FETCH:
			case FLUSH:
			case PUT:
			case DROP:
			case CREATE:
			case LOCK:
			case SELECT:
			case LOAD:
			case UNLOAD:
			case SET:
			case EXECUTE:
			case DATABASE:
			case BEGIN:
			case COMMIT:
			case ROLLBACK:
			case WHENEVER: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		{
			switch (LA(1)) {
			case ORDER: {
				orderbyStatement();
				break;
			}
			case IDENT:
			case END:
			case DEFER:
			case RETURN:
			case RPAREN:
			case WITH:
			case SEMI:
			case RUN:
			case LET:
			case CALL:
			case GOTO:
			case PREPARE:
			case IF:
			case ELSE:
			case WHILE:
			case FOR:
			case FOREACH:
			case INTO:
			case CASE:
			case WHEN:
			case OTHERWISE:
			case SLEEP:
			case CONSTRUCT:
			case DISPLAY:
			case INPUT:
			case MENU:
			case EXIT:
			case CONTINUE:
			case ALLOCATE:
			case LOCATE:
			case DEALLOCATE:
			case RESIZE:
			case FREE:
			case INITIALIZE:
			case VALIDATE:
			case START:
			case PAGE:
			case TERMINATE:
			case FINISH:
			case PAUSE:
			case NEED:
			case PRINT:
			case SKIP:
			case OUTPUT:
			case BEFORE:
			case AFTER:
			case ON:
			case NEXT:
			case ERROR:
			case MESSAGE:
			case PROMPT:
			case INSERT:
			case DELETE:
			case COMMAND:
			case SHOW:
			case HIDE:
			case FIRST:
			case OPTIONS:
			case CLEAR:
			case CLOSE:
			case CURRENT:
			case OPEN:
			case SCROLL:
			case DECLARE:
			case UPDATE:
			case FETCH:
			case FLUSH:
			case PUT:
			case DROP:
			case CREATE:
			case LOCK:
			case SELECT:
			case LOAD:
			case UNLOAD:
			case SET:
			case EXECUTE:
			case DATABASE:
			case BEGIN:
			case COMMIT:
			case ROLLBACK:
			case WHENEVER: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		{
			switch (LA(1)) {
			case INTO: {
				match(INTO);
				match(TEMP);
				identifier();
				break;
			}
			case IDENT:
			case END:
			case DEFER:
			case RETURN:
			case RPAREN:
			case WITH:
			case SEMI:
			case RUN:
			case LET:
			case CALL:
			case GOTO:
			case PREPARE:
			case IF:
			case ELSE:
			case WHILE:
			case FOR:
			case FOREACH:
			case CASE:
			case WHEN:
			case OTHERWISE:
			case SLEEP:
			case CONSTRUCT:
			case DISPLAY:
			case INPUT:
			case MENU:
			case EXIT:
			case CONTINUE:
			case ALLOCATE:
			case LOCATE:
			case DEALLOCATE:
			case RESIZE:
			case FREE:
			case INITIALIZE:
			case VALIDATE:
			case START:
			case PAGE:
			case TERMINATE:
			case FINISH:
			case PAUSE:
			case NEED:
			case PRINT:
			case SKIP:
			case OUTPUT:
			case BEFORE:
			case AFTER:
			case ON:
			case NEXT:
			case ERROR:
			case MESSAGE:
			case PROMPT:
			case INSERT:
			case DELETE:
			case COMMAND:
			case SHOW:
			case HIDE:
			case FIRST:
			case OPTIONS:
			case CLEAR:
			case CLOSE:
			case CURRENT:
			case OPEN:
			case SCROLL:
			case DECLARE:
			case UPDATE:
			case FETCH:
			case FLUSH:
			case PUT:
			case DROP:
			case CREATE:
			case LOCK:
			case SELECT:
			case LOAD:
			case UNLOAD:
			case SET:
			case EXECUTE:
			case DATABASE:
			case BEGIN:
			case COMMIT:
			case ROLLBACK:
			case WHENEVER: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		{
			switch (LA(1)) {
			case WITH: {
				match(WITH);
				match(NO);
				match(LOG);
				break;
			}
			case IDENT:
			case END:
			case DEFER:
			case RETURN:
			case RPAREN:
			case SEMI:
			case RUN:
			case LET:
			case CALL:
			case GOTO:
			case PREPARE:
			case IF:
			case ELSE:
			case WHILE:
			case FOR:
			case FOREACH:
			case CASE:
			case WHEN:
			case OTHERWISE:
			case SLEEP:
			case CONSTRUCT:
			case DISPLAY:
			case INPUT:
			case MENU:
			case EXIT:
			case CONTINUE:
			case ALLOCATE:
			case LOCATE:
			case DEALLOCATE:
			case RESIZE:
			case FREE:
			case INITIALIZE:
			case VALIDATE:
			case START:
			case PAGE:
			case TERMINATE:
			case FINISH:
			case PAUSE:
			case NEED:
			case PRINT:
			case SKIP:
			case OUTPUT:
			case BEFORE:
			case AFTER:
			case ON:
			case NEXT:
			case ERROR:
			case MESSAGE:
			case PROMPT:
			case INSERT:
			case DELETE:
			case COMMAND:
			case SHOW:
			case HIDE:
			case FIRST:
			case OPTIONS:
			case CLEAR:
			case CLOSE:
			case CURRENT:
			case OPEN:
			case SCROLL:
			case DECLARE:
			case UPDATE:
			case FETCH:
			case FLUSH:
			case PUT:
			case DROP:
			case CREATE:
			case LOCK:
			case SELECT:
			case LOAD:
			case UNLOAD:
			case SET:
			case EXECUTE:
			case DATABASE:
			case BEGIN:
			case COMMIT:
			case ROLLBACK:
			case WHENEVER: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
	}

	public final void selectList() throws RecognitionException,
			TokenStreamException {

		{
			{
				sqlExpression();
			}
			{
				switch (LA(1)) {
				case IDENT:
				case AS: {
					sqlAlias();
					break;
				}
				case COMMA:
				case INTO:
				case FROM: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			{
				_loop589: do {
					if ((LA(1) == COMMA)) {
						match(COMMA);
						{
							sqlExpression();
						}
						{
							switch (LA(1)) {
							case IDENT:
							case AS: {
								sqlAlias();
								break;
							}
							case COMMA:
							case INTO:
							case FROM: {
								break;
							}
							default: {
								throw new NoViableAltException(LT(1),
										getFilename());
							}
							}
						}
					} else {
						break _loop589;
					}

				} while (true);
			}
		}
	}

	public final void headSelectStatement() throws RecognitionException,
			TokenStreamException {

		match(SELECT);
		{
			switch (LA(1)) {
			case ALL: {
				match(ALL);
				break;
			}
			case DISTINCT:
			case UNIQUE: {
				{
					switch (LA(1)) {
					case DISTINCT: {
						match(DISTINCT);
						break;
					}
					case UNIQUE: {
						match(UNIQUE);
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
				break;
			}
			case IDENT:
			case INTERRUPT:
			case LPAREN:
			case REAL:
			case DATE:
			case YEAR:
			case MONTH:
			case DAY:
			case STAR:
			case STRING_LITERAL:
			case TRUE:
			case FALSE:
			case NOT:
			case NULL:
			case PLUS:
			case MINUS:
			case MOD:
			case LENGTH:
			case AVG:
			case COUNT:
			case MAX:
			case MIN:
			case SUM:
			case DECODE:
			case NVL:
			case USER:
			case GROUP:
			case TODAY:
			case WEEKDAY:
			case MDY:
			case TIME:
			case PAGENO:
			case LINENO:
			case HIDE:
			case FIRST:
			case LAST:
			case NO:
			case ACCEPT:
			case SQL:
			case CURRENT:
			case TEMP:
			case SIZE:
			case INDEX:
			case WAIT:
			case WORK:
			case FOUND:
			case NUM_INT:
			case NUM_REAL:
			case ASCII:
			case INT_FLAG:
			case NOTFOUND:
			case STATUS: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		selectList();
	}

	public final void tableQualifier() throws RecognitionException,
			TokenStreamException {

		{
			if ((_tokenSet_5.member(LA(1))) && (_tokenSet_100.member(LA(2)))) {
				{
					if ((_tokenSet_5.member(LA(1))) && (LA(2) == COLON)) {
						constantIdentifier();
						match(COLON);
					} else if ((_tokenSet_5.member(LA(1)))
							&& (LA(2) == ATSYMBOL)) {
						constantIdentifier();
						match(ATSYMBOL);
						constantIdentifier();
						match(COLON);
					} else if ((_tokenSet_5.member(LA(1)))
							&& (_tokenSet_101.member(LA(2)))) {
					} else {
						throw new NoViableAltException(LT(1), getFilename());
					}

				}
			} else if ((_tokenSet_102.member(LA(1)))
					&& (_tokenSet_103.member(LA(2)))) {
				{
					switch (LA(1)) {
					case STRING_LITERAL: {
						string();
						break;
					}
					case IDENT:
					case INTERRUPT:
					case REAL:
					case TRUE:
					case FALSE:
					case NOT:
					case NULL:
					case LENGTH:
					case COUNT:
					case USER:
					case GROUP:
					case TODAY:
					case WEEKDAY:
					case MDY:
					case TIME:
					case PAGENO:
					case LINENO:
					case HIDE:
					case FIRST:
					case LAST:
					case NO:
					case ACCEPT:
					case SQL:
					case CURRENT:
					case TEMP:
					case SIZE:
					case INDEX:
					case WAIT:
					case WORK:
					case FOUND:
					case ASCII:
					case INT_FLAG:
					case NOTFOUND:
					case STATUS: {
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
			} else if ((_tokenSet_5.member(LA(1)))
					&& (_tokenSet_101.member(LA(2)))) {
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}

		}
	}

	public final void fromTable() throws RecognitionException,
			TokenStreamException {

		{
			switch (LA(1)) {
			case OUTER: {
				match(OUTER);
				break;
			}
			case IDENT:
			case INTERRUPT:
			case REAL:
			case STRING_LITERAL:
			case TRUE:
			case FALSE:
			case NOT:
			case NULL:
			case LENGTH:
			case COUNT:
			case USER:
			case GROUP:
			case TODAY:
			case WEEKDAY:
			case MDY:
			case TIME:
			case PAGENO:
			case LINENO:
			case HIDE:
			case FIRST:
			case LAST:
			case NO:
			case ACCEPT:
			case SQL:
			case CURRENT:
			case TEMP:
			case SIZE:
			case INDEX:
			case WAIT:
			case WORK:
			case FOUND:
			case ASCII:
			case INT_FLAG:
			case NOTFOUND:
			case STATUS: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		tableIdentifier();
		{
			if ((LA(1) == IDENT || LA(1) == AS)
					&& (_tokenSet_104.member(LA(2)))) {
				sqlAlias();
			} else if ((_tokenSet_104.member(LA(1)))
					&& (_tokenSet_105.member(LA(2)))) {
			} else {
				throw new NoViableAltException(LT(1), getFilename());
			}

		}
	}

	public final void tableExpression() throws RecognitionException,
			TokenStreamException {

		simpleSelectStatement();
	}

	public final void simpleSelectStatement() throws RecognitionException,
			TokenStreamException {

		headSelectStatement();
		fromSelectStatement();
		{
			switch (LA(1)) {
			case WHERE: {
				whereStatement();
				break;
			}
			case IDENT:
			case END:
			case DEFER:
			case RETURN:
			case RPAREN:
			case WITH:
			case SEMI:
			case RUN:
			case LET:
			case CALL:
			case GOTO:
			case GROUP:
			case PREPARE:
			case IF:
			case ELSE:
			case WHILE:
			case FOR:
			case FOREACH:
			case INTO:
			case CASE:
			case WHEN:
			case OTHERWISE:
			case SLEEP:
			case CONSTRUCT:
			case DISPLAY:
			case INPUT:
			case MENU:
			case EXIT:
			case CONTINUE:
			case ALLOCATE:
			case LOCATE:
			case DEALLOCATE:
			case RESIZE:
			case FREE:
			case INITIALIZE:
			case VALIDATE:
			case START:
			case PAGE:
			case TERMINATE:
			case FINISH:
			case PAUSE:
			case NEED:
			case PRINT:
			case SKIP:
			case OUTPUT:
			case BEFORE:
			case AFTER:
			case ON:
			case NEXT:
			case ERROR:
			case MESSAGE:
			case PROMPT:
			case INSERT:
			case DELETE:
			case COMMAND:
			case SHOW:
			case HIDE:
			case FIRST:
			case ORDER:
			case OPTIONS:
			case CLEAR:
			case CLOSE:
			case CURRENT:
			case OPEN:
			case SCROLL:
			case DECLARE:
			case UPDATE:
			case FETCH:
			case FLUSH:
			case PUT:
			case DROP:
			case CREATE:
			case LOCK:
			case SELECT:
			case UNION:
			case HAVING:
			case LOAD:
			case UNLOAD:
			case SET:
			case EXECUTE:
			case DATABASE:
			case BEGIN:
			case COMMIT:
			case ROLLBACK:
			case WHENEVER: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		{
			switch (LA(1)) {
			case GROUP: {
				groupByStatement();
				break;
			}
			case IDENT:
			case END:
			case DEFER:
			case RETURN:
			case RPAREN:
			case WITH:
			case SEMI:
			case RUN:
			case LET:
			case CALL:
			case GOTO:
			case PREPARE:
			case IF:
			case ELSE:
			case WHILE:
			case FOR:
			case FOREACH:
			case INTO:
			case CASE:
			case WHEN:
			case OTHERWISE:
			case SLEEP:
			case CONSTRUCT:
			case DISPLAY:
			case INPUT:
			case MENU:
			case EXIT:
			case CONTINUE:
			case ALLOCATE:
			case LOCATE:
			case DEALLOCATE:
			case RESIZE:
			case FREE:
			case INITIALIZE:
			case VALIDATE:
			case START:
			case PAGE:
			case TERMINATE:
			case FINISH:
			case PAUSE:
			case NEED:
			case PRINT:
			case SKIP:
			case OUTPUT:
			case BEFORE:
			case AFTER:
			case ON:
			case NEXT:
			case ERROR:
			case MESSAGE:
			case PROMPT:
			case INSERT:
			case DELETE:
			case COMMAND:
			case SHOW:
			case HIDE:
			case FIRST:
			case ORDER:
			case OPTIONS:
			case CLEAR:
			case CLOSE:
			case CURRENT:
			case OPEN:
			case SCROLL:
			case DECLARE:
			case UPDATE:
			case FETCH:
			case FLUSH:
			case PUT:
			case DROP:
			case CREATE:
			case LOCK:
			case SELECT:
			case UNION:
			case HAVING:
			case LOAD:
			case UNLOAD:
			case SET:
			case EXECUTE:
			case DATABASE:
			case BEGIN:
			case COMMIT:
			case ROLLBACK:
			case WHENEVER: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		{
			switch (LA(1)) {
			case HAVING: {
				havingStatement();
				break;
			}
			case IDENT:
			case END:
			case DEFER:
			case RETURN:
			case RPAREN:
			case WITH:
			case SEMI:
			case RUN:
			case LET:
			case CALL:
			case GOTO:
			case PREPARE:
			case IF:
			case ELSE:
			case WHILE:
			case FOR:
			case FOREACH:
			case INTO:
			case CASE:
			case WHEN:
			case OTHERWISE:
			case SLEEP:
			case CONSTRUCT:
			case DISPLAY:
			case INPUT:
			case MENU:
			case EXIT:
			case CONTINUE:
			case ALLOCATE:
			case LOCATE:
			case DEALLOCATE:
			case RESIZE:
			case FREE:
			case INITIALIZE:
			case VALIDATE:
			case START:
			case PAGE:
			case TERMINATE:
			case FINISH:
			case PAUSE:
			case NEED:
			case PRINT:
			case SKIP:
			case OUTPUT:
			case BEFORE:
			case AFTER:
			case ON:
			case NEXT:
			case ERROR:
			case MESSAGE:
			case PROMPT:
			case INSERT:
			case DELETE:
			case COMMAND:
			case SHOW:
			case HIDE:
			case FIRST:
			case ORDER:
			case OPTIONS:
			case CLEAR:
			case CLOSE:
			case CURRENT:
			case OPEN:
			case SCROLL:
			case DECLARE:
			case UPDATE:
			case FETCH:
			case FLUSH:
			case PUT:
			case DROP:
			case CREATE:
			case LOCK:
			case SELECT:
			case UNION:
			case LOAD:
			case UNLOAD:
			case SET:
			case EXECUTE:
			case DATABASE:
			case BEGIN:
			case COMMIT:
			case ROLLBACK:
			case WHENEVER: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		{
			switch (LA(1)) {
			case UNION: {
				unionSelectStatement();
				break;
			}
			case IDENT:
			case END:
			case DEFER:
			case RETURN:
			case RPAREN:
			case WITH:
			case SEMI:
			case RUN:
			case LET:
			case CALL:
			case GOTO:
			case PREPARE:
			case IF:
			case ELSE:
			case WHILE:
			case FOR:
			case FOREACH:
			case INTO:
			case CASE:
			case WHEN:
			case OTHERWISE:
			case SLEEP:
			case CONSTRUCT:
			case DISPLAY:
			case INPUT:
			case MENU:
			case EXIT:
			case CONTINUE:
			case ALLOCATE:
			case LOCATE:
			case DEALLOCATE:
			case RESIZE:
			case FREE:
			case INITIALIZE:
			case VALIDATE:
			case START:
			case PAGE:
			case TERMINATE:
			case FINISH:
			case PAUSE:
			case NEED:
			case PRINT:
			case SKIP:
			case OUTPUT:
			case BEFORE:
			case AFTER:
			case ON:
			case NEXT:
			case ERROR:
			case MESSAGE:
			case PROMPT:
			case INSERT:
			case DELETE:
			case COMMAND:
			case SHOW:
			case HIDE:
			case FIRST:
			case ORDER:
			case OPTIONS:
			case CLEAR:
			case CLOSE:
			case CURRENT:
			case OPEN:
			case SCROLL:
			case DECLARE:
			case UPDATE:
			case FETCH:
			case FLUSH:
			case PUT:
			case DROP:
			case CREATE:
			case LOCK:
			case SELECT:
			case LOAD:
			case UNLOAD:
			case SET:
			case EXECUTE:
			case DATABASE:
			case BEGIN:
			case COMMIT:
			case ROLLBACK:
			case WHENEVER: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
	}

	public final void fromSelectStatement() throws RecognitionException,
			TokenStreamException {

		match(FROM);
		{
			switch (LA(1)) {
			case IDENT:
			case INTERRUPT:
			case REAL:
			case STRING_LITERAL:
			case TRUE:
			case FALSE:
			case NOT:
			case NULL:
			case LENGTH:
			case COUNT:
			case USER:
			case GROUP:
			case TODAY:
			case WEEKDAY:
			case MDY:
			case TIME:
			case PAGENO:
			case LINENO:
			case HIDE:
			case FIRST:
			case LAST:
			case NO:
			case ACCEPT:
			case SQL:
			case CURRENT:
			case TEMP:
			case SIZE:
			case INDEX:
			case OUTER:
			case WAIT:
			case WORK:
			case FOUND:
			case ASCII:
			case INT_FLAG:
			case NOTFOUND:
			case STATUS: {
				fromTable();
				break;
			}
			case LPAREN: {
				match(LPAREN);
				tableExpression();
				match(RPAREN);
				{
					if ((LA(1) == IDENT || LA(1) == AS)
							&& (_tokenSet_104.member(LA(2)))) {
						sqlAlias();
					} else if ((_tokenSet_104.member(LA(1)))
							&& (_tokenSet_105.member(LA(2)))) {
					} else {
						throw new NoViableAltException(LT(1), getFilename());
					}

				}
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		{
			_loop608: do {
				if ((LA(1) == COMMA)) {
					match(COMMA);
					{
						switch (LA(1)) {
						case IDENT:
						case INTERRUPT:
						case REAL:
						case STRING_LITERAL:
						case TRUE:
						case FALSE:
						case NOT:
						case NULL:
						case LENGTH:
						case COUNT:
						case USER:
						case GROUP:
						case TODAY:
						case WEEKDAY:
						case MDY:
						case TIME:
						case PAGENO:
						case LINENO:
						case HIDE:
						case FIRST:
						case LAST:
						case NO:
						case ACCEPT:
						case SQL:
						case CURRENT:
						case TEMP:
						case SIZE:
						case INDEX:
						case OUTER:
						case WAIT:
						case WORK:
						case FOUND:
						case ASCII:
						case INT_FLAG:
						case NOTFOUND:
						case STATUS: {
							fromTable();
							break;
						}
						case LPAREN: {
							match(LPAREN);
							tableExpression();
							match(RPAREN);
							{
								if ((LA(1) == IDENT || LA(1) == AS)
										&& (_tokenSet_104.member(LA(2)))) {
									sqlAlias();
								} else if ((_tokenSet_104.member(LA(1)))
										&& (_tokenSet_105.member(LA(2)))) {
								} else {
									throw new NoViableAltException(LT(1),
											getFilename());
								}

							}
							break;
						}
						default: {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
					}
				} else {
					break _loop608;
				}

			} while (true);
		}
	}

	public final void aliasName() throws RecognitionException,
			TokenStreamException {

		identifier();
	}

	public final void whereStatement() throws RecognitionException,
			TokenStreamException {

		match(WHERE);
		condition();
	}

	public final void groupByStatement() throws RecognitionException,
			TokenStreamException {

		match(GROUP);
		match(BY);
		variableOrConstantList();
	}

	public final void havingStatement() throws RecognitionException,
			TokenStreamException {

		match(HAVING);
		condition();
	}

	public final void unionSelectStatement() throws RecognitionException,
			TokenStreamException {

		{
			match(UNION);
			{
				switch (LA(1)) {
				case ALL: {
					match(ALL);
					break;
				}
				case SELECT: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			simpleSelectStatement();
		}
	}

	public final void orderbyStatement() throws RecognitionException,
			TokenStreamException {

		match(ORDER);
		match(BY);
		orderbyColumn();
		{
			_loop634: do {
				if ((LA(1) == COMMA)) {
					match(COMMA);
					orderbyColumn();
				} else {
					break _loop634;
				}

			} while (true);
		}
	}

	public final void orderbyColumn() throws RecognitionException,
			TokenStreamException {

		expression();
		{
			switch (LA(1)) {
			case ASC: {
				match(ASC);
				break;
			}
			case DESC: {
				match(DESC);
				break;
			}
			case IDENT:
			case END:
			case DEFER:
			case RETURN:
			case RPAREN:
			case COMMA:
			case WITH:
			case SEMI:
			case RUN:
			case LET:
			case CALL:
			case GOTO:
			case PREPARE:
			case IF:
			case ELSE:
			case WHILE:
			case FOR:
			case FOREACH:
			case INTO:
			case CASE:
			case WHEN:
			case OTHERWISE:
			case SLEEP:
			case CONSTRUCT:
			case DISPLAY:
			case INPUT:
			case MENU:
			case EXIT:
			case CONTINUE:
			case ALLOCATE:
			case LOCATE:
			case DEALLOCATE:
			case RESIZE:
			case FREE:
			case INITIALIZE:
			case VALIDATE:
			case START:
			case PAGE:
			case TERMINATE:
			case FINISH:
			case PAUSE:
			case NEED:
			case PRINT:
			case SKIP:
			case OUTPUT:
			case BEFORE:
			case AFTER:
			case ON:
			case NEXT:
			case ERROR:
			case MESSAGE:
			case PROMPT:
			case INSERT:
			case DELETE:
			case COMMAND:
			case SHOW:
			case HIDE:
			case FIRST:
			case OPTIONS:
			case CLEAR:
			case CLOSE:
			case CURRENT:
			case OPEN:
			case SCROLL:
			case DECLARE:
			case UPDATE:
			case FETCH:
			case FLUSH:
			case PUT:
			case DROP:
			case CREATE:
			case LOCK:
			case SELECT:
			case LOAD:
			case UNLOAD:
			case SET:
			case EXECUTE:
			case DATABASE:
			case BEGIN:
			case COMMIT:
			case ROLLBACK:
			case WHENEVER: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
	}

	public final void actualParameterList() throws RecognitionException,
			TokenStreamException {

		actualParameter();
		{
			_loop669: do {
				if ((LA(1) == COMMA)) {
					match(COMMA);
					actualParameter();
				} else {
					break _loop669;
				}

			} while (true);
		}
	}

	public final void wheneverStatement() throws RecognitionException,
			TokenStreamException {

		match(WHENEVER);
		wheneverType();
		wheneverFlow();
		eol();
	}

	public final void wheneverType() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case NOT: {
			match(NOT);
			match(FOUND);
			break;
		}
		case ANY:
		case ERROR:
		case SQLERROR: {
			{
				switch (LA(1)) {
				case ANY: {
					match(ANY);
					break;
				}
				case ERROR:
				case SQLERROR: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			{
				switch (LA(1)) {
				case SQLERROR: {
					match(SQLERROR);
					break;
				}
				case ERROR: {
					match(ERROR);
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			break;
		}
		case SQLWARNING:
		case WARNING: {
			{
				switch (LA(1)) {
				case SQLWARNING: {
					match(SQLWARNING);
					break;
				}
				case WARNING: {
					match(WARNING);
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void wheneverFlow() throws RecognitionException,
			TokenStreamException {

		switch (LA(1)) {
		case CONTINUE: {
			match(CONTINUE);
			break;
		}
		case STOP: {
			match(STOP);
			break;
		}
		case CALL: {
			match(CALL);
			identifier();
			break;
		}
		case GOTO:
		case GO: {
			{
				switch (LA(1)) {
				case GO: {
					match(GO);
					match(TO);
					break;
				}
				case GOTO: {
					match(GOTO);
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			{
				switch (LA(1)) {
				case COLON: {
					match(COLON);
					break;
				}
				case IDENT: {
					break;
				}
				default: {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			identifier();
			break;
		}
		default: {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}

	public final void outputReport() throws RecognitionException,
			TokenStreamException {

		match(OUTPUT);
		{
			switch (LA(1)) {
			case REPORT: {
				match(REPORT);
				match(TO);
				{
					switch (LA(1)) {
					case STRING_LITERAL: {
						string();
						break;
					}
					case PIPE: {
						match(PIPE);
						string();
						break;
					}
					case PRINTER: {
						match(PRINTER);
						break;
					}
					default: {
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
				}
				break;
			}
			case END:
			case RIGHT:
			case LEFT:
			case TOP:
			case BOTTOM:
			case PAGE:
			case ORDER:
			case FORMAT: {
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		{
			_loop713: do {
				switch (LA(1)) {
				case LEFT: {
					{
						match(LEFT);
						match(MARGIN);
						numericConstant();
					}
					break;
				}
				case RIGHT: {
					{
						match(RIGHT);
						match(MARGIN);
						numericConstant();
					}
					break;
				}
				case BOTTOM: {
					{
						match(BOTTOM);
						match(MARGIN);
						numericConstant();
					}
					break;
				}
				case PAGE: {
					{
						match(PAGE);
						match(LENGTH);
						numericConstant();
					}
					break;
				}
				default:
					if ((LA(1) == TOP) && (LA(2) == MARGIN)) {
						{
							match(TOP);
							match(MARGIN);
							numericConstant();
						}
					} else if ((LA(1) == TOP) && (LA(2) == OF)) {
						{
							match(TOP);
							match(OF);
							match(PAGE);
							string();
						}
					} else {
						break _loop713;
					}
				}
			} while (true);
		}
	}

	public final void formatReport() throws RecognitionException,
			TokenStreamException {

		match(FORMAT);
		{
			switch (LA(1)) {
			case EVERY: {
				match(EVERY);
				match(ROW);
				break;
			}
			case PAGE:
			case BEFORE:
			case AFTER:
			case ON:
			case FIRST: {
				{
					int _cnt721 = 0;
					_loop721: do {
						if ((_tokenSet_106.member(LA(1)))) {
							{
								switch (LA(1)) {
								case ON: {
									match(ON);
									{
										switch (LA(1)) {
										case EVERY: {
											match(EVERY);
											match(ROW);
											break;
										}
										case LAST: {
											match(LAST);
											match(ROW);
											break;
										}
										default: {
											throw new NoViableAltException(
													LT(1), getFilename());
										}
										}
									}
									break;
								}
								case BEFORE:
								case AFTER: {
									{
										switch (LA(1)) {
										case BEFORE: {
											match(BEFORE);
											break;
										}
										case AFTER: {
											match(AFTER);
											break;
										}
										default: {
											throw new NoViableAltException(
													LT(1), getFilename());
										}
										}
									}
									match(GROUP);
									match(OF);
									variable();
									break;
								}
								default:
									if ((LA(1) == PAGE || LA(1) == FIRST)
											&& (LA(2) == PAGE || LA(2) == HEADER)) {
										{
											switch (LA(1)) {
											case FIRST: {
												match(FIRST);
												break;
											}
											case PAGE: {
												break;
											}
											default: {
												throw new NoViableAltException(
														LT(1), getFilename());
											}
											}
										}
										match(PAGE);
										match(HEADER);
									} else if ((LA(1) == PAGE)
											&& (LA(2) == TRAILER)) {
										match(PAGE);
										match(TRAILER);
									} else {
										throw new NoViableAltException(LT(1),
												getFilename());
									}
								}
							}
							codeBlock();
						} else {
							if (_cnt721 >= 1) {
								break _loop721;
							} else {
								throw new NoViableAltException(LT(1),
										getFilename());
							}
						}

						_cnt721++;
					} while (true);
				}
				break;
			}
			default: {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
	}

	public final void unsignedInteger() throws RecognitionException,
			TokenStreamException {

		match(NUM_INT);
	}

	public final void unsignedReal() throws RecognitionException,
			TokenStreamException {

		match(NUM_REAL);
	}

	public static final String[] _tokenNames = { "<0>", "EOF", "<2>",
			"NULL_TREE_LOOKAHEAD", "IDENT", "\"main\"", "\"end\"", "\"defer\"",
			"\"interrupt\"", "\"quit\"", "\"return\"", "\"function\"",
			"LPAREN", "RPAREN", "COMMA", "\"globals\"", "\"define\"",
			"\"associate\"", "\"with\"", "\"like\"", "DOT", "\"text\"",
			"\"byte\"", "\"bigint\"", "\"integer\"", "\"int\"", "\"smallint\"",
			"\"real\"", "\"smalfloat\"", "\"decimal\"", "\"dec\"",
			"\"numeric\"", "\"money\"", "\"float\"", "\"double\"",
			"\"varchar\"", "\"nvarchar\"", "\"char\"", "\"nchar\"",
			"CHARACTER", "\"date\"", "\"datetime\"", "\"interval\"",
			"\"year\"", "\"to\"", "\"month\"", "\"day\"", "\"hour\"",
			"\"minute\"", "\"second\"", "\"fraction\"", "\"record\"", "STAR",
			"LBRACK", "RBRACK", "\"array\"", "\"of\"", "\"dymanic\"",
			"\"dimensions\"", "STRING_LITERAL", "COLON", "SEMI", "\"run\"",
			"\"in\"", "\"form\"", "\"mode\"", "\"line\"", "\"without\"",
			"\"waiting\"", "\"returning\"", "\"let\"", "EQUAL", "\"call\"",
			"\"goto\"", "\"true\"", "\"false\"", "\"or\"", "\"and\"",
			"\"not\"", "ESC", "QUOTED_STRING", "\"between\"", "\"is\"",
			"\"null\"", "\"all\"", "\"any\"", "\"exists\"", "PLUS", "MINUS",
			"\"as\"", "DIV", "SLASH", "DOUBLEVERTBAR", "\"units\"",
			"\"distinct\"", "\"mod\"", "\"length\"", "\"avg\"", "\"count\"",
			"\"max\"", "\"min\"", "\"sum\"", "\"decode\"", "\"nvl\"",
			"\"user\"", "NOT_EQUAL", "LE", "LT", "GE", "GT", "\"matches\"",
			"\"clipped\"", "\"using\"", "\"group\"", "\"today\"",
			"\"weekday\"", "\"mdy\"", "\"column\"", "\"extend\"", "\"time\"",
			"\"infield\"", "\"prepare\"", "\"through\"", "\"thru\"", "\"if\"",
			"\"then\"", "\"else\"", "\"while\"", "\"for\"", "STEP",
			"\"foreach\"", "\"into\"", "\"reoptimization\"", "\"case\"",
			"\"when\"", "\"otherwise\"", "\"sleep\"", "\"construct\"",
			"\"display\"", "\"input\"", "\"menu\"", "\"report\"", "\"exit\"",
			"\"program\"", "\"continue\"", "\"allocate\"", "\"locate\"",
			"MEMORY", "\"file\"", "\"deallocate\"", "\"resize\"", "\"free\"",
			"\"initialize\"", "\"validate\"", "\"pageno\"", "\"lineno\"",
			"\"space\"", "\"spaces\"", "\"wordwrap\"", "\"right\"",
			"\"margin\"", "\"start\"", "\"pipe\"", "\"printer\"", "\"left\"",
			"\"top\"", "\"bottom\"", "\"page\"", "\"terminate\"", "\"finish\"",
			"\"pause\"", "\"need\"", "\"lines\"", "\"print\"", "\"skip\"",
			"\"output\"", "SAME", "\"before\"", "\"after\"", "\"field\"",
			"\"on\"", "\"key\"", "\"next\"", "\"previous\"", "\"reverse\"",
			"\"blink\"", "\"underline\"", "\"black\"", "\"blue\"", "\"cyan\"",
			"\"green\"", "\"magenta\"", "\"red\"", "\"white\"", "\"yellow\"",
			"\"bold\"", "\"dim\"", "\"normal\"", "\"invisible\"",
			"\"attribute\"", "\"attributes\"", "\"by\"", "\"name\"",
			"\"from\"", "\"help\"", "\"at\"", "\"error\"", "\"message\"",
			"\"prompt\"", "\"row\"", "\"insert\"", "\"delete\"",
			"\"defaults\"", "\"command\"", "\"option\"", "\"show\"",
			"\"hide\"", "\"first\"", "\"last\"", "\"border\"", "\"comment\"",
			"\"off\"", "WRAP", "\"no\"", "\"accept\"", "\"sql\"", "\"order\"",
			"\"constrained\"", "\"unconstrained\"", "\"options\"", "\"clear\"",
			"\"window\"", "\"screen\"", "\"close\"", "\"current\"", "\"open\"",
			"\"rows\"", "\"columns\"", "\"scroll\"", "\"up\"", "\"down\"",
			"\"declare\"", "\"cursor\"", "\"hold\"", "\"update\"", "\"fetch\"",
			"PRIOR", "\"relative\"", "\"absolute\"", "\"flush\"", "\"put\"",
			"\"table\"", "\"unique\"", "\"constraint\"", "\"drop\"",
			"\"create\"", "\"temp\"", "\"log\"", "\"extent\"", "\"size\"",
			"\"lock\"", "\"cluster\"", "\"index\"", "\"asc\"", "\"desc\"",
			"\"select\"", "ATSYMBOL", "\"outer\"", "\"union\"", "\"where\"",
			"\"having\"", "\"load\"", "\"delimiter\"", "\"unload\"",
			"\"values\"", "\"set\"", "\"execute\"", "\"share\"",
			"\"exclusive\"", "\"statitics\"", "\"wait\"", "SECONDS",
			"\"explain\"", "\"isolation\"", "\"stability\"", "\"dirty\"",
			"COMMITTED", "\"repeatable\"", "\"read\"", "\"buffered\"",
			"\"database\"", "\"begin\"", "\"work\"", "\"commit\"",
			"\"rollback\"", "\"whenever\"", "\"found\"", "\"sqlerror\"",
			"\"sqlwarning\"", "\"warning\"", "\"stop\"", "\"go\"",
			"\"external\"", "\"format\"", "\"every\"", "\"header\"",
			"\"trailer\"", "NUM_INT", "NUM_REAL", "\"ascii\"", "\"int_flag\"",
			"\"notfound\"", "\"status\"", "\"aggregate\"", "\"all_rows\"",
			"\"average\"", "\"cache\"", "\"character\"", "\"char_length\"",
			"\"check\"", "\"commited\"", "\"constant\"", "\"copy\"",
			"\"crcols\"", "\"default\"", "\"do\"", "\"escape\"", "\"exec\"",
			"\"field_touched\"", "\"first_rows\"", "\"formonly\"",
			"\"getfldbuf\"", "\"inner\"", "\"indicator\"", "\"instructions\"",
			"\"isnull\"", "\"join\"", "\"label\"", "\"long\"", "\"module\"",
			"\"new\"", "\"now\"", "\"ord\"", "\"percent\"", "\"precision\"",
			"\"quit_flag\"", "\"remove\"", "\"repeat\"", "\"tables\"",
			"\"type\"", "\"view\"", "WS", "EOL", "SL_COMMENT", "SL_COMMENT_2",
			"COMMENT_1", "EXPONENT", "HEX_DIGIT", "VOCAB" };

	private static final long[] mk_tokenSet_0() {
		long[] data = { 67618L, 0L, 8192L, 0L, 0L, 0L };
		return data;
	}

	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());

	private static final long[] mk_tokenSet_1() {
		long[] data = new long[10];
		data[0] = 4611801467282589138L;
		data[1] = -7782781735954526400L;
		data[2] = 18277190645276453L;
		data[3] = -4165180515981344768L;
		data[4] = 135110170683015769L;
		return data;
	}

	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());

	private static final long[] mk_tokenSet_2() {
		long[] data = { 2082L, 0L, 8192L, 0L, 0L, 0L };
		return data;
	}

	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());

	private static final long[] mk_tokenSet_3() {
		long[] data = new long[10];
		data[0] = 4611686018427388944L;
		data[1] = -7926335344172072128L;
		data[2] = 18277190443949861L;
		data[3] = -4165180531114393600L;
		data[4] = 996434149904L;
		return data;
	}

	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());

	private static final long[] mk_tokenSet_4() {
		long[] data = new long[10];
		data[0] = 8687576722245162448L;
		data[1] = -3171094889643880639L;
		data[2] = 62750786722463725L;
		data[3] = -2309695819962525184L;
		data[4] = 141880972086510203L;
		return data;
	}

	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());

	private static final long[] mk_tokenSet_5() {
		long[] data = new long[10];
		data[0] = 134218000L;
		data[1] = 44474167307291648L;
		data[2] = 201326592L;
		data[3] = 4413196337152L;
		data[4] = 135109157068996681L;
		return data;
	}

	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());

	private static final long[] mk_tokenSet_6() {
		long[] data = new long[10];
		data[0] = 65600L;
		data[2] = 140737488355328L;
		data[3] = 17179869184L;
		data[4] = 140737488355328L;
		return data;
	}

	public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());

	private static final long[] mk_tokenSet_7() {
		long[] data = new long[10];
		data[0] = 134218064L;
		data[1] = 44474167307291648L;
		data[2] = 6193482628603904L;
		data[3] = 4430376206848L;
		data[4] = 135601738278240329L;
		return data;
	}

	public static final BitSet _tokenSet_7 = new BitSet(mk_tokenSet_7());

	private static final long[] mk_tokenSet_8() {
		long[] data = new long[10];
		data[0] = 64L;
		data[2] = 140737488355328L;
		data[3] = 17179869184L;
		data[4] = 140737488355328L;
		return data;
	}

	public static final BitSet _tokenSet_8 = new BitSet(mk_tokenSet_8());

	private static final long[] mk_tokenSet_9() {
		long[] data = new long[10];
		data[0] = 64L;
		data[2] = 6193482427277312L;
		data[3] = 17213424128L;
		data[4] = 492581209243648L;
		return data;
	}

	public static final BitSet _tokenSet_9 = new BitSet(mk_tokenSet_9());

	private static final long[] mk_tokenSet_10() {
		long[] data = new long[10];
		data[0] = 576576201158562064L;
		data[1] = 287668796318567424L;
		data[2] = 201326592L;
		data[3] = 4413196337152L;
		data[4] = 141864556510052425L;
		return data;
	}

	public static final BitSet _tokenSet_10 = new BitSet(mk_tokenSet_10());

	private static final long[] mk_tokenSet_11() {
		long[] data = new long[10];
		data[0] = 5201773018469127632L;
		data[1] = -3170673502151225536L;
		data[2] = 24470189888724965L;
		data[3] = -4165180515979247616L;
		data[4] = 141865570124071513L;
		return data;
	}

	public static final BitSet _tokenSet_11 = new BitSet(mk_tokenSet_11());

	private static final long[] mk_tokenSet_12() {
		long[] data = new long[10];
		data[0] = 4611686018427389136L;
		data[1] = -3314649325744684224L;
		data[2] = 24470189687398373L;
		data[3] = -4165180531078742016L;
		data[4] = 1013614019088L;
		return data;
	}

	public static final BitSet _tokenSet_12 = new BitSet(mk_tokenSet_12());

	private static final long[] mk_tokenSet_13() {
		long[] data = new long[10];
		data[0] = 8687576722245165040L;
		data[1] = -3171094889643880639L;
		data[2] = 71757985977204717L;
		data[3] = -2309695819962394112L;
		data[4] = 143851296923484795L;
		return data;
	}

	public static final BitSet _tokenSet_13 = new BitSet(mk_tokenSet_13());

	private static final long[] mk_tokenSet_14() {
		long[] data = new long[10];
		data[0] = -1706731217731357230L;
		data[1] = -864691954472157204L;
		data[2] = 24487783953817583L;
		data[3] = -4164705509776164480L;
		data[4] = 141865570124100569L;
		return data;
	}

	public static final BitSet _tokenSet_14 = new BitSet(mk_tokenSet_14());

	private static final long[] mk_tokenSet_15() {
		long[] data = { 182404581000101888L, 0L, 0L, 0L, 0L, 0L };
		return data;
	}

	public static final BitSet _tokenSet_15 = new BitSet(mk_tokenSet_15());

	private static final long[] mk_tokenSet_16() {
		long[] data = { 182404581000085504L, 0L, 0L, 0L, 0L, 0L };
		return data;
	}

	public static final BitSet _tokenSet_16 = new BitSet(mk_tokenSet_16());

	private static final long[] mk_tokenSet_17() {
		long[] data = new long[10];
		data[1] = 25165824L;
		data[4] = 6755399441055744L;
		return data;
	}

	public static final BitSet _tokenSet_17 = new BitSet(mk_tokenSet_17());

	private static final long[] mk_tokenSet_18() {
		long[] data = new long[10];
		data[0] = -1706731217731355150L;
		data[1] = -864691954170003508L;
		data[2] = 24487783953825775L;
		data[3] = -4164705509776164480L;
		data[4] = 142006307612455897L;
		return data;
	}

	public static final BitSet _tokenSet_18 = new BitSet(mk_tokenSet_18());

	private static final long[] mk_tokenSet_19() {
		long[] data = new long[10];
		data[0] = -360287970189639694L;
		data[1] = -19L;
		data[2] = 71776063226118127L;
		data[3] = -2309220813758268544L;
		data[4] = 144062403162405887L;
		return data;
	}

	public static final BitSet _tokenSet_19 = new BitSet(mk_tokenSet_19());

	private static final long[] mk_tokenSet_20() {
		long[] data = new long[10];
		data[1] = 144115188075855872L;
		data[2] = 8388608L;
		data[3] = -4165255710247223296L;
		data[4] = 996434149904L;
		return data;
	}

	public static final BitSet _tokenSet_20 = new BitSet(mk_tokenSet_20());

	private static final long[] mk_tokenSet_21() {
		long[] data = new long[10];
		data[0] = 581097392971976976L;
		data[1] = 44475244298652672L;
		data[2] = 54043195729772552L;
		data[3] = 1855487459672999936L;
		data[4] = 141879975652360315L;
		return data;
	}

	public static final BitSet _tokenSet_21 = new BitSet(mk_tokenSet_21());

	private static final long[] mk_tokenSet_22() {
		long[] data = new long[8];
		data[0] = 4611686018427388928L;
		data[1] = 512L;
		data[2] = 262791934467840L;
		data[3] = 86174223941632L;
		return data;
	}

	public static final BitSet _tokenSet_22 = new BitSet(mk_tokenSet_22());

	private static final long[] mk_tokenSet_23() {
		long[] data = new long[10];
		data[0] = 8683073122617791952L;
		data[1] = -3171095717501972671L;
		data[2] = 62750786722463717L;
		data[3] = -4165178866443365888L;
		data[4] = 141865570124071513L;
		return data;
	}

	public static final BitSet _tokenSet_23 = new BitSet(mk_tokenSet_23());

	private static final long[] mk_tokenSet_24() {
		long[] data = new long[8];
		data[2] = 18014398509563904L;
		data[3] = 25165824L;
		return data;
	}

	public static final BitSet _tokenSet_24 = new BitSet(mk_tokenSet_24());

	private static final long[] mk_tokenSet_25() {
		long[] data = { 0L, 0L, 18014398509563904L, 0L, 0L, 0L };
		return data;
	}

	public static final BitSet _tokenSet_25 = new BitSet(mk_tokenSet_25());

	private static final long[] mk_tokenSet_26() {
		long[] data = new long[8];
		data[3] = 441926708552007680L;
		return data;
	}

	public static final BitSet _tokenSet_26 = new BitSet(mk_tokenSet_26());

	private static final long[] mk_tokenSet_27() {
		long[] data = new long[8];
		data[0] = 16L;
		data[2] = 54043195528445952L;
		data[3] = 126105187713548288L;
		return data;
	}

	public static final BitSet _tokenSet_27 = new BitSet(mk_tokenSet_27());

	private static final long[] mk_tokenSet_28() {
		long[] data = new long[10];
		data[3] = 4503599628156928L;
		data[4] = 164352L;
		return data;
	}

	public static final BitSet _tokenSet_28 = new BitSet(mk_tokenSet_28());

	private static final long[] mk_tokenSet_29() {
		long[] data = new long[10];
		data[0] = 581097392971976976L;
		data[1] = 44475244296555520L;
		data[2] = 201326600L;
		data[3] = 1152925917803186176L;
		data[4] = 141864556510052425L;
		return data;
	}

	public static final BitSet _tokenSet_29 = new BitSet(mk_tokenSet_29());

	private static final long[] mk_tokenSet_30() {
		long[] data = new long[10];
		data[4] = 8799649810L;
		return data;
	}

	public static final BitSet _tokenSet_30 = new BitSet(mk_tokenSet_30());

	private static final long[] mk_tokenSet_31() {
		long[] data = new long[10];
		data[0] = 4611686018427389136L;
		data[1] = -3314649325744684184L;
		data[2] = 24470189687398373L;
		data[3] = -4165180531078742016L;
		data[4] = 1013614019088L;
		return data;
	}

	public static final BitSet _tokenSet_31 = new BitSet(mk_tokenSet_31());

	private static final long[] mk_tokenSet_32() {
		long[] data = new long[10];
		data[0] = -1706731217731422766L;
		data[1] = -864691954472157204L;
		data[2] = 24487783953817583L;
		data[3] = -4164705509776164480L;
		data[4] = 142006307612521433L;
		return data;
	}

	public static final BitSet _tokenSet_32 = new BitSet(mk_tokenSet_32());

	private static final long[] mk_tokenSet_33() {
		long[] data = new long[10];
		data[0] = -1697724018475633198L;
		data[1] = -864691954472157204L;
		data[2] = 24487783953817583L;
		data[3] = -4164705509776164480L;
		data[4] = 142006307612521433L;
		return data;
	}

	public static final BitSet _tokenSet_33 = new BitSet(mk_tokenSet_33());

	private static final long[] mk_tokenSet_34() {
		long[] data = new long[10];
		data[0] = 6917529027641353424L;
		data[1] = -3314086375791250624L;
		data[2] = 24470189687398381L;
		data[3] = -4165180513898872832L;
		data[4] = 1013614039568L;
		return data;
	}

	public static final BitSet _tokenSet_34 = new BitSet(mk_tokenSet_34());

	private static final long[] mk_tokenSet_35() {
		long[] data = new long[10];
		data[0] = 581079800785932560L;
		data[1] = 44475243225959424L;
		data[2] = 201326592L;
		data[3] = 4413196337152L;
		data[4] = 141864556510052425L;
		return data;
	}

	public static final BitSet _tokenSet_35 = new BitSet(mk_tokenSet_35());

	private static final long[] mk_tokenSet_36() {
		long[] data = new long[10];
		data[0] = -7480363532205682416L;
		data[1] = 44613782698085504L;
		data[2] = 201326592L;
		data[3] = 4413196337152L;
		data[4] = 141864556510053961L;
		return data;
	}

	public static final BitSet _tokenSet_36 = new BitSet(mk_tokenSet_36());

	private static final long[] mk_tokenSet_37() {
		long[] data = new long[10];
		data[0] = 581079800785932560L;
		data[1] = 44475243221765120L;
		data[2] = 201326592L;
		data[3] = 4413196337152L;
		data[4] = 141864556510052425L;
		return data;
	}

	public static final BitSet _tokenSet_37 = new BitSet(mk_tokenSet_37());

	private static final long[] mk_tokenSet_38() {
		long[] data = new long[10];
		data[0] = -7480363532206206704L;
		data[1] = 44475244228398080L;
		data[2] = 201326592L;
		data[3] = 4413196337152L;
		data[4] = 141864556510053449L;
		return data;
	}

	public static final BitSet _tokenSet_38 = new BitSet(mk_tokenSet_38());

	private static final long[] mk_tokenSet_39() {
		long[] data = new long[10];
		data[0] = 1743008504649093392L;
		data[1] = 44475244228398080L;
		data[2] = 201326592L;
		data[3] = 4413196337152L;
		data[4] = 141864556510053449L;
		return data;
	}

	public static final BitSet _tokenSet_39 = new BitSet(mk_tokenSet_39());

	private static final long[] mk_tokenSet_40() {
		long[] data = new long[10];
		data[0] = 1743008504648569104L;
		data[1] = 44475244228529152L;
		data[2] = 201326592L;
		data[3] = 4413196337152L;
		data[4] = 141864556510053449L;
		return data;
	}

	public static final BitSet _tokenSet_40 = new BitSet(mk_tokenSet_40());

	private static final long[] mk_tokenSet_41() {
		long[] data = new long[10];
		data[0] = 1743008504648569104L;
		data[1] = 44475244228660224L;
		data[2] = 201326592L;
		data[3] = 4413196337152L;
		data[4] = 141864556510053449L;
		return data;
	}

	public static final BitSet _tokenSet_41 = new BitSet(mk_tokenSet_41());

	private static final long[] mk_tokenSet_42() {
		long[] data = new long[10];
		data[0] = 1743008504649093392L;
		data[1] = 44613782697692288L;
		data[2] = 201326592L;
		data[3] = 4413196337152L;
		data[4] = 141864556510053961L;
		return data;
	}

	public static final BitSet _tokenSet_42 = new BitSet(mk_tokenSet_42());

	private static final long[] mk_tokenSet_43() {
		long[] data = new long[10];
		data[0] = 1743008504649093392L;
		data[1] = 44613782693497984L;
		data[2] = 201326592L;
		data[3] = 4413196337152L;
		data[4] = 141864556510053449L;
		return data;
	}

	public static final BitSet _tokenSet_43 = new BitSet(mk_tokenSet_43());

	private static final long[] mk_tokenSet_44() {
		long[] data = new long[10];
		data[0] = 8660537532289922512L;
		data[1] = -3270174081516273856L;
		data[2] = 24470189888724973L;
		data[3] = -4165180498799378432L;
		data[4] = 141865570124093017L;
		return data;
	}

	public static final BitSet _tokenSet_44 = new BitSet(mk_tokenSet_44());

	private static final long[] mk_tokenSet_45() {
		long[] data = { 4503599627370496L, 201326592L, 0L, 0L, 0L, 0L };
		return data;
	}

	public static final BitSet _tokenSet_45 = new BitSet(mk_tokenSet_45());

	private static final long[] mk_tokenSet_46() {
		long[] data = new long[10];
		data[0] = 580964352065011984L;
		data[1] = 44474167307291648L;
		data[2] = 201326592L;
		data[3] = 4413196337152L;
		data[4] = 135109157068996681L;
		return data;
	}

	public static final BitSet _tokenSet_46 = new BitSet(mk_tokenSet_46());

	private static final long[] mk_tokenSet_47() {
		long[] data = new long[10];
		data[0] = -1139410705588656688L;
		data[1] = -3270036618906501184L;
		data[2] = 24470189888724973L;
		data[3] = -4165180498799376384L;
		data[4] = 135110170683037273L;
		return data;
	}

	public static final BitSet _tokenSet_47 = new BitSet(mk_tokenSet_47());

	private static final long[] mk_tokenSet_48() {
		long[] data = new long[10];
		data[0] = 576460752437641488L;
		data[1] = 44474167307291648L;
		data[2] = 201326592L;
		data[3] = 4413196337152L;
		data[4] = 141864556510052425L;
		return data;
	}

	public static final BitSet _tokenSet_48 = new BitSet(mk_tokenSet_48());

	private static final long[] mk_tokenSet_49() {
		long[] data = new long[10];
		data[0] = -2301339409585511216L;
		data[1] = -3313947836260355136L;
		data[2] = 24470189687398381L;
		data[3] = -4165180513898870784L;
		data[4] = 1013614039568L;
		return data;
	}

	public static final BitSet _tokenSet_49 = new BitSet(mk_tokenSet_49());

	private static final long[] mk_tokenSet_50() {
		long[] data = new long[10];
		data[0] = 581079800785940752L;
		data[1] = 44475243221765120L;
		data[2] = 201326592L;
		data[3] = 4413196337152L;
		data[4] = 141864556510052425L;
		return data;
	}

	public static final BitSet _tokenSet_50 = new BitSet(mk_tokenSet_50());

	private static final long[] mk_tokenSet_51() {
		long[] data = new long[10];
		data[0] = -562834504564312624L;
		data[1] = -3270035543017193536L;
		data[2] = 24470189888724973L;
		data[3] = -4165180498799376384L;
		data[4] = 141865570124093017L;
		return data;
	}

	public static final BitSet _tokenSet_51 = new BitSet(mk_tokenSet_51());

	private static final long[] mk_tokenSet_52() {
		long[] data = new long[10];
		data[0] = 115448855134480L;
		data[1] = 44474994088496128L;
		data[2] = 201326592L;
		data[3] = 4413196337152L;
		data[4] = 135109157068996681L;
		return data;
	}

	public static final BitSet _tokenSet_52 = new BitSet(mk_tokenSet_52());

	private static final long[] mk_tokenSet_53() {
		long[] data = new long[10];
		data[0] = 134218000L;
		data[1] = 44474991941012480L;
		data[2] = 201326592L;
		data[3] = 4413196337152L;
		data[4] = 135109157068996681L;
		return data;
	}

	public static final BitSet _tokenSet_53 = new BitSet(mk_tokenSet_53());

	private static final long[] mk_tokenSet_54() {
		long[] data = new long[10];
		data[0] = -2301339409585511216L;
		data[1] = -3313947836260355136L;
		data[2] = 24470189687398381L;
		data[3] = -4165180513898866304L;
		data[4] = 1013614039568L;
		return data;
	}

	public static final BitSet _tokenSet_54 = new BitSet(mk_tokenSet_54());

	private static final long[] mk_tokenSet_55() {
		long[] data = new long[10];
		data[0] = 4611686018427921488L;
		data[1] = -5620353796493249600L;
		data[2] = 18277190443949861L;
		data[3] = -4165180531114393600L;
		data[4] = 1013614019088L;
		return data;
	}

	public static final BitSet _tokenSet_55 = new BitSet(mk_tokenSet_55());

	private static final long[] mk_tokenSet_56() {
		long[] data = new long[10];
		data[0] = 5201773018469643600L;
		data[1] = -5476800185364611136L;
		data[2] = 18277190645276453L;
		data[3] = -4165180515981344768L;
		data[4] = 141865570124071513L;
		return data;
	}

	public static final BitSet _tokenSet_56 = new BitSet(mk_tokenSet_56());

	private static final long[] mk_tokenSet_57() {
		long[] data = { 524288L, 138538465116288L, 0L, 0L, 0L, 0L };
		return data;
	}

	public static final BitSet _tokenSet_57 = new BitSet(mk_tokenSet_57());

	private static final long[] mk_tokenSet_58() {
		long[] data = new long[10];
		data[0] = 576576201158562064L;
		data[1] = 287739165062745088L;
		data[2] = 201326592L;
		data[3] = 4413196337152L;
		data[4] = 141864556510052425L;
		return data;
	}

	public static final BitSet _tokenSet_58 = new BitSet(mk_tokenSet_58());

	private static final long[] mk_tokenSet_59() {
		long[] data = new long[10];
		data[0] = 590087000041722128L;
		data[1] = 287668799204510720L;
		data[2] = 201326592L;
		data[3] = 4413196337152L;
		data[4] = 141864556510052425L;
		return data;
	}

	public static final BitSet _tokenSet_59 = new BitSet(mk_tokenSet_59());

	private static final long[] mk_tokenSet_60() {
		long[] data = new long[10];
		data[0] = 5201773018469643600L;
		data[1] = -5476800185364873280L;
		data[2] = 18277190645276453L;
		data[3] = -4165180515981344768L;
		data[4] = 141865570124071513L;
		return data;
	}

	public static final BitSet _tokenSet_60 = new BitSet(mk_tokenSet_60());

	private static final long[] mk_tokenSet_61() {
		long[] data = new long[10];
		data[0] = -1697724018475633198L;
		data[1] = -864691954472157236L;
		data[2] = 24487783953817583L;
		data[3] = -4164705509776164480L;
		data[4] = 141865570124100569L;
		return data;
	}

	public static final BitSet _tokenSet_61 = new BitSet(mk_tokenSet_61());

	private static final long[] mk_tokenSet_62() {
		long[] data = { 4503599627370496L, 2348810240L, 0L, 0L, 0L, 0L };
		return data;
	}

	public static final BitSet _tokenSet_62 = new BitSet(mk_tokenSet_62());

	private static final long[] mk_tokenSet_63() {
		long[] data = new long[10];
		data[0] = 115448855134480L;
		data[1] = 287668796293401600L;
		data[2] = 201326592L;
		data[3] = 4413196337152L;
		data[4] = 135109157068996681L;
		return data;
	}

	public static final BitSet _tokenSet_63 = new BitSet(mk_tokenSet_63());

	private static final long[] mk_tokenSet_64() {
		long[] data = new long[10];
		data[0] = -1706731217731422766L;
		data[1] = -864691954472157236L;
		data[2] = 24487783953817583L;
		data[3] = -4164705509776164480L;
		data[4] = 141865570124100569L;
		return data;
	}

	public static final BitSet _tokenSet_64 = new BitSet(mk_tokenSet_64());

	private static final long[] mk_tokenSet_65() {
		long[] data = new long[10];
		data[0] = 576460752437641488L;
		data[1] = 44474167332457472L;
		data[2] = 201326592L;
		data[3] = 4413196337152L;
		data[4] = 141864556510052425L;
		return data;
	}

	public static final BitSet _tokenSet_65 = new BitSet(mk_tokenSet_65());

	private static final long[] mk_tokenSet_66() {
		long[] data = { 2225411534618624L, 0L, 0L, 0L, 0L, 0L };
		return data;
	}

	public static final BitSet _tokenSet_66 = new BitSet(mk_tokenSet_66());

	private static final long[] mk_tokenSet_67() {
		long[] data = new long[10];
		data[0] = -506662517079244814L;
		data[1] = -65555L;
		data[2] = 71776063226118127L;
		data[3] = -2309220813758268544L;
		data[4] = 143992034418226171L;
		return data;
	}

	public static final BitSet _tokenSet_67 = new BitSet(mk_tokenSet_67());

	private static final long[] mk_tokenSet_68() {
		long[] data = new long[10];
		data[0] = 581079800785940752L;
		data[1] = 287668796318567424L;
		data[2] = 201326592L;
		data[3] = 4413196337152L;
		data[4] = 141864556510052425L;
		return data;
	}

	public static final BitSet _tokenSet_68 = new BitSet(mk_tokenSet_68());

	private static final long[] mk_tokenSet_69() {
		long[] data = new long[10];
		data[0] = -1706731217730374190L;
		data[1] = -826017021972L;
		data[2] = 24487783953817583L;
		data[3] = -4164705509776164480L;
		data[4] = 142006307612521433L;
		return data;
	}

	public static final BitSet _tokenSet_69 = new BitSet(mk_tokenSet_69());

	private static final long[] mk_tokenSet_70() {
		long[] data = new long[10];
		data[0] = -1706731217731422766L;
		data[1] = -826017021972L;
		data[2] = 24487783953817583L;
		data[3] = -4164705509776164480L;
		data[4] = 142006307612521433L;
		return data;
	}

	public static final BitSet _tokenSet_70 = new BitSet(mk_tokenSet_70());

	private static final long[] mk_tokenSet_71() {
		long[] data = new long[10];
		data[0] = -506662517079244814L;
		data[1] = -65539L;
		data[2] = 71776063226642431L;
		data[3] = -2309220813758268544L;
		data[4] = 143992034418228219L;
		return data;
	}

	public static final BitSet _tokenSet_71 = new BitSet(mk_tokenSet_71());

	private static final long[] mk_tokenSet_72() {
		long[] data = { 64L, 0L, 192L, 0L, 0L, 0L };
		return data;
	}

	public static final BitSet _tokenSet_72 = new BitSet(mk_tokenSet_72());

	private static final long[] mk_tokenSet_73() {
		long[] data = new long[10];
		data[0] = 4620693217683178704L;
		data[1] = -3314649325744684224L;
		data[2] = 24470189687398373L;
		data[3] = -4165180531078742016L;
		data[4] = 1013614019088L;
		return data;
	}

	public static final BitSet _tokenSet_73 = new BitSet(mk_tokenSet_73());

	private static final long[] mk_tokenSet_74() {
		long[] data = new long[10];
		data[0] = 7494105228805936592L;
		data[1] = -3171095717501972672L;
		data[2] = 24470189888724965L;
		data[3] = -4165180515979247616L;
		data[4] = 141865570124071513L;
		return data;
	}

	public static final BitSet _tokenSet_74 = new BitSet(mk_tokenSet_74());

	private static final long[] mk_tokenSet_75() {
		long[] data = new long[10];
		data[0] = 8696583921500970992L;
		data[1] = -3170672676440617151L;
		data[2] = 71757987856252909L;
		data[3] = -2309695819962394112L;
		data[4] = 143851296923484795L;
		return data;
	}

	public static final BitSet _tokenSet_75 = new BitSet(mk_tokenSet_75());

	private static final long[] mk_tokenSet_76() {
		long[] data = new long[10];
		data[0] = 576576201164853520L;
		data[1] = 287668796318567424L;
		data[2] = 201326592L;
		data[3] = 4413196337152L;
		data[4] = 141864556510052425L;
		return data;
	}

	public static final BitSet _tokenSet_76 = new BitSet(mk_tokenSet_76());

	private static final long[] mk_tokenSet_77() {
		long[] data = new long[10];
		data[0] = 7507616027682821584L;
		data[1] = -3170673502151225536L;
		data[2] = 24470191767773157L;
		data[3] = -4165180515979247616L;
		data[4] = 141865570124071513L;
		return data;
	}

	public static final BitSet _tokenSet_77 = new BitSet(mk_tokenSet_77());

	private static final long[] mk_tokenSet_78() {
		long[] data = new long[10];
		data[0] = 6917529027641083088L;
		data[1] = -3314649325744684224L;
		data[2] = 24470189687398373L;
		data[3] = -4165180531078742016L;
		data[4] = 1013614019088L;
		return data;
	}

	public static final BitSet _tokenSet_78 = new BitSet(mk_tokenSet_78());

	private static final long[] mk_tokenSet_79() {
		long[] data = new long[10];
		data[0] = 4611686018427389136L;
		data[1] = -3314649325744684224L;
		data[2] = 24470189687398373L;
		data[3] = -4165179431567114240L;
		data[4] = 1013614019088L;
		return data;
	}

	public static final BitSet _tokenSet_79 = new BitSet(mk_tokenSet_79());

	private static final long[] mk_tokenSet_80() {
		long[] data = new long[10];
		data[0] = 576576201158562064L;
		data[1] = 287668796318567424L;
		data[2] = 201326592L;
		data[3] = 4413196337664L;
		data[4] = 141864556510052425L;
		return data;
	}

	public static final BitSet _tokenSet_80 = new BitSet(mk_tokenSet_80());

	private static final long[] mk_tokenSet_81() {
		long[] data = { 0L, -9223372036854775808L, 15909L, 0L, 0L, 0L };
		return data;
	}

	public static final BitSet _tokenSet_81 = new BitSet(mk_tokenSet_81());

	private static final long[] mk_tokenSet_82() {
		long[] data = new long[10];
		data[0] = 5201773018469111248L;
		data[1] = -3170673502151225536L;
		data[2] = 24470189888724965L;
		data[3] = -4165180515979247616L;
		data[4] = 141865570124071513L;
		return data;
	}

	public static final BitSet _tokenSet_82 = new BitSet(mk_tokenSet_82());

	private static final long[] mk_tokenSet_83() {
		long[] data = new long[10];
		data[0] = 6917529027641099472L;
		data[1] = -3314649325744684224L;
		data[2] = 24470189687398373L;
		data[3] = -4165180531078742016L;
		data[4] = 1013614019088L;
		return data;
	}

	public static final BitSet _tokenSet_83 = new BitSet(mk_tokenSet_83());

	private static final long[] mk_tokenSet_84() {
		long[] data = new long[10];
		data[0] = 4611686018427388944L;
		data[1] = -7926335344172072128L;
		data[2] = 18277190443949861L;
		data[3] = -4165180531114393600L;
		data[4] = 1013614019088L;
		return data;
	}

	public static final BitSet _tokenSet_84 = new BitSet(mk_tokenSet_84());

	private static final long[] mk_tokenSet_85() {
		long[] data = { 0L, 0L, 6192449487634432L, 0L, 0L, 0L };
		return data;
	}

	public static final BitSet _tokenSet_85 = new BitSet(mk_tokenSet_85());

	private static final long[] mk_tokenSet_86() {
		long[] data = { 0L, 0L, 11258999068426752L, 0L, 0L, 0L };
		return data;
	}

	public static final BitSet _tokenSet_86 = new BitSet(mk_tokenSet_86());

	private static final long[] mk_tokenSet_87() {
		long[] data = new long[8];
		data[2] = 2048L;
		data[3] = 917504L;
		return data;
	}

	public static final BitSet _tokenSet_87 = new BitSet(mk_tokenSet_87());

	private static final long[] mk_tokenSet_88() {
		long[] data = new long[8];
		data[2] = 11258999068428288L;
		data[3] = 917504L;
		return data;
	}

	public static final BitSet _tokenSet_88 = new BitSet(mk_tokenSet_88());

	private static final long[] mk_tokenSet_89() {
		long[] data = new long[10];
		data[0] = 5201773018469111120L;
		data[1] = -7782359520578613440L;
		data[2] = 18840140598697765L;
		data[3] = -4165180515979243520L;
		data[4] = 141865570124071513L;
		return data;
	}

	public static final BitSet _tokenSet_89 = new BitSet(mk_tokenSet_89());

	private static final long[] mk_tokenSet_90() {
		long[] data = new long[10];
		data[0] = 4611686018427389008L;
		data[1] = -7926335344172072128L;
		data[2] = 18840140397371173L;
		data[3] = -4165180531112292352L;
		data[4] = 1013614019088L;
		return data;
	}

	public static final BitSet _tokenSet_90 = new BitSet(mk_tokenSet_90());

	private static final long[] mk_tokenSet_91() {
		long[] data = new long[10];
		data[0] = 8687576722245162320L;
		data[1] = -7782780908071268543L;
		data[2] = 66127936687177709L;
		data[3] = -2309695819962525184L;
		data[4] = 141880972086510203L;
		return data;
	}

	public static final BitSet _tokenSet_91 = new BitSet(mk_tokenSet_91());

	private static final long[] mk_tokenSet_92() {
		long[] data = new long[10];
		data[0] = 8687576722245165040L;
		data[1] = -3171094889643880637L;
		data[2] = 71757985977204717L;
		data[3] = -2309695819962394112L;
		data[4] = 143851296923484795L;
		return data;
	}

	public static final BitSet _tokenSet_92 = new BitSet(mk_tokenSet_92());

	private static final long[] mk_tokenSet_93() {
		long[] data = new long[10];
		data[3] = 1152921504606846976L;
		data[4] = 96L;
		return data;
	}

	public static final BitSet _tokenSet_93 = new BitSet(mk_tokenSet_93());

	private static final long[] mk_tokenSet_94() {
		long[] data = new long[10];
		data[0] = 770097944092897552L;
		data[1] = 44474167307291648L;
		data[2] = 201326592L;
		data[3] = 4413196337152L;
		data[4] = 135109157068996681L;
		return data;
	}

	public static final BitSet _tokenSet_94 = new BitSet(mk_tokenSet_94());

	private static final long[] mk_tokenSet_95() {
		long[] data = { -9223372036854751232L, 16384L, 0L, 0L, 0L, 0L };
		return data;
	}

	public static final BitSet _tokenSet_95 = new BitSet(mk_tokenSet_95());

	private static final long[] mk_tokenSet_96() {
		long[] data = new long[10];
		data[0] = -562834504564599344L;
		data[1] = -3270035543046598720L;
		data[2] = 24470189888724965L;
		data[3] = -4165180515979247616L;
		data[4] = 141865570124072537L;
		return data;
	}

	public static final BitSet _tokenSet_96 = new BitSet(mk_tokenSet_96());

	private static final long[] mk_tokenSet_97() {
		long[] data = new long[10];
		data[0] = 1161928703996854544L;
		data[1] = 44474167307291776L;
		data[2] = 201326592L;
		data[3] = 4413196337152L;
		data[4] = 135109157068997705L;
		return data;
	}

	public static final BitSet _tokenSet_97 = new BitSet(mk_tokenSet_97());

	private static final long[] mk_tokenSet_98() {
		long[] data = { 4503599627374608L, 0L, 0L, 0L, 0L, 0L };
		return data;
	}

	public static final BitSet _tokenSet_98 = new BitSet(mk_tokenSet_98());

	private static final long[] mk_tokenSet_99() {
		long[] data = new long[10];
		data[0] = 580964352066060560L;
		data[1] = 44474167307291776L;
		data[2] = 201326592L;
		data[3] = 4413196337152L;
		data[4] = 135109157068996681L;
		return data;
	}

	public static final BitSet _tokenSet_99 = new BitSet(mk_tokenSet_99());

	private static final long[] mk_tokenSet_100() {
		long[] data = new long[10];
		data[0] = -1139410705722870576L;
		data[1] = -3313947836260355136L;
		data[2] = 24470189687398381L;
		data[3] = -4165180513898866304L;
		data[4] = 1013614310928L;
		return data;
	}

	public static final BitSet _tokenSet_100 = new BitSet(mk_tokenSet_100());

	private static final long[] mk_tokenSet_101() {
		long[] data = new long[10];
		data[0] = -2292332210329717552L;
		data[1] = -3313947836260355136L;
		data[2] = 24470189687398381L;
		data[3] = -4165180513898866304L;
		data[4] = 1013614309904L;
		return data;
	}

	public static final BitSet _tokenSet_101 = new BitSet(mk_tokenSet_101());

	private static final long[] mk_tokenSet_102() {
		long[] data = new long[10];
		data[0] = 576460752437641488L;
		data[1] = 44474167307291648L;
		data[2] = 201326592L;
		data[3] = 4413196337152L;
		data[4] = 135109157068996681L;
		return data;
	}

	public static final BitSet _tokenSet_102 = new BitSet(mk_tokenSet_102());

	private static final long[] mk_tokenSet_103() {
		long[] data = new long[10];
		data[0] = -2292332210195499568L;
		data[1] = -3270036618906501184L;
		data[2] = 24470189888724973L;
		data[3] = -4165180498799371904L;
		data[4] = 135110170683306585L;
		return data;
	}

	public static final BitSet _tokenSet_103 = new BitSet(mk_tokenSet_103());

	private static final long[] mk_tokenSet_104() {
		long[] data = new long[10];
		data[0] = 6917529027641369808L;
		data[1] = -3314086375791262912L;
		data[2] = 24470189687398381L;
		data[3] = -4165180513898872832L;
		data[4] = 1013614047760L;
		return data;
	}

	public static final BitSet _tokenSet_104 = new BitSet(mk_tokenSet_104());

	private static final long[] mk_tokenSet_105() {
		long[] data = new long[10];
		data[0] = 8687576722245451760L;
		data[1] = -3171094889606119615L;
		data[2] = 71757985977204717L;
		data[3] = -2309695802782524928L;
		data[4] = 143851296923515515L;
		return data;
	}

	public static final BitSet _tokenSet_105 = new BitSet(mk_tokenSet_105());

	private static final long[] mk_tokenSet_106() {
		long[] data = new long[8];
		data[2] = 6192999243448320L;
		data[3] = 33554432L;
		return data;
	}

	public static final BitSet _tokenSet_106 = new BitSet(mk_tokenSet_106());

	
	public void functionStart(String functionName, int line) {
		// apenas para marcar o inicio de uma funcao
	}

	public void functionEnd(int line) {
		// apenas para marcar o fim de uma funcao
	}

}
