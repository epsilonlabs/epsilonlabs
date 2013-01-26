package org.eclipse.epsilon.xminus;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.epsilon.xminus.handlers.XminusContext;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class XminusResource extends ResourceImpl {
	
	protected HashMap<EObject, Node> eObjectNodes = new HashMap<EObject, Node>();
	protected Document document = null;
	protected XminusContext context = null;
	
	public XminusResource(URI uri) {
		setURI(uri);
		context = new XminusContext(this);
	}
	
	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options)
			throws IOException {
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			document = documentBuilder.parse(inputStream);
			
			context.cacheNamespaces(document.getDocumentElement());
			context.handleNode(document.getDocumentElement(), null);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	@Override
	protected void doSave(OutputStream outputStream, Map<?, ?> options)
			throws IOException {
		
		try {
			Source xmlSource = new DOMSource(document);
			Result result = new StreamResult(outputStream);
	
			// create TransformerFactory
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			
			// create Transformer for transformation
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");	//Java XML Indent
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			
			// transform and deliver content to client
			transformer.transform(xmlSource, result);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
}