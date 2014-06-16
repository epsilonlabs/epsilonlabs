package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

import org.eclipse.epsilon.eol.metamodel.DeleteStatement;
import org.eclipse.epsilon.eol.metamodel.visitor.DeleteStatementVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;

public class DeleteStatementPrinter extends DeleteStatementVisitor<PrinterContext, Object>{

	@Override
	public Object visit(DeleteStatement deleteStatement,
			PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "";
		result += context.whitespace();
		result += "delete";
		if (deleteStatement.getDeleted() != null) {
			result += " " + controller.visit(deleteStatement.getDeleted(), context);
		}
		result += ";";
		
		return result;
	}

}
