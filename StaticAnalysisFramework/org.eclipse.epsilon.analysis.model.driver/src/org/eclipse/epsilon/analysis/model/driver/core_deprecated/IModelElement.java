package org.eclipse.epsilon.analysis.model.driver.core_deprecated;

import java.util.ArrayList;
import java.util.List;

public abstract class IModelElement {

	protected List<IAnnotation> iAnnotations = new ArrayList<IAnnotation>();
	
	public List<IAnnotation> getiAnnotations() {
		return iAnnotations;
	}
	
	public void addIAnnotation(IAnnotation iAnnotation)
	{
		iAnnotations.add(iAnnotation);
	}
	
}
