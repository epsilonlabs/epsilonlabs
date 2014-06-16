package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.AssignmentStatement;
import org.eclipse.epsilon.eol.metamodel.visitor.AssignmentStatementVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class AssignmentStatementPrinter extends AssignmentStatementVisitor<PrinterContext, Object>{

	@Override
	public Object visit(AssignmentStatement assignmentStatement,
			PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "";
		result += context.whitespace();
		result += controller.visit(assignmentStatement.getLhs(), context);
		result += " = ";
		result += controller.visit(assignmentStatement.getRhs(), context);
		result += ";";
		return result;
	}

}
