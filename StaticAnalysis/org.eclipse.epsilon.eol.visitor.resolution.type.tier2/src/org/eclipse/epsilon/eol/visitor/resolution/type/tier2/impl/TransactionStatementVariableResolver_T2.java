package org.eclipse.epsilon.eol.visitor.resolution.type.tier2.impl;

import org.eclipse.epsilon.eol.metamodel.NameExpression;
import org.eclipse.epsilon.eol.metamodel.TransactionStatement;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.TransactionStatementVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier2.context.TypeResolutionContext_T2;

public class TransactionStatementVariableResolver_T2 extends TransactionStatementVisitor<TypeResolutionContext_T2, Object>{

	@Override
	public Object visit(TransactionStatement transactionStatement,
			TypeResolutionContext_T2 context,
			EolVisitorController<TypeResolutionContext_T2, Object> controller) {
		
		//visit the transaction name(s)
		for(NameExpression ne: transactionStatement.getNames())
		{
			controller.visit(ne, context);
		}
		//push to stack
		context.getStack().push(transactionStatement, true);
		//visit the body
		controller.visit(transactionStatement.getBody(), context);
		//pop from stack
		context.getStack().pop();
		
		return null;
	}


}
