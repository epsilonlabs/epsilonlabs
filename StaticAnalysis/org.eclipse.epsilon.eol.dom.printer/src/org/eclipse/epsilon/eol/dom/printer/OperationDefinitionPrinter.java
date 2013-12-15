package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.*;



public class OperationDefinitionPrinter extends EolElementPrinter{

	@Override
	public String print(DomElement e, EolElementPrinterFactory f) {
		OperationDefinition operation = (OperationDefinition) e;
		String result = "";
		if(operation.getAnnotationBlock() != null)
		{
			result += f.print((DomElement) operation.getAnnotationBlock());
		}
		
		result += "operation ";
		if(operation.getContextType() != null)
		{
			result += f.print((DomElement) operation.getContextType()) + " ";
		}
		result += f.print((DomElement) operation.getName()) + "(";
		if(operation.getParameters().size() != 0)
		{
			result += f.print(operation.getParameters(), ", ") + ")";
		}
		else {
			result += ")";
		}
		if(operation.getReturnType() != null)
		{
			result += " : " + f.print((DomElement) operation.getReturnType()) + " ";
		}
		result += " {" + f.newline() + f.indent() + f.print((DomElement) operation.getBody()) + f.outdent() + f.newline() + f.whitespace() + "}";
		
		
		
		
		return result;
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof OperationDefinition;
	}

}
