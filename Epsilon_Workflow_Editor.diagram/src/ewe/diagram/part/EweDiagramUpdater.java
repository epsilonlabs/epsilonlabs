/*
 * 
 */
package ewe.diagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;

import ewe.CommitTransactionTask;
import ewe.DisposeModelTask;
import ewe.EUnitTask;
import ewe.EclTask;
import ewe.EglTask;
import ewe.EmlTask;
import ewe.EolTask;
import ewe.EtlTask;
import ewe.EvlTask;
import ewe.EwePackage;
import ewe.FlockTask;
import ewe.LoadEMFModelTask;
import ewe.LoadModelTask;
import ewe.LoadXMLModelTask;
import ewe.NestedElement;
import ewe.Project;
import ewe.Property;
import ewe.RollbackTransactionTask;
import ewe.StartTransactionTask;
import ewe.StoreModelTask;
import ewe.Target;
import ewe.Task;
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
import ewe.diagram.edit.parts.TargetTargetTargetTasksCompartmentEditPart;
import ewe.diagram.edit.parts.TaskEditPart;
import ewe.diagram.edit.parts.TaskFollowsEditPart;
import ewe.diagram.providers.EweElementTypes;

/**
 * @generated
 */
public class EweDiagramUpdater {

	/**
	 * @generated
	 */
	public static boolean isShortcutOrphaned(View view) {
		return !view.isSetElement() || view.getElement() == null
				|| view.getElement().eIsProxy();
	}

	/**
	 * @generated
	 */
	public static List<EweNodeDescriptor> getSemanticChildren(View view) {
		switch (EweVisualIDRegistry.getVisualID(view)) {
		case ProjectEditPart.VISUAL_ID:
			return getProject_1000SemanticChildren(view);
		case TargetTargetTargetTasksCompartmentEditPart.VISUAL_ID:
			return getTargetTargetTargetTasksCompartment_7001SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EweNodeDescriptor> getProject_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Project modelElement = (Project) view.getElement();
		LinkedList<EweNodeDescriptor> result = new LinkedList<EweNodeDescriptor>();
		for (Iterator<?> it = modelElement.getTargets().iterator(); it
				.hasNext();) {
			Target childElement = (Target) it.next();
			int visualID = EweVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == TargetEditPart.VISUAL_ID) {
				result.add(new EweNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweNodeDescriptor> getTargetTargetTargetTasksCompartment_7001SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Target modelElement = (Target) containerView.getElement();
		LinkedList<EweNodeDescriptor> result = new LinkedList<EweNodeDescriptor>();
		for (Iterator<?> it = modelElement.getTargetTasks().iterator(); it
				.hasNext();) {
			Task childElement = (Task) it.next();
			int visualID = EweVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == EolTaskEditPart.VISUAL_ID) {
				result.add(new EweNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EmlTaskEditPart.VISUAL_ID) {
				result.add(new EweNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EglTaskEditPart.VISUAL_ID) {
				result.add(new EweNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EtlTaskEditPart.VISUAL_ID) {
				result.add(new EweNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EvlTaskEditPart.VISUAL_ID) {
				result.add(new EweNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoadEMFModelTaskEditPart.VISUAL_ID) {
				result.add(new EweNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoadXMLModelTaskEditPart.VISUAL_ID) {
				result.add(new EweNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FlockTaskEditPart.VISUAL_ID) {
				result.add(new EweNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EUnitTaskEditPart.VISUAL_ID) {
				result.add(new EweNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EclTaskEditPart.VISUAL_ID) {
				result.add(new EweNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == LoadModelTaskEditPart.VISUAL_ID) {
				result.add(new EweNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == StoreModelTaskEditPart.VISUAL_ID) {
				result.add(new EweNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == RollbackTransactionTaskEditPart.VISUAL_ID) {
				result.add(new EweNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DisposeModelTaskEditPart.VISUAL_ID) {
				result.add(new EweNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == StartTransactionTaskEditPart.VISUAL_ID) {
				result.add(new EweNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == CommitTransactionTaskEditPart.VISUAL_ID) {
				result.add(new EweNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PropertyEditPart.VISUAL_ID) {
				result.add(new EweNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == NestedElementEditPart.VISUAL_ID) {
				result.add(new EweNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TaskEditPart.VISUAL_ID) {
				result.add(new EweNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getContainedLinks(View view) {
		switch (EweVisualIDRegistry.getVisualID(view)) {
		case ProjectEditPart.VISUAL_ID:
			return getProject_1000ContainedLinks(view);
		case TargetEditPart.VISUAL_ID:
			return getTarget_2001ContainedLinks(view);
		case EolTaskEditPart.VISUAL_ID:
			return getEolTask_3001ContainedLinks(view);
		case EmlTaskEditPart.VISUAL_ID:
			return getEmlTask_3002ContainedLinks(view);
		case EglTaskEditPart.VISUAL_ID:
			return getEglTask_3003ContainedLinks(view);
		case EtlTaskEditPart.VISUAL_ID:
			return getEtlTask_3004ContainedLinks(view);
		case EvlTaskEditPart.VISUAL_ID:
			return getEvlTask_3005ContainedLinks(view);
		case LoadEMFModelTaskEditPart.VISUAL_ID:
			return getLoadEMFModelTask_3006ContainedLinks(view);
		case LoadXMLModelTaskEditPart.VISUAL_ID:
			return getLoadXMLModelTask_3007ContainedLinks(view);
		case FlockTaskEditPart.VISUAL_ID:
			return getFlockTask_3008ContainedLinks(view);
		case EUnitTaskEditPart.VISUAL_ID:
			return getEUnitTask_3009ContainedLinks(view);
		case EclTaskEditPart.VISUAL_ID:
			return getEclTask_3010ContainedLinks(view);
		case LoadModelTaskEditPart.VISUAL_ID:
			return getLoadModelTask_3011ContainedLinks(view);
		case StoreModelTaskEditPart.VISUAL_ID:
			return getStoreModelTask_3012ContainedLinks(view);
		case RollbackTransactionTaskEditPart.VISUAL_ID:
			return getRollbackTransactionTask_3013ContainedLinks(view);
		case DisposeModelTaskEditPart.VISUAL_ID:
			return getDisposeModelTask_3014ContainedLinks(view);
		case StartTransactionTaskEditPart.VISUAL_ID:
			return getStartTransactionTask_3015ContainedLinks(view);
		case CommitTransactionTaskEditPart.VISUAL_ID:
			return getCommitTransactionTask_3016ContainedLinks(view);
		case PropertyEditPart.VISUAL_ID:
			return getProperty_3017ContainedLinks(view);
		case NestedElementEditPart.VISUAL_ID:
			return getNestedElement_3018ContainedLinks(view);
		case TaskEditPart.VISUAL_ID:
			return getTask_3019ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getIncomingLinks(View view) {
		switch (EweVisualIDRegistry.getVisualID(view)) {
		case TargetEditPart.VISUAL_ID:
			return getTarget_2001IncomingLinks(view);
		case EolTaskEditPart.VISUAL_ID:
			return getEolTask_3001IncomingLinks(view);
		case EmlTaskEditPart.VISUAL_ID:
			return getEmlTask_3002IncomingLinks(view);
		case EglTaskEditPart.VISUAL_ID:
			return getEglTask_3003IncomingLinks(view);
		case EtlTaskEditPart.VISUAL_ID:
			return getEtlTask_3004IncomingLinks(view);
		case EvlTaskEditPart.VISUAL_ID:
			return getEvlTask_3005IncomingLinks(view);
		case LoadEMFModelTaskEditPart.VISUAL_ID:
			return getLoadEMFModelTask_3006IncomingLinks(view);
		case LoadXMLModelTaskEditPart.VISUAL_ID:
			return getLoadXMLModelTask_3007IncomingLinks(view);
		case FlockTaskEditPart.VISUAL_ID:
			return getFlockTask_3008IncomingLinks(view);
		case EUnitTaskEditPart.VISUAL_ID:
			return getEUnitTask_3009IncomingLinks(view);
		case EclTaskEditPart.VISUAL_ID:
			return getEclTask_3010IncomingLinks(view);
		case LoadModelTaskEditPart.VISUAL_ID:
			return getLoadModelTask_3011IncomingLinks(view);
		case StoreModelTaskEditPart.VISUAL_ID:
			return getStoreModelTask_3012IncomingLinks(view);
		case RollbackTransactionTaskEditPart.VISUAL_ID:
			return getRollbackTransactionTask_3013IncomingLinks(view);
		case DisposeModelTaskEditPart.VISUAL_ID:
			return getDisposeModelTask_3014IncomingLinks(view);
		case StartTransactionTaskEditPart.VISUAL_ID:
			return getStartTransactionTask_3015IncomingLinks(view);
		case CommitTransactionTaskEditPart.VISUAL_ID:
			return getCommitTransactionTask_3016IncomingLinks(view);
		case PropertyEditPart.VISUAL_ID:
			return getProperty_3017IncomingLinks(view);
		case NestedElementEditPart.VISUAL_ID:
			return getNestedElement_3018IncomingLinks(view);
		case TaskEditPart.VISUAL_ID:
			return getTask_3019IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getOutgoingLinks(View view) {
		switch (EweVisualIDRegistry.getVisualID(view)) {
		case TargetEditPart.VISUAL_ID:
			return getTarget_2001OutgoingLinks(view);
		case EolTaskEditPart.VISUAL_ID:
			return getEolTask_3001OutgoingLinks(view);
		case EmlTaskEditPart.VISUAL_ID:
			return getEmlTask_3002OutgoingLinks(view);
		case EglTaskEditPart.VISUAL_ID:
			return getEglTask_3003OutgoingLinks(view);
		case EtlTaskEditPart.VISUAL_ID:
			return getEtlTask_3004OutgoingLinks(view);
		case EvlTaskEditPart.VISUAL_ID:
			return getEvlTask_3005OutgoingLinks(view);
		case LoadEMFModelTaskEditPart.VISUAL_ID:
			return getLoadEMFModelTask_3006OutgoingLinks(view);
		case LoadXMLModelTaskEditPart.VISUAL_ID:
			return getLoadXMLModelTask_3007OutgoingLinks(view);
		case FlockTaskEditPart.VISUAL_ID:
			return getFlockTask_3008OutgoingLinks(view);
		case EUnitTaskEditPart.VISUAL_ID:
			return getEUnitTask_3009OutgoingLinks(view);
		case EclTaskEditPart.VISUAL_ID:
			return getEclTask_3010OutgoingLinks(view);
		case LoadModelTaskEditPart.VISUAL_ID:
			return getLoadModelTask_3011OutgoingLinks(view);
		case StoreModelTaskEditPart.VISUAL_ID:
			return getStoreModelTask_3012OutgoingLinks(view);
		case RollbackTransactionTaskEditPart.VISUAL_ID:
			return getRollbackTransactionTask_3013OutgoingLinks(view);
		case DisposeModelTaskEditPart.VISUAL_ID:
			return getDisposeModelTask_3014OutgoingLinks(view);
		case StartTransactionTaskEditPart.VISUAL_ID:
			return getStartTransactionTask_3015OutgoingLinks(view);
		case CommitTransactionTaskEditPart.VISUAL_ID:
			return getCommitTransactionTask_3016OutgoingLinks(view);
		case PropertyEditPart.VISUAL_ID:
			return getProperty_3017OutgoingLinks(view);
		case NestedElementEditPart.VISUAL_ID:
			return getNestedElement_3018OutgoingLinks(view);
		case TaskEditPart.VISUAL_ID:
			return getTask_3019OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getProject_1000ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getTarget_2001ContainedLinks(View view) {
		Target modelElement = (Target) view.getElement();
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Target_Depends_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getEolTask_3001ContainedLinks(
			View view) {
		EolTask modelElement = (EolTask) view.getElement();
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Task_Follows_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getEmlTask_3002ContainedLinks(
			View view) {
		EmlTask modelElement = (EmlTask) view.getElement();
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Task_Follows_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getEglTask_3003ContainedLinks(
			View view) {
		EglTask modelElement = (EglTask) view.getElement();
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Task_Follows_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getEtlTask_3004ContainedLinks(
			View view) {
		EtlTask modelElement = (EtlTask) view.getElement();
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Task_Follows_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getEvlTask_3005ContainedLinks(
			View view) {
		EvlTask modelElement = (EvlTask) view.getElement();
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Task_Follows_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getLoadEMFModelTask_3006ContainedLinks(
			View view) {
		LoadEMFModelTask modelElement = (LoadEMFModelTask) view.getElement();
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Task_Follows_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getLoadXMLModelTask_3007ContainedLinks(
			View view) {
		LoadXMLModelTask modelElement = (LoadXMLModelTask) view.getElement();
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Task_Follows_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getFlockTask_3008ContainedLinks(
			View view) {
		FlockTask modelElement = (FlockTask) view.getElement();
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Task_Follows_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getEUnitTask_3009ContainedLinks(
			View view) {
		EUnitTask modelElement = (EUnitTask) view.getElement();
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Task_Follows_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getEclTask_3010ContainedLinks(
			View view) {
		EclTask modelElement = (EclTask) view.getElement();
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Task_Follows_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getLoadModelTask_3011ContainedLinks(
			View view) {
		LoadModelTask modelElement = (LoadModelTask) view.getElement();
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Task_Follows_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getStoreModelTask_3012ContainedLinks(
			View view) {
		StoreModelTask modelElement = (StoreModelTask) view.getElement();
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Task_Follows_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getRollbackTransactionTask_3013ContainedLinks(
			View view) {
		RollbackTransactionTask modelElement = (RollbackTransactionTask) view
				.getElement();
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Task_Follows_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getDisposeModelTask_3014ContainedLinks(
			View view) {
		DisposeModelTask modelElement = (DisposeModelTask) view.getElement();
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Task_Follows_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getStartTransactionTask_3015ContainedLinks(
			View view) {
		StartTransactionTask modelElement = (StartTransactionTask) view
				.getElement();
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Task_Follows_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getCommitTransactionTask_3016ContainedLinks(
			View view) {
		CommitTransactionTask modelElement = (CommitTransactionTask) view
				.getElement();
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Task_Follows_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getProperty_3017ContainedLinks(
			View view) {
		Property modelElement = (Property) view.getElement();
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Task_Follows_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getNestedElement_3018ContainedLinks(
			View view) {
		NestedElement modelElement = (NestedElement) view.getElement();
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Task_Follows_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getTask_3019ContainedLinks(View view) {
		Task modelElement = (Task) view.getElement();
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Task_Follows_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getTarget_2001IncomingLinks(View view) {
		Target modelElement = (Target) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Target_Depends_4002(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getEolTask_3001IncomingLinks(View view) {
		EolTask modelElement = (EolTask) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Task_Follows_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getEmlTask_3002IncomingLinks(View view) {
		EmlTask modelElement = (EmlTask) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Task_Follows_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getEglTask_3003IncomingLinks(View view) {
		EglTask modelElement = (EglTask) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Task_Follows_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getEtlTask_3004IncomingLinks(View view) {
		EtlTask modelElement = (EtlTask) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Task_Follows_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getEvlTask_3005IncomingLinks(View view) {
		EvlTask modelElement = (EvlTask) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Task_Follows_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getLoadEMFModelTask_3006IncomingLinks(
			View view) {
		LoadEMFModelTask modelElement = (LoadEMFModelTask) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Task_Follows_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getLoadXMLModelTask_3007IncomingLinks(
			View view) {
		LoadXMLModelTask modelElement = (LoadXMLModelTask) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Task_Follows_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getFlockTask_3008IncomingLinks(
			View view) {
		FlockTask modelElement = (FlockTask) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Task_Follows_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getEUnitTask_3009IncomingLinks(
			View view) {
		EUnitTask modelElement = (EUnitTask) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Task_Follows_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getEclTask_3010IncomingLinks(View view) {
		EclTask modelElement = (EclTask) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Task_Follows_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getLoadModelTask_3011IncomingLinks(
			View view) {
		LoadModelTask modelElement = (LoadModelTask) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Task_Follows_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getStoreModelTask_3012IncomingLinks(
			View view) {
		StoreModelTask modelElement = (StoreModelTask) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Task_Follows_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getRollbackTransactionTask_3013IncomingLinks(
			View view) {
		RollbackTransactionTask modelElement = (RollbackTransactionTask) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Task_Follows_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getDisposeModelTask_3014IncomingLinks(
			View view) {
		DisposeModelTask modelElement = (DisposeModelTask) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Task_Follows_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getStartTransactionTask_3015IncomingLinks(
			View view) {
		StartTransactionTask modelElement = (StartTransactionTask) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Task_Follows_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getCommitTransactionTask_3016IncomingLinks(
			View view) {
		CommitTransactionTask modelElement = (CommitTransactionTask) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Task_Follows_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getProperty_3017IncomingLinks(
			View view) {
		Property modelElement = (Property) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Task_Follows_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getNestedElement_3018IncomingLinks(
			View view) {
		NestedElement modelElement = (NestedElement) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Task_Follows_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getTask_3019IncomingLinks(View view) {
		Task modelElement = (Task) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Task_Follows_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getTarget_2001OutgoingLinks(View view) {
		Target modelElement = (Target) view.getElement();
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Target_Depends_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getEolTask_3001OutgoingLinks(View view) {
		EolTask modelElement = (EolTask) view.getElement();
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Task_Follows_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getEmlTask_3002OutgoingLinks(View view) {
		EmlTask modelElement = (EmlTask) view.getElement();
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Task_Follows_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getEglTask_3003OutgoingLinks(View view) {
		EglTask modelElement = (EglTask) view.getElement();
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Task_Follows_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getEtlTask_3004OutgoingLinks(View view) {
		EtlTask modelElement = (EtlTask) view.getElement();
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Task_Follows_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getEvlTask_3005OutgoingLinks(View view) {
		EvlTask modelElement = (EvlTask) view.getElement();
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Task_Follows_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getLoadEMFModelTask_3006OutgoingLinks(
			View view) {
		LoadEMFModelTask modelElement = (LoadEMFModelTask) view.getElement();
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Task_Follows_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getLoadXMLModelTask_3007OutgoingLinks(
			View view) {
		LoadXMLModelTask modelElement = (LoadXMLModelTask) view.getElement();
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Task_Follows_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getFlockTask_3008OutgoingLinks(
			View view) {
		FlockTask modelElement = (FlockTask) view.getElement();
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Task_Follows_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getEUnitTask_3009OutgoingLinks(
			View view) {
		EUnitTask modelElement = (EUnitTask) view.getElement();
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Task_Follows_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getEclTask_3010OutgoingLinks(View view) {
		EclTask modelElement = (EclTask) view.getElement();
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Task_Follows_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getLoadModelTask_3011OutgoingLinks(
			View view) {
		LoadModelTask modelElement = (LoadModelTask) view.getElement();
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Task_Follows_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getStoreModelTask_3012OutgoingLinks(
			View view) {
		StoreModelTask modelElement = (StoreModelTask) view.getElement();
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Task_Follows_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getRollbackTransactionTask_3013OutgoingLinks(
			View view) {
		RollbackTransactionTask modelElement = (RollbackTransactionTask) view
				.getElement();
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Task_Follows_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getDisposeModelTask_3014OutgoingLinks(
			View view) {
		DisposeModelTask modelElement = (DisposeModelTask) view.getElement();
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Task_Follows_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getStartTransactionTask_3015OutgoingLinks(
			View view) {
		StartTransactionTask modelElement = (StartTransactionTask) view
				.getElement();
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Task_Follows_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getCommitTransactionTask_3016OutgoingLinks(
			View view) {
		CommitTransactionTask modelElement = (CommitTransactionTask) view
				.getElement();
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Task_Follows_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getProperty_3017OutgoingLinks(
			View view) {
		Property modelElement = (Property) view.getElement();
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Task_Follows_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getNestedElement_3018OutgoingLinks(
			View view) {
		NestedElement modelElement = (NestedElement) view.getElement();
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Task_Follows_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<EweLinkDescriptor> getTask_3019OutgoingLinks(View view) {
		Task modelElement = (Task) view.getElement();
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Task_Follows_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<EweLinkDescriptor> getIncomingFeatureModelFacetLinks_Task_Follows_4001(
			Task target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == EwePackage.eINSTANCE
					.getTask_Follows()) {
				result.add(new EweLinkDescriptor(setting.getEObject(), target,
						EweElementTypes.TaskFollows_4001,
						TaskFollowsEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<EweLinkDescriptor> getIncomingFeatureModelFacetLinks_Target_Depends_4002(
			Target target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == EwePackage.eINSTANCE
					.getTarget_Depends()) {
				result.add(new EweLinkDescriptor(setting.getEObject(), target,
						EweElementTypes.TargetDepends_4002,
						TargetDependsEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<EweLinkDescriptor> getOutgoingFeatureModelFacetLinks_Task_Follows_4001(
			Task source) {
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		Task destination = source.getFollows();
		if (destination == null) {
			return result;
		}
		result.add(new EweLinkDescriptor(source, destination,
				EweElementTypes.TaskFollows_4001, TaskFollowsEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<EweLinkDescriptor> getOutgoingFeatureModelFacetLinks_Target_Depends_4002(
			Target source) {
		LinkedList<EweLinkDescriptor> result = new LinkedList<EweLinkDescriptor>();
		for (Iterator<?> destinations = source.getDepends().iterator(); destinations
				.hasNext();) {
			Target destination = (Target) destinations.next();
			result.add(new EweLinkDescriptor(source, destination,
					EweElementTypes.TargetDepends_4002,
					TargetDependsEditPart.VISUAL_ID));
		}
		return result;
	}

}
