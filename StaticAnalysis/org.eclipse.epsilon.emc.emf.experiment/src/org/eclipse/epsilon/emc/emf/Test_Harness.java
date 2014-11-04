package org.eclipse.epsilon.emc.emf;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.analysis.optimisation.loading.context.LoadingOptimisationAnalysisContext;
import org.eclipse.epsilon.eol.analysis.optimisation.loading.impl.LoadingOptimisationAnalyser;
import org.eclipse.epsilon.eol.ast2eol.Ast2EolContext;
import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl.TypeResolver;
import org.eclipse.epsilon.eol.visitor.resolution.variable.impl.VariableResolver;

public class Test_Harness {
	
	public static void main(String[] args) throws Exception {
		
		//Test_Harness.testNormal();
		//System.gc();
		Test_Harness.testSmart();
		System.gc();
	}

	public static void testSmart() throws Exception
	{
		EolModule eolModule = new EolModule();
		eolModule.parse(new File("test/grabats.eol"));
		
		EmfSmartModel smartModel = new EmfSmartModel();
		smartModel.setName("DOM");
		smartModel.setModelFile(new File("test/set3.xmi").getAbsolutePath());
		smartModel.setMetamodelFile(new File("test/JDTAST.ecore").getAbsolutePath());
		//smartModel.setMetamodelUri("org.amma.dsl.jdt.dom");
		
		loadEPackageFromFile("test/JDTAST.ecore");
		
		Ast2EolContext ast2EolContext = new Ast2EolContext();
		EolElement dom = ast2EolContext.getEolElementCreatorFactory().createDomElement(eolModule.getAst(), null, ast2EolContext);
		
		VariableResolver vr = new VariableResolver();
		vr.run(dom);
		
		TypeResolver tr = new TypeResolver();
		tr.getTypeResolutionContext().setModule(eolModule);
		tr.run(dom);
		
		
		LoadingOptimisationAnalyser loa = new LoadingOptimisationAnalyser();
		loa.run(dom);
		
		LoadingOptimisationAnalysisContext loaContext = (LoadingOptimisationAnalysisContext) loa.getTypeResolutionContext();
		
		smartModel.setModelContainer(loaContext.getModelContainers().get(0));
		
		long init = System.nanoTime();
		smartModel.load();
		System.out.println("(took ~" + (System.nanoTime() - init)
				/ 1000000 + "ms to load)");
		
		init = System.nanoTime();
		eolModule.getContext().getModelRepository().addModel(smartModel);
		eolModule.execute();
		
		System.out.println("(took ~" + (System.nanoTime() - init)
				/ 1000000 + "ms to run)");
	}
	
	public static void testNormal() throws Exception
	{
		EolModule eolModule = new EolModule();
		eolModule.parse(new File("test/grabats.eol"));
		
		EmfModel normalModel = new EmfModel();
		normalModel.setName("DOM");
		normalModel.setMetamodelFile(new File("test/JDTAST.ecore").getAbsolutePath());
		normalModel.setModelFile(new File("test/set3.xmi").getAbsolutePath());
		
		loadEPackageFromFile("test/JDTAST.ecore");
		
		System.out.println("emf model prepared, loading...");
		
		long init = System.nanoTime();

		normalModel.load();
		System.out.println("(took ~" + (System.nanoTime() - init)
				/ 1000000 + "ms to load)");
		
		init = System.nanoTime();
		eolModule.getContext().getModelRepository().addModel(normalModel);
		eolModule.execute();
		
		System.out.println("(took ~" + (System.nanoTime() - init)
				/ 1000000 + "ms to run)");
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
				//break;
			}
		}
		return result;
	}

}
