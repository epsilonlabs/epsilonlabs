package org.eclipse.epsilon.eol.ast2eol;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.parse.EolParser;

public class MethodCallExpressionCreator extends FeatureCallExpressionCreator{

	@Override
	public boolean appliesTo(AST ast) {	
		if(		((ast.getType() == EolParser.ARROW || 
				ast.getType() == EolParser.POINT) && 
				ast.getChild(1).getNumberOfChildren() > 0 && 
				ast.getChild(1).getFirstChild().getType() == EolParser.PARAMETERS)
				
				||
	
				(ast.getType() == EolParser.FEATURECALL && 
				ast.getNumberOfChildren() > 0 && 
				ast.getFirstChild().getType() == EolParser.PARAMETERS &&
				(ast.getParent().getType() != EolParser.POINT ||
				ast.getParent().getType() != EolParser.ARROW))
				
				)
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
		
		if(ast.getType() == EolParser.ARROW || ast.getType() == EolParser.POINT)
		{
			MethodCallExpression expression = (MethodCallExpression) context.getEolFactory().createMethodCallExpression(); //create a method call
			this.setAssets(ast, expression, container);
			
			AST targetAst = ast.getFirstChild(); //get the targetAst
			AST featureAst = targetAst.getNextSibling(); //get the featureAst
			AST parametersAst = featureAst.getFirstChild(); //get the parameterAs
			
			expression.setTarget((Expression) context.getEolElementCreatorFactory().createDomElement(targetAst, expression, context)); //set target
			
			expression.setMethod((NameExpression) context.getEolElementCreatorFactory().createDomElement(featureAst, expression, context, NameExpressionCreator.class));
					
			for (AST parameterAst : parametersAst.getChildren()) {
					if (isKeyWord(parameterAst.getText())) {
						expression.getArguments().add((Expression) context.getEolElementCreatorFactory().createDomElement(parameterAst, expression, context, NameExpressionCreator.class)); //process arguments
					}
					else {
						expression.getArguments().add((Expression) context.getEolElementCreatorFactory().createDomElement(parameterAst, expression, context)); //process arguments
					}
					
			}
			
			BooleanExpression isArrow = context.getEolFactory().createBooleanExpression(); //process isArrow
			this.setAssets(ast, isArrow, expression);
			isArrow.setVal((ast.getType() == EolParser.ARROW) ? true : false);
			expression.setIsArrow(isArrow);
			
			
			return expression;
		}
		else {
			MethodCallExpression expression = (MethodCallExpression)context.getEolFactory().createMethodCallExpression(); //create a NaturalMethodCallExpression
			this.setAssets(ast, expression, container);
			
			NameExpression method = (NameExpression) context.getEolElementCreatorFactory().createDomElement(ast, expression, context, NameExpressionCreator.class);
			method.setName(ast.getText()); //set name
			expression.setMethod(method); //set method for MethodCall
			
			AST argumentListAst = ast.getFirstChild(); //fetch the argument AST
			if(argumentListAst != null) //if there are arguments
			{
				for(AST argumentAst: argumentListAst.getChildren()) //process argument
				{
					expression.getArguments().add((Expression) context.getEolElementCreatorFactory().createDomElement(argumentAst, expression, context));
				}
			}

			return expression;
		}
	}
	
	public boolean isKeyWord(String s)
	{
		if (s.equals("Any") ||
				s.equals("Integer") ||
				s.equals("Boolean") ||
				s.equals("Real") ||
				s.equals("String") ||
				s.equals("Bag") ||
				s.equals("Set") ||
				s.equals("OrderedSet") ||
				s.equals("Sequence") ||
				s.equals("Map")) {
			return true;
		}
		else if (s.contains("Bag(")) {
			String temp = s.replaceFirst("Bag(", "");
			temp = temp.replace(")", "");
			return isKeyWord(temp);
		}
		else if (s.contains("Set(")) {
			String temp = s.replaceFirst("Set(", "");
			temp = temp.replace(")", "");
			return isKeyWord(temp);
		}
		else if (s.contains("OrderedSet(")) {
			String temp = s.replaceFirst("OrderedSet(", "");
			temp = temp.replace(")", "");
			return isKeyWord(temp);
		}
		else if (s.contains("Sequence(")) {
			String temp = s.replaceFirst("Sequence(", "");
			temp = temp.replace(")", "");
			return isKeyWord(temp);
		}
		else
		{
			return false;
		}
	}

}
