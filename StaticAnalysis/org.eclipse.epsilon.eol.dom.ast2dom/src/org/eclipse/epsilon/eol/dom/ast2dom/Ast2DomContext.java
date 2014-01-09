package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.eol.dom.EolFactory;
import org.eclipse.epsilon.eol.dom.impl.EolFactoryImpl;

public class Ast2DomContext {

	EolElementCreatorFactory eolElementCreatorFactory;
	EolFactory eolFactory;
	//LinkedList<MetaModel> metaModels;
	
	public Ast2DomContext()
	{
		eolElementCreatorFactory = new EolElementCreatorFactory();
		eolFactory = new EolFactoryImpl();
		//metaModels = new LinkedList<MetaModel>();
	}
	
	public Ast2DomContext(EolElementCreatorFactory eolElementCreatorFactory)
	{
		this.eolElementCreatorFactory = eolElementCreatorFactory;
		eolFactory = new EolFactoryImpl();
	}
	
	public EolFactory getEolFactory()
	{
		return eolFactory;
	}
	
	public EolElementCreatorFactory getEolElementCreatorFactory()
	{
		return eolElementCreatorFactory;
	}
	
	
	/*
	public LinkedList<MetaModel> getMetaModels()
	{
		return metaModels;
	}
	
	public MetaModel createMetaModel()
	{
		return new MetaModel();
	}
	
	public boolean containsModel(String metaModelName)
	{
		boolean result = false;
		for(MetaModel metamodel: metaModels)
		{
			if (metamodel.getMetaModelName().equals(metaModelName)) {
				result = true;
				break;
			}
		}
		return result;
	}
	
	public MetaModel getMetaModel(String metaModelName)
	{
		MetaModel result = null;
		for(MetaModel metaModel: metaModels)
		{
			if(metaModel.getMetaModelName().equals(metaModelName))
			{
				result = metaModel;
			}
		}
		return result;
	}
	
	public String resolveType(String metaModelName, String metaModelElement)
	{
		//System.err.println("R");
		String result = "";
		if(containsModel(metaModelName))
		{
			MetaModel mm = getMetaModel(metaModelName);
			result = mm.getTypeForMetaClass(metaModelElement);
		}
		else {
			result = "unfound";
		}
		return result;
	}
		*/
}
