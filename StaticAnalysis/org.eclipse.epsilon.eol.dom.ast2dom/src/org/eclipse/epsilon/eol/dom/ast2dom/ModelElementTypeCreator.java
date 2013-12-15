package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.ModelElementType;
import org.eclipse.epsilon.eol.dom.NameExpression;
import org.eclipse.epsilon.eol.dom.Type;
import org.eclipse.epsilon.eol.parse.EolParser;

public class ModelElementTypeCreator extends TypeCreator{
	
	@Override
	public boolean appliesTo(AST ast) {
		return (ast.getType() == EolParser.TYPE && ast.getText().contains("!")) || 
				(ast.getType() == EolParser.TYPE && !ast.getText().equalsIgnoreCase("Integer")
				&& !ast.getText().equalsIgnoreCase("Boolean")
				&& !ast.getText().equalsIgnoreCase("Real")
				&& !ast.getText().equalsIgnoreCase("String")
				&& !ast.getText().equalsIgnoreCase("Map")
				&& !ast.getText().equalsIgnoreCase("Sequence")
				&& !ast.getText().equalsIgnoreCase("Set")
				&& !ast.getText().equalsIgnoreCase("OrderedSet")
				&& !ast.getText().equalsIgnoreCase("Bag")
				&& !ast.getText().equalsIgnoreCase("Native")
				&& !ast.getText().equalsIgnoreCase("SelfType")
				&& !ast.getText().equalsIgnoreCase("SelfContentType"));
	}
	
	@Override
	public DomElement create(AST ast, DomElement container,
			Ast2DomContext context) {
		ModelElementType type = context.getEolFactory().createModelElementType();
		String name = ast.getText();
		if(name.contains("!"))
		{
			String[] arr = name.split("!");
			String modelString = arr[0];
			String elementString = arr[1];
			
			this.setAssets(ast, type, container);
			type.setModelName(modelString);
			type.setElementName(elementString);
			
		}
		else {
			this.setAssets(ast, type, container);
			type.setElementName(name);
		}
		
		return type;
	}

	@Override
	public Type create(Ast2DomContext context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "N/A";
	}

}
