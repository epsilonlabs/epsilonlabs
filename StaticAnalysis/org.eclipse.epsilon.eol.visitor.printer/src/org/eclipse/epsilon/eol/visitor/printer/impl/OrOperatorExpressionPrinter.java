package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.OrOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.OrOperatorExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class OrOperatorExpressionPrinter extends OrOperatorExpressionVisitor<PrinterContext, Object>{

	@Override
	public Object visit(OrOperatorExpression orOperatorExpression,
			PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "";
		result += controller.visit(orOperatorExpression.getLhs(), context);
		result += " or ";
		result += controller.visit(orOperatorExpression.getRhs(), context);
		return result;
	}

}
