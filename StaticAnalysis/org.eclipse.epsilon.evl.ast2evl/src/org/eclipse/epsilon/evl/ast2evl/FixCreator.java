package org.eclipse.epsilon.evl.ast2evl;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.ast2eol.Ast2EolContext;
import org.eclipse.epsilon.eol.ast2eol.AstUtilities;
import org.eclipse.epsilon.eol.metamodel.Block;
import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.ExpressionOrStatementBlock;
import org.eclipse.epsilon.evl.metamodel.Fix;
import org.eclipse.epsilon.evl.parse.EvlParser;

public class FixCreator extends EvlElementCreator{

	@Override
	public boolean appliesTo(AST ast) {
		// TODO Auto-generated method stub
		return ast.getType() == EvlParser.FIX;
	}

	@Override
	public EolElement create(AST ast, EolElement container,
			Ast2EolContext context) {
		// TODO Auto-generated method stub
		Ast2EvlContext _context = (Ast2EvlContext) context;
		
		Fix fix = _context.getEvlFactory().createFix();
		this.setAssets(ast, fix, container);
		
		
		AST titleAST = AstUtilities.getChild(ast, EvlParser.TITLE);
		if (titleAST!=null) {
			AST childAst = titleAST.getFirstChild();
			if (childAst != null) {
				ExpressionOrStatementBlock title = _context.getEolFactory().createExpressionOrStatementBlock();
				this.setAssets(childAst, title, fix);
				if (childAst.getType() == EvlParser.BLOCK) {
					title.setBlock((Block) _context.getEvlElementCreatorFactory().createDomElement(childAst, title, _context));
				}
				else
				{
					title.setExpression((Expression) _context.getEvlElementCreatorFactory().createDomElement(childAst, title, _context));
				}
				fix.setTitle(title);
			}
		}
		
		AST doAST = AstUtilities.getChild(ast, EvlParser.BLOCK);
		if (doAST != null) {
			fix.setDo((Block) _context.getEvlElementCreatorFactory().createDomElement(doAST, fix, _context));
		}
		
		return fix;
	}

}
