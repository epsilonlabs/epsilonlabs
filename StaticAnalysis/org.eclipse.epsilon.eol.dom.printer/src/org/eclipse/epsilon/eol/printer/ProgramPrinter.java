package org.eclipse.epsilon.eol.printer;

import org.eclipse.epsilon.eol.metamodel.*;




public class ProgramPrinter extends EolElementPrinter {

	public String print(EolElement e, EolElementPrinterFactory f) {
		Program program = (Program) e;
		return f.print(program.getModelDeclarations()) + f.newline() +
				f.print(program.getImports()) + f.newline() + 
			f.print(program.getBlock()) + f.newline() + 
			f.print(program.getOperations()) + f.newline();
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof Program;
	}

}
