package org.eclipse.epsilon.xminus.handlers;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.w3c.dom.Node;

public class NameMatchingNodeEAttributeHandler extends NameMatchingNodeEStructuralFeatureHandler {
	
	@Override
	public void handle(Node node, EObject eObject) {
		new EAttributeValueSetter().setValue((EAttribute) eStructuralFeature, eObject, context.getValue(node));		
	}

	@Override
	protected boolean appliesToEStructuralFeature(EStructuralFeature eStructuralFeature) {
		return eStructuralFeature instanceof EAttribute;
	}

	@Override
	protected boolean appliesToNode(Node node) {
		return context.isAttribute(node) || context.isElement(node);
	}
	
}