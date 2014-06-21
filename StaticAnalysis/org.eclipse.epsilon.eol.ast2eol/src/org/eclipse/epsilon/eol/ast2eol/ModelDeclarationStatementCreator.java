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
		VariableDeclarationExpression model_name = context.getEolFactory().createVariableDeclarationExpression();
		setAssets(nameAst, model_name, statement);
		model_name.setName((NameExpression) context.getEolElementCreatorFactory().createDomElement(nameAst, statement, context, NameExpressionCreator.class));
		statement.setName(model_name);
		
//		ModelType modelType = context.getEolFactory().createModelType();
//		modelType.setModelName(model_name.getName());
		
		AST aliasAst = AstUtilities.getChild(ast, EolParser.ALIAS);
		if(aliasAst != null)
		{
			for(AST alias: aliasAst.getChildren())
			{	
				VariableDeclarationExpression a = context.getEolFactory().createVariableDeclarationExpression();
				setAssets(alias, a, statement);
				a.setName((NameExpression) context.getEolElementCreatorFactory().createDomElement(alias, statement, context, NameExpressionCreator.class));
				statement.getAlias().add(a);
				
			}
		}
		
		AST driverAst = AstUtilities.getChild(ast, EolParser.DRIVER);
		if(driverAst != null)
		{	
			VariableDeclarationExpression driver = context.getEolFactory().createVariableDeclarationExpression();
			setAssets(driverAst, driver, statement);
			driver.setName((NameExpression) context.getEolElementCreatorFactory().createDomElement(driverAst.getChild(0), statement, context, NameExpressionCreator.class));
			statement.setDriver(driver);
		}
		
		AST parameterListAst = AstUtilities.getChild(ast, EolParser.MODELDECLARATIONPARAMETERS);
		if(parameterListAst != null)
		{
			for(AST parameterAst: parameterListAst.getChildren())
			{
				statement.getParameters().add((ModelDeclarationParameter) context.getEolElementCreatorFactory().createDomElement(parameterAst, statement, context));
			}
		}
		
		return statement;
	}
	

}
