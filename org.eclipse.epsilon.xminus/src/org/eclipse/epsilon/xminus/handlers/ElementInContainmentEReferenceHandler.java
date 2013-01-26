package org.eclipse.epsilon.xminus.handlers;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.w3c.dom.Node;

public class ElementInContainmentEReferenceHandler extends ContextualNodeHandler {

	@Override
	public boolean canHandle(Node node, EObject eObject) {
		return context.getContainer() instanceof EReference && context.isElement(node);
	}

	@Override
	public void handle(Node node, EObject parent) {
		EClass eClass = context.eClassForName(context.getName(node), context.getNamespaceUri(node));
		EObject eObject = EcoreUtil.create(eClass);
		
		EReference eReference = (EReference) context.getContainer();
		
		new EReferenceValueSetter().setValue(eReference, parent, eObject, context);
		
		EStructuralFeature oldContainer = context.getContainer();
		context.setContainer(null);
		context.handleChildren(node, eObject);
		context.setContainer(oldContainer);
	}
	
}
