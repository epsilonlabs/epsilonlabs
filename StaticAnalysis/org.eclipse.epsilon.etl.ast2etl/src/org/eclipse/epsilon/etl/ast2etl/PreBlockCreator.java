package org.eclipse.epsilon.etl.ast2etl;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.ast2eol.Ast2EolContext;
import org.eclipse.epsilon.eol.ast2eol.AstUtilities;
import org.eclipse.epsilon.eol.metamodel.Block;
import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.NameExpression;
import org.eclipse.epsilon.etl.metamodel.PreBlock;
import org.eclipse.epsilon.etl.parse.EtlParser;

public class PreBlockCreator extends NamedBlockCreator{

	@Override
	public boolean appliesTo(AST ast) {
		// TODO Auto-generated method stub
		return (ast.getType() == EtlParser.PRE);
	}

	@Override
	public EolElement create(AST ast, EolElement container,
			Ast2EolContext context) {
		Ast2EtlContext _context = (Ast2EtlContext) context;

		PreBlock preBlock = _context.getEtlFactory().createPreBlock();
		this.setAssets(ast, preBlock, container);

		AST firstChild = ast.getFirstChild();
		if (firstChild!=null & firstChild.getType() != EtlParser.BLOCK) {
			preBlock.setName((NameExpression) _context.getEtlElementCreatorFactory().createDomElement(firstChild, preBlock, _context));
		}
		
		AST blockAst = AstUtilities.getChild(ast, EtlParser.BLOCK);
		if (blockAst != null) {
			preBlock.setBody((Block) _context.getEtlElementCreatorFactory().createDomElement(blockAst, preBlock, _context));
		}
		
		return preBlock;
	}

}
