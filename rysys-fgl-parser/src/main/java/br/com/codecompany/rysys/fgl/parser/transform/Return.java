package br.com.codecompany.rysys.fgl.parser.transform;

import java.util.ArrayList;
import java.util.List;

import antlr.Token;

public class Return {
	private List<Token> returnTokenMembers = new ArrayList<Token>();

	public Return(List<Token> returnTokenMembers) {
		this.returnTokenMembers = returnTokenMembers;
	}
	
	public int getStartLine() {
		return returnTokenMembers.get(0).getLine();
	}
	
	public int getEndLine() {
		return returnTokenMembers.get(returnTokenMembers.size()-1).getLine();
	}
	
	public int totalLines() {
		return getEndLine() - getStartLine();
	}
	
	public String[] getReturnTokens() {
		return joinTokens().split(",");
	}
	
	public String joinTokens() {
		StringBuilder result = new StringBuilder();
		for (int i = 1; i < returnTokenMembers.size(); i++) {
			result.append(returnTokenMembers.get(i).getText());
		}
		return result.toString();
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(returnTokenMembers.get(0).getText());
		result.append(" ");
		result.append(joinTokens());
		return result.toString();
	}
}
