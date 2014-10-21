package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import org.eclipse.epsilon.eol.metamodel.AnyType;
import org.eclipse.epsilon.eol.metamodel.AssignmentStatement;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.NameExpression;
import org.eclipse.epsilon.eol.metamodel.PropertyCallExpression;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.metamodel.VariableDeclarationExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.AssignmentStatementVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class AssignmentStatementTypeResolver extends AssignmentStatementVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(AssignmentStatement assignmentStatement,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		Expression lhs = assignmentStatement.getLhs(); //get lhs expression
		Expression rhs = assignmentStatement.getRhs(); //get rhs expression
		
		//lhs should be either a name expression, a property call, or a variable declaration expression
		if (lhs instanceof PropertyCallExpression || lhs instanceof NameExpression || lhs instanceof VariableDeclarationExpression) {
			//visit rhs to resolve type
			controller.visit(rhs, context); 
			//visit lhs to resolve type
			controller.visit(lhs, context); 
			
			//if lhs is of type Any, allow 
			if (lhs.getResolvedType() instanceof AnyType) {
			}
			else {
				Type lhsType = lhs.getResolvedType(); //get the resolved type of the lhs
				Type rhsType = rhs.getResolvedType(); //get the resolved type of the rhs
				
				//if rhs is of any type
				if (rhsType instanceof AnyType) {
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
}
