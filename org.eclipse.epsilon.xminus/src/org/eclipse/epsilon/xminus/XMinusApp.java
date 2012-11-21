package org.eclipse.epsilon.xminus;

import java.io.File;
import java.io.FileOutputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.eol.EolModule;

import testm2.Testm2Package;

public class XMinusApp {
	
	public static void main(String[] args) throws Exception {
		new XMinusApp().run();
	}
	
	public void run() throws Exception {
		ResourceSet rs = new ResourceSetImpl();
		rs.getPackageRegistry().put(Testm2Package.eINSTANCE.getNsURI(), Testm2Package.eINSTANCE);
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XminusResourceFactory());
		Resource r = rs.createResource(URI.createFileURI(new File("test.xml").getAbsolutePath()));
		r.load(null);
		
		EolModule module = new EolModule();
		//module.parse("for (wp in WP.all) { wp.leader.id.println(wp.title + '->');}");
		//module.parse("for (task in Task.all) { task.partners.size().println(); }");
		module.parse("Effort.all.collect(e|e.months).sum().println();");
		InMemoryEmfModel model = new InMemoryEmfModel(r);
		module.getContext().getModelRepository().addModel(model);
		module.execute();
		
		r.save(new FileOutputStream(new File("test.copy.xml")), null);
		
		/*
		for (EObject o : r.getContents()) {
			print(o,0);
		}*/
	}
	
	protected void print(EObject eObject, int indent) {
		for (int i=0;i<indent;i++) System.out.print("  ");
		System.out.println("[" + EcoreUtil.getID(eObject) + "] " + eObject);
		for (EObject content : eObject.eContents()) {
			print(content, indent+1);
		}
	}
	
}
