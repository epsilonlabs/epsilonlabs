package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.metamodel.*;


public class WhileStatementPrinter extends StatementPrinter {

	public String print(EolElement e, EolElementPrinterFactory f) {
		WhileStatement statement = (WhileStatement) e;
		String result = "while (" + f.print((EolElement) statement.getCondition()) + ") {" + f.newline()
			+ f.indent() + f.print(statement.getBody()) + f.outdent() + f.newline() + 
			f.whitespace() + "}";
		return result;
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof WhileStatement;
	}

}
