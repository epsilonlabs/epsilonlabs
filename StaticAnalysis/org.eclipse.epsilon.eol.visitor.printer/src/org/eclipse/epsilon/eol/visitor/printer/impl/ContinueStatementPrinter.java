package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.ContinueStatement;
import org.eclipse.epsilon.eol.metamodel.visitor.ContinueStatementVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class ContinueStatementPrinter extends ContinueStatementVisitor<PrinterContext, Object>{

	@Override
	public Object visit(ContinueStatement continueStatement,
			PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "";
		result += context.whitespace();
		result += "continue;";
		return result;
	}

}
