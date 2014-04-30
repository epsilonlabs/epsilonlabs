package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.metamodel.*;



public class ExpressionStatementPrinter extends StatementPrinter {

	public String print(EolElement e, EolElementPrinterFactory f) {
		ExpressionStatement statement = (ExpressionStatement) e;
		return f.print((EolElement) statement.getExpression()) + ";";
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof ExpressionStatement;
	}

}
