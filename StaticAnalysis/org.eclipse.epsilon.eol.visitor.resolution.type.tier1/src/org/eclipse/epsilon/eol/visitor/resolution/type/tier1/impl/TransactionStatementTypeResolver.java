package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import org.eclipse.epsilon.eol.metamodel.TransactionStatement;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.TransactionStatementVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class TransactionStatementTypeResolver extends TransactionStatementVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(TransactionStatement transactionStatement,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		controller.visit(transactionStatement.getBody(), context);
		return null;
	}

}
