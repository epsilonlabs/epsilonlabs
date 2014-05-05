package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class ModelDeclarationStatementVisitor<T, R> {
	
	public boolean appliesTo(ModelDeclarationStatement modelDeclarationStatement, T context) {
		return true;
	}
	
	public abstract R visit (ModelDeclarationStatement modelDeclarationStatement, T context, EolVisitorController<T, R> controller);
	
}
