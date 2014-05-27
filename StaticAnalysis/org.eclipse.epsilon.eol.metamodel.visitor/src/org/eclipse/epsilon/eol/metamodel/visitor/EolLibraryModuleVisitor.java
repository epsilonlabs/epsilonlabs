package org.eclipse.epsilon.eol.metamodel.visitor;

import org.eclipse.epsilon.eol.metamodel.*;

public abstract class EolLibraryModuleVisitor<T, R> {
	
	public boolean appliesTo(EolLibraryModule eolLibraryModule, T context) {
		return true;
	}
	
	public abstract R visit (EolLibraryModule eolLibraryModule, T context, EolVisitorController<T, R> controller);
	
}
