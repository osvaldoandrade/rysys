package br.com.codecompany.rysys.api.test.annotation;

import java.util.Calendar;

import junit.framework.Assert;

import org.junit.Test;

import br.com.codecompany.rysys.api.test.ExampleDate;

public class TestDateFieldAnnotation extends TestHelper {
	
	@Test
	public void populateDateField() {
		String response = "12.03.2008";
		ExampleDate pojo = new ExampleDate();
		helper.populateFields(pojo, response);
		
		Calendar c1 = Calendar.getInstance();  
		c1.set(2008, 2, 12); // 12/03/2008
		
		Calendar c2 = Calendar.getInstance();
		c2.setTime(pojo.getProperty());
		
		Assert.assertEquals(c1.get(Calendar.DATE), c2.get(Calendar.DATE));
		Assert.assertEquals(c1.get(Calendar.MONTH), c2.get(Calendar.MONTH));
		Assert.assertEquals(c1.get(Calendar.YEAR), c2.get(Calendar.YEAR));
	}
	
	@Test
	public void extractDateField() {		
		Calendar c1 = Calendar.getInstance();  
		c1.set(2008, 2, 12); // 12/03/2008
		
		ExampleDate pojo = new ExampleDate();
		pojo.setProperty(c1.getTime());
		
		Assert.assertEquals("12.03.2008", helper.extractFieldsAsString(pojo));
	}
		
}
