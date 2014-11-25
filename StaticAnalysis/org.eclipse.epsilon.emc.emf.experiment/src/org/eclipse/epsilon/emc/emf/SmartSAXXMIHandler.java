package org.eclipse.epsilon.emc.emf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.SAXXMIHandler;
import org.eclipse.epsilon.eol.analysis.optimisation.loading.context.ModelContainer;
import org.eclipse.epsilon.eol.analysis.optimisation.loading.context.ModelElementContainer;
import org.eclipse.epsilon.eol.parse.Eol_EolParserRules.elseStatement_return;
import org.eclipse.epsilon.eol.parse.Eol_EolParserRules.returnStatement_return;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class SmartSAXXMIHandler extends SAXXMIHandler{
	
	protected ArrayList<ModelContainer> modelContainers = new ArrayList<ModelContainer>(); // <-------------------- point of change

//	protected ArrayList<String> elementStack = new ArrayList<String>();
//	
//	protected ArrayList<EObject> recordedElements = new ArrayList<EObject>();
//	
//	protected EObject recordedElement;
	protected int callCount = 0;
//	
//	protected boolean shouldStartProcessing;
//	protected boolean shouldHold = false;
	
	protected ArrayList<EClass> load_ref_only_classes = new ArrayList<EClass>();
	
	public SmartSAXXMIHandler(XMLResource xmiResource, XMLHelper helper,
			Map<?, ?> options) {
		super(xmiResource, helper, options);
	}
	
	public void addModelContainer(ModelContainer modelContainer)
	{
		modelContainers.add(modelContainer);
	}
	
	public void setModelContainers(ArrayList<ModelContainer> modelContainers) {
		this.modelContainers = modelContainers;
	}

//	@Override
//	public void startElement(String uri, String localName, String name,
//			Attributes attributes) throws SAXException {
//		EFactory eFactory = getFactoryForPrefix(uri);
//		System.out.println(eFactory);
//		if (objects.size() != 0) {
//			EClass eClass = objects.peekEObject().eClass();
//			System.out.println(eClass);
//		}
//		
//		if (documentRoot != null)
//	    {
//	      EObject eObject = objects.peekEObject();
//	      if (eObject == documentRoot && (extendedMetaData == null || extendedMetaData.isDocumentRoot(eObject.eClass())))
//	      {
//	        types.pop();
//	        objects.pop();
//	        mixedTargets.pop();
//	        documentRoot= null;
//	      }
//	    }
//		if (name.equals("xmi:XMI")) {
//			elementStack.add(name);
//			super.startElement(uri, localName, name, attributes);
//		}
//		else if (name.equals("ecore:Epackage")) {
//			elementStack.add(name);
//			super.startElement(uri, localName, name, attributes);
//		}
//		else if (isNeeded(name)) {
//			elementStack.add(name);
//			super.startElement(uri, localName, name, attributes);
//		}
//		else {
//			if(elementStack.size() > 0)
//			{
//				super.startElement(uri, localName, name, attributes);
//			}
//		}
//	}
//	
//	
//	
//	@Override
//	public void endElement(String uri, String localName, String name) {
//		int size = elementStack.size();
//		if (size > 0) {
//			super.endElement(uri, localName, name);
//			if (name.equals(elementStack.get(size-1))) {
//				elementStack.remove(size-1);
//			}
//		}
//	}
	

//	@Override
//	protected void createObject(EObject peekObject, EStructuralFeature feature) {
//		String id = attribs.getValue("xmi:idref");
//	    if (id != null)
//	    {
//	      EReference eReference = (EReference)feature;
//	      if (!eReference.isContainment())
//	      {
//	        setValueFromId(peekObject, eReference, id);
//	        objects.push(null);
//	        mixedTargets.push(null);
//	        types.push(OBJECT_TYPE);
//	        return;
//	      }
//	    }
//	    
//		if (isNull()) {
//			setFeatureValue(peekObject, feature, null);
//			objects.push(null);
//			mixedTargets.push(null);
//			types.push(OBJECT_TYPE);
//		}
//	    else
//	    {
//	    	MyEObjectStack stack = objects;
//	    	int size = stack.size();
//	    	String xsiType = getXSIType();
//	    	
////	    	ArrayList<EObject> temp = (ArrayList<EObject>) recordedElements.clone();
////	    	for(EObject eObj: temp)
////	    	{
////	    		if (!objects.contains(eObj)) {
////					recordedElements.remove(eObj);
////				}
////	    	}
////	    	
////	    	if (recordedElements.size() == 0 && shouldStartProcessing) {
////	    		shouldHold = true;
////			}
//	    	 if (xsiType != null)
//	    	 {
//	    		 if (isNeeded(xsiType)) {
////	    			 EObject peekBefore = peekObject;
//	    			 createObjectFromTypeName(peekObject, xsiType, feature);
////	    			 recordedElements.add(objects.peekEObject());
////	    			 shouldStartProcessing = true;
////	    			 EObject peekAfter = objects.peekEObject();
////	    			 System.out.println(peekBefore);
////	    			 System.out.println(peekAfter);
//				}
//		     }
//	    	 else
//	    	 {
//	    		 if (!shouldHold) {
//	    			 createObjectFromFeatureType(peekObject, feature);
//		    		 if (xmlMap != null && !((EReference)feature).isContainment())
//		    		 {
//		    			 XMLResource.XMLInfo info = xmlMap.getInfo(feature);
//		    			 if (info != null && info.getXMLRepresentation() == XMLResource.XMLInfo.ELEMENT)
//		    			 {
//		    				 text = new StringBuffer();
//		    			 }
//		    		 }
//				}
//		      }
//	    }
//		
//	}
	
	@Override
	protected void validateCreateObjectFromFactory(EFactory factory,
			String typeName, EObject newObject) {
		// TODO Auto-generated method stub
		if (isNeeded(typeName, factory)) {
			super.validateCreateObjectFromFactory(factory, typeName, newObject);	
		}
		
	}
	
	@Override
	protected EObject createObjectFromFactory(EFactory factory, String typeName) {
		if (isNeeded(typeName, factory)) {
		    EObject newObject = null;

		    if (factory != null)
		    {
		      newObject = helper.createObject(factory, typeName);

		      if (newObject != null)
		      {
		        if (disableNotify)
		          newObject.eSetDeliver(false);

		        handleObjectAttribs(newObject);
		      }
		    }

		    return newObject;
		}
		else {
			if (isNeededOnlyForReference(typeName, factory)) {
			    EObject newObject = null;

			    if (factory != null)
			    {
			      newObject = helper.createObject(factory, typeName);

			      if (newObject != null)
			      {
			        if (disableNotify)
			          newObject.eSetDeliver(false);
			      }
			    }

			    return newObject;

			}
		}
		
		return null;
	}
	
	
	@Override
	public void endDocument() {
	    if (deferredExtent != null)
	    {
	      extent.addAll(deferredExtent);
	    }

	    // Pretend there is an xmlns="" because we really need to ensure that the null prefix
	    // isn't used to denote something other than the null namespace.
	    //
	    if (usedNullNamespacePackage)
	    {
	      helper.addPrefix("", "");
	    }
	    helper.recordPrefixToURIMapping();
	    helper.popContext();
	    //handleForwardReferences(true);

	    if (disableNotify)
	    {
	      for (Iterator<?> i = EcoreUtil.getAllContents(xmlResource.getContents(), false); i.hasNext(); )
	      {
	        EObject eObject = (EObject)i.next();
	        eObject.eSetDeliver(true);
	      }
	    }

	    if (extendedMetaData != null)
	    {
	      if (extent.size() == 1)
	      {
	        EObject root = extent.get(0);
	        recordNamespacesSchemaLocations(root);
	      }

	      if (DEBUG_DEMANDED_PACKAGES)
	      {
	        // EATM temporary for debug purposes only.
	        //
	        Collection<EPackage> demandedPackages = EcoreUtil.copyAll(extendedMetaData.demandedPackages());
	        for (EPackage ePackage : demandedPackages)
	        {
	          ePackage.setName(ePackage.getNsURI());
	        }
	        extent.addAll(demandedPackages);
	      }
	    }

	    System.err.println(callCount);
	}
	
	
	public boolean isNeededOnlyForReference(String name, EFactory factory)
	{
		
		EClass actual = (EClass) factory.getEPackage().getEClassifier(name);

		if (load_ref_only_classes.contains(actual)) {
			return true;
		}
		else {
			for(EReference eRef: actual.getEAllReferences())
			{
				EClass eType = (EClass) eRef.getEType();
				EFactory eFactory = eType.getEPackage().getEFactoryInstance();
				if (isNeeded(eType.getName(), eFactory)) {
					load_ref_only_classes.add(actual);
					return true;
				}
				if(isNeededOnlyForReference(eType.getName(), eFactory))
				{
					return true;
				}
			}
			return false;
		}
	}
	
	public boolean isNeeded(String name, EFactory factory)
	{
		String localName = name;
		int index = name.indexOf(':', 0);
		if (index != -1) {
			localName = name.substring(index+1);
		}

		for(ModelContainer mc: modelContainers)
		{
			if (!factory.getEPackage().getName().equals(mc.getModelName())) {
				continue;
			}
			for(ModelElementContainer mec: mc.getModelElementsAllOfKind())
			{
				String elementName = mec.getElementName();
				if (localName.equals(elementName)) {
					return true;
				}
				
				EClass kind = (EClass) factory.getEPackage().getEClassifier(elementName);
				EClass actual = (EClass) factory.getEPackage().getEClassifier(localName);
				if (actual.getEAllSuperTypes().contains(kind)) {
					return true;
				}

			}
			
			for(ModelElementContainer mec: mc.getModelElementsAllOfType())
			{
				String elementName = mec.getElementName();
				if (localName.equals(elementName)) {
					return true;
				}
			}
		}
		return false;
	}



}
