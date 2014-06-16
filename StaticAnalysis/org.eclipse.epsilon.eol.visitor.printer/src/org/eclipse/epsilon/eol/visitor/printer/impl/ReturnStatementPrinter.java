package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.ReturnStatement;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.ReturnStatementVisitor;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class ReturnStatementPrinter extends ReturnStatementVisitor<PrinterContext, Object>{

	@Override
	public Object visit(ReturnStatement returnStatement,
			PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "return";
		if (returnStatement.getReturned() != null) {
			result += " " + controller.visit(returnStatement.getReturned(), context);
		}
		result += ";";
		return result;
	}

}
