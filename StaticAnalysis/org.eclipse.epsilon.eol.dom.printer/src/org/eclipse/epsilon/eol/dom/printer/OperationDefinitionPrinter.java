package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.*;



public class OperationDefinitionPrinter implements DomElementPrinter{

	@Override
	public String print(DomElement e, DomElementPrinterFactory f) {
		OperationDefinition exp = (OperationDefinition) e;
		return "operation" + 
				(exp.getContextType() == null ? " " : " " + exp.getContextType() + " ") + 
				exp.getName() + 
				"(" + (exp.getParameters() == null ? "" : f.print(exp.getParameters(), ",")) + ")" +  
				(exp.getReturnType() == null ? " " : " : " +exp.getReturnType()) + 
				"{" + f.newline() + f.indent() + f.print(exp.getStatements()) + f.outdent() + f.newline() + f.whitespace() + "}";
	}

}
