package org.eclipse.epsilon.eol.visitor.resolution.type.impl;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.AssignmentStatementVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.visitor.resolution.type.context.TypeResolutionContext;

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
			
			//if lhs is of type Any
			if (lhs.getResolvedType() instanceof AnyType) {
				
				if (lhs instanceof NameExpression && ((NameExpression) lhs).getResolvedContent() != null && ((NameExpression) lhs).getResolvedContent() instanceof VariableDeclarationExpression) {
					AnyType lhsType = (AnyType) lhs.getResolvedType();
					if (lhsType.getDynamicTypes() != null) {
						Type dynamicType = context.getDynamicType(lhsType);
						if (!context.getTypeUtil().isEqualOrGeneric(dynamicType, rhs.getResolvedType())) {
							VariableDeclarationExpression variableDeclarationExpression = (VariableDeclarationExpression) ((NameExpression) lhs).getResolvedContent();
							variableDeclarationExpression.getDefinitionPoints().add(assignmentStatement);
						}
					}
				}
				//get the type
				AnyType lhsType = (AnyType) lhs.getResolvedType(); 
				
				//copy the rhs resolved type
				Type typeCopy = EcoreUtil.copy(rhs.getResolvedType());
				//if rhs is also any
				if (typeCopy instanceof AnyType) {
					
				}
				//if not set the dynamic type to lhs
				else {
					lhsType.getDynamicTypes().add(typeCopy);
				}
				//context.setAssets(typeCopy, lhs);
			}
			else {
				Type lhsType = lhs.getResolvedType(); //get the resolved type of the lhs
				Type rhsType = rhs.getResolvedType(); //get the resolved type of the rhs
				
				//if rhs is of any type
				if (rhsType instanceof AnyType) {
					//fire a warning?
					
					//get the rhs type
					AnyType temp = (AnyType) rhsType;
					//if there is dynamic type
					if (temp.getDynamicTypes() != null) {
						//rhsType = temp.getTempType();
						//get the rhs dynamic type
						rhsType = context.getDynamicType(temp);
					}
					
					//
					if (rhsType instanceof AnyType || rhsType instanceof VoidType) {
						context.getLogBook().addWarning(rhs, "potential type mismatch");
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
	
}
