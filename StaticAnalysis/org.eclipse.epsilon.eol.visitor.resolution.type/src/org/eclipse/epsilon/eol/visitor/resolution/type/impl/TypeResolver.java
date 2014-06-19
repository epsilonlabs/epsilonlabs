package org.eclipse.epsilon.eol.visitor.resolution.type.impl;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolDefaultVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.visitor.resolution.type.context.TypeResolutionContext;

public class TypeResolver {

	protected EolVisitorController<TypeResolutionContext, Object> controller = new EolVisitorController<TypeResolutionContext, Object>();
	protected TypeResolutionContext context = new TypeResolutionContext();
	
	public TypeResolver()
	{
		controller.addImportVisitor(new ImportTypeResolver());
		controller.addDefaultVisitor(new EolDefaultVisitor<TypeResolutionContext, Object>());
		controller.addEolProgramVisitor(new ProgramTypeResolver());
		controller.addBlockVisitor(new BlockTypeResolver());
		controller.addOperationDefinitionVisitor(new OperationDefinitionTypeResolver());
		controller.addReturnStatementVisitor(new ReturnStatementTypeResolver());

		controller.addAssignmentStatementVisitor(new AssignmentStatementTypeResolver());
		controller.addIfStatementVisitor(new IfStatementTypeResolver());
		controller.addForStatementVisitor(new ForStatementTypeResolver());
		controller.addWhileStatementVisitor(new WhileStatementTypeResolver());
		controller.addSwitchStatementVisitor(new SwitchStatementTypeResolver());
		controller.addModelDeclarationStatementVisitor(new ModelDeclarationStatementTypeResolver());

		controller.addEnumerationLiteralExpressionVisitor(new EnumerationLiteralExpressionTypeResolver());
		controller.addNameExpressionVisitor(new NameExpressionTypeResolver());
		controller.addPropertyCallExpressionVisitor(new PropertyCallExpressionTypeResolver());
		controller.addMethodCallExpressionVisitor(new MethodCallExpressionTypeResolver());
		controller.addBinaryOperatorExpressionVisitor(new LogicalOperatorExpressionTypeResolver());
		controller.addPlusOperatorExpressionVisitor(new PlusOperatorExpressionTypeResolver());
		controller.addMinusOperatorExpressionVisitor(new MinusOperatorExpressionTypeResolver());
		controller.addNotOperatorExpressionVisitor(new NotOperatorExpressionTypeResolver());
		controller.addNegativeOperatorExpressionVisitor(new NegativeOperatorExpressionTypeResolver());
		
		controller.addSimpleAnnotationVisitor(new SimpleAnnotationTypeResolver());
		
		controller.addModelElementTypeVisitor(new ModelElementTypeTypeResolver());
		controller.addFOLMethodCallExpressionVisitor(new FOLMethodCallExpressionTypeResolver());
		controller.addVariableDeclarationExpressionVisitor(new VariableDeclarationExpressionTypeResolver());
		controller.addFormalParameterExpressionVisitor(new FormalParameterExpressionTypeResolver());
		controller.addTransactionStatementVisitor(new TransactionStatementTypeResolver());

		controller.addCollectionExpressionVisitor(new CollectionExpressionTypeResolver());
		controller.addExpressionOrStatementBlockVisitor(new ExpressionOrStatementBlockTypeResolver());
	}
	
	public void run(EolElement eolElement)
	{
		controller.visit(eolElement, context);
	}
	
	public TypeResolutionContext getTypeResolutionContext()
	{
		return context;
	}
}
