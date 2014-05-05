package org.eclipse.epsilon.eol.ast2eol;

import java.util.ArrayList;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.metamodel.*;
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
	public EolElement create(AST ast, EolElement container,
			Ast2EolContext context) {
		
		TransactionStatement statement = context.getEolFactory().createTransactionStatement();
		this.setAssets(ast, statement, container);
		
		ArrayList<AST> childrenAsts = AstUtilities.getChildren(ast);
		int temp = 0;
		while(temp < childrenAsts.size() - 1)
		{
			AST nameAst = childrenAsts.get(temp);
			statement.getNames().add((NameExpression) context.getEolElementCreatorFactory().createDomElement(nameAst, statement, context));
			temp++;
		}
		
		AST bodyAst = childrenAsts.get(childrenAsts.size()-1);
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
