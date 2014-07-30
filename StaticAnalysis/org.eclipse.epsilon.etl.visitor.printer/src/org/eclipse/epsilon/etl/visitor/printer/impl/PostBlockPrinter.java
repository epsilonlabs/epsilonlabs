package org.eclipse.epsilon.etl.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.NameExpression;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;
import org.eclipse.epsilon.etl.metamodel.PostBlock;
import org.eclipse.epsilon.etl.metamodel.visitor.EtlVisitorController;
import org.eclipse.epsilon.etl.metamodel.visitor.PostBlockVisitor;

public class PostBlockPrinter extends PostBlockVisitor<PrinterContext, Object>{

	@Override
	public Object visit(PostBlock postBlock, PrinterContext context,
			EtlVisitorController<PrinterContext, Object> controller) {
		String result = "";
		result += context.whitespace();
		result += "pre";
		NameExpression name = postBlock.getName();
		if (name != null) {
			result += " " + controller.visit(name, context);
		}
		result += " {";
		result += context.newline();
		context.indent();
		result += controller.visit(postBlock.getBody(), context);
		context.outdent();
		//result += context.newline();
		result += context.whitespace() + "}";
		
		return result;
	}

}
