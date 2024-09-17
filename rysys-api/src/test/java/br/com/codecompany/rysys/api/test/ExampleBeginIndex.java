package br.com.codecompany.rysys.api.test;

import br.com.codecompany.rysys.api.annotation.Direction;
import br.com.codecompany.rysys.api.annotation.core.CollectionField;
import br.com.codecompany.rysys.api.annotation.core.DataDescriptor;
import br.com.codecompany.rysys.api.annotation.core.FloatField;
import java.util.ArrayList;
import java.util.List;

@DataDescriptor
public class ExampleBeginIndex {

	@CollectionField(index = 1,
	                 elementType = String.class,
	                 direction = Direction.FROM_TO_EIS,
	                 totalBeginIndex = -30, // sera ignorado
	                 totalLength = 1,
	                 elementOffset = 6
	)
	private List<String> list = new ArrayList<String>();

	@FloatField(index = 2,
	            length = 3,
				precision = 0,
				beginIndex = -30, // sera ignorado
				direction = Direction.FROM_TO_EIS)
	private float floatProperty;
	
	public List<String> getList() {
		return list;
	}

	public float getFloatProperty() {
		return floatProperty;
	}

	public void setFloatProperty(float floatProperty) {
		this.floatProperty = floatProperty;
	}
}
