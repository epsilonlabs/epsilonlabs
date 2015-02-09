package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.epsilon.eol.parse.Eol_EolParserRules.returnStatement_return;

import metamodel.connectivity.abstractmodel.EMetamodelDriver;

public class MetamodelContainer {

	//container for metamodel drivers
	ArrayList<EMetamodelDriver> metaModelDrivers = new ArrayList<EMetamodelDriver>();
	
	//map for alias and metamodel drivers
	HashMap<String, ArrayList<EMetamodelDriver>> aliasLookUp = new HashMap<String, ArrayList<EMetamodelDriver>>();
	
	//metamodel name space
	ArrayList<String> metaModelNameSpace = new ArrayList<String>();
		
	public ArrayList<EMetamodelDriver> getMetamodelDrivers()
	{
		return metaModelDrivers;
	}
	
	public String addMetamodelDriver(EMetamodelDriver metaModel)
	{
		String result = "";
		result = addToMetaModelNameSpace(metaModel.getName());
		if (!result.equals("")) {
			return result;
		}
		else {
			//add the metamodel in the metamodel arraylist
			metaModelDrivers.add(metaModel);
			//add the aliases into the alias lookup
			for(String s: metaModel.getAliases())
			{
				if (aliasLookUp.containsKey(s)) {
					aliasLookUp.get(s).add(metaModel);
				}
				else {
					ArrayList<EMetamodelDriver> metamodels = new ArrayList<EMetamodelDriver>();
					metamodels.add(metaModel);
					aliasLookUp.put(s, metamodels);
				}
			}
			return result;
		}
	}
		
	public String addToMetaModelNameSpace(String s)
	{
		String result = "";
		if (!metaModelNameSpace.contains(s)) {
			metaModelNameSpace.add(s);
		}
		else {
			result = "Metamodel identifier: " + s + " already exists";
		}
		return result;
	}
	
	public EMetamodelDriver getMetaModel(String name)
	{
		if (metaModelNameSpace.contains(name)) {
			for(EMetamodelDriver m: metaModelDrivers)
			{
				if (m.getName().equals(name)) {
					return m;
				}
			}
		}
		return null;
	}
	
	//get the metamodel with a NSURI
	public EMetamodelDriver getMetaModelWithNSURI(String nsURI)
	{
		for(EMetamodelDriver m: metaModelDrivers)
		{
			if (m.getMetamodelNsURI().equals(nsURI)) {
				return m;
			}
		}
		return null;
	}
	
	//get metamodels with the same alias
	public ArrayList<EMetamodelDriver> getMetaModelsWithAlias(String alias)
	{
		return aliasLookUp.get(alias);
	}
	
	public boolean containsMetaModel(String metaModel)
	{
		return metaModelNameSpace.contains(metaModel);
	}


}
