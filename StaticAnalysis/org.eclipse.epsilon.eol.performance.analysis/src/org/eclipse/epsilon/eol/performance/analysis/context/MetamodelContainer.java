package org.eclipse.epsilon.eol.performance.analysis.context;

import java.util.ArrayList;
import java.util.HashMap;

import metamodel.connectivity.emf.EMFMetamodelDriver;

public class MetamodelContainer {

	//array that contains the metamodels
	ArrayList<EMFMetamodelDriver> metaModels = new ArrayList<EMFMetamodelDriver>();
	
	//map that looks up an array of metamodels with a given alias
	HashMap<String, ArrayList<EMFMetamodelDriver>> aliasLookUp = new HashMap<String, ArrayList<EMFMetamodelDriver>>();
	
	//metamodel name space
	ArrayList<String> metaModelNameSpace = new ArrayList<String>();
	
	
	public static void main(String[] args) {
		MetamodelContainer container = new MetamodelContainer();
		EMFMetamodelDriver mm1 = new EMFMetamodelDriver();
		mm1.setName("name1");
		mm1.addAlias("a");
		mm1.addAlias("b");
		
		EMFMetamodelDriver mm2 = new EMFMetamodelDriver();
		mm2.setName("name2");
		mm2.addAlias("c");
		mm2.addAlias("d");
		mm2.addAlias("a");
		
		EMFMetamodelDriver mm3 = new EMFMetamodelDriver();
		mm3.setName("name1");
		
		container.inputMetaModel(mm1);
		container.inputMetaModel(mm2);
		container.inputMetaModel(mm3);
		
		System.out.println(container.getMetaModelsWithAlias("a").size());
		System.out.println(container.getMetaModelsWithAlias("b").size());
	}
	
	public ArrayList<EMFMetamodelDriver> getMetaModels()
	{
		return metaModels;
	}
	
	public void inputMetaModel(EMFMetamodelDriver metaModel)
	{
		metaModels.add(metaModel);
		try {
			addToMetaModelNameSpace(metaModel.getMetamodelName());
			addToMetaModelNameSpace(metaModel.getMetamodelName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(String s: metaModel.getAliases())
		{
			if (aliasLookUp.containsKey(s)) {
				aliasLookUp.get(s).add(metaModel);
			}
			else {
				ArrayList<EMFMetamodelDriver> metamodels = new ArrayList<EMFMetamodelDriver>();
				metamodels.add(metaModel);
				aliasLookUp.put(s, metamodels);
			}
		}
	}
		
	public void addToMetaModelNameSpace(String s) throws Exception
	{
		if (!metaModelNameSpace.contains(s)) {
			metaModelNameSpace.add(s);
		}
		else {
			throw new Exception("Metamodel Identifier: " + s + " already exists");
		}
	}
	
	public EMFMetamodelDriver getMetaModel(String name)
	{
		if (metaModelNameSpace.contains(name)) {
			for(EMFMetamodelDriver m: metaModels)
			{
				if (m.getMetamodelName().equals(name)) {
					return m;
				}
				else if(m.getMetamodelName().equals(name))
				{
					return m;
				}
			}
		}
		return null;
	}
	
	public ArrayList<EMFMetamodelDriver> getMetaModelsWithAlias(String alias)
	{
		return aliasLookUp.get(alias);
	}

}
