package org.eclipse.epsilon.eol.visitor.resolution.type.standard.library.collection.handlers.old;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.visitor.resolution.type.context.TypeResolutionContext;

public class RemoveAllHandler {
	
	public void handle(MethodCallExpression methodCall, TypeResolutionContext context)
	{
		if (methodCall.getArguments().size() == 1) { //there should only be one argument
			CollectionType targetType = (CollectionType) methodCall.getTarget().getResolvedType(); //obtain target type, at this stage, preliminary examination should already have the conclusion that the type is of type Collection
			Type contentType = targetType.getContentType(); //obtain content type from the collection
			
			if (contentType == null) {
				//this means the operation is performed on a collection of any, so no need for further actions
			}
			else {
				LiteralExpression argument = (LiteralExpression) methodCall.getArguments().get(0); //get the argument
				if (argument.getResolvedType() instanceof CollectionType) {
					CollectionType argumentType = (CollectionType) argument.getResolvedType(); //get the type of the argument
					if (contentType.getClass() == argumentType.getContentType().getClass()) {
						//match, no further actions
					}
					else {
						//handle type mismatch
					}
				}
				else {
					//handle argument not collection type
				}
				
			}
			
			methodCall.setResolvedType(null); //in either case, removeAll() does not have a return type
			
		}
		else {
			//handle arguments number incorrect
		}
	}

}
