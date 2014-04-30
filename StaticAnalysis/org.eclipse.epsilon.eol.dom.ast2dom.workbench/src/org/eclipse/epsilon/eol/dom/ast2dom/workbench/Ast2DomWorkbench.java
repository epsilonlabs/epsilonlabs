package org.eclipse.epsilon.eol.dom.ast2dom.workbench;


import java.io.File;
import java.net.URL;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.ast2dom.Ast2DomContext;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.visitor.resolution.variable.impl.VariableResolver;

public class Ast2DomWorkbench {

	public static void main(String[] args) throws Exception {
		new Ast2DomWorkbench().run();
	}
	
	public void run() throws Exception {
		
		URL url = getClass().getResource("test1.eol");
		System.out.println(url.toString());
		EolModule eolModule = new EolModule();
		try {
			eolModule.parse(new File(url.getPath()));
		} catch (Exception e) {
			e.printStackTrace();
		}

		AST ast = eolModule.getAst();
		System.out.println(ast.toStringTree());
		
		System.out.println(ast.getChild(0).getChild(0).getChild(1).getType());
		System.out.println(ast.getChild(0).getChild(0).getChild(1).getText());
		
		Ast2DomContext context = new Ast2DomContext();
		EolElement dom = context.getEolElementCreatorFactory().createDomElement(eolModule.getAst(), null, context);
		
		System.err.println(context.getEolElementCreatorFactory().isProperlyContained() ? "DomElements are property contained" : "DomElements are NOT properly contained");
		
		VariableResolver app = new VariableResolver();
		app.run(dom);
				
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		Resource resource = resourceSet.createResource(URI.createFileURI(new File("test.xmi").getAbsolutePath()));
		resource.getContents().add(dom);
		System.out.println(resourceSet.getPackageRegistry().toString());
		System.out.println(EPackage.Registry.INSTANCE.toString());
		resource.save(null);	

	}
}
