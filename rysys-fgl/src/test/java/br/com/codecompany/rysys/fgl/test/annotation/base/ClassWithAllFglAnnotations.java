package br.com.codecompany.rysys.fgl.test.annotation.base;

import br.com.codecompany.rysys.api.annotation.core.DataDescriptor;
import br.com.codecompany.rysys.api.annotation.core.DateField;
import br.com.codecompany.rysys.api.annotation.core.FloatField;
import br.com.codecompany.rysys.api.annotation.core.IntegerField;
import br.com.codecompany.rysys.api.annotation.core.TextField;
import static br.com.codecompany.rysys.api.annotation.Direction.FROM_TO_EIS;

import java.util.Date;


@DataDescriptor
public class ClassWithAllFglAnnotations {
	
	@IntegerField(index=1, direction=FROM_TO_EIS)
	private int intProperty;
	
	@FloatField(index=2, precision=2, direction=FROM_TO_EIS)
	private float floatProperty;
	
	@TextField(index=3, direction=FROM_TO_EIS)
	private String textProperty;
	
	@DateField(index=4, direction=FROM_TO_EIS)
	private Date dateProperty;

	public float getFloatProperty() {
		return floatProperty;
	}

	public void setFloatProperty(float floatProperty) {
		this.floatProperty = floatProperty;
	}

	public int getIntProperty() {
		return intProperty;
	}

	public void setIntProperty(int intProperty) {
		this.intProperty = intProperty;
	}

	public String getTextProperty() {
		return textProperty;
	}

	public void setTextProperty(String textProperty) {
		this.textProperty = textProperty;
	}

	public Date getDateProperty() {
		return dateProperty;
	}

	public void setDateProperty(Date dateProperty) {
		this.dateProperty = dateProperty;
	}
}
