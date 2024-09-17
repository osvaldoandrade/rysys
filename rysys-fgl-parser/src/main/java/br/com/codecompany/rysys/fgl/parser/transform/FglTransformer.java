package br.com.codecompany.rysys.fgl.parser.transform;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import antlr.RecognitionException;
import antlr.TokenStreamException;
import br.com.codecompany.rysys.fgl.parser.FGLLexer;
import br.com.codecompany.rysys.fgl.parser.FGLParser;
import br.com.codecompany.rysys.fgl.parser.FGLTokenTypes;
import br.com.codecompany.rysys.fgl.parser.type.FglRysysType;

public class FglTransformer {

	private static final Logger log = LoggerFactory.getLogger(FglTransformer.class);
	
	private static final Pattern WHENEVER_INSTRUCTION = 
		Pattern.compile("[.[^\\#]]*whenever\\p{Space}+error.*", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	
	private static final String WHENEVER_STATEMENT = "whenever error call handleError";

	private File input;
	private File output;
	private FGLLexer lexer = null;
	private FGLParser parser = null;
	
	// funcao possui returno?
	boolean returnExists = false;
	
	// locais onde instrucao 'whenever' serah inserida
	private Map<Integer, String> wheneverLocationsMap = new HashMap<Integer, String>();

	public FglTransformer(File input, File output) throws FileNotFoundException {
		this.input = input;
		this.output = output;
		lexer = new FGLLexer(new FileInputStream(input));
		parser = new FGLParser(lexer);
	}

	public void transform() throws TokenStreamException, RecognitionException,
			IOException {
		log.info("Parsing " + input);
		parse();
		log.info("Done.");
		log.info("-------------------------------------");
		log.info(Context.getInstance().dump());
		log.info("-------------------------------------");
		wheneverLocationsMap = createWheneverLineMap();
		log.info("Writing new code on " + output);
		update();
		log.info("Done.");
	}
	
	// armazena todas as linha onde serao inseridas instrucoes 'whenever'
	private Map<Integer, String> createWheneverLineMap() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		for (Function function : Context.getInstance().getFunctions()) {
			int location = function.getWheneverInsertionLine();
			if (location > 0) {
				map.put(location, WHENEVER_STATEMENT);
			}
		}
		return map;
	}

	// analisa os tokens e chama as funcoes apropriadas para que o aspecto intercepte
	private void parse() throws TokenStreamException, RecognitionException {
		while (parser.LA(1) != FGLTokenTypes.EOF) {

			if (parser.LA(1) == FGLTokenTypes.DEFINE) {
				parser.typeDeclarations();
			} 
			else if (parser.LA(1) == FGLTokenTypes.RETURN) {
				parser.returnStatement();
			}
			else if (parser.LA(1) == FGLTokenTypes.WHENEVER) {
				parser.wheneverStatement();
			} 			
			else if (parser.LA(1) == FGLTokenTypes.FUNCTION
					&& parser.LA(2) == FGLTokenTypes.IDENT) {
				parser.functionStart(parser.LT(2).getText(), parser.LT(2)
						.getLine());
			} 
			if (parser.LA(1) == FGLTokenTypes.END && parser.LA(2) == FGLTokenTypes.FUNCTION) {
				parser.functionEnd(parser.LT(1).getLine());
			}

			parser.consume();
		}
	}

	// analisa cada uma das linhas lidas
	private final void update() throws IOException {
		StringBuilder code = new StringBuilder();
		Scanner scanner = new Scanner(input);
		int lineNumber = 0;
		returnExists = false;
		while (scanner.hasNextLine()) {
			String oldLine = scanner.nextLine();
			String newLine = processLine(oldLine, ++lineNumber, scanner);
			code.append(newLine);
			code.append("\n");
		}
		scanner.close();
		if (!returnExists) {
			log.warn("No return statement found in " + input);
		}
		generate(output, code);
	}

	// altera linha, se necessario
	private String processLine(String line, int lineNumber, Scanner scanner) {
		StringBuilder newLine = new StringBuilder();
		// linha deve conter instrucao 'whenever'?
		if (wheneverLocationsMap.containsKey(lineNumber)) {
			addWheneverLine(lineNumber, newLine);
		}
		// linha contendo instrucao de retorno
		else if (containsReturn(line)) {
			updateReturnLine(line, lineNumber, scanner, newLine);
			returnExists = true;
		}
		// linha contendo instrucao whenever
		else if (WHENEVER_INSTRUCTION.matcher(line).matches()) {
			updateWheneverLine(line, lineNumber, scanner, newLine);
		}
		else {
			newLine.append(line);
		}
		return newLine.toString();
	}

	// verifica se a linha contem instrucao de retorno
	private boolean containsReturn(String line) {	
		boolean contains = false;
		String lower = line.toLowerCase().trim();
		if (lower.contains("return ") || lower.endsWith("return")) {
			// verifica se a linha esta linha comentada
			int pos = line.indexOf("return");
			int index = line.indexOf("#");
			if (index >= 0 && index < pos) {
				contains = false;
			} else {
				contains = true;
			}
		}
		return contains;
	}
	
	private void addWheneverLine(int lineNumber, StringBuilder newLine) {
		log.debug("Adding whenever statement at line " + lineNumber);
		newLine.append("# ------------- added by rysys preprocessor --------------");
		newLine.append("\n");
		newLine.append(WHENEVER_STATEMENT);
		newLine.append("\n");
		newLine.append("# --------------------------------------------------------");
	}
	
	// altera o retorno adicionando o tipo e o tamanho
	private void updateReturnLine(String line, int lineNumber, Scanner scanner,
			StringBuilder newLine) {
		log.debug("Old return (line=" + lineNumber + "): '" + line + "'");

		// cria o novo retorno
		Return r = Context.getInstance().getReturn(lineNumber);
		if (r == null) {
			throw new ReturnNotFoundException("No return found for line "
					+ lineNumber);
		}

		// cria o novo retorno
		String[] tokens = r.getReturnTokens();
		if (tokens.length == 1 && "".equals(tokens[0].trim())) {
			log.warn("Empty return found at line " + lineNumber + ". No modification done");
			newLine.append(line);
		}
		else {
			for (int i = 0; i < tokens.length; i++) {
				FglRysysType type = Context.getInstance().getRysysType(
						String.valueOf(tokens[i]).trim(), lineNumber);
						
			    // valor do retorno
				newLine.append(tokens[i]);
			    newLine.append(", ");
				
				// tamanho do retorno
				newLine.append(type.getSize());
				newLine.append(", ");
	
				// tipo do retorno
				newLine.append(type.getType());
			    
				if (i < tokens.length-1) {
					newLine.append(", ");
				}
			}
	
			newLine.insert(0, "return ");
	
			// espacos a esquerda
			String spaces = indentation(line);
			newLine.insert(0, spaces);
	
			log.info("Return modified. New return (line=" + lineNumber + "): '"
					+ newLine + "'");
	
			newLine.insert(0, "\n");
			newLine.insert(0, "# ------------ modified by rysys preprocessor ------------");
			newLine.append("\n");
			newLine.append("# --------------------------------------------------------");
	
			// pula linhas posteriores do antigo retorno, pois agora
			// o retorno fica em apenas uma linha
			int total = r.totalLines();
			for (int j = 0; j < total; j++) {
				scanner.nextLine();
			}
		}
	}
	
	private void updateWheneverLine(String line, int lineNumber, Scanner scanner,
			StringBuilder newLine) {
		
		log.debug("Old whenever (line=" + lineNumber + "): '" + line + "'");

		// cria o novo whenever
		Whenever w = Context.getInstance().getWhenever(lineNumber);
		if (w == null) {
			throw new ReturnNotFoundException("No whenever found for line "
					+ lineNumber);
		}
		
		// pula linhas posteriores do antigo whenever, pois agora
		// o whenever fica em apenas uma linha
		int total = w.totalLines();
		for (int j = 0; j < total; j++) {
			scanner.nextLine();
		}

		String whenever = indentation(line) + WHENEVER_STATEMENT;
		
		log.info("Whenever modified. New whenever (line=" + lineNumber + "): '"
				+ whenever + "'");
		
		newLine.append("# ------------ modified by rysys preprocessor ------------");
		newLine.append("\n");
		newLine.append(whenever);
		newLine.append("\n");
		newLine.append("# --------------------------------------------------------");
	}

	// retorna uma string contendo o total de espacos a esquerda
	private String indentation(String line) {
		String result = "";
		for (int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			if (!Character.isSpaceChar(c)) {
				break;
			}
			result += c;
		}
		return result;
	}

	// escreve o novo arquivo em disco
	private void generate(File file, StringBuilder contents)
			throws FileNotFoundException, IOException {

		Writer output = new BufferedWriter(new FileWriter(file));
		try {
			output.write(contents.toString());
		} finally {
			output.close();
		}
	}
}
