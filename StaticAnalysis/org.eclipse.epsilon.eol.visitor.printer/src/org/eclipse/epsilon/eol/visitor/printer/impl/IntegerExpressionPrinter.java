package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.IntegerExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.IntegerExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class IntegerExpressionPrinter extends IntegerExpressionVisitor<PrinterContext, Object>{

	@Override
	public Object visit(IntegerExpression integerExpression,
			PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		return integerExpression.getVal() + "";
	}

}
