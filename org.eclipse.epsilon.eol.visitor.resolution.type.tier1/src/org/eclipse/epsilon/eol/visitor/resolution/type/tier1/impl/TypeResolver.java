package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import org.eclipse.epsilon.eol.metamodel.EOLElement;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class TypeResolver {

	protected EolVisitorController<TypeResolutionContext, Object> controller = new EolVisitorController<TypeResolutionContext, Object>();
	protected TypeResolutionContext context = TypeResolutionContext.getInstance();
	
	public TypeResolver()
	{
	}
	
	public void run(EOLElement eolElement)
	{
		controller.visit(eolElement, context);
	}
	
	public TypeResolutionContext getTypeResolutionContext()
	{
		return context;
	}
}
