package org.eclipse.epsilon.xminus;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import testm2.Testm2Package;

public class XMinusApp {
	
	public static void main(String[] args) throws Exception {
		
		new XMinusApp().run();
		
	}
	
	public void run() throws Exception {
		ResourceSet rs = new ResourceSetImpl();
		//rs.getPackageRegistry().put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		rs.getPackageRegistry().put(Testm2Package.eINSTANCE.getNsURI(), Testm2Package.eINSTANCE);
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XminusResourceFactory());
		Resource r = rs.createResource(URI.createFileURI("/Users/dimitrioskolovos/Projects/Eclipse/appengine-juno/workspace/org.eclipse.epsilon.xminus/test.xml"));
		r.load(null);
		for (EObject o : r.getContents()) {
			print(o,0);
		}
	}
	
	protected void print(EObject eObject, int indent) {
		for (int i=0;i<indent;i++) System.out.print("  ");
		System.out.println(eObject);
		for (EObject content : eObject.eContents()) {
			print(content, indent+1);
		}
	}
	
}
