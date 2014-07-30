package org.eclipse.epsilon.etl.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.NameExpression;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;
import org.eclipse.epsilon.etl.metamodel.PreBlock;
import org.eclipse.epsilon.etl.metamodel.visitor.EtlVisitorController;
import org.eclipse.epsilon.etl.metamodel.visitor.PreBlockVisitor;

public class PreBlockPrinter extends PreBlockVisitor<PrinterContext, Object>{

	@Override
	public Object visit(PreBlock preBlock, PrinterContext context,
			EtlVisitorController<PrinterContext, Object> controller) {
		String result = "";
		result += context.whitespace();
		result += "pre";
		NameExpression name = preBlock.getName();
		if (name != null) {
			result += " " + controller.visit(name, context);
		}
		result += " {";
		result += context.newline();
		context.indent();
		result += controller.visit(preBlock.getBody(), context);
		context.outdent();
		//result += context.newline();
		result += context.whitespace() + "}";
		
		return result;

	}

}
