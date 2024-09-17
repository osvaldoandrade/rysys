package br.com.codecompany.rysys.api.test.annotation;

import br.com.codecompany.rysys.api.test.ExampleInt;
import org.junit.Assert;
import org.junit.Test;

public class TestIntFieldAnnotation extends TestHelper {

	@Test
	public void populateZeroField() {
		String response = "00000";
		ExampleInt pojo = new ExampleInt();
		helper.populateFields(pojo, response);
		Assert.assertEquals(0, pojo.getProperty());
	}

	@Test
	public void populateNegativeZeroField() {
		String response = "-0000";
		ExampleInt pojo = new ExampleInt();
		helper.populateFields(pojo, response);
		Assert.assertEquals(0, pojo.getProperty());
	}

	@Test
	public void populatePositiveZeroField() {
		String response = "+0000";
		ExampleInt pojo = new ExampleInt();
		helper.populateFields(pojo, response);
		Assert.assertEquals(0, pojo.getProperty());
	}

	@Test
	public void populateNegativeField() {
		String response = "-1234";
		ExampleInt pojo = new ExampleInt();
		helper.populateFields(pojo, response);
		Assert.assertEquals(-1234, pojo.getProperty());
	}

	@Test
	public void populatePositiveField() {
		String response = "1234";
		ExampleInt pojo = new ExampleInt();
		helper.populateFields(pojo, response);
		Assert.assertEquals(1234, pojo.getProperty());
	}

	@Test
	public void populatePositiveFieldWithSign() {
		String response = "+1234";
		ExampleInt pojo = new ExampleInt();
		helper.populateFields(pojo, response);
		Assert.assertEquals(1234, pojo.getProperty());
	}

	@Test
	public void extractNegativeField() {
		ExampleInt pojo = new ExampleInt();
		pojo.setProperty(-300);
		Assert.assertEquals("-000300", helper.extractFieldsAsString(pojo));
	}

	@Test
	public void extractPositiveField() {
		ExampleInt pojo = new ExampleInt();
		pojo.setProperty(300);
		Assert.assertEquals("0000300", helper.extractFieldsAsString(pojo));
	}
}
