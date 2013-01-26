package org.eclipse.epsilon.xminus.handlers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.xminus.XminusContext;
import org.w3c.dom.Node;

public interface NodeHandler {
	
	public boolean canHandle(Node node, EObject eObject, XminusContext context);
	public void handle(Node node, EObject eObject, XminusContext context);
	
}
