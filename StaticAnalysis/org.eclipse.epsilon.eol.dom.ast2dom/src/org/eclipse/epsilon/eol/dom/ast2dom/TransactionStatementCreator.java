package org.eclipse.epsilon.eol.dom.ast2dom;

import java.util.LinkedList;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.dom.Block;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.NameExpression;
import org.eclipse.epsilon.eol.dom.TransactionStatement;
import org.eclipse.epsilon.eol.parse.EolParser;

public class TransactionStatementCreator extends StatementCreator{

	@Override
	public boolean appliesTo(AST ast) {
		if(ast.getType() == EolParser.TRANSACTION)
		{
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public DomElement create(AST ast, DomElement container,
			Ast2DomContext context) {
		
		TransactionStatement statement = context.getEolFactory().createTransactionStatement();
		this.setAssets(ast, statement, container);
		
		LinkedList<AST> childrenAsts = AstUtilities.getChildren(ast);
		int temp = 0;
		while(temp < childrenAsts.size() - 1)
		{
			AST nameAst = childrenAsts.get(temp);
			statement.getNames().add((NameExpression) context.getEolElementCreatorFactory().createDomElement(nameAst, statement, context));
			temp++;
		}
		
		AST bodyAst = childrenAsts.getLast();
		if(bodyAst.getType() == EolParser.BLOCK)
		{
			statement.setBody((Block) context.getEolElementCreatorFactory().createDomElement(bodyAst, statement, context));
		}
		else {
			Block bodyBlock = (Block) context.getEolElementCreatorFactory().createDomElement(bodyAst, statement, context, BlockCreator.class);
			bodyBlock.getStatements().add(context.getEolElementCreatorFactory().createStatement(bodyAst, bodyBlock, context));
			statement.setBody(bodyBlock);
		}
		
		return statement;
	}

}
