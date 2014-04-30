package org.eclipse.epsilon.eol.printer;

import org.eclipse.epsilon.eol.metamodel.*;



public class OperationDefinitionPrinter extends EolElementPrinter{

	@Override
	public String print(EolElement e, EolElementPrinterFactory f) {
		OperationDefinition operation = (OperationDefinition) e;
		String result = "";
		if(operation.getAnnotationBlock() != null)
		{
			result += f.print((EolElement) operation.getAnnotationBlock());
		}
		
		result += "operation ";
		if(operation.getContextType() != null)
		{
			result += f.print((EolElement) operation.getContextType()) + " ";
		}
		result += f.print((EolElement) operation.getName()) + "(";
		if(operation.getParameters().size() != 0)
		{
			result += f.print(operation.getParameters(), ", ") + ")";
		}
		else {
			result += ")";
		}
		if(operation.getReturnType() != null)
		{
			result += " : " + f.print((EolElement) operation.getReturnType()) + " ";
		}
		result += " {" + f.newline() + f.indent() + f.print((EolElement) operation.getBody()) + f.outdent() + f.newline() + f.whitespace() + "}";
		
		
		
		
		return result;
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof OperationDefinition;
	}

}
