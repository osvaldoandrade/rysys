package br.com.codecompany.rysys.api.test.annotation;

import junit.framework.Assert;

import org.junit.Test;

import br.com.codecompany.rysys.api.test.ExampleIgnoredField;

public class TestFieldIgnoring extends TestHelper {

	@Test
	public void populateAllFields() {
		String response = "00012340005678";
		ExampleIgnoredField pojo = new ExampleIgnoredField();
		helper.populateFields(pojo, response);
		Assert.assertEquals(1234, pojo.getProperty1());
		Assert.assertEquals(5678, pojo.getProperty2());
	}
	
	@Test
	public void populateIgnoringOneField() {
		String response = "00012340005678";
		ExampleIgnoredField pojo = new ExampleIgnoredField();
		helper.setFieldsToIgnore("property2");
		helper.populateFields(pojo, response);
		Assert.assertEquals(1234, pojo.getProperty1());
		Assert.assertEquals(0, pojo.getProperty2());
	}
	
	@Test
	public void populateIgnoringAllFields() {
		String response = "00012340005678";
		ExampleIgnoredField pojo = new ExampleIgnoredField();
		helper.setFieldsToIgnore("property1", "property2");
		helper.populateFields(pojo, response);
		Assert.assertEquals(0, pojo.getProperty1());
		Assert.assertEquals(0, pojo.getProperty2());
	}	
	
	@Test
	public void extractAllFields() {
		ExampleIgnoredField pojo = new ExampleIgnoredField();
		pojo.setProperty1(300);
		pojo.setProperty2(301);
		Assert.assertEquals("00003000000301", helper.extractFieldsAsString(pojo));
	}
	
	@Test
	public void extractIgnoringOneField() {
		ExampleIgnoredField pojo = new ExampleIgnoredField();
		pojo.setProperty1(300);
		pojo.setProperty2(301);
		helper.setFieldsToIgnore("property2");
		Assert.assertEquals("0000300", helper.extractFieldsAsString(pojo));
	}
	
	@Test
	public void extractIgnoringAllFields() {
		ExampleIgnoredField pojo = new ExampleIgnoredField();
		pojo.setProperty1(300);
		pojo.setProperty2(301);
		helper.setFieldsToIgnore("property1", "property2");
		Assert.assertEquals("", helper.extractFieldsAsString(pojo));
	}	
}
