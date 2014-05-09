package org.eclipse.epsilon.etl.visitor.resolution.type.impl;

import org.eclipse.epsilon.eol.metamodel.Block;
import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.visitor.resolution.type.context.TypeResolutionContext;
import org.eclipse.epsilon.etl.metamodel.Guard;
import org.eclipse.epsilon.etl.metamodel.visitor.EtlVisitorController;
import org.eclipse.epsilon.etl.metamodel.visitor.GuardVisitor;

public class GuardTypeResolver extends GuardVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(Guard guard, TypeResolutionContext context,
			EtlVisitorController<TypeResolutionContext, Object> controller) {
		// TODO Auto-generated method stub
		
		EolElement condition = guard.getCondition();
		if (condition != null) {
			if (condition instanceof Expression || condition instanceof Block) {
				controller.visit(condition, context);
			}
			else {
				//context.getLogBook().addError(condition, "");
				//this should not happen
			}
		}
		
		return null;
	}

}
