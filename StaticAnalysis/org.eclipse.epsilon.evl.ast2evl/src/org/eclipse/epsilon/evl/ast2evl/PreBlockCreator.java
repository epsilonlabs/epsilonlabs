package org.eclipse.epsilon.evl.ast2evl;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.ast2eol.Ast2EolContext;
import org.eclipse.epsilon.eol.ast2eol.AstUtilities;
import org.eclipse.epsilon.eol.metamodel.Block;
import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.NameExpression;
import org.eclipse.epsilon.evl.metamodel.PreBlock;
import org.eclipse.epsilon.evl.parse.EvlParser;

public class PreBlockCreator extends NamedBlockCreator{

	@Override
	public boolean appliesTo(AST ast) {
		// TODO Auto-generated method stub
		return (ast.getType() == EvlParser.PRE);
	}

	@Override
	public EolElement create(AST ast, EolElement container,
			Ast2EolContext context) {
		Ast2EvlContext _context = (Ast2EvlContext) context;

		PreBlock preBlock = _context.getEvlFactory().createPreBlock();
		this.setAssets(ast, preBlock, container);

		AST firstChild = ast.getFirstChild();
		if (firstChild!=null & firstChild.getType() != EvlParser.BLOCK) {
			preBlock.setName((NameExpression) _context.getEvlElementCreatorFactory().createDomElement(firstChild, preBlock, _context));
		}
		
		AST blockAst = AstUtilities.getChild(ast, EvlParser.BLOCK);
		if (blockAst != null) {
			preBlock.setBody((Block) _context.getEvlElementCreatorFactory().createDomElement(blockAst, preBlock, _context));
		}
		
		return null;
	}

}
