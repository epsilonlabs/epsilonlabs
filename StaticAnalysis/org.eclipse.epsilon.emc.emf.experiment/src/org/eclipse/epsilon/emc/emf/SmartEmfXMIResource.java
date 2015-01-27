package org.eclipse.epsilon.emc.emf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.xmi.XMLLoad;
import org.eclipse.emf.ecore.xmi.impl.XMLHelperImpl;

public class SmartEmfXMIResource extends EmfXMIResource{

	public boolean loadAllAttributes = true;

//	protected HashMap<String, ArrayList<String>> objectsToLoad = new HashMap<String, ArrayList<String>>();
//	protected HashMap<String, ArrayList<String>> emptyObjectsToLoad = new HashMap<String, ArrayList<String>>();
	protected HashMap<String, HashMap<String, ArrayList<String>>> objectsAndRefNamesToVisit = new HashMap<String, HashMap<String,ArrayList<String>>>();
	protected HashMap<String, HashMap<String, ArrayList<String>>> actualObjectsToLoad = new HashMap<String, HashMap<String,ArrayList<String>>>();

	protected boolean handleFlatObjects = false;
	
	@Override
	public void load(Map<?, ?> options) throws IOException {
		// TODO Auto-generated method stub
		super.load(options);
	}
	
//	public void setObjectsToLoad(
//			HashMap<String, ArrayList<String>> objectsToLoad) {
//		this.objectsToLoad = objectsToLoad;
//	}
//	
//	public void setEmptyObjectsToLoad(
//			HashMap<String, ArrayList<String>> emptyObjectsToLoad) {
//		this.emptyObjectsToLoad = emptyObjectsToLoad;
//	}
	
	public void setObjectsAndRefNamesToVisit(
			HashMap<String, HashMap<String, ArrayList<String>>> objectsAndRefNamesToVisit) {
		this.objectsAndRefNamesToVisit = objectsAndRefNamesToVisit;
	}
	
	public void setActualObjectsToLoad(
			HashMap<String, HashMap<String, ArrayList<String>>> actualObjectsToLoad) {
		this.actualObjectsToLoad = actualObjectsToLoad;
	}
	
//	protected ArrayList<ModelContainer> modelContainers = new ArrayList<ModelContainer>(); // <-------------------- point of change
//
//	public void addModelContainer(ModelContainer modelContainer)
//	{
//		modelContainers.add(modelContainer);
//	}
//	
//	public void setModelContainers(ArrayList<ModelContainer> modelContainers) {
//		this.modelContainers = modelContainers;
//	}

	public SmartEmfXMIResource(URI uri) {
		super(uri);
	}
	
	public void setLoadAllAttributes(boolean loadAllAttributes) {
		this.loadAllAttributes = loadAllAttributes;
	}

	@Override
	protected XMLLoad createXMLLoad() {
		SmartXMILoadImpl xmiLoadImpl = new SmartXMILoadImpl(createXMLHelper());
		xmiLoadImpl.setLoadAllAttributes(loadAllAttributes);
//		xmiLoadImpl.setModelContainers(modelContainers);
//		xmiLoadImpl.setEmptyObjectsToLoad(emptyObjectsToLoad);
//		xmiLoadImpl.setObjectsToLoad(objectsToLoad);
		xmiLoadImpl.setObjectsAndRefNamesToVisit(objectsAndRefNamesToVisit);
		xmiLoadImpl.setActualObjectsToLoad(actualObjectsToLoad);
		return xmiLoadImpl; // <----------------------- point of change
	}
	
	@Override
	protected XMLLoad createXMLLoad(Map<?, ?> options) {
		if (options != null && Boolean.TRUE.equals(options.get(OPTION_SUPPRESS_XMI)))
	    {
			SmartXMILoadImpl xmiLoadImpl = new SmartXMILoadImpl(new XMLHelperImpl(this));
			xmiLoadImpl.setLoadAllAttributes(loadAllAttributes);
			xmiLoadImpl.setObjectsAndRefNamesToVisit(objectsAndRefNamesToVisit);
			xmiLoadImpl.setActualObjectsToLoad(actualObjectsToLoad);
//			xmiLoadImpl.setModelContainers(modelContainers);
//			xmiLoadImpl.setEmptyObjectsToLoad(emptyObjectsToLoad);
//			xmiLoadImpl.setObjectsToLoad(objectsToLoad);

			return xmiLoadImpl;
	    }
	    else
	    {
	      return createXMLLoad();
	    }
	}
	
	@Override
	public EObject getEObject(String uriFragment) {
		// TODO Auto-generated method stub
		return super.getEObject(uriFragment);
	}
	
	@Override
	protected EObject getEObject(List<String> uriFragmentPath) {
	    int size = uriFragmentPath.size();
	    EObject eObject = getEObjectForURIFragmentRootSegment(size == 0 ? "" : uriFragmentPath.get(0));
	    for (int i = 1; i < size; ++i)
	    {
	    	if (eObject == null) {
				if (handleFlatObjects) {
					List<EObject> contents = getContents();
					String name = uriFragmentPath.get(1);
					for(EObject obj: contents)
					{
//						System.out.println(obj.eClass().getEStructuralFeature("name"));
//						System.out.println(obj.eGet(obj.eClass().getEStructuralFeature("name")));
						if (obj.eGet(obj.eClass().getEStructuralFeature("name")) != null && obj.eGet(obj.eClass().getEStructuralFeature("name")).equals(name)) {
							eObject = obj;
						}
//						if (obj.eGet(obj.eClass().getEStructuralFeature("name")).equals(name)) {
//							
//						}
					}
				}
				else {
					return null;
				}
			}
	    	else{
	  	      eObject = ((InternalEObject)eObject).eObjectForURIFragmentSegment(uriFragmentPath.get(i));
			}
	    }
	    return eObject;
    }
	
	@Override
		protected EObject getEObjectForURIFragmentRootSegment(
				String uriFragmentRootSegment) {
		if (uriFragmentRootSegment.equals("")) {
			handleFlatObjects = true;
			return null;
		}
	    int position =  0;
	    if (uriFragmentRootSegment.length() > 0)
	    {
	      try
	      {
	        position = Integer.parseInt(uriFragmentRootSegment);
	      }
	      catch (NumberFormatException exception)
	      {
	        throw new WrappedException(exception);
	      }
	    }

	    List<EObject> contents = getContents();
	    if (position < contents.size() && position >= 0)
	    {
	      return contents.get(position);
	    }
	    else
	    {
	      return null;
	    }
	  }
	
}
