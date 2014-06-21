package metamodel.connectivity.util;



import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.EcorePackage;

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
		if (result == null) {
			throw new Exception("Cannot find EPackage with uri: " + packageURI);
		}
		return result;
	}
}
