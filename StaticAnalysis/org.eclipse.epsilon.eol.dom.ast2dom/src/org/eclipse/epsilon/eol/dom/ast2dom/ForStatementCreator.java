package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.parse.EolParser;

public class ForStatementCreator extends StatementCreator{

	@Override
	public EolElement create(AST ast, EolElement container,
			Ast2DomContext context) {
		
		ForStatement statement = (ForStatement) context.getEolFactory().createForStatement(); //create a ForStatement
		this.setAssets(ast, statement, container);
		
		AST iteratorAst = ast.getChild(0); //obtain the iterator AST
		AST iteratedAst = ast.getChild(1); //obtain the iterated AST
		statement.setIterator((FormalParameterExpression) context.getEolElementCreatorFactory().createDomElement(iteratorAst, statement, context)); //process the iterator
		statement.setIterated((Expression) context.getEolElementCreatorFactory().createDomElement(iteratedAst, statement, context)); //process the iterated
		
		AST bodyAst = ast.getChild(2);
		if(bodyAst.getType() == EolParser.BLOCK)
		{
			statement.setBody((Block)context.getEolElementCreatorFactory().createDomElement(bodyAst, statement, context)); //process the body
		}
		else {
			Block block = (Block) context.getEolElementCreatorFactory().createDomElement(bodyAst, statement, context, BlockCreator.class);
			block.getStatements().add(context.getEolElementCreatorFactory().createStatement(bodyAst, block, context));
			statement.setBody(block);
		}
		
		return statement;
	}

	@Override
	public boolean appliesTo(AST ast) {
		if(ast.getType() == EolParser.FOR)
		{
			return true;
		}
		else {
			return false;
		}
	}

}
