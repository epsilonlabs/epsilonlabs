package org.eclipse.epsilon.live;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class RemoteModelLoader {
	
	public Resource load(String modelUrl, String metamodelUrl) throws IOException {
		
		ResourceSet rs = new ResourceSetImpl();
		rs.getPackageRegistry().put(EcorePackage.eINSTANCE.getNsURI(), EcorePackage.eINSTANCE);
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		Resource resource = null;
		EPackage metamodel = null;
		
		if (metamodelUrl == null && modelUrl == null) {
			resource = rs.createResource(URI.createURI(""));
			resource.getContents().add(EcoreUtil.copy(EcorePackage.eINSTANCE));
			metamodel = EcorePackage.eINSTANCE;
		}
		else if (metamodelUrl != null) {
			resource = rs.createResource(URI.createURI(metamodelUrl));
			resource.load(Collections.emptyMap());
			metamodel = (EPackage) resource.getContents().get(0);

			rs = new ResourceSetImpl();
			rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
			rs.getPackageRegistry().put(metamodel.getNsURI(), metamodel);
			resource = rs.createResource(URI.createURI(modelUrl));
			resource.load(Collections.emptyMap());
		}
		
		return resource;
	}
	
}
