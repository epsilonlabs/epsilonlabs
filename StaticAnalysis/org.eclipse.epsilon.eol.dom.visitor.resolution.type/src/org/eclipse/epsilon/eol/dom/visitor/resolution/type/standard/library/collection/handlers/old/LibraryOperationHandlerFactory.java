package org.eclipse.epsilon.eol.dom.visitor.resolution.type.standard.library.collection.handlers.old;

import java.util.ArrayList;

public class LibraryOperationHandlerFactory {

	protected LibraryOperationHandlerContext context;
	
	public ArrayList<LibraryOperationHandler> getAllOperationHandlers()
	{
		ArrayList<LibraryOperationHandler> result = new ArrayList<LibraryOperationHandler>();
		result.addAll(getAnyTypeOperationHandlers());
		
		return result;
	}
	
	public ArrayList<LibraryOperationHandler> getAnyTypeOperationHandlers()
	{
		ArrayList<LibraryOperationHandler> result = new ArrayList<LibraryOperationHandler>();
		result.add(new IsDefinedHandler(context));
		
		return result;
	}
}
