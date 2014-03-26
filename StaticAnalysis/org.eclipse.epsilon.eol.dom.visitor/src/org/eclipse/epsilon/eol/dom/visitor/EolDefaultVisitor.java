package org.eclipse.epsilon.eol.dom.visitor;

import org.eclipse.emf.ecore.EObject;

public class EolDefaultVisitor<T, R> {
	
	public boolean appliesTo (EObject o, T context) {
		return true;
	}
	
	public R visit (EObject o, T context, EolVisitorController<T, R> controller) {
		
		for (EObject content : o.eContents()) {
			controller.visit(content, context);
		}
		
		return null;
	}
	
}
