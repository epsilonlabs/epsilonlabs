package org.eclipse.epsilon.eol.dom.visitor.resolution.type.standard.library.collection.handlers.old;

import java.util.ArrayList;

import org.eclipse.epsilon.eol.metamodel.*;

public abstract class LibraryOperationHandler {

	
	protected Object location; //used to store the location of a library operation
	protected String name;
	protected Type contextType;
	protected ArrayList<Type> argTypes;
	protected Type returnType;
		
	public abstract void handle(MethodCallExpression call, LibraryOperationHandlerContext context);
	
	public String getName()
	{
		return name;
	}
	
	public Type getContextType()
	{
		return contextType;
	}
	
	public ArrayList<Type> getArgTypes()
	{
		return argTypes;
	}
	
	public Type getReturnType()
	{
		return returnType;
	}
	
}
