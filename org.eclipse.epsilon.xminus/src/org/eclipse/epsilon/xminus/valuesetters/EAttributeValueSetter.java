package org.eclipse.epsilon.xminus.valuesetters;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

public class EAttributeValueSetter {
	
	public void setValue(EAttribute eAttribute, EObject eObject, String value) {
		System.err.println("Setting value of " + eAttribute);
	}
	
}
