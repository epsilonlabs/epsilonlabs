package org.eclipse.epsilon.eol.dom.visitor.resolution.type.impl;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.visitor.EolDefaultVisitor;
import org.eclipse.epsilon.eol.dom.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.context.TypeResolutionContext;

public class TypeResolver {

	EolVisitorController<TypeResolutionContext, Object> controller = new EolVisitorController<TypeResolutionContext, Object>();
	TypeResolutionContext context = new TypeResolutionContext();
	
	public TypeResolver()
	{
		controller.addImportVisitor(new ImportTypeResolver());
		controller.addDefaultVisitor(new EolDefaultVisitor<TypeResolutionContext, Object>());
		controller.addProgramVisitor(new ProgramTypeResolver());
		controller.addBlockVisitor(new BlockTypeResolver());
		controller.addOperationDefinitionVisitor(new OperationDefinitionTypeResolver());
		controller.addReturnStatementVisitor(new ReturnStatementTypeResolver());

		controller.addAssignmentStatementVisitor(new AssignmentStatementTypeResolver());
		controller.addIfStatementVisitor(new IfStatementTypeResolver());
		controller.addForStatementVisitor(new ForStatementTypeResolver());
		controller.addWhileStatementVisitor(new WhileStatementTypeResolver());
		controller.addSwitchStatementVisitor(new SwitchStatementTypeResolver());
		controller.addModelDeclarationStatementVisitor(new ModelDeclarationStatementTypeResolver());

		controller.addNameExpressionVisitor(new NameExpressionTypeResolver());
		controller.addPropertyCallExpressionVisitor(new PropertyCallExpressionTypeResolver());
		controller.addMethodCallExpressionVisitor(new MethodCallExpressionTypeResolver());
		controller.addBinaryOperatorExpressionVisitor(new LogicalOperatorExpressionTypeResolver());
		controller.addPlusOperatorExpressionVisitor(new PlusOperatorExpressionTypeResolver());
		controller.addMinusOperatorExpressionVisitor(new MinusOperatorExpressionTypeResolver());
		controller.addNotOperatorExpressionVisitor(new NotOperatorExpressionTypeResolver());
		controller.addNegativeOperatorExpressionVisitor(new NegativeOperatorExpressionTypeResolver());
		
		controller.addModelElementTypeVisitor(new ModelElementTypeTypeResolver());
		controller.addFOLMethodCallExpressionVisitor(new FOLMethodCallExpressionTypeResolver());
		controller.addVariableDeclarationExpressionVisitor(new VariableDeclarationExpressionTypeResolver());
		controller.addFormalParameterExpressionVisitor(new FormalParameterExpressionTypeResolver());

	}
	
	public void run(DomElement dom)
	{
		controller.visit(dom, context);
	}
	
	public TypeResolutionContext getTypeResolutionContext()
	{
		return context;
	}
}
