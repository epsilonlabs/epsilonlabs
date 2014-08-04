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
		
//		controller.addModelDeclarationStatementVisitor(new ModelDeclarationStatementOptimiser());
		controller.addEolProgramVisitor(new ProgramPerformanceAnalyser());
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
