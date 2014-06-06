package org.eclipse.epsilon.eol.visitor.resolution.variable.impl;

import org.eclipse.epsilon.eol.metamodel.TransactionStatement;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.TransactionStatementVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.variable.context.VariableResolutionContext;

public class TransactionStatementVariableResolver extends TransactionStatementVisitor<VariableResolutionContext, Object>{

	@Override
	public Object visit(TransactionStatement transactionStatement,
			VariableResolutionContext context,
			EolVisitorController<VariableResolutionContext, Object> controller) {
		
		context.getStack().push(transactionStatement, true);
		controller.visit(transactionStatement.getBody(), context);
		context.getStack().pop();
		
		return null;
	}

}
