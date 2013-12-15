package org.eclipse.epsilon.eol.dom.visitor.resolution.type.impl;

import org.eclipse.epsilon.eol.dom.ReturnStatement;
import org.eclipse.epsilon.eol.dom.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.dom.visitor.ReturnStatementVisitor;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.context.TypeResolutionContext;

public class ReturnStatementTypeResolver extends ReturnStatementVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(ReturnStatement returnStatement,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		// TODO Auto-generated method stub
		return null;
	}

}
