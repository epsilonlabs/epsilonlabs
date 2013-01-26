package org.eclipse.epsilon.xminus.loader;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.w3c.dom.Node;

public class RootNodeHandler extends ContextualNodeHandler {

	@Override
	public boolean canHandle(Node node, EObject eObject) {
		return eObject == null;
	}

	@Override
	public void handle(Node node, EObject o) {
		EClass eClass = context.eClassForName(context.getName(node), context.getNamespaceUri(node));
		EObject eObject = context.createInstance(eClass, node);
		context.getResource().getContents().add(eObject);
		context.handleChildren(node, eObject);
	}

}
