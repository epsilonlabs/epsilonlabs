package org.eclipse.epsilon.xminus.loader;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class EReferenceValueSetter {
	
	public void setValue(EReference eReference, EObject eObject, String value, XminusResourceLoader context) {
		
		EClass proxyEClass = (EClass) eReference.getEType();
		if (proxyEClass.isAbstract()) {
			proxyEClass = context.findConcreteEClass(proxyEClass);
		}
		
		if (eReference.isMany()) {
			String[] valueIds = value.split(",");
			for (String valueId : valueIds) {
				EObject proxy = EcoreUtil.create(proxyEClass);
				((InternalEObject) proxy).eSetProxyURI(context.getResource().getURI().appendFragment(valueId));
				setValue(eReference, eObject, proxy, context);
			}
		}
		else {
			EObject proxy = EcoreUtil.create(proxyEClass);
			((InternalEObject) proxy).eSetProxyURI(context.getResource().getURI().appendFragment(value));
			setValue(eReference, eObject, proxy, context);
		}
	}
	
	public void setValue(EReference eReference, EObject eObject, EObject value, XminusResourceLoader context) {
		if (eReference.isMany()) {
			((List<Object>) eObject.eGet(eReference)).add(value);
		}
		else {
			eObject.eSet(eReference, value);
		}
	}
	
	
	
}
