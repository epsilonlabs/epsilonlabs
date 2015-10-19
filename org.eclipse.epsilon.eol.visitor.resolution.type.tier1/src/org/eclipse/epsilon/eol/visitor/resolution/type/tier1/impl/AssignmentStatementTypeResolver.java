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
import org.eclipse.epsilon.eol.problem.LogBook;
import org.eclipse.epsilon.eol.problem.imessages.IMessage_TypeResolution;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeInferenceManager;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeUtil;

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
			
			Type lhsType = lhs.getResolvedType(); //get the resolved type of the lhs 
			Type rhsType = rhs.getResolvedType(); //get the resolved type of the rhs

			if (lhsType == null) {
				//this should not happen as all expressions should have types
				LogBook.getInstance().addError(lhs, IMessage_TypeResolution.EXPRESSION_DOES_NOT_HAVE_A_TYPE);
				return null;
			}
			
			if (rhsType == null) {
				//this should not happen as all expressions should have types
				LogBook.getInstance().addError(rhs, IMessage_TypeResolution.EXPRESSION_DOES_NOT_HAVE_A_TYPE);
				return null;
			}
			

			
			//if lhs is of type Any, allow 
			if (TypeUtil.getInstance().isInstanceofAnyType(lhsType)) {
				if (lhs instanceof NameExpression) {
					NameExpression name = (NameExpression) lhs;
					if (name.getResolvedContent() instanceof VariableDeclarationExpression) {
						VariableDeclarationExpression var = (VariableDeclarationExpression) name.getResolvedContent();
						context.getTypeRegistry().assignType(var, rhsType);
					}
				}
				else if (lhs instanceof VariableDeclarationExpression) {
					VariableDeclarationExpression var = (VariableDeclarationExpression) lhs;
					context.getTypeRegistry().assignType(var, rhsType);
				}
				
				//Type assignedRhsType = EcoreUtil.copy(rhsType);
				//lhs.setResolvedType(assignedRhsType);
				//context.setAssets(assignedRhsType, lhs);
//				if (TypeUtil.getInstance().isInstanceofAnyType(rhsType)) {
//					for(Type t: ((AnyType)rhsType).getDynamicTypes())
//					{
//						((AnyType)lhsType).getDynamicTypes().add(t);
//					}
//				}
//				else {
//					((AnyType)lhsType).getDynamicTypes().add(rhsType);
//				}
			}
			else {
				//if rhs is of any type
				if (TypeUtil.getInstance().isInstanceofAnyType(rhsType)) {
					if (TypeInferenceManager.getInstance().containsDynamicType((AnyType) rhsType, lhsType.eClass())) {
						LogBook.getInstance().addWarning(rhs, IMessage_TypeResolution.POTENTIAL_TYPE_MISMATCH);
					}
					else {
						LogBook.getInstance().addWarning(rhs, IMessage_TypeResolution.TYPE_MISMATCH);
					}
					
				}
				else if (!context.getTypeUtil().isTypeEqualOrGeneric(rhsType, lhsType)) { //if the types are not related at all
						LogBook.getInstance().addError(rhs, IMessage_TypeResolution.TYPE_MISMATCH);
				}
			}
		
			
		}
		else {
			LogBook.getInstance().addError(lhs, IMessage_TypeResolution.INVALID_ASSIGNMENT_TARGET);
		}
		return null;
	}
}
