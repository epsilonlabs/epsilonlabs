package org.eclipse.epsilon.eol.visitor.resolution.type.impl;

import org.eclipse.epsilon.eol.metamodel.TransactionStatement;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.TransactionStatementVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.context.TypeResolutionContext;

public class TransactionStatementTypeResolver extends TransactionStatementVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(TransactionStatement transactionStatement,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		// TODO Auto-generated method stub
//		if (context.getPessimistic()) {
//			context.getStack().push(transactionStatement, true);
//		}

		controller.visit(transactionStatement.getBody(), context);
//		if (context.getPessimistic()) {
//			context.getStack().pop();
//		}

		return null;
	}

}
