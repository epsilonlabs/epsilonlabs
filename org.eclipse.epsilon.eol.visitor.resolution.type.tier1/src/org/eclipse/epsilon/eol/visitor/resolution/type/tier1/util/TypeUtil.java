package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;

public class TypeUtil {

	public boolean isEDataType(EObject eObject)
	{
		return eObject instanceof EDataType;
	}
	
	
}
