package org.eclipse.epsilon.eol.visitor.resolution.variable.impl;

import org.eclipse.epsilon.eol.metamodel.EolLibraryModule;
import org.eclipse.epsilon.eol.metamodel.EolProgram;
import org.eclipse.epsilon.eol.metamodel.Import;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.ImportVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.variable.context.VariableResolutionContext;

public class ImportVariableResolver extends ImportVisitor<VariableResolutionContext, Object>{

	@Override
	public Object visit(Import _import, VariableResolutionContext context,
			EolVisitorController<VariableResolutionContext, Object> controller) {
		//get the imported program
		EolLibraryModule program = _import.getImportedProgram();
		//if program is not null
		if (program != null) { 
			//if program is eol program then it is good
			if (program instanceof EolProgram) {
				EolProgram temp = (EolProgram) program;
				controller.visit(temp, context);	
			}
		}
		else {
			//if program is null, something is wrong
			context.getLogBook().addError(_import, "cannot find the imported program");
		}
		return null;
	}

}
