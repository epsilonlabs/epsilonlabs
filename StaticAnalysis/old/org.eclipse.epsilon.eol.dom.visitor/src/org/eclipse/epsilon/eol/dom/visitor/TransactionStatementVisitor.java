package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class TransactionStatementVisitor<T, R> {
	
	public boolean appliesTo(TransactionStatement transactionStatement, T context) {
		return true;
	}
	
	public abstract R visit (TransactionStatement transactionStatement, T context, EolVisitorController<T, R> controller);
	
}
