package metamodel.connectivity.plainxml;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XML2Ecore {
	
	protected Document document;
	protected EcoreFactory factory = EcoreFactory.eINSTANCE;
	protected EPackage ePackage = factory.createEPackage();

	
	protected HashMap<String, EClass> metaClassMap = new HashMap<String, EClass>();	

	public Node getRoot() {
		return document.getFirstChild();
	}
	
	public EPackage getePackage() {
		return ePackage;
	}
	
	public void setRoot(Node node) {
		Node oldRoot = getRoot();
		if (oldRoot != null) document.removeChild(oldRoot);
		document.appendChild(node);
	}
		
	public EClass createEClass(Element element)
	{
		String className = element.getNodeName();
		
		EClass cls = getEClass(className);
		ePackage.getEClassifiers().add(cls);
		NamedNodeMap attrs = element.getAttributes();
		HashMap<String, EAttribute> attributeMap = new HashMap<String, EAttribute>();
		for(int i = 0; i < attrs.getLength(); i++)
		{
			String attrName = attrs.item(i).getNodeName();
			EAttribute attr = getEAttribute(className, attrName);
			if (attributeMap.containsKey(attrName)) {
				attr.setUpperBound(EStructuralFeature.UNBOUNDED_MULTIPLICITY);
			}
			else {
				attributeMap.put(attrName, attr);
			}
		}
		HashMap<String, EReference> referenceMap = new HashMap<String, EReference>();
		NodeList children = element.getChildNodes();
		for (int i=0; i<children.getLength(); i++) {
			Object o = children.item(i);
			if (o instanceof Element) {
				if (isComplexElement((Element) o)) {
					EClass referenceNode = createEClass((Element) o);
					EReference reference = getEReference(className, referenceNode);
					if (attributeMap.containsKey(reference.getName())) {
						if (reference.getUpperBound() == EStructuralFeature.UNBOUNDED_MULTIPLICITY) {
							
						}
						else {
							reference.setUpperBound(EStructuralFeature.UNBOUNDED_MULTIPLICITY);	
						}
					}
					else {
						referenceMap.put(reference.getName(), reference);
					}
				}
				else {
					String attrName = ((Element)o).getNodeName();
					EAttribute attr = getEAttribute(className, attrName);
					if (attributeMap.containsKey(attrName)) {
						attr.setUpperBound(EStructuralFeature.UNBOUNDED_MULTIPLICITY);

					}
					else {
						attributeMap.put(attrName, attr);
					}
				}
			}
		}
		return cls;
	}
	
	public EClass getEClass(String name)
	{
		EClass result = null;
		if (metaClassMap.containsKey(name)) {
			result = metaClassMap.get(name);
		}
		else {
			result = factory.createEClass();
			result.setName(name);
			metaClassMap.put(name, result);
		}
		return result;
	}
	
	public EAttribute getEAttribute(String className, String attributeName)
	{
		EAttribute result = null;
		if (metaClassMap.containsKey(className)) {
			EClass cls = metaClassMap.get(className);
			if (cls.getEStructuralFeature(attributeName) == null) {
				result = factory.createEAttribute();
				result.setName(attributeName);
				result.setEType(EcorePackage.eINSTANCE.getEString());
				result.setLowerBound(0);
				result.setUpperBound(1);
				cls.getEStructuralFeatures().add(result);
			}
			else {
				result = (EAttribute) cls.getEStructuralFeature(attributeName);
			}
		}
		return result;
	}
	
	public EReference getEReference(String className, EClass referredClass)
	{
		EReference result = null;
		if (metaClassMap.containsKey(className)) {
			EClass cls = metaClassMap.get(className);
			String referenceName = referredClass.getName();
			if (cls.getEStructuralFeature(referenceName) == null) {
				result = factory.createEReference();
				result.setName(referenceName);
				result.setEType(referredClass);
				result.setLowerBound(0);
				result.setUpperBound(1);
				cls.getEStructuralFeatures().add(result);
			}
			else {
				result = (EReference) cls.getEStructuralFeature(referenceName);
			}
		}
		return result;
	}
	
	public boolean isComplexElement(Element element)
	{
		boolean result = true;
		if (element.getAttributes().getLength()==0) {
			if(element.getChildNodes().getLength()==1)
			{
				if (element.getChildNodes().item(0) instanceof Element) {
					
				}
				else {
					result = false;
				}
			}
		}
		return result;
	}
	
	public void parseXMLFromFile(String filePath) throws ParserConfigurationException, SAXException, IOException
	{
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

//		URL url = getClass().getResource(filePath);
//		File file = new File(url.getPath());
		File file = new File(filePath);
		
		document = documentBuilder.parse(file);
		String packageName = getRoot().getNodeName();
		String prefix = packageName.toLowerCase();
		String nsURI = "http://" + packageName + "/1.0";
		ePackage.setName(packageName);
		ePackage.setNsPrefix(prefix);
		ePackage.setNsURI(nsURI);
		NodeList childNodes = getRoot().getChildNodes();
		for (int i=0; i<childNodes.getLength(); i++) {
			Object o = childNodes.item(i);
			if (o instanceof Element) {
				createEClass((Element) o);
			}
		}
	}
	

	public void testParse() throws ParserConfigurationException, SAXException, IOException
	{
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

		URL url = getClass().getResource("library.xml");
		File file = new File(url.getPath());
		
		document = documentBuilder.parse(file);
		String packageName = getRoot().getNodeName();
		String prefix = packageName.toLowerCase();
		String nsURI = "http://" + packageName + "/1.0";
		ePackage.setName(packageName);
		ePackage.setNsPrefix(prefix);
		ePackage.setNsURI(nsURI);
		NodeList childNodes = getRoot().getChildNodes();
		for (int i=0; i<childNodes.getLength(); i++) {
			Object o = childNodes.item(i);
			if (o instanceof Element) {
				createEClass((Element) o);
			}
		}
		
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		Resource resource = resourceSet.createResource(URI.createFileURI(new File("library.ecore").getAbsolutePath()));
		resource.getContents().add(ePackage);
		System.out.println(resourceSet.getPackageRegistry().toString());
		System.out.println(EPackage.Registry.INSTANCE.toString());
		resource.save(null);	
	}
	
	public static void main(String[] args) throws IOException {
		new XML2Ecore().test();
	}
	
	public void test() throws IOException {
		EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
		ePackage.setName("MyEPackage");
		ePackage.setNsPrefix("myep");
		ePackage.setNsURI("http://myEPackage/1");
		
		EClass class1 = EcoreFactory.eINSTANCE.createEClass();
		class1.setName("Class1");
		ePackage.getEClassifiers().add(class1);
		
		EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
		attribute.setName("myAttr");
		attribute.setEType(EcorePackage.eINSTANCE.getEString());
		
		class1.getEStructuralFeatures().add(attribute);
		
		EClass class2 = EcoreFactory.eINSTANCE.createEClass();
		class2.setName("Class2");
		
		EReference ref = EcoreFactory.eINSTANCE.createEReference();
		ref.setName("classtwos");
		ref.setLowerBound(0);
		ref.setUpperBound(EStructuralFeature.UNBOUNDED_MULTIPLICITY);
		ref.setEType(class2);
		
		//ePackage.getEClassifiers().add(class1);
		ePackage.getEClassifiers().add(class2);
		
		class1.getEStructuralFeatures().add(ref);
		
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		Resource resource = resourceSet.createResource(URI.createFileURI(new File("test.ecore").getAbsolutePath()));
		resource.getContents().add(ePackage);
		System.out.println(resourceSet.getPackageRegistry().toString());
		System.out.println(EPackage.Registry.INSTANCE.toString());
		resource.save(null);	

	}


}
