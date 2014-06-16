package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.VariableDeclarationExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.VariableDeclarationExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class VariableDeclarationExpressionPrinter extends VariableDeclarationExpressionVisitor<PrinterContext, Object>{

	@Override
	public Object visit(
			VariableDeclarationExpression variableDeclarationExpression,
			PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		
		String result = "var";
		
		result += " " + controller.visit(variableDeclarationExpression.getName(), context);
		
		if (variableDeclarationExpression.getResolvedType() != null) {
			result += " : ";
			if (variableDeclarationExpression.getCreate().isVal()) {
				result += "new ";
			}
			result += controller.visit(variableDeclarationExpression.getResolvedType(), context);
		}
		return result;
	}

}
