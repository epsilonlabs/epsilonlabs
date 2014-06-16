package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.AbortStatement;
import org.eclipse.epsilon.eol.metamodel.visitor.AbortStatementVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class AbortStatementPrinter extends AbortStatementVisitor<PrinterContext, Object>{

	@Override
	public Object visit(AbortStatement abortStatement, PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {

		return "abort;";
	}

}
