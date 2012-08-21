/*
 * 
 */
package ewe.diagram.navigator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonContentProvider;

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
import ewe.diagram.part.EweVisualIDRegistry;
import ewe.diagram.part.Messages;

/**
 * @generated
 */
public class EweNavigatorContentProvider implements ICommonContentProvider {

	/**
	 * @generated
	 */
	private static final Object[] EMPTY_ARRAY = new Object[0];

	/**
	 * @generated
	 */
	private Viewer myViewer;

	/**
	 * @generated
	 */
	private AdapterFactoryEditingDomain myEditingDomain;

	/**
	 * @generated
	 */
	private WorkspaceSynchronizer myWorkspaceSynchronizer;

	/**
	 * @generated
	 */
	private Runnable myViewerRefreshRunnable;

	/**
	 * @generated
	 */
	@SuppressWarnings({ "unchecked", "serial", "rawtypes" })
	public EweNavigatorContentProvider() {
		TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE
				.createEditingDomain();
		myEditingDomain = (AdapterFactoryEditingDomain) editingDomain;
		myEditingDomain.setResourceToReadOnlyMap(new HashMap() {
			public Object get(Object key) {
				if (!containsKey(key)) {
					put(key, Boolean.TRUE);
				}
				return super.get(key);
			}
		});
		myViewerRefreshRunnable = new Runnable() {
			public void run() {
				if (myViewer != null) {
					myViewer.refresh();
				}
			}
		};
		myWorkspaceSynchronizer = new WorkspaceSynchronizer(editingDomain,
				new WorkspaceSynchronizer.Delegate() {
					public void dispose() {
					}

					public boolean handleResourceChanged(final Resource resource) {
						unloadAllResources();
						asyncRefresh();
						return true;
					}

					public boolean handleResourceDeleted(Resource resource) {
						unloadAllResources();
						asyncRefresh();
						return true;
					}

					public boolean handleResourceMoved(Resource resource,
							final URI newURI) {
						unloadAllResources();
						asyncRefresh();
						return true;
					}
				});
	}

	/**
	 * @generated
	 */
	public void dispose() {
		myWorkspaceSynchronizer.dispose();
		myWorkspaceSynchronizer = null;
		myViewerRefreshRunnable = null;
		myViewer = null;
		unloadAllResources();
		((TransactionalEditingDomain) myEditingDomain).dispose();
		myEditingDomain = null;
	}

	/**
	 * @generated
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		myViewer = viewer;
	}

	/**
	 * @generated
	 */
	void unloadAllResources() {
		for (Resource nextResource : myEditingDomain.getResourceSet()
				.getResources()) {
			nextResource.unload();
		}
	}

	/**
	 * @generated
	 */
	void asyncRefresh() {
		if (myViewer != null && !myViewer.getControl().isDisposed()) {
			myViewer.getControl().getDisplay()
					.asyncExec(myViewerRefreshRunnable);
		}
	}

	/**
	 * @generated
	 */
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof IFile) {
			IFile file = (IFile) parentElement;
			URI fileURI = URI.createPlatformResourceURI(file.getFullPath()
					.toString(), true);
			Resource resource = myEditingDomain.getResourceSet().getResource(
					fileURI, true);
			ArrayList<EweNavigatorItem> result = new ArrayList<EweNavigatorItem>();
			ArrayList<View> topViews = new ArrayList<View>(resource
					.getContents().size());
			for (EObject o : resource.getContents()) {
				if (o instanceof View) {
					topViews.add((View) o);
				}
			}
			return result.toArray();
		}

		if (parentElement instanceof EweNavigatorGroup) {
			EweNavigatorGroup group = (EweNavigatorGroup) parentElement;
			return group.getChildren();
		}

		if (parentElement instanceof EweNavigatorItem) {
			EweNavigatorItem navigatorItem = (EweNavigatorItem) parentElement;
			if (navigatorItem.isLeaf() || !isOwnView(navigatorItem.getView())) {
				return EMPTY_ARRAY;
			}
			return getViewChildren(navigatorItem.getView(), parentElement);
		}

		/*
		 * Due to plugin.xml restrictions this code will be called only for views representing
		 * shortcuts to this diagram elements created on other diagrams. 
		 */
		if (parentElement instanceof IAdaptable) {
			View view = (View) ((IAdaptable) parentElement)
					.getAdapter(View.class);
			if (view != null) {
				return getViewChildren(view, parentElement);
			}
		}

		return EMPTY_ARRAY;
	}

	/**
	 * @generated
	 */
	private Object[] getViewChildren(View view, Object parentElement) {
		switch (EweVisualIDRegistry.getVisualID(view)) {

		case CommitTransactionTaskEditPart.VISUAL_ID: {
			LinkedList<EweAbstractNavigatorItem> result = new LinkedList<EweAbstractNavigatorItem>();
			Node sv = (Node) view;
			EweNavigatorGroup incominglinks = new EweNavigatorGroup(
					Messages.NavigatorGroupName_CommitTransactionTask_3016_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			EweNavigatorGroup outgoinglinks = new EweNavigatorGroup(
					Messages.NavigatorGroupName_CommitTransactionTask_3016_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(TaskFollowsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(TaskFollowsEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case FlockTaskEditPart.VISUAL_ID: {
			LinkedList<EweAbstractNavigatorItem> result = new LinkedList<EweAbstractNavigatorItem>();
			Node sv = (Node) view;
			EweNavigatorGroup incominglinks = new EweNavigatorGroup(
					Messages.NavigatorGroupName_FlockTask_3008_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			EweNavigatorGroup outgoinglinks = new EweNavigatorGroup(
					Messages.NavigatorGroupName_FlockTask_3008_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(TaskFollowsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(TaskFollowsEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case StoreModelTaskEditPart.VISUAL_ID: {
			LinkedList<EweAbstractNavigatorItem> result = new LinkedList<EweAbstractNavigatorItem>();
			Node sv = (Node) view;
			EweNavigatorGroup incominglinks = new EweNavigatorGroup(
					Messages.NavigatorGroupName_StoreModelTask_3012_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			EweNavigatorGroup outgoinglinks = new EweNavigatorGroup(
					Messages.NavigatorGroupName_StoreModelTask_3012_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(TaskFollowsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(TaskFollowsEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case EvlTaskEditPart.VISUAL_ID: {
			LinkedList<EweAbstractNavigatorItem> result = new LinkedList<EweAbstractNavigatorItem>();
			Node sv = (Node) view;
			EweNavigatorGroup incominglinks = new EweNavigatorGroup(
					Messages.NavigatorGroupName_EvlTask_3005_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			EweNavigatorGroup outgoinglinks = new EweNavigatorGroup(
					Messages.NavigatorGroupName_EvlTask_3005_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(TaskFollowsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(TaskFollowsEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case EmlTaskEditPart.VISUAL_ID: {
			LinkedList<EweAbstractNavigatorItem> result = new LinkedList<EweAbstractNavigatorItem>();
			Node sv = (Node) view;
			EweNavigatorGroup incominglinks = new EweNavigatorGroup(
					Messages.NavigatorGroupName_EmlTask_3002_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			EweNavigatorGroup outgoinglinks = new EweNavigatorGroup(
					Messages.NavigatorGroupName_EmlTask_3002_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(TaskFollowsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(TaskFollowsEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case LoadEMFModelTaskEditPart.VISUAL_ID: {
			LinkedList<EweAbstractNavigatorItem> result = new LinkedList<EweAbstractNavigatorItem>();
			Node sv = (Node) view;
			EweNavigatorGroup incominglinks = new EweNavigatorGroup(
					Messages.NavigatorGroupName_LoadEMFModelTask_3006_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			EweNavigatorGroup outgoinglinks = new EweNavigatorGroup(
					Messages.NavigatorGroupName_LoadEMFModelTask_3006_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(TaskFollowsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(TaskFollowsEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case DisposeModelTaskEditPart.VISUAL_ID: {
			LinkedList<EweAbstractNavigatorItem> result = new LinkedList<EweAbstractNavigatorItem>();
			Node sv = (Node) view;
			EweNavigatorGroup incominglinks = new EweNavigatorGroup(
					Messages.NavigatorGroupName_DisposeModelTask_3014_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			EweNavigatorGroup outgoinglinks = new EweNavigatorGroup(
					Messages.NavigatorGroupName_DisposeModelTask_3014_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(TaskFollowsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(TaskFollowsEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case EUnitTaskEditPart.VISUAL_ID: {
			LinkedList<EweAbstractNavigatorItem> result = new LinkedList<EweAbstractNavigatorItem>();
			Node sv = (Node) view;
			EweNavigatorGroup incominglinks = new EweNavigatorGroup(
					Messages.NavigatorGroupName_EUnitTask_3009_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			EweNavigatorGroup outgoinglinks = new EweNavigatorGroup(
					Messages.NavigatorGroupName_EUnitTask_3009_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(TaskFollowsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(TaskFollowsEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case NestedElementEditPart.VISUAL_ID: {
			LinkedList<EweAbstractNavigatorItem> result = new LinkedList<EweAbstractNavigatorItem>();
			Node sv = (Node) view;
			EweNavigatorGroup incominglinks = new EweNavigatorGroup(
					Messages.NavigatorGroupName_NestedElement_3018_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			EweNavigatorGroup outgoinglinks = new EweNavigatorGroup(
					Messages.NavigatorGroupName_NestedElement_3018_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(TaskFollowsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(TaskFollowsEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case EglTaskEditPart.VISUAL_ID: {
			LinkedList<EweAbstractNavigatorItem> result = new LinkedList<EweAbstractNavigatorItem>();
			Node sv = (Node) view;
			EweNavigatorGroup incominglinks = new EweNavigatorGroup(
					Messages.NavigatorGroupName_EglTask_3003_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			EweNavigatorGroup outgoinglinks = new EweNavigatorGroup(
					Messages.NavigatorGroupName_EglTask_3003_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(TaskFollowsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(TaskFollowsEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case TaskFollowsEditPart.VISUAL_ID: {
			LinkedList<EweAbstractNavigatorItem> result = new LinkedList<EweAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			EweNavigatorGroup target = new EweNavigatorGroup(
					Messages.NavigatorGroupName_TaskFollows_4001_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			EweNavigatorGroup source = new EweNavigatorGroup(
					Messages.NavigatorGroupName_TaskFollows_4001_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(EolTaskEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(EmlTaskEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(EglTaskEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(EtlTaskEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(EvlTaskEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EweVisualIDRegistry
							.getType(LoadEMFModelTaskEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EweVisualIDRegistry
							.getType(LoadXMLModelTaskEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(FlockTaskEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(EUnitTaskEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(EclTaskEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EweVisualIDRegistry
							.getType(LoadModelTaskEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EweVisualIDRegistry
							.getType(StoreModelTaskEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EweVisualIDRegistry
							.getType(RollbackTransactionTaskEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EweVisualIDRegistry
							.getType(DisposeModelTaskEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EweVisualIDRegistry
							.getType(StartTransactionTaskEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EweVisualIDRegistry
							.getType(CommitTransactionTaskEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(PropertyEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EweVisualIDRegistry
							.getType(NestedElementEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(TaskEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(EolTaskEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(EmlTaskEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(EglTaskEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(EtlTaskEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(EvlTaskEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EweVisualIDRegistry
							.getType(LoadEMFModelTaskEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EweVisualIDRegistry
							.getType(LoadXMLModelTaskEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(FlockTaskEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(EUnitTaskEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(EclTaskEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EweVisualIDRegistry
							.getType(LoadModelTaskEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EweVisualIDRegistry
							.getType(StoreModelTaskEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EweVisualIDRegistry
							.getType(RollbackTransactionTaskEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EweVisualIDRegistry
							.getType(DisposeModelTaskEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EweVisualIDRegistry
							.getType(StartTransactionTaskEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EweVisualIDRegistry
							.getType(CommitTransactionTaskEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(PropertyEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EweVisualIDRegistry
							.getType(NestedElementEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(TaskEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case LoadModelTaskEditPart.VISUAL_ID: {
			LinkedList<EweAbstractNavigatorItem> result = new LinkedList<EweAbstractNavigatorItem>();
			Node sv = (Node) view;
			EweNavigatorGroup incominglinks = new EweNavigatorGroup(
					Messages.NavigatorGroupName_LoadModelTask_3011_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			EweNavigatorGroup outgoinglinks = new EweNavigatorGroup(
					Messages.NavigatorGroupName_LoadModelTask_3011_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(TaskFollowsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(TaskFollowsEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ProjectEditPart.VISUAL_ID: {
			LinkedList<EweAbstractNavigatorItem> result = new LinkedList<EweAbstractNavigatorItem>();
			result.addAll(getForeignShortcuts((Diagram) view, parentElement));
			Diagram sv = (Diagram) view;
			EweNavigatorGroup links = new EweNavigatorGroup(
					Messages.NavigatorGroupName_Project_1000_links,
					"icons/linksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(TargetEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(TaskFollowsEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					EweVisualIDRegistry
							.getType(TargetDependsEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			if (!links.isEmpty()) {
				result.add(links);
			}
			return result.toArray();
		}

		case EclTaskEditPart.VISUAL_ID: {
			LinkedList<EweAbstractNavigatorItem> result = new LinkedList<EweAbstractNavigatorItem>();
			Node sv = (Node) view;
			EweNavigatorGroup incominglinks = new EweNavigatorGroup(
					Messages.NavigatorGroupName_EclTask_3010_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			EweNavigatorGroup outgoinglinks = new EweNavigatorGroup(
					Messages.NavigatorGroupName_EclTask_3010_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(TaskFollowsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(TaskFollowsEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case RollbackTransactionTaskEditPart.VISUAL_ID: {
			LinkedList<EweAbstractNavigatorItem> result = new LinkedList<EweAbstractNavigatorItem>();
			Node sv = (Node) view;
			EweNavigatorGroup incominglinks = new EweNavigatorGroup(
					Messages.NavigatorGroupName_RollbackTransactionTask_3013_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			EweNavigatorGroup outgoinglinks = new EweNavigatorGroup(
					Messages.NavigatorGroupName_RollbackTransactionTask_3013_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(TaskFollowsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(TaskFollowsEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case EtlTaskEditPart.VISUAL_ID: {
			LinkedList<EweAbstractNavigatorItem> result = new LinkedList<EweAbstractNavigatorItem>();
			Node sv = (Node) view;
			EweNavigatorGroup incominglinks = new EweNavigatorGroup(
					Messages.NavigatorGroupName_EtlTask_3004_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			EweNavigatorGroup outgoinglinks = new EweNavigatorGroup(
					Messages.NavigatorGroupName_EtlTask_3004_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(TaskFollowsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(TaskFollowsEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case TargetDependsEditPart.VISUAL_ID: {
			LinkedList<EweAbstractNavigatorItem> result = new LinkedList<EweAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			EweNavigatorGroup target = new EweNavigatorGroup(
					Messages.NavigatorGroupName_TargetDepends_4002_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			EweNavigatorGroup source = new EweNavigatorGroup(
					Messages.NavigatorGroupName_TargetDepends_4002_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(TargetEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(TargetEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case TaskEditPart.VISUAL_ID: {
			LinkedList<EweAbstractNavigatorItem> result = new LinkedList<EweAbstractNavigatorItem>();
			Node sv = (Node) view;
			EweNavigatorGroup incominglinks = new EweNavigatorGroup(
					Messages.NavigatorGroupName_Task_3019_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			EweNavigatorGroup outgoinglinks = new EweNavigatorGroup(
					Messages.NavigatorGroupName_Task_3019_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(TaskFollowsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(TaskFollowsEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case StartTransactionTaskEditPart.VISUAL_ID: {
			LinkedList<EweAbstractNavigatorItem> result = new LinkedList<EweAbstractNavigatorItem>();
			Node sv = (Node) view;
			EweNavigatorGroup incominglinks = new EweNavigatorGroup(
					Messages.NavigatorGroupName_StartTransactionTask_3015_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			EweNavigatorGroup outgoinglinks = new EweNavigatorGroup(
					Messages.NavigatorGroupName_StartTransactionTask_3015_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(TaskFollowsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(TaskFollowsEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case TargetEditPart.VISUAL_ID: {
			LinkedList<EweAbstractNavigatorItem> result = new LinkedList<EweAbstractNavigatorItem>();
			Node sv = (Node) view;
			EweNavigatorGroup incominglinks = new EweNavigatorGroup(
					Messages.NavigatorGroupName_Target_2001_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			EweNavigatorGroup outgoinglinks = new EweNavigatorGroup(
					Messages.NavigatorGroupName_Target_2001_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					EweVisualIDRegistry
							.getType(TargetTargetTargetTasksCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EweVisualIDRegistry.getType(EolTaskEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					EweVisualIDRegistry
							.getType(TargetTargetTargetTasksCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EweVisualIDRegistry.getType(EmlTaskEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					EweVisualIDRegistry
							.getType(TargetTargetTargetTasksCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EweVisualIDRegistry.getType(EglTaskEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					EweVisualIDRegistry
							.getType(TargetTargetTargetTasksCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EweVisualIDRegistry.getType(EtlTaskEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					EweVisualIDRegistry
							.getType(TargetTargetTargetTasksCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EweVisualIDRegistry.getType(EvlTaskEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					EweVisualIDRegistry
							.getType(TargetTargetTargetTasksCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EweVisualIDRegistry
							.getType(LoadEMFModelTaskEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					EweVisualIDRegistry
							.getType(TargetTargetTargetTasksCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EweVisualIDRegistry
							.getType(LoadXMLModelTaskEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					EweVisualIDRegistry
							.getType(TargetTargetTargetTasksCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EweVisualIDRegistry.getType(FlockTaskEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					EweVisualIDRegistry
							.getType(TargetTargetTargetTasksCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EweVisualIDRegistry.getType(EUnitTaskEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					EweVisualIDRegistry
							.getType(TargetTargetTargetTasksCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EweVisualIDRegistry.getType(EclTaskEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					EweVisualIDRegistry
							.getType(TargetTargetTargetTasksCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EweVisualIDRegistry
							.getType(LoadModelTaskEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					EweVisualIDRegistry
							.getType(TargetTargetTargetTasksCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EweVisualIDRegistry
							.getType(StoreModelTaskEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					EweVisualIDRegistry
							.getType(TargetTargetTargetTasksCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EweVisualIDRegistry
							.getType(RollbackTransactionTaskEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					EweVisualIDRegistry
							.getType(TargetTargetTargetTasksCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EweVisualIDRegistry
							.getType(DisposeModelTaskEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					EweVisualIDRegistry
							.getType(TargetTargetTargetTasksCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EweVisualIDRegistry
							.getType(StartTransactionTaskEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					EweVisualIDRegistry
							.getType(TargetTargetTargetTasksCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EweVisualIDRegistry
							.getType(CommitTransactionTaskEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					EweVisualIDRegistry
							.getType(TargetTargetTargetTasksCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EweVisualIDRegistry.getType(PropertyEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					EweVisualIDRegistry
							.getType(TargetTargetTargetTasksCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EweVisualIDRegistry
							.getType(NestedElementEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					EweVisualIDRegistry
							.getType(TargetTargetTargetTasksCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					EweVisualIDRegistry.getType(TaskEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EweVisualIDRegistry
							.getType(TargetDependsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EweVisualIDRegistry
							.getType(TargetDependsEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case PropertyEditPart.VISUAL_ID: {
			LinkedList<EweAbstractNavigatorItem> result = new LinkedList<EweAbstractNavigatorItem>();
			Node sv = (Node) view;
			EweNavigatorGroup incominglinks = new EweNavigatorGroup(
					Messages.NavigatorGroupName_Property_3017_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			EweNavigatorGroup outgoinglinks = new EweNavigatorGroup(
					Messages.NavigatorGroupName_Property_3017_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(TaskFollowsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(TaskFollowsEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case LoadXMLModelTaskEditPart.VISUAL_ID: {
			LinkedList<EweAbstractNavigatorItem> result = new LinkedList<EweAbstractNavigatorItem>();
			Node sv = (Node) view;
			EweNavigatorGroup incominglinks = new EweNavigatorGroup(
					Messages.NavigatorGroupName_LoadXMLModelTask_3007_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			EweNavigatorGroup outgoinglinks = new EweNavigatorGroup(
					Messages.NavigatorGroupName_LoadXMLModelTask_3007_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(TaskFollowsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(TaskFollowsEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case EolTaskEditPart.VISUAL_ID: {
			LinkedList<EweAbstractNavigatorItem> result = new LinkedList<EweAbstractNavigatorItem>();
			Node sv = (Node) view;
			EweNavigatorGroup incominglinks = new EweNavigatorGroup(
					Messages.NavigatorGroupName_EolTask_3001_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			EweNavigatorGroup outgoinglinks = new EweNavigatorGroup(
					Messages.NavigatorGroupName_EolTask_3001_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(TaskFollowsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					EweVisualIDRegistry.getType(TaskFollowsEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}
		}
		return EMPTY_ARRAY;
	}

	/**
	 * @generated
	 */
	private Collection<View> getLinksSourceByType(Collection<Edge> edges,
			String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (Edge nextEdge : edges) {
			View nextEdgeSource = nextEdge.getSource();
			if (type.equals(nextEdgeSource.getType())
					&& isOwnView(nextEdgeSource)) {
				result.add(nextEdgeSource);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getLinksTargetByType(Collection<Edge> edges,
			String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (Edge nextEdge : edges) {
			View nextEdgeTarget = nextEdge.getTarget();
			if (type.equals(nextEdgeTarget.getType())
					&& isOwnView(nextEdgeTarget)) {
				result.add(nextEdgeTarget);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getOutgoingLinksByType(
			Collection<? extends View> nodes, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (View nextNode : nodes) {
			result.addAll(selectViewsByType(nextNode.getSourceEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getIncomingLinksByType(
			Collection<? extends View> nodes, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (View nextNode : nodes) {
			result.addAll(selectViewsByType(nextNode.getTargetEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getChildrenByType(
			Collection<? extends View> nodes, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (View nextNode : nodes) {
			result.addAll(selectViewsByType(nextNode.getChildren(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getDiagramLinksByType(
			Collection<Diagram> diagrams, String type) {
		ArrayList<View> result = new ArrayList<View>();
		for (Diagram nextDiagram : diagrams) {
			result.addAll(selectViewsByType(nextDiagram.getEdges(), type));
		}
		return result;
	}

	// TODO refactor as static method
	/**
	 * @generated
	 */
	private Collection<View> selectViewsByType(Collection<View> views,
			String type) {
		ArrayList<View> result = new ArrayList<View>();
		for (View nextView : views) {
			if (type.equals(nextView.getType()) && isOwnView(nextView)) {
				result.add(nextView);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return ProjectEditPart.MODEL_ID.equals(EweVisualIDRegistry
				.getModelID(view));
	}

	/**
	 * @generated
	 */
	private Collection<EweNavigatorItem> createNavigatorItems(
			Collection<View> views, Object parent, boolean isLeafs) {
		ArrayList<EweNavigatorItem> result = new ArrayList<EweNavigatorItem>(
				views.size());
		for (View nextView : views) {
			result.add(new EweNavigatorItem(nextView, parent, isLeafs));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<EweNavigatorItem> getForeignShortcuts(Diagram diagram,
			Object parent) {
		LinkedList<View> result = new LinkedList<View>();
		for (Iterator<View> it = diagram.getChildren().iterator(); it.hasNext();) {
			View nextView = it.next();
			if (!isOwnView(nextView)
					&& nextView.getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
				result.add(nextView);
			}
		}
		return createNavigatorItems(result, parent, false);
	}

	/**
	 * @generated
	 */
	public Object getParent(Object element) {
		if (element instanceof EweAbstractNavigatorItem) {
			EweAbstractNavigatorItem abstractNavigatorItem = (EweAbstractNavigatorItem) element;
			return abstractNavigatorItem.getParent();
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean hasChildren(Object element) {
		return element instanceof IFile || getChildren(element).length > 0;
	}

}
