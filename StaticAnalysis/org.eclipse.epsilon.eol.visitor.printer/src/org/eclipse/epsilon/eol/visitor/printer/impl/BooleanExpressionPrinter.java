package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.BooleanExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.BooleanExpressionVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class BooleanExpressionPrinter extends BooleanExpressionVisitor<PrinterContext, Object>{

	@Override
	public Object visit(BooleanExpression booleanExpression,
			PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "";
		result += booleanExpression.isVal();
		return result;
	}

}
