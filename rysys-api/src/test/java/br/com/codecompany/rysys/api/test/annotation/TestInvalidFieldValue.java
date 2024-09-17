package br.com.codecompany.rysys.api.test.annotation;

import br.com.codecompany.rysys.api.test.ExampleBigDecimal;
import br.com.codecompany.rysys.api.test.ExampleDate;
import br.com.codecompany.rysys.api.test.ExampleInt;
import org.junit.Assert;
import org.junit.Test;

public class TestInvalidFieldValue extends TestHelper {

	@Test
	public void populateInvalidBigDecimalField() {
		String response = "ZYK234G";
		ExampleBigDecimal pojo = new ExampleBigDecimal();
		helper.populateFields(pojo, response);
		Assert.assertEquals(null, pojo.getProperty());
	}

	@Test
	public void populateInvalidDateField() {
		String response = "__/__/____";
		ExampleDate pojo = new ExampleDate();
		helper.populateFields(pojo, response);
		Assert.assertEquals(null, pojo.getProperty());
	}

	@Test
	public void populateInvalidIntField() {
		String response = "**(--)**";
		ExampleInt pojo = new ExampleInt();
		helper.populateFields(pojo, response);
		Assert.assertEquals(0, pojo.getProperty());
	}
}
