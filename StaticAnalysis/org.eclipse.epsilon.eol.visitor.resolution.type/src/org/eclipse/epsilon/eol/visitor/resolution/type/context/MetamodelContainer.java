package org.eclipse.epsilon.eol.visitor.resolution.type.context;

import java.util.ArrayList;
import java.util.HashMap;

import metamodel.connectivity.abstractmodel.EMetamodelDriver;
import metamodel.connectivity.emf.EMFMetamodelDriver;

public class MetamodelContainer {

	//array that contains the metamodels
	ArrayList<EMetamodelDriver> metaModels = new ArrayList<EMetamodelDriver>();
	
	//map that looks up an array of metamodels with a given alias
	HashMap<String, ArrayList<EMetamodelDriver>> aliasLookUp = new HashMap<String, ArrayList<EMetamodelDriver>>();
	
	//metamodel name space
	ArrayList<String> metaModelNameSpace = new ArrayList<String>();
	
	TypeResolutionContext context;
	
	public MetamodelContainer(TypeResolutionContext context)
	{
		this.context = context;
	}
	
	
	public static void main(String[] args) {
		MetamodelContainer container = new MetamodelContainer(new TypeResolutionContext());
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
	
	public ArrayList<EMetamodelDriver> getMetaModels()
	{
		return metaModels;
	}
	
	public void inputMetaModel(EMetamodelDriver metaModel)
	{
		metaModels.add(metaModel);
		addToMetaModelNameSpace(metaModel.getMetamodelName());

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
	}
		
	public void addToMetaModelNameSpace(String s)
	{
		if (!metaModelNameSpace.contains(s)) {
			metaModelNameSpace.add(s);
		}
		else {
			System.err.println("Metamodel Identifier: " + s + " already exists");
			//throw new Exception("Metamodel Identifier: " + s + " already exists");
		}
	}
	
	public EMetamodelDriver getMetaModel(String name)
	{
		if (metaModelNameSpace.contains(name)) {
			for(EMetamodelDriver m: metaModels)
			{
				if (m.getMetamodelName().equals(name)) {
					return m;
				}
			}
		}
		return null;
	}
	
	public EMetamodelDriver getMetaModelWithURI(String nsURI)
	{
		for(EMetamodelDriver m: metaModels)
		{
			if (m.getMetamodelNsURI().equals(nsURI)) {
				return m;
			}
		}
		return null;
	}
	
	public ArrayList<EMetamodelDriver> getMetaModelsWithAlias(String alias)
	{
		return aliasLookUp.get(alias);
	}

}
