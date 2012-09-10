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
import ewe.StoreModelTask;
import ewe.parts.EweViewsRepository;
import ewe.parts.StoreModelTaskPropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class StoreModelTaskPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public StoreModelTaskPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject storeModelTask, String editing_mode) {
		super(editingContext, storeModelTask, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EweViewsRepository.class;
		partKey = EweViewsRepository.StoreModelTask.class;
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
			final StoreModelTask storeModelTask = (StoreModelTask)elt;
			final StoreModelTaskPropertiesEditionPart basePart = (StoreModelTaskPropertiesEditionPart)editingPart;
			// init values
			if (storeModelTask.getName() != null && isAccessible(EweViewsRepository.StoreModelTask.Properties.name))
				basePart.setName(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEString(), storeModelTask.getName()));
			
			if (storeModelTask.getModel() != null && isAccessible(EweViewsRepository.StoreModelTask.Properties.model))
				basePart.setModel(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEString(), storeModelTask.getModel()));
			
			if (storeModelTask.getTarget() != null && isAccessible(EweViewsRepository.StoreModelTask.Properties.target))
				basePart.setTarget(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEString(), storeModelTask.getTarget()));
			
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
		if (editorKey == EweViewsRepository.StoreModelTask.Properties.name) {
			return EwePackage.eINSTANCE.getTask_Name();
		}
		if (editorKey == EweViewsRepository.StoreModelTask.Properties.model) {
			return EwePackage.eINSTANCE.getStoreModelTask_Model();
		}
		if (editorKey == EweViewsRepository.StoreModelTask.Properties.target) {
			return EwePackage.eINSTANCE.getStoreModelTask_Target();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		StoreModelTask storeModelTask = (StoreModelTask)semanticObject;
		if (EweViewsRepository.StoreModelTask.Properties.name == event.getAffectedEditor()) {
			storeModelTask.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue()));
		}
		if (EweViewsRepository.StoreModelTask.Properties.model == event.getAffectedEditor()) {
			storeModelTask.setModel((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue()));
		}
		if (EweViewsRepository.StoreModelTask.Properties.target == event.getAffectedEditor()) {
			storeModelTask.setTarget((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		if (editingPart.isVisible()) {
			StoreModelTaskPropertiesEditionPart basePart = (StoreModelTaskPropertiesEditionPart)editingPart;
			if (EwePackage.eINSTANCE.getTask_Name().equals(msg.getFeature()) && basePart != null && isAccessible(EweViewsRepository.StoreModelTask.Properties.name)) {
				if (msg.getNewValue() != null) {
					basePart.setName(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEString(), msg.getNewValue()));
				} else {
					basePart.setName("");
				}
			}
			if (EwePackage.eINSTANCE.getStoreModelTask_Model().equals(msg.getFeature()) && basePart != null && isAccessible(EweViewsRepository.StoreModelTask.Properties.model)) {
				if (msg.getNewValue() != null) {
					basePart.setModel(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEString(), msg.getNewValue()));
				} else {
					basePart.setModel("");
				}
			}
			if (EwePackage.eINSTANCE.getStoreModelTask_Target().equals(msg.getFeature()) && basePart != null && isAccessible(EweViewsRepository.StoreModelTask.Properties.target)) {
				if (msg.getNewValue() != null) {
					basePart.setTarget(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEString(), msg.getNewValue()));
				} else {
					basePart.setTarget("");
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
				if (EweViewsRepository.StoreModelTask.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EwePackage.eINSTANCE.getTask_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EwePackage.eINSTANCE.getTask_Name().getEAttributeType(), newValue);
				}
				if (EweViewsRepository.StoreModelTask.Properties.model == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EwePackage.eINSTANCE.getStoreModelTask_Model().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EwePackage.eINSTANCE.getStoreModelTask_Model().getEAttributeType(), newValue);
				}
				if (EweViewsRepository.StoreModelTask.Properties.target == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EwePackage.eINSTANCE.getStoreModelTask_Target().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EwePackage.eINSTANCE.getStoreModelTask_Target().getEAttributeType(), newValue);
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
