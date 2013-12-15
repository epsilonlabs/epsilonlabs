package org.eclipse.epsilon.eol.dom.visitor.resolution.variable.impl;

import org.eclipse.epsilon.eol.dom.Import;
import org.eclipse.epsilon.eol.dom.Program;
import org.eclipse.epsilon.eol.dom.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.dom.visitor.ProgramVisitor;
import org.eclipse.epsilon.eol.dom.visitor.resolution.variable.context.VariableResolutionContext;
import org.eclipse.epsilon.eol.parse.Eol_EolParserRules.returnStatement_return;

public class ProgramVariableResolver extends ProgramVisitor<VariableResolutionContext, Object>{

	@Override
	public Object visit(Program program, VariableResolutionContext context,
			EolVisitorController<VariableResolutionContext, Object> controller) {
		if (context.getMainProgram() == null) { //if the program is the EOL in question (the main program)
			context.getStack().push(program, true); //insert a stack
			context.setMainProgram(program); //set the main program to be this one
			for(Import imported : program.getImports())
			{
				controller.visit(imported, context); //visit each import statement and resolve the imported programs
			}
			controller.visitContents(program, context); //visit the contents of the program in question
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
