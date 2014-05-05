package org.eclipse.epsilon.eol.printer;

import org.eclipse.epsilon.eol.metamodel.*;

public class SwitchCaseDefaultStatementPrinter extends SwitchCaseStatementPrinter{

	@Override
	public String print(EolElement e, EolElementPrinterFactory f) {
		SwitchCaseDefaultStatement statement = (SwitchCaseDefaultStatement) e;
		String result = "default :";
		result += f.newline() + f.indent() + f.print(statement.getBody()) + f.outdent();
		return result;
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof SwitchCaseDefaultStatement;
	}

}
