package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.WhileStatementVisitor;
import org.eclipse.epsilon.eol.problem.LogBook;
import org.eclipse.epsilon.eol.problem.imessages.IMessage_TypeResolution;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeInferenceManager;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeUtil;

public class WhileStatementTypeResolver extends WhileStatementVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(WhileStatement whileStatement,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {

		context.getTypeRegistry().pushEntry(whileStatement.getBody());//////////
		controller.visit(whileStatement.getCondition(), context);
		controller.visit(whileStatement.getBody(), context);
		
		Expression condition = whileStatement.getCondition();
		Type conditionType = condition.getResolvedType();

		if (!(conditionType instanceof BooleanType)) {
			if (TypeUtil.getInstance().isInstanceofAnyType(conditionType)) {
				if (!TypeInferenceManager.getInstance().containsDynamicType((AnyType) conditionType, EolFactory.eINSTANCE.createBooleanType().eClass())) {
					LogBook.getInstance().addError(condition, IMessage_TypeResolution.EXPRESSION_NOT_BOOLEAN);
				}
			}
			else {
				LogBook.getInstance().addError(condition, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.EXPECTED_TYPE, "Boolean"));
			}
		}
		context.getTypeRegistry().popEntry();
		
		return null;
	}

}
