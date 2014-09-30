package org.eclipse.epsilon.eol.visitor.resolution.type.impl;


import metamodel.connectivity.abstractmodel.EMetamodelDriver;
import metamodel.connectivity.emf.EMFMetamodelDriver;
import metamodel.connectivity.plainxml.PlainXMLMetamodelDriver;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.ModelDeclarationStatementVisitor;
import org.eclipse.epsilon.eol.parse.Eol_EolParserRules.elseStatement_return;
import org.eclipse.epsilon.eol.parse.Eol_EolParserRules.returnStatement_return;
import org.eclipse.epsilon.eol.visitor.resolution.type.context.TypeResolutionContext;

/*
 * this implementation is subjected to major changes when the metamodel loaders are properly developed
 */

public class ModelDeclarationStatementTypeResolver extends ModelDeclarationStatementVisitor<TypeResolutionContext, Object>{
	
	@Override
	public Object visit(ModelDeclarationStatement modelDeclarationStatement,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		//fetch the sourceParameter which specifies the metamodel information
		ModelDeclarationParameter sourceParameter = null;
		
		//fetch the metamodel name or NSURI
		String sourceString = ""; 

		//if the driver is EMF
		if(getDriverType(modelDeclarationStatement).equals("EMF"))
		{
			//get the nsuri 
			sourceParameter = getParameter("nsuri", modelDeclarationStatement);
			
			//if nsuri is not found, find uri for file location
			if (sourceParameter == null) {
				sourceParameter = getParameter("uri", modelDeclarationStatement);	
			}
			
			
			//if no nsuri is defined, it should report error and return
			if (sourceParameter == null) {
				context.getLogBook().addError(modelDeclarationStatement, "either an nsuri or an uri needs to be specified");
				return null;
			}
			else {
				
				//if nsuri or the uri is found, get it 
				sourceString = sourceParameter.getValue().getVal();
				
				//create a new MetaModel
				EMetamodelDriver metaModel = new EMFMetamodelDriver(); 
				
				//try loading the model
				try {
					//load the model
					metaModel.loadModel(sourceString);
				} catch (Exception e) {
					//if loading fails, raise error to the logbook.
					context.getLogBook().addError(modelDeclarationStatement, "cannot load model: " + e.getMessage());
					return null;
				}
				
				//get the model name
				String modelName = modelDeclarationStatement.getName().getName().getName();
				
				//add given name
				metaModel.setName(modelName);
				
				//add aliases
				for(VariableDeclarationExpression name: modelDeclarationStatement.getAlias()) 
				{
					if (name.getName().equals(modelName)) {
						context.getLogBook().addError(name, "name already used to define the model name");
					}
					else {
						metaModel.addAlias(name.getName().getName());	
					}
				}
				
				//put the metamodel in the context
				String s = context.inputMetaModel(metaModel);
				if (!s.equals("")) {
					context.getLogBook().addError(modelDeclarationStatement, s);
				}
				
				else {
					//put the ModelDeclarationStatement in the context
					context.putModelDeclarationStatement(modelName, modelDeclarationStatement); 	
				}

			}
		}
		else if (getDriverType(modelDeclarationStatement).equals("XML")) {
			
			//if nsuri is not found, find uri for file location
			sourceParameter = getParameter("uri", modelDeclarationStatement);	
			
			//if no nsuri is defined, it should report error and return
			if (sourceParameter == null) {
				context.getLogBook().addError(modelDeclarationStatement, "an uri needs to be specified");
				return null;
			}
			else {
				
				//if nsuri or the uri is found, get it 
				sourceString = sourceParameter.getValue().getVal();
				
				//create a new XMLMetaModel
				PlainXMLMetamodelDriver metaModel = new PlainXMLMetamodelDriver();
				
				try {
					metaModel.loadModel(context.getParentFolderDirectory() + sourceString);
				} catch (Exception e) {
					context.getLogBook().addError(modelDeclarationStatement, "cannot load model: " + e.getMessage());
					return null;
				}
				
				//get the model name
				String modelName = modelDeclarationStatement.getName().getName().getName();
				
				//add given name
				metaModel.setName(modelName);
				
				//add aliases
				for(VariableDeclarationExpression name: modelDeclarationStatement.getAlias()) 
				{
					if (name.getName().equals(modelName)) {
						context.getLogBook().addError(name, "name already used to define the model name");
					}
					else {
						metaModel.addAlias(name.getName().getName());	
					}
				}
				
				//put the metamodel in the context
				String s = context.inputMetaModel(metaModel);
				if (!s.equals("")) {
					context.getLogBook().addError(modelDeclarationStatement, s);
				}
				
				else {
					//put the ModelDeclarationStatement in the context
					context.putModelDeclarationStatement(modelName, modelDeclarationStatement); 	
				}
			}
		}
		else {
			context.getLogBook().addError(modelDeclarationStatement.getDriver(), "Driver technology unknown");
		}
		return null;
		
	}
	
	private ModelDeclarationParameter getParameter(String paramName, ModelDeclarationStatement statement)
	{
		ModelDeclarationParameter result = null;
		for(ModelDeclarationParameter parameter: statement.getParameters())
		{
			if (parameter.getName().getName().equals(paramName)) {
				return parameter;
			}
		}
		return result;
	}
	
	private String getDriverType(ModelDeclarationStatement statement)
	{
		return statement.getDriver().getName().getName();
	}
		
}
