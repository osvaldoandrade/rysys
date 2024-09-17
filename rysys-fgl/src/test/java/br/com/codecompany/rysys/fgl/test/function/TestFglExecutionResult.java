package br.com.codecompany.rysys.fgl.test.function;

import br.com.codecompany.rysys.fgl.executor.FglExecutionResult;
import org.junit.Assert;
import org.junit.Test;

public class TestFglExecutionResult {

	@Test
	public void multipleResult() {
        StringBuffer message = new StringBuffer();
        message.append("<rysys type=\"2\">");
        message.append("<protocolVersion>1</protocolVersion>");
        message.append("<adapterType>1</adapterType>");
        message.append("<commandType>4</commandType>");
        message.append("<libraryPath>isisf001</libraryPath>");
        message.append("<function>");
        message.append("<name>libisisf001.so</name>");
        message.append("<results>");

		// tipo inteiro
		message.append("<result>");
        message.append("<name></name>");
		message.append("<type>1</type>");
		message.append("<value><![CDATA[123456]]></value>");
        message.append("</result>");
		// tipo float
		message.append("<result>");
        message.append("<name></name>");
		message.append("<type>2</type>");
		message.append("<value><![CDATA[78.99]]></value>");
        message.append("</result>");
		// tipo string
		message.append("<result>");
        message.append("<name></name>");
		message.append("<type>4</type>");
		message.append("<value><![CDATA[ANDRE DANTAS ROCHA]]></value>");
        message.append("</result>");

		message.append("</results>");
        message.append("</function>");
        message.append("</rysys>");

		FglExecutionResult result = new FglExecutionResult(message.toString());
		Assert.assertEquals(3, result.size());
		Assert.assertEquals(new Integer(123456), result.getResultAt(0));
		Assert.assertEquals(new Float(78.99), result.getResultAt(1));
		Assert.assertEquals("ANDRE DANTAS ROCHA", result.getResultAt(2));
	}
}
