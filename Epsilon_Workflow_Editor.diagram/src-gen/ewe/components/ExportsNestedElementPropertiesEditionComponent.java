/**
 * Generated with Acceleo
 */
package ewe.components;

// Start of user code for imports
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;

import ewe.EwePackage;
import ewe.ExportsNestedElement;
import ewe.parts.EweViewsRepository;
import ewe.parts.ExportsNestedElementPropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class ExportsNestedElementPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public ExportsNestedElementPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject exportsNestedElement, String editing_mode) {
		super(editingContext, exportsNestedElement, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EweViewsRepository.class;
		partKey = EweViewsRepository.ExportsNestedElement.class;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Object, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 * 
	 */
	public void initPart(Object key, int kind, EObject elt, ResourceSet allResource) {
		setInitializing(true);
		if (editingPart != null && key == partKey) {
			editingPart.setContext(elt, allResource);
			final ExportsNestedElement exportsNestedElement = (ExportsNestedElement)elt;
			final ExportsNestedElementPropertiesEditionPart basePart = (ExportsNestedElementPropertiesEditionPart)editingPart;
			// init values
			if (exportsNestedElement.getRef() != null && isAccessible(EweViewsRepository.ExportsNestedElement.Properties.ref))
				basePart.setRef(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEString(), exportsNestedElement.getRef()));
			
			if (exportsNestedElement.getAs() != null && isAccessible(EweViewsRepository.ExportsNestedElement.Properties.as))
				basePart.setAs(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEString(), exportsNestedElement.getAs()));
			
			if (exportsNestedElement.getOptional() != null && isAccessible(EweViewsRepository.ExportsNestedElement.Properties.optional))
				basePart.setOptional(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEString(), exportsNestedElement.getOptional()));
			
			// init filters
			
			
			
			// init values for referenced views
			
			// init filters for referenced views
			
		}
		setInitializing(false);
	}






	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#associatedFeature(java.lang.Object)
	 */
	public EStructuralFeature associatedFeature(Object editorKey) {
		if (editorKey == EweViewsRepository.ExportsNestedElement.Properties.ref) {
			return EwePackage.eINSTANCE.getVariableNestedElement_Ref();
		}
		if (editorKey == EweViewsRepository.ExportsNestedElement.Properties.as) {
			return EwePackage.eINSTANCE.getVariableNestedElement_As();
		}
		if (editorKey == EweViewsRepository.ExportsNestedElement.Properties.optional) {
			return EwePackage.eINSTANCE.getVariableNestedElement_Optional();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		ExportsNestedElement exportsNestedElement = (ExportsNestedElement)semanticObject;
		if (EweViewsRepository.ExportsNestedElement.Properties.ref == event.getAffectedEditor()) {
			exportsNestedElement.setRef((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue()));
		}
		if (EweViewsRepository.ExportsNestedElement.Properties.as == event.getAffectedEditor()) {
			exportsNestedElement.setAs((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue()));
		}
		if (EweViewsRepository.ExportsNestedElement.Properties.optional == event.getAffectedEditor()) {
			exportsNestedElement.setOptional((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		if (editingPart.isVisible()) {
			ExportsNestedElementPropertiesEditionPart basePart = (ExportsNestedElementPropertiesEditionPart)editingPart;
			if (EwePackage.eINSTANCE.getVariableNestedElement_Ref().equals(msg.getFeature()) && basePart != null && isAccessible(EweViewsRepository.ExportsNestedElement.Properties.ref)) {
				if (msg.getNewValue() != null) {
					basePart.setRef(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEString(), msg.getNewValue()));
				} else {
					basePart.setRef("");
				}
			}
			if (EwePackage.eINSTANCE.getVariableNestedElement_As().equals(msg.getFeature()) && basePart != null && isAccessible(EweViewsRepository.ExportsNestedElement.Properties.as)) {
				if (msg.getNewValue() != null) {
					basePart.setAs(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEString(), msg.getNewValue()));
				} else {
					basePart.setAs("");
				}
			}
			if (EwePackage.eINSTANCE.getVariableNestedElement_Optional().equals(msg.getFeature()) && basePart != null && isAccessible(EweViewsRepository.ExportsNestedElement.Properties.optional)) {
				if (msg.getNewValue() != null) {
					basePart.setOptional(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEString(), msg.getNewValue()));
				} else {
					basePart.setOptional("");
				}
			}
			
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public Diagnostic validateValue(IPropertiesEditionEvent event) {
		Diagnostic ret = Diagnostic.OK_INSTANCE;
		if (event.getNewValue() != null) {
			try {
				if (EweViewsRepository.ExportsNestedElement.Properties.ref == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EwePackage.eINSTANCE.getVariableNestedElement_Ref().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EwePackage.eINSTANCE.getVariableNestedElement_Ref().getEAttributeType(), newValue);
				}
				if (EweViewsRepository.ExportsNestedElement.Properties.as == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EwePackage.eINSTANCE.getVariableNestedElement_As().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EwePackage.eINSTANCE.getVariableNestedElement_As().getEAttributeType(), newValue);
				}
				if (EweViewsRepository.ExportsNestedElement.Properties.optional == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EwePackage.eINSTANCE.getVariableNestedElement_Optional().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EwePackage.eINSTANCE.getVariableNestedElement_Optional().getEAttributeType(), newValue);
				}
			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			} catch (WrappedException we) {
				ret = BasicDiagnostic.toDiagnostic(we);
			}
		}
		return ret;
	}

}
