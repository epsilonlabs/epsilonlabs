package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import org.eclipse.epsilon.eol.metamodel.AnyType;
import org.eclipse.epsilon.eol.metamodel.DivideOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.EolFactory;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.IntegerExpression;
import org.eclipse.epsilon.eol.metamodel.IntegerType;
import org.eclipse.epsilon.eol.metamodel.RealExpression;
import org.eclipse.epsilon.eol.metamodel.RealType;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.metamodel.visitor.DivideOperatorExpressionVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.problem.LogBook;
import org.eclipse.epsilon.eol.problem.imessages.IMessage_TypeResolution;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeInferenceManager;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeUtil;

public class DivideOperatorExpressionTypeResolver extends DivideOperatorExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(DivideOperatorExpression divideOperatorExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		controller.visitContents(divideOperatorExpression, context);
		
		Expression lhs = divideOperatorExpression.getLhs();
		Expression rhs = divideOperatorExpression.getRhs();
		
		Type lhsType = lhs.getResolvedType();
		Type rhsType = rhs.getResolvedType();
		
		Type type = EolFactory.eINSTANCE.createRealType();
		divideOperatorExpression.setResolvedType(type);
		context.setAssets(type, divideOperatorExpression);
		
		
		if(lhsType == null){
			LogBook.getInstance().addError(divideOperatorExpression.getLhs(), IMessage_TypeResolution.EXPRESSION_DOES_NOT_HAVE_A_TYPE);
			return null;
		}
		
		if(rhsType == null){
			LogBook.getInstance().addError(divideOperatorExpression.getRhs(), IMessage_TypeResolution.EXPRESSION_DOES_NOT_HAVE_A_TYPE);
			return null;
		}
		
		TypeUtil typeUtil = TypeUtil.getInstance();
		
		if (lhs instanceof RealExpression) {
			if (((RealExpression) lhs).getValue() == 0.0) {
				LogBook.getInstance().addError(lhs, IMessage_TypeResolution.DIVISION_BY_ZERO);
			}
		}
		
		if (lhs instanceof IntegerExpression) {
			if (((IntegerExpression) lhs).getValue() == 0) {
				LogBook.getInstance().addError(lhs, IMessage_TypeResolution.DIVISION_BY_ZERO);
			}
		}
		
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
					LogBook.getInstance().addError(divideOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
				}
			}
			else {
				LogBook.getInstance().addError(divideOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
			}
		}
		else {
			LogBook.getInstance().addError(lhs, IMessage_TypeResolution.EXPRESSION_NOT_NUMERAL);
		}
		
		if (lhsType instanceof IntegerType && rhsType instanceof IntegerType) {
			type = EolFactory.eINSTANCE.createIntegerType();
		}
		
		context.setAssets(type, divideOperatorExpression);
		divideOperatorExpression.setResolvedType(type);
		return null;
	}

}
