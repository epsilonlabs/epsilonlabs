package org.eclipse.epsilon.eol.dom.visitor.resolution.type.impl;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.dom.AnyType;
import org.eclipse.epsilon.eol.dom.AssignmentStatement;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.dom.NameExpression;
import org.eclipse.epsilon.eol.dom.PropertyCallExpression;
import org.eclipse.epsilon.eol.dom.Type;
import org.eclipse.epsilon.eol.dom.VariableDeclarationExpression;
import org.eclipse.epsilon.eol.dom.visitor.AssignmentStatementVisitor;
import org.eclipse.epsilon.eol.dom.visitor.EolVisitorController;
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
				//context.setAssets(typeCopy, lhs);
				lhsType.setTempType(typeCopy);
			}
			else {
				Type lhsType = lhs.getResolvedType(); //get the resolved type of the lhs
				Type rhsType = rhs.getResolvedType(); //get the resolved type of the rhs
				if (!context.getTypeUtil().isEqualOrGeneric(rhsType, lhsType)) { //if the types are not related at all
					context.getLogBook().addError(rhs, "Type mismatch");
				}
			}

		}
		else {
			context.getLogBook().addError(lhs, "can only assign values to variables and features");
		}
		return null;
	}

}
