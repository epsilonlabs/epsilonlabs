package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import org.eclipse.epsilon.eol.metamodel.AnyType;
import org.eclipse.epsilon.eol.metamodel.EolFactory;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.IntegerType;
import org.eclipse.epsilon.eol.metamodel.MinusOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.RealType;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.MinusOperatorExpressionVisitor;
import org.eclipse.epsilon.eol.problem.LogBook;
import org.eclipse.epsilon.eol.problem.imessages.IMessage_TypeResolution;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeInferenceManager;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeUtil;

public class MinusOperatorExpressionTypeResolver extends MinusOperatorExpressionVisitor<TypeResolutionContext, Object>{
	

	@Override
	public Object visit(MinusOperatorExpression minusOperatorExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		controller.visitContents(minusOperatorExpression, context);
		
		Expression lhs = minusOperatorExpression.getLhs();
		Expression rhs = minusOperatorExpression.getRhs();
		
		Type lhsType = lhs.getResolvedType();
		Type rhsType = rhs.getResolvedType();
		
		Type type = EolFactory.eINSTANCE.createRealType();
		minusOperatorExpression.setResolvedType(type);
		context.setAssets(type, minusOperatorExpression);
		
		
		if(lhsType == null){
			LogBook.getInstance().addError(minusOperatorExpression.getLhs(), IMessage_TypeResolution.EXPRESSION_DOES_NOT_HAVE_A_TYPE);
			return null;
		}
		
		if(rhsType == null){
			LogBook.getInstance().addError(minusOperatorExpression.getRhs(), IMessage_TypeResolution.EXPRESSION_DOES_NOT_HAVE_A_TYPE);
			return null;
		}
		
		TypeUtil typeUtil = TypeUtil.getInstance();
		
		if (lhsType instanceof RealType) {
			if (rhsType instanceof RealType) {
				
			}
			else if (typeUtil.isInstanceofAnyType(rhsType)) {
				if (!TypeInferenceManager.getInstance().containsDynamicType((AnyType) rhsType, lhsType.eClass())) {
					LogBook.getInstance().addError(rhs, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.EXPECTED_TYPE, lhsType.getClass().getName()));
				}
			}
			else {
				LogBook.getInstance().addError(rhs, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.EXPECTED_TYPE, lhsType.getClass().getName()));
			}
		}
		else if (typeUtil.isInstanceofAnyType(lhsType)) {
			if (rhsType instanceof RealType) {
				if (!TypeInferenceManager.getInstance().containsDynamicType((AnyType) lhsType, rhsType.eClass())) {
					LogBook.getInstance().addError(lhs, IMessage_TypeResolution.EXPRESSION_NOT_NUMERAL);
				}
			}
			else if (typeUtil.isInstanceofAnyType(rhsType)) {
				boolean match = false;
				for(Type t: ((AnyType)rhsType).getDynamicTypes())
				{
					if (t instanceof RealType) {
						//try if there exists a type in lhs that is equal to t
						if (TypeUtil.getInstance().isTypeEqual(t, TypeInferenceManager.getInstance().getDynamicType((AnyType) lhsType, t.eClass()))) {
							LogBook.getInstance().addWarning(lhs, IMessage_TypeResolution.EXPRESSION_IS_ANYTYPE);
							match = true;
						}
					}
				}
				if (!match) {
					LogBook.getInstance().addError(minusOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
				}
			}
			else {
				LogBook.getInstance().addError(minusOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
			}
		}
		else {
			LogBook.getInstance().addError(lhs, IMessage_TypeResolution.EXPRESSION_NOT_NUMERAL);
		}
		
		if (lhsType instanceof IntegerType && rhsType instanceof IntegerType) {
			type = EolFactory.eINSTANCE.createIntegerType();
		}
		
		context.setAssets(type, minusOperatorExpression);
		minusOperatorExpression.setResolvedType(type);
		return null;
	}

}
