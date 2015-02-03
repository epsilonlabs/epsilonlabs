package org.eclipse.epsilon.eol.visitor.resolution.variable.impl;

import java.util.ArrayList;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.NameExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.variable.context.PluralVariable;
import org.eclipse.epsilon.eol.visitor.resolution.variable.context.SimpleVariable;
import org.eclipse.epsilon.eol.visitor.resolution.variable.context.Variable;
import org.eclipse.epsilon.eol.visitor.resolution.variable.context.VariableResolutionContext;

public class NameExpressionVariableResolver extends NameExpressionVisitor<VariableResolutionContext, Object>{

	@Override
	public Object visit(NameExpression nameExpression,
			VariableResolutionContext context,
			EolVisitorController<VariableResolutionContext, Object> controller) {
		//if the name of the expression is "null"
		if (nameExpression.getName().equals("null")) {
			nameExpression.setResolvedContent(null);
		}
		else
		{
			//get the variable from the stack
			Variable v = context.getStack().getVariable(nameExpression.getName());
			if(v != null)
			{
				//if v is a instnace of the simple variable
				if (v instanceof SimpleVariable) {
					//get the variable declaration from the variable
					VariableDeclarationExpression vde = (VariableDeclarationExpression) ((SimpleVariable) v).getVariable();
					//set the resolved content to the variable
					nameExpression.setResolvedContent(vde);
					//if the container of the name expression is a assignment statement
				}
				//if v is not a simple variable, then it should be defined in the model declaration statement
				else {
					ArrayList<VariableDeclarationExpression> content = new ArrayList<VariableDeclarationExpression>();

					//for all of the variable declaration expressions in the plural variable, add to the content arraylist
					for(VariableDeclarationExpression vde: ((PluralVariable)v).getValues())
					{
						content.add(vde);
					}
					//set the content array list to the name expression
					nameExpression.setResolvedContent(content);
				}
			}
			else {
				//this should happen but these should be the reserved keywords - we are not interested in it.
			}
		}
		return null;
	}
	
	
//	@Override
//	public Object visit(NameExpression nameExpression,
//			VariableResolutionContext context,
//			EolVisitorController<VariableResolutionContext, Object> controller) {
//		if (nameExpression.getName().equals("null")) {
//			nameExpression.setResolvedContent(null);
//		}
//		else
//		{
//			Variable v = context.getStack().getVariable(nameExpression.getName());
//			if(v != null)
//			{
//				if (v instanceof SimpleVariable) {
//					VariableDeclarationExpression vde = (VariableDeclarationExpression) ((SimpleVariable) v).getVariable();
//					nameExpression.setResolvedContent(vde);
//					
//					
//					if (nameExpression.getContainer() instanceof AssignmentStatement && ((AssignmentStatement) nameExpression.getContainer()).getLhs().equals(nameExpression)) {
//						AssignmentStatement at = (AssignmentStatement) nameExpression.getContainer();
//						if (!context.isAssignmentToAvoid(at)) {
//							vde.getDefinitionPoints().add(at);	
//						}
//					}
//					else {
//						if (vde.getDefinitionPoints().size() == 0) {
//							if (context.getCurrentEolElement() instanceof OperationDefinition) {
//								
//							}
//							else {
//								context.getLogBook().addError(nameExpression, "expression has not been initialised");
//								Statement stmt = getContainingStatement(nameExpression);
//								if (stmt != null && stmt instanceof AssignmentStatement) {
//									context.addAssignmentToAvoid((AssignmentStatement) stmt);
//								}
//							}
//						}
//					}
//				}
//				else {
//					ArrayList<VariableDeclarationExpression> content = new ArrayList<VariableDeclarationExpression>();
//					for(VariableDeclarationExpression vde: ((PluralVariable)v).getValues())
//					{	
//						content.add(vde);
//					}
//					nameExpression.setResolvedContent(content);
//				}
//			}
//			else {
//			}
//		}
//		return null;
//	}

	

}
