package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import org.eclipse.epsilon.eol.metamodel.AnyType;
import org.eclipse.epsilon.eol.metamodel.EOLElement;
import org.eclipse.epsilon.eol.metamodel.OperationDefinition;
import org.eclipse.epsilon.eol.metamodel.ReturnStatement;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.metamodel.VoidType;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.ReturnStatementVisitor;
import org.eclipse.epsilon.eol.problem.imessages.IMessage_TypeResolution;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class ReturnStatementTypeResolver_T1 extends ReturnStatementVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(ReturnStatement returnStatement,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		controller.visit(returnStatement.getExpression(), context);
		EOLElement rawContainer = returnStatement.getContainer(); //get the container
		while(!(rawContainer instanceof OperationDefinition) && rawContainer != null) //get all the way to OperationDefinition
		{
			rawContainer = rawContainer.getContainer();
		}
		
		if (rawContainer == null) {
			context.getLogBook().addError(returnStatement, IMessage_TypeResolution.RETURN_STATEMENT_NOT_IN_OP);
		}
		
		else {
			if (rawContainer instanceof OperationDefinition) {
				 //check again if the container is an operationdefinition
				OperationDefinition container = (OperationDefinition) rawContainer; //cast 
				Type returnType = container.getReturnType(); //get return type of the operation
				
				if (returnType == null) {
					
				}
				else {
					Type returnedType = returnStatement.getExpression().getResolvedType(); //get the returned type of the operation
					if (returnedType == null) {
						if (returnType instanceof VoidType) {
							
						}
						else {
							context.getLogBook().addError(returnStatement, "expecting return type" + returnType.eClass().getName());
						}
					}
					else {
						if (returnedType.eClass().getName().equals("AnyTypeImpl")) {
							AnyType leType = (AnyType) returnedType;
							if (leType.isDeclared()) {
								
							}
							else {
								
							}

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
		}
		return null;
	}
	
}
