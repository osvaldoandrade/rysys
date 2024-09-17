package br.com.codecompany.rysys.api.test;

import br.com.codecompany.rysys.api.annotation.Direction;
import br.com.codecompany.rysys.api.annotation.core.DataDescriptor;
import br.com.codecompany.rysys.api.annotation.core.IntegerField;

@DataDescriptor
public class ExampleInt {

	@IntegerField(length=7, index=1, direction=Direction.FROM_TO_EIS)
	private int property;

	public void setProperty(int property) {
		this.property = property;
	}

	public int getProperty() {
		return property;
	}
}
