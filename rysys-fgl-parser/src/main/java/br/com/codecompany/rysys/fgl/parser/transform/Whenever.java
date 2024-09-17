package br.com.codecompany.rysys.fgl.parser.transform;

import java.util.List;

import antlr.Token;

public class Whenever extends Return {

	public Whenever(List<Token> wheneverTokenMembers) {
		super(wheneverTokenMembers);
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(super.toString());
		result.append(" {lines=");
		result.append(getStartLine());
		result.append("-");
		result.append(getEndLine());
		result.append("}");
		return result.toString();
	}
}
