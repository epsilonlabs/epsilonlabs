package org.eclipse.epsilon.xminus.handlers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.epsilon.xminus.XminusContext;
import org.eclipse.epsilon.xminus.valuesetters.EReferenceValueSetter;
import org.w3c.dom.Node;

public class NameMatchingNodeNonContainmentEReferenceValueHandler extends NameMatchingNodeEStructuralFeatureHandler {
	
	@Override
	public boolean canHandle(Node node, EObject eObject, XminusContext context) {
		return context.getContainer() == null && super.canHandle(node, eObject, context);
	}
	
	@Override
	public void handle(Node node, EObject eObject, XminusContext context) {
		new EReferenceValueSetter().setValue((EReference) eStructuralFeature, eObject, getValue(node), context);
	}

	@Override
	protected boolean appliesToEStructuralFeature(EStructuralFeature eStructuralFeature) {
		return eStructuralFeature instanceof EReference && !((EReference) eStructuralFeature).isContainment();
	}

	@Override
	protected boolean appliesToNode(Node node) {
		return isAttribute(node) || isElement(node);
	}

}
