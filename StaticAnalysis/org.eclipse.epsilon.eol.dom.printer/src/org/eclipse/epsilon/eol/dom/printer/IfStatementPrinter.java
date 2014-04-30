package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.metamodel.*;



public class IfStatementPrinter extends StatementPrinter {

	public String print(EolElement e, EolElementPrinterFactory f) {
		IfStatement s = (IfStatement) e;
		String r = "if (" + f.print((EolElement) s.getCondition()) + ") {" + f.newline()
			+ f.indent() + f.print(s.getIfBody()) + f.outdent() + f.newline() + 
			f.whitespace() + "}";
		if (s.getElseBody() != null) {
			r = r + f.newline() + f.whitespace() + "else { " + f.newline() + f.indent() + f.print(s.getElseBody()) 
			+ f.newline() + f.outdent() + f.whitespace() + "}"; 
		}
		return r;
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof IfStatement;
	}

}
