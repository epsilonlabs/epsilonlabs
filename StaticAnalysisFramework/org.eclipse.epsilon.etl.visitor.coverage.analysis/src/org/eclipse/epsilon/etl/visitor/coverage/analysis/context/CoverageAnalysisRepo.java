package org.eclipse.epsilon.etl.visitor.coverage.analysis.context;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.epsilon.eol.metamodel.EOLElement;
import org.eclipse.epsilon.etl.metamodel.ETLModule;
import org.eclipse.epsilon.etl.metamodel.TransformationRule;

public class CoverageAnalysisRepo {

	protected ArrayList<MetaElementContainer> globalContainers;
	protected ArrayList<TransformationRuleContainer> transformationContainers;
	
	public CoverageAnalysisRepo()
	{
		globalContainers = new ArrayList<MetaElementContainer>();
		transformationContainers = new ArrayList<TransformationRuleContainer>();
	}
	
	public ArrayList<MetaElementContainer> getGlobalContainers() {
		return globalContainers;
	}
	
	public ArrayList<TransformationRuleContainer> getTransformationContainers() {
		return transformationContainers;
	}
	
	public void addToGlobalContainer(MetaElementContainer container)
	{
		globalContainers.add(container);
	}
	
	public void addToTransformationContainers(TransformationRule rule)
	{
		boolean defined = false;
		for(TransformationRuleContainer tc: transformationContainers)
		{
			if (tc.getTransformationRule().equals(rule)) {
				defined = true;
			}
		}
		
		if (!defined) {
			transformationContainers.add(new TransformationRuleContainer(rule));
		}
	}
	
	public void add(EClass eClass, EOLElement currentElement)
	{
		
		if (currentElement instanceof ETLModule) {
			boolean exist = false;
			for(MetaElementContainer container: globalContainers)
			{
				if (container.getEClass().equals(eClass)) {
					exist = true;
				}
			}
			if (!exist) {
				globalContainers.add(new MetaElementContainer(eClass));
			}
		}
		else if(currentElement instanceof TransformationRule)
		{
			boolean exist = false;
			for(TransformationRuleContainer tc: transformationContainers)
			{
				boolean innerExist = false;
				if (tc.getTransformationRule().equals(currentElement)) {
					exist = true;
					for(MetaElementContainer container: tc.getOtherContinaers())
					{
						if (container.getEClass().equals(eClass)) {
							innerExist = true;
						}
					}
					if (!innerExist) {
						tc.getOtherContinaers().add(new MetaElementContainer(eClass));
					}
				}
			}
			if (!exist) {
				TransformationRuleContainer tc = new TransformationRuleContainer((TransformationRule) currentElement);
				
				transformationContainers.add(tc);
			}
		}
	}
	
	public ArrayList<EClass> getSuperClassContainingProperty(EClass eClass, String propertyName)
	{
		ArrayList<EClass> result = new ArrayList<EClass>();
		for(EClass superClass: eClass.getESuperTypes())
		{
			for(EStructuralFeature feature: superClass.getEAllStructuralFeatures())
			{
				if (feature.getName().equals(propertyName)) {
					result.add(superClass);
					break;
				}
			}
		}
		return result;
	}
	
	public void add(EClass eClass, String propertyName, EOLElement currentElement, boolean featureAccessViaOpposite)
	{
		if (currentElement instanceof ETLModule) {
			boolean exist = false;
			for(MetaElementContainer container: globalContainers)
			{
				if (container.getEClass().equals(eClass)) {
					exist = true;
					container.add(propertyName, featureAccessViaOpposite);
				}
			}
			if (!exist) {
				MetaElementContainer container = new MetaElementContainer(eClass);
				container.add(propertyName, featureAccessViaOpposite);
				globalContainers.add(container);
			}
		}
		else if(currentElement instanceof TransformationRule)
		{
//			boolean exist = false;
			for(TransformationRuleContainer tc: transformationContainers)
			{
				if (tc.getTransformationRule().equals(currentElement)) {
					tc.add(eClass, propertyName, featureAccessViaOpposite);
				}
//				boolean innerExist = false;
//				if (tc.getTransformationRule().equals(currentElement)) {
//					exist = true;
//					for(MetaElementContainer container: tc.getOtherContinaers())
//					{
//						if (container.getClassifier().equals(eClass)) {
//							innerExist = true;
//							container.add(propertyName);
//						}
//					}
//					if (!innerExist) {
//						MetaElementContainer container = new MetaElementContainer(eClass);
//						container.add(propertyName);
//						tc.getOtherContinaers().add(container);
//					}
//				}
			}
//			if (!exist) {
//				TransformationContainer tc = new TransformationContainer((TransformationRule) currentElement);
//				
//			}
		}

	}
	
}
