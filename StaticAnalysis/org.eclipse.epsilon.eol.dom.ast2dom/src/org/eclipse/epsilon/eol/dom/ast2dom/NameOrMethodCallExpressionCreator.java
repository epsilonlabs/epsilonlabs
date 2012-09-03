package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.dom.MethodCallExpression;
import org.eclipse.epsilon.eol.dom.NameExpression;
import org.eclipse.epsilon.eol.parse.EolParser;

public class NameOrMethodCallExpressionCreator extends ExpressionCreator{

	@Override
	public DomElement create(AST ast, DomElement container,
			Ast2DomContext context) {
AST parametersAst = ast.getFirstChild();
		
		if (parametersAst != null && parametersAst.getType() == EolParser.PARAMETERS) {
			MethodCallExpression exp = (MethodCallExpression)context.getDomFactory().createMethodCallExpression();
			exp.setLine(ast.getLine());
			exp.setColumn(ast.getColumn());
			
			exp.setMethod(ast.getText());
			for (AST parameterAst : parametersAst.getChildren()) {
				exp.getArguments().add((Expression) context.getDomElementCreatorFactory().createDomElement(parameterAst, exp, context));
			}
			
			//exp.printSelf();
			//System.out.println(exp.getClass());
			return exp;
		}
		else if (parametersAst != null && parametersAst.getType() == EolParser.PARAMLIST) {
			MethodCallExpression exp = (MethodCallExpression) context.getDomFactory().createMethodCallExpression();
			exp.setLine(ast.getLine());
			exp.setColumn(ast.getColumn());
			
			exp.setMethod(ast.getText());
			for (AST parameterAst : parametersAst.getChildren()) {
				exp.getArguments().add((Expression) context.getDomElementCreatorFactory().createDomElement(parameterAst, exp, context));
			}
			
			//exp.printSelf();
			//System.out.println(exp.getClass());
			return exp;
		}
		else {
			NameExpression exp = (NameExpression) context.getDomFactory().createNameExpression();
			exp.setLine(ast.getLine());
			exp.setColumn(ast.getColumn());
			
			exp.setName(ast.getText());
			//exp.printSelf();
			//System.out.println(exp.getClass());
			return exp;
		}
	}

}
