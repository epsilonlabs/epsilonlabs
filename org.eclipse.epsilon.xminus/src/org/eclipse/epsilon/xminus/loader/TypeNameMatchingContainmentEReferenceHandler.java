package org.eclipse.epsilon.xminus.loader;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.w3c.dom.Node;

public class TypeNameMatchingContainmentEReferenceHandler extends ContextualNodeHandler {

	protected EReference eReference;
	protected EClass eClass;
	
	@Override
	public boolean canHandle(Node node, EObject eObject) {
		if (eObject != null && context.isElement(node) && context.getContainer() == null) {
			eClass = context.eClassForName(context.getName(node), context.getNamespaceUri(node));
			if (eClass == null) return false;
			
			for (EReference eReference : eObject.eClass().getEAllReferences()) {
				if (eReference.isTransient() || !eReference.isContainment()) continue;
				if (isAssignable(eClass, eReference.getEType())) {
					this.eReference = eReference;
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void handle(Node node, EObject p) {
		EObject eObject =  context.createInstance(eClass, node);
		new EReferenceValueSetter().setValue(eReference, p, eObject, context);
		context.handleChildren(node, eObject);
	}
	
	protected boolean isAssignable(EClass source, EClassifier target) {
		return source == target || source.getEAllSuperTypes().contains(target);
	}
	
}
