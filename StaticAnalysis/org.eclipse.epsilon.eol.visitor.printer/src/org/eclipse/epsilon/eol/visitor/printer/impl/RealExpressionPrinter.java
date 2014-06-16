package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.RealExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.RealExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class RealExpressionPrinter extends RealExpressionVisitor<PrinterContext, Object>{

	@Override
	public Object visit(RealExpression realExpression, PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		
		return realExpression.getVal() + "";
	}

}
