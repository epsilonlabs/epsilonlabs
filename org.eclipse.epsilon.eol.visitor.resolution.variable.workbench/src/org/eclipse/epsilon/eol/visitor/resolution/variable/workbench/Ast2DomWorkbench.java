package org.eclipse.epsilon.eol.visitor.resolution.variable.workbench;


import java.io.File;
import java.net.URL;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.ast2eol.context.Ast2EolContext;
import org.eclipse.epsilon.eol.metamodel.EOLElement;
import org.eclipse.epsilon.eol.problem.EOLProblem;
import org.eclipse.epsilon.eol.problem.LogBook;
import org.eclipse.epsilon.eol.visitor.resolution.variable.impl.EOLVariableResolver;

public class Ast2DomWorkbench {

	public static void main(String[] args) throws Exception {
		new Ast2DomWorkbench().run();
	}
	
	public void run() throws Exception {
		
		URL url = getClass().getResource("test1.eol");
		
		EolModule eolModule = new EolModule();
		try {
			eolModule.parse(new File(url.getPath()));
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		Ast2EolContext context = new Ast2EolContext();
		
		System.out.println(eolModule.getAst().toStringTree());
		
		EOLElement dom = context.getEolElementCreatorFactory().createEOLElement(eolModule.getAst(), null, context);
		
		System.err.println(context.getEolElementCreatorFactory().isProperlyContained() ? "DomElements are property contained" : "DomElements are NOT properly contained");
		
		EOLVariableResolver app = new EOLVariableResolver();
		app.run(dom);
		
		LogBook logBook = LogBook.getInstance();
		for(EOLProblem problem: logBook.getAllProblems())
		{
			System.out.println(problem.getMessage());
		}
				
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		Resource resource = resourceSet.createResource(URI.createFileURI(new File("test.xmi").getAbsolutePath()));
		resource.getContents().add(dom);
		System.out.println(resourceSet.getPackageRegistry().toString());
		System.out.println(EPackage.Registry.INSTANCE.toString());
		resource.save(null);	

	}
}
