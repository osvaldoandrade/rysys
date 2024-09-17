package br.com.codecompany.rysys.api.test.annotation;

import br.com.codecompany.rysys.api.test.ExampleDouble2;
import junit.framework.Assert;

import org.junit.Test;

import br.com.codecompany.rysys.api.test.ExampleDouble;

public class TestDoubleFieldAnnotation extends TestHelper {
	@Test
	public void populateZeroField() {
		String response = "0000000";
		ExampleDouble pojo = new ExampleDouble();
		helper.populateFields(pojo, response);
		Assert.assertEquals(new Double("0.0"), pojo.getProperty());
	}

	@Test
	public void populateNegativeZeroField() {
		String response = "-000000";
		ExampleDouble pojo = new ExampleDouble();
		helper.populateFields(pojo, response);
		Assert.assertEquals(new Double("0.0"), pojo.getProperty());
	}

	@Test
	public void populatePositiveZeroField() {
		String response = "+000000";
		ExampleDouble pojo = new ExampleDouble();
		helper.populateFields(pojo, response);
		Assert.assertEquals(new Double("0.0"), pojo.getProperty());
	}
	
	@Test
	public void populateNegativeIntegerField() {
		String response = "-123400";
		ExampleDouble pojo = new ExampleDouble();
		helper.populateFields(pojo, response);
		Assert.assertEquals(new Double("-1234.00"), pojo.getProperty());
	}
	
	@Test
	public void populatePositiveIntegerField() {
		String response = "+123400";
		ExampleDouble pojo = new ExampleDouble();
		helper.populateFields(pojo, response);
		Assert.assertEquals(new Double("1234.00"), pojo.getProperty());
	}	
	
	@Test
	public void extractNegativeIntegerField() {
		ExampleDouble pojo = new ExampleDouble();
		pojo.setProperty(new Double(-300));
		Assert.assertEquals("-000030000", helper.extractFieldsAsString(pojo));
	}
	
	@Test
	public void extractPositiveIntegerField() {
		ExampleDouble pojo = new ExampleDouble();
		pojo.setProperty(new Double(300));
		Assert.assertEquals("0000030000", helper.extractFieldsAsString(pojo));
	}
	
	@Test
	public void populateNegativeDoubleField() {
		String response = "-123456";
		ExampleDouble pojo = new ExampleDouble();
		helper.populateFields(pojo, response);
		Assert.assertEquals(new Double("-1234.56"), pojo.getProperty());
	}	

	@Test
	public void populatePositiveDoubleField() {
		String response = "123456";
		ExampleDouble pojo = new ExampleDouble();
		helper.populateFields(pojo, response);
		Assert.assertEquals(new Double("1234.56"), pojo.getProperty());
	}
	
	@Test
	public void populatePositiveDoubleFieldWithSign() {
		String response = "+123456";
		ExampleDouble pojo = new ExampleDouble();
		helper.populateFields(pojo, response);
		Assert.assertEquals(new Double("1234.56"), pojo.getProperty());
	}

    @Test
    public void populateDecimalFieldWithPrecisionAndTrailingZero() {
        String response = "0000000300";
        ExampleDouble2 pojo = new ExampleDouble2();
        helper.populateFields(pojo, response);
        Assert.assertEquals(0.03, pojo.getProperty());
    }
}
