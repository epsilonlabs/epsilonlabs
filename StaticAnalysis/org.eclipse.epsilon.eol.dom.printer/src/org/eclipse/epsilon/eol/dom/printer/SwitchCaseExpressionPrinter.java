package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.metamodel.*;

public class SwitchCaseExpressionPrinter extends SwitchCaseStatementPrinter{

	public String print(EolElement e, EolElementPrinterFactory f) {
		SwitchCaseExpressionStatement statement = (SwitchCaseExpressionStatement) e;
		String result = "case " + f.print((EolElement) ((SwitchCaseExpressionStatement) statement).getExpression());
		result += ":" + f.newline() + f.indent() + f.print(statement.getBody()) + f.outdent();
		return result;
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof SwitchCaseExpressionStatement;
	}

}
