package org.eclipse.epsilon.xminus.loader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.xminus.XminusDiagnostic;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XminusResourceLoader {
	
	protected Resource resource = null;
	protected ArrayList<NodeHandler> nodeHandlers = new ArrayList<NodeHandler>();
	protected EStructuralFeature container;
	protected HashMap<String, EClass> eClasses = null;
	protected HashMap<String, String> namespaces = new HashMap<String, String>();
	protected short AttributeNodeType = 2;
	protected short ElementNodeType = 1;
	
	public XminusResourceLoader(Resource resource) {
		this.resource = resource;
		getNodeHandlers().add(new RootNodeHandler());
		getNodeHandlers().add(new NameMatchingNodeEAttributeHandler());
		getNodeHandlers().add(new NameMatchingElementContainmentEReferenceHandler());
		getNodeHandlers().add(new ElementInContainmentEReferenceHandler());
		getNodeHandlers().add(new NameMatchingNodeNonContainmentEReferenceValueHandler());
		getNodeHandlers().add(new TypeNameMatchingContainmentEReferenceHandler());
		for (NodeHandler nodeHandler : getNodeHandlers()) {
			if (nodeHandler instanceof ContextualNodeHandler) {
				((ContextualNodeHandler) nodeHandler).setContext(this);
			}
		}
	}
	
	public Resource getResource() {
		return resource;
	}
	
	public void setContainer(EStructuralFeature container) {
		this.container = container;
	}
	
	public EStructuralFeature getContainer() {
		return container;
	}
	
	public ArrayList<NodeHandler> getNodeHandlers() {
		return nodeHandlers;
	}
	
	public void handleNode(Node node, EObject eObject) {
		for (NodeHandler nodeHandler : getNodeHandlers()) {
			if (nodeHandler.canHandle(node, eObject)) {
				nodeHandler.handle(node, eObject);
				return;
			}
		}
		if (isAttribute(node) || isElement(node)) {
			resource.getWarnings().add(new XminusDiagnostic("Ignored node " + getName(node), node));
		}
	}
	
	public void handleChildren(Node node, EObject eObject) {
		NodeList childNodes = node.getChildNodes();

		for (Node attribute : getAttributes(node)) {
			handleNode(attribute, eObject);
		}
		
		for (int i=0; i<childNodes.getLength(); i++) {
			handleNode(childNodes.item(i), eObject);
		}
		
	}
	
	protected List<Node> getAttributes(Node node) {
		ArrayList<Node> attributes = new ArrayList<Node>();
		for (int i=0; i<node.getAttributes().getLength(); i++) {
			attributes.add(node.getAttributes().item(i));
		}
		return attributes;
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
	
	public HashMap<String, EClass> getEClasses() {
		if (eClasses == null) {
			eClasses = new HashMap<String, EClass>();
			for (String nsUri : resource.getResourceSet().getPackageRegistry().keySet()) {
				Object o = resource.getResourceSet().getPackageRegistry().get(nsUri);
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
	
	public EClass findConcreteEClass(EClass abstractEClass) {
		for (EClass eClass : getEClasses().values()) {
			if (abstractEClass.isSuperTypeOf(eClass) && !eClass.isAbstract()) {
				return eClass;
			}
		}
		return null;
	}
	
	public void cacheNamespaces(Element e) {
		for (Node attribute : getAttributes(e)) {
			if (getPrefix(attribute).equals("xmlns")) {
				namespaces.put(getName(attribute), attribute.getNodeValue());
			}
			else if (getName(attribute).equals("xmlns")) {
				namespaces.put("", attribute.getNodeValue());
			}
		}
	}
	
	public String getName(Node node) {
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
	
	protected String getNamespaceUri(EClassifier eClassifier) {
		return eClassifier.getEPackage().getNsURI() + "#" + eClassifier.getName();
	}	

	public boolean isAttribute(Node node) {
		return node.getNodeType() == AttributeNodeType;
	}

	public boolean isElement(Node node) {
		return node.getNodeType() == ElementNodeType;
	}
	
	public String getValue(Node node) {
		if (isElement(node)) {
			return ("" + node.getTextContent()).trim();
		}
		else {
			return node.getNodeValue().trim();
		}
	}
	
	protected boolean isNamespaceDeclaration(Node node) {
		return isAttribute(node) && (getName(node).equals("xmlns") || getPrefix(node).equals("xmlns"));
	}
	
	public void load(Document document) {
		cacheNamespaces(document.getDocumentElement());
		handleNode(document.getDocumentElement(), null);
	}
	
	public EObject createInstance(EClass eClass, Node node) {
		return EcoreUtil.create(eClass);
	}
}
