package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.*;



public class ExpressionStatementPrinter extends StatementPrinter {

	public String print(DomElement e, EolElementPrinterFactory f) {
		ExpressionStatement statement = (ExpressionStatement) e;
		return f.print((DomElement) statement.getExpression()) + ";";
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof ExpressionStatement;
	}

}
