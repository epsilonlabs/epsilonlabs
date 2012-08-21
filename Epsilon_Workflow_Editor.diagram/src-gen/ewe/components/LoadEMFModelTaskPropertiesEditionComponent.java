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
import ewe.LoadEMFModelTask;
import ewe.parts.EweViewsRepository;
import ewe.parts.LoadEMFModelTaskPropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class LoadEMFModelTaskPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public LoadEMFModelTaskPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject loadEMFModelTask, String editing_mode) {
		super(editingContext, loadEMFModelTask, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EweViewsRepository.class;
		partKey = EweViewsRepository.LoadEMFModelTask.class;
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
			final LoadEMFModelTask loadEMFModelTask = (LoadEMFModelTask)elt;
			final LoadEMFModelTaskPropertiesEditionPart basePart = (LoadEMFModelTaskPropertiesEditionPart)editingPart;
			// init values
			if (loadEMFModelTask.getName() != null && isAccessible(EweViewsRepository.LoadEMFModelTask.Properties.name))
				basePart.setName(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEString(), loadEMFModelTask.getName()));
			
			if (loadEMFModelTask.getType() != null && isAccessible(EweViewsRepository.LoadEMFModelTask.Properties.type))
				basePart.setType(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEString(), loadEMFModelTask.getType()));
			
			if (loadEMFModelTask.getModelFile() != null && isAccessible(EweViewsRepository.LoadEMFModelTask.Properties.modelFile))
				basePart.setModelFile(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEString(), loadEMFModelTask.getModelFile()));
			
			if (loadEMFModelTask.getMetamodelFile() != null && isAccessible(EweViewsRepository.LoadEMFModelTask.Properties.metamodelFile))
				basePart.setMetamodelFile(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEString(), loadEMFModelTask.getMetamodelFile()));
			
			if (isAccessible(EweViewsRepository.LoadEMFModelTask.Properties.isMetamodelFileBased)) {
				basePart.setIsMetamodelFileBased(loadEMFModelTask.isIsMetamodelFileBased());
			}
			if (isAccessible(EweViewsRepository.LoadEMFModelTask.Properties.readOnLoad)) {
				basePart.setReadOnLoad(loadEMFModelTask.isReadOnLoad());
			}
			if (loadEMFModelTask.getMetamodelUri() != null && isAccessible(EweViewsRepository.LoadEMFModelTask.Properties.metamodelUri))
				basePart.setMetamodelUri(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEString(), loadEMFModelTask.getMetamodelUri()));
			
			if (isAccessible(EweViewsRepository.LoadEMFModelTask.Properties.storeOnDisposal)) {
				basePart.setStoreOnDisposal(loadEMFModelTask.isStoreOnDisposal());
			}
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
		if (editorKey == EweViewsRepository.LoadEMFModelTask.Properties.name) {
			return EwePackage.eINSTANCE.getTask_Name();
		}
		if (editorKey == EweViewsRepository.LoadEMFModelTask.Properties.type) {
			return EwePackage.eINSTANCE.getLoadModelTask_Type();
		}
		if (editorKey == EweViewsRepository.LoadEMFModelTask.Properties.modelFile) {
			return EwePackage.eINSTANCE.getLoadEMFModelTask_ModelFile();
		}
		if (editorKey == EweViewsRepository.LoadEMFModelTask.Properties.metamodelFile) {
			return EwePackage.eINSTANCE.getLoadEMFModelTask_MetamodelFile();
		}
		if (editorKey == EweViewsRepository.LoadEMFModelTask.Properties.isMetamodelFileBased) {
			return EwePackage.eINSTANCE.getLoadEMFModelTask_IsMetamodelFileBased();
		}
		if (editorKey == EweViewsRepository.LoadEMFModelTask.Properties.readOnLoad) {
			return EwePackage.eINSTANCE.getLoadEMFModelTask_ReadOnLoad();
		}
		if (editorKey == EweViewsRepository.LoadEMFModelTask.Properties.metamodelUri) {
			return EwePackage.eINSTANCE.getLoadEMFModelTask_MetamodelUri();
		}
		if (editorKey == EweViewsRepository.LoadEMFModelTask.Properties.storeOnDisposal) {
			return EwePackage.eINSTANCE.getLoadEMFModelTask_StoreOnDisposal();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		LoadEMFModelTask loadEMFModelTask = (LoadEMFModelTask)semanticObject;
		if (EweViewsRepository.LoadEMFModelTask.Properties.name == event.getAffectedEditor()) {
			loadEMFModelTask.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue()));
		}
		if (EweViewsRepository.LoadEMFModelTask.Properties.modelFile == event.getAffectedEditor()) {
			loadEMFModelTask.setModelFile((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue()));
		}
		if (EweViewsRepository.LoadEMFModelTask.Properties.metamodelFile == event.getAffectedEditor()) {
			loadEMFModelTask.setMetamodelFile((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue()));
		}
		if (EweViewsRepository.LoadEMFModelTask.Properties.isMetamodelFileBased == event.getAffectedEditor()) {
			loadEMFModelTask.setIsMetamodelFileBased((Boolean)event.getNewValue());
		}
		if (EweViewsRepository.LoadEMFModelTask.Properties.readOnLoad == event.getAffectedEditor()) {
			loadEMFModelTask.setReadOnLoad((Boolean)event.getNewValue());
		}
		if (EweViewsRepository.LoadEMFModelTask.Properties.metamodelUri == event.getAffectedEditor()) {
			loadEMFModelTask.setMetamodelUri((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue()));
		}
		if (EweViewsRepository.LoadEMFModelTask.Properties.storeOnDisposal == event.getAffectedEditor()) {
			loadEMFModelTask.setStoreOnDisposal((Boolean)event.getNewValue());
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		if (editingPart.isVisible()) {
			LoadEMFModelTaskPropertiesEditionPart basePart = (LoadEMFModelTaskPropertiesEditionPart)editingPart;
			if (EwePackage.eINSTANCE.getTask_Name().equals(msg.getFeature()) && basePart != null && isAccessible(EweViewsRepository.LoadEMFModelTask.Properties.name)) {
				if (msg.getNewValue() != null) {
					basePart.setName(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEString(), msg.getNewValue()));
				} else {
					basePart.setName("");
				}
			}
			if (EwePackage.eINSTANCE.getLoadModelTask_Type().equals(msg.getFeature()) && basePart != null && isAccessible(EweViewsRepository.LoadEMFModelTask.Properties.type)) {
				if (msg.getNewValue() != null) {
					basePart.setType(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEString(), msg.getNewValue()));
				} else {
					basePart.setType("");
				}
			}
			if (EwePackage.eINSTANCE.getLoadEMFModelTask_ModelFile().equals(msg.getFeature()) && basePart != null && isAccessible(EweViewsRepository.LoadEMFModelTask.Properties.modelFile)) {
				if (msg.getNewValue() != null) {
					basePart.setModelFile(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEString(), msg.getNewValue()));
				} else {
					basePart.setModelFile("");
				}
			}
			if (EwePackage.eINSTANCE.getLoadEMFModelTask_MetamodelFile().equals(msg.getFeature()) && basePart != null && isAccessible(EweViewsRepository.LoadEMFModelTask.Properties.metamodelFile)) {
				if (msg.getNewValue() != null) {
					basePart.setMetamodelFile(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEString(), msg.getNewValue()));
				} else {
					basePart.setMetamodelFile("");
				}
			}
			if (EwePackage.eINSTANCE.getLoadEMFModelTask_IsMetamodelFileBased().equals(msg.getFeature()) && basePart != null && isAccessible(EweViewsRepository.LoadEMFModelTask.Properties.isMetamodelFileBased))
				basePart.setIsMetamodelFileBased((Boolean)msg.getNewValue());
			
			if (EwePackage.eINSTANCE.getLoadEMFModelTask_ReadOnLoad().equals(msg.getFeature()) && basePart != null && isAccessible(EweViewsRepository.LoadEMFModelTask.Properties.readOnLoad))
				basePart.setReadOnLoad((Boolean)msg.getNewValue());
			
			if (EwePackage.eINSTANCE.getLoadEMFModelTask_MetamodelUri().equals(msg.getFeature()) && basePart != null && isAccessible(EweViewsRepository.LoadEMFModelTask.Properties.metamodelUri)) {
				if (msg.getNewValue() != null) {
					basePart.setMetamodelUri(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEString(), msg.getNewValue()));
				} else {
					basePart.setMetamodelUri("");
				}
			}
			if (EwePackage.eINSTANCE.getLoadEMFModelTask_StoreOnDisposal().equals(msg.getFeature()) && basePart != null && isAccessible(EweViewsRepository.LoadEMFModelTask.Properties.storeOnDisposal))
				basePart.setStoreOnDisposal((Boolean)msg.getNewValue());
			
			
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == EweViewsRepository.LoadEMFModelTask.Properties.modelFile;
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
				if (EweViewsRepository.LoadEMFModelTask.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EwePackage.eINSTANCE.getTask_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EwePackage.eINSTANCE.getTask_Name().getEAttributeType(), newValue);
				}
				if (EweViewsRepository.LoadEMFModelTask.Properties.type == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EwePackage.eINSTANCE.getLoadModelTask_Type().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EwePackage.eINSTANCE.getLoadModelTask_Type().getEAttributeType(), newValue);
				}
				if (EweViewsRepository.LoadEMFModelTask.Properties.modelFile == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EwePackage.eINSTANCE.getLoadEMFModelTask_ModelFile().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EwePackage.eINSTANCE.getLoadEMFModelTask_ModelFile().getEAttributeType(), newValue);
				}
				if (EweViewsRepository.LoadEMFModelTask.Properties.metamodelFile == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EwePackage.eINSTANCE.getLoadEMFModelTask_MetamodelFile().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EwePackage.eINSTANCE.getLoadEMFModelTask_MetamodelFile().getEAttributeType(), newValue);
				}
				if (EweViewsRepository.LoadEMFModelTask.Properties.isMetamodelFileBased == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EwePackage.eINSTANCE.getLoadEMFModelTask_IsMetamodelFileBased().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EwePackage.eINSTANCE.getLoadEMFModelTask_IsMetamodelFileBased().getEAttributeType(), newValue);
				}
				if (EweViewsRepository.LoadEMFModelTask.Properties.readOnLoad == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EwePackage.eINSTANCE.getLoadEMFModelTask_ReadOnLoad().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EwePackage.eINSTANCE.getLoadEMFModelTask_ReadOnLoad().getEAttributeType(), newValue);
				}
				if (EweViewsRepository.LoadEMFModelTask.Properties.metamodelUri == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EwePackage.eINSTANCE.getLoadEMFModelTask_MetamodelUri().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EwePackage.eINSTANCE.getLoadEMFModelTask_MetamodelUri().getEAttributeType(), newValue);
				}
				if (EweViewsRepository.LoadEMFModelTask.Properties.storeOnDisposal == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EwePackage.eINSTANCE.getLoadEMFModelTask_StoreOnDisposal().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EwePackage.eINSTANCE.getLoadEMFModelTask_StoreOnDisposal().getEAttributeType(), newValue);
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
