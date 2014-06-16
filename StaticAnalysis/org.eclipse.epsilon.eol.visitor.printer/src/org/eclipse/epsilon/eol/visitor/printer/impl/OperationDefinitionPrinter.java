package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.OperationDefinition;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.OperationDefinitionVisitor;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class OperationDefinitionPrinter extends OperationDefinitionVisitor<PrinterContext, Object>{

	@Override
	public Object visit(OperationDefinition operationDefinition,
			PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "";
		if(operationDefinition.getAnnotationBlock() != null)
		{
			result += controller.visit(operationDefinition.getAnnotationBlock(), context);
		}
		
		result += "operation ";
		if(operationDefinition.getContextType() != null)
		{
			result += controller.visit(operationDefinition.getContextType(), context) + " ";
		}
		result += controller.visit(operationDefinition.getName(), context) + "(";
		
		if(operationDefinition.getParameters() != null && operationDefinition.getParameters().size() != 0)
		{
			result += controller.visit(operationDefinition.getParameters().get(0), context);
			for(int i = 1; i < operationDefinition.getParameters().size(); i++)
			{
				result += controller.visit(operationDefinition.getParameters().get(i), context);
			}
			result += ")";
		}
		else {
			result += ")";
		}
		if(operationDefinition.getReturnType() != null)
		{
			result += " : " + controller.visit(operationDefinition.getReturnType(), context) + " ";
		}
		result += " {" + context.newline();
		context.indent();
		result += controller.visit(operationDefinition.getBody(), context);
		context.outdent();
		result += context.newline() + context.whitespace() + "}";

		return result;
	}

}
