package br.com.codecompany.rysys.fgl.test.annotation;

import junit.framework.Assert;

import org.junit.Test;

import br.com.codecompany.rysys.fgl.test.annotation.base.ClassWithFglInteger;

public class TestFglIntegerAnnotation extends FglTestHelper {

	@Override
	protected String results() {
		StringBuffer results = new StringBuffer();

		// tipo inteiro
		results.append("<result>");
        results.append("<name></name>");
		results.append("<type>1</type>");
		results.append("<value><![CDATA[-1234]]></value>");
        results.append("</result>");

		return results.toString();
	}

	@Test
	public void populateIntegerField() {
		ClassWithFglInteger pojo = new ClassWithFglInteger();
		helper.populateFields(pojo, result);
		Assert.assertEquals(-1234, pojo.getProperty());
	}
	
	@Test
	public void extractIntegerField() {
		ClassWithFglInteger pojo = new ClassWithFglInteger();
		pojo.setProperty(-300);
		Assert.assertEquals(-300, helper.extractFieldsAsList(pojo).get(0));
	}
}
