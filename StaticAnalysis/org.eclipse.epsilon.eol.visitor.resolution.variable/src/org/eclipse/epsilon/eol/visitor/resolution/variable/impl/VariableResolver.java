package org.eclipse.epsilon.eol.visitor.resolution.variable.impl;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolDefaultVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.visitor.resolution.variable.context.VariableResolutionContext;

public class VariableResolver {

	protected EolVisitorController<VariableResolutionContext, Object> controller = new EolVisitorController<VariableResolutionContext, Object>();
	protected VariableResolutionContext context = new VariableResolutionContext();
	
	public VariableResolver()
	{
		controller.addImportVisitor(new ImportVariableResolver());
		controller.addEolProgramVisitor(new ProgramVariableResolver());
		controller.addDefaultVisitor(new EolDefaultVisitor<VariableResolutionContext, Object>());
		controller.addVariableDeclarationExpressionVisitor(new VariableDeclarationExpressionVariableResolver());
		controller.addFormalParameterExpressionVisitor(new FormalParameterExpressionVariableResolver());
		controller.addNameExpressionVisitor(new NameExpressionVariableResolver());
		controller.addForStatementVisitor(new ForStatementVariableResolver());
		controller.addIfStatementVisitor(new IfStatementVariableResolver());
		controller.addSwitchCaseDefaultStatementVisitor(new SwitchCaseDefaultStatementVariableResolver());
		controller.addSwitchStatementVisitor(new SwitchStatementVariableResolver());
		controller.addSwitchCaseExpressionStatementVisitor(new SwitchCaseExpressionStatementVariableResolver());
		controller.addWhileStatementVisitor(new WhileStatementVariableResolver());
		controller.addOperationDefinitionVisitor(new OperationDefinitionVariableResolver());
		controller.addFOLMethodCallExpressionVisitor(new FOLMethodCallExpressionVariableResolver());
		
	}
	
	public void run(EolElement dom)
	{
		controller.visit(dom, context);
	}
	
	public VariableResolutionContext getVariableResolutionContext()
	{
		return context;
	}
	
}
