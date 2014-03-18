package org.eclipse.epsilon.eol.dom.metamodel.coverage.context;

import org.eclipse.emf.ecore.EClassifier;

public class MetaClassContainer {

	private EClassifier classifier;
	private int count;
	
	public MetaClassContainer(EClassifier classifier)
	{
		this.classifier = classifier;
		count = 0;
	}
	
	public void increase()
	{
		count++;
	}
	
	public int getCount() {
		return count;
	}
	
	public EClassifier getClassifier() {
		return classifier;
	}
	
	public void setClassifier(EClassifier classifier) {
		this.classifier = classifier;
	}
	

}
