package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.AndOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.AndOperatorExpressionVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class AndOperatorExpressionPrinter extends AndOperatorExpressionVisitor<PrinterContext, Object>{

	@Override
	public Object visit(AndOperatorExpression andOperatorExpression,
			PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {

		String result = "";
		result += controller.visit(andOperatorExpression.getLhs(), context);
		result += " and ";
		result += controller.visit(andOperatorExpression.getRhs(), context);
		return result;
	}

}
