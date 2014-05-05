package org.eclipse.epsilon.eol.ast2eol;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.parse.EolParser;

public class WhileStatementCreator extends StatementCreator{

	@Override
	public EolElement create(AST ast, EolElement container,
			Ast2EolContext context) {
		
		WhileStatement statement = (WhileStatement) context.getEolFactory().createWhileStatement(); //create a WhileStatement
		this.setAssets(ast, statement, container);
		
		statement.setCondition((Expression) context.getEolElementCreatorFactory().createDomElement(ast.getFirstChild(), statement, context)); //set the condition
		
		AST bodyAST = ast.getChild(1); //fetch the body ast
		if(bodyAST.getType() == EolParser.BLOCK)
		{
			statement.setBody((Block) context.getEolElementCreatorFactory().createDomElement(bodyAST, statement, context)); //process the block ast
		}
		else {	
			Block block = (Block) context.getEolElementCreatorFactory().createDomElement(bodyAST, statement, context, BlockCreator.class);
			block.getStatements().add(context.getEolElementCreatorFactory().createStatement(bodyAST, block, context));
			statement.setBody(block);
		}
		
		return statement;
	}

	@Override
	public boolean appliesTo(AST ast) {
		if(ast.getType() == EolParser.WHILE)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
