package org.eclipse.epsilon.emc.emf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.xml.stream.events.EndDocument;

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
import org.eclipse.emf.ecore.xmi.FeatureNotFoundException;
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
	
//	protected ArrayList<ModelContainer> modelContainers = new ArrayList<ModelContainer>(); // <-------------------- point of change

	protected HashMap<String, ArrayList<String>> objectsToLoad = new HashMap<String, ArrayList<String>>();
	protected HashMap<String, ArrayList<String>> emptyObjectsToLoad = new HashMap<String, ArrayList<String>>();
	protected int callCount = 0;
	protected boolean shouldHalt = false;
	protected String currentName = "";
	protected int currentElementsSize = -1;
	
	public void setObjectsToLoad(
			HashMap<String, ArrayList<String>> objectsToLoad) {
		this.objectsToLoad = objectsToLoad;
	}
	
	public void setEmptyObjectsToLoad(
			HashMap<String, ArrayList<String>> emptyObjectsToLoad) {
		this.emptyObjectsToLoad = emptyObjectsToLoad;
	}
	
	public SmartSAXXMIHandler(XMLResource xmiResource, XMLHelper helper,
			Map<?, ?> options) {
		super(xmiResource, helper, options);
	}
	
//	public void addModelContainer(ModelContainer modelContainer)
//	{
//		
//		modelContainers.add(modelContainer);
//	}
	
//	public void setModelContainers(ArrayList<ModelContainer> modelContainers) {
//		this.modelContainers = modelContainers;
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
		protected void setAttribValue(EObject object, String name, String value) {
			// TODO Auto-generated method stub
			return;
		}
	
//	@Override
//	protected void setFeatureValue(EObject object, EStructuralFeature feature,
//			Object value, int position) {
//		// TODO Auto-generated method stub
//		if (feature instanceof EReference) {
//			EReference ref = (EReference) feature;
//			EClass eType = (EClass) ref.getEType();
//			String eTypePack = eType.getEPackage().getName();
//			String eTypeName = eType.getName();
//			if (isNeeded(eTypePack, eTypeName) || isNeededOnlyForReference(eTypePack, eTypeName)) {
//				super.setFeatureValue(object, feature, value);
//			}
//		}
//	}
	
	@Override
	protected void setFeatureValue(EObject object, EStructuralFeature feature,
			Object value) {
		// TODO Auto-generated method stub
//		String packageName = object.eClass().getEPackage().getName();
//		String eclassName = object.eClass().getName();
		
		if (feature instanceof EReference) {
			EReference ref = (EReference) feature;
			EClass eType = (EClass) ref.getEType();
			String eTypePack = eType.getEPackage().getName();
			String eTypeName = eType.getName();
			if (isNeeded(eTypePack, eTypeName) || isNeededOnlyForReference(eTypePack, eTypeName)) {
				super.setFeatureValue(object, feature, value);
			}
		}
		
		
//		if (isNeeded(packageName, eclassName)) {
//			super.setFeatureValue(object, feature, value);
//		}
//		else if (isNeededOnlyForReference(packageName, eclassName)) {
//
//			if (feature instanceof EReference) {
//				EReference ref = (EReference) feature;
//				EClass eType = (EClass) ref.getEType();
//				String eTypePack = eType.getEPackage().getName();
//				String eTypeName = eType.getName();
//				if (isNeeded(eTypePack, eTypeName) || isNeededOnlyForReference(eTypePack, eTypeName)) {
//					super.setFeatureValue(object, feature, value);
//				}
////				else {
////					System.out.println(eTypePack+ ":" +eTypeName + "-" + feature.getName());
////				}
//			}
////			else
////			{
////				System.out.println(feature.getName());
////			}
//		
//		} 
//		else
//		{
//			System.out.println(packageName + ":" + eclassName);
//		}
	}
	
	@Override
	protected void validateCreateObjectFromFactory(EFactory factory,
			String typeName, EObject newObject) {
		// TODO Auto-generated method stub
		if (factory != null) {
			String epack = factory.getEPackage().getName();

			if (isNeeded(epack, typeName) || isNeededOnlyForReference(epack, typeName)) {
				super.validateCreateObjectFromFactory(factory, typeName, newObject);	
			}
		}
		else {
			super.validateCreateObjectFromFactory(factory, typeName, newObject);
		}
		
	}
	
	@Override
	protected EObject createObjectFromFactory(EFactory factory, String typeName) {
		if (factory != null) {
			callCount++;
			String epack = factory.getEPackage().getName();
			
			if (isNeeded(epack, typeName) || isNeededOnlyForReference(epack, typeName)) {
				return super.createObjectFromFactory(factory, typeName);
			}
			else {
				return null;
			}
		}
		else
		{
			return super.createObjectFromFactory(factory, typeName);
		}
		
		
	}
	
	
	public boolean isNeededOnlyForReference(String packageName, String className)
	{
		if (emptyObjectsToLoad.get(packageName) == null) {
			return false;
		}
		else {
			return emptyObjectsToLoad.get(packageName).contains(className);
		}
	}
	
	public boolean isNeeded(String packageName, String className)
	{
		if (objectsToLoad.get(packageName) == null) {
			return false;
		}
		else {
			return objectsToLoad.get(packageName).contains(className);
		}
	}
	
//	public boolean isNeededOnlyForReference(String name, EFactory factory)
//	{
//		for(ModelContainer mc: modelContainers)
//		{
//			if (factory.getEPackage().getName().equals(mc.getModelName())) {
//				for(String element: mc.getEmptyElements())
//				{
//					if (name.equals(element)) {
//						return true;
//					}
//
//					EClass kind = (EClass) factory.getEPackage().getEClassifier(element);
//					EClass actual = (EClass) factory.getEPackage().getEClassifier(name);
//					for(EClass superClass: actual.getEAllSuperTypes())
//					{
//						if (kind.getName().equals(superClass.getName())) {
//							return true;
//						}
//					}
//
//				}
//			}
//		}
//		return false;
//	}
	
//	public boolean isNeeded(String name, EFactory factory)
//	{
//
//		for(ModelContainer mc: modelContainers)
//		{
//			if (factory.getEPackage().getName().equals(mc.getModelName())) {
//				for(ModelElementContainer mec: mc.getModelElementsAllOfKind())
//				{
//					String elementName = mec.getElementName();
//					if (name.equals(elementName)) {
//						return true;
//					}
//					
//					EClass kind = (EClass) factory.getEPackage().getEClassifier(elementName);
//					EClass actual = (EClass) factory.getEPackage().getEClassifier(name);
//					for(EClass superClass: actual.getEAllSuperTypes())
//					{
//						if (kind.getName().equals(superClass.getName())) {
//							return true;
//						}
//					}
//
//				}
//				
//				for(ModelElementContainer mec: mc.getModelElementsAllOfType())
//				{
//					String elementName = mec.getElementName();
//					if (name.equals(elementName)) {
//						return true;
//					}
//				}
//			}
//		}
//		return false;
//	}

	@Override
	public void endDocument() {
		System.err.println(callCount);

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
//	    handleForwardReferences(true);

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
	  
	}
	
//	public boolean isNeeded(String prefix, String name)
//	{
////		String localName = name;
////		int index = name.indexOf(':', 0);
////		if (index != -1) {
////			localName = name.substring(index+1);
////		}
//
//		for(ModelContainer mc: modelContainers)
//		{
//			if (prefix.equalsIgnoreCase(mc.getModelName())) {
//				for(ModelElementContainer mec: mc.getModelElementsAllOfKind())
//				{
//					String elementName = mec.getElementName();
//					if (name.equals(elementName)) {
//						return true;
//					}
//					
//				}
//				
//				for(ModelElementContainer mec: mc.getModelElementsAllOfType())
//				{
//					String elementName = mec.getElementName();
//					if (name.equals(elementName)) {
//						return true;
//					}
//				}
//			}
//		}
//		return false;
//	}

	
//	@Override 
//	protected void createTopObject(String prefix, String name) {
//		// TODO Auto-generated method stub
//		if (prefix.equals("ecore") || isNeeded(prefix, name)) {
//			super.createTopObject(prefix, name);	
//		}
//		
//	}
	
	
//	
//	@Override
//	public void endElement(String uri, String localName, String name) {
//		callCount ++;
//		// TODO Auto-generated method stub
//		
//		if (shouldHalt && currentElementsSize != -1) {
//			if (elements.size() >= currentElementsSize) {
//				if (name.equals(currentName) && elements.size() == currentElementsSize) {
//					shouldHalt = false;
//					elements.pop();	
//				}
//				else {
//					elements.pop();	
//				}
//			}
//			else
//			{
//				shouldHalt = false;	
//				//super.endElement(uri, localName, name);	
//			}
//		}
//		else
//		{
//			super.endElement(uri, localName, name);	
//		}
//	}
//	
//	public void halt(String name)
//	{
//		currentElementsSize = elements.size();
//		currentName = name;
//		shouldHalt = true;
//	}
	
	/*
	@Override
	protected void handleFeature(String prefix, String name) {

		if (shouldHalt) {
			return;
		}
	    EObject peekObject = objects.peekEObject();
	    if (peekObject == null)
	    {
	      types.push(ERROR_TYPE);
	      error
	        (new FeatureNotFoundException
	          (name,
	           null,
	           getLocation(),
	           getLineNumber(),
	           getColumnNumber()));
	      return;
	    }

	    if (peekObject instanceof DynamicEObjectImpl) {
	    	
	    	// This happens when processing an element with simple content that has elements content even though it shouldn't.
		    //
		    EStructuralFeature feature = getFeature(peekObject, prefix, name, true);

	    	DynamicEObjectImpl lePeekObject = (DynamicEObjectImpl) peekObject;
	    	
	    	if (isNeededOnlyForReference(lePeekObject.eClass().getName(), lePeekObject.eClass().getEPackage().getEFactoryInstance())) {
	    		if (feature != null)
			    {
	    			int kind = helper.getFeatureKind(feature);
	    			if (kind == XMLHelper.DATATYPE_SINGLE || kind == XMLHelper.DATATYPE_IS_MANY)
	    			{
	    				halt(name);
	    			}
	    			else if (extendedMetaData != null)
	    			{
				        EReference eReference = (EReference)feature;
				        if (eReference.getEType() instanceof EClass) {
					        EClass eType = (EClass) eReference.getEType();
					        if (isNeeded(eType.getName(), eType.getEPackage().getEFactoryInstance()) || isNeededOnlyForReference(eType.getName(), eType.getEPackage().getEFactoryInstance())) {
					        	boolean isContainment = eReference.isContainment();
						        if (!isContainment && !eReference.isResolveProxies() && extendedMetaData.getFeatureKind(feature) != ExtendedMetaData.UNSPECIFIED_FEATURE)
						        {
						        	isIDREF = true;
						        	objects.push(null);
						        	mixedTargets.push(null);
						        	types.push(feature);
						        	text = new StringBuffer();
						        }
						        else
						        {
						        	createObject(peekObject, feature);
						        	EObject childObject = objects.peekEObject();
						        	if (childObject != null)
						        	{
						        		if (isContainment)
						        		{
						        			EStructuralFeature simpleFeature = extendedMetaData.getSimpleFeature(childObject.eClass());
						        			if (simpleFeature != null)
						        			{
						        				isSimpleFeature = true;
						        				isIDREF = simpleFeature instanceof EReference;
						        				objects.push(null);
						        				mixedTargets.push(null);
						        				types.push(simpleFeature);
						        				text = new StringBuffer();
						        			}
						        		}
						        		else if (!childObject.eIsProxy())
						        		{
						        			text = new StringBuffer();
						        		}
						        	}
						        }
							}
					        else {
					        	halt(name);
							}
						}
	    			}
	    			else
	    			{
	    				EReference eReference = (EReference)feature;
				        if (eReference.getEType() instanceof EClass) {
					        EClass eType = (EClass) eReference.getEType();
					        if (isNeeded(eType.getName(), eType.getEPackage().getEFactoryInstance()) || isNeededOnlyForReference(eType.getName(), eType.getEPackage().getEFactoryInstance())) {
					        	createObject(peekObject, feature);
					        }
					        else {
					        	halt(name);
							}
				        }
	    			}
			    }
	    		else
			    {
			      // Try to get a general-content feature.
			      // Use a pattern that's not possible any other way.
			      //
			      if (xmlMap != null && (feature = getFeature(peekObject, null, "", true)) != null)
			      {

			        EFactory eFactory = getFactoryForPrefix(prefix);

			        // This is for the case for a local unqualified element that has been bound.
			        //
			        if (eFactory == null)
			        {
			          eFactory = feature.getEContainingClass().getEPackage().getEFactoryInstance();
			        }

			        EObject newObject = null;
			        if (useNewMethods)
			        {
			          newObject = createObject(eFactory, helper.getType(eFactory, name), false);
			        }
			        else
			        {
			            newObject = createObjectFromFactory(eFactory, name);
			        }
			        newObject = validateCreateObjectFromFactory(eFactory, name, newObject, feature);
			        if (newObject != null)
			        {
			          setFeatureValue(peekObject, feature, newObject);
			        }
			        processObject(newObject);
			      }
			      else
			      {
			        // This handles the case of a substitution group.
			        //
			        if (xmlMap != null)
			        {
			          EFactory eFactory = getFactoryForPrefix(prefix);
			          EObject newObject = createObjectFromFactory(eFactory, name);
			          validateCreateObjectFromFactory(eFactory, name, newObject);
			          if (newObject != null)
			          {
			            for (EReference eReference : peekObject.eClass().getEAllReferences())
			            {
			              if (eReference.getEType().isInstance(newObject))
			              {
			                setFeatureValue(peekObject, eReference, newObject);
			                processObject(newObject);
			                return;
			              }
			            }
			          }
			        }

			        handleUnknownFeature(prefix, name, true, peekObject, null);
			      }
			    }
			}
	    	else if (isNeeded(lePeekObject.eClass().getName(), lePeekObject.eClass().getEPackage().getEFactoryInstance())) {
				super.handleFeature(prefix, name);
			}
	    	else
	    	{
	    		halt(name);
//	    		objects.push(null);
//	        	mixedTargets.push(null);
//	        	types.push(OBJECT_TYPE);
//	        	text = null;
	    	}

		}
	    else {
			super.handleFeature(prefix, name);
		}
	    
	  
	}
	*/
//	@Override
//	protected void handleFeature(String prefix, String name) {
//
//		if (shouldHalt) {
//			return;
//		}
//	    EObject peekObject = objects.peekEObject();
//	    if (peekObject == null)
//	    {
//	      types.push(ERROR_TYPE);
//	      error
//	        (new FeatureNotFoundException
//	          (name,
//	           null,
//	           getLocation(),
//	           getLineNumber(),
//	           getColumnNumber()));
//	      return;
//	    }
//
//	    if (peekObject instanceof DynamicEObjectImpl) {
//	    	
//	    	// This happens when processing an element with simple content that has elements content even though it shouldn't.
//		    //
//		    EStructuralFeature feature = getFeature(peekObject, prefix, name, true);
//
//	    	DynamicEObjectImpl lePeekObject = (DynamicEObjectImpl) peekObject;
//	    	
//	    	if (isNeededOnlyForReference(lePeekObject.eClass().getName(), lePeekObject.eClass().getEPackage().getEFactoryInstance())) {
//	    		if (feature != null)
//			    {
//	    			int kind = helper.getFeatureKind(feature);
//	    			if (kind == XMLHelper.DATATYPE_SINGLE || kind == XMLHelper.DATATYPE_IS_MANY)
//	    			{
//	    				halt(name);
//	    			}
//	    			else if (extendedMetaData != null)
//	    			{
//				        EReference eReference = (EReference)feature;
//				        if (eReference.getEType() instanceof EClass) {
//					        EClass eType = (EClass) eReference.getEType();
//					        if (isNeeded(eType.getName(), eType.getEPackage().getEFactoryInstance()) || isNeededOnlyForReference(eType.getName(), eType.getEPackage().getEFactoryInstance())) {
//					        	boolean isContainment = eReference.isContainment();
//						        if (!isContainment && !eReference.isResolveProxies() && extendedMetaData.getFeatureKind(feature) != ExtendedMetaData.UNSPECIFIED_FEATURE)
//						        {
//						        	isIDREF = true;
//						        	objects.push(null);
//						        	mixedTargets.push(null);
//						        	types.push(feature);
//						        	text = new StringBuffer();
//						        }
//						        else
//						        {
//						        	createObject(peekObject, feature);
//						        	EObject childObject = objects.peekEObject();
//						        	if (childObject != null)
//						        	{
//						        		if (isContainment)
//						        		{
//						        			EStructuralFeature simpleFeature = extendedMetaData.getSimpleFeature(childObject.eClass());
//						        			if (simpleFeature != null)
//						        			{
//						        				isSimpleFeature = true;
//						        				isIDREF = simpleFeature instanceof EReference;
//						        				objects.push(null);
//						        				mixedTargets.push(null);
//						        				types.push(simpleFeature);
//						        				text = new StringBuffer();
//						        			}
//						        		}
//						        		else if (!childObject.eIsProxy())
//						        		{
//						        			text = new StringBuffer();
//						        		}
//						        	}
//						        }
//							}
//					        else {
//					        	halt(name);
//							}
//						}
//	    			}
//	    			else
//	    			{
//	    				EReference eReference = (EReference)feature;
//				        if (eReference.getEType() instanceof EClass) {
//					        EClass eType = (EClass) eReference.getEType();
//					        if (isNeeded(eType.getName(), eType.getEPackage().getEFactoryInstance()) || isNeededOnlyForReference(eType.getName(), eType.getEPackage().getEFactoryInstance())) {
//					        	createObject(peekObject, feature);
//					        }
//					        else {
//					        	halt(name);
//							}
//				        }
//	    			}
//			    }
//	    		else
//			    {
//			      // Try to get a general-content feature.
//			      // Use a pattern that's not possible any other way.
//			      //
//			      if (xmlMap != null && (feature = getFeature(peekObject, null, "", true)) != null)
//			      {
//
//			        EFactory eFactory = getFactoryForPrefix(prefix);
//
//			        // This is for the case for a local unqualified element that has been bound.
//			        //
//			        if (eFactory == null)
//			        {
//			          eFactory = feature.getEContainingClass().getEPackage().getEFactoryInstance();
//			        }
//
//			        EObject newObject = null;
//			        if (useNewMethods)
//			        {
//			          newObject = createObject(eFactory, helper.getType(eFactory, name), false);
//			        }
//			        else
//			        {
//			            newObject = createObjectFromFactory(eFactory, name);
//			        }
//			        newObject = validateCreateObjectFromFactory(eFactory, name, newObject, feature);
//			        if (newObject != null)
//			        {
//			          setFeatureValue(peekObject, feature, newObject);
//			        }
//			        processObject(newObject);
//			      }
//			      else
//			      {
//			        // This handles the case of a substitution group.
//			        //
//			        if (xmlMap != null)
//			        {
//			          EFactory eFactory = getFactoryForPrefix(prefix);
//			          EObject newObject = createObjectFromFactory(eFactory, name);
//			          validateCreateObjectFromFactory(eFactory, name, newObject);
//			          if (newObject != null)
//			          {
//			            for (EReference eReference : peekObject.eClass().getEAllReferences())
//			            {
//			              if (eReference.getEType().isInstance(newObject))
//			              {
//			                setFeatureValue(peekObject, eReference, newObject);
//			                processObject(newObject);
//			                return;
//			              }
//			            }
//			          }
//			        }
//
//			        handleUnknownFeature(prefix, name, true, peekObject, null);
//			      }
//			    }
//			}
//	    	else if (isNeeded(lePeekObject.eClass().getName(), lePeekObject.eClass().getEPackage().getEFactoryInstance())) {
//				super.handleFeature(prefix, name);
//			}
//	    	else
//	    	{
//	    		halt(name);
////	    		objects.push(null);
////	        	mixedTargets.push(null);
////	        	types.push(OBJECT_TYPE);
////	        	text = null;
//	    	}
//
//		}
//	    else {
//			super.handleFeature(prefix, name);
//		}
//	    
//	  
//	}


}
