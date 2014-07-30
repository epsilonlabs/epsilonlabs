package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.StringExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.StringExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class StringExpressionPrinter extends StringExpressionVisitor<PrinterContext, Object>{

	@Override
	public Object visit(StringExpression stringExpression,
			PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "\'" + stringExpression.getVal() + "\'"; 
		return result;
	}

}
