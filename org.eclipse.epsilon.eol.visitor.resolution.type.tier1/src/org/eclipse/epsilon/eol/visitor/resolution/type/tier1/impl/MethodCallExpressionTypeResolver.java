package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import java.util.ArrayList;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.AnyType;
import org.eclipse.epsilon.eol.metamodel.CollectionType;
import org.eclipse.epsilon.eol.metamodel.EolFactory;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.MethodCallExpression;
import org.eclipse.epsilon.eol.metamodel.ModelElementType;
import org.eclipse.epsilon.eol.metamodel.NameExpression;
import org.eclipse.epsilon.eol.metamodel.OperationDefinition;
import org.eclipse.epsilon.eol.metamodel.SelfContentType;
import org.eclipse.epsilon.eol.metamodel.SelfType;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.MethodCallExpressionVisitor;
import org.eclipse.epsilon.eol.problem.LogBook;
import org.eclipse.epsilon.eol.problem.imessages.IMessage_TypeResolution;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.operationDefinitionUtil.OperationDefinitionManager;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeUtil;

public class MethodCallExpressionTypeResolver extends MethodCallExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(MethodCallExpression methodCallExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		//prepare target type
		Type targetType = null;
		
		//prepare arrow
		boolean arrow = false;
		
		//prepare argTypes
		ArrayList<Type> argTypes = new ArrayList<Type>();
		
		//get method name
		String methodName = methodCallExpression.getMethod().getName();
		
		//get target
		Expression target = methodCallExpression.getTarget();
		
		for(Expression argument: methodCallExpression.getArguments()) //process arguments
		{
			controller.visit(argument, context); //resolve the type of the argument first
			if (argument.getResolvedType() == null) {
				LogBook.getInstance().addError(argument, IMessage_TypeResolution.EXPRESSION_DOES_NOT_HAVE_A_TYPE);
				return null;
			}
			argTypes.add(EcoreUtil.copy(argument.getResolvedType())); //if is not any type, add to the argument list immediately
		}


		if (target == null) { //if the target is null
			targetType = EolFactory.eINSTANCE.createAnyType(); //since the target is null, we create an AnyType
			context.setAssets(targetType, target);
		}
		else { //if the target is not null
			controller.visit(target, context); //visit content first
			
			targetType = EcoreUtil.copy(target.getResolvedType()); //get target type
			
			if (targetType == null) { //if target type is null
				context.getLogBook().addError(target, IMessage_TypeResolution.EXPRESSION_DOES_NOT_HAVE_A_TYPE);
				targetType = EolFactory.eINSTANCE.createAnyType();
				context.setAssets(targetType, target);
			}
			arrow = methodCallExpression.isIsArrow();
		}
		
		OperationDefinition operationDefinition;
		//fetch operation definition using name, context type and arg types from the standard library and user defined operations
		operationDefinition = context.getOperationDefinitionManager().getOperation(methodCallExpression, methodName, targetType, argTypes, arrow); 
		
		//if an operation is found
		if (operationDefinition != null) {
			
			//get the context type of the operation
			Type opContextType = operationDefinition.getContextType();
			
			//if target type and context type is generic
			if (context.getTypeUtil().isTypeEqualOrGeneric(targetType,opContextType)) {
				
				//if target is null, check operation definition declares context type
				if (target == null) {
					if (TypeUtil.getInstance().isInstanceofAnyType(opContextType)) {
						AnyType ct = (AnyType) opContextType;
						if (ct.isDeclared()) {
							LogBook.getInstance().addWarning(methodCallExpression, IMessage_TypeResolution.OPERATION_REQUIRES_TARGET);
							return null;
						}
					}
				}
				
				
				//deals with parameter of type "Type"
				for(int i = 0; i < operationDefinition.getParameters().size(); i++)
				{
					//if the parameter is keyword "Type"
					if (operationDefinition.getParameters().get(i).getResolvedType().eClass().getName().equals("Type")) {
						//if the argument is an name expression
						if(methodCallExpression.getArguments().get(i) instanceof NameExpression)
						{
							NameExpression arg = (NameExpression) methodCallExpression.getArguments().get(i);
							if (context.getTypeUtil().isTypeKeyWord(arg.getName())) {
								
							}
							else {
								context.getLogBook().addError(arg, IMessage_TypeResolution.EXPRESSION_SHOULD_BE_TYPE);
							}
						}
						else {
							context.getLogBook().addError(methodCallExpression.getArguments().get(i), IMessage_TypeResolution.EXPRESSION_SHOULD_BE_TYPE);
						}
					}
				}
				
				
				if (OperationDefinitionManager.getInstance().handled(operationDefinition)) {
					//make a copy of the return type
					Type returnType = EcoreUtil.copy(operationDefinition.getReturnType());
					//set the resolved type
					methodCallExpression.setResolvedType(returnType);
					//set assets
					context.setAssets(returnType, methodCallExpression);
					//set the resolved type of the method
					methodCallExpression.getMethod().setResolvedType(EcoreUtil.copy(returnType));
					//set resolved content
					methodCallExpression.getMethod().setResolvedContent(operationDefinition); 
				}
				else {
					
					//if is self type
					if (operationDefinition.getReturnType() instanceof SelfType) {
						
						Type targetTypeCopy = EcoreUtil.copy(targetType);
						
						//just copy the target type because the target type has been resolved
						methodCallExpression.setResolvedType(targetTypeCopy);
						context.setAssets(targetTypeCopy, methodCallExpression);
						//set the resolved type of the method
						methodCallExpression.getMethod().setResolvedType(EcoreUtil.copy(targetTypeCopy));
						//set resolved content
						methodCallExpression.getMethod().setResolvedContent(operationDefinition); 
					}
					
					//if is selfContentType
					else if (operationDefinition.getReturnType() instanceof SelfContentType) {
						
						//if target type is of collection type
						if (targetType instanceof CollectionType) {
							Type contentType = ((CollectionType) targetType).getContentType(); //getContentType
							if (contentType != null) {
								methodCallExpression.setResolvedType(EcoreUtil.copy(contentType)); //set resolved type
								methodCallExpression.getMethod().setResolvedType(EcoreUtil.copy(contentType)); //set method type
								methodCallExpression.getMethod().setResolvedContent(operationDefinition); //set resolved content
							}
							else {
								AnyType tempAnyType = EolFactory.eINSTANCE.createAnyType();
								methodCallExpression.setResolvedType(EcoreUtil.copy(tempAnyType));
								methodCallExpression.getMethod().setResolvedType(EcoreUtil.copy(tempAnyType));
								//handle content type null
							}
						}
						else {
							LogBook.getInstance().addError(target, IMessage_TypeResolution.EXPRESSION_SHOULD_BE_COLLECTION_TYPE);
							
							AnyType tempAnyType = EolFactory.eINSTANCE.createAnyType();
							methodCallExpression.setResolvedType(EcoreUtil.copy(tempAnyType));
							methodCallExpression.getMethod().setResolvedType(EcoreUtil.copy(tempAnyType));
						}
					}
					
					else if (operationDefinition.getReturnType() instanceof CollectionType && 
							(((CollectionType)operationDefinition.getReturnType()).getContentType() instanceof SelfType)) { //if the return type is collection type and its content type is SelfType ============================
						
						CollectionType returnType = (CollectionType) operationDefinition.getReturnType();
						
						CollectionType resultType = EcoreUtil.copy(returnType);
						resultType.setContentType(EcoreUtil.copy(targetType));
						methodCallExpression.setResolvedType(EcoreUtil.copy(resultType)); //set the type of the method call
						methodCallExpression.getMethod().setResolvedType(EcoreUtil.copy(resultType)); //set resolved type
						methodCallExpression.getMethod().setResolvedContent(operationDefinition); //set resolved content
					}
					
					else {
						Type returnTypeCopy = EcoreUtil.copy(operationDefinition.getReturnType());
						
						methodCallExpression.setResolvedType(returnTypeCopy); //set the type of the method call
						context.setAssets(returnTypeCopy, methodCallExpression);
						methodCallExpression.getMethod().setResolvedType(EcoreUtil.copy(returnTypeCopy)); //set resolved type
						methodCallExpression.getMethod().setResolvedContent(operationDefinition); //set resolved content
					}
				}
				
				
			}
			else if (TypeUtil.getInstance().isInstanceofAnyType(targetType)) {
					methodCallExpression.setResolvedType(EcoreUtil.copy(operationDefinition.getReturnType())); //set the type of the method call
					methodCallExpression.getMethod().setResolvedType(EcoreUtil.copy(operationDefinition.getReturnType())); //set resolved type
					methodCallExpression.getMethod().setResolvedContent(operationDefinition); //set resolved conten
			}
			else {
				//handle type incompatible
				String expectedType = "";
				String actualType = "";
				if (opContextType instanceof ModelElementType) {
					expectedType = ((ModelElementType)opContextType).getModelName() + "!" + ((ModelElementType)opContextType).getElementName();
				}
				
				else {
					expectedType = opContextType.getClass().toString();
				}
				if (targetType instanceof ModelElementType) {
					actualType = ((ModelElementType)targetType).getModelName() + "!" + ((ModelElementType)targetType).getElementName();
				}
				else {
					actualType = targetType.getClass().toString();
				}
				LogBook.getInstance().addError(target, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.OPERATION_CONTEXT_TYPE_MISMATCH, methodName, expectedType, actualType));
			}
		}
		else {
			String argString = "";
			for(int i = 0; i < argTypes.size(); i++)
			{
				argString += argTypes.get(i).eClass().getName();
				if (i == argTypes.size() - 1) {
					
				}
				else {
					argString.concat(", ");
				}
			}
			
			LogBook.getInstance().addError(methodCallExpression, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.OPERATION_NOT_FOUND, methodName, argString));
		}
		return null;
	}
}
