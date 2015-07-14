package org.eclipse.epsilon.eol.visitor.resolution.variable.impl;

import org.eclipse.epsilon.eol.metamodel.EOLLibraryModule;
import org.eclipse.epsilon.eol.metamodel.EOLProgram;
import org.eclipse.epsilon.eol.metamodel.Import;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.ImportVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.variable.context.VariableResolutionContext;

public class ImportVariableResolver extends ImportVisitor<VariableResolutionContext, Object>{

	@Override
	public Object visit(Import _import, VariableResolutionContext context,
			EolVisitorController<VariableResolutionContext, Object> controller) {
		//get the imported program
		EOLLibraryModule program = _import.getImportedModule();
		//if program is not null
		if (program != null) { 
			//if program is eol program then it is good
			if (program instanceof EOLProgram) {
				EOLProgram temp = (EOLProgram) program;
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
