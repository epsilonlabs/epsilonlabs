package org.eclipse.epsilon.xminus.handlers;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.xminus.XminusContext;
import org.eclipse.epsilon.xminus.valuesetters.EReferenceValueSetter;
import org.w3c.dom.Node;

public class ElementInContainmentEReferenceHandler extends AbstractNodeHandler {

	@Override
	public boolean canHandle(Node node, EObject eObject, XminusContext context) {
		return context.getContainer() instanceof EReference && isElement(node);
	}

	@Override
	public void handle(Node node, EObject parent, XminusContext context) {
		EClass eClass = context.getResource().eClassForName(getName(node), context.getResource().getNamespaceUri(node));
		EObject eObject = EcoreUtil.create(eClass);
		
		EReference eReference = (EReference) context.getContainer();
		
		new EReferenceValueSetter().setValue(eReference, parent, eObject, context);
		
		EStructuralFeature oldContainer = context.getContainer();
		context.setContainer(null);
		context.handleChildren(node, eObject);
		context.setContainer(oldContainer);
	}
	
}
