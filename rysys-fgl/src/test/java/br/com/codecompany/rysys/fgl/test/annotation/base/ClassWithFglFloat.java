package br.com.codecompany.rysys.fgl.test.annotation.base;

import br.com.codecompany.rysys.api.annotation.Direction;
import br.com.codecompany.rysys.api.annotation.core.DataDescriptor;
import br.com.codecompany.rysys.api.annotation.core.FloatField;

@DataDescriptor
public class ClassWithFglFloat {
	
	@FloatField(index=2, precision=2, direction=Direction.FROM_TO_EIS)
	private float property;

	public void setProperty(float property) {
		this.property = property;
	}

	public float getProperty() {
		return property;
	}
}
