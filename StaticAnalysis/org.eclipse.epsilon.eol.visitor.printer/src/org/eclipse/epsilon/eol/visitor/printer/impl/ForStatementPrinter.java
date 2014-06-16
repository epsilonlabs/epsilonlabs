package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.ForStatement;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.ForStatementVisitor;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class ForStatementPrinter extends ForStatementVisitor<PrinterContext, Object>{

	@Override
	public Object visit(ForStatement forStatement, PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "";
		result += "for(" + controller.visit(forStatement.getIterator(), context) + " in " + controller.visit(forStatement.getIterated(), context) + ") {";
		result += context.newline();
		context.indent();
		result += controller.visit(forStatement.getBody(), context);
		context.outdent();
		result += context.newline();
		result += context.whitespace() + "}";
		return result;
	}

}
