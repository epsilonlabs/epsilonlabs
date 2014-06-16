package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.FormalParameterExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.FormalParameterExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class FormalParameterExpressionPrinter extends FormalParameterExpressionVisitor<PrinterContext, Object>{

	@Override
	public Object visit(FormalParameterExpression formalParameterExpression,
			PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "";
		result += controller.visit(formalParameterExpression.getName(), context);
		if(formalParameterExpression.getResolvedType() != null)
		{
			result += " : " + controller.visit(formalParameterExpression.getResolvedType(), context); 
		}
		return result;
	}

}
