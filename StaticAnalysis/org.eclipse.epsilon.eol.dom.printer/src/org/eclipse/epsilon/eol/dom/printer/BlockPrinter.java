package org.eclipse.epsilon.eol.dom.printer;

import org.eclipse.epsilon.eol.dom.Block;
import org.eclipse.epsilon.eol.dom.DomElement;

public class BlockPrinter extends EolElementPrinter{

	@Override
	public String print(DomElement e, EolElementPrinterFactory f) {
		Block block = (Block) e;
		return f.print(block.getStatements());
	}

	@Override
	public boolean appliesTo(DomElement dom) {
		// TODO Auto-generated method stub
		return dom instanceof Block;
	}

}
