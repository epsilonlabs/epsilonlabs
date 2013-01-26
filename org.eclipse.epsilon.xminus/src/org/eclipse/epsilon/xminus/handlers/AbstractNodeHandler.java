package org.eclipse.epsilon.xminus.handlers;

import org.eclipse.emf.ecore.EClassifier;
import org.w3c.dom.Node;

public abstract class AbstractNodeHandler implements NodeHandler {
	
	protected short AttributeNodeType = 2;
	protected short ElementNodeType = 1;	

	protected boolean isAttribute(Node node) {
		return node.getNodeType() == AttributeNodeType;
	}

	protected boolean isElement(Node node) {
		return node.getNodeType() == ElementNodeType;
	}
	
	protected String getName(Node node) {
		String name = node.getNodeName();
		if (name.indexOf(':') > 0) {
			name = name.split(":")[1];
		}
		return name;
	}
	
	protected String getNamespaceUri(EClassifier eClassifier) {
		return eClassifier.getEPackage().getNsURI() + "#" + eClassifier.getName();
	}
	
	protected String getPrefix(Node node) {
		String name = node.getNodeName();
		if (name.indexOf(':') > 0) {
			return name.split(":")[0];
		}
		else {
			return "";
		}		
	}
	
	protected String getValue(Node node) {
		if (isElement(node)) {
			return ("" + node.getTextContent()).trim();
		}
		else {
			return node.getNodeValue().trim();
		}
	}
}
