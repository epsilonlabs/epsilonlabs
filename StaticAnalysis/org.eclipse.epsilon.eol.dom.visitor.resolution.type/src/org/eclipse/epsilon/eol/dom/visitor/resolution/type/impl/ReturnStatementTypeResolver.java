package org.eclipse.epsilon.eol.dom.visitor.resolution.type.impl;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.OperationDefinition;
import org.eclipse.epsilon.eol.dom.ReturnStatement;
import org.eclipse.epsilon.eol.dom.Type;
import org.eclipse.epsilon.eol.dom.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.dom.visitor.ReturnStatementVisitor;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.context.TypeResolutionContext;

public class ReturnStatementTypeResolver extends ReturnStatementVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(ReturnStatement returnStatement,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		controller.visit(returnStatement.getReturned(), context);
		DomElement rawContainer = returnStatement.getContainer(); 
		while(!(rawContainer instanceof OperationDefinition))
		{
			rawContainer = rawContainer.getContainer();
		}
		
		if (rawContainer instanceof OperationDefinition) {
			OperationDefinition container = (OperationDefinition) rawContainer;
			Type returnType = container.getReturnType();
			Type returnedType = returnStatement.getReturned().getResolvedType();
			if (!context.getTypeUtil().isEqualOrGeneric(returnedType, returnType)) {
				context.getLogBook().addError(returnStatement, "OperationDefinition " + container.getName().getName() + " requires return type: " + returnType.getClass().getSimpleName());
			}
		}
		// TODO Auto-generated method stub
		return null;
	}

}
