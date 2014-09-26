package org.eclipse.epsilon.eol.visitor.resolution.type.impl;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.PlusOperatorExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.context.TypeResolutionContext;

public class PlusOperatorExpressionTypeResolver extends PlusOperatorExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(PlusOperatorExpression plusOperatorExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		controller.visitContents(plusOperatorExpression, context); //visit contents first
		
		Type type = null;
		
		Type lhsType = plusOperatorExpression.getLhs().getResolvedType(); //get the lhs type
		Type rhsType = plusOperatorExpression.getRhs().getResolvedType(); //get the rhs type
		
		if(lhsType == null)
		{
			context.getLogBook().addError(plusOperatorExpression.getLhs(), "Cannot resolve type");
		}
		
		if(rhsType == null)
		{
			context.getLogBook().addError(plusOperatorExpression.getRhs(), "Cannot resolve type");
		}
		
		if (lhsType instanceof AnyType && rhsType instanceof AnyType) {
			type = context.getEolFactory().createAnyType();
		}
		//if both sides are of primitive type
		else if (lhsType instanceof PrimitiveType && rhsType instanceof PrimitiveType) {
			//if either one is a string
			if (lhsType instanceof StringType || rhsType instanceof StringType) {
				type = context.getEolFactory().createStringType();
			}
			else if (lhsType instanceof BooleanType || rhsType instanceof BooleanType) {
				type = context.getEolFactory().createStringType(); 
			}
			else if (lhsType instanceof RealType || rhsType instanceof RealType) {
				type = context.getEolFactory().createRealType();
			}
			else if (lhsType instanceof IntegerType && rhsType instanceof IntegerType) {
				type = context.getEolFactory().createIntegerType();
			}
			
		}
		else if (lhsType instanceof CollectionType && rhsType instanceof CollectionType) {
			if (context.getTypeUtil().isEqualOrGeneric(lhsType, rhsType)) {
				type = EcoreUtil.copy(lhsType);
			}
		}
		else if ((lhsType instanceof AnyType && !(rhsType instanceof AnyType)) || (!(lhsType instanceof AnyType) && rhsType instanceof AnyType)) {
			if (lhsType instanceof AnyType) {
				type = EcoreUtil.copy(rhsType);
			}
			else {
				type = EcoreUtil.copy(lhsType);
			}
		}
		
		context.setAssets(type, plusOperatorExpression);
		plusOperatorExpression.setResolvedType(type);

		return null;
	}
	
	


}
