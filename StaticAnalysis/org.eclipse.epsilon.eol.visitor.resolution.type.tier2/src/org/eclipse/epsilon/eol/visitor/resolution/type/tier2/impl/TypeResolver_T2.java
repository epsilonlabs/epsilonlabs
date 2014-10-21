package org.eclipse.epsilon.eol.visitor.resolution.type.tier2.impl;

import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.visitor.EolDefaultVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier2.context.TypeResolutionContext_T2;

public class TypeResolver_T2 {


	protected EolVisitorController<TypeResolutionContext_T2, Object> controller = new EolVisitorController<TypeResolutionContext_T2, Object>();
	protected TypeResolutionContext_T2 context = new TypeResolutionContext_T2();
	
	public TypeResolver_T2()
	{
		controller.addEolProgramVisitor(new EolProgramTypeResolver_T2());
		controller.addForStatementVisitor(new ForStatementTypeResolver_T2());
		controller.addIfStatementVisitor(new IfStatementTypeResolver_T2());
		controller.addOperationDefinitionVisitor(new OperationDefinitionTypeResolver_T2());
		controller.addSwitchCaseDefaultStatementVisitor(new SwitchCaseDefaultStatementTypeResolver_T2());
		controller.addSwitchCaseExpressionStatementVisitor(new SwitchCaseExpressionStatementTypeResolver_T2());
		controller.addSwitchStatementVisitor(new SwitchStatementTypeResolver_T2());
		controller.addTransactionStatementVisitor(new TransactionStatementVariableResolver_T2());
		controller.addWhileStatementVisitor(new WhileStatementTypeResolver_T2());
		controller.addNameExpressionVisitor(new NameExpressionTypeResolver_T2());
		controller.addVariableDeclarationExpressionVisitor(new VariableDeclarationExpressionTypeResolver_T2());
		controller.addDefaultVisitor(new EolDefaultVisitor<TypeResolutionContext_T2, Object>());
	
		controller.addBinaryOperatorExpressionVisitor(new LogicalOperatorExpressionTypeResolver());
		controller.addPlusOperatorExpressionVisitor(new PlusOperatorExpressionTypeResolver());
		controller.addMinusOperatorExpressionVisitor(new MinusOperatorExpressionTypeResolver());
		controller.addNotOperatorExpressionVisitor(new NotOperatorExpressionTypeResolver());
		controller.addNegativeOperatorExpressionVisitor(new NegativeOperatorExpressionTypeResolver());
		controller.addMethodCallExpressionVisitor(new MethodCallExpressionTypeResolver());
		
	}
	
	public void run(EolElement eolElement)
	{
		controller.visit(eolElement, context);
	}

	public TypeResolutionContext getTypeResolutionContext() {
		return context;
	}
	
	
	
}
