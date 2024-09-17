package br.com.codecompany.rysys.cobol.executor;


import java.io.Serializable;

import br.com.codecompany.rysys.api.executor.ExecutionResult;
import br.com.codecompany.rysys.api.executor.ProtocolException;
import br.com.codecompany.rysys.api.executor.NoResultException;
import java.io.StringReader;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class CobolExecutionResult implements ExecutionResult {

	private static Logger log = LoggerFactory.getLogger(CobolExecutionResult.class);

	private boolean error = false;
    private String message;
    private Object result = null;

    public CobolExecutionResult(Serializable response) {
    	message = String.valueOf(response);
    	try {
			InputSource input = new InputSource();
			input.setCharacterStream(new StringReader(message));
			XPath xpath = XPathFactory.newInstance().newXPath();
			String expression = "/rysys/function/results/result/value";
			NodeList nodes = (NodeList) xpath
				.evaluate(expression, input, XPathConstants.NODESET);
			if (nodes.getLength() > 0) {
				result = nodes.item(0).getTextContent();
				log.debug("Result received from EIS: [" + result + "]");
			}
			else {
				log.debug("Empty result received from EIS");
			}
		} catch (Exception e) {
			throw new ProtocolException("Invalid message received from EIS: " + message, e);
		}
    }

    @Override
    public String toString() {
        return message;
    }

    public boolean isError() {
        return error;
    }

    public Object getResultAt(int index) {
    	if (result == null) {
    		throw new NoResultException("There is no result for this execution");
    	}
    	else {
	    	if (index != 0) {
	    		throw new NoResultException("There is only one " +
						"result available. Use index 0");
	    	}
	        return result;
    	}
    }

    public int size() {
        return result == null? 0 : 1;
    }
}
