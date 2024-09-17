package br.com.codecompany.rysys.fgl.parser.transform;

import java.util.ArrayList;
import java.util.List;

import br.com.codecompany.rysys.fgl.parser.FGLTokenTypes;

import antlr.Token;

@SuppressWarnings("unused")
public class Variable {
	
	private String name;
	private String type;
	
	private int identTokenStartLine = 0;
	private int identTokenColStart = 0;
	private int identTokenColEnd = 0;
	private int typeTokenLine = 0;
	private int typeTokenColStart = 0;
	private int typeTokenColEnd = 0;
	private List<Token> identTokenMembers = new ArrayList<Token>();
	private List<Token> typeTokenMembers = new ArrayList<Token>();
	private int typeTokenEndLine = 0;
	
	public Variable(List<Token> identTokenMembers, List<Token> typeTokenMembers) {
		this.identTokenMembers = identTokenMembers;
		this.typeTokenMembers = typeTokenMembers;
		if (identTokenMembers.size() > 0 && typeTokenMembers.size() > 0) {
			// linha e colunas do identificador
			identTokenStartLine = identTokenMembers.get(0).getLine();
			identTokenColStart = identTokenMembers.get(0).getColumn();
			identTokenColEnd = identTokenMembers.get(identTokenMembers.size()-1).getColumn();
			// linha e colunas do tipo
			typeTokenLine = typeTokenMembers.get(0).getLine();
			typeTokenColStart = typeTokenMembers.get(0).getColumn();
			typeTokenColEnd = typeTokenMembers.get(typeTokenMembers.size()-1).getColumn();
			// ultima linha da declaracao
			typeTokenEndLine = typeTokenMembers.get(typeTokenMembers.size()-1).getLine();
		}
	}

	public int getStartLine() {
		return identTokenStartLine;
	}

	public int getEndLine() {
		return typeTokenEndLine;
	}	
	
	public String getName() {
		if (name == null || "".equals(name)) {
			name = "";
			for (Token token : identTokenMembers) {
				name += token.getText();
			}
		}
		return name;
	}
	
	public String getType() {
		if (type == null || "".equals(type)) {
			type = "";
			for (Token token : typeTokenMembers) {
				String text = token.getText();
				if (token.getType() == FGLTokenTypes.OF) {
					text = " " + text + " ";
				}
				type += text;
			}
			if (type.startsWith("record")) {
				type = "record";
			}
			else if (type.startsWith("like")) {
				type = "like";
			}
		}
		return type;		
	}
	
	@Override
	public String toString() {
		return getName() + ":" + getType() + 
		" {lines=" + identTokenStartLine + "-" + typeTokenEndLine + ",cols=" + 
		identTokenColStart + "-" + typeTokenColEnd + "}";
	}
}
