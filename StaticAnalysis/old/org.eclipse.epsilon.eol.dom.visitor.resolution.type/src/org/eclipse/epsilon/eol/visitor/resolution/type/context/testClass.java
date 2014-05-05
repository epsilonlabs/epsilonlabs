package org.eclipse.epsilon.eol.visitor.resolution.type.context;

import org.eclipse.emf.ecore.EcorePackage;

public class testClass {

	public static void main(String[] args) {
		EcorePackage epaPackage = EcorePackage.eINSTANCE;
		System.out.println(epaPackage.getEBoolean().getInstanceClassName());
		System.out.println(epaPackage.getEBooleanObject().getInstanceClassName());
		System.out.println(epaPackage.getEDouble().getInstanceClassName());
		System.out.println(epaPackage.getEDoubleObject().getInstanceClassName());
		System.out.println(epaPackage.getEFloat().getInstanceClassName());
		System.out.println(epaPackage.getEFloatObject().getInstanceClassName());
		System.out.println(epaPackage.getEInt().getInstanceClassName());
		System.out.println(epaPackage.getEIntegerObject().getInstanceClassName());
	}
	
}
