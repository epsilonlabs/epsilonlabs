package org.eclipse.epsilon.etl.dtx.transformation.dependency;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public class CoverageUnit {

	protected EClass eClass;
	protected EStructuralFeature eStructuralFeature;
	
	protected boolean used;
	
	public CoverageUnit(EClass eClass, EStructuralFeature eStructuralFeature, boolean used)
	{
		this.eClass = eClass;
		this.eStructuralFeature = eStructuralFeature;
		this.used = used;
	}
	
	public String getMetaModel()
	{
		return eClass.getEPackage().getName();
	}
	
	public String getMetaElement()
	{
		return eClass.getName();
	}
	
	public String getProperty()
	{
		return eStructuralFeature.getName();
	}
	
	public String getPropertyType()
	{
		if (eStructuralFeature instanceof EAttribute) {
			return "attribute";
		}
		else if (eStructuralFeature instanceof EReference) {
			return "reference";
		}
		return null;
	}
	
	public String getUsed()
	{
		if (used) {
			return "true";
		}
		else {
			return "false";
		}
	}
}
