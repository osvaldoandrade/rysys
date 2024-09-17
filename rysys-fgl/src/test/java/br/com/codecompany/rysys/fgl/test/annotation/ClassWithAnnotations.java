package br.com.codecompany.rysys.fgl.test.annotation;

import br.com.codecompany.rysys.api.annotation.Direction;
import br.com.codecompany.rysys.api.annotation.core.FloatField;
import br.com.codecompany.rysys.api.annotation.core.IntegerField;
import br.com.codecompany.rysys.api.annotation.core.TextField;

public class ClassWithAnnotations {


	/*FIXME tirar campo length como obrigatorio!!!!!!
	apagar FGL annotations e so consiredar as anotacoes de texto, inteiro e float
	*/

	// campos enviados
	@IntegerField(index = 1, length=1, direction=Direction.TO_EIS)
	private int outIntegerProperty;

	@TextField(index = 2, length=1, direction=Direction.TO_EIS)
	private String outStringProperty;

	@FloatField(index = 3, length=1, precision=3, direction=Direction.TO_EIS)
	private float outFloatProperty;

	// campos recebidos
	@IntegerField(index = 1, length=1, direction=Direction.FROM_EIS)
	private int inIntegerProperty;

	@TextField(index = 2, length=1, direction=Direction.FROM_EIS)
	private String inStringProperty;

	@FloatField(index = 3, length=1, precision=3, direction=Direction.FROM_EIS)
	private float inFloatProperty;

	public float getInFloatProperty() {
		return inFloatProperty;
	}

	public void setInFloatProperty(float inFloatProperty) {
		this.inFloatProperty = inFloatProperty;
	}

	public int getInIntegerProperty() {
		return inIntegerProperty;
	}

	public void setInIntegerProperty(int inIntegerProperty) {
		this.inIntegerProperty = inIntegerProperty;
	}

	public String getInStringProperty() {
		return inStringProperty;
	}

	public void setInStringProperty(String inStringProperty) {
		this.inStringProperty = inStringProperty;
	}

	public float getOutFloatProperty() {
		return outFloatProperty;
	}

	public void setOutFloatProperty(float outFloatProperty) {
		this.outFloatProperty = outFloatProperty;
	}

	public int getOutIntegerProperty() {
		return outIntegerProperty;
	}

	public void setOutIntegerProperty(int outIntegerProperty) {
		this.outIntegerProperty = outIntegerProperty;
	}

	public String getOutStringProperty() {
		return outStringProperty;
	}

	public void setOutStringProperty(String outStringProperty) {
		this.outStringProperty = outStringProperty;
	}
}
