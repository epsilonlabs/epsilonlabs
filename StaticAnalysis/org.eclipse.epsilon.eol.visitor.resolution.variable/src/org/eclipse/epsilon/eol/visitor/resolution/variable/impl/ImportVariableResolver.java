package org.eclipse.epsilon.eol.visitor.resolution.variable.impl;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.ImportVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.variable.context.VariableResolutionContext;

public class ImportVariableResolver extends ImportVisitor<VariableResolutionContext, Object>{

	@Override
	public Object visit(Import _import, VariableResolutionContext context,
			EolVisitorController<VariableResolutionContext, Object> controller) {
		controller.visit(_import.getImportedProgram(), context);
		
		/*
		AST importedAst = context.getAst2DomUtil().generateAst(getClass(), imported); //create AST out of the uri		
		Program importedProgram = null; //prepare imported program
		if (importedAst!=null) { //if AST is not null (which means the file specified by the uri exists)
			importedProgram = context.getAst2DomUtil().generateProgram(importedAst); //generate a program and assign it to the imported program
			Program mainProgram = context.getMainProgram(); //get the main program from the context
			importedProgram.setContainer(mainProgram); //set the containter of the imported program to be the main program
			
			controller.visit(importedProgram, context); //visit the imported program
		}*/
		
		
		return null;
	}

}
