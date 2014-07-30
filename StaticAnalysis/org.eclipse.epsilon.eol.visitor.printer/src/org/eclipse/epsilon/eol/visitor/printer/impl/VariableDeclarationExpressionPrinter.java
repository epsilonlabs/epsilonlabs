package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.AnyType;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.metamodel.VariableDeclarationExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.VariableDeclarationExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;
import org.omg.CORBA.Any;

public class VariableDeclarationExpressionPrinter extends VariableDeclarationExpressionVisitor<PrinterContext, Object>{

	@Override
	public Object visit(
			VariableDeclarationExpression variableDeclarationExpression,
			PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		
		String result = "var";
		
		result += " " + controller.visit(variableDeclarationExpression.getName(), context);
		
		Type resolvedType = variableDeclarationExpression.getResolvedType();
		
		if (resolvedType != null) {
			if (resolvedType instanceof AnyType) {
				if (((AnyType) resolvedType).isDeclared()) {
					result += " : ";
				}
			}
			else {
				result += " : ";
			}
			if (variableDeclarationExpression.getCreate().isVal()) {
				result += "new ";
			}
			result += controller.visit(variableDeclarationExpression.getResolvedType(), context);
		}
		return result;
	}

}
