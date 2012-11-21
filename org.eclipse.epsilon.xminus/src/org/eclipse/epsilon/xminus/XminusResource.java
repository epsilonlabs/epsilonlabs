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
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

//TODO: Support lazy reference resolution
public class XminusResource extends ResourceImpl {
	
	protected short ElementNodeType = 1;
	protected List<EClass> eClasses = null;
	protected HashMap<EObject, Node> eObjectNodes = new HashMap<EObject, Node>();
	protected Document document = null;
	
	public XminusResource(URI uri) {
		setURI(uri);
	}
	
	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options)
			throws IOException {
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			document = documentBuilder.parse(inputStream);
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
		
		try {
			Source xmlSource = new DOMSource(document);
			Result result = new StreamResult(outputStream);
	
			// create TransformerFactory
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			
			// create Transformer for transformation
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");	//Java XML Indent
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			
			// transform and deliver content to client
			transformer.transform(xmlSource, result);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	protected void resolveReferences() {
		TreeIterator<EObject> iterator = getAllContents();
		while (iterator.hasNext()) {
			EObject eObject = iterator.next();
			Node node = eObjectNodes.get(eObject);
			
			for (Node attribute : getAttributes(node)) {
				for (EReference eReference : eObject.eClass().getEAllReferences()) {
					if (eReference.isChangeable() && !eReference.isContainment() && eReference.getName().equalsIgnoreCase(attribute.getNodeName())) {
						setEReferenceValue(eObject, eReference, attribute.getNodeValue());
					}
				}
			}
			
			for (int i=0; i<node.getChildNodes().getLength(); i++) {
				Node child = node.getChildNodes().item(i);
				
			}
		}
	}
	
	protected List<Node> getAttributes(Node node) {
		ArrayList<Node> attributes = new ArrayList<Node>();
		for (int i=0; i<node.getAttributes().getLength(); i++) {
			attributes.add(node.getAttributes().item(i));
		}
		return attributes;
	}
	
	protected List<Node> getChildren(Node node) {
		ArrayList<Node> children = new ArrayList<Node>();
		for (int i=0; i<node.getChildNodes().getLength(); i++) {
			Node child = node.getChildNodes().item(i);
			if (child.getNodeType() == ElementNodeType) {
				children.add(child);
			}
		}
		return children;
	}
	
	protected EObject findEObject(EClassifier eClassifier, String id) {
		TreeIterator<EObject> iterator = getAllContents();
		while (iterator.hasNext()) {
			EObject eObject = iterator.next();
			if (isAssignable(eObject.eClass(), eClassifier) && id.equalsIgnoreCase(EcoreUtil.getID(eObject))) {
				return eObject;
			}
		}
		return null;
	}
	
	protected List<EObject> findEObjects(EClassifier eClassifier) {
		ArrayList<EObject> eObjects = new ArrayList<EObject>();
		TreeIterator<EObject> iterator = getAllContents();
		while (iterator.hasNext()) {
			EObject eObject = iterator.next();
			if (isAssignable(eObject.eClass(), eClassifier)) {
				eObjects.add(eObject);
			}
		}
		return eObjects;
	}
	
	protected boolean isAssignable(EClass source, EClassifier target) {
		return source == target || source.getEAllSuperTypes().contains(target);
	}
	
	protected EObject createEObject(Node node, EClass eClass) {
		String tagName = node.getNodeName();
		if (eClass == null) eClass = eClassForName(tagName);
		
		EObject eObject = eClass.getEPackage().getEFactoryInstance().create(eClass);
		eObjectNodes.put(eObject, node);
		
		for (Node attribute : getAttributes(node)) {
			for (EAttribute eAttribute : eClass.getEAllAttributes()) {
				if (eAttribute.getName().equalsIgnoreCase(attribute.getNodeName())) {
					setEAttributeValue(eObject, eAttribute, attribute.getNodeValue());
				}
			}
		}
		
		for (Node child : getChildren(node)) {
			
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
	
	protected void setEReferenceValue(EObject eObject, EReference eReference, String value) {
		if (eReference.isMany()) {
			List<Object> eValues = (List<Object>) eObject.eGet(eReference);
			if ("*".equals(value.trim())) {
				eValues.addAll(findEObjects(eReference.getEType()));
			}
			else {
				String[] valueIds = value.split(",");
				for (String valueId : valueIds) {
					EObject target = findEObject(eReference.getEType(), valueId.trim());
					if (target != null) {
						eValues.add(target);
					}
				}
			}
		}
		else {
			EObject target = findEObject(eReference.getEType(), value.trim());
			if (target != null) {
				eObject.eSet(eReference, target);
			}
		}
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
			if (eClass.getName().equalsIgnoreCase(name) && isAssignable(eClass, classifier)){
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