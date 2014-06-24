package metamodel.connectivity.plainxml;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XML2Ecore {
	//this class should work fine!!! NOW!!!
	
	
	
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
		
		EClass cls = getEClass(className);//get class, if exist, retrieve from epackage, if not, create one and put into epackage
		NamedNodeMap attrs = element.getAttributes(); //get the attributes of the node
		HashMap<String, EAttribute> attributeMap = new HashMap<String, EAttribute>(); //initialise attribute map
		for(int i = 0; i < attrs.getLength(); i++) //for each attribute
		{
			String attrName = attrs.item(i).getNodeName(); //get the attr name
			EAttribute attr = getEAttribute(className, attrName); //retrieve attr if exist, if not create one
			if (attributeMap.containsKey(attrName)) { //if attribute already exists set upper bound to unlimited
				attr.setUpperBound(EStructuralFeature.UNBOUNDED_MULTIPLICITY);
			}
			else {
				attributeMap.put(attrName, attr); 
			}
		}
		HashMap<String, EReference> referenceMap = new HashMap<String, EReference>(); //initialise reference map
		NodeList children = element.getChildNodes(); //get the child nodes of the node
		for (int i=0; i<children.getLength(); i++) { //for each node
			Object o = children.item(i); //get object
			if (o instanceof Element) { //if object is an element
				if (isComplexElement((Element) o)) { //if is complex element
					EClass referenceNode = createEClass((Element) o); // create reference node
					EReference reference = getEReference(className, referenceNode); //get eRef if exist, if not create one
					if (referenceMap.containsKey(reference.getName())) { // if reference map contains key
						if (reference.getUpperBound() == EStructuralFeature.UNBOUNDED_MULTIPLICITY) {
							
						}
						else {
							reference.setUpperBound(EStructuralFeature.UNBOUNDED_MULTIPLICITY);	 //set upperbound to be multiple
						}
					}
					else {
						referenceMap.put(reference.getName(), reference); //put reference in the map
					}
				}
				else { //if is not complex element
					String attrName = ((Element)o).getNodeName(); //get attr name
					EAttribute attr = getEAttribute(className, attrName); //get attr if exists, if not create one
					if (attributeMap.containsKey(attrName)) { 
						attr.setUpperBound(EStructuralFeature.UNBOUNDED_MULTIPLICITY); //if exists set upperbound to be multiple

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
			//result = metaClassMap.get(name);
			result = (EClass) ePackage.getEClassifier(name);
		}
		else {
			result = factory.createEClass();
			result.setName(name);
			metaClassMap.put(name, result);
			ePackage.getEClassifiers().add(result);
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
	

//	public void testParse() throws ParserConfigurationException, SAXException, IOException
//	{
//		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
//		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
//
//		URL url = getClass().getResource("library.xml");
//		File file = new File(url.getPath());
//		
//		document = documentBuilder.parse(file);
//		String packageName = getRoot().getNodeName();
//		String prefix = packageName.toLowerCase();
//		String nsURI = "http://" + packageName + "/1.0";
//		ePackage.setName(packageName);
//		ePackage.setNsPrefix(prefix);
//		ePackage.setNsURI(nsURI);
//		NodeList childNodes = getRoot().getChildNodes();
//		for (int i=0; i<childNodes.getLength(); i++) {
//			Object o = childNodes.item(i);
//			if (o instanceof Element) {
//				createEClass((Element) o);
//			}
//		}
//		
//		ResourceSet resourceSet = new ResourceSetImpl();
//		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
//		Resource resource = resourceSet.createResource(URI.createFileURI(new File("library.ecore").getAbsolutePath()));
//		resource.getContents().add(ePackage);
//		System.out.println(resourceSet.getPackageRegistry().toString());
//		System.out.println(EPackage.Registry.INSTANCE.toString());
//		resource.save(null);	
//	}
	
//	public static void main(String[] args) throws IOException {
//		new XML2Ecore().test();
//	}
//	
//	public void test() throws IOException {
//		EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
//		ePackage.setName("MyEPackage");
//		ePackage.setNsPrefix("myep");
//		ePackage.setNsURI("http://myEPackage/1");
//		
//		EClass class1 = EcoreFactory.eINSTANCE.createEClass();
//		class1.setName("Class1");
//		ePackage.getEClassifiers().add(class1);
//		
//		EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
//		attribute.setName("myAttr");
//		attribute.setEType(EcorePackage.eINSTANCE.getEString());
//		
//		class1.getEStructuralFeatures().add(attribute);
//		
//		EClass class2 = EcoreFactory.eINSTANCE.createEClass();
//		class2.setName("Class2");
//		
//		EReference ref = EcoreFactory.eINSTANCE.createEReference();
//		ref.setName("classtwos");
//		ref.setLowerBound(0);
//		ref.setUpperBound(EStructuralFeature.UNBOUNDED_MULTIPLICITY);
//		ref.setEType(class2);
//		
//		//ePackage.getEClassifiers().add(class1);
//		ePackage.getEClassifiers().add(class2);
//		
//		class1.getEStructuralFeatures().add(ref);
//		
//		ResourceSet resourceSet = new ResourceSetImpl();
//		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
//		Resource resource = resourceSet.createResource(URI.createFileURI(new File("test.ecore").getAbsolutePath()));
//		resource.getContents().add(ePackage);
//		System.out.println(resourceSet.getPackageRegistry().toString());
//		System.out.println(EPackage.Registry.INSTANCE.toString());
//		resource.save(null);	
//
//	}


}
