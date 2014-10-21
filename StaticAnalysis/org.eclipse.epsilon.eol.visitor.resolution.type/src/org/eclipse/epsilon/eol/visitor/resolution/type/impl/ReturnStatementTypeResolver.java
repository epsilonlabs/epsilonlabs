package org.eclipse.epsilon.eol.visitor.resolution.type.impl;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.ReturnStatementVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.context.TypeResolutionContext;

public class ReturnStatementTypeResolver extends ReturnStatementVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(ReturnStatement returnStatement,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		controller.visit(returnStatement.getReturned(), context);
		EolElement rawContainer = returnStatement.getContainer(); //get the container
		while(!(rawContainer instanceof OperationDefinition)) //get all the way to OperationDefinition
		{
			rawContainer = rawContainer.getContainer();
		}
		
		if (rawContainer instanceof OperationDefinition) { //check again if the container is an operationdefinition
			OperationDefinition container = (OperationDefinition) rawContainer; //cast 
			Type returnType = container.getReturnType(); //get return type of the operation
			
			if (returnType == null) {
				
			}
			else {
				Type returnedType = returnStatement.getReturned().getResolvedType(); //get the returned type of the operation
				if (returnedType == null) {
					if (returnType instanceof VoidType) {
						
					}
					else {
						context.getLogBook().addError(returnStatement, "expecting return type" + returnType.eClass().getName());
					}
				}
				else {
					if (returnedType instanceof AnyType) {
						returnedType = context.getDynamicType((AnyType) returnedType);
						//container.setReturnType(returnedType); //==============attention
//						rawReturnType = (AnyType) returnedType;
//						if (rawReturnType.getTempType()!=null) {
//							returnedType = rawReturnType.getTempType();
//						}
//						container.setReturnType(EcoreUtil.copy(returnedType));
					}
					else if (!context.getTypeUtil().isEqualOrGeneric(returnedType, returnType)) {
						if (returnType instanceof VoidType || returnedType instanceof AnyType) {
							
						}
						else {
							context.getLogBook().addError(returnStatement, "OperationDefinition " + container.getName().getName() + " requires return type: " + returnType.getClass().getSimpleName());
						}					
					}
				}
			}
		}
		// TODO Auto-generated method stub
		return null;
	}
	
//	public Type getDynamicType(AnyType anyType)
//	{
//		while(anyType.getDynamicType() != null)
//		{
//			if (anyType.getDynamicType() instanceof AnyType) {
//				anyType = (AnyType) anyType.getDynamicType();
//			}
//			else {
//				return anyType.getDynamicType();
//			}
//		}
//		return anyType;
//	}

}
