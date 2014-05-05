package org.eclipse.epsilon.eol.printer;

import org.eclipse.epsilon.eol.metamodel.*;


public class BreakStatementPrinter extends StatementPrinter {

	public String print(EolElement e, EolElementPrinterFactory f) {
		return "break;";
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof BreakStatement;
	}

}
