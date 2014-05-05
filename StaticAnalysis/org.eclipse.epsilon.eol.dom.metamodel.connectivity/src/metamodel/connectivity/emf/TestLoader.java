package metamodel.connectivity.emf;


import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;

public class TestLoader {
	
	public static void main(String[] args)
	{
		TestLoader loader = new TestLoader();
		loader.test();
	}
	

	public void test(){
		ResourceSet resourceSet = new ResourceSetImpl();

		// Register the default resource factory -- only needed for stand-alone!
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
		"ecore", new EcoreResourceFactoryImpl());

		// Register the package -- only needed for stand-alone!
		EcorePackage ecorePackage = EcorePackage.eINSTANCE;

		// Get the URI of the model file.
		URI fileURI = URI.createFileURI(new File("Dom.ecore").getAbsolutePath());

		// Demand load the resource for this file.
		System.out.println(EPackage.Registry.INSTANCE.size());
		Resource resource = resourceSet.getResource(fileURI, true);

		// Print the contents of the resource to System.out.
		try
		{
			resource.save(System.out, Collections.EMPTY_MAP);
		}
		catch (IOException e) {}
		EPackage package1 = (EPackage) resource.getContents().get(0);
		EPackage.Registry.INSTANCE.put("Dom.ecore", package1);
		EPackage package0 = EPackage.Registry.INSTANCE.getEPackage("Dom.ecore");
		System.err.println(package0.toString());
		
		//EPackage package1 = (EPackage) resource.getContents().get(0);
		//EPackage.Registry.INSTANCE.put("Dom.ecore", package1);
		
		System.out.println(EPackage.Registry.INSTANCE.toString());
		System.out.println(EPackage.Registry.INSTANCE.size());
	}
}
