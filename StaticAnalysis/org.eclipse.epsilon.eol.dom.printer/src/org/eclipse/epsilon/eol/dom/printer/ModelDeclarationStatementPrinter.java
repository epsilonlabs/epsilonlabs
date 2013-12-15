package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.ModelDeclarationStatement;

public class ModelDeclarationStatementPrinter extends StatementPrinter{

	@Override
	public String print(DomElement e, EolElementPrinterFactory f) {
		ModelDeclarationStatement statement = (ModelDeclarationStatement) e;
		String result = "";
		result += "model " + f.print((DomElement) statement.getName()) + 
				" alias " + f.print(statement.getAlias(), ", ") + 
				" driver " + f.print((DomElement) statement.getDriver());
		result += " {" + f.print(statement.getParameters(), ", ") + "};" + f.newline();
		return result;
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof ModelDeclarationStatement;
	}

}
