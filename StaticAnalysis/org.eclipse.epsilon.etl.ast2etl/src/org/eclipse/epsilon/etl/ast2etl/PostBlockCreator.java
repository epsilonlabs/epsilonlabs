package org.eclipse.epsilon.etl.ast2etl;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.ast2eol.Ast2EolContext;
import org.eclipse.epsilon.eol.ast2eol.AstUtilities;
import org.eclipse.epsilon.eol.metamodel.Block;
import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.NameExpression;
import org.eclipse.epsilon.etl.metamodel.PostBlock;
import org.eclipse.epsilon.etl.parse.EtlParser;

public class PostBlockCreator extends NamedBlockCreator{

	@Override
	public boolean appliesTo(AST ast) {
		// TODO Auto-generated method stub
		return ast.getType() == EtlParser.POST;
	}

	@Override
	public EolElement create(AST ast, EolElement container,
			Ast2EolContext context) {
		Ast2EtlContext _context = (Ast2EtlContext) context;

		PostBlock postBlock = _context.getEtlFactory().createPostBlock();
		this.setAssets(ast, postBlock, container);

		AST firstChild = ast.getFirstChild();
		if (firstChild!=null & firstChild.getType() != EtlParser.BLOCK) {
			postBlock.setName((NameExpression) _context.getEtlElementCreatorFactory().createDomElement(firstChild, postBlock, _context));
		}
		
		AST blockAst = AstUtilities.getChild(ast, EtlParser.BLOCK);
		if (blockAst != null) {
			postBlock.setBody((Block) _context.getEtlElementCreatorFactory().createDomElement(blockAst, postBlock, _context));
		}
		

		return null;
	}

}
