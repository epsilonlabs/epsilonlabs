package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

import org.eclipse.epsilon.eol.metamodel.EqualsOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.EqualsOperatorExpressionVisitor;

public class EqualsOperatorExpressionPrinter extends EqualsOperatorExpressionVisitor<PrinterContext, Object>{

	@Override
	public Object visit(EqualsOperatorExpression equalsOperatorExpression,
			PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "";
		result += controller.visit(equalsOperatorExpression.getLhs(), context);
		result += "=";
		result += controller.visit(equalsOperatorExpression.getRhs(), context);
		return result;
	}

}
