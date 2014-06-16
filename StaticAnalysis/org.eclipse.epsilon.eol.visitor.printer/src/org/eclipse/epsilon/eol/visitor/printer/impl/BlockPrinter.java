package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.Block;
import org.eclipse.epsilon.eol.metamodel.Statement;
import org.eclipse.epsilon.eol.metamodel.visitor.BlockVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class BlockPrinter extends BlockVisitor<PrinterContext, Object>{

	@Override
	public Object visit(Block block, PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "";
		for(Statement stmt: block.getStatements())
		{
			result += controller.visit(stmt, context);
			result += context.newline();
		}
		return result;
	}

}
