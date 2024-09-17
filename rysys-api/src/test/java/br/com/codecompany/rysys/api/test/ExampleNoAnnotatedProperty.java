package br.com.codecompany.rysys.api.test;

import br.com.codecompany.rysys.api.annotation.core.DataDescriptor;

@DataDescriptor
public class ExampleNoAnnotatedProperty {
	
	private String property = "text";
	
	public String getProperty() {
		return property;
	}
	
	public void setProperty(String property) {
		this.property = property;
	}
}
