package org.eclipse.epsilon.eol.dom.metamodel.coverage.context;

import java.util.ArrayList;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class CoverageAnalysisRepo {

	private ArrayList<MetaModelContainer> metaModelContainers;
	
	public CoverageAnalysisRepo()
	{
		metaModelContainers = new ArrayList<MetaModelContainer>();
	}
	
	public void insertEPackage(EPackage ePackage)
	{
		metaModelContainers.add(new MetaModelContainer(ePackage));
	}
	
	public void add(EClassifier classifier)
	{
		addOne(classifier);
		if (classifier instanceof EClass) {
			TreeIterator<EObject> iter = ((EClass)classifier).eAllContents();
			while(iter.hasNext())
			{
				EObject obj = iter.next();
				if (obj instanceof EClass) {
					if (((EClass) classifier).isSuperTypeOf((EClass) obj)) {
						addOne((EClassifier) obj);
					}
				}
			}
		}
	}
	
	public void addOne(EClassifier classifier)
	{
		boolean added = false;
		for(MetaModelContainer mmc: metaModelContainers)
		{
			if (mmc.getePackage().equals(classifier.getEPackage())) {
				mmc.add(classifier);
				added = true;
				break;
			}
		}
		if (!added) {
			insertEPackage(classifier.getEPackage());
			add(classifier);
		}
	}
	
	public ArrayList<MetaClassContainer> getCoverageForEPackage(EPackage ep)
	{
		for(MetaModelContainer mmc: metaModelContainers)
		{
			if(mmc.getePackage().equals(ep))
			{
				return mmc.getMetaClassContainers();
			}
		}
		return null;
	}
	
	public String toString()
	{
		String result = "";
		for(MetaModelContainer mmc: metaModelContainers)
		{
			result += "model name: " + mmc.getName() + ", nsURI: " + mmc.getNSURI() + "\n";
			for(MetaClassContainer mcc: mmc.getMetaClassContainers())
			{
				result += "meta class: " + mcc.getClassifier() + ", coverage: " + mcc.getCount() + "\n";
			}
			result += "===================================\n";
		}
		return result;
	}
}
