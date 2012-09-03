package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.*;


public class SwitchCaseStatementPrinter implements DomElementPrinter {

	public String print(DomElement e, DomElementPrinterFactory f) {
		SwitchCaseStatement statement = (SwitchCaseStatement) e;
		String r = "";
		
		if (statement instanceof SwitchCaseExpressionStatement) {
			r = "case " + f.print((DomElement) ((SwitchCaseExpressionStatement) statement).getExpression());
		}
		else {
			r = "default";
		}
		
		r+= ":" + f.newline() + f.indent() + f.print(statement.getBody())
		+ f.outdent();
		
		return r;
	}

}
