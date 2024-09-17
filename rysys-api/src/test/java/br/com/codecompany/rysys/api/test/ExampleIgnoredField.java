package br.com.codecompany.rysys.api.test;

import br.com.codecompany.rysys.api.annotation.Direction;
import br.com.codecompany.rysys.api.annotation.core.DataDescriptor;
import br.com.codecompany.rysys.api.annotation.core.IntegerField;

@DataDescriptor
public class ExampleIgnoredField {
	
	@IntegerField(length=7, index=1, direction=Direction.FROM_TO_EIS)
	private int property1;

	@IntegerField(length=7, beginIndex=7, index=2, direction=Direction.FROM_TO_EIS)	
	private int property2;

	public void setProperty1(int property) {
		this.property1 = property;
	}

	public int getProperty1() {
		return property1;
	}

	public void setProperty2(int propertyToIgnore) {
		this.property2 = propertyToIgnore;
	}

	public int getProperty2() {
		return property2;
	}
}
