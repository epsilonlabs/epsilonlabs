package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import org.eclipse.epsilon.eol.metamodel.AnyType;
import org.eclipse.epsilon.eol.metamodel.BooleanType;
import org.eclipse.epsilon.eol.metamodel.EolFactory;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.NotOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.NotOperatorExpressionVisitor;
import org.eclipse.epsilon.eol.problem.LogBook;
import org.eclipse.epsilon.eol.problem.imessages.IMessage_TypeResolution;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeInferenceManager;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeUtil;

public class NotOperatorExpressionTypeResolver extends NotOperatorExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(NotOperatorExpression notOperatorExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		Expression expression = notOperatorExpression.getExpression();
		
		controller.visit(expression, context); 
		Type expressionType = expression.getResolvedType();
		
		//set type first, this allows minor-error in expressions n statements
		Type type = EolFactory.eINSTANCE.createBooleanType(); 
		notOperatorExpression.setResolvedType(type);
		context.setAssets(type, notOperatorExpression); //set the type to the notOperatorExpression

		
		if (expressionType != null) {
			if (TypeUtil.getInstance().isInstanceofAnyType(expressionType)) {
				if(!TypeInferenceManager.getInstance().containsDynamicType((AnyType) expressionType, type.eClass()))
				{
					LogBook.getInstance().addError(expression, IMessage_TypeResolution.EXPRESSION_NOT_BOOLEAN);
				}
				else {
					LogBook.getInstance().addWarning(expression, IMessage_TypeResolution.EXPRESSION_IS_ANYTYPE);
				}
			}
			else if(!(expressionType instanceof BooleanType))
			{
				LogBook.getInstance().addError(expression, "Expression should be boolean");
			}
		}
		else {
			LogBook.getInstance().addError(expression, IMessage_TypeResolution.EXPRESSION_DOES_NOT_HAVE_A_TYPE);
		}
		
		return null;
	}

}
