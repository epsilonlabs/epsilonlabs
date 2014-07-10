package org.eclipse.epsilon.etl.visitor.coverage.analysis.context;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.etl.metamodel.TransformationRule;

public class CoverageAnalysisContext {

	protected EolElement currentElement;
	protected CoverageAnalysisRepo coverageAnalysisRepo = new CoverageAnalysisRepo();
	
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
	}
	
	public void add(EClass eClass, String propertyName)
	{
		coverageAnalysisRepo.add(eClass, propertyName, currentElement);
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
					container.add(esf.getName());
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
						tempContainer.add(esf.getName());
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
						tempContainer.add(esf.getName());
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
				container.add(esf.getName());
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
				container.add(esf.getName());
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
					tempContainer.add(esf.getName());
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
					tempContainer.add(esf.getName());
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
	
	public String toString()
	{
		String result = "global: \n";
		for(MetaElementContainer mec: getglobalContainers())
		{
			result += mec.getEClass().getName() + " \n";
			result += "attributes: \n";
			for(EAttribute attribute: mec.getAttributes())
			{
				result += attribute.getName() + "\n";
			}
			result += "references: \n";
			for(EReference reference: mec.getReferences())
			{
				result += reference.getName() + "\n";
			}
		}
		result += "Transformations: \n";
		for(TransformationContainer tc: getTransformationContainers())
		{
			result += tc.getTransformationRule().getName().getName() + ": \n";
			MetaElementContainer sourceContainer = tc.getSourceContainer();
			result += "source: \n";
			result += sourceContainer.getEClass().getName() + "\n";
			result += "attributes: \n";
			for(EAttribute attribute: sourceContainer.getAttributes())
			{
				result += attribute.getName() + "\n";
			}
			result += "references: \n";
			for(EReference reference: sourceContainer.getReferences())
			{
				result += reference.getName() + "\n";
			}
			for(MetaElementContainer targetContainer: tc.getTargetcontainers())
			{
				result += "target: \n";
				result += targetContainer.getEClass().getName() + "\n";
				result += "attributes: \n";
				for(EAttribute attribute: targetContainer.getAttributes())
				{
					result += attribute.getName() + "\n";
				}
				result += "references: \n";
				for(EReference reference: targetContainer.getReferences())
				{
					result += reference.getName() + "\n";
				}
			}
			for(MetaElementContainer otherContainer: tc.getOtherContinaers())
			{
				result += "target: \n";
				result += otherContainer.getEClass().getName() + "\n";
				result += "attributes: \n";
				for(EAttribute attribute: otherContainer.getAttributes())
				{
					result += attribute.getName() + "\n";
				}
				result += "references: \n";
				for(EReference reference: otherContainer.getReferences())
				{
					result += reference.getName() + "\n";
				}
			}
		}
		return result;
	}
	
	
}
