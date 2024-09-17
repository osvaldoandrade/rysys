package br.com.codecompany.rysys.fgl.test.annotation;

import junit.framework.Assert;

import org.junit.Test;

import br.com.codecompany.rysys.fgl.test.annotation.base.ClassWithFglText;

public class TestFglTextAnnotation extends FglTestHelper {
	
	@Override
	protected String results() {
		StringBuffer results = new StringBuffer();

		// tipo string
		results.append("<result>");
        results.append("<name></name>");
		results.append("<type>4</type>");
		results.append("<value><![CDATA[ANDRE DANTAS ROCHA]]></value>");
        results.append("</result>");

		return results.toString();
	}

	@Test
	public void populateTextField() {
		ClassWithFglText pojo = new ClassWithFglText();
		helper.populateFields(pojo, result);
		Assert.assertEquals("ANDRE DANTAS ROCHA", pojo.getProperty());
	}
	
	@Test
	public void extractTextField() {
		ClassWithFglText pojo = new ClassWithFglText();
		pojo.setProperty("ANDRE");
		Assert.assertEquals("ANDRE", helper.extractFieldsAsList(pojo).get(0));
	}
}
