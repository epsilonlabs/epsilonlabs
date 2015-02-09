package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.BlockVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class BlockTypeResolver extends BlockVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(Block block, TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		//get statements then resolve one by one
		for(Statement stmt: block.getStatements())
		{
			controller.visit(stmt, context);
		}
		return null;
	}

}
