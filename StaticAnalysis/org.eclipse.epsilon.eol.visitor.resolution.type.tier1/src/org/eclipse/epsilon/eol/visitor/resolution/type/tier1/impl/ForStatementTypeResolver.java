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

		//visit iterator
		controller.visit(forStatement.getIterator(), context);
		
		//visit iterated
		controller.visit(forStatement.getIterated(), context);
		
		if (forStatement.getIterated().getResolvedType() != null) {
			//if iterated is collection type
			if (forStatement.getIterated().getResolvedType() instanceof CollectionType) {
				
				//get iterated type
				CollectionType iteratedType = (CollectionType) forStatement.getIterated().getResolvedType();
				
				Type contentType = null;
				
				if (iteratedType.getContentType() != null) {
					contentType = EcoreUtil.copy(iteratedType.getContentType());
					forStatement.getIterator().setResolvedType(EcoreUtil.copy(contentType));
				}
				else {
					//technically this should not happen
					contentType = context.getEolFactory().createAnyType();
					forStatement.getIterator().setResolvedType(EcoreUtil.copy(contentType));
				}
			}
			else {
				context.getLogBook().addError(forStatement.getIterated(), "Expression should be a Collection");
			}
			
			controller.visit(forStatement.getBody(), context);
		}
		else {
			context.getLogBook().addError(forStatement.getIterated(), "Expression does not have a type");
		}
		
		
		return null;
	}

}
