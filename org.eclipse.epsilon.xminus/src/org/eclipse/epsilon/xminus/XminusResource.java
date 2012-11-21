package org.eclipse.epsilon.xminus;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

//TODO: Support lazy reference resolution
public class XminusResource extends ResourceImpl {
	
	protected short ElementNodeType = 1;
	protected List<EClass> eClasses = null;
	protected HashMap<EObject, Node> eObjectNodes = new HashMap<EObject, Node>();
	
	public XminusResource(URI uri) {
		setURI(uri);
	}
	
	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options)
			throws IOException {
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(inputStream);
			getContents().add(createEObject(document.getDocumentElement(), null));
			resolveReferences();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	@Override
	protected void doSave(OutputStream outputStream, Map<?, ?> options)
			throws IOException {
		super.doSave(outputStream, options);
	}
	
	protected void resolveReferences() {
		
	}
	
	protected EObject findEObject(EClass eClass, String id) {
		return null;
	}
	
	protected EObject createEObject(Node node, EClass eClass) {
		String tagName = node.getNodeName();
		if (eClass == null) eClass = eClassForName(tagName);
		
		EObject eObject = eClass.getEPackage().getEFactoryInstance().create(eClass);
		eObjectNodes.put(eObject, node);
		
		for (int i = 0; i<node.getAttributes().getLength(); i++) {
			Node attribute = node.getAttributes().item(i);
			for (EAttribute eAttribute : eClass.getEAllAttributes()) {
				if (eAttribute.getName().equalsIgnoreCase(attribute.getNodeName())) {
					setEAttributeValue(eObject, eAttribute, attribute.getNodeValue());
				}
			}
		}
		
		for (int i = 0; i<node.getChildNodes().getLength(); i++) {
			Node child = node.getChildNodes().item(i);
			
			for (EAttribute eAttribute : eClass.getEAllAttributes()) {
				if (eAttribute.isChangeable() && eAttribute.getName().equalsIgnoreCase(child.getNodeName())) {
					setEAttributeValue(eObject, eAttribute, child.getTextContent()+"");
				}
			}
			
			for (EReference eReference : eClass.getEAllReferences()) {
				if (eReference.isContainment() && eReference.isChangeable()) {
					EClass valueEClass = getAssignableEClass(eReference.getEType(), child.getNodeName());
					
					if (valueEClass != null) {
						if (eReference.isMany()) {
							((List<EObject>) eObject.eGet(eReference)).add(createEObject(child, valueEClass));
						}
						else {
							eObject.eSet(eReference, createEObject(child, valueEClass));
						}
					}
				}
			}
			
		}
		
		return eObject;
	}
	
	protected void setEAttributeValue(EObject eObject, EAttribute eAttribute, String value) {
		
		EFactory eFactory = eAttribute.getEAttributeType().getEPackage().getEFactoryInstance();
		
		if (eAttribute.isMany()) {
			String[] values = value.split(",");
			List<Object> eValues = (List<Object>) eObject.eGet(eAttribute);
			for (String val : values) {
				eValues.add(eFactory.createFromString(eAttribute.getEAttributeType(), val.trim()));
			}
		}
		else {
			eObject.eSet(eAttribute, eFactory.createFromString(eAttribute.getEAttributeType(), value.trim()));
		}
	}
	
	protected EClass getAssignableEClass(EClassifier classifier, String name) {
		for (EClass eClass : getEClasses()) {
			if (eClass.getName().equalsIgnoreCase(name) && (
					eClass == classifier || eClass.getEAllSuperTypes().contains(classifier))){
				return eClass;
			}
		}
		return null;
	}
	
	protected List<EClass> getEClasses() {
		if (eClasses == null) {
			eClasses = new ArrayList<EClass>();
			for (String nsUri : resourceSet.getPackageRegistry().keySet()) {
				Object o = resourceSet.getPackageRegistry().get(nsUri);
				if (o instanceof EPackage) {
					EPackage ePackage = (EPackage) o;
					for (EClassifier eClassifier : ePackage.getEClassifiers()) {
						if (eClassifier instanceof EClass) {
							eClasses.add((EClass) eClassifier);
						}
					}
				}
			}
		}
		return eClasses;
	}
	
	protected EClass eClassForName(String name) {
		for (EClass eClass : getEClasses()) {
			if (eClass.getName().equalsIgnoreCase(name)) {
				return eClass;
			}
		}
		return null;
	}
	
}