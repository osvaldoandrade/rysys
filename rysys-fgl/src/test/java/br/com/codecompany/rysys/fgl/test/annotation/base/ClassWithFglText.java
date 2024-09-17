package br.com.codecompany.rysys.fgl.test.annotation.base;

import br.com.codecompany.rysys.api.annotation.Direction;
import br.com.codecompany.rysys.api.annotation.core.DataDescriptor;
import br.com.codecompany.rysys.api.annotation.core.TextField;

@DataDescriptor
public class ClassWithFglText {
	
	@TextField(index=3, direction=Direction.FROM_TO_EIS)
	private String property;

	public void setProperty(String property) {
		this.property = property;
	}

	public String getProperty() {
		return property;
	}
}
