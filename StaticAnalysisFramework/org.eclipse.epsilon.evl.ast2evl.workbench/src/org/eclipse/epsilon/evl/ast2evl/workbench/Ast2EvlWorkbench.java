package org.eclipse.epsilon.evl.ast2evl.workbench;

import java.io.File;
import java.net.URL;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.metamodel.EOLElement;
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.epsilon.evl.ast2evl.Ast2EvlContext;

public class Ast2EvlWorkbench {

	public static void main(String[] args) {
		try {
			new Ast2EvlWorkbench().run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() throws Exception {
		
		URL url = getClass().getResource("test.evl");
		System.out.println(url.toString());
		EvlModule evlModule = new EvlModule();
		try {
			evlModule.parse(new File(url.getPath()));
		} catch (Exception e) {
			e.printStackTrace();
		}

		AST ast = evlModule.getAst();
		
		System.out.println(ast.toStringTree());

		Ast2EvlContext context = new Ast2EvlContext(evlModule);
		EOLElement dom = (EOLElement) context.getEvlElementCreatorFactory().createEOLElement(evlModule.getAst(), null, context);
		
		System.err.println(context.getEvlElementCreatorFactory().isProperlyContained() ? "DomElements are property contained" : "DomElements are NOT properly contained");

		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		Resource resource = resourceSet.createResource(URI.createFileURI(new File("test.xmi").getAbsolutePath()));
		resource.getContents().add(dom);
		System.out.println(resourceSet.getPackageRegistry().toString());
		System.out.println(EPackage.Registry.INSTANCE.toString());
		resource.save(null);	

	}

}
