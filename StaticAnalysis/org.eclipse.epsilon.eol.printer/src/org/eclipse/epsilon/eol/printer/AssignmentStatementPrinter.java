package org.eclipse.epsilon.eol.printer;

import org.eclipse.epsilon.eol.metamodel.*;


public class AssignmentStatementPrinter extends StatementPrinter {

	public String print(EolElement e, EolElementPrinterFactory f) {
		AssignmentStatement s = (AssignmentStatement) e;
		return f.print((EolElement) s.getLhs()) + " := " + f.print((EolElement) s.getRhs()) + ";";
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof AssignmentStatement;
	}

}
