package br.com.codecompany.rysys.api.test.annotation;

import junit.framework.Assert;

import org.junit.Test;

import br.com.codecompany.rysys.api.test.ExampleFloat;

public class TestFloatFieldAnnotation extends TestHelper {

	@Test
	public void populateZeroField() {
		String response = "0000000";
		ExampleFloat pojo = new ExampleFloat();
		helper.populateFields(pojo, response);
		Assert.assertEquals(new Float("0.0"), pojo.getProperty());
	}

	@Test
	public void populateNegativeZeroField() {
		String response = "-000000";
		ExampleFloat pojo = new ExampleFloat();
		helper.populateFields(pojo, response);
		Assert.assertEquals(new Float("0.0"), pojo.getProperty());
	}

	@Test
	public void populatePositiveZeroField() {
		String response = "+000000";
		ExampleFloat pojo = new ExampleFloat();
		helper.populateFields(pojo, response);
		Assert.assertEquals(new Float("0.0"), pojo.getProperty());
	}
	
	@Test
	public void populateNegativeIntegerField() {
		String response = "-123400";
		ExampleFloat pojo = new ExampleFloat();
		helper.populateFields(pojo, response);
		Assert.assertEquals(new Float("-1234.00"), pojo.getProperty());
	}
	
	@Test
	public void populatePositiveIntegerField() {
		String response = "+123400";
		ExampleFloat pojo = new ExampleFloat();
		helper.populateFields(pojo, response);
		Assert.assertEquals(new Float("1234.00"), pojo.getProperty());
	}	
	
	@Test
	public void extractNegativeIntegerField() {
		ExampleFloat pojo = new ExampleFloat();
		pojo.setProperty(new Float(-300));
		Assert.assertEquals("-000030000", helper.extractFieldsAsString(pojo));
	}
	
	@Test
	public void extractPositiveIntegerField() {
		ExampleFloat pojo = new ExampleFloat();
		pojo.setProperty(new Float(300));
		Assert.assertEquals("0000030000", helper.extractFieldsAsString(pojo));
	}
	
	@Test
	public void populateNegativeFloatField() {
		String response = "-123456";
		ExampleFloat pojo = new ExampleFloat();
		helper.populateFields(pojo, response);
		Assert.assertEquals(new Float("-1234.56"), pojo.getProperty());
	}	

	@Test
	public void populatePositiveFloatField() {
		String response = "123456";
		ExampleFloat pojo = new ExampleFloat();
		helper.populateFields(pojo, response);
		Assert.assertEquals(new Float("1234.56"), pojo.getProperty());
	}
	
	@Test
	public void populatePositiveFloatFieldWithSign() {
		String response = "+123456";
		ExampleFloat pojo = new ExampleFloat();
		helper.populateFields(pojo, response);
		Assert.assertEquals(new Float("1234.56"), pojo.getProperty());
	}	
}
