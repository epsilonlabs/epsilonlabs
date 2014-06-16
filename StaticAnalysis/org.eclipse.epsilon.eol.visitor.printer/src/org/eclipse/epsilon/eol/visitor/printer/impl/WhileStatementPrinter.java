package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

import org.eclipse.epsilon.eol.metamodel.WhileStatement;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.WhileStatementVisitor;

public class WhileStatementPrinter extends WhileStatementVisitor<PrinterContext, Object>{

	@Override
	public Object visit(WhileStatement whileStatement, PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "while (" + controller.visit(whileStatement.getCondition(), context) + ") {" + context.newline(); 
		context.indent();
		result += controller.visit(whileStatement.getBody(), context);
		context.outdent();
		result += context.newline() + context.whitespace() + "}";
		return result;
	}

}
