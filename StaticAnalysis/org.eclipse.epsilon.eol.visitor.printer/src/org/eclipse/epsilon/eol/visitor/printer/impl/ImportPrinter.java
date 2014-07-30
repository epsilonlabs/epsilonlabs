package org.eclipse.epsilon.eol.visitor.printer.impl;

import org.eclipse.epsilon.eol.metamodel.Import;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.ImportVisitor;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class ImportPrinter extends ImportVisitor<PrinterContext, Object>{

	@Override
	public Object visit(Import _import, PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "import " + controller.visit(_import.getImported(), context) + ";";
		return result;
	}

}
