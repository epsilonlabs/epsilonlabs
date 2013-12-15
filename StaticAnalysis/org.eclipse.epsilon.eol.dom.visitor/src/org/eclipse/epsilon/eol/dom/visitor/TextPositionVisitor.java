package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.epsilon.eol.dom.*;

public abstract class TextPositionVisitor<T, R> {
	
	public boolean appliesTo(TextPosition textPosition, T context) {
		return true;
	}
	
	public abstract R visit (TextPosition textPosition, T context, EolVisitorController<T, R> controller);
	
}
