package br.com.codecompany.rysys.api.test.annotation;

import br.com.codecompany.rysys.api.test.ExampleNullFields;
import org.junit.Assert;
import org.junit.Test;

public class TestIgnoreNullFields extends TestHelper {

	@Test
	public void extractIgnoringNullField() {
		ExampleNullFields pojo = new ExampleNullFields();
		helper.setIgnoreNullFields(true);
		Assert.assertEquals("", helper.extractFieldsAsString(pojo));
	}

    @Test
    public void extractUsingNullField() {
		ExampleNullFields pojo = new ExampleNullFields();
        helper.setIgnoreNullFields(false);
		String result = "0000000000" + // dateProperty
				        "        "   + // stringProperty
						""           + // collectionProperty
						"00000"      + // doubleProperty
						"0000000"    + // integerProperty
						"000000";      // bigDecimalProperty
		Assert.assertEquals(result, helper.extractFieldsAsString(pojo));
    }

}
