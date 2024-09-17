package br.com.codecompany.rysys.api.test;

import br.com.codecompany.rysys.api.annotation.Direction;
import br.com.codecompany.rysys.api.annotation.core.DataDescriptor;
import br.com.codecompany.rysys.api.annotation.core.IntegerField;

@DataDescriptor
public class ExampleInteger {

	@IntegerField(length=7, index=1, direction=Direction.FROM_TO_EIS)
	private Integer property;

	public void setProperty(Integer property) {
		this.property = property;
	}

	public Integer getProperty() {
		return property;
	}
}
