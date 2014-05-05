package org.eclipse.epsilon.eol.visitor.resolution.type.standard.library.collection.handlers.old;


import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.visitor.resolution.type.context.TypeResolutionContext;


public class ClearHandler {

	public void handle(MethodCallExpression methodCall, TypeResolutionContext context)
	{
		if (methodCall.getArguments().size() == 0) { //there should be no arguments
			methodCall.setResolvedType(null); //clear() does not have a return type
		}
		else {
			//handle arguments number incorrect
		}
	}

}
