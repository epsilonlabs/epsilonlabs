package org.eclipse.epsilon.eol.visitor.resolution.type.context;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.epsilon.eol.parse.Eol_EolParserRules.returnStatement_return;

import metamodel.connectivity.abstractmodel.EMetamodelDriver;
import metamodel.connectivity.emf.EMFMetamodelDriver;

public class MetamodelContainer {

	//array that contains the metamodels
	ArrayList<EMetamodelDriver> metaModels = new ArrayList<EMetamodelDriver>();
	
	//map that looks up an array of metamodels with a given alias
	HashMap<String, ArrayList<EMetamodelDriver>> aliasLookUp = new HashMap<String, ArrayList<EMetamodelDriver>>();
	
	//metamodel name space
	ArrayList<String> metaModelNameSpace = new ArrayList<String>();
	
	public static void main(String[] args) {
//		MetamodelContainer container = new MetamodelContainer();
//		
//		EMFMetamodelDriver mm1 = new EMFMetamodelDriver();
//		mm1.setName("name1");
//		mm1.addAlias("a");
//		mm1.addAlias("b");
//		
//		EMFMetamodelDriver mm2 = new EMFMetamodelDriver();
//		mm2.setName("name2");
//		mm2.addAlias("c");
//		mm2.addAlias("d");
//		mm2.addAlias("a");
//		
//		EMFMetamodelDriver mm3 = new EMFMetamodelDriver();
//		mm3.setName("name1");
//		
//		container.inputMetaModel(mm1);
//		container.inputMetaModel(mm2);
//		container.inputMetaModel(mm3);
//		
//		System.out.println(container.getMetaModelsWithAlias("a").size());
//		System.out.println(container.getMetaModelsWithAlias("b").size());
	}
	
	public ArrayList<EMetamodelDriver> getMetaModels()
	{
		return metaModels;
	}
	
	public String inputMetaModel(EMetamodelDriver metaModel)
	{
		String result = "";
		//add the metamodel in the metamodel arraylist
		metaModels.add(metaModel);
		
		//add the name of the metamodel into the namespace
		result = addToMetaModelNameSpace(metaModel.getName());
		if (!result.equals("")) {
			return result;
		} 
		//addToMetaModelNameSpace(metaModel.getMetamodelName());

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
		
	public String addToMetaModelNameSpace(String s)
	{
		String result = "";
		if (!metaModelNameSpace.contains(s)) {
			metaModelNameSpace.add(s);
		}
		else {
			result = "Metamodel Identifier: " + s + " already exists";
			//System.err.println("Metamodel Identifier: " + s + " already exists");
		}
		return result;
	}
	
	public EMetamodelDriver getMetaModel(String name)
	{
		if (metaModelNameSpace.contains(name)) {
			for(EMetamodelDriver m: metaModels)
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
		for(EMetamodelDriver m: metaModels)
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
