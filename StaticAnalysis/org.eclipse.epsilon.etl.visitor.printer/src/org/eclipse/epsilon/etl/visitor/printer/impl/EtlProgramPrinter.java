package org.eclipse.epsilon.etl.visitor.printer.impl;

import java.util.Iterator;

import org.eclipse.epsilon.eol.metamodel.Import;
import org.eclipse.epsilon.eol.metamodel.ModelDeclarationStatement;
import org.eclipse.epsilon.eol.metamodel.OperationDefinition;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;
import org.eclipse.epsilon.etl.metamodel.EtlProgram;
import org.eclipse.epsilon.etl.metamodel.PostBlock;
import org.eclipse.epsilon.etl.metamodel.PreBlock;
import org.eclipse.epsilon.etl.metamodel.TransformationRule;
import org.eclipse.epsilon.etl.metamodel.visitor.EtlProgramVisitor;
import org.eclipse.epsilon.etl.metamodel.visitor.EtlVisitorController;

public class EtlProgramPrinter extends EtlProgramVisitor<PrinterContext, Object>{

	@Override
	public Object visit(EtlProgram etlProgram, PrinterContext context,
			EtlVisitorController<PrinterContext, Object> controller) {
		String result = "";
		if (etlProgram.getModelDeclarations() != null && etlProgram.getModelDeclarations().size() != 0) {
			Iterator<ModelDeclarationStatement> iterator = etlProgram.getModelDeclarations().iterator();
			while(iterator.hasNext())
			{
				result += controller.visit(iterator.next(), context);
				if (iterator.hasNext()) {
					result += context.newline();
				}
			}
			result += context.newline();
		}
		if (etlProgram.getImports() != null && etlProgram.getImports().size() != 0) {
			Iterator<Import> iterator = etlProgram.getImports().iterator();
			while(iterator.hasNext())
			{
				result += controller.visit(iterator.next(), context);
				if (iterator.hasNext()) {
					result += context.newline();
				}
			}
			result += context.newline();
		}
		
		if (etlProgram.getPreBlocks() != null && etlProgram.getPreBlocks().size() != 0) {
			Iterator<PreBlock> iterator = etlProgram.getPreBlocks().iterator();
			while(iterator.hasNext())
			{
				result += controller.visit(iterator.next(), context);
				if (iterator.hasNext()) {
					result += context.newline();
				}
			}
			result += context.newline();
		}
		
		if (etlProgram.getTransformationRules() != null && etlProgram.getTransformationRules().size() != 0) {
			Iterator<TransformationRule> iterator = etlProgram.getTransformationRules().iterator();
			while(iterator.hasNext())
			{
				result += controller.visit(iterator.next(), context);
				if (iterator.hasNext()) {
					result += context.newline();
				}
			}
			result += context.newline();
		}
		
		
		if (etlProgram.getPostBlocks() != null && etlProgram.getPostBlocks().size() != 0) {
			Iterator<PostBlock> iterator = etlProgram.getPostBlocks().iterator();
			while(iterator.hasNext())
			{
				result += controller.visit(iterator.next(), context);
				if (iterator.hasNext()) {
					result += context.newline();
				}
			}
			result += context.newline();
		}
		
		if (etlProgram.getOperations() != null && etlProgram.getOperations().size() != 0) {
			Iterator<OperationDefinition> iterator = etlProgram.getOperations().iterator();
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
