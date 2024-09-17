package br.com.codecompany.rysys.fgl.executor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.codecompany.rysys.api.executor.ExecutionResult;
import br.com.codecompany.rysys.api.executor.ProtocolException;
import br.com.codecompany.rysys.api.executor.NoResultException;
import br.com.codecompany.rysys.api.function.Types;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class FglExecutionResult implements ExecutionResult {

	private static Logger log = LoggerFactory.getLogger(FglExecutionResult.class);
	private boolean error = false;
	private String message;
	private List<Object> results = new ArrayList<Object>();

	public FglExecutionResult(Serializable response) {
		message = String.valueOf(response);
		try {
			InputSource input = new InputSource();
			input.setCharacterStream(new StringReader(message));
			XPath xpath = XPathFactory.newInstance().newXPath();
			String expression = "/rysys/function/results/result";
			NodeList nodes = (NodeList) xpath.evaluate(expression, input, XPathConstants.NODESET);
			if (nodes.getLength() > 0) {
				// percorre cada um dos <result>
				for (int i = 0; i < nodes.getLength(); i++) {
					String type = null;
					String value = null;
					Node node = nodes.item(i);
					NodeList children = node.getChildNodes();
					for (int j = 0; j < children.getLength(); j++) {
						Node child = children.item(j);
						if ("type".equals(child.getNodeName())) {
							type = child.getTextContent();
						} else if ("value".equals(child.getNodeName())) {
							value = child.getTextContent();
						}
						if (type != null && value != null) {
							Object result = populate(type, value);
							results.add(result);
							log.debug("Result received from EIS: [" + results + "]");
						}
					}
				}
			} else {
				log.debug("Empty result received from EIS");
			}
		} catch (Exception e) {
			throw new ProtocolException("Invalid message received from EIS: " + message, e);
		}
	}

	private Object populate(String type, String value) {
		Object result = null;
		int t = -1;

		try {
			t = Integer.valueOf(type);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("The argument type is not a number");
		}

		switch (t) {
			case Types.FGL_FLOAT:
				result = Float.parseFloat(value);
				break;
			case Types.FGL_INTEGER:
				result = Integer.parseInt(value);
				break;
			case Types.FGL_STRING:
				result = value;
				break;
			case Types.FGL_DATE:
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				try {
					result = dateFormat.parse(value);
					break;
				} catch (ParseException e) {
					throw new IllegalArgumentException("Date value '" + value +
							"' does not correspond to format 'yyyy-MM-dd'");
				}
			default:
				throw new IllegalArgumentException("The argument type '"
						+ type + "' is unknown");
		}

		return result;
	}

	@Override
	public String toString() {
		return message;
	}

	public boolean isError() {
		return error;
	}

	public Object getResultAt(int index) {
		if (results == null) {
			throw new NoResultException("There is no result for this execution");
		} else {
			if (index > results.size() - 1) {
				throw new NoResultException("There is no result in index " + index);
			}
			return results.get(index);
		}
	}

	public int size() {
		return results.size();
	}
}
