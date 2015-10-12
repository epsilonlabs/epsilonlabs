package org.eclipse.epsilon.analysis.model.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.eclipse.epsilon.analysis.model.driver.IMetamodelDriver;
import org.eclipse.epsilon.eol.problem.imessages.IMessage_IMetamodelDriver;

public class IMetamodelManager {

	ArrayList<IMetamodelDriver> iMetamodelDrivers = new ArrayList<IMetamodelDriver>();

	HashMap<String, HashSet<IMetamodelDriver>> aliasMap = new HashMap<String, HashSet<IMetamodelDriver>>();
	
	HashSet<String> metamodelNamespace = new HashSet<String>();
	
	public ArrayList<IMetamodelDriver> getiMetamodelDrivers() {
		return iMetamodelDrivers;
	}
	
	public void addIMetamodelDriver(IMetamodelDriver iMetamodelDriver)
	{
		if (addToMetamodelNamespace(iMetamodelDriver)) {
			iMetamodelDrivers.add(iMetamodelDriver);
			for(String alias: iMetamodelDriver.getAliases())
			{
				HashSet<IMetamodelDriver> _iMetamodelDrivers = aliasMap.get(alias);
				if (_iMetamodelDrivers != null) {
					_iMetamodelDrivers.add(iMetamodelDriver);
				}
				else {
					_iMetamodelDrivers = new HashSet<IMetamodelDriver>();
					_iMetamodelDrivers.add(iMetamodelDriver);
					aliasMap.put(alias, _iMetamodelDrivers);
				}
			}
		}
	}
	
	public boolean addToMetamodelNamespace(IMetamodelDriver iMetamodelDriver)
	{
		if (!metamodelNamespace.add(iMetamodelDriver.getName())) {
			iMetamodelDriver.getLogBook().addError(iMetamodelDriver.getModelDeclarationStatement().getName(), IMessage_IMetamodelDriver.bindMessage(IMessage_IMetamodelDriver.METAMODEL_NAME_EXISTS,  iMetamodelDriver.getModelDeclarationStatement().getName().getName().getName()));
			return false;
		}
		else {
			return true;
		}
	}
	
	public IMetamodelDriver getIMetamodelDriverWithName(String iMetamodelDriver)
	{
		for(IMetamodelDriver driver: iMetamodelDrivers)
		{
			if (driver.getName().equals(iMetamodelDriver)) {
				return driver;
			}
		}
		return null;
	}
	
	public HashSet<IMetamodelDriver> getIMetamodelDriversWithAlias(String alias)
	{
		return aliasMap.get(alias);
	}
	        
}
