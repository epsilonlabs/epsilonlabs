package org.eclipse.epsilon.eol.performance.analysis.impl;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolDefaultVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.performance.analysis.context.PerformanceAnalysisContext;

public class PerformanceAnalyser {

	EolVisitorController<PerformanceAnalysisContext, Object> controller = new EolVisitorController<PerformanceAnalysisContext, Object>();
	PerformanceAnalysisContext context = new PerformanceAnalysisContext();
	
	public PerformanceAnalyser()
	{
		System.out.println("Inside Optimiser");
		controller.addDefaultVisitor(new EolDefaultVisitor<PerformanceAnalysisContext, Object>());
		
		controller.addModelDeclarationStatementVisitor(new ModelDeclarationStatementOptimiser());
		//controller.addProgramVisitor(new ProgramOptimiser());
		controller.addProgramVisitor(new ProgramPerformanceAnalyser());
		controller.addBlockVisitor(new BlockOptimiser());
		controller.addFOLMethodCallExpressionVisitor(new FOLMethodCallExpressionOptimiser());
		controller.addMethodCallExpressionVisitor(new MethodCallExpressionOptimiser());
	}
	
	
	public void run(EolElement dom)
	{
		controller.visit(dom, context);
	}
	
	public PerformanceAnalysisContext getOptimisationContext()
	{
		return context;
	}
	
}
