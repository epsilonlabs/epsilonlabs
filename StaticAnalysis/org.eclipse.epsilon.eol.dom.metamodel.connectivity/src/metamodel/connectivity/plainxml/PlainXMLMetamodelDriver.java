package metamodel.connectivity.plainxml;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import metamodel.connectivity.abstractmodel.EMetamodelDriver;

public class PlainXMLMetamodelDriver implements EMetamodelDriver{

	protected String name;
	protected ArrayList<String> aliases;

	protected EPackage ePackage;
	protected EClass root;
	protected PlainXMLMetamodelDriverUtil util;

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<String> getAliases() {
		return aliases;
	}
	
	public void setAliases(ArrayList<String> aliases) {
		this.aliases = aliases;
	}
	
	public void addAlias(String alias)
	{
		aliases.add(alias);
	}
	
	public boolean containsAlias(String alias)
	{
		return aliases.contains(alias);
	}
	
	@Override
	public void loadModel(String modelString)  {
		this.ePackage = util.loadModel(modelString);
	}

	@Override
	public String getMetamodelName() {
		return ePackage.getName();
	}

	@Override
	public String getMetamodelNsURI() {
		return ePackage.getNsURI();
	}

	@Override
	public String getMetamodelNsPrefix() {
		return ePackage.getNsPrefix();
	}

	@Override
	public boolean containsMetaClass(String className) {
		if (className.startsWith("t_")) {
			return true;
		}
		return false;
	}

	@Override
	public EClass getMetaClass(String className) {
		if (className.equals("root")) {
			if (root != null) {
				return root;
			}
			else {
				return null;
			}
		}
		else if (className.startsWith("t_")) {
			String escapedName = util.removeTag(className);
			EClass result = (EClass) ePackage.getEClassifier(escapedName);
			if (result != null) {
				return result; 
			}
			else {
				result = util.getFactory().createEClass();
				result.setName(escapedName);
				result.getEAnnotations().add(util.createAnnotationForWarning("Type may not exist in the metamodel"));
				ePackage.getEClassifiers().add(result);
				return result;
			}
		}
		else {
			return null;
		}
	}

	@Override
	public boolean containsEnum(String enumName) {
		// TODO Auto-generated method stub
		//enum not supported yet
		return false;
	}

	@Override
	public EEnum getEnum(String enumName) {
		// TODO Auto-generated method stub
		// enum not supported yet
		return null;
	}

	@Override
	public boolean containsEnumLiteral(String enumName, String literalName) {
		// TODO Auto-generated method stub
		// enum not supported yet
		return false;
	}

	@Override
	public boolean containsEAttribute(String className, String attributeName) {
		if (className.startsWith("t_") || className.equals("root")) {
			if (util.isXMLSyntax(attributeName)) {
				if (attributeName.startsWith("e_") ||
						attributeName.startsWith("x_") ||
						attributeName.startsWith("c_") ||
						attributeName.startsWith("t_")) {
					return false;
				}
				else {
					return true;
				}

			}
			else {
				if (attributeName.equals("text") || attributeName.equals("tagname")) {
					return true;
				}
				else {
					return false;
				}
			}
		}
		else {
			return false;
		}

	}

	@Override
	public boolean containsEReference(String className, String referenceName) {
		if (className.startsWith("t_") || className.equals("root")) {
			if (util.isXMLSyntax(referenceName)) {
				if (referenceName.startsWith("e_") ||
						//referenceName.startsWith("x_") ||
						referenceName.startsWith("c_") ||
						referenceName.startsWith("t_")) {
					return true;
				}
				else {
					return false;
				}

			}
			else {
				if (referenceName.equals("parentNode") || referenceName.equals("children")) {
					return true;
				}
				else {
					return false;
				}
			}
		}
		else {
			return false;
		}
	}

	@Override
	public boolean contains(String className, String propertyName) {
		return containsEReference(className, propertyName) || containsEAttribute(className, propertyName);	

	}

	@Override
	public EAttribute getEAttribute(String className, String attributeName) {
		if (!(className.startsWith("t_") || className.equals("root"))) { //if classname is not xml syntax return null
			return null;
		}
		else { //if class name is xml syntax, get the class
			EClass clazz = getMetaClass(util.removeTag(className));
			if (clazz == null) {
				return null; //if class does not exist return null;
			}
			else { //if class exists (it always exists)
				if (attributeName.equals("text") || attributeName.equals("tagname")) { //if is keyword, handle it
					EAttribute result = (EAttribute) clazz.getEStructuralFeature(attributeName);
					if (result == null) {
						EAttribute attr = util.getFactory().createEAttribute();
						attr.setName(attributeName);
						attr.setLowerBound(0);
						attr.setUpperBound(1);
						attr.setEType(util.getEcorePackage().getEString());
						clazz.getEStructuralFeatures().add(attr);
						return attr;
					}
					else {
						return result;
					}
				}
				else if (util.isXMLSyntax(attributeName)) { //discard inappropriate keywords
					if (attributeName.startsWith("e_") ||
							attributeName.startsWith("x_") ||
							attributeName.startsWith("c_") ||
							attributeName.startsWith("t_")) {
						return null;
					}
					else {
						String escapedAttrName = util.removeTag(attributeName); //escape attribute name
						EStructuralFeature temp = clazz.getEStructuralFeature(escapedAttrName); //get the estructurefeature
						if (temp == null) { //if does not exist, create one and throw a warning
							EAttribute attribute = util.getFactory().createEAttribute();
							attribute.setName(escapedAttrName);
							attribute.setUpperBound(1);
							attribute.setLowerBound(0);
							attribute.setEType(util.getEDataTypeByName(attributeName));
							attribute.getEAnnotations().add(util.createAnnotationForWarning("attribute does not exist in the model"));
							clazz.getEStructuralFeatures().add(attribute);
							return attribute;
						}
						else { //if exists
							if (temp instanceof EAttribute) { //if it is not an eattribute return null
								EAttribute attr = (EAttribute) temp;
								return attr;
							}
							else {
								return null;
							}
						}
					}
				}
				else {
					return null;
				}
			}
		}
	}

	@Override
	public EReference getEReference(String className, String referenceName) {
		if (!(className.startsWith("t_") || className.equals("root"))) { //if classname is not xml syntax return null
			return null;
		}
		else {
			EClass clazz = getMetaClass(util.removeTag(className));
			if (clazz == null) {
				return null; //if class does not exist return null;
			}
			else {
				if (referenceName.equals("parentNode")) {
					if (className.equals("root")) {
						return null;
					}
					else {
						EStructuralFeature feature = clazz.getEStructuralFeature("parentNode");
						if (feature == null) {
							EObject parent = clazz.eContainer();
							if (parent != null) {
								EReference eReference = util.getFactory().createEReference();
								eReference.setName("parentNode");
								eReference.setUpperBound(1);
								eReference.setLowerBound(0);
								if (parent instanceof EPackage) {
									eReference.setEType(getMetaClass("root"));
								}
								else {
									eReference.setEType(parent.eClass());
								}
								clazz.getEStructuralFeatures().add(eReference);
								return eReference;
							}
							else {
								return null;
							}
						}
						else {
							if (feature instanceof EReference) {
								return (EReference) feature;
							}
							else {
								return null;
							}
						}
					}
				}
				else if (referenceName.equals("children")) {
					EStructuralFeature feature = clazz.getEStructuralFeature("children");
					if (feature == null) {
						EReference eReference = util.getFactory().createEReference();
						eReference.setName("children");
						eReference.setLowerBound(0);
						eReference.setUpperBound(1);
//						EClassifier temp = null;
						eReference.setEType(util.getEcorePackage().getEEList());
						clazz.getEStructuralFeatures().add(eReference);
						return eReference;
					}
					else {
						if (feature instanceof EReference) {
							return (EReference) feature;
						}
						else {
							return null;
						}
					}
				}
				else {
					String escapedReferenceName = util.removeTag(referenceName);
					EStructuralFeature feature = clazz.getEStructuralFeature(escapedReferenceName);
					if (feature == null) {
						if (referenceName.startsWith("e_")) {
							EClass otherEnd = getMetaClass(escapedReferenceName);
							
							EReference eReference = util.getFactory().createEReference();
							eReference.setName(escapedReferenceName);
							eReference.setEType(otherEnd);
							eReference.setLowerBound(0);
							eReference.setUpperBound(1);
							eReference.getEAnnotations().add(util.createAnnotationForWarning("reference may not exist in the model"));
							clazz.getEStructuralFeatures().add(eReference);
							return eReference;
						}
						else if (referenceName.startsWith("c_")) {
							EClass otherEnd = getMetaClass(escapedReferenceName);
							
							EReference eReference = util.getFactory().createEReference();
							eReference.setName(escapedReferenceName);
							eReference.setEType(otherEnd);
							eReference.setLowerBound(0);
							eReference.setUpperBound(EStructuralFeature.UNBOUNDED_MULTIPLICITY);
							eReference.getEAnnotations().add(util.createAnnotationForWarning("reference may not exist in the model"));
							clazz.getEStructuralFeatures().add(eReference);
							return eReference;
						}
						else {
							return null;
						}
					}
					else {
						if (feature instanceof EReference) {
							return (EReference) feature;
						}
						else {
							return null;
						}
					}
				}
			}
		}
	}

	@Override
	public EStructuralFeature getEStructuralFeature(String className,
			String featureName) {
		EStructuralFeature feature = getEAttribute(className, featureName);
		return feature == null? getEReference(className, featureName) : feature;
	}

	@Override
	public EAttribute getEAttribute(EClass metaClass, String attributeName) {
		return getEAttribute(metaClass.getName(), attributeName);
	}

	@Override
	public EReference getEReference(EClass metaClass, String referenceName) {
		return getEReference(metaClass.getName(), referenceName);
	}

	@Override
	public EStructuralFeature getEStructuralFeature(EClass metaClass,
			String featureName) {
		return getEStructuralFeature(metaClass.getName(), featureName);
	}

	@Override
	public EClassifier getTypeForEAttribute(EClass eClass, String attributeName) {
		if (eClass == null) {
			return null;
		}
		else {
			
			if (attributeName.equals("text") || attributeName.equals("tagName")) {
				return util.getEcorePackage().getEString();
			}
			else if (attributeName.equals("parentNode") || attributeName.equals("children")) {
				 return null;
			} 
			else {
				if (util.isXMLSyntax(attributeName)) {
					if (attributeName.startsWith("e_") ||
							attributeName.startsWith("x_") ||
							attributeName.startsWith("c_") ||
							attributeName.startsWith("t_")) {
						return null;
					}
					else {
						EAttribute result = getEAttribute(eClass, attributeName);
						if (result != null) {
							return result.getEType();
						}
						else {
							return null;
						}
					}
				}
				else
				{
					return null;
				}
			}
		}
	}

	@Override
	public EClassifier getTypeForEReference(EClass eClass, String referenceName) {
		if (eClass == null) {
			return null;
		}
		else {
			EReference eReference = getEReference(eClass, referenceName);
			if (eReference != null) {
				return eReference.getEType();
			}
			else {
				return null;
			}
		}
	}

	@Override
	public EClassifier getTypeForEStructuralFeature(EClass eClass,
			String propertyName) {
		EClassifier result = getTypeForEAttribute(eClass, propertyName);
		return result == null ? getTypeForEReference(eClass, propertyName) : result;
	}

	@Override
	public EClassifier getTypeForEAttribute(String className,
			String attributeName) {
		EAttribute attribute = getEAttribute(className, attributeName);
		if (attribute != null) {
			return attribute.getEType();
		}
		else {
			return null;
		}
	}

	@Override
	public EClassifier getTypeForEReference(String className,
			String referenceName) {
		EReference reference = getEReference(className, referenceName);
		if (reference != null) {
			return reference.getEType();
		}
		else {
			return null;
		}
	}

	@Override
	public EClassifier getTypeForEStructuralFeature(String className,
			String propertyName) {
		EClassifier result = getTypeForEAttribute(className, propertyName);
		
		return result == null ? getTypeForEReference(className, propertyName) : result;
	}
	
	public void setRoot(EClass root) {
		this.root = root;
	}
	
	public EClass getRoot() {
		return root;
	}

}
