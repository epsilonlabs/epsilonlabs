package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.ImportVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class ImportTypeResolver extends ImportVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(Import _import, TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		//visit the imported program
		if (_import.getImportedProgram() != null) {
			controller.visit(_import.getImportedProgram(), context);	
		}
		else {
			context.getLogBook().addError(_import, "Imported program cannot be resolved");
		}
		
		return null;
	}

}
