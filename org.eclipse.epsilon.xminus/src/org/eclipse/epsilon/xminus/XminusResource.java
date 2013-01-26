package org.eclipse.epsilon.xminus;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.epsilon.xminus.loader.XminusResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class XminusResource extends ResourceImpl {
	
	protected HashMap<EObject, Node> eObjectNodes = new HashMap<EObject, Node>();
	protected Document document = null;
	protected List<Resource> importedResources = new ArrayList<>();
	
	public XminusResource(URI uri) {
		setURI(uri);
	}
	
	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options)
			throws IOException {
		try {
			// Line numbers: http://stackoverflow.com/questions/4915422/get-line-number-from-xml-node-java
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			document = documentBuilder.parse(inputStream);
			new XminusResourceLoader(this).load(document);
		}
		catch (Exception ex) {
			throw new IOException(ex);
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
	
	public List<Resource> getImportedResources() {
		return importedResources;
	}
	
}