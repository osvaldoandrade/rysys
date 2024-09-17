package br.com.codecompany.rysys.api.function;

import static br.com.codecompany.rysys.util.Constants.UNNAMED;
import static br.com.codecompany.rysys.util.Constants.UNDEFINED;

public class Parameter {

	private String name = UNNAMED;
	private Object value;
	private int type = UNDEFINED;

	public Parameter(Object value) {
		this.value = value;
	}

	public Parameter(Object value, String name) {
		this.name = name;
		this.value = value;
	}

	public Parameter(String name, int type) {
		this.name = name;
		this.type = type;
	}

	public Parameter(Object value, String name, int type) {
		this.name = name;
		this.value = value;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public Object getValue() {
		return value;
	}

	public int getType() {
		return type;
	}
}
