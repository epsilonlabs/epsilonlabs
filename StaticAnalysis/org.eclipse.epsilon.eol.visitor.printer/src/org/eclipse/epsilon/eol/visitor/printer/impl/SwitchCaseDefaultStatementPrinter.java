package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.SwitchCaseDefaultStatement;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.SwitchCaseDefaultStatementVisitor;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class SwitchCaseDefaultStatementPrinter extends SwitchCaseDefaultStatementVisitor<PrinterContext, Object>{

	@Override
	public Object visit(SwitchCaseDefaultStatement switchCaseDefaultStatement,
			PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "default :" + context.newline();
		context.indent();
		result += switchCaseDefaultStatement.getBody();
		context.outdent();
		return result;
	}

}
