package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context;

import org.eclipse.epsilon.analysis.model.driver.IMetamodelDriver;
import org.eclipse.epsilon.eol.metamodel.EOLElement;
import org.eclipse.epsilon.eol.metamodel.EOLLibraryModule;
import org.eclipse.epsilon.eol.problem.LogBook;

public class TypeResolutionContext {

	protected EOLLibraryModule currentProgram = null;
	protected EOLElement currentEOLElement = null;
	
	protected LogBook logBook = new LogBook();
	protected IMetamodelManager iMetamodelManager = new IMetamodelManager();
	
	protected final String[] supportedDrivers = {"EMF", "XML"};
	
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
	
}
