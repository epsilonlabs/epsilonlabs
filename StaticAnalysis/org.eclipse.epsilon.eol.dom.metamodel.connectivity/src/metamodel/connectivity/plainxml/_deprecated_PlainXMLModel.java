//package metamodel.connectivity.plainxml;
//
//import java.util.List;
//
//import metamodel.connectivity.emf.EMFMetamodelDriver;
//
//import org.eclipse.emf.ecore.EAnnotation;
//import org.eclipse.emf.ecore.EAttribute;
//import org.eclipse.emf.ecore.EClass;
//import org.eclipse.emf.ecore.EClassifier;
//import org.eclipse.emf.ecore.EDataType;
//import org.eclipse.emf.ecore.EEnum;
//import org.eclipse.emf.ecore.EObject;
//import org.eclipse.emf.ecore.EPackage;
//import org.eclipse.emf.ecore.EReference;
//import org.eclipse.emf.ecore.EStructuralFeature;
//import org.eclipse.emf.ecore.EcorePackage;
//
//public class _deprecated_PlainXMLModel extends EMFMetamodelDriver{
//
//	protected XML2Ecore xml2EcoreParser = new XML2Ecore();
//		
//	public void loadModel(String sourceString) throws Exception
//	{
//		xml2EcoreParser.parseXMLFromFile(sourceString);
//		ePackage = xml2EcoreParser.getePackage();
//	}
//	
//	public String removeTag(String fullName)
//	{
//		if (isXMLSyntax(fullName)) {
//			return fullName.substring(2, fullName.length());
//		}
//		else {
//			return fullName;
//		}
//	}
//	
//	public boolean isXMLSyntax(String fullName)
//	{
//		if (fullName.startsWith("a_") || fullName.startsWith("b_") ||
//				fullName.startsWith("i_") || fullName.startsWith("f_") || 
//				fullName.startsWith("d_") || fullName.startsWith("s_") ||
//				fullName.startsWith("t_") || fullName.startsWith("c_") ||
//				fullName.startsWith("e_") || fullName.startsWith("x_")) {
//			return true;
//		}
//		else {
//			return false;
//		}
//	}
//	
//	public String getMetamodelName()
//	{
//		return ePackage.getName();
//	}
//	
//	public String getMetamodelNsURI()
//	{
//		return ePackage.getNsURI();
//	}
//	
//	public String getMetamodelNsPrefix()
//	{
//		return ePackage.getNsPrefix();
//	}
//	
//	public boolean containsMetaClass(String metaClassName)
//	{
//		if (!metaClassName.startsWith("t_")) {
//			return false;
//		}
//		else {
//			return true;	
//		}
//	}
//	
//	public EClass getMetaClass(String metaClassName)
//	{
//		if (metaClassName.equals("root")) {
//			EClass clazz = super.getMetaClass(metaClassName);
//			if (clazz == null) {
//				EClass result = xml2EcoreParser.factory.createEClass();
//				result.setName(metaClassName);
//				//result.getEAnnotations().add(createAnnotationForWarning("Type does not exist in the model"));
//				ePackage.getEClassifiers().add(result);
//				return result;
//			}
//			else {
//				return clazz;
//			}
//		}
//		else if (isXMLSyntax(metaClassName)) {
//			if(super.getMetaClass(removeTag(metaClassName)) == null)
//			{
//				EClass result = xml2EcoreParser.factory.createEClass();
//				result.setName(removeTag(metaClassName));
//
//				result.getEAnnotations().add(createAnnotationForWarning("Type does not exist in the model"));
//
//				ePackage.getEClassifiers().add(result);
//				return result;
//			}
//			else {
//				return super.getMetaClass(removeTag(metaClassName));
//			}	
//		}
//		else {
//			return super.getMetaClass(metaClassName);
//		}
//	}
//	
//	public boolean containsEnum(String enumName)
//	{
//		return true;
//	}
//	
//	public EEnum getEnum(String enumName)
//	{
//		if(super.getEnum(removeTag(enumName)) == null)
//		{
//			return null;
//		}
//		else {
//			return super.getEnum(removeTag(enumName));
//		}
//	}
//	
//	public boolean containsEnumLiteral(String enumName, String literlName)
//	{
//		return super.containsEnumLiteral(removeTag(enumName), literlName);
//	}
//	
//	public List<EStructuralFeature> getEStructuralFeatures(String metaClassName)
//	{
//		return super.getEStructuralFeatures(removeTag(metaClassName));
//	}
//		
//	public boolean containsEReference(String metaClassName, String eReferenceName)
//	{
//		if (isXMLSyntax(metaClassName) && isXMLSyntax(eReferenceName)) {
//			return true;	
//		}
//		else
//		{
//			return false;
//		}
//		
//		//return super.containsEReference(removeTag(metaClassName), removeTag(eReferenceName));
//	}
//	
//	public boolean containsEAttribute(String metaClassName, String eAttributeName)
//	{
//		if (isXMLSyntax(metaClassName) && isXMLSyntax(eAttributeName)) {
//			return true;
//		}
//		else if (isXMLSyntax(metaClassName) && eAttributeName.equals("text")) {
//			return true;
//		}
//		else {
//			return false;
//		}
//		//return super.containsEAttribute(removeTag(metaClassName), removeTag(eAttributeName));
//	}
//	
//	public boolean contains(String metaClassName, String property)
//	{
//		if (property.equals("text") || property.equals("parentNode") || property.equals("children") || property.equals("tagName")) {
//			return true;
//		}
//		
//		if (isXMLSyntax(metaClassName) && isXMLSyntax(property)) {
//			if ((!(metaClassName.startsWith("t_"))) || property.startsWith("x_")) {
//				return false;
//			}
//			else {
//				return true;	
//			}
//		}
//		else {
//			return false;
//		}		
//	}
//	
//	public EAttribute getEAttribute(EClass object, String attributeName)
//	{
//		if (isXMLSyntax(attributeName) || attributeName.equals("text") || attributeName.equals("tagName")) {
//			
//			if (attributeName.equals("text")) {
//				EAttribute result = super.getEAttribute(object, attributeName);
//				if(result == null)
//				{
//					EAttribute eAttribute = xml2EcoreParser.factory.createEAttribute();
//					eAttribute.setName("text");
//					/*if (attributeName.startsWith("c_")) {//--------
//						eAttribute.setUpperBound(EStructuralFeature.UNBOUNDED_MULTIPLICITY);
//						eAttribute.setEType(EcorePackage.eINSTANCE.getEString());
//					}
//					else {
//						eAttribute.setUpperBound(1);
//						eAttribute.setLowerBound(0);
//						eAttribute.setEType(getEDataTypeByName(attributeName));
//					}*/
//					
//					eAttribute.setUpperBound(1);
//					eAttribute.setLowerBound(0);
//					eAttribute.setEType(ecorePackage.getEString());
//					
//					object.getEStructuralFeatures().add(eAttribute);
//					
//					return eAttribute;	
//				}
//				else {
//						return result;
//				}
//				
//			}
//			else if (attributeName.equals("tagName")) {
//				EAttribute result = null;
//				if (object!=null) {
//					result = super.getEAttribute(object, attributeName);
//				}
//				if(result == null)
//				{
//					EAttribute eAttribute = xml2EcoreParser.factory.createEAttribute();
//					eAttribute.setName("tagName");
//					/*if (attributeName.startsWith("c_")) {//--------
//						eAttribute.setUpperBound(EStructuralFeature.UNBOUNDED_MULTIPLICITY);
//						eAttribute.setEType(EcorePackage.eINSTANCE.getEString());
//					}
//					else {
//						eAttribute.setUpperBound(1);
//						eAttribute.setLowerBound(0);
//						eAttribute.setEType(getEDataTypeByName(attributeName));
//					}*/
//					
//					eAttribute.setUpperBound(1);
//					eAttribute.setLowerBound(0);
//					eAttribute.setEType(ecorePackage.getEString());
//					if (object != null) {
//						object.getEStructuralFeatures().add(eAttribute);
//
//					}
//					return eAttribute;	
//				}
//				else {
//						return result;
//				}
//
//			}
//			else {
//				if (attributeName.startsWith("e_") ||
//						attributeName.startsWith("x_") ||
//						attributeName.startsWith("c_") ||
//						attributeName.startsWith("t_")) {
//					return null;
//				}
//				else if(isXMLSyntax(attributeName))
//				{
//					EAttribute result = super.getEAttribute(object, removeTag(attributeName));
//					if(result == null)
//					{
//						EAttribute eAttribute = xml2EcoreParser.factory.createEAttribute();
//						eAttribute.setName(removeTag(attributeName));
//						/*if (attributeName.startsWith("c_")) {//--------
//							eAttribute.setUpperBound(EStructuralFeature.UNBOUNDED_MULTIPLICITY);
//							eAttribute.setEType(EcorePackage.eINSTANCE.getEString());
//						}
//						else {
//							eAttribute.setUpperBound(1);
//							eAttribute.setLowerBound(0);
//							eAttribute.setEType(getEDataTypeByName(attributeName));
//						}*/
//						
//						eAttribute.setUpperBound(1);
//						eAttribute.setLowerBound(0);
//						eAttribute.setEType(getEDataTypeByName(attributeName));
//						
//						eAttribute.getEAnnotations().add(createAnnotationForWarning("attribute does not exist in the model"));
//						object.getEStructuralFeatures().add(eAttribute);
//						
//						return eAttribute;	
//					}
//					else {
//							return result;
//					}
//				}
//			}
//		}
//		return null;		
//	}
//	
//	public EReference getEReference(EClass object, String referenceName)
//	{
//		if (isXMLSyntax(referenceName)) {
//			EReference result = super.getEReference(object, removeTag(referenceName));
//			if (result == null) {
//				if(referenceName.startsWith("e_"))
//				{
//					EClass clazz = getMetaClass(referenceName);
//					ePackage.getEClassifiers().add(clazz);
//					
//					EReference eReference = xml2EcoreParser.factory.createEReference();
//					eReference.setName(removeTag(referenceName));
//					eReference.setEType(clazz);
//					eReference.setLowerBound(0);
//					eReference.setUpperBound(1);
//					eReference.getEAnnotations().add(createAnnotationForWarning("reference does not exist in the model"));
//					
//					object.getEStructuralFeatures().add(eReference);
//					return eReference;
//				}
//				else if (referenceName.startsWith("c_")) {
//					EClass clazz = getMetaClass(referenceName);
//					ePackage.getEClassifiers().add(clazz);
//					
//					EReference eReference = xml2EcoreParser.factory.createEReference();
//					eReference.setName(removeTag(referenceName));
//					eReference.setEType(clazz);
//					eReference.setUpperBound(EStructuralFeature.UNBOUNDED_MULTIPLICITY);
//					eReference.setLowerBound(0);
//					eReference.getEAnnotations().add(createAnnotationForWarning("reference does not exist in the model"));
//					
//					object.getEStructuralFeatures().add(eReference);
//					return eReference;
//
//				}
//				else {
//					return null;
//				}
//			}
//			else {
//				return result;	
//			}
//		}
//		else if (referenceName.equals("parentNode")) {
//			EObject clazz = null;
//			if (object != null) {
//				clazz = object.eContainer();
//			}
//			
//			EReference eReference = xml2EcoreParser.factory.createEReference();
//			eReference.setName(referenceName);
//			eReference.setLowerBound(0);
//			eReference.setUpperBound(1);
//			
//			if(object.getName().equals("root"))
//			{
//				eReference.setEType(getMetaClass("root"));
//				eReference.getEAnnotations().add(createAnnotationForWarning("node may be the root of the document already"));
//				object.getEStructuralFeatures().add(eReference);
//			}
//			else {
//				if (clazz instanceof EPackage) {
//					eReference.setEType(getMetaClass("root"));
//				}
//				else {
//					eReference.setEType(clazz.eClass());
//				}
//				if (object != null) {
//					object.getEStructuralFeatures().add(eReference);	
//				}
//			}
//
//			return eReference;
//
//		}
//		else if (referenceName.equals("children")) {
//			EReference result = null;
//			if (object!=null) {
//				result = super.getEReference(object, referenceName);
//			}
//			
//			if (result != null) {
//				return result;
//			}
//			else {
//				EReference eReference = xml2EcoreParser.factory.createEReference();
//				eReference.setName(referenceName);
//				eReference.setLowerBound(0);
//				eReference.setUpperBound(EStructuralFeature.UNBOUNDED_MULTIPLICITY);
//				EClassifier temp = null;
//				for(EObject obj :object.eContents())
//				{
//					if (obj instanceof EReference) {
//						temp = ((EReference) obj).getEType();
//					}
//				}
//				if (temp.getName().equals("root")) {
//					eReference.getEAnnotations().add(createAnnotationForWarning("node may not contain any children"));
//				}
//				eReference.setEType(temp); //not so sure about this
//				object.getEStructuralFeatures().add(eReference);
//				return eReference;
//			}			
//		}
//		else {
//			return null;
//		}
//	}
//	
//	public EStructuralFeature getEStructuralFeature(EClass object, String featureName)
//	{
//		return getEAttribute(object, featureName) == null? getEReference(object, featureName) : getEAttribute(object, featureName);
//		//return object.getEStructuralFeature(removeTag(featureName));
//	}
//	
//	public EClassifier getTypeForEAttribute(EObject object, String attributeName)
//	{
//		if (attributeName.equals("text")) {
//			return ecorePackage.getEString();
//		}
//		if (attributeName.equals("tagName")) {
//			return ecorePackage.getEString();
//		}
//		if (attributeName.equals("parentNode") || attributeName.equals("children")) {
//			return null;
//		}
//		return super.getTypeForEAttribute(object, removeTag(attributeName));
//	}
//	
//	public EClassifier getTypeForEReference(EObject object, String referenceName)
//	{
//		if (referenceName.equals("parentNode")) {
//			
//			//EClass parentNode = xml2EcoreParser.factory.createEClass();
//			//parentNode.setName("parentNode");
//			return super.getTypeForEReference(object, referenceName);
//		}
//		else if (referenceName.equals("children")) {
//			return super.getTypeForEReference(object, referenceName);
//		}
//		return super.getTypeForEReference(object, removeTag(referenceName));
//	}
//	
//	public EClassifier getTypeForEStructuralFeature(EObject object, String propertyName)
//	{
//		if (propertyName.startsWith("e_") || propertyName.startsWith("c_")) {
//			return getTypeForEReference(object, propertyName) == null ? getTypeForEAttribute(object, propertyName) : getTypeForEReference(object, propertyName);
//		}
//		else {
//			return getTypeForEAttribute(object, propertyName) == null ? getTypeForEReference(object, propertyName) : getTypeForEAttribute(object, propertyName);	
//		}
//	}
//		
//	public EDataType getEDataTypeByName(String s)
//	{
//		if (s.startsWith("b_")) {
//			return EcorePackage.eINSTANCE.getEBoolean();
//		}
//		else if (s.startsWith("f_")) {
//			return EcorePackage.eINSTANCE.getEFloat();
//		}
//		else if (s.startsWith("d_")) {
//			return EcorePackage.eINSTANCE.getEDouble();
//		}
//		else if (s.startsWith("i_")) {
//			return EcorePackage.eINSTANCE.getEInt();
//		}
//		else if (s.startsWith("s_") || s.startsWith("a_")) {
//			return EcorePackage.eINSTANCE.getEString();
//		}
//		return null;
//	}
//	
//	public EAnnotation createAnnotationForWarning(String s)
//	{
//		EAnnotation annot = xml2EcoreParser.factory.createEAnnotation();
//		annot.getDetails().put("warning", s);
//		return annot;
//	}
//	
//	public EAnnotation createAnnotationForError(String s)
//	{
//		EAnnotation annot = xml2EcoreParser.factory.createEAnnotation();
//		annot.getDetails().put("error", s);
//		return annot;
//	}
//
//}
