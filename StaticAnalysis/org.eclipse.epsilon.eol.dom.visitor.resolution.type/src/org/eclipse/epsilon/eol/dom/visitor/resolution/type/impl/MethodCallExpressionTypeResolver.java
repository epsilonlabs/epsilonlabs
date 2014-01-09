package org.eclipse.epsilon.eol.dom.visitor.resolution.type.impl;

import java.util.ArrayList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.dom.AnyType;
import org.eclipse.epsilon.eol.dom.CollectionType;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.dom.MethodCallExpression;
import org.eclipse.epsilon.eol.dom.ModelElementType;
import org.eclipse.epsilon.eol.dom.OperationDefinition;
import org.eclipse.epsilon.eol.dom.SelfContentType;
import org.eclipse.epsilon.eol.dom.SelfType;
import org.eclipse.epsilon.eol.dom.Type;
import org.eclipse.epsilon.eol.dom.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.dom.visitor.MethodCallExpressionVisitor;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.context.TypeResolutionContext;

public class MethodCallExpressionTypeResolver extends MethodCallExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(MethodCallExpression methodCallExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		if (methodCallExpression.getTarget() == null) {
			String name = methodCallExpression.getMethod().getName();  //get method name
			ArrayList<Type> argTypes = new ArrayList<Type>(); //prepare argTypes
			for(Expression exp: methodCallExpression.getArguments()) //process arguments
			{
				controller.visit(exp, context); //resolve the type of the argument first
				if (exp.getResolvedType() instanceof AnyType) { //if is anytype
					AnyType temp = (AnyType) exp.getResolvedType();
					if (temp.getTempType() != null) {
						argTypes.add(temp.getTempType()); //if there's a temp type, set the type to be the temp type
					}
					else {
						argTypes.add(temp);
					}
				}
				else {
					argTypes.add(exp.getResolvedType()); //if is not any type, add to the argument list immediately
				}
			}
			Type targetType = context.getEolFactory().createAnyType(); 
			
			OperationDefinition operationDefinition;
			operationDefinition = context.getOperationDefinitionControl().getOperation(methodCallExpression, name, targetType, argTypes, false); //fetch operation definition using name, context type and arg types
			if (operationDefinition != null) { //if there is an operation			
				Type contextType = operationDefinition.getContextType(); //get the context type of the operation
				if (context.getTypeUtil().isEqualOrGeneric(targetType,contextType)) { //if target type and context type is generic
					
					if (operationDefinition.getReturnType() instanceof SelfType) { //if is self type
						methodCallExpression.setResolvedType(EcoreUtil.copy(targetType));  //just copy the target type because the target type has been resolved
						methodCallExpression.getMethod().setResolvedType(EcoreUtil.copy(targetType)); //set the resolved type of the method
						methodCallExpression.getMethod().setResolvedContent(operationDefinition); //set resolved content
					}
					else if (operationDefinition.getReturnType() instanceof SelfContentType) { //if is selfContentType
						if (targetType instanceof CollectionType) { //if target type is of collection type
							Type contentType = ((CollectionType) targetType).getContentType(); //getContentType
							if (contentType != null) {
								methodCallExpression.setResolvedType(EcoreUtil.copy(contentType)); //set resolved type
								methodCallExpression.getMethod().setResolvedType(EcoreUtil.copy(contentType)); //set method type
								methodCallExpression.getMethod().setResolvedContent(operationDefinition); //set resolved content
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
						methodCallExpression.setResolvedType(EcoreUtil.copy(operationDefinition.getReturnType())); //set the type of the method call
						methodCallExpression.getMethod().setResolvedType(EcoreUtil.copy(operationDefinition.getReturnType())); //set resolved type
						methodCallExpression.getMethod().setResolvedContent(operationDefinition); //set resolved content
					}
				}
				else if (targetType instanceof AnyType) {
					methodCallExpression.setResolvedType(EcoreUtil.copy(operationDefinition.getReturnType())); //set the type of the method call
					methodCallExpression.getMethod().setResolvedType(EcoreUtil.copy(operationDefinition.getReturnType())); //set resolved type
					methodCallExpression.getMethod().setResolvedContent(operationDefinition); //set resolved conten
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
					context.getLogBook().addError(methodCallExpression.getTarget(), "Type mismatch for Operation: " + 
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
				context.getLogBook().addError(methodCallExpression, "OperationDefinition: " + name + "("+ argString +")" + "cannot be found");
			}

		}
		else {
			controller.visit(methodCallExpression.getTarget(), context); //visit content first
			
			String name = methodCallExpression.getMethod().getName();  //get method name
			ArrayList<Type> argTypes = new ArrayList<Type>(); //prepare argTypes
			for(Expression exp: methodCallExpression.getArguments()) //process arguments
			{
				controller.visit(exp, context); //resolve the type of the argument first
				if (exp.getResolvedType() instanceof AnyType) { //if is anytype
					AnyType temp = (AnyType) exp.getResolvedType();
					if (temp.getTempType() != null) {
						argTypes.add(temp.getTempType()); //if there's a temp type, set the type to be the temp type
					}
					else {
						argTypes.add(temp);
					}
				}
				else {
					argTypes.add(exp.getResolvedType()); //if is not any type, add to the argument list immediately
				}
			}
			Type targetType = methodCallExpression.getTarget().getResolvedType(); //get target type
			
			if (targetType == null) { //if target type is null
				//note : this should be an error, but leave like this by now
				targetType = context.getEolFactory().createAnyType(); //there should be an error
			}
			
			if (targetType instanceof AnyType) { //if target type is of type any
				if (((AnyType) targetType).getTempType() != null) {
					targetType = ((AnyType) targetType).getTempType();
				}
			}

			boolean arrow = methodCallExpression.getIsArrow().isVal();
			
			OperationDefinition operationDefinition;
			operationDefinition = context.getOperationDefinitionControl().getOperation(methodCallExpression, name, targetType, argTypes, arrow); //fetch operation definition using name, context type and arg types
			
			if (operationDefinition != null) { //if there is an operation			
				Type contextType = operationDefinition.getContextType(); //get the context type of the operation
				if (context.getTypeUtil().isEqualOrGeneric(targetType,contextType)) { //if target type and context type is generic
					
					if (operationDefinition.getReturnType() instanceof SelfType) { //if is self type
						methodCallExpression.setResolvedType(EcoreUtil.copy(targetType));  //just copy the target type because the target type has been resolved
						methodCallExpression.getMethod().setResolvedType(EcoreUtil.copy(targetType)); //set the resolved type of the method
						methodCallExpression.getMethod().setResolvedContent(operationDefinition); //set resolved content
					}
					else if (operationDefinition.getReturnType() instanceof SelfContentType) { //if is selfContentType
						if (targetType instanceof CollectionType) { //if target type is of collection type
							Type contentType = ((CollectionType) targetType).getContentType(); //getContentType
							if (contentType != null) {
								methodCallExpression.setResolvedType(EcoreUtil.copy(contentType)); //set resolved type
								methodCallExpression.getMethod().setResolvedType(EcoreUtil.copy(contentType)); //set method type
								methodCallExpression.getMethod().setResolvedContent(operationDefinition); //set resolved content
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
						methodCallExpression.setResolvedType(EcoreUtil.copy(operationDefinition.getReturnType())); //set the type of the method call
						methodCallExpression.getMethod().setResolvedType(EcoreUtil.copy(operationDefinition.getReturnType())); //set resolved type
						methodCallExpression.getMethod().setResolvedContent(operationDefinition); //set resolved content
					}
				}
				else if (targetType instanceof AnyType) {
					methodCallExpression.setResolvedType(EcoreUtil.copy(operationDefinition.getReturnType())); //set the type of the method call
					methodCallExpression.getMethod().setResolvedType(EcoreUtil.copy(operationDefinition.getReturnType())); //set resolved type
					methodCallExpression.getMethod().setResolvedContent(operationDefinition); //set resolved conten
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
					context.getLogBook().addError(methodCallExpression.getTarget(), "Type mismatch for Operation: " + 
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
				context.getLogBook().addError(methodCallExpression, "OperationDefinition: " + name + "("+ argString +")" + "cannot be found");
			}
		}
		return null;
	}

}
