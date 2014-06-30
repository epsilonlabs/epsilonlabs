package org.eclipse.epsilon.eol.visitor.resolution.type.impl;


import metamodel.connectivity.abstractmodel.EMetamodelDriver;
import metamodel.connectivity.emf.EMFMetamodelDriver;
import metamodel.connectivity.plainxml.PlainXMLMetamodelDriver;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.ModelDeclarationStatementVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.context.TypeResolutionContext;

public class ModelDeclarationStatementTypeResolver extends ModelDeclarationStatementVisitor<TypeResolutionContext, Object>{

	//this implementation is subjected to major changes when the metamodel loaders are properly developed
	@Override
	public Object visit(ModelDeclarationStatement modelDeclarationStatement,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		ModelDeclarationParameter sourceParameter = fetchSourceParameter(modelDeclarationStatement); //fetch the sourceParameter which specifies the metamodel information
		String sourceString = sourceParameter.getValue().getVal(); //fetch the metamodel name or NSURI

		if(modelDeclarationStatement.getDriver().getName().getName().equals("EMF"))
		{
			EMetamodelDriver metaModel = new EMFMetamodelDriver(); //create a new MetaModel
			try {
				metaModel.loadModel(sourceString);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //load the metamodel with the name or NSURI
			
			//System.out.println(metaModel.getMetaModelName());
			String modelName = modelDeclarationStatement.getName().getName().getName();
			metaModel.setName(modelName); //add given name
			for(VariableDeclarationExpression name: modelDeclarationStatement.getAlias()) //add aliases
			{
				metaModel.addAlias(name.getName().getName());
			}
			context.inputMetaModel(metaModel); //put the metamodel in the context
			context.putModelDeclarationStatement(modelName, modelDeclarationStatement); //put the ModelDeclarationStatement in the context
			
		}
		else if (modelDeclarationStatement.getDriver().getName().getName().equals("XML")) {
			PlainXMLMetamodelDriver metaModel = new PlainXMLMetamodelDriver();
			String directoryPath = context.getDirectoryPathString();
			try {
				metaModel.loadModel(directoryPath + sourceString);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String modelName = modelDeclarationStatement.getName().getName().getName();

			metaModel.setName(modelName); //add given name
			for(VariableDeclarationExpression name: modelDeclarationStatement.getAlias()) //add aliases
			{
				metaModel.addAlias(name.getName().getName());
			}
			context.inputMetaModel(metaModel); //put the metamodel in the context
			context.putModelDeclarationStatement(modelName, modelDeclarationStatement); //put the ModelDeclarationStatement in the context
		}
		return null;
		
	}
	
	private ModelDeclarationParameter fetchSourceParameter(ModelDeclarationStatement statement)
	{
		ModelDeclarationParameter result = null; //declare result
		for(ModelDeclarationParameter parameter: statement.getParameters()) //loop through ModelDeclarationParameters
		{
			if (parameter.getName().getName().equals("nsuri")) { //if parameter 'metamodel' is found
				result = parameter; //set result and break
				break;
			}
		}
		return result;
	}
	
}
