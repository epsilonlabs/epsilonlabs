package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.dom.Block;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.SwitchCaseDefaultStatement;
import org.eclipse.epsilon.eol.parse.EolParser;

public class SwitchCaseDefaultCreator extends SwitchStatementCaseCreator{

	@Override
	public boolean appliesTo(AST ast) {
		if(ast.getType() == EolParser.DEFAULT)
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

		SwitchCaseDefaultStatement statement = (SwitchCaseDefaultStatement) context.getEolFactory().createSwitchCaseDefaultStatement(); //create a SwitchCaseDefaultStatment
		this.setAssets(ast, statement, container);
		
		AST blockAST = AstUtilities.getChild(ast, EolParser.BLOCK); //fetch the body AST for the switch case, there is always a block
		if(blockAST != null)
		{
			statement.setBody((Block)context.getEolElementCreatorFactory().createDomElement(blockAST, statement, context)); //set the body of the switch case
		}
		
		return statement;
	}

}
