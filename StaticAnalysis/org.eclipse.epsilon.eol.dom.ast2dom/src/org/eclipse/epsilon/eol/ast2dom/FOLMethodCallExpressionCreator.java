package org.eclipse.epsilon.eol.ast2dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.parse.EolParser;

public class FOLMethodCallExpressionCreator extends FeatureCallExpressionCreator{

	@Override
	public boolean appliesTo(AST ast) {
		if((ast.getType() == EolParser.POINT || ast.getType() == EolParser.ARROW) && 
				ast.getNumberOfChildren() > 1 &&
				ast.getChild(1).getNumberOfChildren() > 0 &&
				ast.getChild(1).getFirstChild().getType() == EolParser.PARAMLIST)
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
		
		FOLMethodCallExpression expression = (FOLMethodCallExpression) context.getEolFactory().createFOLMethodCallExpression(); //create a FOLMethodCallExpression
		this.setAssets(ast, expression, container);
		
		AST targetAst = ast.getFirstChild(); //get the targetAst
		AST featureAst = targetAst.getNextSibling(); //get the featureAst
		AST parametersAst = featureAst.getFirstChild(); //get the parameterAst
		
		expression.setTarget((Expression) context.getEolElementCreatorFactory().createDomElement(targetAst, expression, context));
		
		expression.setMethod((NameExpression) context.getEolElementCreatorFactory().createDomElement(featureAst, expression, context, NameExpressionCreator.class));
		
		for(AST formalAst: parametersAst.getChildren()) //process the iterator(s)
		{
			expression.getIterators().add((FormalParameterExpression) context.getEolElementCreatorFactory().createDomElement(formalAst, expression, context));
		}
		
		AST conditionAst = parametersAst.getNextSibling();
		while(conditionAst != null) //process the condition(s)
		{
			expression.getConditions().add((Expression) context.getEolElementCreatorFactory().createDomElement(conditionAst, expression, context));
			conditionAst = conditionAst.getNextSibling();
		}
		
		BooleanExpression isArrow = (BooleanExpression) context.getEolElementCreatorFactory().createDomElement(ast, expression, context, BooleanExpressionCreator.class);
		isArrow.setVal((ast.getType() == EolParser.ARROW) ? true : false);
		expression.setIsArrow(isArrow);
		
		return expression;
	}

}
