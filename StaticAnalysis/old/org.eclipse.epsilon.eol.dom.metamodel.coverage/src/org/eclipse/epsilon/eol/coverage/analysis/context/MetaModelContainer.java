package org.eclipse.epsilon.eol.coverage.analysis.context;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class MetaModelContainer {

	private EPackage ePackage;
	private ArrayList<MetaClassContainer> metaClassContainers;
	
	public MetaModelContainer(EPackage ePackage)
	{
		this.ePackage = ePackage;
		metaClassContainers = new ArrayList<MetaClassContainer>();
		for(EClassifier classifier: ePackage.getEClassifiers())
		{
			add(classifier);
		}
	}
	
	public EPackage getePackage() {
		return ePackage;
	}
	
	public String getNSURI()
	{
		return ePackage.getNsURI();
	}
	
	public String getName() {
		return ePackage.getName();
	}
	
	public ArrayList<MetaClassContainer> getMetaClassContainers() {
		return metaClassContainers;
	}
	
	public boolean add(EClassifier classifier)
	{
		boolean result = false;
		
		MetaClassContainer container = getMetaClassContainer(classifier);
		if (container != null) {
			container.increase();
			result = true;
		}
		else {
			metaClassContainers.add(new MetaClassContainer(classifier));
			result = true;
		}
		return result;
	}
	
	public MetaClassContainer getMetaClassContainer(EClassifier classifier)
	{
		MetaClassContainer container = null;
		for(MetaClassContainer mcc: metaClassContainers)
		{
			if (mcc.getClassifier().equals(classifier)) {
				container = mcc;
				break;
			}
		}
		return container;
	}
	
	public int getNumberOfMetaClassUsed()
	{
		int result = 0;
		for(MetaClassContainer mcc: metaClassContainers)
		{
			if (mcc.getCount()>0) {
				result++;
			}
		}
		return result;
	}
	
	public int getNumberOfMetaClasses()
	{
		return metaClassContainers.size();
	}
	
	public float getUsageRatio()
	{
		return (float)getNumberOfMetaClassUsed()/(float)getNumberOfMetaClasses();
	}
}
