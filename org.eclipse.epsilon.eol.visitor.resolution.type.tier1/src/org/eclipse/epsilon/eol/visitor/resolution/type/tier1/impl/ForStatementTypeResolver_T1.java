package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.CollectionType;
import org.eclipse.epsilon.eol.metamodel.ForStatement;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.ForStatementVisitor;
import org.eclipse.epsilon.eol.problem.imessages.IMessage_TypeResolution;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class ForStatementTypeResolver_T1 extends ForStatementVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(ForStatement forStatement,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {

		controller.visit(forStatement.getIterator(), context);
		controller.visit(forStatement.getCondition(), context);
		
		if (forStatement.getCondition().getResolvedType() instanceof CollectionType) {
			CollectionType conditionType = (CollectionType) forStatement.getCondition().getResolvedType();
			Type contentType = null;
			if (conditionType.getContentType() != null) {
				contentType = EcoreUtil.copy(conditionType.getContentType());
				forStatement.getIterator().setResolvedType(EcoreUtil.copy(contentType));
				context.setAssets(contentType, forStatement.getCondition());
			}
			else {
				context.getLogBook().addError(forStatement.getContainer(), IMessage_TypeResolution.COLLECTION_EXPRESSION_NO_CONTENT_TYPE);
			}
		}
		else {
			context.getLogBook().addError(forStatement.getCondition(), IMessage_TypeResolution.FOR_STMT_CONDITION_NOT_COLLECTION_TYPE);
		}
		
		controller.visit(forStatement.getBody(), context);

		return null;
	}

}
