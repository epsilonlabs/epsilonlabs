package org.eclipse.epsilon.xminus.handlers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.w3c.dom.Node;

public class NameMatchingElementContainmentEReferenceHandler extends NameMatchingNodeEStructuralFeatureHandler {
	
	@Override
	public boolean canHandle(Node node, EObject eObject) {
		return context.getContainer() == null && 
			super.canHandle(node, eObject);
	}
	
	@Override
	public void handle(Node node, EObject eObject) {
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
		return context.isElement(node);
	}

}
