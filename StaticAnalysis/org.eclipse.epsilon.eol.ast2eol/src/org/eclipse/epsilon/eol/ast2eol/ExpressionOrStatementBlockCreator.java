package org.eclipse.epsilon.eol.ast2eol;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.metamodel.Block;
import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.ExpressionOrStatementBlock;
import org.eclipse.epsilon.eol.metamodel.Statement;
import org.eclipse.epsilon.eol.parse.EolParser;

public class ExpressionOrStatementBlockCreator extends EolElementCreator{

	@Override
	public boolean appliesTo(AST ast) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EolElement create(AST ast, EolElement container,
			Ast2EolContext context) {
		ExpressionOrStatementBlock body = context.getEolFactory().createExpressionOrStatementBlock();
		setAssets(ast, body, container);
		
		if(ast.getType() == EolParser.BLOCK)
		{
			body.setBlock((Block)context.getEolElementCreatorFactory().createDomElement(ast, body, context)); //process the body
		}
		else {
			EolElement createdElement = context.getEolElementCreatorFactory().createDomElement(ast, body, context);
			if (createdElement instanceof Expression) {
				body.setExpression((Expression) createdElement);	
			}
			else {
				context.getEolElementCreatorFactory().discardEolElement(createdElement);
				Block block = context.getEolFactory().createBlock();
				setAssets(ast, block, body);
				Statement stmt = context.getEolElementCreatorFactory().createStatement(ast, block, context);
				block.getStatements().add(stmt);
				setAssets(ast, stmt, block);
				body.setBlock(block);
			}
			
		}
		return body;
	}

}
