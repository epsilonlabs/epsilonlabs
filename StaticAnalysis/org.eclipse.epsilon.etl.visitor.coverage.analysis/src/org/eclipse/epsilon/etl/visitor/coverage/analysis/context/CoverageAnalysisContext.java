package org.eclipse.epsilon.etl.visitor.coverage.analysis.context;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.etl.metamodel.TransformationRule;

public class CoverageAnalysisContext {

	protected EolElement currentElement;
	protected CoverageAnalysisRepo coverageAnalysisRepo = new CoverageAnalysisRepo();
	protected HashMap<EPackage, ArrayList<EClass>> packageUsageRegistry = new HashMap<EPackage, ArrayList<EClass>>();
	
	public CoverageAnalysisRepo getCoverageAnalysisRepo() {
		return coverageAnalysisRepo;
	}
	
	public void setCurrentElement(EolElement currentElement) {
		this.currentElement = currentElement;
	}
	
	public EolElement getCurrentElement() {
		return currentElement;
	}
	
	public void add(EClass eClass)
	{
		coverageAnalysisRepo.add(eClass, currentElement);
		putEClassInPackageUsageRegistry(eClass);
		
	}
	
	public void add(EClass eClass, String propertyName, boolean featureAccessViaOpposite)
	{
		coverageAnalysisRepo.add(eClass, propertyName, currentElement, featureAccessViaOpposite);
		putEClassInPackageUsageRegistry(eClass);
	}
	
	public void putEClassInPackageUsageRegistry(EClass eClass)
	{
		EPackage ePackage = eClass.getEPackage();
		if (packageUsageRegistry.containsKey(ePackage)) {
			ArrayList<EClass> classes = packageUsageRegistry.get(ePackage);
			if (!classes.contains(eClass)) {
				classes.add(eClass);	
			}
		}
		else {
			ArrayList<EClass> classes = new ArrayList<EClass>();
			classes.add(eClass);
			packageUsageRegistry.put(ePackage, classes);
		}
	}
	
	public ArrayList<EClass> getUnusedClasses()
	{
		ArrayList<EClass> result = new ArrayList<EClass>();
		for(EPackage ePackage: packageUsageRegistry.keySet())
		{
			ArrayList<EClass> value = packageUsageRegistry.get(ePackage);
			for(EClassifier eClass: ePackage.getEClassifiers())
			{
				if (eClass instanceof EClass && !value.contains(eClass)) {
					result.add((EClass) eClass);
				}
			}
		}
		return result;
	}
	
	public ArrayList<EClass> getUnusedClasses(EPackage ePackage)
	{
		ArrayList<EClass> result = new ArrayList<EClass>();
		ArrayList<EClass> value = packageUsageRegistry.get(ePackage);
		for(EClassifier eClass: ePackage.getEClassifiers())
		{
			if (eClass instanceof EClass && !value.contains(eClass)) {
				result.add((EClass) eClass);
			}
		}
		return result;
	}
	
	public ArrayList<MetaElementContainer> getglobalContainers()
	{
		return coverageAnalysisRepo.getGlobalContainers();
	}
	
	public ArrayList<TransformationContainer> getTransformationContainers()
	{
		return coverageAnalysisRepo.getTransformationContainers();
	}
	
	public ArrayList<MetaElementContainer> getCoverageForTransformation(TransformationRule transformationRule)
	{
		ArrayList<MetaElementContainer> result = new ArrayList<MetaElementContainer>();
		for(TransformationContainer tc: getTransformationContainers())
		{
			if (tc.getTransformationRule().equals(transformationRule)) {
				MetaElementContainer sourceContainer = tc.getSourceContainer();
				MetaElementContainer container = getContainerForMetaElement(sourceContainer.getEClass(), result);
				if (container != null) {
				}
				else {
					container = new MetaElementContainer(sourceContainer.getEClass());
					result.add(container);
				}
				for(EStructuralFeature esf: sourceContainer.getAllFeatures())
				{
					container.add(esf.getName(), false);
				}
				for(EReference ref: sourceContainer.getFeaturesAccessedViaOpposite())
				{
					container.add(ref.getName(), true);
				}
				
				for(MetaElementContainer targetContainer : tc.getTargetcontainers())
				{
					MetaElementContainer tempContainer = getContainerForMetaElement(targetContainer.getEClass(), result);
					if (tempContainer != null) {
						
					}
					else {
						tempContainer = new MetaElementContainer(targetContainer.getEClass());
						result.add(tempContainer);
					}
					for(EStructuralFeature esf: targetContainer.getAllFeatures())
					{
						tempContainer.add(esf.getName(), false);
					}
					for(EReference ref: targetContainer.getFeaturesAccessedViaOpposite())
					{
						container.add(ref.getName(), true);
					}
				}
				
				for(MetaElementContainer otherContainer : tc.getOtherContinaers())
				{
					MetaElementContainer tempContainer = getContainerForMetaElement(otherContainer.getEClass(), result);
					if (tempContainer != null) {
						
					}
					else {
						tempContainer = new MetaElementContainer(otherContainer.getEClass());
						result.add(tempContainer);
					}
					for(EStructuralFeature esf: otherContainer.getAllFeatures())
					{
						tempContainer.add(esf.getName(), false);
					}
					for(EReference ref: otherContainer.getFeaturesAccessedViaOpposite())
					{
						container.add(ref.getName(), true);
					}
				}
			}
		}
		return result;
	}
	
	public ArrayList<MetaElementContainer> getCoverageForGlobal()
	{
		ArrayList<MetaElementContainer> result = new ArrayList<MetaElementContainer>();
		
		for(MetaElementContainer mec: getglobalContainers())
		{
			MetaElementContainer container = getContainerForMetaElement(mec.getEClass(), result);
			if (container != null) {
			}
			else {
				container = new MetaElementContainer(mec.getEClass());
				result.add(container);
			}
			for(EStructuralFeature esf: mec.getAllFeatures())
			{
				container.add(esf.getName(), false);
			}
			for(EReference ref: mec.getFeaturesAccessedViaOpposite())
			{
				container.add(ref.getName(), true);
			}
		}
		for(TransformationContainer tc: getTransformationContainers())
		{
			MetaElementContainer sourceContainer = tc.getSourceContainer();
			MetaElementContainer container = getContainerForMetaElement(sourceContainer.getEClass(), result);
			if (container != null) {
			}
			else {
				container = new MetaElementContainer(sourceContainer.getEClass());
				result.add(container);
			}
			for(EStructuralFeature esf: sourceContainer.getAllFeatures())
			{
				container.add(esf.getName(), false);
			}
			for(EReference ref: sourceContainer.getFeaturesAccessedViaOpposite())
			{
				container.add(ref.getName(), true);
			}
			
			for(MetaElementContainer targetContainer : tc.getTargetcontainers())
			{
				MetaElementContainer tempContainer = getContainerForMetaElement(targetContainer.getEClass(), result);
				if (tempContainer != null) {
					
				}
				else {
					tempContainer = new MetaElementContainer(targetContainer.getEClass());
					result.add(tempContainer);
				}
				for(EStructuralFeature esf: targetContainer.getAllFeatures())
				{
					tempContainer.add(esf.getName(), false);
				}
				for(EReference ref: targetContainer.getFeaturesAccessedViaOpposite())
				{
					container.add(ref.getName(), true);
				}
			}
			
			for(MetaElementContainer otherContainer : tc.getOtherContinaers())
			{
				MetaElementContainer tempContainer = getContainerForMetaElement(otherContainer.getEClass(), result);
				if (tempContainer != null) {
					
				}
				else {
					tempContainer = new MetaElementContainer(otherContainer.getEClass());
					result.add(tempContainer);
				}
				for(EStructuralFeature esf: otherContainer.getAllFeatures())
				{
					tempContainer.add(esf.getName(), false);
				}
				for(EReference ref: otherContainer.getFeaturesAccessedViaOpposite())
				{
					container.add(ref.getName(), true);
				}
			}
		}
		return result;
	}
	
	public MetaElementContainer getContainerForMetaElement(EClass eClass, ArrayList<MetaElementContainer> containers)
	{
		for(MetaElementContainer mec: containers)
		{
			if (mec.getEClass().equals(eClass)) {
				return mec;
			}
		}
		return null;
	}
	
	
	public void clear()
	{
		this.coverageAnalysisRepo = new CoverageAnalysisRepo();
		this.currentElement = null;
		this.packageUsageRegistry.clear();
	}
//	public String toString()
//	{
//		String result = "global: \n";
//		for(MetaElementContainer mec: getglobalContainers())
//		{
//			result += mec.getEClass().getName() + " \n";
//			result += "attributes: \n";
//			for(EAttribute attribute: mec.getAttributes())
//			{
//				result += attribute.getName() + "\n";
//			}
//			result += "references: \n";
//			for(EReference reference: mec.getReferences())
//			{
//				result += reference.getName() + "\n";
//			}
//		}
//		result += "Transformations: \n";
//		for(TransformationContainer tc: getTransformationContainers())
//		{
//			result += tc.getTransformationRule().getName().getName() + ": \n";
//			MetaElementContainer sourceContainer = tc.getSourceContainer();
//			result += "source: \n";
//			result += sourceContainer.getEClass().getName() + "\n";
//			result += "attributes: \n";
//			for(EAttribute attribute: sourceContainer.getAttributes())
//			{
//				result += attribute.getName() + "\n";
//			}
//			result += "references: \n";
//			for(EReference reference: sourceContainer.getReferences())
//			{
//				result += reference.getName() + "\n";
//			}
//			for(MetaElementContainer targetContainer: tc.getTargetcontainers())
//			{
//				result += "target: \n";
//				result += targetContainer.getEClass().getName() + "\n";
//				result += "attributes: \n";
//				for(EAttribute attribute: targetContainer.getAttributes())
//				{
//					result += attribute.getName() + "\n";
//				}
//				result += "references: \n";
//				for(EReference reference: targetContainer.getReferences())
//				{
//					result += reference.getName() + "\n";
//				}
//			}
//			for(MetaElementContainer otherContainer: tc.getOtherContinaers())
//			{
//				result += "target: \n";
//				result += otherContainer.getEClass().getName() + "\n";
//				result += "attributes: \n";
//				for(EAttribute attribute: otherContainer.getAttributes())
//				{
//					result += attribute.getName() + "\n";
//				}
//				result += "references: \n";
//				for(EReference reference: otherContainer.getReferences())
//				{
//					result += reference.getName() + "\n";
//				}
//			}
//		}
//		return result;
//	}
	
	
}
