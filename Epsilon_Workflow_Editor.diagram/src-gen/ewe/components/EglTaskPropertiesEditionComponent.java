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
import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.context.impl.EReferencePropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.policies.impl.CreateEditingPolicy;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import ewe.EglTask;
import ewe.EwePackage;
import ewe.ExportsNestedElement;
import ewe.ModelNestedElement;
import ewe.UsesNestedElement;
import ewe.parts.EglTaskPropertiesEditionPart;
import ewe.parts.EweViewsRepository;


// End of user code

/**
 * 
 * 
 */
public class EglTaskPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for exports ReferencesTable
	 */
	protected ReferencesTableSettings exportsSettings;
	
	/**
	 * Settings for uses ReferencesTable
	 */
	protected ReferencesTableSettings usesSettings;
	
	/**
	 * Settings for models ReferencesTable
	 */
	protected ReferencesTableSettings modelsSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public EglTaskPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject eglTask, String editing_mode) {
		super(editingContext, eglTask, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EweViewsRepository.class;
		partKey = EweViewsRepository.EglTask.class;
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
			final EglTask eglTask = (EglTask)elt;
			final EglTaskPropertiesEditionPart basePart = (EglTaskPropertiesEditionPart)editingPart;
			// init values
			if (eglTask.getSrc() != null && isAccessible(EweViewsRepository.EglTask.Properties.src))
				basePart.setSrc(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEString(), eglTask.getSrc()));
			
			if (isAccessible(EweViewsRepository.EglTask.Properties.exports)) {
				exportsSettings = new ReferencesTableSettings(eglTask, EwePackage.eINSTANCE.getExecutableModelTask_Exports());
				basePart.initExports(exportsSettings);
			}
			if (isAccessible(EweViewsRepository.EglTask.Properties.uses)) {
				usesSettings = new ReferencesTableSettings(eglTask, EwePackage.eINSTANCE.getExecutableModelTask_Uses());
				basePart.initUses(usesSettings);
			}
			if (isAccessible(EweViewsRepository.EglTask.Properties.models)) {
				modelsSettings = new ReferencesTableSettings(eglTask, EwePackage.eINSTANCE.getExecutableModelTask_Models());
				basePart.initModels(modelsSettings);
			}
			if (eglTask.getTarget() != null && isAccessible(EweViewsRepository.EglTask.Properties.target))
				basePart.setTarget(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEString(), eglTask.getTarget()));
			
			// init filters
			
			if (isAccessible(EweViewsRepository.EglTask.Properties.exports)) {
				basePart.addFilterToExports(new ViewerFilter() {
			
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof ExportsNestedElement); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for exports
				// End of user code
			}
			if (isAccessible(EweViewsRepository.EglTask.Properties.uses)) {
				basePart.addFilterToUses(new ViewerFilter() {
			
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof UsesNestedElement); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for uses
				// End of user code
			}
			if (isAccessible(EweViewsRepository.EglTask.Properties.models)) {
				basePart.addFilterToModels(new ViewerFilter() {
			
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof ModelNestedElement); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for models
				// End of user code
			}
			
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
		if (editorKey == EweViewsRepository.EglTask.Properties.src) {
			return EwePackage.eINSTANCE.getExecutableModelTask_Src();
		}
		if (editorKey == EweViewsRepository.EglTask.Properties.exports) {
			return EwePackage.eINSTANCE.getExecutableModelTask_Exports();
		}
		if (editorKey == EweViewsRepository.EglTask.Properties.uses) {
			return EwePackage.eINSTANCE.getExecutableModelTask_Uses();
		}
		if (editorKey == EweViewsRepository.EglTask.Properties.models) {
			return EwePackage.eINSTANCE.getExecutableModelTask_Models();
		}
		if (editorKey == EweViewsRepository.EglTask.Properties.target) {
			return EwePackage.eINSTANCE.getEglTask_Target();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		EglTask eglTask = (EglTask)semanticObject;
		if (EweViewsRepository.EglTask.Properties.src == event.getAffectedEditor()) {
			eglTask.setSrc((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue()));
		}
		if (EweViewsRepository.EglTask.Properties.exports == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, exportsSettings, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(semanticObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy instanceof CreateEditingPolicy) {
						policy.execute();
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.EDIT) {
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, (EObject) event.getNewValue(), editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt((EObject) event.getNewValue(), PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy editionPolicy = provider.getPolicy(context);
					if (editionPolicy != null) {
						editionPolicy.execute();
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				exportsSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				exportsSettings.move(event.getNewIndex(), (ExportsNestedElement) event.getNewValue());
			}
		}
		if (EweViewsRepository.EglTask.Properties.uses == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, usesSettings, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(semanticObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy instanceof CreateEditingPolicy) {
						policy.execute();
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.EDIT) {
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, (EObject) event.getNewValue(), editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt((EObject) event.getNewValue(), PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy editionPolicy = provider.getPolicy(context);
					if (editionPolicy != null) {
						editionPolicy.execute();
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				usesSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				usesSettings.move(event.getNewIndex(), (UsesNestedElement) event.getNewValue());
			}
		}
		if (EweViewsRepository.EglTask.Properties.models == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, modelsSettings, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(semanticObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy instanceof CreateEditingPolicy) {
						policy.execute();
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.EDIT) {
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, (EObject) event.getNewValue(), editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt((EObject) event.getNewValue(), PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy editionPolicy = provider.getPolicy(context);
					if (editionPolicy != null) {
						editionPolicy.execute();
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				modelsSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				modelsSettings.move(event.getNewIndex(), (ModelNestedElement) event.getNewValue());
			}
		}
		if (EweViewsRepository.EglTask.Properties.target == event.getAffectedEditor()) {
			eglTask.setTarget((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		if (editingPart.isVisible()) {
			EglTaskPropertiesEditionPart basePart = (EglTaskPropertiesEditionPart)editingPart;
			if (EwePackage.eINSTANCE.getExecutableModelTask_Src().equals(msg.getFeature()) && basePart != null && isAccessible(EweViewsRepository.EglTask.Properties.src)) {
				if (msg.getNewValue() != null) {
					basePart.setSrc(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEString(), msg.getNewValue()));
				} else {
					basePart.setSrc("");
				}
			}
			if (EwePackage.eINSTANCE.getExecutableModelTask_Exports().equals(msg.getFeature()) && isAccessible(EweViewsRepository.EglTask.Properties.exports))
				basePart.updateExports();
			if (EwePackage.eINSTANCE.getExecutableModelTask_Uses().equals(msg.getFeature()) && isAccessible(EweViewsRepository.EglTask.Properties.uses))
				basePart.updateUses();
			if (EwePackage.eINSTANCE.getExecutableModelTask_Models().equals(msg.getFeature()) && isAccessible(EweViewsRepository.EglTask.Properties.models))
				basePart.updateModels();
			if (EwePackage.eINSTANCE.getEglTask_Target().equals(msg.getFeature()) && basePart != null && isAccessible(EweViewsRepository.EglTask.Properties.target)) {
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
				if (EweViewsRepository.EglTask.Properties.src == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EwePackage.eINSTANCE.getExecutableModelTask_Src().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EwePackage.eINSTANCE.getExecutableModelTask_Src().getEAttributeType(), newValue);
				}
				if (EweViewsRepository.EglTask.Properties.target == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EwePackage.eINSTANCE.getEglTask_Target().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EwePackage.eINSTANCE.getEglTask_Target().getEAttributeType(), newValue);
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
