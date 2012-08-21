/*
 * 
 */
package ewe.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

import ewe.EwePackage;
import ewe.diagram.edit.parts.CommitTransactionTaskEditPart;
import ewe.diagram.edit.parts.DisposeModelTaskEditPart;
import ewe.diagram.edit.parts.EUnitTaskEditPart;
import ewe.diagram.edit.parts.EclTaskEditPart;
import ewe.diagram.edit.parts.EglTaskEditPart;
import ewe.diagram.edit.parts.EmlTaskEditPart;
import ewe.diagram.edit.parts.EolTaskEditPart;
import ewe.diagram.edit.parts.EtlTaskEditPart;
import ewe.diagram.edit.parts.EvlTaskEditPart;
import ewe.diagram.edit.parts.FlockTaskEditPart;
import ewe.diagram.edit.parts.LoadEMFModelTaskEditPart;
import ewe.diagram.edit.parts.LoadModelTaskEditPart;
import ewe.diagram.edit.parts.LoadXMLModelTaskEditPart;
import ewe.diagram.edit.parts.NestedElementEditPart;
import ewe.diagram.edit.parts.ProjectEditPart;
import ewe.diagram.edit.parts.PropertyEditPart;
import ewe.diagram.edit.parts.RollbackTransactionTaskEditPart;
import ewe.diagram.edit.parts.StartTransactionTaskEditPart;
import ewe.diagram.edit.parts.StoreModelTaskEditPart;
import ewe.diagram.edit.parts.TargetDependsEditPart;
import ewe.diagram.edit.parts.TargetEditPart;
import ewe.diagram.edit.parts.TaskEditPart;
import ewe.diagram.edit.parts.TaskFollowsEditPart;
import ewe.diagram.part.EweDiagramEditorPlugin;

/**
 * @generated
 */
public class EweElementTypes {

	/**
	 * @generated
	 */
	private EweElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map<IElementType, ENamedElement> elements;

	/**
	 * @generated
	 */
	private static ImageRegistry imageRegistry;

	/**
	 * @generated
	 */
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType Project_1000 = getElementType("Epsilon_Workflow_Editor.diagram.Project_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Target_2001 = getElementType("Epsilon_Workflow_Editor.diagram.Target_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType EolTask_3001 = getElementType("Epsilon_Workflow_Editor.diagram.EolTask_3001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType EmlTask_3002 = getElementType("Epsilon_Workflow_Editor.diagram.EmlTask_3002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType EglTask_3003 = getElementType("Epsilon_Workflow_Editor.diagram.EglTask_3003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType EtlTask_3004 = getElementType("Epsilon_Workflow_Editor.diagram.EtlTask_3004"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType EvlTask_3005 = getElementType("Epsilon_Workflow_Editor.diagram.EvlTask_3005"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType LoadEMFModelTask_3006 = getElementType("Epsilon_Workflow_Editor.diagram.LoadEMFModelTask_3006"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType LoadXMLModelTask_3007 = getElementType("Epsilon_Workflow_Editor.diagram.LoadXMLModelTask_3007"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FlockTask_3008 = getElementType("Epsilon_Workflow_Editor.diagram.FlockTask_3008"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType EUnitTask_3009 = getElementType("Epsilon_Workflow_Editor.diagram.EUnitTask_3009"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType EclTask_3010 = getElementType("Epsilon_Workflow_Editor.diagram.EclTask_3010"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType LoadModelTask_3011 = getElementType("Epsilon_Workflow_Editor.diagram.LoadModelTask_3011"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType StoreModelTask_3012 = getElementType("Epsilon_Workflow_Editor.diagram.StoreModelTask_3012"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType RollbackTransactionTask_3013 = getElementType("Epsilon_Workflow_Editor.diagram.RollbackTransactionTask_3013"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType DisposeModelTask_3014 = getElementType("Epsilon_Workflow_Editor.diagram.DisposeModelTask_3014"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType StartTransactionTask_3015 = getElementType("Epsilon_Workflow_Editor.diagram.StartTransactionTask_3015"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType CommitTransactionTask_3016 = getElementType("Epsilon_Workflow_Editor.diagram.CommitTransactionTask_3016"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Property_3017 = getElementType("Epsilon_Workflow_Editor.diagram.Property_3017"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType NestedElement_3018 = getElementType("Epsilon_Workflow_Editor.diagram.NestedElement_3018"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Task_3019 = getElementType("Epsilon_Workflow_Editor.diagram.Task_3019"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType TaskFollows_4001 = getElementType("Epsilon_Workflow_Editor.diagram.TaskFollows_4001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType TargetDepends_4002 = getElementType("Epsilon_Workflow_Editor.diagram.TargetDepends_4002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static ImageRegistry getImageRegistry() {
		if (imageRegistry == null) {
			imageRegistry = new ImageRegistry();
		}
		return imageRegistry;
	}

	/**
	 * @generated
	 */
	private static String getImageRegistryKey(ENamedElement element) {
		return element.getName();
	}

	/**
	 * @generated
	 */
	private static ImageDescriptor getProvidedImageDescriptor(
			ENamedElement element) {
		if (element instanceof EStructuralFeature) {
			EStructuralFeature feature = ((EStructuralFeature) element);
			EClass eContainingClass = feature.getEContainingClass();
			EClassifier eType = feature.getEType();
			if (eContainingClass != null && !eContainingClass.isAbstract()) {
				element = eContainingClass;
			} else if (eType instanceof EClass
					&& !((EClass) eType).isAbstract()) {
				element = eType;
			}
		}
		if (element instanceof EClass) {
			EClass eClass = (EClass) element;
			if (!eClass.isAbstract()) {
				return EweDiagramEditorPlugin.getInstance()
						.getItemImageDescriptor(
								eClass.getEPackage().getEFactoryInstance()
										.create(eClass));
			}
		}
		// TODO : support structural features
		return null;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		String key = getImageRegistryKey(element);
		ImageDescriptor imageDescriptor = getImageRegistry().getDescriptor(key);
		if (imageDescriptor == null) {
			imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
		}
		return imageDescriptor;
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		String key = getImageRegistryKey(element);
		Image image = getImageRegistry().get(key);
		if (image == null) {
			ImageDescriptor imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
			image = getImageRegistry().get(key);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImage(element);
	}

	/**
	 * Returns 'type' of the ecore object associated with the hint.
	 * 
	 * @generated
	 */
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap<IElementType, ENamedElement>();

			elements.put(Project_1000, EwePackage.eINSTANCE.getProject());

			elements.put(Target_2001, EwePackage.eINSTANCE.getTarget());

			elements.put(EolTask_3001, EwePackage.eINSTANCE.getEolTask());

			elements.put(EmlTask_3002, EwePackage.eINSTANCE.getEmlTask());

			elements.put(EglTask_3003, EwePackage.eINSTANCE.getEglTask());

			elements.put(EtlTask_3004, EwePackage.eINSTANCE.getEtlTask());

			elements.put(EvlTask_3005, EwePackage.eINSTANCE.getEvlTask());

			elements.put(LoadEMFModelTask_3006,
					EwePackage.eINSTANCE.getLoadEMFModelTask());

			elements.put(LoadXMLModelTask_3007,
					EwePackage.eINSTANCE.getLoadXMLModelTask());

			elements.put(FlockTask_3008, EwePackage.eINSTANCE.getFlockTask());

			elements.put(EUnitTask_3009, EwePackage.eINSTANCE.getEUnitTask());

			elements.put(EclTask_3010, EwePackage.eINSTANCE.getEclTask());

			elements.put(LoadModelTask_3011,
					EwePackage.eINSTANCE.getLoadModelTask());

			elements.put(StoreModelTask_3012,
					EwePackage.eINSTANCE.getStoreModelTask());

			elements.put(RollbackTransactionTask_3013,
					EwePackage.eINSTANCE.getRollbackTransactionTask());

			elements.put(DisposeModelTask_3014,
					EwePackage.eINSTANCE.getDisposeModelTask());

			elements.put(StartTransactionTask_3015,
					EwePackage.eINSTANCE.getStartTransactionTask());

			elements.put(CommitTransactionTask_3016,
					EwePackage.eINSTANCE.getCommitTransactionTask());

			elements.put(Property_3017, EwePackage.eINSTANCE.getProperty());

			elements.put(NestedElement_3018,
					EwePackage.eINSTANCE.getNestedElement());

			elements.put(Task_3019, EwePackage.eINSTANCE.getTask());

			elements.put(TaskFollows_4001,
					EwePackage.eINSTANCE.getTask_Follows());

			elements.put(TargetDepends_4002,
					EwePackage.eINSTANCE.getTarget_Depends());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	 * @generated
	 */
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	 * @generated
	 */
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet<IElementType>();
			KNOWN_ELEMENT_TYPES.add(Project_1000);
			KNOWN_ELEMENT_TYPES.add(Target_2001);
			KNOWN_ELEMENT_TYPES.add(EolTask_3001);
			KNOWN_ELEMENT_TYPES.add(EmlTask_3002);
			KNOWN_ELEMENT_TYPES.add(EglTask_3003);
			KNOWN_ELEMENT_TYPES.add(EtlTask_3004);
			KNOWN_ELEMENT_TYPES.add(EvlTask_3005);
			KNOWN_ELEMENT_TYPES.add(LoadEMFModelTask_3006);
			KNOWN_ELEMENT_TYPES.add(LoadXMLModelTask_3007);
			KNOWN_ELEMENT_TYPES.add(FlockTask_3008);
			KNOWN_ELEMENT_TYPES.add(EUnitTask_3009);
			KNOWN_ELEMENT_TYPES.add(EclTask_3010);
			KNOWN_ELEMENT_TYPES.add(LoadModelTask_3011);
			KNOWN_ELEMENT_TYPES.add(StoreModelTask_3012);
			KNOWN_ELEMENT_TYPES.add(RollbackTransactionTask_3013);
			KNOWN_ELEMENT_TYPES.add(DisposeModelTask_3014);
			KNOWN_ELEMENT_TYPES.add(StartTransactionTask_3015);
			KNOWN_ELEMENT_TYPES.add(CommitTransactionTask_3016);
			KNOWN_ELEMENT_TYPES.add(Property_3017);
			KNOWN_ELEMENT_TYPES.add(NestedElement_3018);
			KNOWN_ELEMENT_TYPES.add(Task_3019);
			KNOWN_ELEMENT_TYPES.add(TaskFollows_4001);
			KNOWN_ELEMENT_TYPES.add(TargetDepends_4002);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case ProjectEditPart.VISUAL_ID:
			return Project_1000;
		case TargetEditPart.VISUAL_ID:
			return Target_2001;
		case EolTaskEditPart.VISUAL_ID:
			return EolTask_3001;
		case EmlTaskEditPart.VISUAL_ID:
			return EmlTask_3002;
		case EglTaskEditPart.VISUAL_ID:
			return EglTask_3003;
		case EtlTaskEditPart.VISUAL_ID:
			return EtlTask_3004;
		case EvlTaskEditPart.VISUAL_ID:
			return EvlTask_3005;
		case LoadEMFModelTaskEditPart.VISUAL_ID:
			return LoadEMFModelTask_3006;
		case LoadXMLModelTaskEditPart.VISUAL_ID:
			return LoadXMLModelTask_3007;
		case FlockTaskEditPart.VISUAL_ID:
			return FlockTask_3008;
		case EUnitTaskEditPart.VISUAL_ID:
			return EUnitTask_3009;
		case EclTaskEditPart.VISUAL_ID:
			return EclTask_3010;
		case LoadModelTaskEditPart.VISUAL_ID:
			return LoadModelTask_3011;
		case StoreModelTaskEditPart.VISUAL_ID:
			return StoreModelTask_3012;
		case RollbackTransactionTaskEditPart.VISUAL_ID:
			return RollbackTransactionTask_3013;
		case DisposeModelTaskEditPart.VISUAL_ID:
			return DisposeModelTask_3014;
		case StartTransactionTaskEditPart.VISUAL_ID:
			return StartTransactionTask_3015;
		case CommitTransactionTaskEditPart.VISUAL_ID:
			return CommitTransactionTask_3016;
		case PropertyEditPart.VISUAL_ID:
			return Property_3017;
		case NestedElementEditPart.VISUAL_ID:
			return NestedElement_3018;
		case TaskEditPart.VISUAL_ID:
			return Task_3019;
		case TaskFollowsEditPart.VISUAL_ID:
			return TaskFollows_4001;
		case TargetDependsEditPart.VISUAL_ID:
			return TargetDepends_4002;
		}
		return null;
	}

}
