package org.eclipse.epsilon.eol.visitor.resolution.variable.impl;

import org.eclipse.epsilon.eol.metamodel.ModelDeclarationStatement;
import org.eclipse.epsilon.eol.metamodel.VariableDeclarationExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.ModelDeclarationStatementVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.variable.context.VariableResolutionContext;

public class ModelDeclarationStatementVariableResolver extends ModelDeclarationStatementVisitor<VariableResolutionContext, Object>{

	@Override
	public Object visit(ModelDeclarationStatement modelDeclarationStatement,
			VariableResolutionContext context,
			EolVisitorController<VariableResolutionContext, Object> controller) {
		VariableDeclarationExpression name = modelDeclarationStatement.getName();
		if (name != null) {
			context.getStack().putVariable(name, false);	
		}
		else {
			context.getLogBook().addError(modelDeclarationStatement, "model declaration needs to define a name");
		}
		
		for(VariableDeclarationExpression alias: modelDeclarationStatement.getAlias())
		{
			context.getStack().putVariable(alias, true);
		}
		
		VariableDeclarationExpression driver = modelDeclarationStatement.getDriver();
		if (driver != null) {
		}
		else {
			context.getLogBook().addError(modelDeclarationStatement, "model loading driver needs to be specified");
		}
		
		return null;
	}

}
