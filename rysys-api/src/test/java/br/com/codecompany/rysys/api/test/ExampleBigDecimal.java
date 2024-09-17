package br.com.codecompany.rysys.api.test;

import java.math.BigDecimal;

import br.com.codecompany.rysys.api.annotation.Direction;
import br.com.codecompany.rysys.api.annotation.core.BigDecimalField;
import br.com.codecompany.rysys.api.annotation.core.DataDescriptor;

@DataDescriptor
public class ExampleBigDecimal {
	
	@BigDecimalField(length=10, index=1, precision=2, direction=Direction.FROM_TO_EIS)
	private BigDecimal property;

	public void setProperty(BigDecimal property) {
		this.property = property;
	}

	public BigDecimal getProperty() {
		return property;
	}
}
