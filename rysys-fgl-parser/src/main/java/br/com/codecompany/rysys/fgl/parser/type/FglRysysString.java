package br.com.codecompany.rysys.fgl.parser.type;


public class FglRysysString implements FglRysysType {

	private int size;
	
	public FglRysysString(int size) {
		this.size = size;
	}
	
	public int getSize() {
		return size;
	}

	public int getType() {
		return FGL_STRING;
	}

}
