package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.AnyType;
import org.eclipse.epsilon.eol.metamodel.EolFactory;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.NegativeOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.RealType;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.NegativeOperatorExpressionVisitor;
import org.eclipse.epsilon.eol.problem.LogBook;
import org.eclipse.epsilon.eol.problem.imessages.IMessage_TypeResolution;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeInferenceManager;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeUtil;

public class NegativeOperatorExpressionTypeResolver extends NegativeOperatorExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(NegativeOperatorExpression negativeOperatorExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		Expression expression = negativeOperatorExpression.getExpression();
		
		controller.visit(expression, context); 
		Type expressionType = expression.getResolvedType();
		
		//set type first, this allows minor-error in expressions n statements
		Type type = EolFactory.eINSTANCE.createIntegerType(); 

		
		if (expressionType != null) {
			if (TypeUtil.getInstance().isInstanceofAnyType(expressionType)) {
				if(!TypeInferenceManager.getInstance().containsDynamicType((AnyType) expressionType, type.eClass()))
				{
					LogBook.getInstance().addError(expression, IMessage_TypeResolution.EXPRESSION_NOT_NUMERAL);
				}
				else {
					LogBook.getInstance().addWarning(expression, IMessage_TypeResolution.EXPRESSION_IS_ANYTYPE);
				}
			}
			else {
				if (expressionType instanceof RealType) {
					type = EcoreUtil.copy(expressionType);
				}
				else {
					LogBook.getInstance().addError(expression, IMessage_TypeResolution.EXPRESSION_NOT_NUMERAL);
				}
			}
		}
		else {
			LogBook.getInstance().addError(expression, IMessage_TypeResolution.EXPRESSION_DOES_NOT_HAVE_A_TYPE);
		}
		
		negativeOperatorExpression.setResolvedType(type);
		context.setAssets(type, negativeOperatorExpression); //set the type to the notOperatorExpression
		return null;
	}
}
