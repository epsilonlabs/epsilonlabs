package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.OperationDefinition;
import org.eclipse.epsilon.eol.dom.Statement;
import org.eclipse.epsilon.eol.dom.VariableDeclarationExpression;
import org.eclipse.epsilon.eol.parse.EolParser;

public class OperationDefinitionCreator extends DomElementCreator{

	@Override
	public DomElement create(AST ast, DomElement container,
			Ast2DomContext context) {
		
		OperationDefinition operation = (OperationDefinition) context.getDomFactory().createOperationDefinition();

		AST contextTypeAst = null;
		AST nameAst = null;
		AST paramListAst = null;
		AST returnAst = null;
		AST bodyAst = null;
		
		if (ast.getFirstChild().getType() == EolParser.TYPE) {
			contextTypeAst = ast.getFirstChild();
			nameAst = contextTypeAst.getNextSibling(); 
		}
		else {
			nameAst = ast.getFirstChild();
		}
		
		if (nameAst.getNextSibling().getType() == EolParser.PARAMLIST){
			paramListAst = nameAst.getNextSibling();
		}
		
		if (paramListAst != null){ // helper with parameters
			if (paramListAst.getNextSibling().getType() == EolParser.TYPE){ // with return type
				returnAst = paramListAst.getNextSibling();
				bodyAst = returnAst.getNextSibling();
			} else { // without return type
				bodyAst = paramListAst.getNextSibling();
			}
		} else { // helper without parameters
			if (nameAst.getNextSibling().getType() == EolParser.TYPE){ //with return type
				returnAst = nameAst.getNextSibling();
				bodyAst = returnAst.getNextSibling();
			} else { // without return type
				bodyAst = nameAst.getNextSibling();
			}
		}
		
		if(contextTypeAst != null)
		{
			operation.setContextType(contextTypeAst.getText());
		}
		operation.setName(nameAst.getText());
		
		if(paramListAst != null)
		{
			for(AST parameter : paramListAst.getChildren())
			{
				operation.getParameters().add((VariableDeclarationExpression) context.getDomElementCreatorFactory().createDomElement(parameter, operation, context));
			}
		}
		
		if(returnAst != null)
		{
			operation.setReturnType(returnAst.getText());
		}
		
		for(AST statement: bodyAst.getChildren())
		{
			operation.getStatements().add((Statement)context.getDomElementCreatorFactory().createStatement(statement, operation, context));
		}
		
		operation.setLine(ast.getLine());
		operation.setColumn(ast.getColumn());
		
		return operation;
	}

}
