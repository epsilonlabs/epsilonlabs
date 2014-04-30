package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.parse.EolParser;

public class PropertyCallExpressionCreator extends FeatureCallExpressionCreator{

	@Override
	public boolean appliesTo(AST ast) {
		if((ast.getType() == EolParser.ARROW || ast.getType() == EolParser.POINT) && 
				ast.getChild(1).getNumberOfChildren() == 0)
		{
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public EolElement create(AST ast, EolElement container,
			Ast2DomContext context) {
		
		PropertyCallExpression expression = context.getEolFactory().createPropertyCallExpression(); //create an PropertyCallExpression
		this.setAssets(ast, expression, container);
		
		AST targetAst = ast.getFirstChild(); //get the targetAst
		AST propertyAst = targetAst.getNextSibling(); //get the featureAst
		
		expression.setTarget((Expression) context.getEolElementCreatorFactory().createDomElement(targetAst, expression, context)); //set target
		expression.setProperty((NameExpression) context.getEolElementCreatorFactory().createDomElement(propertyAst, expression, context)); //set property
		
		String propertyString = propertyAst.getText(); //obtain the string for the property
		
		BooleanExpression extended = (BooleanExpression) context.getEolElementCreatorFactory().createDomElement(propertyAst, expression, context, BooleanExpressionCreator.class);
		
		if (propertyString.startsWith("~")) { //if the string for the feature starts with ~
			extended.setVal(true); //set extended to true
		}
		else { //if not an extended property
			extended.setVal(false);
		}
		expression.setExtended(extended); //set the extended of the pexp		
		
		BooleanExpression isArrow = (BooleanExpression) context.getEolElementCreatorFactory().createDomElement(ast, expression, context, BooleanExpressionCreator.class);
		isArrow.setVal((ast.getType() == EolParser.ARROW) ? true : false);
		expression.setIsArrow(isArrow);
		
		return expression;
	}

}
