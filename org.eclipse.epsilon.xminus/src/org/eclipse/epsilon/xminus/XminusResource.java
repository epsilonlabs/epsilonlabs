package org.eclipse.epsilon.xminus;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
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
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.epsilon.xminus.handlers.ElementInContainmentEReferenceHandler;
import org.eclipse.epsilon.xminus.handlers.NameMatchingElementContainmentEReferenceHandler;
import org.eclipse.epsilon.xminus.handlers.NameMatchingNodeEAttributeHandler;
import org.eclipse.epsilon.xminus.handlers.NodeHandler;
import org.eclipse.epsilon.xminus.handlers.RootNodeHandler;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class XminusResource extends ResourceImpl {
	
	protected short ElementNodeType = 1;
	protected short AttributeNodeType = 2;
	
	protected HashMap<String, EClass> eClasses = null;
	protected HashMap<EObject, Node> eObjectNodes = new HashMap<EObject, Node>();
	protected Document document = null;
	protected HashMap<String, String> namespaces = new HashMap<String, String>();
	protected XminusContext context = null;
	
	public XminusResource(URI uri) {
		setURI(uri);
		context = new XminusContext();
		context.setResource(this);
		context.getNodeHandlers().add(new RootNodeHandler());
		context.getNodeHandlers().add(new NameMatchingNodeEAttributeHandler());
		context.getNodeHandlers().add(new NameMatchingElementContainmentEReferenceHandler());
		context.getNodeHandlers().add(new ElementInContainmentEReferenceHandler());
	}
	
	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options)
			throws IOException {
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			document = documentBuilder.parse(inputStream);
			cacheNamespaces(document.getDocumentElement());
			context.handleNode(document.getDocumentElement(), null);
			//getContents().add(createEObject(document.getDocumentElement(), null));
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	protected void cacheNamespaces(Element e) {
		for (Node attribute : getAttributes(e)) {
			if (getPrefix(attribute).equals("xmlns")) {
				namespaces.put(getName(attribute), attribute.getNodeValue());
			}
			else if (getName(attribute).equals("xmlns")) {
				namespaces.put("", attribute.getNodeValue());
			}
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
		String tagName = getName(node);
		if (eClass == null) eClass = eClassForName(tagName, getNamespaceUri(node));
		
		EObject eObject = EcoreUtil.create(eClass);
		eObjectNodes.put(eObject, node);
		
		for (Node childOrAttribute : getChildrenAndAttributes(node)) {
			
			boolean consumed = false;
			
			for (EAttribute eAttribute : eClass.getEAllAttributes()) {
				if (eAttribute.isTransient()) continue;
				if (eAttribute.getName().equalsIgnoreCase(getName(childOrAttribute))) {
					setEAttributeValue(eObject, eAttribute, getValue(childOrAttribute));
					consumed = true;
				}
			}
			
			for (EReference eReference : eClass.getEAllReferences()) {
				if (eReference.isTransient()) continue;
				
				if (eReference.isContainment() && isElement(childOrAttribute)) {
					
					if (eReference.getName().equalsIgnoreCase(getName(childOrAttribute))) {
						List<Node> valueNodes = getChildren(childOrAttribute);
						if (eReference.isMany()) {
							List<EObject> eReferenceValues = (List<EObject>) eObject.eGet(eReference);
							for (Node valueNode : valueNodes) {
								eReferenceValues.add(createEObject(valueNode, null));
							}
						}
						else {
							if (valueNodes.size() > 0) {
								if (valueNodes.size() > 1) {
									addWarning("Multiple values provided for single-valued feature " + eReference.getName(), childOrAttribute);
								}
								eObject.eSet(eReference, createEObject(valueNodes.get(0), null));
							}
						}
						consumed = true;
					}
					else {
						Node child = childOrAttribute;
						EClass valueEClass = getAssignableEClass(eReference.getEType(), child);
						
						if (valueEClass != null) {
							if (eReference.isMany()) {
								((List<EObject>) eObject.eGet(eReference)).add(createEObject(child, valueEClass));
							}
							else {
								if (eObject.eIsSet(eReference)) {
									addWarning("Multiple values provided for single-valued feature " + eReference.getName(), child);
								}
								eObject.eSet(eReference, createEObject(child, valueEClass));
							}
							consumed = true;
						}
					}
				}
				else {
					if (eReference.getName().equalsIgnoreCase(getName(childOrAttribute))) {
						EClass proxyEClass = (EClass) eReference.getEType();
						if (proxyEClass.isAbstract()) {
							proxyEClass = findConcreteEClass(proxyEClass);
						}
						
						if (eReference.isMany()) {
							String[] valueIds = getValue(childOrAttribute).split(",");
							for (String valueId : valueIds) {
								EObject proxy = EcoreUtil.create(proxyEClass);
								((InternalEObject) proxy).eSetProxyURI(getURI().appendFragment(valueId));
								((Collection<EObject>) eObject.eGet(eReference)).add(proxy);
							}
						}
						else {
							EObject proxy = EcoreUtil.create(proxyEClass);
							((InternalEObject) proxy).eSetProxyURI(getURI().appendFragment(getValue(childOrAttribute)));
							eObject.eSet(eReference, proxy);
						}
						
						consumed = true;
					}
				}
				
			}
			
			if (consumed == false && !isNamespaceDeclaration(childOrAttribute)) {
				addWarning("Node " + getName(childOrAttribute) + " could not be mapped to a valid feature of " + eObject, childOrAttribute);
			}
			
		}
				
		return eObject;
	}
	
	public EClass findConcreteEClass(EClass abstractEClass) {
		for (EClass eClass : getEClasses().values()) {
			if (abstractEClass.isSuperTypeOf(eClass) && !eClass.isAbstract()) {
				return eClass;
			}
		}
		return null;
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
	
	protected EClass getAssignableEClass(EClassifier classifier, Node node) {
		EClass eClass = eClassForName(getName(node), getNamespaceUri(node));
		if (eClass != null && isAssignable(eClass, classifier)) {
			return eClass;
		}
		return null;
	}
	
	protected HashMap<String, EClass> getEClasses() {
		if (eClasses == null) {
			eClasses = new HashMap<String, EClass>();
			for (String nsUri : resourceSet.getPackageRegistry().keySet()) {
				Object o = resourceSet.getPackageRegistry().get(nsUri);
				if (o instanceof EPackage) {
					EPackage ePackage = (EPackage) o;
					for (EClassifier eClassifier : ePackage.getEClassifiers()) {
						if (eClassifier instanceof EClass) {
							eClasses.put(ePackage.getNsURI() + "#" + eClassifier.getName(), (EClass) eClassifier);
						}
					}
				}
			}
		}
		return eClasses;
	}
	
	public EClass eClassForName(String name, String namespaceUri) {
		if (namespaceUri != null) {
			for (String eClassUri : getEClasses().keySet()) {
				if (eClassUri.equalsIgnoreCase(namespaceUri + "#" + name)) {
					return getEClasses().get(eClassUri);
				}
			}
		}
		else {
			for (EClass eClass : getEClasses().values()) {
				if (eClass.getName().equalsIgnoreCase(name)) {
					return eClass;
				}
			}
		}
		return null;
	}
	
	protected String getName(Node node) {
		String name = node.getNodeName();
		if (name.indexOf(':') > 0) {
			name = name.split(":")[1];
		}
		return name;
	}
	
	protected String getPrefix(Node node) {
		String name = node.getNodeName();
		if (name.indexOf(':') > 0) {
			return name.split(":")[0];
		}
		else {
			return "";
		}		
	}
	
	public String getNamespaceUri(Node node) {
		
		String name = node.getNodeName();
		if (name.indexOf(':') > 0) {
			String prefix = name.split(":")[0];
			return namespaces.get(prefix);
		}
		else {
			return namespaces.get("");
		}
	}
	
	protected List<Node> getChildrenAndAttributes(Node parent) {
		ArrayList<Node> childrenAndAttributes = new ArrayList<Node>();
		childrenAndAttributes.addAll(getAttributes(parent));
		childrenAndAttributes.addAll(getChildren(parent));
		return childrenAndAttributes;
	}
	
	protected String getNamespaceUri(EClassifier eClassifier) {
		return eClassifier.getEPackage().getNsURI() + "#" + eClassifier.getName();
	}
	
	protected boolean isAttribute(Node node) {
		return node.getNodeType() == AttributeNodeType;
	}
	
	protected String getValue(Node node) {
		if (isElement(node)) {
			return ("" + node.getTextContent()).trim();
		}
		else {
			return node.getNodeValue().trim();
		}
	}
	
	protected boolean isElement(Node node) {
		return node.getNodeType() == ElementNodeType;
	}
	
	protected boolean isNamespaceDeclaration(Node node) {
		return isAttribute(node) && (getName(node).equals("xmlns") || getPrefix(node).equals("xmlns"));
	}
	
	protected void addWarning(String reason, Node node) {
		getWarnings().add(new XminusDiagnostic(reason, node));
	}
	
	protected void addError(String reason, Node node) {
		getErrors().add(new XminusDiagnostic(reason, node));
	}
	
}