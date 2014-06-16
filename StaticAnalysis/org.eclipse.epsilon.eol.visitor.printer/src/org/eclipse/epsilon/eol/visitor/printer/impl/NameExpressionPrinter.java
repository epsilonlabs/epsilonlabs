package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

import org.eclipse.epsilon.eol.metamodel.NameExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.NameExpressionVisitor;

public class NameExpressionPrinter extends NameExpressionVisitor<PrinterContext, Object>{

	@Override
	public Object visit(NameExpression nameExpression, PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = nameExpression.getName();
		return result;
	}

}
