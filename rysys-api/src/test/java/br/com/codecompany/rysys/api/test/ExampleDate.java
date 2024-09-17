package br.com.codecompany.rysys.api.test;

import java.util.Date;

import br.com.codecompany.rysys.api.annotation.Direction;
import br.com.codecompany.rysys.api.annotation.core.DataDescriptor;
import br.com.codecompany.rysys.api.annotation.core.DateField;

@DataDescriptor
public class ExampleDate {
	
	@DateField(length=10, index=1, direction=Direction.FROM_TO_EIS)
	private Date property;

	public void setProperty(Date property) {
		this.property = property;
	}

	public Date getProperty() {
		return property;
	}
}
