package org.eclipse.epsilon.eol.performance.analysis.impl;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolDefaultVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.performance.analysis.context.OptimisationContext;

public class Optimiser {

	EolVisitorController<OptimisationContext, Object> controller = new EolVisitorController<OptimisationContext, Object>();
	OptimisationContext context = new OptimisationContext();
	
	public Optimiser()
	{
		System.out.println("Inside Optimiser");
		controller.addDefaultVisitor(new EolDefaultVisitor<OptimisationContext, Object>());
		
		controller.addModelDeclarationStatementVisitor(new ModelDeclarationStatementOptimiser());
		controller.addProgramVisitor(new ProgramOptimiser());
		controller.addBlockVisitor(new BlockOptimiser());
		controller.addFOLMethodCallExpressionVisitor(new FOLMethodCallExpressionOptimiser());
		controller.addMethodCallExpressionVisitor(new MethodCallExpressionOptimiser());
	}
	
	
	public void run(EolElement dom)
	{
		controller.visit(dom, context);
	}
	
	public OptimisationContext getOptimisationContext()
	{
		return context;
	}
	
}
