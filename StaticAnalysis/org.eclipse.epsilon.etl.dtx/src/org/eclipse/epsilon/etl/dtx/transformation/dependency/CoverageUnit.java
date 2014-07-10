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
		if (eClass != null) {
			return eClass.getEPackage().getName();	
		}
		else {
			return "";
		}
		
	}
	
	public String getMetaElement()
	{
		if (eClass != null) {
			return eClass.getName();	
		}
		else {
			return "";
		}
		
	}
	
	public String getProperty()
	{
		if (eStructuralFeature != null) {
			return eStructuralFeature.getName();	
		}
		else {
			return "";
		}
		
	}
	
	public String getPropertyType()
	{
		if (eStructuralFeature != null) {
			if (eStructuralFeature instanceof EAttribute) {
				return "attribute";
			}
			else if (eStructuralFeature instanceof EReference) {
				return "reference";
			}	
		}
		else {
			return "";
		}
		return "";
	}
	
	public String getUsed()
	{
		if (eClass != null) {
			if (used) {
				return "true";
			}
			else {
				return "false";
			}	
		}
		else {
			return "";
		}
	}
}
