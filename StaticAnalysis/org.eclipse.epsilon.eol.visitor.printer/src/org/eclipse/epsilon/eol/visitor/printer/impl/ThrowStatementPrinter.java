package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.ThrowStatement;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.ThrowStatementVisitor;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class ThrowStatementPrinter extends ThrowStatementVisitor<PrinterContext, Object>{

	@Override
	public Object visit(ThrowStatement throwStatement, PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "throw";
		if (throwStatement.getThrown() != null) {
			result += " " + controller.visit(throwStatement.getThrown(), context); 
		}
		result += ";";
		return result;	
	}

}
