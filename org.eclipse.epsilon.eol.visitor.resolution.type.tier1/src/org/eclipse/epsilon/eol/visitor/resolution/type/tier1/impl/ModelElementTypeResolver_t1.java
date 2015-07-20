package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import java.util.ArrayList;
import java.util.HashSet;

import org.eclipse.epsilon.analysis.model.driver.IMetamodelDriver;
import org.eclipse.epsilon.analysis.model.driver.IPackageDriver;
import org.eclipse.epsilon.analysis.model.driver.emf.EMFIMetamodelDriver;
import org.eclipse.epsilon.analysis.model.driver.plainxml.PlainXMLIMetamodelDriver;
import org.eclipse.epsilon.eol.metamodel.ModelElementType;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.ModelElementTypeVisitor;
import org.eclipse.epsilon.eol.problem.imessages.IMessage_TypeResolution;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class ModelElementTypeResolver_t1 extends ModelElementTypeVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(ModelElementType modelElementType,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		//get the string for model
		String modelString = modelElementType.getModelName();
		
		//get the string for element
		String elementString = modelElementType.getElementName(); 
		
		//if keyword _ModelElementType_ is found, then return null, do nothing
		if (modelString == null && elementString.equals("_ModelElementType_")) { 
			return null;
		}
		
		if (context.getiMetamodelManager().getiMetamodelDrivers().size() == 0) {
			context.getLogBook().addError(modelElementType, IMessage_TypeResolution.MODEL_DECL_NO_MODEL_DECLARED);
			return null;
		}
		
		
		//if model name is not null
		if (modelString != null) {
			
			//if elementString is not null
			if (elementString != null) {
				
				IMetamodelDriver iMetamodelDriver = context.getiMetamodelManager().getIMetamodelDriverWithName(modelString);
				if (iMetamodelDriver != null) {
					handleTypeWithIMetamodelDriver(modelElementType, iMetamodelDriver, context, modelString, elementString);
				}
				else {
					HashSet<IMetamodelDriver> iMetamodelDrivers = context.getiMetamodelManager().getIMetamodelDriversWithAlias(modelString);
					if (iMetamodelDrivers.size() == 0) {
						context.getLogBook().addError(modelElementType, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.TYPE_CANNOT_BE_RESOLVED, modelString+"!"+elementString));
					}
					else if (iMetamodelDrivers.size() == 1) {
						handleTypeWithIMetamodelDriver(modelElementType, iMetamodelDriver, context, modelString, elementString);
					}
					else if (iMetamodelDrivers.size() > 1) {
						ArrayList<IMetamodelDriver> iMetamodelDriversFound = new ArrayList<IMetamodelDriver>();
						for(IMetamodelDriver iMetamodelDriver2: iMetamodelDrivers)
						{
							if (context.getTypeUtil().iMetamodelContainsMetaElement(iMetamodelDriver2, modelString, elementString)) {
								iMetamodelDriversFound.add(iMetamodelDriver2);
							}
						}
						if (iMetamodelDriversFound.size() == 0) {
							context.getLogBook().addError(modelElementType, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.TYPE_CANNOT_BE_RESOLVED, modelString+"!"+elementString));
						}
						else if (iMetamodelDriversFound.size() > 1) {
							context.getLogBook().addError(modelElementType, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.MODEL_ELEMENT_DEFINED_IN_MULTIPLE_METAMODELS, modelString+"!"+elementString));
						}
						else {
							handleTypeWithIMetamodelDriver(modelElementType, iMetamodelDriversFound.get(0), context, modelString, elementString);
						}
					}
				}
			}
			else {
				context.getLogBook().addError(modelElementType, IMessage_TypeResolution.ELEMENT_TYPE_CANNOT_BE_NULL);
			}
		}
		
		//if model string is null
		else {
			
			ArrayList<IMetamodelDriver> iMetamodelDrivers = context.getiMetamodelManager().getiMetamodelDrivers();
			if (iMetamodelDrivers.size() == 0) {
				context.getLogBook().addError(modelElementType, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.TYPE_CANNOT_BE_RESOLVED, "!"+elementString));
			}
			else if (iMetamodelDrivers.size() == 1) {
				handleTypeWithIMetamodelDriver(modelElementType, iMetamodelDrivers.get(0), context, "", elementString);
			}
			else if (iMetamodelDrivers.size() > 1) {
				ArrayList<IMetamodelDriver> iMetamodelDriversFound = new ArrayList<IMetamodelDriver>();
				for(IMetamodelDriver iMetamodelDriver2: iMetamodelDrivers)
				{
					if (context.getTypeUtil().iMetamodelContainsMetaElement(iMetamodelDriver2, "", elementString)) {
						iMetamodelDriversFound.add(iMetamodelDriver2);
					}
				}
				if (iMetamodelDriversFound.size() == 0) {
					context.getLogBook().addError(modelElementType, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.TYPE_CANNOT_BE_RESOLVED, "!"+elementString));
				}
				else if (iMetamodelDriversFound.size() > 1) {
					context.getLogBook().addError(modelElementType, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.MODEL_ELEMENT_DEFINED_IN_MULTIPLE_METAMODELS, "!"+elementString));
				}
				else {
					handleTypeWithIMetamodelDriver(modelElementType, iMetamodelDriversFound.get(0), context, "", elementString);
				}
			}
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
