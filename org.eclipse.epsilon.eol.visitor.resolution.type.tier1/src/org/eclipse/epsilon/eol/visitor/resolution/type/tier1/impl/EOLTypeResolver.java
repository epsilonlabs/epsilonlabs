package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import org.eclipse.epsilon.eol.metamodel.EOLElement;
import org.eclipse.epsilon.eol.metamodel.visitor.EolDefaultVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.AnalysisInterruptException;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class EOLTypeResolver {

	protected EolVisitorController<TypeResolutionContext, Object> controller = new EolVisitorController<TypeResolutionContext, Object>();
	protected TypeResolutionContext context = TypeResolutionContext.getInstance(true);
	protected boolean debug = false;
	
	public EOLTypeResolver()
	{
		controller.addExpressionStatementVisitor(new ExpressionStatementTypeResolver());
		controller.addImportVisitor(new ImportTypeResolver());
		controller.addDefaultVisitor(new EolDefaultVisitor<TypeResolutionContext, Object>());
		controller.addEOLProgramVisitor(new EOLProgramTypeResolver());
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
		controller.addFOLMethodCallExpressionVisitor(new FOLMethodCallExpressionTypeResolver());
		
		controller.addBinaryOperatorExpressionVisitor(new LogicalOperatorExpressionTypeResolver());
		controller.addPlusOperatorExpressionVisitor(new PlusOperatorExpressionTypeResolver());
		controller.addMinusOperatorExpressionVisitor(new MinusOperatorExpressionTypeResolver());
		controller.addMultiplyOperatorExpressionVisitor(new MultiplyOperatorExpressionTypeResolver());
		controller.addDivideOperatorExpressionVisitor(new DivideOperatorExpressionTypeResolver());
		controller.addNotOperatorExpressionVisitor(new NotOperatorExpressionTypeResolver());
		controller.addNegativeOperatorExpressionVisitor(new NegativeOperatorExpressionTypeResolver());
		
		controller.addSimpleAnnotationStatementVisitor(new SimpleAnnotationStatementTypeResolver());
		
		controller.addModelElementTypeVisitor(new ModelElementTypeResolver());
		controller.addVariableDeclarationExpressionVisitor(new VariableDeclarationExpressionTypeResolver());
		controller.addFormalParameterExpressionVisitor(new FormalParameterExpressionTypeResolver());
		controller.addTransactionStatementVisitor(new TransactionStatementTypeResolver());

		controller.addCollectionExpressionVisitor(new CollectionExpressionTypeResolver());
		controller.addExpressionOrStatementBlockVisitor(new ExpressionOrStatementBlockTypeResolver());
		controller.addMapExpressionVisitor(new MapExpressionTypeResolver());
		controller.addNewExpressionVisitor(new NewExpressionTypeResolver());
	}
	
	public void run(EOLElement eolElement)
	{
		if (debug) {
			controller.visit(eolElement, context);
		}
		else {
			try{
				controller.visit(eolElement, context);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				if (!(e instanceof AnalysisInterruptException)) {
					//e.printStackTrace();
				}
			}
		}
	}
	
	public TypeResolutionContext getTypeResolutionContext()
	{
		return context;
	}
}
