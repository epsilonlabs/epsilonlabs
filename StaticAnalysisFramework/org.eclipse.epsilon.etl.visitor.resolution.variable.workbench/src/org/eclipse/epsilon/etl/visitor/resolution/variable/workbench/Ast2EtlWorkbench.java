package org.eclipse.epsilon.etl.visitor.resolution.variable.workbench;


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
import org.eclipse.epsilon.etl.EtlModule;
import org.eclipse.epsilon.etl.ast2etl.Ast2EtlContext;
import org.eclipse.epsilon.etl.visitor.resolution.variable.impl.EtlVariableResolver;


public class Ast2EtlWorkbench {

	public static void main(String[] args) throws Exception {
		new Ast2EtlWorkbench().run();
	}
	
	public void run() throws Exception {
		
		URL url = getClass().getResource("test.etl");
		System.out.println(url.toString());
		EtlModule etlModule = new EtlModule();
		try {
			etlModule.parse(new File(url.getPath()));
		} catch (Exception e) {
			e.printStackTrace();
		}

		AST ast = etlModule.getAst();
		
		System.out.println(ast.toStringTree());
		//System.out.println(ast.getFirstChild().getType());
		//System.out.println(ast.getChild(0).getChild(0).getChild(1).getType());
		//System.out.println(ast.getChild(0).getChild(0).getChild(1).getText());

		Ast2EtlContext context = new Ast2EtlContext(etlModule);
		EOLElement dom = (EOLElement) context.getEtlElementCreatorFactory().createEOLElement(etlModule.getAst(), null, context);
		
//		Ast2EolContext context = new Ast2EolContext();
//		EolElement dom = (EolElement) context.getEolElementCreatorFactory().createDomElement(etlModule.getAst(), null, context);
//		
		System.err.println(context.getEtlElementCreatorFactory().isProperlyContained() ? "DomElements are property contained" : "DomElements are NOT properly contained");
//		
//		VariableResolver app = new VariableResolver();
//		app.run(dom);
		
		EtlVariableResolver vr = new EtlVariableResolver();
		vr.run(dom);
//				
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		Resource resource = resourceSet.createResource(URI.createFileURI(new File("test.xmi").getAbsolutePath()));
		resource.getContents().add(dom);
		System.out.println(resourceSet.getPackageRegistry().toString());
		System.out.println(EPackage.Registry.INSTANCE.toString());
		resource.save(null);	

	}
}
