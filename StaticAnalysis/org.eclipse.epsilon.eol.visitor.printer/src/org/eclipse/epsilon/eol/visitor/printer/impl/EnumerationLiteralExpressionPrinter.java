package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.EnumerationLiteralExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EnumerationLiteralExpressionVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class EnumerationLiteralExpressionPrinter extends EnumerationLiteralExpressionVisitor<PrinterContext, Object>{

	@Override
	public Object visit(
			EnumerationLiteralExpression enumerationLiteralExpression,
			PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "";
		
		if (enumerationLiteralExpression.getModel() != null) {
			result += controller.visit(enumerationLiteralExpression.getModel(), context) + "!";
		}
		result += controller.visit(enumerationLiteralExpression.getEnumeration(), context) + "#" + controller.visit(enumerationLiteralExpression.getLiteral(), context);
		return result;
	}

}
