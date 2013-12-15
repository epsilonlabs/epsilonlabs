package org.eclipse.epsilon.eol.dom.ast2dom;

public abstract class FeatureCallExpressionCreator extends ExpressionCreator{

	
	
	/*
	public DomElement create(AST ast, DomElement container,
			Ast2DomContext context) {
		
		AST targetAst = ast.getFirstChild(); //get the targetAst
		AST featureAst = targetAst.getNextSibling(); //get the featureAst
		AST parametersAst = featureAst.getFirstChild(); //get the parameterAst
		
		FeatureCallExpression exp = null;
		if (parametersAst == null) { //if there is no parameter, it would be a property call
			PropertyCallExpression pexp = (PropertyCallExpression) context.getDomFactory().createPropertyCallExpression(); //create an PropertyCallExpression
			pexp.setLine(ast.getLine()); //set line number
			pexp.setColumn(ast.getColumn()); //set column number
			
			NameExpression property = (NameExpression)context.getDomFactory().createNameExpression();
			property.setContainer(pexp);
			property.setLine(featureAst.getLine()); //set line number
			property.setColumn(featureAst.getColumn()); //set column number
						
			String propertyString = featureAst.getText(); //obtain the string for the feature
			
			BooleanExpression extended = context.getDomFactory().createBooleanExpression(); //create a BooleanExpression for "extended"
			extended.setContainer(pexp); //set the container
			extended.setLine(featureAst.getLine()); //set line number
			extended.setColumn(featureAst.getColumn()); //set column number
			
			if (propertyString.startsWith("~")) { //if the string for the feature starts with ~
				property.setName(propertyString.substring(1)); //set the name of the property to the extended property
				extended.setVal(true); //set extended to true
			}
			else { //if not an extended property
				property.setName(propertyString); //set the name 
			}
			pexp.setProperty(property); //set the property of the pexp
			pexp.setExtended(extended); //set the extended of the pexp
			
			exp = pexp;
		}
		else {
			
			if(parametersAst.getType() == EolParser.PARAMLIST) //if there is a parameter list, it would be a first logic order method
			{
				FOLMethodCallExpression fexp = (FOLMethodCallExpression) context.getDomFactory().createFOLMethodCallExpression(); //create a FOLMethodCallExpression
				fexp.setLine(ast.getLine()); //set line number
				fexp.setColumn(ast.getColumn()); //set column number
				
				NameExpression method = (NameExpression)context.getDomFactory().createNameExpression(); //create a NameExpression for method
				method.setContainer(fexp); //set the container of the method to fexp
				method.setLine(featureAst.getLine());
				method.setColumn(featureAst.getColumn());
				method.setName(featureAst.getText());
				fexp.setMethod(method);
				
				AST iteratorAst = parametersAst.getFirstChild(); //get iteratorAst
				AST conditionAst = parametersAst.getNextSibling(); //get conditionAst
				fexp.setIterator((VariableDeclarationExpression) context.getDomElementCreatorFactory().createDomElement(iteratorAst, fexp, context));
				fexp.setCondition((Expression) context.getDomElementCreatorFactory().createDomElement(conditionAst, fexp, context));
				
				exp = fexp;
			}
			else
			{ //if there are parameters, then it should be a methodCallExpression
				MethodCallExpression mexp = (MethodCallExpression) context.getDomFactory().createMethodCallExpression(); //create a method call
				mexp.setLine(ast.getLine()); //set line number
				mexp.setColumn(ast.getColumn()); //set column number
						
				NameExpression method = (NameExpression)context.getDomFactory().createNameExpression(); //create a NameExpression for method
				method.setContainer(mexp); //set the container of the method to mexp
				method.setLine(featureAst.getLine()); //set line number
				method.setColumn(featureAst.getColumn()); //set column number
				method.setName(featureAst.getText()); //set name
				mexp.setMethod(method); //set method for MethodCallExpression
				
				for (AST parameterAst : parametersAst.getChildren()) {
					mexp.getArguments().add((Expression) context.getDomElementCreatorFactory().createDomElement(parameterAst, mexp, context)); //process arguments
				}
				
				exp = mexp;
			}
		}
		NameExpression target = context.getDomFactory().createNameExpression();
		target.setContainer(exp);
		target.setLine(targetAst.getLine());
		target.setColumn(targetAst.getColumn());
		target.setName(targetAst.getText());
		exp.setTarget(target);
		
		BooleanExpression isArrow = context.getDomFactory().createBooleanExpression();
		isArrow.setContainer(exp);
		isArrow.setLine(ast.getLine());
		isArrow.setColumn(ast.getColumn());
		isArrow.setVal(ast.getType() == EolParser.ARROW);
		exp.setIsArrow(isArrow);
		
		return exp;
	}

	public boolean appliesTo(AST ast) {
		return false;
	}
	*/

}
