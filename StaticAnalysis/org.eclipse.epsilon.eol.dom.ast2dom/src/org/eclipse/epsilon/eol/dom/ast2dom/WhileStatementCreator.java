package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.dom.Block;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.dom.WhileStatement;
import org.eclipse.epsilon.eol.parse.EolParser;

public class WhileStatementCreator extends StatementCreator{

	@Override
	public DomElement create(AST ast, DomElement container,
			Ast2DomContext context) {
		
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
