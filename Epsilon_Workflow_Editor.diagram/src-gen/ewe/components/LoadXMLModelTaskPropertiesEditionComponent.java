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
import ewe.LoadXMLModelTask;
import ewe.parts.EweViewsRepository;
import ewe.parts.LoadXMLModelTaskPropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class LoadXMLModelTaskPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public LoadXMLModelTaskPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject loadXMLModelTask, String editing_mode) {
		super(editingContext, loadXMLModelTask, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EweViewsRepository.class;
		partKey = EweViewsRepository.LoadXMLModelTask.class;
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
			final LoadXMLModelTask loadXMLModelTask = (LoadXMLModelTask)elt;
			final LoadXMLModelTaskPropertiesEditionPart basePart = (LoadXMLModelTaskPropertiesEditionPart)editingPart;
			// init values
			if (loadXMLModelTask.getName() != null && isAccessible(EweViewsRepository.LoadXMLModelTask.Properties.name))
				basePart.setName(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEString(), loadXMLModelTask.getName()));
			
			if (loadXMLModelTask.getType() != null && isAccessible(EweViewsRepository.LoadXMLModelTask.Properties.type))
				basePart.setType(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEString(), loadXMLModelTask.getType()));
			
			if (loadXMLModelTask.getFile() != null && isAccessible(EweViewsRepository.LoadXMLModelTask.Properties.file))
				basePart.setFile(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEString(), loadXMLModelTask.getFile()));
			
			if (loadXMLModelTask.getUri() != null && isAccessible(EweViewsRepository.LoadXMLModelTask.Properties.uri))
				basePart.setUri(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEString(), loadXMLModelTask.getUri()));
			
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
		if (editorKey == EweViewsRepository.LoadXMLModelTask.Properties.name) {
			return EwePackage.eINSTANCE.getTask_Name();
		}
		if (editorKey == EweViewsRepository.LoadXMLModelTask.Properties.type) {
			return EwePackage.eINSTANCE.getLoadModelTask_Type();
		}
		if (editorKey == EweViewsRepository.LoadXMLModelTask.Properties.file) {
			return EwePackage.eINSTANCE.getLoadXMLModelTask_File();
		}
		if (editorKey == EweViewsRepository.LoadXMLModelTask.Properties.uri) {
			return EwePackage.eINSTANCE.getLoadXMLModelTask_Uri();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		LoadXMLModelTask loadXMLModelTask = (LoadXMLModelTask)semanticObject;
		if (EweViewsRepository.LoadXMLModelTask.Properties.name == event.getAffectedEditor()) {
			loadXMLModelTask.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue()));
		}
		if (EweViewsRepository.LoadXMLModelTask.Properties.file == event.getAffectedEditor()) {
			loadXMLModelTask.setFile((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue()));
		}
		if (EweViewsRepository.LoadXMLModelTask.Properties.uri == event.getAffectedEditor()) {
			loadXMLModelTask.setUri((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		if (editingPart.isVisible()) {
			LoadXMLModelTaskPropertiesEditionPart basePart = (LoadXMLModelTaskPropertiesEditionPart)editingPart;
			if (EwePackage.eINSTANCE.getTask_Name().equals(msg.getFeature()) && basePart != null && isAccessible(EweViewsRepository.LoadXMLModelTask.Properties.name)) {
				if (msg.getNewValue() != null) {
					basePart.setName(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEString(), msg.getNewValue()));
				} else {
					basePart.setName("");
				}
			}
			if (EwePackage.eINSTANCE.getLoadModelTask_Type().equals(msg.getFeature()) && basePart != null && isAccessible(EweViewsRepository.LoadXMLModelTask.Properties.type)) {
				if (msg.getNewValue() != null) {
					basePart.setType(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEString(), msg.getNewValue()));
				} else {
					basePart.setType("");
				}
			}
			if (EwePackage.eINSTANCE.getLoadXMLModelTask_File().equals(msg.getFeature()) && basePart != null && isAccessible(EweViewsRepository.LoadXMLModelTask.Properties.file)) {
				if (msg.getNewValue() != null) {
					basePart.setFile(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEString(), msg.getNewValue()));
				} else {
					basePart.setFile("");
				}
			}
			if (EwePackage.eINSTANCE.getLoadXMLModelTask_Uri().equals(msg.getFeature()) && basePart != null && isAccessible(EweViewsRepository.LoadXMLModelTask.Properties.uri)) {
				if (msg.getNewValue() != null) {
					basePart.setUri(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEString(), msg.getNewValue()));
				} else {
					basePart.setUri("");
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
				if (EweViewsRepository.LoadXMLModelTask.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EwePackage.eINSTANCE.getTask_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EwePackage.eINSTANCE.getTask_Name().getEAttributeType(), newValue);
				}
				if (EweViewsRepository.LoadXMLModelTask.Properties.type == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EwePackage.eINSTANCE.getLoadModelTask_Type().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EwePackage.eINSTANCE.getLoadModelTask_Type().getEAttributeType(), newValue);
				}
				if (EweViewsRepository.LoadXMLModelTask.Properties.file == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EwePackage.eINSTANCE.getLoadXMLModelTask_File().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EwePackage.eINSTANCE.getLoadXMLModelTask_File().getEAttributeType(), newValue);
				}
				if (EweViewsRepository.LoadXMLModelTask.Properties.uri == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EwePackage.eINSTANCE.getLoadXMLModelTask_Uri().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EwePackage.eINSTANCE.getLoadXMLModelTask_Uri().getEAttributeType(), newValue);
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
