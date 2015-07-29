package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import org.eclipse.epsilon.eol.metamodel.AnyType;
import org.eclipse.epsilon.eol.metamodel.EolFactory;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.IntegerType;
import org.eclipse.epsilon.eol.metamodel.MultiplyOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.RealType;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.MultiplyOperatorExpressionVisitor;
import org.eclipse.epsilon.eol.problem.LogBook;
import org.eclipse.epsilon.eol.problem.imessages.IMessage_TypeResolution;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeInferenceManager;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeUtil;

public class MultiplyOperatorExpressionTypeResolver extends MultiplyOperatorExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(MultiplyOperatorExpression multiplyOperatorExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		controller.visitContents(multiplyOperatorExpression, context);
		
		Expression lhs = multiplyOperatorExpression.getLhs();
		Expression rhs = multiplyOperatorExpression.getRhs();
		
		Type lhsType = lhs.getResolvedType();
		Type rhsType = rhs.getResolvedType();
		
		Type type = EolFactory.eINSTANCE.createRealType();
		multiplyOperatorExpression.setResolvedType(type);
		context.setAssets(type, multiplyOperatorExpression);
		
		
		if(lhsType == null){
			LogBook.getInstance().addError(multiplyOperatorExpression.getLhs(), IMessage_TypeResolution.EXPRESSION_DOES_NOT_HAVE_A_TYPE);
			return null;
		}
		
		if(rhsType == null){
			LogBook.getInstance().addError(multiplyOperatorExpression.getRhs(), IMessage_TypeResolution.EXPRESSION_DOES_NOT_HAVE_A_TYPE);
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
					LogBook.getInstance().addError(multiplyOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
				}
			}
			else {
				LogBook.getInstance().addError(multiplyOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
			}
		}
		else {
			LogBook.getInstance().addError(lhs, IMessage_TypeResolution.EXPRESSION_NOT_NUMERAL);
		}
		
		if (lhsType instanceof IntegerType && rhsType instanceof IntegerType) {
			type = EolFactory.eINSTANCE.createIntegerType();
		}
		
		context.setAssets(type, multiplyOperatorExpression);
		multiplyOperatorExpression.setResolvedType(type);
		return null;
	}

}
