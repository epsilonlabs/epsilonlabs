package org.eclipse.epsilon.eol.analysis.optimisation.loading.workbench;

import java.io.File;
import java.net.URL;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.EolImport;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.analysis.optimisation.loading.impl.LoadingOptimisationAnalyser;
import org.eclipse.epsilon.eol.ast2eol.Ast2EolContext;
import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl.TypeResolver;
import org.eclipse.epsilon.eol.visitor.resolution.variable.impl.VariableResolver;

public class Workbench {
	
	public static void main(String[] args) throws Exception {
		Workbench workbench = new Workbench();
		workbench.run();
		
	}

	public void run() throws Exception {
		
		URL url = getClass().getResource("test1.eol");
		//System.out.println(url.toString());
		EolModule eolModule = new EolModule();
		try {
			eolModule.parse(new File(url.getPath()));
		} catch (Exception e) {
			e.printStackTrace();
		}

		for(EolImport imp: eolModule.getImports())
		{
			System.out.println(imp.getModule().getAst().toStringTree());
		}
		
		loadEPackageFromFile("model/University.ecore");
		
		long start = System.nanoTime();

		Ast2EolContext context = new Ast2EolContext();
		EolElement dom = context.getEolElementCreatorFactory().createDomElement(eolModule.getAst(), null, context);
		
		VariableResolver vr = new VariableResolver();
		vr.run(dom);
				
		TypeResolver tr = new TypeResolver();
		tr.getTypeResolutionContext().setModule(eolModule);
		tr.run(dom);
		
		LoadingOptimisationAnalyser loa = new LoadingOptimisationAnalyser();
		loa.run(dom);
	
		long end = System.nanoTime();

		System.out.println((end-start)/1000000);

		loa.getTypeResolutionContext().print();

	}
	
	public static EPackage loadEPackageFromFile(String fileName)
	{
		EPackage result = null;
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		URI uri = URI.createFileURI(new File(fileName).getAbsolutePath());
		Resource resource = resourceSet.getResource(uri, true);
		for(EObject obj: resource.getContents())
		{
			if(obj instanceof EPackage)
			{
				EPackage.Registry.INSTANCE.put(((EPackage) obj).getNsURI(), obj);
				result = (EPackage) obj;
			}
		}
		return result;
	}


}
