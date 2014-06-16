package org.eclipse.epsilon.eol.visitor.printer.impl;

import java.util.Iterator;

import org.eclipse.epsilon.eol.metamodel.EolProgram;
import org.eclipse.epsilon.eol.metamodel.Import;
import org.eclipse.epsilon.eol.metamodel.ModelDeclarationStatement;
import org.eclipse.epsilon.eol.metamodel.OperationDefinition;
import org.eclipse.epsilon.eol.metamodel.visitor.EolProgramVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

public class EolProgramPrinter extends EolProgramVisitor<PrinterContext, Object>{

	@Override
	public Object visit(EolProgram eolProgram, PrinterContext context,
			EolVisitorController<PrinterContext, Object> controller) {
		String result = "";
		if (eolProgram.getModelDeclarations() != null && eolProgram.getModelDeclarations().size() != 0) {
			Iterator<ModelDeclarationStatement> iterator = eolProgram.getModelDeclarations().iterator();
			while(iterator.hasNext())
			{
				result += controller.visit(iterator.next(), context);
				if (iterator.hasNext()) {
					result += context.newline();
				}
			}
			result += context.newline();
		}
		if (eolProgram.getImports() != null && eolProgram.getImports().size() != 0) {
			Iterator<Import> iterator = eolProgram.getImports().iterator();
			while(iterator.hasNext())
			{
				result += controller.visit(iterator.next(), context);
				if (iterator.hasNext()) {
					result += context.newline();
				}
			}
			result += context.newline();
		}
		if (eolProgram.getBlock() != null) {
			result += controller.visit(eolProgram.getBlock(), context) + context.newline();
		}
		if (eolProgram.getOperations() != null && eolProgram.getOperations().size() != 0) {
			Iterator<OperationDefinition> iterator = eolProgram.getOperations().iterator();
			while(iterator.hasNext())
			{
				result += controller.visit(iterator.next(), context);
				if (iterator.hasNext()) {
					result += context.newline();
				}
			}
		}
		return result;
	}

}
