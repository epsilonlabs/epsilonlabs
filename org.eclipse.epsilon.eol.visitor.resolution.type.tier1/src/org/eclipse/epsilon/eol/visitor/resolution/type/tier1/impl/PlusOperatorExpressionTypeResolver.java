package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.AnyType;
import org.eclipse.epsilon.eol.metamodel.EolFactory;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.IntegerType;
import org.eclipse.epsilon.eol.metamodel.PlusOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.RealType;
import org.eclipse.epsilon.eol.metamodel.StringType;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.PlusOperatorExpressionVisitor;
import org.eclipse.epsilon.eol.problem.LogBook;
import org.eclipse.epsilon.eol.problem.imessages.IMessage_TypeResolution;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeInferenceManager;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeUtil;

public class PlusOperatorExpressionTypeResolver extends PlusOperatorExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(PlusOperatorExpression plusOperatorExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		controller.visitContents(plusOperatorExpression, context);
		
		Expression lhs = plusOperatorExpression.getLhs();
		Expression rhs = plusOperatorExpression.getRhs();
		
		Type lhsType = lhs.getResolvedType();
		Type rhsType = rhs.getResolvedType();
		
		Type type = EolFactory.eINSTANCE.createRealType();
		plusOperatorExpression.setResolvedType(type);
		context.setAssets(type, plusOperatorExpression);
		
		
		if(lhsType == null){
			LogBook.getInstance().addError(plusOperatorExpression.getLhs(), IMessage_TypeResolution.EXPRESSION_DOES_NOT_HAVE_A_TYPE);
			return null;
		}
		
		if(rhsType == null){
			LogBook.getInstance().addError(plusOperatorExpression.getRhs(), IMessage_TypeResolution.EXPRESSION_DOES_NOT_HAVE_A_TYPE);
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
		else if (lhsType instanceof StringType) {
			if (rhsType instanceof StringType) {
				Type tempType = EolFactory.eINSTANCE.createStringType();
				plusOperatorExpression.setResolvedType(tempType);
				context.setAssets(type, plusOperatorExpression);
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
			else if (rhsType instanceof StringType) {
				if (!TypeInferenceManager.getInstance().containsDynamicType((AnyType) lhsType, rhsType.eClass())) {
					LogBook.getInstance().addError(lhs, IMessage_TypeResolution.EXPRESSION_NOT_NUMERAL);
				}
			}
			else if (typeUtil.isInstanceofAnyType(rhsType)) {
				boolean match = false;
				for(Type t: ((AnyType)rhsType).getDynamicTypes())
				{
					if (t instanceof RealType || t instanceof StringType) {
						//try if there exists a type in lhs that is equal to t
						if (TypeUtil.getInstance().isTypeEqual(t, TypeInferenceManager.getInstance().getDynamicType((AnyType) lhsType, t.eClass()))) {
							type = EcoreUtil.copy(t);
							// LogBook.getInstance().addWarning(lhs, IMessage_TypeResolution.EXPRESSION_IS_ANYTYPE);
							match = true;
							break;
						}
					}
				}
				if (!match) {
					LogBook.getInstance().addError(plusOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
				}
			}
			else {
				LogBook.getInstance().addError(plusOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
			}
		}
		else {
			LogBook.getInstance().addError(lhs, IMessage_TypeResolution.EXPRESSION_NOT_NUMERAL);
		}
		
		if (lhsType instanceof IntegerType && rhsType instanceof IntegerType) {
			type = EolFactory.eINSTANCE.createIntegerType();
		}
		
		context.setAssets(type, plusOperatorExpression);
		plusOperatorExpression.setResolvedType(type);
		return null;
	}
}
