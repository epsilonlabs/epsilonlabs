package org.eclipse.epsilon.etl.visitor.printer.impl;

import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;
import org.eclipse.epsilon.etl.metamodel.Guard;
import org.eclipse.epsilon.etl.metamodel.visitor.EtlVisitorController;
import org.eclipse.epsilon.etl.metamodel.visitor.GuardVisitor;

public class GuardPrinter extends GuardVisitor<PrinterContext, Object>{

	@Override
	public Object visit(Guard guard, PrinterContext context,
			EtlVisitorController<PrinterContext, Object> controller) {
		String result = "";
		result += context.whitespace();
		result += "guard:";
		if (guard.getCondition().getBlock() != null) {
			result += " {";
			result += context.newline();
			context.indent();
			context.outdent();
			result += controller.visit(guard.getCondition().getBlock(), context);
			result += context.whitespace() + "}";
		}
		else if (guard.getCondition().getExpression() != null) {
			result += " " + controller.visit(guard.getCondition().getExpression(), context);
		}
		result += context.newline();
		
		return result;
	}

}
