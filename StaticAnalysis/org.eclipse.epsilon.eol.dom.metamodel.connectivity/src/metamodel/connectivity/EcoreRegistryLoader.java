package metamodel.connectivity;


import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;

public class EcoreRegistryLoader {
	
	public static void main(String[] args) throws Exception
	{
		//EPackage ePackage = EcoreFileLoader.loadEPackageFromFile("dom.ecore");
		EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		//EPackage.Registry.INSTANCE.put("", null);
		if(EcoreRegistryLoader.loadEPackageFromRetistry("http://www.eclipse.org/emf/2002/Ecore") == null)
		{
			System.out.println("null");
		}
		else {
			System.out.println("loaded");
		}
		EcoreRegistryLoader.loadEPackageFromRetistry("http://dom/1.0");
		//EcoreRegistryLoader.loadEPackageFromRetistry("http://www.eclipse.org/ocl/1.1.0/Ecore");
		for(Object obj: EPackage.Registry.INSTANCE.values())
		{
			System.out.println(obj);
		}
	}
	
	public static EPackage loadEPackageFromRetistry(String packageURI) throws Exception
	{
		EPackage result = null;
		result = EPackage.Registry.INSTANCE.getEPackage(packageURI);
		if (result == null) {
			throw new Exception("Cannot find EPackage with uri: " + packageURI);
		}
		return result;
	}
}
