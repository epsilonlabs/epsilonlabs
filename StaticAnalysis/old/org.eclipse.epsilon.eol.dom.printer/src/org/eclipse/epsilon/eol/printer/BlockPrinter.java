package org.eclipse.epsilon.eol.printer;

import org.eclipse.epsilon.eol.metamodel.*;

public class BlockPrinter extends EolElementPrinter{

	@Override
	public String print(EolElement e, EolElementPrinterFactory f) {
		Block block = (Block) e;
		return f.print(block.getStatements());
	}

	@Override
	public boolean appliesTo(EolElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof Block;
	}

}
