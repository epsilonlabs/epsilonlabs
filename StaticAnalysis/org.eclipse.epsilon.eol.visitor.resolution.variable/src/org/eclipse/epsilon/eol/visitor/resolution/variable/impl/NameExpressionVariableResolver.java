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
		//else proceed
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
					
					/*
					if (nameExpression.getContainer() instanceof AssignmentStatement && ((AssignmentStatement) nameExpression.getContainer()).getLhs().equals(nameExpression)) {
						//get the assignment statement
						AssignmentStatement at = (AssignmentStatement) nameExpression.getContainer();
						if (!context.isAssignmentToAvoid(at)) {
							//if the lhs of the assignment equals to the name expression, add this to the definition points collection to the variabledeclarationexpression
							vde.getDefinitionPoints().add(at);	
						}
					}
					//if the container is not an assignment statement
					else {
						//if the defition points are empty
						if (vde.getDefinitionPoints().size() == 0) {
							if (context.getCurrentEolElement() instanceof OperationDefinition) {
								
							}
							else {
								//throw error
								context.getLogBook().addError(nameExpression, "expression has not been initialised");
								//get the containing stateement
								Statement stmt = getContainingStatement(nameExpression);
								//if the containing statement is an assignment statement, throw into the to-avoid array
								if (stmt != null && stmt instanceof AssignmentStatement) {
									context.addAssignmentToAvoid((AssignmentStatement) stmt);
								}
							}
						}
					}*/
					
					
					
				}
				//if v is not a simple variable, then it should be defined in the model declaration statement
				else {
					//prepare the content
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
	
	
	public Statement getContainingStatement(NameExpression nameExpression)
	{
		EolElement eolElement = nameExpression.getContainer();
		while(!(eolElement instanceof Statement) && eolElement != null)
		{
			eolElement = eolElement.getContainer();
		}
		return (Statement) eolElement;
	}

}
