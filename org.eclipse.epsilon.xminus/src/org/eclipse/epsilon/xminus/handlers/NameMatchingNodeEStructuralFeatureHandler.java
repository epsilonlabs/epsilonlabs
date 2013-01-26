package org.eclipse.epsilon.xminus.handlers;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.epsilon.xminus.XminusContext;
import org.w3c.dom.Node;

public abstract class NameMatchingNodeEStructuralFeatureHandler extends AbstractNodeHandler {
	
	protected EStructuralFeature eStructuralFeature;

	@Override
	public boolean canHandle(Node node, EObject eObject, XminusContext context) {
		if (eObject == null) return false;
		EClass eClass = eObject.eClass();
		if (appliesToNode(node)) {
			for (EStructuralFeature eStructuralFeature : eClass.getEAllStructuralFeatures()) {
				if (eStructuralFeature.isTransient()) continue;
				if (!appliesToEStructuralFeature(eStructuralFeature)) continue;
				if (eStructuralFeature.getName().equalsIgnoreCase(getName(node))) {
					this.eStructuralFeature = eStructuralFeature;
					return true;
				}
			}
		}
		return false;
	}
	
	protected abstract boolean appliesToEStructuralFeature(EStructuralFeature eStructuralFeature);
	
	protected abstract boolean appliesToNode(Node node);
}
