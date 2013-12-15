package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.dom.Block;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.parse.EolParser;

public class BlockCreator extends EolElementCreator{

	@Override
	public DomElement create(AST ast, DomElement container,
			Ast2DomContext context) {
		
		Block block = context.getEolFactory().createBlock(); //create a block
		this.setAssets(ast, block, container);
		
		for (AST statementAst : ast.getChildren()) {
			block.getStatements().add(context.getEolElementCreatorFactory().createStatement(statementAst, block, context));//process block AST
		}
		
		return block;
	}

	@Override
	public boolean appliesTo(AST ast) {
		if(ast.getType() == EolParser.BLOCK)
		{
			return true;
		}
		else {
			return false;
		}
	}

}
