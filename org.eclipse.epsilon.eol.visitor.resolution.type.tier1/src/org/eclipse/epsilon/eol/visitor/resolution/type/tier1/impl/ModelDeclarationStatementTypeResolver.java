package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import org.eclipse.epsilon.analysis.model.driver.IMetamodelDriver;
import org.eclipse.epsilon.analysis.model.driver.emf.EMFIMetamodelDriver;
import org.eclipse.epsilon.analysis.model.driver.plainxml.PlainXMLIMetamodelDriver;
import org.eclipse.epsilon.eol.metamodel.ModelDeclarationParameter;
import org.eclipse.epsilon.eol.metamodel.ModelDeclarationStatement;
import org.eclipse.epsilon.eol.metamodel.NameExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.ModelDeclarationStatementVisitor;
import org.eclipse.epsilon.eol.problem.LogBook;
import org.eclipse.epsilon.eol.problem.imessages.IMessage_TypeResolution;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class ModelDeclarationStatementTypeResolver extends ModelDeclarationStatementVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(ModelDeclarationStatement modelDeclarationStatement,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		if (validStatement(modelDeclarationStatement, context)) {
			//fetch the sourceParameter which specifies the metamodel information
			ModelDeclarationParameter sourceParameter = null;
			
			//fetch the metamodel name or NSURI
			String sourceString = ""; 

			//if the driver is EMF
			if(getDriverType(modelDeclarationStatement).equals("EMF"))
			{
				//get the nsuri 
				sourceParameter = getParameter("nsURI", modelDeclarationStatement);
				
				//if nsuri is not found, find uri for file location
				if (sourceParameter == null) {
					sourceParameter = getParameter("path", modelDeclarationStatement);	
				}
				
				//if no nsuri is defined, it should report error and return
				if (sourceParameter == null) {
					LogBook.getInstance().addError(modelDeclarationStatement, IMessage_TypeResolution.MODEL_DECL_NSURI_OR_PATH_REQUIRED);
					return null;
				}
				else {
					
					//if nsuri or the uri is found, get it 
					sourceString = ((NameExpression)sourceParameter.getValue()).getName();
					
					//create a new MetaModel
					IMetamodelDriver iMetamodelDriver = new EMFIMetamodelDriver(); 
					iMetamodelDriver.setLogBook(LogBook.getInstance());
					
					boolean loaded = iMetamodelDriver.loadModel(sourceString);
					
					if (loaded) {
						context.getiMetamodelManager().addIMetamodelDriver(iMetamodelDriver);
						return null;
					}
					
					return null;
				}
			}
			else if (getDriverType(modelDeclarationStatement).equals("XML")) {
				
				//if nsuri is not found, find uri for file location
				sourceParameter = getParameter("path", modelDeclarationStatement);	
				
				//if no nsuri is defined, it should report error and return
				if (sourceParameter == null) {
					LogBook.getInstance().addError(modelDeclarationStatement, IMessage_TypeResolution.MODEL_DECL_NSURI_OR_PATH_REQUIRED);
					return null;
				}
				else {
					
					sourceString = ((NameExpression)sourceParameter.getValue()).getName();

					
					//create a new XMLMetaModel
					PlainXMLIMetamodelDriver iMetamodelDriver = new PlainXMLIMetamodelDriver();
					iMetamodelDriver.setLogBook(LogBook.getInstance());

					boolean loaded = iMetamodelDriver.loadModel(sourceString);
					
					if (loaded) {
						context.getiMetamodelManager().addIMetamodelDriver(iMetamodelDriver);
					}
					
					return null;
				}
			}
		}
		
		return null;
		
	}
	
	private ModelDeclarationParameter getParameter(String paramName, ModelDeclarationStatement statement)
	{
		ModelDeclarationParameter result = null;
		for(ModelDeclarationParameter parameter: statement.getParameters())
		{
			NameExpression key = (NameExpression) parameter.getKey();
			
			if (key.getName().equals(paramName)) {
				return parameter;
			}
		}
		return result;
	}

	
	private String getDriverType(ModelDeclarationStatement statement)
	{
		if (statement.getDriver().getName() != null) {
			return statement.getDriver().getName();	
		}
		else {
			
			return null;
		}
		
	}
	
	private boolean validStatement(ModelDeclarationStatement statement, TypeResolutionContext context)
	{
		if (statement.getName() == null) {
			LogBook.getInstance().addError(statement, IMessage_TypeResolution.MODEL_DECL_NO_NAME);
			return false;
		}
		if (statement.getDriver() == null) {
			LogBook.getInstance().addError(statement, IMessage_TypeResolution.MODEL_DECL_NO_DRIVER);
			return false;
		}
		else {
			boolean supported = false;
			String driver = statement.getDriver().getName();
			for(String supportedDriver: context.getSupportedDrivers())
			{
				if (supportedDriver.equals(driver)) {
					supported = true;
					break;
				}
			}
			if (!supported) {
				LogBook.getInstance().addError(statement.getDriver(), IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.MODEL_DECL_DRIVER_NOT_SUPPORTED, driver));
				return false;
			}
		}
		return true;
		
	}


}
