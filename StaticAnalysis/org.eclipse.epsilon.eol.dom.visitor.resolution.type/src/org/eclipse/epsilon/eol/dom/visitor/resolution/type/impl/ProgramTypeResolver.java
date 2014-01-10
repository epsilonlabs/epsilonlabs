package org.eclipse.epsilon.eol.dom.visitor.resolution.type.impl;

import org.eclipse.epsilon.eol.dom.Import;
import org.eclipse.epsilon.eol.dom.ModelDeclarationStatement;
import org.eclipse.epsilon.eol.dom.OperationDefinition;
import org.eclipse.epsilon.eol.dom.Program;
import org.eclipse.epsilon.eol.dom.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.dom.visitor.ProgramVisitor;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.context.TypeResolutionContext;

public class ProgramTypeResolver extends ProgramVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(Program program, TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		for(Import import1: program.getImports())
		{
			controller.visit(import1, context);
		}
		
		for(ModelDeclarationStatement mds: program.getModelDeclarations()) //process each model declaration statement
		{
			controller.visit(mds, context);
		}
		
		for(OperationDefinition od: program.getOperations()) //process each operation
		{
			controller.visit(od, context);
		}
		
		controller.visitContents(program.getBlock(), context); //process statement block
		return null;
	}

}
