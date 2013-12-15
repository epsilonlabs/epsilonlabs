package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.*;


public class AssignmentStatementPrinter extends StatementPrinter {

	public String print(DomElement e, EolElementPrinterFactory f) {
		AssignmentStatement s = (AssignmentStatement) e;
		return f.print((DomElement) s.getLhs()) + " := " + f.print((DomElement) s.getRhs()) + ";";
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof AssignmentStatement;
	}

}
