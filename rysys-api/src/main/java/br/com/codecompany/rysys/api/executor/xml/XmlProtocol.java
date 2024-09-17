package br.com.codecompany.rysys.api.executor.xml;

import br.com.codecompany.rysys.api.executor.ProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.codecompany.rysys.api.function.Parameter;
import br.com.codecompany.rysys.api.function.ParameterSupport;
import br.com.codecompany.rysys.util.SocketUtils;

import java.io.ByteArrayOutputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public abstract class XmlProtocol {

	public static final String ROOT_TAG = "rysys";
	public static final String FUNCTION_TAG = "function";
	public static final String PARAMETERS_TAG = "parameters";
	public static final String PARAMETER_TAG = "parameter";
	public static final String PARAMETER_NAME_TAG = "name";
	public static final String PARAMETER_TYPE_TAG = "type";
	public static final String PARAMETER_VALUE_TAG = "value";
	public static final String TRANSACTION_NAME_TAG = "name";

	private static Logger log = LoggerFactory.getLogger(XmlProtocol.class);
	
	public static final String PROTOCOL_VERSION = "1";
	
	protected Document document;
	protected Element root;

	public XmlProtocol() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(false);
			DocumentBuilder builder = factory.newDocumentBuilder();
			document = builder.newDocument();
			root = document.createElement(ROOT_TAG);
			document.appendChild(root);
		} catch (Exception e) {
			throw new ProtocolException("Error creating message to EIS", e);
		}
	}

	private String toString(Document document) {
		try {
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			Element element = document.getDocumentElement();
			DOMSource source = new DOMSource(element);
			StreamResult result = new StreamResult(stream);
			TransformerFactory transFactory = TransformerFactory.newInstance();
			Transformer transformer = transFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			transformer.setOutputProperty(OutputKeys.INDENT, "no");
			transformer.transform(source, result);
			return new String(stream.toByteArray());
		} catch (Exception e) {
			throw new ProtocolException("Error creating message to EIS", e);
		}
	}

	public String toXML(ParameterSupport function) {
		// cabecalho
		writeHeader(function, root);

		Element functionTag = document.createElement(FUNCTION_TAG);
		root.appendChild(functionTag);

		Element transactionName = document.createElement(TRANSACTION_NAME_TAG);
		transactionName.setTextContent(function.getName());
		functionTag.appendChild(transactionName);

		writeLibraryPathNode(function, functionTag);
		int parametersSize = function.getParameters().size();
		checkParametersSize(parametersSize);
		if (parametersSize > 0) {
			// inicio tag parameter
			Element parameters = document.createElement(PARAMETERS_TAG);
			functionTag.appendChild(parameters);

			// itera nos parametros
			for (Parameter param : function.getParameters()) {
				// inicio tag parameter
				Element parameter = document.createElement(PARAMETER_TAG);
				parameters.appendChild(parameter);

				// nome
				Element name = document.createElement(PARAMETER_NAME_TAG);
				name.setTextContent("");
				parameter.appendChild(name);

				// tipo
				Element type = document.createElement(PARAMETER_TYPE_TAG);
				type.setTextContent(String.valueOf(param.getType()));
				parameter.appendChild(type);

				// valor
				Element value = document.createElement(PARAMETER_VALUE_TAG);
				CDATASection cdata = document.createCDATASection(String.valueOf(param.getValue()));
				value.appendChild(cdata);
				parameter.appendChild(value);
			}
		}

		return toString(document);
	}

	private void writeHeader(ParameterSupport function, Element parent) {
		writeProtocolVersionNode(function, parent);

		// tag security
		writeSecurityNode(function, parent);

		// tag adapterType
		writeAdapterTypeNode(function, parent);

		// tag commandType
		writeCommandTypeNode(function, parent);
	}

	protected void writeProtocolVersionNode(ParameterSupport function, Element parent) {
		Element protocolVersion = document.createElement("protocolVersion");
		protocolVersion.setTextContent(PROTOCOL_VERSION);
		root.appendChild(protocolVersion);
	}

	protected void writeSecurityNode(ParameterSupport function, Element parent) {
		// tag security
		Element security = document.createElement("security");
		parent.appendChild(security);

		// tag sourceHost
		Element sourceHost = document.createElement("sourceHost");
		sourceHost.setTextContent(SocketUtils.getHostName());
		security.appendChild(sourceHost);

		// tag credentials
		Element cretentials = document.createElement("cretentials");
		security.appendChild(cretentials);

		// tag credential
		Element cretential = document.createElement("cretential");
		cretentials.appendChild(cretential);

		// tag name
		Element name = document.createElement(PARAMETER_NAME_TAG);
		name.setTextContent("");
		cretential.appendChild(name);

		// tag value
		Element value = document.createElement(PARAMETER_VALUE_TAG);
		value.setTextContent("");
		cretential.appendChild(value);
	}

	protected void writeAdapterTypeNode(ParameterSupport function, Element parent) {
		Element adapterType = document.createElement("adapterType");
		adapterType.setTextContent(String.valueOf(adapterType(function)));
		parent.appendChild(adapterType);
	}

	protected void writeCommandTypeNode(ParameterSupport function, Element parent) {
		Element commandType = document.createElement("commandType");
		commandType.setTextContent(String.valueOf(commandType(function)));
		parent.appendChild(commandType);
	}

	protected void writeLibraryPathNode(ParameterSupport function, Element parent) {
		Element libraryPath = document.createElement("libraryPath");
		libraryPath.setTextContent(libraryPath(function));
		parent.appendChild(libraryPath);
	}

	protected abstract void checkParametersSize(int parametersSize);

	protected abstract int adapterType(ParameterSupport function);

	protected abstract int commandType(ParameterSupport function);

	protected abstract String libraryPath(ParameterSupport function);
}
