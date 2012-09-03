package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.DomFactory;
import org.eclipse.epsilon.eol.dom.OrderedSetExpression;
import org.eclipse.epsilon.eol.dom.VariableDeclarationExpression;
import org.eclipse.epsilon.eol.parse.EolParser;

public class VariableDeclarationExpressionCreator extends ExpressionCreator{

	@Override
	public DomElement create(AST ast, DomElement container,
			Ast2DomContext context) {
		DomFactory domFactory = context.getDomFactory();
		
		VariableDeclarationExpression declaration = (VariableDeclarationExpression) domFactory.createVariableDeclarationExpression() ;
		declaration.setLine(ast.getLine());
		declaration.setColumn(ast.getColumn());
		
		AST nameAst = ast.getFirstChild();
		declaration.setName(nameAst.getText());

		AST typeAst = nameAst.getNextSibling();
		if (typeAst != null) {
			declaration.setType(context.getTypeCreatorFactory().createType(declaration, typeAst.getText()));
		}
		declaration.setCreate((ast.getType() == EolParser.NEW) || (ast.getType() == EolParser.VAR));
		//declaration.printSelf();
		//System.out.println("Variable Declaration for: " + declaration.getName());
		
		return declaration;
	}

}
