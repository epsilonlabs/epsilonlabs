package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import java.util.ArrayList;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.FOLMethodCallExpressionVisitor;
import org.eclipse.epsilon.eol.parse.Eol_EolParserRules.returnStatement_return;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class FOLMethodCallExpressionTypeResolver extends FOLMethodCallExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(FOLMethodCallExpression fOLMethodCallExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		//visit target first
		controller.visit(fOLMethodCallExpression.getTarget(), context);
		
		//get target type
		Type targetType = fOLMethodCallExpression.getTarget().getResolvedType();
		
		//prepare content type
		Type contentType = null;
		
		//get method name
		String name = fOLMethodCallExpression.getMethod().getName();
		
		//if target type is not null
		if (targetType != null) {
			//if target type is not collection type, set resolved type to any and return
			if (!(targetType instanceof CollectionType)) {
				context.getLogBook().addError(fOLMethodCallExpression.getTarget(), "operation" + name + "can only be performed on collection types");
				fOLMethodCallExpression.setResolvedType(context.getEolFactory().createAnyType());
				return null;
			}
			else {
				//get the content type of the target
				contentType = EcoreUtil.copy(((CollectionType)targetType).getContentType());
				
				//if contentType is null, set it to Any
				if (contentType == null) {
					contentType = context.getEolFactory().createAnyType();
				}
				
				//get the iterator
				FormalParameterExpression iterator = fOLMethodCallExpression.getIterator();
				
				//visit the iterator
				controller.visit(iterator, context);
				
				//if iterator type is null or any, copy the content type of the target
				if (iterator.getResolvedType() == null || iterator.getResolvedType() instanceof AnyType) {
					iterator.setResolvedType(EcoreUtil.copy(contentType));
				}

				//visit the condition
				controller.visit(fOLMethodCallExpression.getCondition(), context);
				
				//prepare argTypes
				ArrayList<Type> argTypes = new ArrayList<Type>();
				
				//put Any for now for the sake of searching
				argTypes.add(context.getEolFactory().createAnyType()); 

				//get isArrow
				boolean arrow = fOLMethodCallExpression.getIsArrow().isVal();
				
				//prepare operation definition
				OperationDefinition operationDefinition;
				
				//fetch operation definition using name, context type and arg types from the built in library
				operationDefinition = context.getOperationDefinitionControl().getOperation(fOLMethodCallExpression, name, targetType, argTypes, arrow); 
				
				//if there is an operation
				if (operationDefinition != null) {
					
					//get the context type of the operation
					Type contextType = operationDefinition.getContextType();
					
					//if target type and context type is generic
					if (context.getTypeUtil().isEqualOrGeneric(targetType,contextType)) {
						
						//if is self type
						if (operationDefinition.getReturnType() instanceof SelfType) { 
							
							//just copy the target type because the target type has been resolved
							fOLMethodCallExpression.setResolvedType(EcoreUtil.copy(targetType)); 
							
							//set the resolved type of the method
							fOLMethodCallExpression.getMethod().setResolvedType(EcoreUtil.copy(targetType));
							
							//set resolved content
							fOLMethodCallExpression.getMethod().setResolvedContent(operationDefinition); 
						}
						//if is selfContentType
						else if (operationDefinition.getReturnType() instanceof SelfContentType) {
							
							//if target type is of collection type
							if (targetType instanceof CollectionType) {
								if (contentType != null) {
									//set resolved type
									fOLMethodCallExpression.setResolvedType(EcoreUtil.copy(contentType));
									
									//set method type
									fOLMethodCallExpression.getMethod().setResolvedType(EcoreUtil.copy(contentType));
									
									//set resolved content
									fOLMethodCallExpression.getMethod().setResolvedContent(operationDefinition); 
								}
								else {
									//this should be Any i guess?
									//handle content type null
								}
								
							}
							else {
								//handle this
							}
						}
						else {
							fOLMethodCallExpression.setResolvedType(EcoreUtil.copy(operationDefinition.getReturnType())); //set the type of the method call
							fOLMethodCallExpression.getMethod().setResolvedType(EcoreUtil.copy(operationDefinition.getReturnType())); //set resolved type
							fOLMethodCallExpression.getMethod().setResolvedContent(operationDefinition); //set resolved content
						}
					}
					else {
						//handle type incompatible
						String expectedType = "";
						String actualType = "";
						if (contextType instanceof ModelElementType) {
							expectedType = ((ModelElementType)contextType).getModelName() + "!" + ((ModelElementType)contextType).getElementName();
						}
						
						else {
							expectedType = contextType.getClass().toString();
						}
						if (targetType instanceof ModelElementType) {
							actualType = ((ModelElementType)targetType).getModelName() + "!" + ((ModelElementType)targetType).getElementName();
						}
						else {
							actualType = targetType.getClass().toString();
						}
						context.getLogBook().addError(fOLMethodCallExpression.getTarget(), "Type mismatch for Operation: " + 
						operationDefinition.getName().getName() + "()" + "; Expected type: " + expectedType + 
						" , actual type: " + actualType);
						
					}
				}
				else {
					String argString = "";
					for(int i = 0; i < argTypes.size(); i++)
					{
						argString.concat(argTypes.get(i).getClass().toString());
						if (i == argTypes.size() - 1) {
							
						}
						else {
							argString.concat(", ");
						}
					}
					context.getLogBook().addError(fOLMethodCallExpression, "OperationDefinition: " + name + "("+ argString +")" + "cannot be found");
				}
			}
		}
		else {
			context.getLogBook().addError(targetType, "Target does not have a type");
		}
		

		
		return null;
	}

}
