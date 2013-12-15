package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.SwitchCaseExpressionStatement;

public class SwitchCaseExpressionPrinter extends SwitchCaseStatementPrinter{

	public String print(DomElement e, EolElementPrinterFactory f) {
		SwitchCaseExpressionStatement statement = (SwitchCaseExpressionStatement) e;
		String result = "case " + f.print((DomElement) ((SwitchCaseExpressionStatement) statement).getExpression());
		result += ":" + f.newline() + f.indent() + f.print(statement.getBody()) + f.outdent();
		return result;
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof SwitchCaseExpressionStatement;
	}

}
