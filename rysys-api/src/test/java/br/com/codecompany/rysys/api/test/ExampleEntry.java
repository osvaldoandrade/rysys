package br.com.codecompany.rysys.api.test;

import br.com.codecompany.rysys.api.annotation.Direction;
import br.com.codecompany.rysys.api.annotation.core.DataDescriptor;
import br.com.codecompany.rysys.api.annotation.core.IntegerField;
import br.com.codecompany.rysys.api.annotation.core.TextField;

@DataDescriptor
public class ExampleEntry {

	@IntegerField(index = 1, 
			      length = 1, 
			      direction = Direction.FROM_TO_EIS)
	private int value;

	@TextField(index = 2, 
			   beginIndex = 1, 
			   length = 9, 
			   direction = Direction.FROM_TO_EIS)
	private String name;

	public String getName() {
		return name;
	}

	public int getValue() {
		return value;
	}

	public ExampleEntry() {

	}

	public ExampleEntry(String name, int value) {
		this.name = name;
		this.value = value;
	}

	@Override
	public String toString() {
		return value + ":" + name;
	}
}
