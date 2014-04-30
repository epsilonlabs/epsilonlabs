package org.eclipse.epsilon.eol.ast2dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.parse.EolParser;

public class IfStatementCreator extends StatementCreator{

	@Override
	public EolElement create(AST ast, EolElement container,
			Ast2DomContext context) {
		
		IfStatement statement = (IfStatement) context.getEolFactory().createIfStatement(); //create an IfStatement
		this.setAssets(ast, statement, container);
		
		AST conditionAst = ast.getFirstChild(); //fetch the condition ast
		AST ifBodyAst = conditionAst.getNextSibling(); //fetch the body ast
		AST elseBodyAst = ifBodyAst.getNextSibling(); //fetch the else body ast
		
		statement.setCondition((Expression) context.getEolElementCreatorFactory().createDomElement(conditionAst, statement, context)); //process condition
		if(ifBodyAst.getType() == EolParser.BLOCK)
		{
			statement.setIfBody((Block) context.getEolElementCreatorFactory().createDomElement(ifBodyAst, statement, context)); //process if body
		}
		else {
			Block ifBlock = context.getEolFactory().createBlock();
			ifBlock.setLine(ifBodyAst.getLine());
			ifBlock.setColumn(ifBodyAst.getColumn());
			ifBlock.setContainer(statement);
			
			ifBlock.getStatements().add(context.getEolElementCreatorFactory().createStatement(ifBodyAst, ifBlock, context));
			statement.setIfBody(ifBlock);
		}
		
		
		if (elseBodyAst != null) { //if there is a else-body
			if(elseBodyAst.getType() == EolParser.BLOCK)
			{
				statement.setElseBody((Block) context.getEolElementCreatorFactory().createDomElement(elseBodyAst, statement, context)); //process else body
			}
			else {				
				Block elseBlock = context.getEolFactory().createBlock();
				elseBlock.setLine(elseBodyAst.getLine());
				elseBlock.setColumn(elseBodyAst.getColumn());
				elseBlock.setContainer(statement);
				
				elseBlock.getStatements().add(context.getEolElementCreatorFactory().createStatement(elseBodyAst, elseBlock, context));
				statement.setElseBody(elseBlock);
			}
		}
		
		return statement;
	}

	@Override
	public boolean appliesTo(AST ast) {
		if(ast.getType() == EolParser.IF)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
