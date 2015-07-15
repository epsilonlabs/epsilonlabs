package org.eclipse.epsilon.analysis.model.driver.util;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EPackage;

public class EcoreRegistryLoader {

	public static ArrayList<EPackage> loadEPackageFromRegistry(String nsURI) throws Exception
	{
		ArrayList<EPackage> result = new ArrayList<EPackage>();
		result.add(EPackage.Registry.INSTANCE.getEPackage(nsURI));
		return result;
	}
}
