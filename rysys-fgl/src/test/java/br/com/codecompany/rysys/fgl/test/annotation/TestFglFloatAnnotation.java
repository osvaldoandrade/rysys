package br.com.codecompany.rysys.fgl.test.annotation;

import junit.framework.Assert;

import org.junit.Test;

import br.com.codecompany.rysys.fgl.test.annotation.base.ClassWithFglFloat;

public class TestFglFloatAnnotation extends FglTestHelper {

	@Override
	protected String results() {
		StringBuffer results = new StringBuffer();

		// tipo float
		results.append("<result>");
        results.append("<name></name>");
		results.append("<type>2</type>");
		results.append("<value><![CDATA[34.89]]></value>");
        results.append("</result>");

		return results.toString();
	}

	@Test
	public void populateFloatField() {
		ClassWithFglFloat pojo = new ClassWithFglFloat();
		helper.populateFields(pojo, result);
		Assert.assertEquals(34.89f, pojo.getProperty());
	}
	
	@Test
	public void extractFloatField() {
		ClassWithFglFloat pojo = new ClassWithFglFloat();
		pojo.setProperty(-300.56f);
		Assert.assertEquals(-300.56F, helper.extractFieldsAsList(pojo).get(0));
	}
}
