package br.com.codecompany.rysys.api.test.annotation;

import java.math.BigDecimal;

import br.com.codecompany.rysys.api.test.ExampleBigDecimal2;
import junit.framework.Assert;

import org.junit.Test;

import br.com.codecompany.rysys.api.test.ExampleBigDecimal;

public class TestBigDecimalFieldAnnotation extends TestHelper {

	@Test
	public void populateZeroField() {
		String response = "0000000";
		ExampleBigDecimal pojo = new ExampleBigDecimal();
		helper.populateFields(pojo, response);
		Assert.assertEquals(new BigDecimal("0.00"), pojo.getProperty());
	}

	@Test
	public void populateNegativeZeroField() {
		String response = "-000000";
		ExampleBigDecimal pojo = new ExampleBigDecimal();
		helper.populateFields(pojo, response);
		Assert.assertEquals(new BigDecimal("0.00"), pojo.getProperty());
	}

	@Test
	public void populatePositiveZeroField() {
		String response = "+000000";
		ExampleBigDecimal pojo = new ExampleBigDecimal();
		helper.populateFields(pojo, response);
		Assert.assertEquals(new BigDecimal("0.00"), pojo.getProperty());
	}
	
	@Test
	public void populateNegativeIntegerField() {
		String response = "-123400";
		ExampleBigDecimal pojo = new ExampleBigDecimal();
		helper.populateFields(pojo, response);
		Assert.assertEquals(new BigDecimal("-1234.00"), pojo.getProperty());
	}
	
	@Test
	public void populatePositiveIntegerField() {
		String response = "+123400";
		ExampleBigDecimal pojo = new ExampleBigDecimal();
		helper.populateFields(pojo, response);
		Assert.assertEquals(new BigDecimal("1234.00"), pojo.getProperty());
	}
	
	@Test
	public void extractNegativeIntegerField() {
		ExampleBigDecimal pojo = new ExampleBigDecimal();
		pojo.setProperty(new BigDecimal(-300));
		Assert.assertEquals("-000030000", helper.extractFieldsAsString(pojo));
	}
	
	@Test
	public void extractPositiveIntegerField() {
		ExampleBigDecimal pojo = new ExampleBigDecimal();
		pojo.setProperty(new BigDecimal(300));
		Assert.assertEquals("0000030000", helper.extractFieldsAsString(pojo));
	}
	
	@Test
	public void populateNegativeDecimalField() {
		String response = "-123456";
		ExampleBigDecimal pojo = new ExampleBigDecimal();
		helper.populateFields(pojo, response);
		Assert.assertEquals(new BigDecimal("-1234.56"), pojo.getProperty());
	}	

	@Test
	public void populatePositiveDecimalField() {
		String response = "123456";
		ExampleBigDecimal pojo = new ExampleBigDecimal();
		helper.populateFields(pojo, response);
		Assert.assertEquals(new BigDecimal("1234.56"), pojo.getProperty());
	}
	
	@Test
	public void populatePositiveDecimalFieldWithSign() {
		String response = "+123456";
		ExampleBigDecimal pojo = new ExampleBigDecimal();
		helper.populateFields(pojo, response);
		Assert.assertEquals(new BigDecimal("1234.56"), pojo.getProperty());
	}

	@Test
	public void extractNegativeDecimalField() {
		ExampleBigDecimal pojo = new ExampleBigDecimal();
		pojo.setProperty(new BigDecimal(-300.45));
		Assert.assertEquals("-000030045", helper.extractFieldsAsString(pojo));
	}

	@Test
	public void extractPositiveDecimalField() {
		ExampleBigDecimal pojo = new ExampleBigDecimal();
		pojo.setProperty(new BigDecimal(300.45));
		Assert.assertEquals("0000030045", helper.extractFieldsAsString(pojo));
	}

    @Test
    public void populateDecimalFieldWithPrecisionAndTrailingZero() {
        String response = "0000000300";
        ExampleBigDecimal2 pojo = new ExampleBigDecimal2();
        helper.populateFields(pojo, response);
        Assert.assertEquals(new BigDecimal("0.0300"), pojo.getProperty());
    }
}
