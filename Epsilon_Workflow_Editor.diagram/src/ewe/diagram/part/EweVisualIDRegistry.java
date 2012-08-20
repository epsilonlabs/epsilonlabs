/*
 * 
 */
package ewe.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

import ewe.EwePackage;
import ewe.Project;
import ewe.diagram.edit.parts.CommitTransactionTaskEditPart;
import ewe.diagram.edit.parts.CommitTransactionTaskNameEditPart;
import ewe.diagram.edit.parts.DisposeModelTaskEditPart;
import ewe.diagram.edit.parts.DisposeModelTaskNameEditPart;
import ewe.diagram.edit.parts.EUnitTaskEditPart;
import ewe.diagram.edit.parts.EUnitTaskSrcEditPart;
import ewe.diagram.edit.parts.EclTaskEditPart;
import ewe.diagram.edit.parts.EclTaskSrcEditPart;
import ewe.diagram.edit.parts.EglTaskEditPart;
import ewe.diagram.edit.parts.EglTaskSrcEditPart;
import ewe.diagram.edit.parts.EmlTaskEditPart;
import ewe.diagram.edit.parts.EmlTaskSrcEditPart;
import ewe.diagram.edit.parts.EolTaskEditPart;
import ewe.diagram.edit.parts.EolTaskSrcEditPart;
import ewe.diagram.edit.parts.EtlTaskEditPart;
import ewe.diagram.edit.parts.EtlTaskSrcEditPart;
import ewe.diagram.edit.parts.EvlTaskEditPart;
import ewe.diagram.edit.parts.EvlTaskSrcEditPart;
import ewe.diagram.edit.parts.FlockTaskEditPart;
import ewe.diagram.edit.parts.FlockTaskSrcEditPart;
import ewe.diagram.edit.parts.LoadEMFModelTaskEditPart;
import ewe.diagram.edit.parts.LoadEMFModelTaskNameEditPart;
import ewe.diagram.edit.parts.LoadModelTaskEditPart;
import ewe.diagram.edit.parts.LoadModelTaskNameEditPart;
import ewe.diagram.edit.parts.LoadXMLModelTaskEditPart;
import ewe.diagram.edit.parts.LoadXMLModelTaskNameEditPart;
import ewe.diagram.edit.parts.NestedElementEditPart;
import ewe.diagram.edit.parts.NestedElementNameEditPart;
import ewe.diagram.edit.parts.ProjectEditPart;
import ewe.diagram.edit.parts.PropertyEditPart;
import ewe.diagram.edit.parts.PropertyNameEditPart;
import ewe.diagram.edit.parts.RollbackTransactionTaskEditPart;
import ewe.diagram.edit.parts.RollbackTransactionTaskNameEditPart;
import ewe.diagram.edit.parts.StartTransactionTaskEditPart;
import ewe.diagram.edit.parts.StartTransactionTaskNameEditPart;
import ewe.diagram.edit.parts.StoreModelTaskEditPart;
import ewe.diagram.edit.parts.StoreModelTaskNameEditPart;
import ewe.diagram.edit.parts.TargetDependsEditPart;
import ewe.diagram.edit.parts.TargetDependsExternalLabelEditPart;
import ewe.diagram.edit.parts.TargetEditPart;
import ewe.diagram.edit.parts.TargetNameEditPart;
import ewe.diagram.edit.parts.TargetTargetTargetTasksCompartmentEditPart;
import ewe.diagram.edit.parts.TaskEditPart;
import ewe.diagram.edit.parts.TaskFollowsEditPart;
import ewe.diagram.edit.parts.TaskFollowsExternalLabelEditPart;
import ewe.diagram.edit.parts.TaskNameEditPart;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class EweVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "Epsilon_Workflow_Editor.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (ProjectEditPart.MODEL_ID.equals(view.getType())) {
				return ProjectEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return ewe.diagram.part.EweVisualIDRegistry.getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(
					Platform.getDebugOption(DEBUG_KEY))) {
				EweDiagramEditorPlugin.getInstance().logError(
						"Unable to parse view type as a visualID number: "
								+ type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return Integer.toString(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (EwePackage.eINSTANCE.getProject().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((Project) domainElement)) {
			return ProjectEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = ewe.diagram.part.EweVisualIDRegistry
				.getModelID(containerView);
		if (!ProjectEditPart.MODEL_ID.equals(containerModelID)
				&& !"ewe".equals(containerModelID)) { //$NON-NLS-1$
			return -1;
		}
		int containerVisualID;
		if (ProjectEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = ewe.diagram.part.EweVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = ProjectEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case ProjectEditPart.VISUAL_ID:
			if (EwePackage.eINSTANCE.getTarget().isSuperTypeOf(
					domainElement.eClass())) {
				return TargetEditPart.VISUAL_ID;
			}
			break;
		case TargetTargetTargetTasksCompartmentEditPart.VISUAL_ID:
			if (EwePackage.eINSTANCE.getEolTask().isSuperTypeOf(
					domainElement.eClass())) {
				return EolTaskEditPart.VISUAL_ID;
			}
			if (EwePackage.eINSTANCE.getEmlTask().isSuperTypeOf(
					domainElement.eClass())) {
				return EmlTaskEditPart.VISUAL_ID;
			}
			if (EwePackage.eINSTANCE.getEglTask().isSuperTypeOf(
					domainElement.eClass())) {
				return EglTaskEditPart.VISUAL_ID;
			}
			if (EwePackage.eINSTANCE.getEtlTask().isSuperTypeOf(
					domainElement.eClass())) {
				return EtlTaskEditPart.VISUAL_ID;
			}
			if (EwePackage.eINSTANCE.getEvlTask().isSuperTypeOf(
					domainElement.eClass())) {
				return EvlTaskEditPart.VISUAL_ID;
			}
			if (EwePackage.eINSTANCE.getLoadEMFModelTask().isSuperTypeOf(
					domainElement.eClass())) {
				return LoadEMFModelTaskEditPart.VISUAL_ID;
			}
			if (EwePackage.eINSTANCE.getLoadXMLModelTask().isSuperTypeOf(
					domainElement.eClass())) {
				return LoadXMLModelTaskEditPart.VISUAL_ID;
			}
			if (EwePackage.eINSTANCE.getFlockTask().isSuperTypeOf(
					domainElement.eClass())) {
				return FlockTaskEditPart.VISUAL_ID;
			}
			if (EwePackage.eINSTANCE.getEUnitTask().isSuperTypeOf(
					domainElement.eClass())) {
				return EUnitTaskEditPart.VISUAL_ID;
			}
			if (EwePackage.eINSTANCE.getEclTask().isSuperTypeOf(
					domainElement.eClass())) {
				return EclTaskEditPart.VISUAL_ID;
			}
			if (EwePackage.eINSTANCE.getLoadModelTask().isSuperTypeOf(
					domainElement.eClass())) {
				return LoadModelTaskEditPart.VISUAL_ID;
			}
			if (EwePackage.eINSTANCE.getStoreModelTask().isSuperTypeOf(
					domainElement.eClass())) {
				return StoreModelTaskEditPart.VISUAL_ID;
			}
			if (EwePackage.eINSTANCE.getRollbackTransactionTask()
					.isSuperTypeOf(domainElement.eClass())) {
				return RollbackTransactionTaskEditPart.VISUAL_ID;
			}
			if (EwePackage.eINSTANCE.getDisposeModelTask().isSuperTypeOf(
					domainElement.eClass())) {
				return DisposeModelTaskEditPart.VISUAL_ID;
			}
			if (EwePackage.eINSTANCE.getStartTransactionTask().isSuperTypeOf(
					domainElement.eClass())) {
				return StartTransactionTaskEditPart.VISUAL_ID;
			}
			if (EwePackage.eINSTANCE.getCommitTransactionTask().isSuperTypeOf(
					domainElement.eClass())) {
				return CommitTransactionTaskEditPart.VISUAL_ID;
			}
			if (EwePackage.eINSTANCE.getProperty().isSuperTypeOf(
					domainElement.eClass())) {
				return PropertyEditPart.VISUAL_ID;
			}
			if (EwePackage.eINSTANCE.getNestedElement().isSuperTypeOf(
					domainElement.eClass())) {
				return NestedElementEditPart.VISUAL_ID;
			}
			if (EwePackage.eINSTANCE.getTask().isSuperTypeOf(
					domainElement.eClass())) {
				return TaskEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = ewe.diagram.part.EweVisualIDRegistry
				.getModelID(containerView);
		if (!ProjectEditPart.MODEL_ID.equals(containerModelID)
				&& !"ewe".equals(containerModelID)) { //$NON-NLS-1$
			return false;
		}
		int containerVisualID;
		if (ProjectEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = ewe.diagram.part.EweVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = ProjectEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case ProjectEditPart.VISUAL_ID:
			if (TargetEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TargetEditPart.VISUAL_ID:
			if (TargetNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TargetTargetTargetTasksCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EolTaskEditPart.VISUAL_ID:
			if (EolTaskSrcEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EmlTaskEditPart.VISUAL_ID:
			if (EmlTaskSrcEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EglTaskEditPart.VISUAL_ID:
			if (EglTaskSrcEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EtlTaskEditPart.VISUAL_ID:
			if (EtlTaskSrcEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EvlTaskEditPart.VISUAL_ID:
			if (EvlTaskSrcEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case LoadEMFModelTaskEditPart.VISUAL_ID:
			if (LoadEMFModelTaskNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case LoadXMLModelTaskEditPart.VISUAL_ID:
			if (LoadXMLModelTaskNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FlockTaskEditPart.VISUAL_ID:
			if (FlockTaskSrcEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EUnitTaskEditPart.VISUAL_ID:
			if (EUnitTaskSrcEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EclTaskEditPart.VISUAL_ID:
			if (EclTaskSrcEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case LoadModelTaskEditPart.VISUAL_ID:
			if (LoadModelTaskNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StoreModelTaskEditPart.VISUAL_ID:
			if (StoreModelTaskNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RollbackTransactionTaskEditPart.VISUAL_ID:
			if (RollbackTransactionTaskNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DisposeModelTaskEditPart.VISUAL_ID:
			if (DisposeModelTaskNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StartTransactionTaskEditPart.VISUAL_ID:
			if (StartTransactionTaskNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CommitTransactionTaskEditPart.VISUAL_ID:
			if (CommitTransactionTaskNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PropertyEditPart.VISUAL_ID:
			if (PropertyNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case NestedElementEditPart.VISUAL_ID:
			if (NestedElementNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TaskEditPart.VISUAL_ID:
			if (TaskNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TargetTargetTargetTasksCompartmentEditPart.VISUAL_ID:
			if (EolTaskEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EmlTaskEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EglTaskEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EtlTaskEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EvlTaskEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoadEMFModelTaskEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoadXMLModelTaskEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FlockTaskEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EUnitTaskEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EclTaskEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoadModelTaskEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StoreModelTaskEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RollbackTransactionTaskEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DisposeModelTaskEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StartTransactionTaskEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CommitTransactionTaskEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PropertyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (NestedElementEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TaskEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TaskFollowsEditPart.VISUAL_ID:
			if (TaskFollowsExternalLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TargetDependsEditPart.VISUAL_ID:
			if (TargetDependsExternalLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(Project element) {
		return true;
	}

}
