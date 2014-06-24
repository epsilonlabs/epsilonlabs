package metamodel.connectivity.abstractmodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public interface EMetamodelDriver {

	public abstract void loadModel(String modelString) throws Exception; 
	
	public abstract String getMetamodelName();
	public abstract String getMetamodelNsURI();
	public abstract String getMetamodelNsPrefix();
	
	public abstract boolean containsMetaClass(String className);
	public abstract EClass getMetaClass(String className);
	
	public abstract boolean containsEnum(String enumName);
	public abstract EEnum getEnum(String enumName);
	
	public abstract boolean containsEnumLiteral(String enumName, String literalName);
	
	public abstract boolean containsEAttribute(String className, String attributeName);
	public abstract boolean containsEReference(String className, String referenceName);
	public abstract boolean contains(String className, String propertyName);
	
	public abstract EAttribute getEAttribute(String className, String attributeName);
	public abstract EReference getEReference(String className, String referenceName);
	public abstract EStructuralFeature getEStructuralFeature(String className, String featureName);
	
	public abstract EAttribute getEAttribute(EClass metaClass, String attributeName);
	public abstract EReference getEReference(EClass metaClass, String referenceName);
	public abstract EStructuralFeature getEStructuralFeature(EClass metaClass, String featureName);
			
	public abstract EClassifier getTypeForEAttribute(EClass eClass, String attributeName);
	public abstract EClassifier getTypeForEReference(EClass eClass, String referenceName);
	public abstract EClassifier getTypeForEStructuralFeature(EClass eClass, String propertyName);
	
	public abstract EClassifier getTypeForEAttribute(String className, String attributeName);
	public abstract EClassifier getTypeForEReference(String className, String referenceName);
	public abstract EClassifier getTypeForEStructuralFeature(String className, String propertyName);

}
