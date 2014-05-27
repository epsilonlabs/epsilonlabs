package org.eclipse.epsilon.eol.visitor.resolution.variable.impl;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolProgramVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.visitor.resolution.variable.context.VariableResolutionContext;

public class ProgramVariableResolver extends EolProgramVisitor<VariableResolutionContext, Object>{

	@Override
	public Object visit(EolProgram program, VariableResolutionContext context,
			EolVisitorController<VariableResolutionContext, Object> controller) {
		if (context.getMainProgram() == null) { //if the program is the EOL in question (the main program)
			context.getStack().push(program, true); //insert a stack
			context.setMainProgram(program); //set the main program to be this one
			for(Import imported : program.getImports())
			{
				controller.visit(imported, context); //visit each import statement and resolve the imported programs
			}
			controller.visit(program.getBlock(), context); //visit the contents of the program in question
			for(OperationDefinition op: program.getOperations())
			{
				controller.visit(op, context);
			}
		}
		else { //if the program is the program that is imported
			for(Import imported : program.getImports()) 
			{
				controller.visit(imported, context); //visit each import statement and resolve the imported programs
			}
			controller.visitContents(program, context); //visit the contents of the program
		}
		 return null;
	}

}
