package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.metamodel.*;

public class ModelDeclarationStatementPrinter extends StatementPrinter{

	@Override
	public String print(EolElement e, EolElementPrinterFactory f) {
		ModelDeclarationStatement statement = (ModelDeclarationStatement) e;
		String result = "";
		result += "model " + f.print((EolElement) statement.getName()) + 
				" alias " + f.print(statement.getAlias(), ", ") + 
				" driver " + f.print((EolElement) statement.getDriver());
		result += " {" + f.print(statement.getParameters(), ", ") + "};" + f.newline();
		return result;
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof ModelDeclarationStatement;
	}

}
