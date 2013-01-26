package org.eclipse.epsilon.xminus.loader;

import org.eclipse.emf.ecore.EObject;
import org.w3c.dom.Node;

public interface NodeHandler {
	
	public boolean canHandle(Node node, EObject eObject);
	public void handle(Node node, EObject eObject);
	
}
