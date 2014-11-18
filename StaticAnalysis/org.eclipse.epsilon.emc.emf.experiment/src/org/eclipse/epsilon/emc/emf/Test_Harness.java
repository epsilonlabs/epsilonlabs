package org.eclipse.epsilon.emc.emf;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
		Test_Harness.runSet1();
		//Test_Harness.runSet2();
		//Test_Harness.runSet3();
		//Test_Harness.runSet4();
	}
	
	public static void runSet1() throws Exception
	{
		Test_Harness.test("test/set1.xmi", "test/set1_10percent.eol");
		Test_Harness.test("test/set1.xmi", "test/set1_20percent.eol");
		Test_Harness.test("test/set1.xmi", "test/set1_30percent.eol");
		Test_Harness.test("test/set1.xmi", "test/set1_40percent.eol");
		Test_Harness.test("test/set1.xmi", "test/set1_50percent.eol");
		Test_Harness.test("test/set1.xmi", "test/set1_60percent.eol");
		Test_Harness.test("test/set1.xmi", "test/set1_70percent.eol");
		Test_Harness.test("test/set1.xmi", "test/set1_80percent.eol");
		Test_Harness.test("test/set1.xmi", "test/set1_95percent.eol");
		Test_Harness.test("test/set1.xmi", "test/set1_100percent.eol");
	}
	
	public static void runSet2() throws Exception
	{
//		Test_Harness.test("test/set2.xmi", "test/set2_10percent.eol");
//		Test_Harness.test("test/set2.xmi", "test/set2_20percent.eol");
//		Test_Harness.test("test/set2.xmi", "test/set2_30percent.eol");
//		Test_Harness.test("test/set2.xmi", "test/set2_40percent.eol");
//		Test_Harness.test("test/set2.xmi", "test/set2_50percent.eol");
		Test_Harness.test("test/set2.xmi", "test/set2_60percent.eol");
//		Test_Harness.test("test/set2.xmi", "test/set2_70percent.eol");
//		Test_Harness.test("test/set2.xmi", "test/set2_80percent.eol");
//		Test_Harness.test("test/set2.xmi", "test/set2_90percent.eol");
//		Test_Harness.test("test/set2.xmi", "test/set2_100percent.eol");
	}
	
	public static void runSet3() throws Exception
	{
//		Test_Harness.test("test/set3.xmi", "test/set3_10percent.eol");
		Test_Harness.test("test/set3.xmi", "test/set3_20percent.eol");
//		Test_Harness.test("test/set3.xmi", "test/set3_30percent.eol");
//		Test_Harness.test("test/set3.xmi", "test/set3_40percent.eol");
//		Test_Harness.test("test/set3.xmi", "test/set3_50percent.eol");
//		Test_Harness.test("test/set3.xmi", "test/set3_60percent.eol");
//		Test_Harness.test("test/set3.xmi", "test/set3_70percent.eol");
//		Test_Harness.test("test/set3.xmi", "test/set3_80percent.eol");
//		Test_Harness.test("test/set3.xmi", "test/set3_90percent.eol");
//		Test_Harness.test("test/set3.xmi", "test/set3_100percent.eol");
	}
	
	public static void runSet4() throws Exception
	{
		Test_Harness.test("test/set4.xmi", "test/set4_10percent.eol");
		Test_Harness.test("test/set4.xmi", "test/set4_20percent.eol");
		Test_Harness.test("test/set4.xmi", "test/set4_30percent.eol");
		Test_Harness.test("test/set4.xmi", "test/set4_40percent.eol");
		Test_Harness.test("test/set4.xmi", "test/set4_50percent.eol");
		Test_Harness.test("test/set4.xmi", "test/set4_60percent.eol");
		Test_Harness.test("test/set4.xmi", "test/set4_70percent.eol");
		Test_Harness.test("test/set4.xmi", "test/set4_80percent.eol");
		Test_Harness.test("test/set4.xmi", "test/set4_90percent.eol");
		Test_Harness.test("test/set4.xmi", "test/set4_100percent.eol");
	}
	
	public static void test(String set, String file) throws Exception
	{
		//prepare data holders
		ArrayList<ArrayList<Long>> normalData = new ArrayList<ArrayList<Long>>();
		ArrayList<ArrayList<Long>> smartData = new ArrayList<ArrayList<Long>>();
		ArrayList<ArrayList<Long>> greedyData = new ArrayList<ArrayList<Long>>();
		
		//specify the iteration and disregard
		final int iteration = 15;
		final int disregard = 5;
		
		//run normal
		for(int i = 0; i < iteration; i++)
		{
			normalData.add(Test_Harness.testModel(set, file, 0));
			System.gc();
		}

		//run smart
		for(int i = 0; i < iteration; i++)
		{
			smartData.add(Test_Harness.testModel(set, file, 1));
			System.gc();
		}
		
		//run greedy
		for(int i = 0; i < iteration; i++)
		{
			greedyData.add(Test_Harness.testModel(set, file, 2));
			System.gc();
		}
		
		//gc
		System.gc();
		
		//set counter
		int counter = 0;
		
		//normal results
		String normalResult = "";
		long normalLoadTime = 0;
		long normalExecutionTime = 0;
		long normalMemoryConsumption = 0;
		
		for(ArrayList<Long> result : normalData)
		{
			if (counter < disregard) {
				//if still in disregard range, ignore
			}
			else {
				normalLoadTime += result.get(0);
				normalExecutionTime += result.get(1);
				normalMemoryConsumption += result.get(2);
				normalResult += "|"+result.get(0) + ", " + result.get(1) + ", " + result.get(2);	
			}
			counter ++;
		}
		counter = 0;

		String smartResult = "";
		long smartLoadTime = 0;
		long smartExecutionTime = 0;
		long smartMemoryConsumption = 0;
		
		for(ArrayList<Long> result : smartData)
		{
			if (counter < disregard) {
				
			}
			else {
				smartLoadTime += result.get(0);
				smartExecutionTime += result.get(1);
				smartMemoryConsumption += result.get(2);
				smartResult += "|" + result.get(0) + ", " + result.get(1) + ", " + result.get(2);	
			}
			counter ++;
		}
		
		counter = 0;
		
		String greedyResult = "";
		long greedyLoadTime = 0;
		long greedyExecutionTime = 0;
		long greedyMemoryConsumption = 0;
		for(ArrayList<Long> result : greedyData)
		{
			if (counter < disregard) {
				
			}
			else {
				greedyLoadTime += result.get(0);
				greedyExecutionTime += result.get(1);
				greedyMemoryConsumption += result.get(2);
				
				greedyResult += "|" + result.get(0) + ", " + result.get(1) + ", " + result.get(2);	
			}
			counter ++;
			
		}
				
		System.out.println("Normal: " + normalResult);
		System.out.println("Smart: " + smartResult);
		System.out.println("Greedy: " + greedyResult);
		
		System.out.println("normal loading time average: " + normalLoadTime/(iteration-disregard));
		System.out.println("normal execution time average: " + normalExecutionTime/(iteration-disregard));
		System.out.println("normal memory consumption: " + normalMemoryConsumption/(iteration-disregard));
		
		System.out.println("smart loading time average: " + smartLoadTime/(iteration-disregard));
		System.out.println("smart execution time average: " + smartExecutionTime/(iteration-disregard));
		System.out.println("smart memory consumption: " + smartMemoryConsumption/(iteration-disregard));
		
		System.out.println("greedy loading time average: " + greedyLoadTime/(iteration-disregard));
		System.out.println("greedy execution time average: " + greedyExecutionTime/(iteration-disregard));
		System.out.println("greedy memory consumption: " + greedyMemoryConsumption/(iteration-disregard));
		
		try
		{
		    FileWriter writer = new FileWriter(file.substring(0, file.length()-4) + ".csv");
	 
		    writer.append("Normal loading time");
		    writer.append(',');
		    writer.append("Normal execution time");
		    writer.append(',');
		    writer.append("Normal memory consumption");
		    writer.append(',');
		    writer.append("Smart loading time");
		    writer.append(',');
		    writer.append("Smart execution time");
		    writer.append(',');
		    writer.append("Smart memory consumption");
		    writer.append(',');
		    writer.append("Greedy loading time");
		    writer.append(',');
		    writer.append("Greedy execution time");
		    writer.append(',');
		    writer.append("Greedy memory consumption");
		    writer.append('\n');
		    
		    writer.append(normalLoadTime/(iteration-disregard)+"");
		    writer.append(',');
		    writer.append(normalExecutionTime/(iteration-disregard)+"");
		    writer.append(',');
		    writer.append(normalMemoryConsumption/(iteration-disregard)+"");
		    writer.append(',');
		    writer.append(smartLoadTime/(iteration-disregard)+"");
		    writer.append(',');
		    writer.append(smartExecutionTime/(iteration-disregard)+"");
		    writer.append(',');
		    writer.append(smartMemoryConsumption/(iteration-disregard)+"");
		    writer.append(',');
		    writer.append(greedyLoadTime/(iteration-disregard)+"");
		    writer.append(',');
		    writer.append(greedyExecutionTime/(iteration-disregard)+"");
		    writer.append(',');
		    writer.append(greedyMemoryConsumption/(iteration-disregard)+"");
		    writer.append('\n');
	 
	 
		    writer.flush();
		    writer.close();
		}
		catch(IOException e)
		{
		     e.printStackTrace();
		} 
	
	}
	
	public static ArrayList<Long> testModel(String set, String file, int type) throws Exception
	{
		//prepare result
		ArrayList<Long> result = new ArrayList<Long>();
		//prepare eolModule
		EolModule eolModule = new EolModule();
		eolModule.parse(new File(file));
		
		//prepare model type
		String modelType = "";
		//prepare emf model
		EmfModel emfModel = null;
		
		
		if (type == 0) {
			emfModel = new EmfModel();
			modelType = "Normal";
		}
		if (type == 1) {
			emfModel = new EmfSmartModel();
			modelType = "Smart";
			
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
			((EmfSmartModel)emfModel).setModelContainers(loaContext.getModelContainers());
		}
		if (type == 2) {
			emfModel = new EmfGreedyModel();
			modelType = "Greedy";
		}
		
		emfModel.setName("DOM");
		emfModel.setMetamodelFile(new File("test/JDTAST.ecore").getAbsolutePath());
		emfModel.setModelFile(new File(set).getAbsolutePath());
		loadEPackageFromFile("test/JDTAST.ecore");

		System.out.println(modelType + " model prepared, loading...");
		
		long memoryConsumptionStart = Runtime.getRuntime().freeMemory();
		long init = System.nanoTime();
		
		emfModel.load();
		
		long result1 = (System.nanoTime()-init)/1000000;
		
		result.add(result1);
		System.out.println("(took ~" + result1 + "ms to load)");
		
		init = System.nanoTime();
		
		eolModule.getContext().getModelRepository().addModel(emfModel);
		eolModule.execute();
		
		long result2 = (System.nanoTime() - init)/1000000;
		result.add(result2);
		System.out.println("(took ~" + result2 + "ms to run)");
		
		long memoryConsumptionEnd = Runtime.getRuntime().freeMemory();
		
		result.add(memoryConsumptionStart-memoryConsumptionEnd);
		eolModule.getContext().getModelRepository().dispose();
		
		return result;
	}

	public static ArrayList<Long> testSmart(String set, String file) throws Exception
	{
		ArrayList<Long> result = new ArrayList<Long>();
		EolModule eolModule = new EolModule();
		eolModule.parse(new File(file));
		//eolModule.parse(new File("test/set2_50percent.eol"));
		
		EmfSmartModel smartModel = new EmfSmartModel();
		smartModel.setName("DOM");
		smartModel.setMetamodelFile(new File("test/JDTAST.ecore").getAbsolutePath());
		//smartModel.setModelFile(new File("test/set2.xmi").getAbsolutePath());
		smartModel.setModelFile(new File(set).getAbsolutePath());
		
		System.out.println("emf smart model prepared, loading...");
		
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
		System.out.println(loaContext.getModelContainers().get(0).getModelElementsAllOfKind().size() +loaContext.getModelContainers().get(1).getModelElementsAllOfKind().size());
		smartModel.setModelContainers(loaContext.getModelContainers());
		
		long memoryConsumptionStart = Runtime.getRuntime().freeMemory();
		
		long init = System.nanoTime();
		smartModel.load();
		long result1 = (System.nanoTime()-init)/1000000;
		result.add(result1);
		System.out.println("(took ~" + result1 + "ms to load)");
		
		init = System.nanoTime();
		eolModule.getContext().getModelRepository().addModel(smartModel);
		eolModule.execute();
		long result2 = (System.nanoTime() - init)/1000000;
		result.add(result2);
		System.out.println("(took ~" + result2 + "ms to run)");
		long memoryConsumptionEnd = Runtime.getRuntime().freeMemory();
		
		result.add(memoryConsumptionStart-memoryConsumptionEnd);
		eolModule.getContext().getModelRepository().dispose();
		return result;
	}
	
	public static ArrayList<Long> testNormal(String set, String file) throws Exception
	{
		ArrayList<Long> result = new ArrayList<Long>();
		EolModule eolModule = new EolModule();
		eolModule.parse(new File(file));
		//eolModule.parse(new File("test/set2_50percent.eol"));
		
		EmfModel normalModel = new EmfModel();
		normalModel.setName("DOM");
		normalModel.setMetamodelFile(new File("test/JDTAST.ecore").getAbsolutePath());
		normalModel.setModelFile(new File(set).getAbsolutePath());
		//normalModel.setModelFile(new File("test/set2.xmi").getAbsolutePath());
		
		loadEPackageFromFile("test/JDTAST.ecore");
		
		System.out.println("emf normal model prepared, loading...");
		
		long memoryConsumptionStart = Runtime.getRuntime().freeMemory();

		long init = System.nanoTime();
		normalModel.load();
		
		long result1 = (System.nanoTime()-init)/1000000;
		result.add(result1);
		System.out.println("(took ~" + result1 + "ms to load)");
		
		init = System.nanoTime();
		eolModule.getContext().getModelRepository().addModel(normalModel);
		eolModule.execute();
		
		long result2 = (System.nanoTime() - init)/1000000;
		result.add(result2);
		System.out.println("(took ~" + result2 + "ms to run)");
		
		long memoryConsumptionEnd = Runtime.getRuntime().freeMemory();
		
		result.add(memoryConsumptionStart-memoryConsumptionEnd);

		eolModule.getContext().getModelRepository().dispose();
		return result;
	}
	
	public static ArrayList<Long> testGreedy(String set, String file) throws Exception
	{
		ArrayList<Long> result = new ArrayList<Long>();
		EolModule eolModule = new EolModule();
		eolModule.parse(new File(file));
		//eolModule.parse(new File("test/set2_50percent.eol"));
		
		EmfGreedyModel normalModel = new EmfGreedyModel();
		normalModel.setName("DOM");
		normalModel.setMetamodelFile(new File("test/JDTAST.ecore").getAbsolutePath());
		normalModel.setModelFile(new File(set).getAbsolutePath());
		//normalModel.setModelFile(new File("test/set2.xmi").getAbsolutePath());
		
		loadEPackageFromFile("test/JDTAST.ecore");
		
		System.out.println("emf greedy model prepared, loading...");
		long memoryConsumptionStart = Runtime.getRuntime().freeMemory();

		long init = System.nanoTime();
		normalModel.load();
		
		long result1 = (System.nanoTime()-init)/1000000;
		result.add(result1);
		System.out.println("(took ~" + result1 + "ms to load)");
		
		init = System.nanoTime();
		eolModule.getContext().getModelRepository().addModel(normalModel);
		eolModule.execute();
		
		long result2 = (System.nanoTime() - init)/1000000;
		result.add(result2);
		System.out.println("(took ~" + result2 + "ms to run)");
		long memoryConsumptionEnd = Runtime.getRuntime().freeMemory();
		
		result.add(memoryConsumptionStart-memoryConsumptionEnd);

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
