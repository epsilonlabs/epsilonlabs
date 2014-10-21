package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.ForStatementVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class ForStatementTypeResolver extends ForStatementVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(ForStatement forStatement,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {

		controller.visit(forStatement.getIterator(), context);
		controller.visit(forStatement.getIterated(), context);
		if (forStatement.getIterated().getResolvedType() instanceof CollectionType) {
			CollectionType iteratedType = (CollectionType) forStatement.getIterated().getResolvedType();
			Type contentType = null;
			if (iteratedType.getContentType() != null) {
				contentType = EcoreUtil.copy(iteratedType.getContentType());
				forStatement.getIterator().setResolvedType(EcoreUtil.copy(contentType));
			}	
		}
		
		controller.visit(forStatement.getBody(), context);
		
		return null;
	}

}
