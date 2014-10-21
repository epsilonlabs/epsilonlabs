package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.standard.library.collection.handlers.old;

import javax.lang.model.type.PrimitiveType;

import org.eclipse.emf.ecore.xml.type.AnyType;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class AddHandler {

	public void handle(MethodCallExpression methodCall, TypeResolutionContext context)
	{ 
		if (methodCall.getArguments().size() == 1) { //there should only be one argument
			CollectionType targetType = (CollectionType) methodCall.getTarget().getResolvedType(); //obtain target type, at this stage, preliminary examination should already have the conclusion that the type is of type Collection
			Type contentType = targetType.getContentType(); //obtain content type from the collection
			
			if (contentType == null) {
				LiteralExpression argument = (LiteralExpression) methodCall.getArguments().get(0); //get the argument
				Type argumentType = argument.getResolvedType(); //get the type of the argument
				if (argumentType instanceof PrimitiveType || argumentType instanceof AnyType) {
					
				}
				else {
					//handle argument type 
				}
			}
			else {
				LiteralExpression argument = (LiteralExpression) methodCall.getArguments().get(0); //get the argument
				Type argumentType = argument.getResolvedType(); //get the type of the argument
				if (contentType.getClass() == argumentType.getClass()) {
					//match, no further actions
				}
				else {
					//handle type mismatch
				}
			}
			
			methodCall.setResolvedType(null); //in either case, add() does not have a return type
			
		}
		else {
			//handle arguments number incorrect
		}
	}
}
