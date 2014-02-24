package org.eclipse.epsilon.eol.dom.visitor.optimisation.impl;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.visitor.EolDefaultVisitor;
import org.eclipse.epsilon.eol.dom.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.dom.visitor.optimisation.context.OptimisationContext;

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
	
	
	public void run(DomElement dom)
	{
		controller.visit(dom, context);
	}
	
	public OptimisationContext getOptimisationContext()
	{
		return context;
	}
	
}
