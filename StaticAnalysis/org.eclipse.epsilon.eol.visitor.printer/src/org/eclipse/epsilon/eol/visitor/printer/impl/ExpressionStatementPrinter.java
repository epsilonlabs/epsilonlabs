package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.ExpressionStatement;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.ExpressionStatementVisitor;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class ExpressionStatementPrinter extends ExpressionStatementVisitor<PrinterContext, Object>{

	@Override
	public Object visit(ExpressionStatement expressionStatement,
			PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "";
		result += context.whitespace();
		result += controller.visit(expressionStatement.getExpression(), context);
		return result;
	}

}
