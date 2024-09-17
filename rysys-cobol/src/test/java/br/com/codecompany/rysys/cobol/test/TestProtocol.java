package br.com.codecompany.rysys.cobol.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.codecompany.rysys.api.function.EisType;
import br.com.codecompany.rysys.api.function.FunctionFactory;
import br.com.codecompany.rysys.cobol.executor.CobolExecutionResult;
import br.com.codecompany.rysys.cobol.executor.CobolProtocol;
import br.com.codecompany.rysys.cobol.function.CobolFunction;
import br.com.codecompany.rysys.util.SocketUtils;

public class TestProtocol {

	private CobolProtocol protocol;
	private CobolFunction function;

	@Before
	public void setUp() {
		protocol = new CobolProtocol();
		function = (CobolFunction) FunctionFactory.getFunction(
				EisType.COBOL, "FUNCTION_NAME");
	}

	@Test
	public void functionOneParameter() {
		function.addParameterValue("ANDRE");
		String xml = (String) protocol.extractCommand(function);
		Assert.assertEquals(createRequest("ANDRE"), xml);
	}

	@Test
	public void functionManyParameters() {
		function.addParameterValue("ANDRE");
		function.addParameterValue("DANTAS");
		function.addParameterValue("ROCHA");
		String xml = (String) protocol.extractCommand(function);
		Assert.assertEquals(createRequest("ANDREDANTASROCHA"), xml);
	}

	@Test
	public void functionMultiParameters() {
		function.setParameters("ANDRE");
		function.setParameters("DANTAS");
		String xml = (String) protocol.extractCommand(function);
		Assert.assertEquals(createRequest("ANDREDANTAS"), xml);
	}

	@Test
	public void successResult() {
		StringBuilder response = new StringBuilder();
		response.append("<rysys>");
        response.append("<function>");
		response.append("<results>");
		response.append("<result>");
		response.append("<name/>");
		response.append("<value>");
		response.append("ANDRE DANTAS ROCHA");
		response.append("</value>");
		response.append("</result>");
		response.append("</results>");
        response.append("</function>");
		response.append("</rysys>");

		CobolExecutionResult result = protocol.extractResult(response);
		Assert.assertEquals("ANDRE DANTAS ROCHA", result.getResultAt(0));
	}

	private String createRequest(String value) {
		StringBuilder request = new StringBuilder();
		request.append("<rysys>");
		request.append("<protocolVersion>1</protocolVersion>");
		request.append("<security>");
		request.append("<sourceHost>" + SocketUtils.getHostName() + "</sourceHost>");
		request.append("<cretentials><cretential><name/><value/></cretential></cretentials>");
		request.append("</security>");
		request.append("<adapterType>3</adapterType>");
		request.append("<commandType>4</commandType>");
		request.append("<function>");
		request.append("<name>FUNCTION_NAME</name>");
		request.append("<libraryPath>./</libraryPath>");
		request.append("<parameters><parameter><name/><type>4</type>");
		request.append("<value><![CDATA[" + value + "]]></value>");
		request.append("</parameter></parameters>");
		request.append("</function>");
		request.append("</rysys>");

		return request.toString();
	}
}
