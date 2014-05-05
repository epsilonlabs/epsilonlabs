package org.eclipse.epsilon.eol.performance.analysis.context;

import java.util.ArrayList;
import java.util.HashMap;

import metamodel.connectivity.emf.EMetaModel;

public class MetamodelContainer {

	//array that contains the metamodels
	ArrayList<EMetaModel> metaModels = new ArrayList<EMetaModel>();
	
	//map that looks up an array of metamodels with a given alias
	HashMap<String, ArrayList<EMetaModel>> aliasLookUp = new HashMap<String, ArrayList<EMetaModel>>();
	
	//metamodel name space
	ArrayList<String> metaModelNameSpace = new ArrayList<String>();
	
	
	public static void main(String[] args) {
		MetamodelContainer container = new MetamodelContainer();
		EMetaModel mm1 = new EMetaModel();
		mm1.setName("name1");
		mm1.addAlias("a");
		mm1.addAlias("b");
		
		EMetaModel mm2 = new EMetaModel();
		mm2.setName("name2");
		mm2.addAlias("c");
		mm2.addAlias("d");
		mm2.addAlias("a");
		
		EMetaModel mm3 = new EMetaModel();
		mm3.setName("name1");
		
		container.inputMetaModel(mm1);
		container.inputMetaModel(mm2);
		container.inputMetaModel(mm3);
		
		System.out.println(container.getMetaModelsWithAlias("a").size());
		System.out.println(container.getMetaModelsWithAlias("b").size());
	}
	
	public ArrayList<EMetaModel> getMetaModels()
	{
		return metaModels;
	}
	
	public void inputMetaModel(EMetaModel metaModel)
	{
		metaModels.add(metaModel);
		try {
			addToMetaModelNameSpace(metaModel.getMetaModelName());
			addToMetaModelNameSpace(metaModel.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(String s: metaModel.getAliases())
		{
			if (aliasLookUp.containsKey(s)) {
				aliasLookUp.get(s).add(metaModel);
			}
			else {
				ArrayList<EMetaModel> metamodels = new ArrayList<EMetaModel>();
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
	
	public EMetaModel getMetaModel(String name)
	{
		if (metaModelNameSpace.contains(name)) {
			for(EMetaModel m: metaModels)
			{
				if (m.getMetaModelName().equals(name)) {
					return m;
				}
				else if(m.getName().equals(name))
				{
					return m;
				}
			}
		}
		return null;
	}
	
	public ArrayList<EMetaModel> getMetaModelsWithAlias(String alias)
	{
		return aliasLookUp.get(alias);
	}

}
