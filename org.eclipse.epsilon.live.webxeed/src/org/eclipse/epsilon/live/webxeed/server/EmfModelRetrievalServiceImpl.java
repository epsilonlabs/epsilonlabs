package org.eclipse.epsilon.live.webxeed.server;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.epsilon.dt.exeed.EObjectImageTextProvider;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.live.webxeed.client.EmfModelRetrievalService;
import org.eclipse.epsilon.live.webxeed.shared.WAttributeSlot;
import org.eclipse.epsilon.live.webxeed.shared.WObject;
import org.eclipse.epsilon.live.webxeed.shared.WReferenceSlot;
import org.eclipse.epsilon.live.webxeed.shared.WSlot;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class EmfModelRetrievalServiceImpl extends RemoteServiceServlet implements EmfModelRetrievalService {
	
	protected HashMap<EObject, WObject> cache = new HashMap<EObject, WObject>();
	protected EObjectImageTextProvider imageTextProvider = null;
	
	@Override
	public WObject getEmfModel(String modelUrl, String metamodelUrl) {
		
		try {
			Resource resource = new RemoteModelLoader().load(modelUrl, metamodelUrl);
			imageTextProvider = new EObjectImageTextProvider(new InMemoryEmfModel(resource), System.out, System.err, false) {
				
				@Override
				protected void logException(Exception ex) {
					
				}
			};
			
			return createWObject(resource.getContents().get(0));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	protected WObject createWObject(EObject o) {
		if (cache.containsKey(o)) {
			return cache.get(o);
		}
		
		WObject wObject = new WObject();
		cache.put(o, wObject);
		wObject.setTypeName(o.eClass().getName());
		wObject.setLabel(imageTextProvider.getEObjectLabel(o, o.eClass().getName(), false));
		wObject.setReferenceLabel(imageTextProvider.getEObjectReferenceLabel(o, wObject.getLabel()));
		wObject.setIcon(imageTextProvider.getEObjectImage(o, "object"));
		
		for (EStructuralFeature sf : o.eClass().getEAllStructuralFeatures()) {
			WSlot wSlot = null;
			
			if (sf instanceof EReference) {
				EReference eReference = (EReference) sf;
				wSlot = new WReferenceSlot();
				WReferenceSlot wReferenceSlot = (WReferenceSlot) wSlot;
				wReferenceSlot.setContainment(eReference.isContainment());
				
				if (eReference.isMany()) {
					for (Object value : (Collection<?>) o.eGet(eReference)) {
						wReferenceSlot.getValues().add(createWObject((EObject) value));
					}
					
				}
				else if (o.eIsSet(eReference)){
					wReferenceSlot.getValues().add(createWObject((EObject)o.eGet(eReference)));
				}
			}
			else {
				EAttribute eAttribute = (EAttribute) sf;
				wSlot = new WAttributeSlot();
				WAttributeSlot wAttributeSlot = (WAttributeSlot) wSlot;
				
				if (eAttribute.isMany()) {
					for (Object value : (Collection<?>) o.eGet(eAttribute)) {
						wAttributeSlot.getValues().add(value+"");
					}
				}
				else {
					wAttributeSlot.getValues().add(o.eGet(eAttribute) + "");
				}
			}
			wSlot.setName(sf.getName());
			wObject.getSlots().add(wSlot);
		}
		
		return wObject;
		
	}
	
}
