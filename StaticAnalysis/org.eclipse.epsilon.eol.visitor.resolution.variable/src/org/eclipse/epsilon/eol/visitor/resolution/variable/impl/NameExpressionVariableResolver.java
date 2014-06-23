package org.eclipse.epsilon.eol.visitor.resolution.variable.impl;

import java.util.ArrayList;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.NameExpressionVisitor;
import org.eclipse.epsilon.eol.parse.Eol_EolParserRules.variableDeclarationExpression_return;
import org.eclipse.epsilon.eol.visitor.resolution.variable.context.PluralVariable;
import org.eclipse.epsilon.eol.visitor.resolution.variable.context.SimpleVariable;
import org.eclipse.epsilon.eol.visitor.resolution.variable.context.Variable;
import org.eclipse.epsilon.eol.visitor.resolution.variable.context.VariableResolutionContext;

public class NameExpressionVariableResolver extends NameExpressionVisitor<VariableResolutionContext, Object>{

	@Override
	public Object visit(NameExpression nameExpression,
			VariableResolutionContext context,
			EolVisitorController<VariableResolutionContext, Object> controller) {
		if (nameExpression.getName().equals("null")) {
			nameExpression.setResolvedContent(null);
		}
		else
		{
			Variable v = context.getStack().getVariable(nameExpression.getName());
			if(context.getStack().getVariable(nameExpression.getName()) != null)
			{
				if (v instanceof SimpleVariable) {
					nameExpression.setResolvedContent(((SimpleVariable) v).getVariable());	
				}
				else {
					ArrayList<VariableDeclarationExpression> content = new ArrayList<VariableDeclarationExpression>();

					for(VariableDeclarationExpression vde: ((PluralVariable)v).getValues())
					{	
						content.add(vde);
					}
					nameExpression.setResolvedContent(content);
				}
			}
			else {
				//this should not happen
			}
		}
		return null;
	}

}
