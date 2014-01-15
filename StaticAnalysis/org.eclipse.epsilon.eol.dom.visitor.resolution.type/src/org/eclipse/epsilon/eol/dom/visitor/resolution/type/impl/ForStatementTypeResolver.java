package org.eclipse.epsilon.eol.dom.visitor.resolution.type.impl;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.dom.CollectionType;
import org.eclipse.epsilon.eol.dom.ForStatement;
import org.eclipse.epsilon.eol.dom.Type;
import org.eclipse.epsilon.eol.dom.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.dom.visitor.ForStatementVisitor;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.context.TypeResolutionContext;

public class ForStatementTypeResolver extends ForStatementVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(ForStatement forStatement,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		// TODO Auto-generated method stub
		controller.visit(forStatement.getIterator(), context);
		controller.visit(forStatement.getIterated(), context);
		if (forStatement.getIterated().getResolvedType() instanceof CollectionType) {
			CollectionType iteratedType = (CollectionType) forStatement.getIterated().getResolvedType();
			Type contentType = null;
			if (iteratedType.getContentType() != null) {
				contentType = iteratedType.getContentType();
				forStatement.getIterated().setResolvedType(EcoreUtil.copy(contentType));
			}	
		}
		
		controller.visit(forStatement.getBody(), context);
		return null;
	}

}
