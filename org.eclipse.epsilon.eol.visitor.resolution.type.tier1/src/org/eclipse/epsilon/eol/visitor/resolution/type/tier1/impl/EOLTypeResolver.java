package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import org.eclipse.epsilon.eol.metamodel.EOLElement;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class EOLTypeResolver {

	protected EolVisitorController<TypeResolutionContext, Object> controller = new EolVisitorController<TypeResolutionContext, Object>();
	protected TypeResolutionContext context = new TypeResolutionContext();
	
	public EOLTypeResolver()
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
