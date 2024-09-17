package br.com.codecompany.rysys.fgl.test.annotation.base;


import java.util.Date;

import br.com.codecompany.rysys.api.annotation.Direction;
import br.com.codecompany.rysys.api.annotation.core.DataDescriptor;
import br.com.codecompany.rysys.api.annotation.core.DateField;

@DataDescriptor
public class ClassWithFglDate {
	
	@DateField(index=4, direction=Direction.FROM_TO_EIS)
	private Date property;

	public void setProperty(Date property) {
		this.property = property;
	}

	public Date getProperty() {
		return property;
	}
}
