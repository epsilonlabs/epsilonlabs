package org.eclipse.epsilon.eol.performance.analysis.impl;

import java.io.File;
import java.net.URL;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.eol.metamodel.BinaryOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.EolPackage;
import org.eclipse.epsilon.eol.metamodel.EqualsOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.FOLMethodCallExpression;
import org.eclipse.epsilon.eol.metamodel.MethodCallExpression;
import org.eclipse.epsilon.eol.metamodel.ModelElementType;
import org.eclipse.epsilon.eol.metamodel.NameExpression;
import org.eclipse.epsilon.eol.metamodel.EolProgram;
import org.eclipse.epsilon.eol.metamodel.PropertyCallExpression;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.metamodel.visitor.EolProgramVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.performance.analysis.context.PerformanceAnalysisContext;
import org.eclipse.epsilon.eol.printer.EolElementPrinterFactory;
import org.eclipse.epsilon.epl.EplModule;
import org.eclipse.epsilon.epl.PatternMatch;
import org.eclipse.epsilon.epl.PatternMatchModel;

public class ProgramPerformanceAnalyser extends EolProgramVisitor<PerformanceAnalysisContext, Object>{

	InMemoryEmfModel model;
	
	
	
	@Override
	public Object visit(EolProgram program, PerformanceAnalysisContext context,
			EolVisitorController<PerformanceAnalysisContext, Object> controller) {
		// TODO Auto-generated method stub
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		Resource resource = resourceSet.createResource(URI.createFileURI(new File("test.xmi").getAbsolutePath()));
		resource.getContents().add(program);

		model = new InMemoryEmfModel("EOL",	program.eResource(), EolPackage.eINSTANCE);
		try {
			matchSelectPatterOne(program, context);
			matchSelectPatterTwo(program, context);
			matchSelectPatterThree(program, context);
			matchSelectPatterFour(program, context);
			matchSelectPatterFive(program, context);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void matchSelectPatterOne(EolProgram program, PerformanceAnalysisContext context) throws Exception
	{
		EplModule module = new EplModule();
		
		URL url = this.getClass().getProtectionDomain().getCodeSource().getLocation();
		
		String parent = url.getPath() + "src/patterns/patternOne.epl";
		
		module.parse(new File(parent));
		
		module.getContext().getModelRepository().addModel(model);
		
		PatternMatchModel patternMatchModel = (PatternMatchModel) module.execute();
		for(PatternMatch pm : patternMatchModel.getMatches())
		{
			String frn = pm.getPattern().getRoles().get(0).getNames().get(0);
			FOLMethodCallExpression fol = (FOLMethodCallExpression) pm.getRoleBinding(frn);
			NameExpression rhs = (NameExpression) ((EqualsOperatorExpression)fol.getConditions().get(0)).getRhs();
			PropertyCallExpression lhs = (PropertyCallExpression) pm.getRoleBinding("lhs");
			String propertyName = lhs.getProperty().getName();
			EClass lhsType = (EClass) ((ModelElementType)lhs.getTarget().getResolvedType()).getEcoreType();
			
			EReference eReference = (EReference) lhsType.getEStructuralFeature(propertyName);
			
			String opposite = eReference.getEOpposite().getName();
			
			if (fol.getMethod().getName().equals("select")) {
				context.getLogBook().addWarning(fol, "Expression should be read as: " + rhs.getName() + "." + opposite);
			}
			else if (fol.getMethod().getName().equals("selectOne")) {
				context.getLogBook().addWarning(fol, "Expression should be read as: " + rhs.getName() + "." + opposite + ".first");
			}	
		}
		System.out.println(patternMatchModel.getAllOfKind("PatternOne").size());
	}
	
	public void matchSelectPatterTwo(EolProgram program, PerformanceAnalysisContext context) throws Exception
	{
		EplModule module = new EplModule();
		
		URL url = this.getClass().getProtectionDomain().getCodeSource().getLocation();
		
		String parent = url.getPath() + "src/patterns/patternTwo.epl";
		
		module.parse(new File(parent));
		
		module.getContext().getModelRepository().addModel(model);
		
		PatternMatchModel patternMatchModel = (PatternMatchModel) module.execute();		
		
		for(PatternMatch pm : patternMatchModel.getMatches())
		{
			FOLMethodCallExpression fol = (FOLMethodCallExpression) pm.getRoleBinding("folcall");
			FOLMethodCallExpression targetfol = (FOLMethodCallExpression) pm.getRoleBinding("targetFOLCall");
			EolElementPrinterFactory factory = new EolElementPrinterFactory();
			
			context.getLogBook().addWarning(fol, "Sub-optimal expression, consider rewriting as: "+ factory.print(targetfol.getTarget()) + ".select("+ targetfol.getIterators().get(0).getName().getName() + "|" +  factory.print(targetfol.getConditions()) + "and" + factory.print(fol.getConditions()) + ")");
		}
		System.out.println(patternMatchModel.getAllOfKind("PatternTwo").size());
	}
	
	public void matchSelectPatterThree(EolProgram program, PerformanceAnalysisContext context) throws Exception
	{
		EplModule module = new EplModule();
		
		URL url = this.getClass().getProtectionDomain().getCodeSource().getLocation();
		
		String parent = url.getPath() + "src/patterns/patternThree.epl";
		
		module.parse(new File(parent));
		
		module.getContext().getModelRepository().addModel(model);
		
		PatternMatchModel patternMatchModel = (PatternMatchModel) module.execute();
		
		for(PatternMatch pm : patternMatchModel.getMatches())
		{
			FOLMethodCallExpression fol = (FOLMethodCallExpression) pm.getRoleBinding("folcall");
			EolElementPrinterFactory factory = new EolElementPrinterFactory();
			
			context.getLogBook().addWarning(fol, "Expression should be read as: "+ factory.print(fol.getTarget()) + ".selectOne("+ fol.getIterators().get(0).getName().getName() + "|" + factory.print(fol.getConditions()) + ")");
		}
		System.out.println(patternMatchModel.getAllOfKind("PatternThree").size());
	}
	
	public void matchSelectPatterFour(EolProgram program, PerformanceAnalysisContext context) throws Exception
	{
		EplModule module = new EplModule();
		
		URL url = this.getClass().getProtectionDomain().getCodeSource().getLocation();
		
		String parent = url.getPath() + "src/patterns/patternFour.epl";
		
		module.parse(new File(parent));
		
		module.getContext().getModelRepository().addModel(model);
		
		PatternMatchModel patternMatchModel = (PatternMatchModel) module.execute();
		for(PatternMatch pm : patternMatchModel.getMatches())
		{
			FOLMethodCallExpression fol = (FOLMethodCallExpression) pm.getRoleBinding("folMethodCall");
			BinaryOperatorExpression binaryOperatorExpression = (BinaryOperatorExpression) pm.getRoleBinding("binaryOperatorExpression");
			EolElementPrinterFactory factory = new EolElementPrinterFactory();
			
			context.getLogBook().addWarning(binaryOperatorExpression, "Expression should be read as: "+ factory.print(fol.getTarget()) + ".exists("+ fol.getIterators().get(0).getName().getName() + "|" + factory.print(fol.getConditions()) + ")");
		}
		System.out.println(patternMatchModel.getAllOfKind("PatternFour").size());
	}
	
	public void matchSelectPatterFive(EolProgram program, PerformanceAnalysisContext context) throws Exception
	{
		EplModule module = new EplModule();
		
		URL url = this.getClass().getProtectionDomain().getCodeSource().getLocation();
		
		String parent = url.getPath() + "src/patterns/patternFive.epl";
		
		module.parse(new File(parent));
		
		module.getContext().getModelRepository().addModel(model);
		
		PatternMatchModel patternMatchModel = (PatternMatchModel) module.execute();
		for(PatternMatch pm : patternMatchModel.getMatches())
		{
			FOLMethodCallExpression fol = (FOLMethodCallExpression) pm.getRoleBinding("folcall");
			MethodCallExpression methodCallExpression = (MethodCallExpression) pm.getRoleBinding("methodCall");
			EolElementPrinterFactory factory = new EolElementPrinterFactory();
			
			context.getLogBook().addWarning(methodCallExpression, "Expression should be read as: "+ factory.print(fol.getTarget()) + ".selectOne("+ fol.getIterators().get(0).getName().getName() + "|" + factory.print(fol.getConditions()) + ")");
		}
		System.out.println(patternMatchModel.getAllOfKind("PatternFive").size());
	}
	
}
