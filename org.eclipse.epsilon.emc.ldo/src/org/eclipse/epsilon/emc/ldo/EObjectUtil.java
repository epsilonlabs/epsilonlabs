package org.eclipse.epsilon.emc.ldo;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

public class EObjectUtil {
	
	public static List<EObject> asList(EObject eObject) {
		List<EObject> eObjects = new ArrayList<EObject>(); 
		eObjects.add(eObject);
		TreeIterator<EObject> it = eObject.eAllContents();
		while (it.hasNext()) {
			eObjects.add(it.next());
		}
		return eObjects;
	}
	
}
