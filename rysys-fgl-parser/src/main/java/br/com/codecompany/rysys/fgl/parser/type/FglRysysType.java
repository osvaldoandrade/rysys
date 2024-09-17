package br.com.codecompany.rysys.fgl.parser.type;

public interface FglRysysType {
	
	public static final int FGL_INTEGER = 1;
	public static final int FGL_FLOAT = 2;
	public static final int FGL_STRING = 4;
	public static final int FGL_DATE = 5;
	
	public int getType();
	public int getSize();
}
