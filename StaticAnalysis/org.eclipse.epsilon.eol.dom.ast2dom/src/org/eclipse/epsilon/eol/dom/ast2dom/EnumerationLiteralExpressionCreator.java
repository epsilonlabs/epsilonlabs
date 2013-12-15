package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.EnumerationLiteralExpression;
import org.eclipse.epsilon.eol.dom.ModelExpression;
import org.eclipse.epsilon.eol.dom.NameExpression;
import org.eclipse.epsilon.eol.parse.EolParser;

public class EnumerationLiteralExpressionCreator extends ExpressionCreator{

	@Override
	public DomElement create(AST ast, DomElement container,
			Ast2DomContext context) {
		
		EnumerationLiteralExpression expression = (EnumerationLiteralExpression) context.getEolFactory().createEnumerationLiteralExpression(); //create an EnumerationLiteralExpression
		this.setAssets(ast, expression, container);
		
		if(ast.getText().contains("!"))
		{
			String[] arr1 = ast.getText().split("!"); //split the string by !
			ModelExpression model = (ModelExpression) context.getEolElementCreatorFactory().createDomElement(ast, expression, context, ModelExpressionCreator.class);
			model.setName(arr1[0]); //set name
			expression.setModel(model); //set model for the enumeration
		
			String[] arr2 = arr1[1].split("#"); //split the string by #			
			NameExpression enumeration = (NameExpression) context.getEolElementCreatorFactory().createDomElement(ast, expression, context, NameExpressionCreator.class);//create a NameExpression to express enumeration
			enumeration.setColumn(ast.getColumn() + arr1[0].length()); //set column
			enumeration.setName(arr2[0]); //set name
			expression.setEnumeration(enumeration); //set enumeration for the enumeration
						
			NameExpression literal = (NameExpression) context.getEolElementCreatorFactory().createDomElement(ast, expression, context, NameExpressionCreator.class);//create a NameExpression to express enumeration literal
			literal.setColumn(enumeration.getColumn() + arr2[0].length()); //set column
			literal.setName(arr2[1]); //set name
			expression.setLiteral(literal); //set literal
		}
		
		else {
			String[] arr2 = ast.getText().split("#"); //split the string by #
			
			NameExpression enumeration = (NameExpression) context.getEolElementCreatorFactory().createDomElement(ast, expression, context, NameExpressionCreator.class);//create a NameExpression to express enumeration
			enumeration.setColumn(ast.getColumn() + arr2[0].length()); //set column
			enumeration.setName(arr2[0]); //set name
			expression.setEnumeration(enumeration); //set enumeration for the enumeration
			
			NameExpression literal = (NameExpression) context.getEolElementCreatorFactory().createDomElement(ast, expression, context, NameExpressionCreator.class);//create a NameExpression to express enumeration literal
			literal.setColumn(enumeration.getColumn() + arr2[0].length()); //set column
			literal.setName(arr2[1]); //set name
			expression.setLiteral(literal); //set literal
		}

		return expression;
	}

	@Override
	public boolean appliesTo(AST ast) {
		if(ast.getType() == EolParser.ENUMERATION_VALUE)
		{
			return true;
		}
		else {
			return false;
		}
	}

}
