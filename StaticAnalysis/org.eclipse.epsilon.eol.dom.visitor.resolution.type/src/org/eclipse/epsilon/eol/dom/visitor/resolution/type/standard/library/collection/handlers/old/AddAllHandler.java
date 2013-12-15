package org.eclipse.epsilon.eol.dom.visitor.resolution.type.standard.library.collection.handlers.old;

import org.eclipse.epsilon.eol.dom.CollectionType;
import org.eclipse.epsilon.eol.dom.LiteralExpression;
import org.eclipse.epsilon.eol.dom.MethodCallExpression;
import org.eclipse.epsilon.eol.dom.Type;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.context.TypeResolutionContext;

public class AddAllHandler {

	public void handle(MethodCallExpression methodCall, TypeResolutionContext context)
	{
		if (methodCall.getArguments().size() == 1) { //there should only be one argument
			CollectionType targetType = (CollectionType) methodCall.getTarget().getResolvedType(); //obtain target type, at this stage, preliminary examination should already have the conclusion that the type is of type Collection
			Type contentType = targetType.getContentType(); //obtain content type from the collection
			
			if (contentType == null) {
				LiteralExpression argument = (LiteralExpression) methodCall.getArguments().get(0); //get the argument
				Type argumentType = argument.getResolvedType(); //get the type of the argument
				if (argumentType instanceof CollectionType) {
					
				}
				else {
					//handle argument not collection type
				}
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
			
			methodCall.setResolvedType(null); //in either case, add() does not have a return type
			
		}
		else {
			//handle arguments number incorrect
		}
	}
}
