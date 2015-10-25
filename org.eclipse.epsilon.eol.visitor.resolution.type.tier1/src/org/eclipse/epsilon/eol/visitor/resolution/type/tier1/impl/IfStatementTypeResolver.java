package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import org.eclipse.epsilon.eol.metamodel.ExpressionOrStatementBlock;
import org.eclipse.epsilon.eol.metamodel.IfStatement;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.IfStatementVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class IfStatementTypeResolver extends IfStatementVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(IfStatement ifStatement, TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		context.getTypeRegistry().pushScope(ifStatement.getIfBody());//////////
		
		context.setHandlingBranchCondition(true);
		controller.visit(ifStatement.getCondition(), context);
		context.setHandlingBranchCondition(false);
		
		controller.visit(ifStatement.getIfBody(), context);
		context.getTypeRegistry().popScope();//////////
		
		for(ExpressionOrStatementBlock eosb: ifStatement.getElseIfBodies())
		{
			context.getTypeRegistry().pushScope(eosb);
			controller.visit(eosb, context);
			context.getTypeRegistry().popScope();
		}
		
		if (ifStatement.getElseBody() != null) {
			context.getTypeRegistry().pushScope(ifStatement.getElseBody());
			controller.visit(ifStatement.getElseBody(), context);
			context.getTypeRegistry().popScope();
		}
		return null;
	}

}
