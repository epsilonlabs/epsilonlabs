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
			controller.visit(name, context);
			//context.getStack().putVariable(name, false);	
			context.putModelName(name.getName().getName());
		}
		else {
			context.getLogBook().addError(modelDeclarationStatement, "model declaration needs to define a name");
		}
		
		for(VariableDeclarationExpression alias: modelDeclarationStatement.getAlias())
		{
			if (context.isKeyWordSimple(alias.getName().getName())) {
				context.getLogBook().addError(alias.getName(), context.RESERVED_KEYWORD);
			}
			else {
				String aliasName = alias.getName().getName();
				if (context.nameDefinedInModelNames(aliasName)) {
					context.getLogBook().addError(alias, "name already used to define a model, please choose another alias");
				}
				else {
					context.getStack().putVariable(alias, true);	
				}
			}
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
