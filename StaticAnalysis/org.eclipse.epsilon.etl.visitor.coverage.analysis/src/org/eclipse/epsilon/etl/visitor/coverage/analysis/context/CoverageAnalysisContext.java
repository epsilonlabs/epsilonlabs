package org.eclipse.epsilon.etl.visitor.coverage.analysis.context;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
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
}
