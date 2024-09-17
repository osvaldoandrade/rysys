package br.com.codecompany.rysys.api.test.annotation;

import junit.framework.Assert;

import org.junit.Test;

import br.com.codecompany.rysys.api.test.ExampleInteger;

public class TestIntegerFieldAnnotation extends TestHelper {

	@Test
	public void populateZeroField() {
		String response = "0000000";
		ExampleInteger pojo = new ExampleInteger();
		helper.populateFields(pojo, response);
		Assert.assertEquals(new Integer("0"), pojo.getProperty());
	}

	@Test
	public void populateNegativeZeroField() {
		String response = "-000000";
		ExampleInteger pojo = new ExampleInteger();
		helper.populateFields(pojo, response);
		Assert.assertEquals(new Integer("0"), pojo.getProperty());
	}

	@Test
	public void populatePositiveZeroField() {
		String response = "+000000";
		ExampleInteger pojo = new ExampleInteger();
		helper.populateFields(pojo, response);
		Assert.assertEquals(new Integer("0"), pojo.getProperty());
	}

	@Test
	public void populateNegativeField() {
		String response = "-1234";
		ExampleInteger pojo = new ExampleInteger();
		helper.populateFields(pojo, response);
		Assert.assertEquals(new Integer(-1234), pojo.getProperty());
	}
		
	@Test
	public void populatePositiveField() {
		String response = "1234";
		ExampleInteger pojo = new ExampleInteger();
		helper.populateFields(pojo, response);
		Assert.assertEquals(new Integer(1234), pojo.getProperty());
	}
	
	@Test
	public void populatePositiveFieldWithSign() {
		String response = "+1234";
		ExampleInteger pojo = new ExampleInteger();
		helper.populateFields(pojo, response);
		Assert.assertEquals(new Integer(1234), pojo.getProperty());
	}	
	
	@Test
	public void extractNegativeField() {
		ExampleInteger pojo = new ExampleInteger();
		pojo.setProperty(-300);
		Assert.assertEquals("-000300", helper.extractFieldsAsString(pojo));
	}
	
	@Test
	public void extractPositiveField() {
		ExampleInteger pojo = new ExampleInteger();
		pojo.setProperty(300);
		Assert.assertEquals("0000300", helper.extractFieldsAsString(pojo));
	}			
}
