package br.com.codecompany.rysys.api.test;

import br.com.codecompany.rysys.api.annotation.Direction;
import br.com.codecompany.rysys.api.annotation.core.DataDescriptor;
import br.com.codecompany.rysys.api.annotation.core.DoubleField;

@DataDescriptor
public class ExampleDouble2 {
	
	@DoubleField(index = 1, length = 10, precision = 4, direction = Direction.FROM_EIS)
	private double property;

	public void setProperty(double property) {
		this.property = property;
	}

	public double getProperty() {
		return property;
	}
}
