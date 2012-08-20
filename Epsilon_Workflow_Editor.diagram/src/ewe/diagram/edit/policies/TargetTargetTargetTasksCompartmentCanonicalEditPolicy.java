/*
 * 
 */
package ewe.diagram.edit.policies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.DeferredLayoutCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetViewMutabilityCommand;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

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
import ewe.diagram.edit.parts.PropertyEditPart;
import ewe.diagram.edit.parts.RollbackTransactionTaskEditPart;
import ewe.diagram.edit.parts.StartTransactionTaskEditPart;
import ewe.diagram.edit.parts.StoreModelTaskEditPart;
import ewe.diagram.edit.parts.TaskEditPart;
import ewe.diagram.part.EweDiagramUpdater;
import ewe.diagram.part.EweNodeDescriptor;
import ewe.diagram.part.EweVisualIDRegistry;

/**
 * @generated
 */
public class TargetTargetTargetTasksCompartmentCanonicalEditPolicy extends
		CanonicalEditPolicy {

	/**
	 * @generated
	 */
	protected void refreshOnActivate() {
		// Need to activate editpart children before invoking the canonical refresh for EditParts to add event listeners
		List<?> c = getHost().getChildren();
		for (int i = 0; i < c.size(); i++) {
			((EditPart) c.get(i)).activate();
		}
		super.refreshOnActivate();
	}

	/**
	 * @generated
	 */
	protected EStructuralFeature getFeatureToSynchronize() {
		return EwePackage.eINSTANCE.getTarget_TargetTasks();
	}

	/**
	 * @generated
	 */
	@SuppressWarnings("rawtypes")
	protected List getSemanticChildrenList() {
		View viewObject = (View) getHost().getModel();
		LinkedList<EObject> result = new LinkedList<EObject>();
		List<EweNodeDescriptor> childDescriptors = EweDiagramUpdater
				.getTargetTargetTargetTasksCompartment_7001SemanticChildren(viewObject);
		for (EweNodeDescriptor d : childDescriptors) {
			result.add(d.getModelElement());
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected boolean isOrphaned(Collection<EObject> semanticChildren,
			final View view) {
		return isMyDiagramElement(view)
				&& !semanticChildren.contains(view.getElement());
	}

	/**
	 * @generated
	 */
	private boolean isMyDiagramElement(View view) {
		int visualID = EweVisualIDRegistry.getVisualID(view);
		switch (visualID) {
		case EolTaskEditPart.VISUAL_ID:
		case EmlTaskEditPart.VISUAL_ID:
		case EglTaskEditPart.VISUAL_ID:
		case EtlTaskEditPart.VISUAL_ID:
		case EvlTaskEditPart.VISUAL_ID:
		case LoadEMFModelTaskEditPart.VISUAL_ID:
		case LoadXMLModelTaskEditPart.VISUAL_ID:
		case FlockTaskEditPart.VISUAL_ID:
		case EUnitTaskEditPart.VISUAL_ID:
		case EclTaskEditPart.VISUAL_ID:
		case LoadModelTaskEditPart.VISUAL_ID:
		case StoreModelTaskEditPart.VISUAL_ID:
		case RollbackTransactionTaskEditPart.VISUAL_ID:
		case DisposeModelTaskEditPart.VISUAL_ID:
		case StartTransactionTaskEditPart.VISUAL_ID:
		case CommitTransactionTaskEditPart.VISUAL_ID:
		case PropertyEditPart.VISUAL_ID:
		case NestedElementEditPart.VISUAL_ID:
		case TaskEditPart.VISUAL_ID:
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void refreshSemantic() {
		if (resolveSemanticElement() == null) {
			return;
		}
		LinkedList<IAdaptable> createdViews = new LinkedList<IAdaptable>();
		List<EweNodeDescriptor> childDescriptors = EweDiagramUpdater
				.getTargetTargetTargetTasksCompartment_7001SemanticChildren((View) getHost()
						.getModel());
		LinkedList<View> orphaned = new LinkedList<View>();
		// we care to check only views we recognize as ours
		LinkedList<View> knownViewChildren = new LinkedList<View>();
		for (View v : getViewChildren()) {
			if (isMyDiagramElement(v)) {
				knownViewChildren.add(v);
			}
		}
		// alternative to #cleanCanonicalSemanticChildren(getViewChildren(), semanticChildren)
		//
		// iteration happens over list of desired semantic elements, trying to find best matching View, while original CEP
		// iterates views, potentially losing view (size/bounds) information - i.e. if there are few views to reference same EObject, only last one 
		// to answer isOrphaned == true will be used for the domain element representation, see #cleanCanonicalSemanticChildren()
		for (Iterator<EweNodeDescriptor> descriptorsIterator = childDescriptors
				.iterator(); descriptorsIterator.hasNext();) {
			EweNodeDescriptor next = descriptorsIterator.next();
			String hint = EweVisualIDRegistry.getType(next.getVisualID());
			LinkedList<View> perfectMatch = new LinkedList<View>(); // both semanticElement and hint match that of NodeDescriptor
			for (View childView : getViewChildren()) {
				EObject semanticElement = childView.getElement();
				if (next.getModelElement().equals(semanticElement)) {
					if (hint.equals(childView.getType())) {
						perfectMatch.add(childView);
						// actually, can stop iteration over view children here, but
						// may want to use not the first view but last one as a 'real' match (the way original CEP does
						// with its trick with viewToSemanticMap inside #cleanCanonicalSemanticChildren
					}
				}
			}
			if (perfectMatch.size() > 0) {
				descriptorsIterator.remove(); // precise match found no need to create anything for the NodeDescriptor
				// use only one view (first or last?), keep rest as orphaned for further consideration
				knownViewChildren.remove(perfectMatch.getFirst());
			}
		}
		// those left in knownViewChildren are subject to removal - they are our diagram elements we didn't find match to,
		// or those we have potential matches to, and thus need to be recreated, preserving size/location information.
		orphaned.addAll(knownViewChildren);
		//
		ArrayList<CreateViewRequest.ViewDescriptor> viewDescriptors = new ArrayList<CreateViewRequest.ViewDescriptor>(
				childDescriptors.size());
		for (EweNodeDescriptor next : childDescriptors) {
			String hint = EweVisualIDRegistry.getType(next.getVisualID());
			IAdaptable elementAdapter = new CanonicalElementAdapter(
					next.getModelElement(), hint);
			CreateViewRequest.ViewDescriptor descriptor = new CreateViewRequest.ViewDescriptor(
					elementAdapter, Node.class, hint, ViewUtil.APPEND, false,
					host().getDiagramPreferencesHint());
			viewDescriptors.add(descriptor);
		}

		boolean changed = deleteViews(orphaned.iterator());
		//
		CreateViewRequest request = getCreateViewRequest(viewDescriptors);
		Command cmd = getCreateViewCommand(request);
		if (cmd != null && cmd.canExecute()) {
			SetViewMutabilityCommand.makeMutable(
					new EObjectAdapter(host().getNotationView())).execute();
			executeCommand(cmd);
			@SuppressWarnings("unchecked")
			List<IAdaptable> nl = (List<IAdaptable>) request.getNewObject();
			createdViews.addAll(nl);
		}
		if (changed || createdViews.size() > 0) {
			postProcessRefreshSemantic(createdViews);
		}
		if (createdViews.size() > 1) {
			// perform a layout of the container
			DeferredLayoutCommand layoutCmd = new DeferredLayoutCommand(host()
					.getEditingDomain(), createdViews, host());
			executeCommand(new ICommandProxy(layoutCmd));
		}

		makeViewsImmutable(createdViews);
	}
}
