package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.ExprList;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.ExprListVisitor;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class ExprListPrinter extends ExprListVisitor<PrinterContext, Object>{

	@Override
	public Object visit(ExprList exprList, PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "";
		if (exprList.getExpressions().size() > 0) {
			result += controller.visit(exprList.getExpressions().get(0), context);
			for(int i = 1; i < exprList.getExpressions().size(); i++)
			{
				result += "," + controller.visit(exprList.getExpressions().get(i), context);
			}

		}
		return result;
	}

}
