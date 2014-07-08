package org.eclipse.epsilon.etl.visitor.coverage.analysis.context;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.epsilon.eol.metamodel.EolElement;

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
	
	public String toString()
	{
		String result = "global: \n";
		for(MetaElementContainer mec: getglobalContainers())
		{
			result += mec.getClassifier().getName() + " \n";
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
			result += sourceContainer.getClassifier().getName() + "\n";
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
				result += targetContainer.getClassifier().getName() + "\n";
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
				result += otherContainer.getClassifier().getName() + "\n";
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
