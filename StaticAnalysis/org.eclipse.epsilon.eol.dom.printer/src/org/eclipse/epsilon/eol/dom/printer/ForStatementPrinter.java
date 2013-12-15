package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.*;




public class ForStatementPrinter extends StatementPrinter {

	public String print(DomElement e, EolElementPrinterFactory f) {
		ForStatement s = (ForStatement) e;
		return "for (" + f.print((DomElement) s.getIterator()) + " in " + 
			f.print((DomElement) s.getIterated()) + ") {" + f.newline() + 
			f.indent() + f.print(s.getBody()) + f.outdent() + f.newline() 
			+ f.whitespace() + "}";
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof ForStatement;
	}

}
