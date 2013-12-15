package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.SwitchCaseDefaultStatement;

public class SwitchCaseDefaultStatementPrinter extends SwitchCaseStatementPrinter{

	@Override
	public String print(DomElement e, EolElementPrinterFactory f) {
		SwitchCaseDefaultStatement statement = (SwitchCaseDefaultStatement) e;
		String result = "default :";
		result += f.newline() + f.indent() + f.print(statement.getBody()) + f.outdent();
		return result;
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof SwitchCaseDefaultStatement;
	}

}
