package org.eclipse.epsilon.xminus.handlers;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.epsilon.xminus.XminusContext;
import org.eclipse.epsilon.xminus.valuesetters.EAttributeValueSetter;
import org.w3c.dom.Node;

public class NameMatchingNodeEAttributeHandler extends NameMatchingNodeEStructuralFeatureHandler {
	
	@Override
	public void handle(Node node, EObject eObject, XminusContext context) {
		new EAttributeValueSetter().setValue((EAttribute) eStructuralFeature, eObject, getValue(node));		
	}

	@Override
	protected boolean appliesToEStructuralFeature(EStructuralFeature eStructuralFeature) {
		return eStructuralFeature instanceof EAttribute;
	}

	@Override
	protected boolean appliesToNode(Node node) {
		return isAttribute(node) || isElement(node);
	}
	
}