package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.parse.EolParser;

public class ExecutableAnnotationCreator extends AnnotationCreator{

	@Override
	public EolElement create(AST ast, EolElement container,
			Ast2DomContext context) {

		ExecutableAnnotation annotation = context.getEolFactory().createExecutableAnnotation(); //create an ExecutableAnnotation
		this.setAssets(ast, annotation, container);
		
		AST nameAst = ast.getFirstChild(); //fetch the first child
		if(nameAst != null && nameAst.getType() == EolParser.NAME)
		{
			annotation.setName((NameExpression) context.getEolElementCreatorFactory().createDomElement(nameAst, annotation, context, NameExpressionCreator.class)); //set name for annotation
		}
		
		AST expressionAst = ast.getFirstChild().getNextSibling(); //fetch the second child
		annotation.setExpression((Expression) context.getEolElementCreatorFactory().createDomElement(expressionAst, annotation, context)); //setExpression
		
		return annotation;
	}

	@Override
	public boolean appliesTo(AST ast) {
		if(ast.getType() == EolParser.EXECUTABLEANNOTATION)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
