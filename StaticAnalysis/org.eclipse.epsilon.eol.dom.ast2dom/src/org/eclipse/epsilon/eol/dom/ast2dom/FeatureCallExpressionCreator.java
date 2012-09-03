package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.dom.FLOMethodCallExpression;
import org.eclipse.epsilon.eol.dom.FeatureCallExpression;
import org.eclipse.epsilon.eol.dom.MethodCallExpression;
import org.eclipse.epsilon.eol.dom.PropertyCallExpression;
import org.eclipse.epsilon.eol.dom.VariableDeclarationExpression;
import org.eclipse.epsilon.eol.parse.EolParser;

public class FeatureCallExpressionCreator extends ExpressionCreator{

	@Override
	public DomElement create(AST ast, DomElement container,
			Ast2DomContext context) {
		AST targetAst = ast.getFirstChild();
		AST featureAst = targetAst.getNextSibling();
		AST parametersAst = featureAst.getFirstChild();
		
		FeatureCallExpression exp = null;
		if (parametersAst == null) {
			exp = (PropertyCallExpression) context.getDomFactory().createPropertyCallExpression();
			PropertyCallExpression pexp = (PropertyCallExpression) exp;
			pexp.setLine(ast.getLine());
			pexp.setColumn(ast.getColumn());
			
			String property = featureAst.getText();
			if (property.startsWith("~")) {
				pexp.setExtended(true);
				pexp.setProperty(property.substring(1));
			}
			else {
				pexp.setProperty(property);
			}
		}
		else {
			
			if(parametersAst.getType() == EolParser.PARAMLIST)
			{
				exp = (FLOMethodCallExpression) context.getDomFactory().createFLOMethodCallExpression();
				FLOMethodCallExpression mexp = (FLOMethodCallExpression) exp;
				
				mexp.setLine(ast.getLine());
				mexp.setColumn(ast.getColumn());
				
				mexp.setMethod(featureAst.getText());
				AST iteratorAst = parametersAst.getFirstChild();
				AST conditionAst = parametersAst.getNextSibling();
				mexp.setIterator((VariableDeclarationExpression) context.getDomElementCreatorFactory().createDomElement(iteratorAst, mexp, context));
				mexp.setCondition((Expression) context.getDomElementCreatorFactory().createDomElement(conditionAst, mexp, context));
				System.out.println("************************************* " + featureAst.getText() + iteratorAst.getText() + conditionAst.getText());
			}
			else
			{
				exp = (MethodCallExpression) context.getDomFactory().createMethodCallExpression();
				MethodCallExpression mexp = (MethodCallExpression) exp;
				
				mexp.setLine(ast.getLine());
				mexp.setColumn(ast.getColumn());
				
				mexp.setMethod(featureAst.getText());
				for (AST parameterAst : parametersAst.getChildren()) {
					mexp.getArguments().add((Expression) context.getDomElementCreatorFactory().createDomElement(parameterAst, mexp, context));
				}
			}
		}
		
		exp.setArrow(ast.getType() == EolParser.ARROW);
		exp.setTarget((Expression) context.getDomElementCreatorFactory().createDomElement(targetAst, exp, context));
		//System.out.println(exp.getClass());
		//exp.printSelf();
		return exp;
	}

}
