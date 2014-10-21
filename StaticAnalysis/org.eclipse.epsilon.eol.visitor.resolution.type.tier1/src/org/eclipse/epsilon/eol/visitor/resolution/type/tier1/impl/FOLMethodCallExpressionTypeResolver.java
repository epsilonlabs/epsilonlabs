package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import java.util.ArrayList;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.FOLMethodCallExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class FOLMethodCallExpressionTypeResolver extends FOLMethodCallExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(FOLMethodCallExpression fOLMethodCallExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		controller.visit(fOLMethodCallExpression.getTarget(), context);  //visit target first
		
		Type targetType = fOLMethodCallExpression.getTarget().getResolvedType(); //get target type
		Type contentType = null; //prepare content type
		String name = fOLMethodCallExpression.getMethod().getName();  //get method name

		if (!(targetType instanceof CollectionType)) {
			context.getLogBook().addError(fOLMethodCallExpression.getTarget(), "operation" + name + "can only be performed on collection types");
		}
		else {
			contentType = ((CollectionType)targetType).getContentType(); //get the content type of the target
			if (contentType == null) {
				contentType = context.getEolFactory().createAnyType();
			}
			if (contentType instanceof AnyType) {
				contentType = context.getEolFactory().createAnyType();
			}
		}
		
		FormalParameterExpression iterator = fOLMethodCallExpression.getIterator();
		controller.visit(iterator, context);
		if (iterator.getResolvedType() == null || iterator.getResolvedType() instanceof AnyType) {
			iterator.setResolvedType(EcoreUtil.copy(contentType));
		}

		controller.visit(fOLMethodCallExpression.getCondition(), context);
		
		
		ArrayList<Type> argTypes = new ArrayList<Type>(); //prepare argTypes
		argTypes.add(context.getEolFactory().createAnyType()); //put Any for now for the sake of searching

		boolean arrow = fOLMethodCallExpression.getIsArrow().isVal();
		
		OperationDefinition operationDefinition;
		operationDefinition = context.getOperationDefinitionControl().getOperation(fOLMethodCallExpression, name, targetType, argTypes, arrow); //fetch operation definition using name, context type and arg types
		
		if (operationDefinition != null) { //if there is an operation			
			Type contextType = operationDefinition.getContextType(); //get the context type of the operation
			if (context.getTypeUtil().isEqualOrGeneric(targetType,contextType)) { //if target type and context type is generic
				
				if (operationDefinition.getReturnType() instanceof SelfType) { //if is self type
					fOLMethodCallExpression.setResolvedType(EcoreUtil.copy(targetType));  //just copy the target type because the target type has been resolved
					fOLMethodCallExpression.getMethod().setResolvedType(EcoreUtil.copy(targetType)); //set the resolved type of the method
					fOLMethodCallExpression.getMethod().setResolvedContent(operationDefinition); //set resolved content
				}
				else if (operationDefinition.getReturnType() instanceof SelfContentType) { //if is selfContentType
					if (targetType instanceof CollectionType) { //if target type is of collection type
						if (contentType != null) {
							fOLMethodCallExpression.setResolvedType(EcoreUtil.copy(contentType)); //set resolved type
							fOLMethodCallExpression.getMethod().setResolvedType(EcoreUtil.copy(contentType)); //set method type
							fOLMethodCallExpression.getMethod().setResolvedContent(operationDefinition); //set resolved content
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
		return null;
	}

}
