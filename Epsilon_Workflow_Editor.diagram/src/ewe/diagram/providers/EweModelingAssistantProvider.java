/*
 * 
 */
package ewe.diagram.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

import ewe.diagram.edit.parts.CommitTransactionTaskEditPart;
import ewe.diagram.edit.parts.DisposeModelTaskEditPart;
import ewe.diagram.edit.parts.DisposeModelsTaskEditPart;
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
import ewe.diagram.edit.parts.NestedElementEditPart;
import ewe.diagram.edit.parts.ProjectEditPart;
import ewe.diagram.edit.parts.RollbackTransactionTaskEditPart;
import ewe.diagram.edit.parts.StartTransactionTaskEditPart;
import ewe.diagram.edit.parts.StoreModelTaskEditPart;
import ewe.diagram.edit.parts.TargetEditPart;
import ewe.diagram.edit.parts.TargetTargetTargetTasksCompartmentEditPart;
import ewe.diagram.edit.parts.TaskEditPart;
import ewe.diagram.part.EweDiagramEditorPlugin;
import ewe.diagram.part.Messages;

/**
 * @generated
 */
public class EweModelingAssistantProvider extends ModelingAssistantProvider {

	/**
	 * @generated
	 */
	public List getTypesForPopupBar(IAdaptable host) {
		IGraphicalEditPart editPart = (IGraphicalEditPart) host
				.getAdapter(IGraphicalEditPart.class);
		if (editPart instanceof ProjectEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(EweElementTypes.Target_2001);
			return types;
		}
		if (editPart instanceof TargetTargetTargetTasksCompartmentEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(18);
			types.add(EweElementTypes.EolTask_3001);
			types.add(EweElementTypes.EmlTask_3002);
			types.add(EweElementTypes.EglTask_3003);
			types.add(EweElementTypes.EtlTask_3004);
			types.add(EweElementTypes.EvlTask_3005);
			types.add(EweElementTypes.LoadEMFModelTask_3006);
			types.add(EweElementTypes.FlockTask_3007);
			types.add(EweElementTypes.EUnitTask_3008);
			types.add(EweElementTypes.EclTask_3009);
			types.add(EweElementTypes.LoadModelTask_3010);
			types.add(EweElementTypes.StoreModelTask_3011);
			types.add(EweElementTypes.RollbackTransactionTask_3012);
			types.add(EweElementTypes.DisposeModelTask_3013);
			types.add(EweElementTypes.StartTransactionTask_3014);
			types.add(EweElementTypes.CommitTransactionTask_3015);
			types.add(EweElementTypes.DisposeModelsTask_3016);
			types.add(EweElementTypes.NestedElement_3017);
			types.add(EweElementTypes.Task_3018);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof TargetEditPart) {
			return ((TargetEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof EolTaskEditPart) {
			return ((EolTaskEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof EmlTaskEditPart) {
			return ((EmlTaskEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof EglTaskEditPart) {
			return ((EglTaskEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof EtlTaskEditPart) {
			return ((EtlTaskEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof EvlTaskEditPart) {
			return ((EvlTaskEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof LoadEMFModelTaskEditPart) {
			return ((LoadEMFModelTaskEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof FlockTaskEditPart) {
			return ((FlockTaskEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof EUnitTaskEditPart) {
			return ((EUnitTaskEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof EclTaskEditPart) {
			return ((EclTaskEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof LoadModelTaskEditPart) {
			return ((LoadModelTaskEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof StoreModelTaskEditPart) {
			return ((StoreModelTaskEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof RollbackTransactionTaskEditPart) {
			return ((RollbackTransactionTaskEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof DisposeModelTaskEditPart) {
			return ((DisposeModelTaskEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof StartTransactionTaskEditPart) {
			return ((StartTransactionTaskEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof CommitTransactionTaskEditPart) {
			return ((CommitTransactionTaskEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof DisposeModelsTaskEditPart) {
			return ((DisposeModelsTaskEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof NestedElementEditPart) {
			return ((NestedElementEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof TaskEditPart) {
			return ((TaskEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof TargetEditPart) {
			return ((TargetEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof EolTaskEditPart) {
			return ((EolTaskEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof EmlTaskEditPart) {
			return ((EmlTaskEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof EglTaskEditPart) {
			return ((EglTaskEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof EtlTaskEditPart) {
			return ((EtlTaskEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof EvlTaskEditPart) {
			return ((EvlTaskEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof LoadEMFModelTaskEditPart) {
			return ((LoadEMFModelTaskEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof FlockTaskEditPart) {
			return ((FlockTaskEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof EUnitTaskEditPart) {
			return ((EUnitTaskEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof EclTaskEditPart) {
			return ((EclTaskEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof LoadModelTaskEditPart) {
			return ((LoadModelTaskEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof StoreModelTaskEditPart) {
			return ((StoreModelTaskEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof RollbackTransactionTaskEditPart) {
			return ((RollbackTransactionTaskEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof DisposeModelTaskEditPart) {
			return ((DisposeModelTaskEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof StartTransactionTaskEditPart) {
			return ((StartTransactionTaskEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof CommitTransactionTaskEditPart) {
			return ((CommitTransactionTaskEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof DisposeModelsTaskEditPart) {
			return ((DisposeModelsTaskEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof NestedElementEditPart) {
			return ((NestedElementEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof TaskEditPart) {
			return ((TaskEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSourceAndTarget(IAdaptable source,
			IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof TargetEditPart) {
			return ((TargetEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof EolTaskEditPart) {
			return ((EolTaskEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof EmlTaskEditPart) {
			return ((EmlTaskEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof EglTaskEditPart) {
			return ((EglTaskEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof EtlTaskEditPart) {
			return ((EtlTaskEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof EvlTaskEditPart) {
			return ((EvlTaskEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof LoadEMFModelTaskEditPart) {
			return ((LoadEMFModelTaskEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof FlockTaskEditPart) {
			return ((FlockTaskEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof EUnitTaskEditPart) {
			return ((EUnitTaskEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof EclTaskEditPart) {
			return ((EclTaskEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof LoadModelTaskEditPart) {
			return ((LoadModelTaskEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof StoreModelTaskEditPart) {
			return ((StoreModelTaskEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof RollbackTransactionTaskEditPart) {
			return ((RollbackTransactionTaskEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof DisposeModelTaskEditPart) {
			return ((DisposeModelTaskEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof StartTransactionTaskEditPart) {
			return ((StartTransactionTaskEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof CommitTransactionTaskEditPart) {
			return ((CommitTransactionTaskEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof DisposeModelsTaskEditPart) {
			return ((DisposeModelsTaskEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof NestedElementEditPart) {
			return ((NestedElementEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof TaskEditPart) {
			return ((TaskEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForSource(IAdaptable target,
			IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof TargetEditPart) {
			return ((TargetEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof EolTaskEditPart) {
			return ((EolTaskEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof EmlTaskEditPart) {
			return ((EmlTaskEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof EglTaskEditPart) {
			return ((EglTaskEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof EtlTaskEditPart) {
			return ((EtlTaskEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof EvlTaskEditPart) {
			return ((EvlTaskEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof LoadEMFModelTaskEditPart) {
			return ((LoadEMFModelTaskEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof FlockTaskEditPart) {
			return ((FlockTaskEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof EUnitTaskEditPart) {
			return ((EUnitTaskEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof EclTaskEditPart) {
			return ((EclTaskEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof LoadModelTaskEditPart) {
			return ((LoadModelTaskEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof StoreModelTaskEditPart) {
			return ((StoreModelTaskEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof RollbackTransactionTaskEditPart) {
			return ((RollbackTransactionTaskEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof DisposeModelTaskEditPart) {
			return ((DisposeModelTaskEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof StartTransactionTaskEditPart) {
			return ((StartTransactionTaskEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof CommitTransactionTaskEditPart) {
			return ((CommitTransactionTaskEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof DisposeModelsTaskEditPart) {
			return ((DisposeModelsTaskEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof NestedElementEditPart) {
			return ((NestedElementEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof TaskEditPart) {
			return ((TaskEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForTarget(IAdaptable source,
			IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof TargetEditPart) {
			return ((TargetEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof EolTaskEditPart) {
			return ((EolTaskEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof EmlTaskEditPart) {
			return ((EmlTaskEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof EglTaskEditPart) {
			return ((EglTaskEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof EtlTaskEditPart) {
			return ((EtlTaskEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof EvlTaskEditPart) {
			return ((EvlTaskEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof LoadEMFModelTaskEditPart) {
			return ((LoadEMFModelTaskEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof FlockTaskEditPart) {
			return ((FlockTaskEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof EUnitTaskEditPart) {
			return ((EUnitTaskEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof EclTaskEditPart) {
			return ((EclTaskEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof LoadModelTaskEditPart) {
			return ((LoadModelTaskEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof StoreModelTaskEditPart) {
			return ((StoreModelTaskEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof RollbackTransactionTaskEditPart) {
			return ((RollbackTransactionTaskEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof DisposeModelTaskEditPart) {
			return ((DisposeModelTaskEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof StartTransactionTaskEditPart) {
			return ((StartTransactionTaskEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof CommitTransactionTaskEditPart) {
			return ((CommitTransactionTaskEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof DisposeModelsTaskEditPart) {
			return ((DisposeModelsTaskEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof NestedElementEditPart) {
			return ((NestedElementEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof TaskEditPart) {
			return ((TaskEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForSource(IAdaptable target,
			IElementType relationshipType) {
		return selectExistingElement(target,
				getTypesForSource(target, relationshipType));
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForTarget(IAdaptable source,
			IElementType relationshipType) {
		return selectExistingElement(source,
				getTypesForTarget(source, relationshipType));
	}

	/**
	 * @generated
	 */
	protected EObject selectExistingElement(IAdaptable host, Collection types) {
		if (types.isEmpty()) {
			return null;
		}
		IGraphicalEditPart editPart = (IGraphicalEditPart) host
				.getAdapter(IGraphicalEditPart.class);
		if (editPart == null) {
			return null;
		}
		Diagram diagram = (Diagram) editPart.getRoot().getContents().getModel();
		HashSet<EObject> elements = new HashSet<EObject>();
		for (Iterator<EObject> it = diagram.getElement().eAllContents(); it
				.hasNext();) {
			EObject element = it.next();
			if (isApplicableElement(element, types)) {
				elements.add(element);
			}
		}
		if (elements.isEmpty()) {
			return null;
		}
		return selectElement((EObject[]) elements.toArray(new EObject[elements
				.size()]));
	}

	/**
	 * @generated
	 */
	protected boolean isApplicableElement(EObject element, Collection types) {
		IElementType type = ElementTypeRegistry.getInstance().getElementType(
				element);
		return types.contains(type);
	}

	/**
	 * @generated
	 */
	protected EObject selectElement(EObject[] elements) {
		Shell shell = Display.getCurrent().getActiveShell();
		ILabelProvider labelProvider = new AdapterFactoryLabelProvider(
				EweDiagramEditorPlugin.getInstance()
						.getItemProvidersAdapterFactory());
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(
				shell, labelProvider);
		dialog.setMessage(Messages.EweModelingAssistantProviderMessage);
		dialog.setTitle(Messages.EweModelingAssistantProviderTitle);
		dialog.setMultipleSelection(false);
		dialog.setElements(elements);
		EObject selected = null;
		if (dialog.open() == Window.OK) {
			selected = (EObject) dialog.getFirstResult();
		}
		return selected;
	}
}
