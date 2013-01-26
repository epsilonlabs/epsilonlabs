package org.eclipse.epsilon.xminus;

import java.io.File;
import java.io.FileOutputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.types.EolSequence;

import rss.RssPackage;
import testm2.Testm2Factory;
import testm2.Testm2Package;

public class XMinusApp {
	
	public static void main(String[] args) throws Exception {
		new XMinusApp().run();
	}
	
	public void run() throws Exception {
		ResourceSet rs = new ResourceSetImpl();
		rs.getPackageRegistry().put(EcorePackage.eINSTANCE.getNsURI(), EcorePackage.eINSTANCE);
		//rs.getPackageRegistry().put(Testm2Package.eINSTANCE.getNsURI(), Testm2Package.eINSTANCE);
		//rs.getPackageRegistry().put(RssPackage.eINSTANCE.getNsURI(), RssPackage.eINSTANCE);
		
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XminusResourceFactory());
		Resource r = rs.createResource(URI.createFileURI(new File("ecore.xml").getAbsolutePath()));
		//Resource r = rs.createResource(URI.createURI("http://kolovos.wordpress.com/feed"));
		r.load(null);
		
		for (Diagnostic diagnostic : r.getWarnings()) {
			System.err.println(diagnostic.getMessage());
		}
		
		//for (EObject o : r.getContents()) {
		//	print(o,0);
		//}
		
		EolModule module = new EolModule();
		//module.parse("EReference.all.second().id().println(); EReference.all.second().eOpposite.name.println();");
		
		//module.parse("EReference.all.first().eOpposite.name.println();");
		module.parse("EClass.all.first().eSuperTypes.first().name.println();");
		//module.parse("EClass.all.collect(c|c.id()).println();");
		
		InMemoryEmfModel model = new InMemoryEmfModel(r);
		module.getContext().getModelRepository().addModel(model);
		module.execute();
		
		/*
		EolSequence<?> objects = (EolSequence<?>) module.execute();
		EObject eDataType = (EObject) objects.get(0);
		EObject eProxy = (EObject) objects.get(1);
		
		System.err.println(eDataType);
		System.err.println(eDataType.eResource().getURIFragment(eDataType));
		System.err.println(eProxy);
		System.err.println(eProxy.eIsProxy());
		
		System.err.println(r.getEObject("//s"));
		
		/*
		EolModule module = new EolModule();
		//module.parse("for (wp in Project.all) { wp.c.println(); }");
		//module.parse("for (task in Task.all) { task.partners.size().println(task.title + '->'); }");
		
		//module.parse("var tni = ThingWithNoId.all.first(); tni.eResource().getURIFragment(tni).println();");
		module.parse("WP.all.first().thingsWithNoId.first().name.println();");
		//module.parse("for (d in Deliverable.all){ d.partner.println(); }");
		//module.parse("Effort.all.collect(e|e.months).sum().println();");
		//module.parse("Item.all.collect(i|i.title).println();");
		InMemoryEmfModel model = new InMemoryEmfModel(r);
		module.getContext().getModelRepository().addModel(model);
		module.execute();
		
		r.save(new FileOutputStream(new File("test.copy.xml")), null);
		*/
		
	}
	
	protected void print(EObject eObject, int indent) {
		for (int i=0;i<indent;i++) System.out.print("  ");
		System.out.println("[" + EcoreUtil.getID(eObject) + "] " + eObject);
		for (EObject content : eObject.eContents()) {
			print(content, indent+1);
		}
	}
	
}
