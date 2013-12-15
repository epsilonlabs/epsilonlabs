package org.eclipse.epsilon.eol.dom.visitor.resolution.type.standard.library.collection.handlers.old;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.EolFactory;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.context.TypeUtil;

public class LibraryOperationHandlerContext {

	protected EolFactory eolFactory;
	protected LibraryOperationHandlerFactory opFactory;
	protected TypeUtil typeUtil;
	
	public LibraryOperationHandlerContext(EolFactory eolFactory)
	{
		this.eolFactory = eolFactory;
	}
	
	public LibraryOperationHandlerFactory getHandlerFactory()
	{
		return opFactory;
	}
	
	public EolFactory getEolFactory()
	{
		return eolFactory;
	}
	
	public TypeUtil getTypeUtil()
	{
		return typeUtil;
	}
	
	public void setAssets(DomElement obj, DomElement container)
	{
		obj.setLine(container.getLine());
		obj.setColumn(container.getColumn());
		obj.setContainer(container);
	}
	
}
