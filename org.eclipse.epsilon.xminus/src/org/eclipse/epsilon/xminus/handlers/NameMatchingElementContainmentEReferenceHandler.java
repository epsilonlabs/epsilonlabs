package org.eclipse.epsilon.xminus.handlers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.epsilon.xminus.XminusContext;
import org.w3c.dom.Node;

public class NameMatchingElementContainmentEReferenceHandler extends NameMatchingNodeEStructuralFeatureHandler {
	
	@Override
	public boolean canHandle(Node node, EObject eObject, XminusContext context) {
		return context.getContainer() == null && 
			super.canHandle(node, eObject, context);
	}
	
	@Override
	public void handle(Node node, EObject eObject, XminusContext context) {
		EStructuralFeature oldContainer = context.getContainer();
		context.setContainer(eStructuralFeature);
		context.handleChildren(node, eObject);
		context.setContainer(oldContainer);
	}

	@Override
	protected boolean appliesToEStructuralFeature(EStructuralFeature eStructuralFeature) {
		return eStructuralFeature instanceof EReference && ((EReference) eStructuralFeature).isContainment();
	}

	@Override
	protected boolean appliesToNode(Node node) {
		return isElement(node);
	}

}
