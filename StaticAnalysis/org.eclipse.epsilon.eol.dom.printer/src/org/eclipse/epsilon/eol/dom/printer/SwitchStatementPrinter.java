package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.*;



public class SwitchStatementPrinter extends StatementPrinter {

	public String print(DomElement e, EolElementPrinterFactory f) {
		SwitchStatement statement = (SwitchStatement) e;
		String result = "switch (" + f.print((DomElement) statement.getExpression()) + ") {" + f.newline() + f.indent();
		if (statement.getCases() != null) {
			result += f.print(statement.getCases());
			result += f.newline();
		}
		
		if (statement.getDefault() != null) {
			result += f.print((DomElement) statement.getDefault());
			result += f.newline();
		}
		result += f.outdent() + f.whitespace() + "}";
		/*r = "switch (" + f.print((DomElement) statement.getExpression()) + ") {" + f.newline()
		+ f.indent() + f.print(statement.getCases()) + f.newline() + 
		f.outdent() + f.whitespace() + "}";*/
		return result;
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof SwitchStatement;
	}
	
}
