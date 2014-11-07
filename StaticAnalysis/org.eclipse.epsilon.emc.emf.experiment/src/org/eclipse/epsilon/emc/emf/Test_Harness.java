package org.eclipse.epsilon.emc.emf;

import java.io.File;
import java.util.ArrayList;

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
		ArrayList<ArrayList<Long>> normalTimes = new ArrayList<ArrayList<Long>>();
		ArrayList<ArrayList<Long>> smartTimes = new ArrayList<ArrayList<Long>>();
		ArrayList<ArrayList<Long>> greedyTimes = new ArrayList<ArrayList<Long>>();
		
		final int iteration = 20;
		final int disregard = 10;
		
		for(int i = 0; i < iteration; i++)
		{
			normalTimes.add(Test_Harness.testNormal());
			System.gc();
			smartTimes.add(Test_Harness.testSmart());
			System.gc();
			greedyTimes.add(Test_Harness.testGreedy());
			System.gc();
		}
		
		int counter = 0;
		
		String normalResult = "";
		long normalLoadTime = 0;
		long normalExecutionTime = 0;
		for(ArrayList<Long> result : normalTimes)
		{
			if (counter < disregard) {
				
			}
			else {
				normalLoadTime += result.get(0);
				normalExecutionTime += result.get(1);
				normalResult += "|"+result.get(0) + ", " + result.get(1);	
			}
			counter ++;
		}
		String smartResult = "";
		long smartLoadTime = 0;
		long smartExecutionTime = 0;
		counter = 0;
		for(ArrayList<Long> result : smartTimes)
		{
			if (counter < disregard) {
				
			}
			else {
				smartLoadTime += result.get(0);
				smartExecutionTime += result.get(1);
				smartResult += "|" + result.get(0) + ", " + result.get(1);	
			}
			counter ++;
			
		}
		String greedyResult = "";
		long greedyLoadTime = 0;
		long greedyExecutionTime = 0;
		counter = 0;
		for(ArrayList<Long> result : greedyTimes)
		{
			if (counter < disregard) {
				
			}
			else {
				greedyLoadTime += result.get(0);
				greedyExecutionTime += result.get(1);
				greedyResult += "|" + result.get(0) + ", " + result.get(1);	
			}
			counter ++;
			
		}
		
		System.out.println("Normal: " + normalResult);
		System.out.println("Smart: " + smartResult);
		System.out.println("Greedy: " + greedyResult);
		
		System.out.println("normal loading time average: " + normalLoadTime/(iteration-disregard));
		System.out.println("normal execution time average: " + normalExecutionTime/(iteration-disregard));
		
		System.out.println("smart loading time average: " + smartLoadTime/(iteration-disregard));
		System.out.println("smart execution time average: " + smartExecutionTime/(iteration-disregard));
		
		System.out.println("greedy loading time average: " + greedyLoadTime/(iteration-disregard));
		System.out.println("greedy execution time average: " + greedyExecutionTime/(iteration-disregard));
	}

	public static ArrayList<Long> testSmart() throws Exception
	{
		ArrayList<Long> result = new ArrayList<Long>();
		EolModule eolModule = new EolModule();
		eolModule.parse(new File("test/40percent.eol"));
		
		EmfSmartModel smartModel = new EmfSmartModel();
		smartModel.setName("DOM");
		smartModel.setModelFile(new File("test/set1.xmi").getAbsolutePath());
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
		
		smartModel.setModelContainers(loaContext.getModelContainers());
		
		long init = System.nanoTime();
		smartModel.load();
		result.add((System.nanoTime() - init)/1000000);
		System.out.println("(took ~" + (System.nanoTime() - init)
				/ 1000000 + "ms to load)");
		
		init = System.nanoTime();
		eolModule.getContext().getModelRepository().addModel(smartModel);
		eolModule.execute();
		result.add((System.nanoTime() - init)/1000000);
		System.out.println("(took ~" + (System.nanoTime() - init)
				/ 1000000 + "ms to run)");
		eolModule.getContext().getModelRepository().dispose();
		return result;
	}
	
	public static ArrayList<Long> testNormal() throws Exception
	{
		ArrayList<Long> result = new ArrayList<Long>();
		EolModule eolModule = new EolModule();
		eolModule.parse(new File("test/40percent.eol"));
		
		EmfModel normalModel = new EmfModel();
		normalModel.setName("DOM");
		normalModel.setMetamodelFile(new File("test/JDTAST.ecore").getAbsolutePath());
		normalModel.setModelFile(new File("test/set1.xmi").getAbsolutePath());
		
		loadEPackageFromFile("test/JDTAST.ecore");
		
		System.out.println("emf model prepared, loading...");
		
		long init = System.nanoTime();

		normalModel.load();
		result.add((System.nanoTime() - init)/1000000);

		System.out.println("(took ~" + (System.nanoTime() - init)
				/ 1000000 + "ms to load)");
		
		init = System.nanoTime();
		eolModule.getContext().getModelRepository().addModel(normalModel);
		eolModule.execute();
		result.add((System.nanoTime() - init)/1000000);
		System.out.println("(took ~" + (System.nanoTime() - init)
				/ 1000000 + "ms to run)");
		eolModule.getContext().getModelRepository().dispose();
		return result;
	}
	
	public static ArrayList<Long> testGreedy() throws Exception
	{
		ArrayList<Long> result = new ArrayList<Long>();
		EolModule eolModule = new EolModule();
		eolModule.parse(new File("test/40percent.eol"));
		
		EmfGreedyModel normalModel = new EmfGreedyModel();
		normalModel.setName("DOM");
		normalModel.setMetamodelFile(new File("test/JDTAST.ecore").getAbsolutePath());
		normalModel.setModelFile(new File("test/set1.xmi").getAbsolutePath());
		
		loadEPackageFromFile("test/JDTAST.ecore");
		
		System.out.println("emf model prepared, loading...");
		
		long init = System.nanoTime();

		normalModel.load();
		result.add((System.nanoTime() - init)/1000000);
		System.out.println("(took ~" + (System.nanoTime() - init)
				/ 1000000 + "ms to load)");
		
		init = System.nanoTime();
		eolModule.getContext().getModelRepository().addModel(normalModel);
		eolModule.execute();
		result.add((System.nanoTime() - init)/1000000);
		System.out.println("(took ~" + (System.nanoTime() - init)
				/ 1000000 + "ms to run)");
		eolModule.getContext().getModelRepository().dispose();
		return result;
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
