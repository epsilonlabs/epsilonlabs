package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.ExpRange;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.ExpRangeVisitor;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class ExpRangePrinter extends ExpRangeVisitor<PrinterContext, Object>{

	@Override
	public Object visit(ExpRange expRange, PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "";
		result += controller.visit(expRange.getStart(), context) + ".." + controller.visit(expRange.getEnd(), context);
		return result;
	}

}
