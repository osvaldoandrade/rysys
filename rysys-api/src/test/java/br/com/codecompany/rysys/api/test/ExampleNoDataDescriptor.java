package br.com.codecompany.rysys.api.test;

import br.com.codecompany.rysys.api.annotation.core.TextField;

public class ExampleNoDataDescriptor {
	
	@TextField(length=10)
	private String property = "text";
	
	public String getProperty() {
		return property;
	}
	
	public void setProperty(String property) {
		this.property = property;
	}
}
