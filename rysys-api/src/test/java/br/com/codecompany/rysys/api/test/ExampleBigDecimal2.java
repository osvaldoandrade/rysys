package br.com.codecompany.rysys.api.test;

import br.com.codecompany.rysys.api.annotation.Direction;
import br.com.codecompany.rysys.api.annotation.core.BigDecimalField;
import br.com.codecompany.rysys.api.annotation.core.DataDescriptor;

import java.math.BigDecimal;

@DataDescriptor
public class ExampleBigDecimal2 {

    @BigDecimalField(index = 1, length = 10, precision = 4, direction = Direction.FROM_EIS)
	private BigDecimal property;

	public void setProperty(BigDecimal property) {
		this.property = property;
	}

	public BigDecimal getProperty() {
		return property;
	}
}
