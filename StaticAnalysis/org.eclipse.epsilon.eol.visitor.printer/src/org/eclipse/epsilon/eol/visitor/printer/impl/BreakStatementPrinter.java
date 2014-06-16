package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.BreakStatement;
import org.eclipse.epsilon.eol.metamodel.visitor.BreakStatementVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class BreakStatementPrinter extends BreakStatementVisitor<PrinterContext, Object>{

	@Override
	public Object visit(BreakStatement breakStatement, PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {

		String result = "";
		result += context.whitespace();
		result += "break;";
		return result;
	}

}
