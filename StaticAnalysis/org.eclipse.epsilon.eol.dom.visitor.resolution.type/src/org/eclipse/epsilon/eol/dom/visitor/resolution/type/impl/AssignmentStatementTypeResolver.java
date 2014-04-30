package org.eclipse.epsilon.eol.dom.visitor.resolution.type.impl;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.AssignmentStatementVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.context.TypeResolutionContext;

public class AssignmentStatementTypeResolver extends AssignmentStatementVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(AssignmentStatement assignmentStatement,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		Expression lhs = assignmentStatement.getLhs(); //get lhs expression
		Expression rhs = assignmentStatement.getRhs(); //get rhs expression
		if (lhs instanceof PropertyCallExpression || lhs instanceof NameExpression || lhs instanceof VariableDeclarationExpression) {
			controller.visit(rhs, context); //visit rhs
			controller.visit(lhs, context); //visit lhs
			
			if (lhs.getResolvedType() instanceof AnyType) { //if lhs is of type Any
				AnyType lhsType = (AnyType) lhs.getResolvedType(); //get the type
				Type typeCopy = EcoreUtil.copy(rhs.getResolvedType());
				if (typeCopy instanceof AnyType) {
					
				}
				else {
					lhsType.setDynamicType(typeCopy);
				}
				//context.setAssets(typeCopy, lhs);
			}
			else {
				Type lhsType = lhs.getResolvedType(); //get the resolved type of the lhs
				Type rhsType = rhs.getResolvedType(); //get the resolved type of the rhs
				if (rhsType instanceof AnyType) {
					context.getLogBook().addWarning(rhs, "potential type mismatch");
					AnyType temp = (AnyType) rhsType;
					if (temp.getDynamicType() != null) {
						//rhsType = temp.getTempType();
						rhsType = getDynamicType(temp);
					}
					
					if (rhsType instanceof AnyType || rhsType instanceof VoidType) {
						
					}
					else if (!context.getTypeUtil().isEqualOrGeneric(rhsType, lhsType)) { //if the types are not related at all
						context.getLogBook().addError(rhs, "Type mismatch");
					}
				}
				else if (rhsType instanceof VoidType) {
					context.getLogBook().addWarning(rhs, "potential type mismatch");
				}
				else if (!context.getTypeUtil().isEqualOrGeneric(rhsType, lhsType)) { //if the types are not related at all
					context.getLogBook().addError(rhs, "Type mismatch");
				}
			}

		}
		else {
			context.getLogBook().addError(lhs, "can only assign values to variables and features");
		}
		return null;
	}
	
	public Type getDynamicType(AnyType anyType)
	{
		while(anyType.getDynamicType() != null)
		{
			if (anyType.getDynamicType() instanceof AnyType) {
				anyType = (AnyType) anyType.getDynamicType();
			}
			else {
				return anyType.getDynamicType();
			}
		}
		return anyType;
	}

}
