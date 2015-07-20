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
	
	protected LogBook logBook = new LogBook();
	protected IMetamodelManager iMetamodelManager = new IMetamodelManager();
	
	protected TypeUtil typeUtil = new TypeUtil();
	protected final String[] supportedDrivers = {"EMF", "XML"};
	
	protected OperationDefinitionManager operationDefinitionManager = null;
	
	public TypeResolutionContext()
	{
		typeUtil.setContext(this);
		operationDefinitionManager = new OperationDefinitionManager(this);
	}
	
	public TypeUtil getTypeUtil() {
		return typeUtil;
	}
	
	public LogBook getLogBook() {
		return logBook;
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
