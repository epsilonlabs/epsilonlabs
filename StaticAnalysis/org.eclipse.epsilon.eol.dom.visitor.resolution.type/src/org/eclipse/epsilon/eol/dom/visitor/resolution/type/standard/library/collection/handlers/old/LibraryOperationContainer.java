package org.eclipse.epsilon.eol.dom.visitor.resolution.type.standard.library.collection.handlers.old;

import java.util.ArrayList;

import org.eclipse.epsilon.eol.dom.Type;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.context.TypeUtil;

public class LibraryOperationContainer {

	protected ArrayList<LibraryOperationHandler> handlers;
	protected TypeUtil typeUtil;
	protected LibraryOperationHandlerContext context;
	
	public LibraryOperationContainer(TypeUtil typeUtil)
	{
		handlers = new ArrayList<LibraryOperationHandler>();
		handlers.addAll(context.getHandlerFactory().getAllOperationHandlers());
		this.typeUtil = typeUtil;
	}
	
	
	public boolean containsOperation(String name, Type contextType, ArrayList<Type> argTypes)
	{
		boolean result = false;
		for(LibraryOperationHandler handler: handlers)
		{
			if (handler.getName().equals(name)) {
				if (typeUtil.isTypeEqual(handler.getContextType(), contextType)) {
					if (handler.getArgTypes().size() == argTypes.size()) {
						if (handler.getArgTypes().size() == 0) {
							result = true;
							return result;
						}
						else {
							for (int i = 0; i < handler.getArgTypes().size(); i++) {
								Type a = handler.getArgTypes().get(i);
								Type b = argTypes.get(i);
								result = typeUtil.isEqualOrGeneric(a, b);
								if (!result) {
									break;
								}
							}
							if (result) {
								return true;
							}
						}
					}
				}
			}
		}		
		return result;
	}
	
	//get the operation which is most feasible in terms of contextType
	public LibraryOperationHandler getOperation(String name, Type contextType, ArrayList<Type> argTypes)
	{
		ArrayList<LibraryOperationHandler> list = getHandlers(name, argTypes);
		if (list == null) {
			return null;
		}
		else {
			int index = -1;
			int depth = 999;
			for (int i = 0; i < list.size(); i++) {
				LibraryOperationHandler handler = list.get(i);
				int distance = typeUtil.shortestDistanceBetweenObject(contextType, handler.getContextType());
				if (distance < depth) {
					depth = distance;
					index = i;
				}
			}

			return list.get(index);
		}		
	}
	
	public ArrayList<LibraryOperationHandler> getHandlers(String name, ArrayList<Type> argTypes)
	{
		ArrayList<LibraryOperationHandler> result = new ArrayList<LibraryOperationHandler>();//initialise the result
		for(LibraryOperationHandler handler: handlers) //for every operation
		{
			if(handler.getName().equals(name)) //if name is the same
			{
				if (handler.getArgTypes().size() == argTypes.size()) { //if same argument type
					if (handler.getArgTypes().size() == 0) { //if argument size is 0
						result.add(handler); //add to result
					}
					else {
						boolean compare = false; //flag
						for (int i = 0; i < handler.getArgTypes().size(); i++) { //for each parameter
							Type a = handler.getArgTypes().get(i); //get parameter type
							Type b = argTypes.get(i); //get arg type
							compare = typeUtil.isEqualOrGeneric(a, b); //determine if the types are same or generically related
							if (!compare) { //if not
								break; //break
							}
						}
						if (compare) { //if compare is true then the signature is identical
							result.add(handler); //add to result
						}
					}
				}
			}
		}
		if (result.size()!=0) { //if result is not empty
			return result; //return
		}
		else {
			return null;
		}
	}
}
