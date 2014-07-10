package org.eclipse.epsilon.etl.visitor.coverage.analysis.context;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.etl.metamodel.EtlProgram;
import org.eclipse.epsilon.etl.metamodel.TransformationRule;

public class CoverageAnalysisRepo {

	protected ArrayList<MetaElementContainer> globalContainers;
	protected ArrayList<TransformationContainer> transformationContainers;
	
	public CoverageAnalysisRepo()
	{
		globalContainers = new ArrayList<MetaElementContainer>();
		transformationContainers = new ArrayList<TransformationContainer>();
	}
	
	public ArrayList<MetaElementContainer> getGlobalContainers() {
		return globalContainers;
	}
	
	public ArrayList<TransformationContainer> getTransformationContainers() {
		return transformationContainers;
	}
	
	public void addToGlobalContainer(MetaElementContainer container)
	{
		globalContainers.add(container);
	}
	
	public void addToTransformationContainers(TransformationRule rule)
	{
		boolean defined = false;
		for(TransformationContainer tc: transformationContainers)
		{
			if (tc.getTransformationRule().equals(rule)) {
				defined = true;
			}
		}
		
		if (!defined) {
			transformationContainers.add(new TransformationContainer(rule));
		}
	}
	
	public void add(EClass eClass, EolElement currentElement)
	{
		
		if (currentElement instanceof EtlProgram) {
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
			for(TransformationContainer tc: transformationContainers)
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
				TransformationContainer tc = new TransformationContainer((TransformationRule) currentElement);
				
				transformationContainers.add(tc);
			}
		}
	}
	
	public void add(EClass eClass, String propertyName, EolElement currentElement)
	{
		if (currentElement instanceof EtlProgram) {
			boolean exist = false;
			for(MetaElementContainer container: globalContainers)
			{
				if (container.getEClass().equals(eClass)) {
					exist = true;
					container.add(propertyName);
				}
			}
			if (!exist) {
				MetaElementContainer container = new MetaElementContainer(eClass);
				container.add(propertyName);
				globalContainers.add(container);
			}
		}
		else if(currentElement instanceof TransformationRule)
		{
//			boolean exist = false;
			for(TransformationContainer tc: transformationContainers)
			{
				if (tc.getTransformationRule().equals(currentElement)) {
					tc.add(eClass, propertyName);
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
