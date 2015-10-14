package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import org.eclipse.epsilon.eol.metamodel.Block;
import org.eclipse.epsilon.eol.metamodel.Statement;
import org.eclipse.epsilon.eol.metamodel.visitor.BlockVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class BlockTypeResolver extends BlockVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(Block block, TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		for(Statement statement: block.getStatements())
		{
			context.setCurrentStatement(statement);
			controller.visit(statement, context);
		}
		return null;
	}

}
