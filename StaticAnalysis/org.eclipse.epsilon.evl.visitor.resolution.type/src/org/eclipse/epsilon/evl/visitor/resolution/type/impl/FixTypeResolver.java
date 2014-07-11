package org.eclipse.epsilon.evl.visitor.resolution.type.impl;

import org.eclipse.epsilon.eol.visitor.resolution.type.context.TypeResolutionContext;

import org.eclipse.epsilon.evl.metamodel.Fix;
import org.eclipse.epsilon.evl.metamodel.visitor.EvlVisitorController;
import org.eclipse.epsilon.evl.metamodel.visitor.FixVisitor;

public class FixTypeResolver extends FixVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(Fix fix, TypeResolutionContext context,
			EvlVisitorController<TypeResolutionContext, Object> controller) {
		
		if (fix.getTitle()!=null) {
			controller.visit(fix.getTitle(), context);
		}
		
		if (fix.getDo()!=null) {
			controller.visit(fix.getDo(), context);
		}
		return null;
	}

}
