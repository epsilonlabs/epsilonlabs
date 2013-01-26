package org.eclipse.epsilon.xminus;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.epsilon.xminus.handlers.NodeHandler;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XminusContext {
	
	protected XminusResource resource = null;
	protected ArrayList<NodeHandler> nodeHandlers = new ArrayList<NodeHandler>();
	protected EStructuralFeature container;
	
	public void setResource(XminusResource resource) {
		this.resource = resource;
	}
	
	public XminusResource getResource() {
		return resource;
	}
	
	public void setContainer(EStructuralFeature container) {
		this.container = container;
	}
	
	public EStructuralFeature getContainer() {
		return container;
	}
	
	public ArrayList<NodeHandler> getNodeHandlers() {
		return nodeHandlers;
	}
	
	public void handleNode(Node node, EObject eObject) {
		for (NodeHandler nodeHandler : getNodeHandlers()) {
			if (nodeHandler.canHandle(node, eObject, this)) {
				nodeHandler.handle(node, eObject, this);
			}
		}
	}
	
	public void handleChildren(Node node, EObject eObject) {
		NodeList childNodes = node.getChildNodes();

		for (Node attribute : getAttributes(node)) {
			handleNode(attribute, eObject);
		}
		
		for (int i=0; i<childNodes.getLength(); i++) {
			handleNode(childNodes.item(i), eObject);
		}
		
	}
	
	protected List<Node> getAttributes(Node node) {
		ArrayList<Node> attributes = new ArrayList<Node>();
		for (int i=0; i<node.getAttributes().getLength(); i++) {
			attributes.add(node.getAttributes().item(i));
		}
		return attributes;
	}
	
}
