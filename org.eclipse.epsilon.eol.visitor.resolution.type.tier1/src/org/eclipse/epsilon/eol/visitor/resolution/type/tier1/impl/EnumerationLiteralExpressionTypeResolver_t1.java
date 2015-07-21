package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.epsilon.analysis.model.driver.IMetamodelDriver;
import org.eclipse.epsilon.analysis.model.driver.IPackageDriver;
import org.eclipse.epsilon.analysis.model.driver.emf.EMFIMetamodelDriver;
import org.eclipse.epsilon.analysis.model.driver.plainxml.PlainXMLIMetamodelDriver;
import org.eclipse.epsilon.eol.metamodel.EnumerationLiteralExpression;
import org.eclipse.epsilon.eol.metamodel.EolFactory;
import org.eclipse.epsilon.eol.metamodel.ModelElementType;
import org.eclipse.epsilon.eol.metamodel.visitor.EnumerationLiteralExpressionVisitor;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.problem.imessages.IMessage_TypeResolution;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class EnumerationLiteralExpressionTypeResolver_t1 extends EnumerationLiteralExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(
			EnumerationLiteralExpression enumerationLiteralExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		String modelName = enumerationLiteralExpression.getModel().getName(); //get model name
		String enumName = enumerationLiteralExpression.getEnumeration().getName(); //get enumName
		String literalName = enumerationLiteralExpression.getLiteral().getName(); //get literalname
		enumerationLiteralExpression.setResolvedType(EolFactory.eINSTANCE.createIntegerType());

		
		ArrayList<IMetamodelDriver> iMetamodelDrivers = context.getTypeUtil().getIMetamodelDrivers(modelName, enumName);
		if (iMetamodelDrivers.size() == 0) {
			context.getLogBook().addError(enumerationLiteralExpression, IMessage_TypeResolution.ENUM_CANNOT_BE_RESOLVED);
		}
		else if (iMetamodelDrivers.size() == 1) {
			IMetamodelDriver iMetamodelDriver = iMetamodelDrivers.get(0);
			if (enumName.contains("::")) {
				
			}
		}
		
		IMetamodelDriver mm = context.getMetaModel(modelName); //get metamodel
		if (mm != null) { //if metamodel is not null
			if (mm.containsEnum(enumName)) { //if metamodel caontains enumeration
				if (mm.containsEnumLiteral(enumName, literalName)) { //if enumeration contains literal
					
					EType type = context.getEolFactory().createEType(); //create eType
					type.setEcoreType((EClassifier) mm.getEnum(enumName)); //set ecoreType
					context.setAssets(type, enumerationLiteralExpression); //set assets
					enumerationLiteralExpression.setResolvedType(type);
				}
				else {
					//handle enumerationliteral not found
					context.getLogBook().addError(enumerationLiteralExpression.getLiteral(), "literal is not found");
				}
			}
			else {
				//handle enum not found
				context.getLogBook().addError(enumerationLiteralExpression.getEnumeration(), "Enumeration is not found");
			}
		}
		else {
			context.getLogBook().addError(enumerationLiteralExpression.getModel(), "Model not found");
			//handle model not found
		}
		return null;
	}
	
	public void handleTypeWithIMetamodelDriver(ModelElementType modelElementType, IMetamodelDriver iMetamodelDriver, TypeResolutionContext context, String modelString, String elementString)
	{
		
		String[] identifiers = elementString.split("::");
		
		if (iMetamodelDriver instanceof EMFIMetamodelDriver) {
			
			if (identifiers.length == 1) {
				if (iMetamodelDriver.getIPackageDrivers().size() == 1) {
					IPackageDriver iPackageDriver = iMetamodelDriver.getIPackageDrivers().get(0);
					if (iPackageDriver.getMetaElement(identifiers[0]) != null) {
						modelElementType.setModelType(iPackageDriver.getMetaElement(identifiers[0]));
						modelElementType.setResolvedIModel(iMetamodelDriver.getIModel());
						modelElementType.setResolvedModelDeclaration(iMetamodelDriver.getModelDeclarationStatement());
						return;
					}
					else {
						context.getLogBook().addError(modelElementType, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.TYPE_CANNOT_BE_RESOLVED, modelString+"!"+elementString));
					}				
				}
				else {
					boolean found = false;
					for(IPackageDriver iPackageDriver : context.getTypeUtil().getAllIPackageDrivers(iMetamodelDriver))
					{
						if (iPackageDriver.containsMetaElement(identifiers[0])) {
							found = true;
							modelElementType.setModelType(iPackageDriver.getMetaElement(identifiers[0]));
							modelElementType.setResolvedIModel(iMetamodelDriver.getIModel());
							modelElementType.setResolvedModelDeclaration(iMetamodelDriver.getModelDeclarationStatement());
							return;
						}
					}
					if (!found) {
						context.getLogBook().addError(modelElementType, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.TYPE_CANNOT_BE_RESOLVED, modelString+"!"+elementString));
					}
				}
			}
			else {
				IPackageDriver iPackageDriver = iMetamodelDriver.getIPackageDriver(identifiers[0]);
				
				for(int i = 1; i < identifiers.length-1; i++)
				{
					iPackageDriver = iPackageDriver.getSubPackageDriver(identifiers[i]);
				}	
				if (iPackageDriver.getMetaElement(identifiers[identifiers.length-2]) != null) {
					modelElementType.setModelType(iPackageDriver.getMetaElement(identifiers[0]));
					modelElementType.setResolvedIModel(iMetamodelDriver.getIModel());
					modelElementType.setResolvedModelDeclaration(iMetamodelDriver.getModelDeclarationStatement());
					return;
				}
				else {
					context.getLogBook().addError(modelElementType, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.TYPE_CANNOT_BE_RESOLVED, modelString+"!"+elementString));
				}
			}
		}
		
		else if (iMetamodelDriver instanceof PlainXMLIMetamodelDriver) {
			if (!elementString.startsWith("t_")) {
				context.getLogBook().addError(modelElementType, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.INVALID_XML_TYPE_NOTATION, elementString.substring(0, 2)));
				return;
			}
			else {

				if (iMetamodelDriver.getIPackageDrivers().size() == 1) {
					IPackageDriver iPackageDriver = iMetamodelDriver.getIPackageDrivers().get(0);
					if (iPackageDriver.getMetaElement(identifiers[0]) != null) {
						modelElementType.setModelType(iPackageDriver.getMetaElement(identifiers[0]));
						modelElementType.setResolvedIModel(iMetamodelDriver.getIModel());
						modelElementType.setResolvedModelDeclaration(iMetamodelDriver.getModelDeclarationStatement());
						return;
					}
					else {
						context.getLogBook().addError(modelElementType, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.TYPE_CANNOT_BE_RESOLVED, modelString+"!"+elementString));
					}				
				}
				else {
					boolean found = false;
					for(IPackageDriver iPackageDriver : context.getTypeUtil().getAllIPackageDrivers(iMetamodelDriver))
					{
						if (iPackageDriver.containsMetaElement(identifiers[0])) {
							found = true;
							modelElementType.setModelType(iPackageDriver.getMetaElement(identifiers[0]));
							modelElementType.setResolvedIModel(iMetamodelDriver.getIModel());
							modelElementType.setResolvedModelDeclaration(iMetamodelDriver.getModelDeclarationStatement());
							return;
						}
					}
					if (!found) {
						context.getLogBook().addError(modelElementType, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.TYPE_CANNOT_BE_RESOLVED, modelString+"!"+elementString));
					}
				}			
			}
		}
	}
	

}
