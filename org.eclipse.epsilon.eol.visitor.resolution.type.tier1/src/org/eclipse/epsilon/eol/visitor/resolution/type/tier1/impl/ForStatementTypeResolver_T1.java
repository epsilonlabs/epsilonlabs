package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.AnyType;
import org.eclipse.epsilon.eol.metamodel.CollectionType;
import org.eclipse.epsilon.eol.metamodel.EolFactory;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.ForStatement;
import org.eclipse.epsilon.eol.metamodel.FormalParameterExpression;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.ForStatementVisitor;
import org.eclipse.epsilon.eol.problem.LogBook;
import org.eclipse.epsilon.eol.problem.imessages.IMessage_TypeResolution;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeInferenceManager;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeUtil;

public class ForStatementTypeResolver_T1 extends ForStatementVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(ForStatement forStatement,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {

		controller.visit(forStatement.getIterator(), context);
		controller.visit(forStatement.getCondition(), context);
		
		FormalParameterExpression iterator = forStatement.getIterator();
		Expression condition = forStatement.getCondition();
		
		//if condition is collection type
		if (condition.getResolvedType() instanceof CollectionType) {
			CollectionType conditionType = (CollectionType) condition.getResolvedType();
			Type contentType = null;
			//if content typs is not null
			if (conditionType.getContentType() != null) {
				//copy content type
				contentType = EcoreUtil.copy(conditionType.getContentType());
				//if iterator does not have a type, assign type and report error
				if (iterator.getResolvedType() == null) {
					LogBook.getInstance().addError(forStatement.getIterator(), IMessage_TypeResolution.EXPRESSION_DOES_NOT_HAVE_A_TYPE);
					forStatement.getIterator().setResolvedType(EcoreUtil.copy(contentType));
					context.setAssets(contentType, forStatement.getIterator());	
				}
			}
			else {
				//if conditon does not have a content type, report error
				LogBook.getInstance().addError(forStatement.getContainer(), IMessage_TypeResolution.COLLECTION_EXPRESSION_NO_CONTENT_TYPE);
			}
		}
		else {
			//if condition is AnyType, check dynamic type, report error if necessary
			if (TypeUtil.getInstance().isInstanceofAnyType(condition.getResolvedType())) {
				AnyType conditionType = (AnyType) condition.getResolvedType();
				if (!TypeInferenceManager.getInstance().containsDynamicType(conditionType, EolFactory.eINSTANCE.createCollectionType().eClass())) {
					LogBook.getInstance().addError(condition, IMessage_TypeResolution.FOR_STMT_CONDITION_NOT_COLLECTION_TYPE);
				}
			}
			LogBook.getInstance().addError(condition, IMessage_TypeResolution.FOR_STMT_CONDITION_NOT_COLLECTION_TYPE);
		}
		
		controller.visit(forStatement.getBody(), context);

		return null;
	}
}
