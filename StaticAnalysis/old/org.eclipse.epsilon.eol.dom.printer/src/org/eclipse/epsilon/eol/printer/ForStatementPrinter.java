package org.eclipse.epsilon.eol.printer;

import org.eclipse.epsilon.eol.metamodel.*;




public class ForStatementPrinter extends StatementPrinter {

	public String print(EolElement e, EolElementPrinterFactory f) {
		ForStatement s = (ForStatement) e;
		return "for (" + f.print((EolElement) s.getIterator()) + " in " + 
			f.print((EolElement) s.getIterated()) + ") {" + f.newline() + 
			f.indent() + f.print(s.getBody()) + f.outdent() + f.newline() 
			+ f.whitespace() + "}";
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof ForStatement;
	}

}
