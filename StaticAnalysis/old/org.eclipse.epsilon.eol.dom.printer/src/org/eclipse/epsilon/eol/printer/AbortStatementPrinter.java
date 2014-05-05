package org.eclipse.epsilon.eol.printer;

import org.eclipse.epsilon.eol.metamodel.*;

public class AbortStatementPrinter extends StatementPrinter{

	@Override
	public String print(EolElement e, EolElementPrinterFactory f) {
		return "abort;";
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof AbortStatement;
	}

}
