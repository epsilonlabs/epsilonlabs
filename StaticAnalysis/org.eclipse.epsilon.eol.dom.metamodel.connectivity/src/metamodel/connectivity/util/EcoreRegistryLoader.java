package metamodel.connectivity.util;



import java.util.Set;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;

public class EcoreRegistryLoader {
	
	public static void main(String[] args) throws Exception
	{
		System.out.println(EcorePackage.eINSTANCE);
		Registry epack = EPackage.Registry.INSTANCE;
		for(Object obj: EPackage.Registry.INSTANCE.keySet())
		{
			System.out.println(obj);
		}
	}
	
	public static EPackage loadEPackageFromRetistry(String packageURI) throws Exception
	{			
		EPackage result = null;
		result = EPackage.Registry.INSTANCE.getEPackage(packageURI);
		return result;
	}
}
