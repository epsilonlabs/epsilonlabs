package org.eclipse.epsilon.emc.emf;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.impl.XMILoadImpl;
import org.eclipse.epsilon.eol.analysis.optimisation.loading.context.ModelContainer;
import org.xml.sax.helpers.DefaultHandler;

public class SmartXMILoadImpl extends XMILoadImpl{
//	protected ArrayList<ModelContainer> modelContainers = new ArrayList<ModelContainer>(); // <-------------------- point of change
//
//	public void addModelContainer(ModelContainer modelContainer) // <-------------------- point of change
//	{
//		modelContainers.add(modelContainer);
//	}
//	
//	public void setModelContainers(ArrayList<ModelContainer> modelContainers) { // <-------------------- point of change
//		this.modelContainers = modelContainers;
//	}
	
	protected HashMap<String, ArrayList<String>> objectsToLoad = new HashMap<String, ArrayList<String>>();
	protected HashMap<String, ArrayList<String>> emptyObjectsToLoad = new HashMap<String, ArrayList<String>>();

	public void setObjectsToLoad(
			HashMap<String, ArrayList<String>> objectsToLoad) {
		this.objectsToLoad = objectsToLoad;
	}
	
	public void setEmptyObjectsToLoad(
			HashMap<String, ArrayList<String>> emptyObjectsToLoad) {
		this.emptyObjectsToLoad = emptyObjectsToLoad;
	}
	
	public SmartXMILoadImpl(XMLHelper helper) {
		super(helper);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected DefaultHandler makeDefaultHandler() {
		SmartSAXXMIHandler handler = new SmartSAXXMIHandler(resource, helper, options); // <-------------------- point of change
		//handler.setModelContainers(modelContainers); // <-------------------- point of change
		handler.setObjectsToLoad(objectsToLoad);
		handler.setEmptyObjectsToLoad(emptyObjectsToLoad);
		return handler; // <-------------------- point of change
		
	}

}