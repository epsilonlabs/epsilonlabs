package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import org.eclipse.epsilon.eol.metamodel.AndOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.AnyType;
import org.eclipse.epsilon.eol.metamodel.BinaryOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.BooleanType;
import org.eclipse.epsilon.eol.metamodel.CollectionType;
import org.eclipse.epsilon.eol.metamodel.ComparablePrimitiveType;
import org.eclipse.epsilon.eol.metamodel.EolFactory;
import org.eclipse.epsilon.eol.metamodel.EqualsOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.GreaterThanOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.GreaterThanOrEqualToOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.ImpliesOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.LessThanOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.LessThanOrEqualToOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.ModelElementType;
import org.eclipse.epsilon.eol.metamodel.NotEqualsOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.OrOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.PrimitiveType;
import org.eclipse.epsilon.eol.metamodel.RealType;
import org.eclipse.epsilon.eol.metamodel.StringType;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.metamodel.XorOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.BinaryOperatorExpressionVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.problem.LogBook;
import org.eclipse.epsilon.eol.problem.imessages.IMessage_TypeResolution;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeInferenceManager;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeUtil;

public class LogicalOperatorExpressionTypeResolver_T1 extends BinaryOperatorExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public boolean appliesTo(BinaryOperatorExpression binaryOperatorExpression,
			TypeResolutionContext context) {
		return binaryOperatorExpression instanceof AndOperatorExpression ||
				binaryOperatorExpression instanceof OrOperatorExpression ||
				binaryOperatorExpression instanceof ImpliesOperatorExpression ||
				binaryOperatorExpression instanceof XorOperatorExpression ||
				binaryOperatorExpression instanceof GreaterThanOperatorExpression ||
				binaryOperatorExpression instanceof GreaterThanOrEqualToOperatorExpression ||
				binaryOperatorExpression instanceof EqualsOperatorExpression ||
				binaryOperatorExpression instanceof NotEqualsOperatorExpression ||
				binaryOperatorExpression instanceof LessThanOperatorExpression ||
				binaryOperatorExpression instanceof LessThanOrEqualToOperatorExpression;				
	}

	@Override
	public Object visit(BinaryOperatorExpression binaryOperatorExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {

		
		controller.visit(binaryOperatorExpression.getLhs(), context);
		controller.visit(binaryOperatorExpression.getRhs(), context);
		
		BooleanType type = EolFactory.eINSTANCE.createBooleanType(); 
		binaryOperatorExpression.setResolvedType(type);
		context.setAssets(type, binaryOperatorExpression);
		
		Expression lhs = binaryOperatorExpression.getLhs();
		Expression rhs = binaryOperatorExpression.getRhs();
		
		Type lhsType = lhs.getResolvedType();
		Type rhsType = rhs.getResolvedType();
		
		TypeUtil typeUtil = TypeUtil.getInstance();
		
		if (lhsType == null) {
			LogBook.getInstance().addError(lhs, IMessage_TypeResolution.EXPRESSION_DOES_NOT_HAVE_A_TYPE);
			return null;
		}
		
		if (rhsType == null) {
			LogBook.getInstance().addError(rhs, IMessage_TypeResolution.EXPRESSION_DOES_NOT_HAVE_A_TYPE);
			return null;
		}
		
		if (isLogicalOperator(binaryOperatorExpression)) {
			
			if (lhsType instanceof BooleanType) {
				if (rhsType instanceof BooleanType) {
					
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
				if (rhsType instanceof BooleanType) {
					if (!TypeInferenceManager.getInstance().containsDynamicType((AnyType) lhsType, rhsType.eClass())) {
						LogBook.getInstance().addError(lhs, IMessage_TypeResolution.EXPRESSION_NOT_NUMERAL);
					}
				}
				else if (typeUtil.isInstanceofAnyType(rhsType)) {
					boolean match = false;
					for(Type t: ((AnyType)rhsType).getDynamicTypes())
					{
						if (t instanceof BooleanType) {
							//try if there exists a type in lhs that is equal to t
							if (TypeUtil.getInstance().isTypeEqual(t, TypeInferenceManager.getInstance().getDynamicType((AnyType) lhsType, t.eClass()))) {
								LogBook.getInstance().addWarning(lhs, IMessage_TypeResolution.EXPRESSION_IS_ANYTYPE);
								match = true;
							}
						}
					}
					if (!match) {
						LogBook.getInstance().addError(binaryOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
					}
				}
				else {
					LogBook.getInstance().addError(binaryOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
				}
			}
			else {
				LogBook.getInstance().addError(lhs, IMessage_TypeResolution.EXPRESSION_NOT_NUMERAL);
			}
		}

		
		//if is comparativeOperator
		else if (isComparativeOperator(binaryOperatorExpression)) {
			//if lhs or rhs is Anytype
			if (typeUtil.isInstanceofAnyType(lhsType) || typeUtil.isInstanceofAnyType(rhsType)) {
				//if lhs is any
				if (typeUtil.isInstanceofAnyType(lhsType)) {
					//if rhs is comparableprimitive
					if (rhsType instanceof ComparablePrimitiveType) {
						//if lhs is compatable to rhs
						if (TypeInferenceManager.getInstance().containsDynamicType((AnyType) lhsType, rhsType.eClass())) {
							LogBook.getInstance().addWarning(lhs, IMessage_TypeResolution.EXPRESSION_IS_ANYTYPE);
							return null;
						}
						else {
							LogBook.getInstance().addError(lhs, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.EXPECTED_TYPE, rhsType.getClass().getSimpleName()));	
						}
					}
					else {
						//if rhs is also any type
						if (typeUtil.isInstanceofAnyType(rhsType)) {
							//for each dynamic type
							boolean match = false;
							for(Type t: ((AnyType)rhsType).getDynamicTypes())
							{
								//if t is comparableprimitive
								if (t instanceof ComparablePrimitiveType) {
									//if lhstype contains t
									if (TypeInferenceManager.getInstance().containsDynamicType((AnyType) lhsType, t.eClass())) {
										LogBook.getInstance().addWarning(lhs, IMessage_TypeResolution.EXPRESSION_IS_ANYTYPE);
										match = true;
									}
								}
							}
							if (!match) {
								LogBook.getInstance().addError(binaryOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
							}
						}
						else {
							LogBook.getInstance().addError(binaryOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
						}
					}
				}
				//if rhs is anytype
				else if (typeUtil.isInstanceofAnyType(rhsType)) {
					//if lhs is comparativeprimitive
					if (lhsType instanceof ComparablePrimitiveType) {
						//if rhs contains lhs
						if (TypeInferenceManager.getInstance().containsDynamicType((AnyType) rhsType, lhsType.eClass())) {
							LogBook.getInstance().addWarning(rhs, IMessage_TypeResolution.EXPRESSION_IS_ANYTYPE);
						}
						else {
							LogBook.getInstance().addError(rhs, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.EXPECTED_TYPE, lhsType.getClass().getSimpleName()));	
						}
					}
					else {
						//if lhs is also any
						if (typeUtil.isInstanceofAnyType(lhsType)) {
							//for each dynamic type
							boolean match = false;
							for(Type t: ((AnyType)lhsType).getDynamicTypes())
							{
								if (t instanceof ComparablePrimitiveType) {
									if (TypeInferenceManager.getInstance().containsDynamicType((AnyType) rhsType, t.eClass())) {
										LogBook.getInstance().addWarning(rhs, IMessage_TypeResolution.EXPRESSION_IS_ANYTYPE);
										match = true;
									}
								}
							}
							if (!match) {
								LogBook.getInstance().addError(binaryOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
							}
						}
						else {
							LogBook.getInstance().addError(binaryOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
						}
					}
					
				}
				return null;
			}
			else if (lhsType instanceof ComparablePrimitiveType && rhsType instanceof ComparablePrimitiveType) {
				if (lhsType instanceof RealType) {
					if (rhsType instanceof RealType) {
						
					}
					else {
						LogBook.getInstance().addError(rhs, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.EXPECTED_TYPE, lhsType.getClass().getSimpleName()));
					}
				}
				else {
					if (rhsType instanceof StringType) {
						
					}
					else {
						LogBook.getInstance().addError(rhs, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.EXPECTED_TYPE, lhsType.getClass().getSimpleName()));
					}
				}
			}
			else {
				if (!(lhsType instanceof ComparablePrimitiveType)) {
					LogBook.getInstance().addError(lhs, IMessage_TypeResolution.EXPRESSION_SHOULD_BE_COMPARABLE);
				}
				if (!(rhsType instanceof ComparablePrimitiveType)) {
					LogBook.getInstance().addError(rhs, IMessage_TypeResolution.EXPRESSION_SHOULD_BE_COMPARABLE);
				}
			}
		}
		else if(isEqualityComparisonOperator(binaryOperatorExpression))
		{
			//if lhs or rhs is anytype
			if (typeUtil.isInstanceofAnyType(lhsType) || typeUtil.isInstanceofAnyType(rhsType)) {
				//if lhs is any
				if (typeUtil.isInstanceofAnyType(lhsType)) {
					//if rhs is also any
					if (typeUtil.isInstanceofAnyType(rhsType)) {
						//for each dynamic type
						boolean match = false;
						for(Type t: ((AnyType)rhsType).getDynamicTypes())
						{
							//try if there exists a type in lhs that is equal to t
							if (TypeUtil.getInstance().isTypeEqual(t, TypeInferenceManager.getInstance().getDynamicType((AnyType) lhsType, t.eClass()))) {
								LogBook.getInstance().addWarning(lhs, IMessage_TypeResolution.EXPRESSION_IS_ANYTYPE);
								match = true;
							}
						}
						if (!match) {
							LogBook.getInstance().addError(binaryOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
						}
					}
					else {
						//try if there exists a type in lhs that is equal to rhs
						if (TypeUtil.getInstance().isTypeEqual(rhsType, TypeInferenceManager.getInstance().getDynamicType((AnyType) lhsType, rhsType.eClass()))) {
							LogBook.getInstance().addWarning(lhs, IMessage_TypeResolution.EXPRESSION_IS_ANYTYPE);
						}
						else {
							LogBook.getInstance().addError(lhs, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.EXPECTED_TYPE, rhsType.getClass().getSimpleName()));	
						}
					}
				}
				//if rhs is any
				else if (typeUtil.isInstanceofAnyType(rhsType)) {
					//if lhs is also any
					if (typeUtil.isInstanceofAnyType(lhsType)) {
						
						boolean match = false;
						for(Type t: ((AnyType)lhsType).getDynamicTypes())
						{
							//try if there exists a type in rhs that is equal to t
							if (TypeUtil.getInstance().isTypeEqual(t, TypeInferenceManager.getInstance().getDynamicType((AnyType) rhsType, t.eClass()))) {
								LogBook.getInstance().addWarning(rhs, IMessage_TypeResolution.EXPRESSION_IS_ANYTYPE);
								match = true;
							}
						}
						if (!match) {
							LogBook.getInstance().addError(binaryOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
						}
					}
					else {
						//try if there exists a type in rhs that is equalt to lhs
						if (TypeUtil.getInstance().isTypeEqual(lhsType, TypeInferenceManager.getInstance().getDynamicType((AnyType) rhsType, lhsType.eClass()))) {
							LogBook.getInstance().addWarning(rhs, IMessage_TypeResolution.EXPRESSION_IS_ANYTYPE);
						}
						else {
							LogBook.getInstance().addError(rhs, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.EXPECTED_TYPE, lhsType.getClass().getSimpleName()));	
						}
					}
				}
			}
			else if (lhsType instanceof PrimitiveType && rhsType instanceof PrimitiveType) {
				if (lhsType instanceof BooleanType) {
					if (rhsType instanceof BooleanType) {
						
					}
					else {
						LogBook.getInstance().addError(rhs, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.EXPECTED_TYPE, lhsType.getClass().getSimpleName()));
					}
					return null;
				}
				else if (lhsType instanceof StringType) {
					if (rhsType instanceof StringType) {
						
					}
					else {
						LogBook.getInstance().addError(rhs, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.EXPECTED_TYPE, lhsType.getClass().getSimpleName()));
					}
					return null;
				}
				else if (lhsType instanceof RealType)
				{
					if (rhsType instanceof RealType) {
						
					}
					else {
						LogBook.getInstance().addError(rhs, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.EXPECTED_TYPE, lhsType.getClass().getSimpleName()));
					}	
					return null;
				}
			}
			else {
				if (lhsType instanceof CollectionType && rhsType instanceof CollectionType) {
					if (TypeUtil.getInstance().isTypeEqual(lhsType, rhsType)) {
						
					}
					else {
						LogBook.getInstance().addError(binaryOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
					}
				}
				else if (lhsType instanceof ModelElementType && rhsType instanceof ModelElementType) {
					if (TypeUtil.getInstance().isTypeEqual(lhsType, rhsType)) {
						
					}
					else {
						LogBook.getInstance().addError(binaryOperatorExpression, IMessage_TypeResolution.OPERAND_TYPE_MISMATCH);
					}
				}
			}
		}
		return null;
	}	
	
	public boolean isLogicalOperator(BinaryOperatorExpression op)
	{
		boolean result = false;
		if (op instanceof AndOperatorExpression ||
				op instanceof OrOperatorExpression ||
				op instanceof ImpliesOperatorExpression ||
				op instanceof XorOperatorExpression) {
			result = true;
		}
		return result;
	}
	
	public boolean isComparativeOperator(BinaryOperatorExpression op)
	{
		boolean result = false;
		if (op instanceof GreaterThanOperatorExpression ||
				op instanceof GreaterThanOrEqualToOperatorExpression ||
				op instanceof LessThanOperatorExpression ||
				op instanceof LessThanOrEqualToOperatorExpression) {
			result = true;
		}
		return result;
	}
	
	public boolean isEqualityComparisonOperator(BinaryOperatorExpression op)
	{
		boolean result = false;
		if (op instanceof EqualsOperatorExpression ||
				op instanceof NotEqualsOperatorExpression) {
			result = true;
		}
		return result;
	}

}
