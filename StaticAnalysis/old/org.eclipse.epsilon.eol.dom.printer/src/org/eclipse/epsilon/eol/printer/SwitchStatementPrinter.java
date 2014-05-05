package org.eclipse.epsilon.eol.printer;

import org.eclipse.epsilon.eol.metamodel.*;



public class SwitchStatementPrinter extends StatementPrinter {

	public String print(EolElement e, EolElementPrinterFactory f) {
		SwitchStatement statement = (SwitchStatement) e;
		String result = "switch (" + f.print((EolElement) statement.getExpression()) + ") {" + f.newline() + f.indent();
		if (statement.getCases() != null) {
			result += f.print(statement.getCases());
			result += f.newline();
		}
		
		if (statement.getDefault() != null) {
			result += f.print((EolElement) statement.getDefault());
			result += f.newline();
		}
		result += f.outdent() + f.whitespace() + "}";
		/*r = "switch (" + f.print((DomElement) statement.getExpression()) + ") {" + f.newline()
		+ f.indent() + f.print(statement.getCases()) + f.newline() + 
		f.outdent() + f.whitespace() + "}";*/
		return result;
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof SwitchStatement;
	}
	
}
