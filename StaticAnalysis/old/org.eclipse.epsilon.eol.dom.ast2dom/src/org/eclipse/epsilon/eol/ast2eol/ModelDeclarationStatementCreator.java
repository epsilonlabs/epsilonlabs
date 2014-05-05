package org.eclipse.epsilon.eol.ast2eol;


import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.parse.EolParser;

public class ModelDeclarationStatementCreator extends StatementCreator{

	@Override
	public boolean appliesTo(AST ast) {
		if(ast.getType() == EolParser.MODELDECLARATION)
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
		
		ModelDeclarationStatement statement = context.getEolFactory().createModelDeclarationStatement();
		this.setAssets(ast, statement, container);
		
		AST nameAst = ast.getChild(0);
		statement.setName((NameExpression) context.getEolElementCreatorFactory().createDomElement(nameAst, statement, context, NameExpressionCreator.class));
		
		AST aliasAst = AstUtilities.getChild(ast, EolParser.ALIAS);
		if(aliasAst != null)
		{
			for(AST alias: aliasAst.getChildren())
			{			
				statement.getAlias().add((NameExpression) context.getEolElementCreatorFactory().createDomElement(alias, statement, context, NameExpressionCreator.class));
			}
		}
		
		AST driverAst = AstUtilities.getChild(ast, EolParser.DRIVER);
		if(driverAst != null)
		{	
			statement.setDriver((NameExpression) context.getEolElementCreatorFactory().createDomElement(driverAst.getChild(0), statement, context, NameExpressionCreator.class));
		}
		
		AST parameterListAst = AstUtilities.getChild(ast, EolParser.MODELDECLARATIONPARAMETERS);
		if(parameterListAst != null)
		{
			for(AST parameterAst: parameterListAst.getChildren())
			{
				statement.getParameters().add((ModelDeclarationParameter) context.getEolElementCreatorFactory().createDomElement(parameterAst, statement, context));
			}
		}
		
		//ModelDeclarationParameter sourceParameter = fetchSourceParameter(statement);
		//String sourceString = sourceParameter.getValue().getVal();
		//MetaModel metaModel = context.createMetaModel();
		//metaModel.loadModel(sourceString);
	//	context.getMetaModels().add(metaModel);
		
		return statement;
	}
	
	public ModelDeclarationParameter fetchSourceParameter(ModelDeclarationStatement statement)
	{
		ModelDeclarationParameter result = null;
		for(ModelDeclarationParameter parameter: statement.getParameters())
		{
			if (parameter.getName().getName().equals("metamodel")) {
				result = parameter;
				break;
			}
		}
		return result;
	}

}
