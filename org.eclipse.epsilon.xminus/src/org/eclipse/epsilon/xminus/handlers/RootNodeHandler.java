package org.eclipse.epsilon.xminus.handlers;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.xminus.XminusContext;
import org.w3c.dom.Node;

public class RootNodeHandler extends AbstractNodeHandler {

	@Override
	public boolean canHandle(Node node, EObject eObject, XminusContext context) {
		return eObject == null;
	}

	@Override
	public void handle(Node node, EObject o, XminusContext context) {
		EClass eClass = context.getResource().eClassForName(getName(node), context.getResource().getNamespaceUri(node));
		EObject eObject = EcoreUtil.create(eClass);
		context.getResource().getContents().add(eClass);
		context.handleChildren(node, eObject);
	}

}
