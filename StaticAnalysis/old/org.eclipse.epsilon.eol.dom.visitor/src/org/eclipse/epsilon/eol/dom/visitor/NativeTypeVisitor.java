package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class NativeTypeVisitor<T, R> {
	
	public boolean appliesTo(NativeType nativeType, T context) {
		return true;
	}
	
	public abstract R visit (NativeType nativeType, T context, EolVisitorController<T, R> controller);
	
}
