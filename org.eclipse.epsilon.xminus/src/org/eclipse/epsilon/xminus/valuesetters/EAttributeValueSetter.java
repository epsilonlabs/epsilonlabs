package org.eclipse.epsilon.xminus.valuesetters;

import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;

public class EAttributeValueSetter {
	
	public void setValue(EAttribute eAttribute, EObject eObject, String value) {
		
		//System.err.println("Setting value of " + eAttribute + " to " + value);
		
		EFactory eFactory = eAttribute.getEAttributeType().getEPackage().getEFactoryInstance();
		
		if (eAttribute.isMany()) {
			String[] values = value.split(",");
			List<Object> eValues = (List<Object>) eObject.eGet(eAttribute);
			for (String val : values) {
				eValues.add(eFactory.createFromString(eAttribute.getEAttributeType(), val.trim()));
			}
		}
		else {
			eObject.eSet(eAttribute, eFactory.createFromString(eAttribute.getEAttributeType(), value.trim()));
		}
	}
	
}
