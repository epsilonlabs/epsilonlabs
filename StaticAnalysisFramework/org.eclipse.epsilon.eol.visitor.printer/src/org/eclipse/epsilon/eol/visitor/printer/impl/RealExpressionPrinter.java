package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.RealExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.RealExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.printer.context.EOLPrinterContext;

public class RealExpressionPrinter extends RealExpressionVisitor<EOLPrinterContext, Object>{

	@Override
	public Object visit(RealExpression realExpression, EOLPrinterContext context,
			EolVisitorController<EOLPrinterContext, Object> controller) {
		
		return realExpression.getValue() + "";
	}

}
