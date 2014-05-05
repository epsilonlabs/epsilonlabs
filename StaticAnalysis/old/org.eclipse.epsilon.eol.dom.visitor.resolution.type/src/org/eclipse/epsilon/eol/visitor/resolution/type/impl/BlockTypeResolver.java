package org.eclipse.epsilon.eol.visitor.resolution.type.impl;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.BlockVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.visitor.resolution.type.context.TypeResolutionContext;

public class BlockTypeResolver extends BlockVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(Block block, TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		for(Statement stmt: block.getStatements())
		{
			controller.visit(stmt, context);
		}
		return null;
	}

}
