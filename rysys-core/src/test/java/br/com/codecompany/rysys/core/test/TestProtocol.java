package br.com.codecompany.rysys.core.test;

import br.com.codecompany.rysys.core.driver.MessageExecutionException;
import br.com.codecompany.rysys.core.driver.SshAdapter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Assert;
import org.junit.Test;

public class TestProtocol {

	private MyProtocol protocol = new MyProtocol();

	@Test
	public void successfulReturn() {
		StringBuffer message = 
				new StringBuffer("<rysys type=\"2\">AAAA</rysys>");
		boolean success = protocol.endOfCommand(message);
		Assert.assertTrue(success);
		Assert.assertEquals("<rysys type=\"2\">AAAA</rysys>",
				protocol.successReturn());
	}

    @Test
    public void successfulReturn2() {
        StringBuffer message = new StringBuffer();
        message.append("<rysys type=\"2\">");
        message.append("<protocolVersion>1</protocolVersion>");
        message.append("<adapterType>3</adapterType>");
        message.append("<commandType>4</commandType>");
        message.append("<libraryPath>isisf001</libraryPath>");
        message.append("<function>");
        message.append("<name>libisisf001.so</name>");
        message.append("<results><result>");
        message.append("<name></name><type></type><value>00100000000</value>");
        message.append("</result></results>");
        message.append("</function>");
        message.append("</rysys>");
		boolean success = protocol.endOfCommand(message);
		Assert.assertTrue(success);
    }

	@Test
	public void multipleSuccessfulReturn() {
		StringBuffer message = new StringBuffer();
		message.append("<rysys type=\"2\">AAAA</rysys>");
		message.append("<rysys type=\"2\">BBBB</rysys>");
		message.append("<rysys type=\"2\">CCCC</rysys>");
		boolean success = protocol.endOfCommand(message);
		Assert.assertTrue(success);
		Assert.assertEquals("<rysys type=\"2\">CCCC</rysys>",
				protocol.successReturn());
	}

	@Test
	public void erroneousReturn() {
		StringBuffer message = new StringBuffer();
		message.append("<rysys type=\"2\">AAAA");
		message.append("<error>");
		message.append("<code>100</code>");
		message.append("<description>A description</description>");
		message.append("</error>");
		message.append("</rysys>");

		try {
			protocol.endOfCommand(message);
			Assert.fail("Exception not thrown");
		} catch (MessageExecutionException e) {
			String errorMessage = e.getMessage();
			Assert.assertEquals("Error executing message: A description (100)",
					errorMessage);
		}
	}

    @Test
    public void erroneousReturn2() {
        StringBuffer message = new StringBuffer();
        message.append("<rysys type=\"2\">");
        message.append("<protocolVersion>1</protocolVersion>");
        message.append("<error>");
        message.append("<code>7</code>");
        message.append("<description>The command type is not valid;</description>");
        message.append("</error></rysys>");

		try {
			protocol.endOfCommand(message);
			Assert.fail("Exception not thrown");
		} catch (MessageExecutionException e) {
			String errorMessage = e.getMessage();
			Assert.assertEquals("Error executing message: The command type is not valid; (7)",
					errorMessage);
		}
    }

	private class MyProtocol extends SshAdapter {

		public boolean endOfCommand(StringBuffer buffer) {
			return isEndOfCommand(buffer);
		}

		public String successReturn() {
			return successReturn;
		}

		public Pattern errorPattern() {
			return ERROR_PATTERN;
		}

		public Pattern returnPattern() {
			return RETURN_PATTERN;
		}

		@Override
		public void disconnect() {
			
		}

		public String getBeginTransactionCommand() {
			return null;
		}

		public String getCommitCommand() {
			return null;
		}

		public String getRollbackCommand() {
			return null;
		}
	}
}
