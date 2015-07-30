package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.analysis.model.driver.IMetamodelDriver;
import org.eclipse.epsilon.eol.metamodel.EOLElement;
import org.eclipse.epsilon.eol.metamodel.EOLLibraryModule;
import org.eclipse.epsilon.eol.problem.LogBook;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.operationDefinitionUtil.OperationDefinitionManager;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeUtil;

public class TypeResolutionContext {
	
	protected EOLLibraryModule currentProgram = null;
	protected EOLElement currentEOLElement = null;
	
	protected IMetamodelManager iMetamodelManager = new IMetamodelManager();
	protected final String[] supportedDrivers = {"EMF", "XML"};
	
	protected OperationDefinitionManager operationDefinitionManager = new OperationDefinitionManager();
	
	public TypeUtil getTypeUtil() {
		return TypeUtil.getInstance();
	}
	
	public LogBook getLogBook() {
		return LogBook.getInstance();
	}
	
	public void addIMetamodelDriver(IMetamodelDriver iMetamodelDriver)
	{
		iMetamodelManager.addIMetamodelDriver(iMetamodelDriver);
	}
	
	public String[] getSupportedDrivers() {
		return supportedDrivers;
	}
	public IMetamodelManager getiMetamodelManager() {
		return iMetamodelManager;
	}
	
	public OperationDefinitionManager getOperationDefinitionManager() {
		return operationDefinitionManager;
	}
	
	public void copyLocation(EOLElement created, EOLElement targetLocation)
	{
		created.setRegion(EcoreUtil.copy(targetLocation.getRegion()));
	}
	
	public void setAssets(EOLElement obj, EOLElement container)
	{
		obj.setRegion(EcoreUtil.copy(container.getRegion()));
		obj.setContainer(container);
	}
	
}
