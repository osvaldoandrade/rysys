package br.com.codecompany.rysys.cobol.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.codecompany.rysys.api.annotation.GenericRequestPopulator;
import br.com.codecompany.rysys.api.annotation.GenericResponsePopulator;
import br.com.codecompany.rysys.api.annotation.PopulatorHelper;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestCobolFunction {
	
	private PopulatorHelper helper;
	
	@Before
	public void setUp() {
		GenericRequestPopulator request = new GenericRequestPopulator();
		GenericResponsePopulator response = new GenericResponsePopulator();
		helper = new PopulatorHelper(request, response);		
	}
	
	@Test
	public void function() {
		// extrai os valores dos campos
		CobolPojo pojo = new CobolPojo("ANDRE", "ROCHA", 20);
		String fieldsAsString = helper.extractFieldsAsString(pojo);
		
		Assert.assertEquals("ANDRE     ROCHA     20", fieldsAsString);
		
//		// executa
//		Function function = FunctionFactory.getFunction(EisType.COBOL, "algum_nome");
//		function.addParameter(fieldsAsString);		
//		CobolFunctionExecutor executor = new CobolFunctionExecutor();
//		CobolExecutionResult result = (CobolExecutionResult) executor.execute(null, function);
//		
//		// resultado da execucao
//		Result<String> response = result.getResultAt(0);
//		
//		// popula o pojo com o resultado
//		helper.populateFields(pojo, response.getValue());
		
//		Assert.assertEquals("ANDRE", pojo.getNome());
//		Assert.assertEquals("ROCHA", pojo.getSobrenome());
//		Assert.assertEquals(21, pojo.getIdade());
	}

	@Test
	public void testExtraction() {
		StringBuilder message = new StringBuilder();
        Pattern pattern = Pattern.compile(".*\\<function\\>.*\\<name\\>(.+)\\<\\/name\\>.*", Pattern.DOTALL);
        message.append("<rysys><protocolVersion>1</protocolVersion>");
		message.append("<security><sourceHost>cygnus.fnsbr.net</sourceHost>");
		message.append("<cretentials><cretential><name/><value/></cretential>");
		message.append("</cretentials></security>");
		message.append("<adapterType>3</adapterType><commandType>4</commandType>");
		message.append("<function><name>isisff02</name>");
		message.append("<libraryPath>libisisff02.so</libraryPath>");
		message.append("<parameters><parameter><name/><type>4</type>");
		message.append("<value><![CDATA[J01JAVADES   JAVA123   FIDDES    O038FIDELITY       000000000000000 ]]></value>");
		message.append("</parameter></parameters></function></rysys>");
		Matcher matcher = pattern.matcher(message);
		Assert.assertEquals(true, matcher.matches());
		Assert.assertEquals("isisff02", matcher.group(1));
	}
}
