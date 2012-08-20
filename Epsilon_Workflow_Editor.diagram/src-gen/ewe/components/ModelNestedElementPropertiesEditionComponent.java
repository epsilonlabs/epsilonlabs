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
import ewe.ModelNestedElement;
import ewe.parts.EweViewsRepository;
import ewe.parts.ModelNestedElementPropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class ModelNestedElementPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public ModelNestedElementPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject modelNestedElement, String editing_mode) {
		super(editingContext, modelNestedElement, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EweViewsRepository.class;
		partKey = EweViewsRepository.ModelNestedElement.class;
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
			final ModelNestedElement modelNestedElement = (ModelNestedElement)elt;
			final ModelNestedElementPropertiesEditionPart basePart = (ModelNestedElementPropertiesEditionPart)editingPart;
			// init values
			if (modelNestedElement.getRef() != null && isAccessible(EweViewsRepository.ModelNestedElement.Properties.ref))
				basePart.setRef(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEString(), modelNestedElement.getRef()));
			
			if (modelNestedElement.getAs() != null && isAccessible(EweViewsRepository.ModelNestedElement.Properties.as))
				basePart.setAs(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEString(), modelNestedElement.getAs()));
			
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
		if (editorKey == EweViewsRepository.ModelNestedElement.Properties.ref) {
			return EwePackage.eINSTANCE.getModelNestedElement_Ref();
		}
		if (editorKey == EweViewsRepository.ModelNestedElement.Properties.as) {
			return EwePackage.eINSTANCE.getModelNestedElement_As();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		ModelNestedElement modelNestedElement = (ModelNestedElement)semanticObject;
		if (EweViewsRepository.ModelNestedElement.Properties.ref == event.getAffectedEditor()) {
			modelNestedElement.setRef((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue()));
		}
		if (EweViewsRepository.ModelNestedElement.Properties.as == event.getAffectedEditor()) {
			modelNestedElement.setAs((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		if (editingPart.isVisible()) {
			ModelNestedElementPropertiesEditionPart basePart = (ModelNestedElementPropertiesEditionPart)editingPart;
			if (EwePackage.eINSTANCE.getModelNestedElement_Ref().equals(msg.getFeature()) && basePart != null && isAccessible(EweViewsRepository.ModelNestedElement.Properties.ref)) {
				if (msg.getNewValue() != null) {
					basePart.setRef(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEString(), msg.getNewValue()));
				} else {
					basePart.setRef("");
				}
			}
			if (EwePackage.eINSTANCE.getModelNestedElement_As().equals(msg.getFeature()) && basePart != null && isAccessible(EweViewsRepository.ModelNestedElement.Properties.as)) {
				if (msg.getNewValue() != null) {
					basePart.setAs(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEString(), msg.getNewValue()));
				} else {
					basePart.setAs("");
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
				if (EweViewsRepository.ModelNestedElement.Properties.ref == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EwePackage.eINSTANCE.getModelNestedElement_Ref().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EwePackage.eINSTANCE.getModelNestedElement_Ref().getEAttributeType(), newValue);
				}
				if (EweViewsRepository.ModelNestedElement.Properties.as == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EwePackage.eINSTANCE.getModelNestedElement_As().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EwePackage.eINSTANCE.getModelNestedElement_As().getEAttributeType(), newValue);
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
