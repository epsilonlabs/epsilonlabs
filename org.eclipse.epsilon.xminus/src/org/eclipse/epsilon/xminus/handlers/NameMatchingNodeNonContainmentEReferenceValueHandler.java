package org.eclipse.epsilon.xminus.handlers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.w3c.dom.Node;

public class NameMatchingNodeNonContainmentEReferenceValueHandler extends NameMatchingNodeEStructuralFeatureHandler {
	
	@Override
	public boolean canHandle(Node node, EObject eObject) {
		return context.getContainer() == null && super.canHandle(node, eObject);
	}
	
	@Override
	public void handle(Node node, EObject eObject) {
		new EReferenceValueSetter().setValue((EReference) eStructuralFeature, eObject, context.getValue(node), context);
	}

	@Override
	protected boolean appliesToEStructuralFeature(EStructuralFeature eStructuralFeature) {
		return eStructuralFeature instanceof EReference && !((EReference) eStructuralFeature).isContainment();
	}

	@Override
	protected boolean appliesToNode(Node node) {
		return context.isAttribute(node) || context.isElement(node);
	}

}
