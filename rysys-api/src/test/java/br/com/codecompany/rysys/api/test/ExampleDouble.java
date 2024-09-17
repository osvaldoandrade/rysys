package br.com.codecompany.rysys.api.test;

import br.com.codecompany.rysys.api.annotation.Direction;
import br.com.codecompany.rysys.api.annotation.core.DataDescriptor;
import br.com.codecompany.rysys.api.annotation.core.DoubleField;

@DataDescriptor
public class ExampleDouble {
	
	@DoubleField(length=10, index=1, precision=2, direction=Direction.FROM_TO_EIS)
	private double property;

	public void setProperty(double property) {
		this.property = property;
	}

	public double getProperty() {
		return property;
	}
}
