package org.eclipse.epsilon.eol.ast2eol;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.parse.EolParser;

public class SimpleAnnotationCreator extends AnnotationCreator{

	@Override
	public EolElement create(AST ast, EolElement container,
			Ast2EolContext context) {

		SimpleAnnotation annotation = context.eolFactory.createSimpleAnnotation(); //create a simple annotation
		this.setAssets(ast, annotation, container);
		
		String astText = ast.getText(); //fetch the ast text
		String arr[] = astText.split(" "); //split the string
		if (arr.length != 0) {
			String nameString = arr[0]; //the name string should be the first one
			nameString = nameString.substring(1);  //truncate "@"
			if (arr.length > 1) {
				String valueString = astText.substring(nameString.length()+2); //the value string should be the rest
				StringExpression value = (StringExpression) context.getEolElementCreatorFactory().createDomElement(ast, annotation, context, StringExpressionCreator.class);
				value.setColumn(ast.getColumn() + nameString.length()); //set column
				value.setVal(valueString); //set value of the value
				annotation.getValues().add(value); //set the value of the annotation
			}
			
			NameExpression name = (NameExpression) context.getEolElementCreatorFactory().createDomElement(ast, annotation, context, NameExpressionCreator.class);
			name.setName(nameString); //set name to the NameExpression
			
			annotation.setName(name); //set name for the annotation
			
			
		}
		return annotation;
	}

	@Override
	public boolean appliesTo(AST ast) {
		if(ast.getType() == EolParser.Annotation)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	

}
