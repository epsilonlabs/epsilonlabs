package org.eclipse.epsilon.emc.emf;

import java.util.ArrayList;

import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.impl.XMILoadImpl;
import org.eclipse.epsilon.eol.analysis.optimisation.loading.context.ModelContainer;
import org.xml.sax.helpers.DefaultHandler;

public class SmartXMILoadImpl extends XMILoadImpl{
	protected ArrayList<ModelContainer> modelContainers = new ArrayList<ModelContainer>(); // <-------------------- point of change

	public void addModelContainer(ModelContainer modelContainer) // <-------------------- point of change
	{
		modelContainers.add(modelContainer);
	}
	
	public void setModelContainers(ArrayList<ModelContainer> modelContainers) { // <-------------------- point of change
		this.modelContainers = modelContainers;
	}
	public SmartXMILoadImpl(XMLHelper helper) {
		super(helper);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected DefaultHandler makeDefaultHandler() {
		SmartSAXXMIHandler handler = new SmartSAXXMIHandler(resource, helper, options); // <-------------------- point of change
		handler.setModelContainers(modelContainers); // <-------------------- point of change
		return handler; // <-------------------- point of change
		
	}

}
