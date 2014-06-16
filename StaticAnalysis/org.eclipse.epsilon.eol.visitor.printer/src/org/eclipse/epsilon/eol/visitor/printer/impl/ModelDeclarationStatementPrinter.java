package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.ModelDeclarationStatement;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.ModelDeclarationStatementVisitor;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class ModelDeclarationStatementPrinter extends ModelDeclarationStatementVisitor<PrinterContext, Object>{

	@Override
	public Object visit(ModelDeclarationStatement modelDeclarationStatement,
			PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "";
		result += "model ";
		if (modelDeclarationStatement.getName() != null) {
			result += controller.visit(modelDeclarationStatement.getName(), context);
		}
		result += " alias ";
		if (modelDeclarationStatement.getAlias() != null && modelDeclarationStatement.getAlias().size() > 0) {
			result += controller.visit(modelDeclarationStatement.getAlias().get(0), context);
			for(int i = 1; i < modelDeclarationStatement.getAlias().size(); i ++)
			{
				result += ", " + controller.visit(modelDeclarationStatement.getAlias().get(i), context);
			}
		}
		result += " driver ";
		if(modelDeclarationStatement.getDriver() != null)
		{
			result += controller.visit(modelDeclarationStatement.getDriver(), context);
		}
		result += " {";
		if (modelDeclarationStatement.getParameters() != null && modelDeclarationStatement.getParameters().size() > 0) {
			result += controller.visit(modelDeclarationStatement.getParameters().get(0), context);
			for(int i = 1; i < modelDeclarationStatement.getParameters().size(); i++)
			{
				result += ", " + controller.visit(modelDeclarationStatement.getParameters().get(i), context);
			}
		}
		return result;
	}

}
