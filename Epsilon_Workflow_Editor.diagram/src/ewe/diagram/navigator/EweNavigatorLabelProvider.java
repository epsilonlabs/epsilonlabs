/*
 * 
 */
package ewe.diagram.navigator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.ui.services.parser.CommonParserHint;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

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
import ewe.diagram.edit.parts.TargetEditPart;
import ewe.diagram.edit.parts.TargetNameEditPart;
import ewe.diagram.edit.parts.TaskEditPart;
import ewe.diagram.edit.parts.TaskFollowsEditPart;
import ewe.diagram.edit.parts.TaskNameEditPart;
import ewe.diagram.part.EweDiagramEditorPlugin;
import ewe.diagram.part.EweVisualIDRegistry;
import ewe.diagram.providers.EweElementTypes;
import ewe.diagram.providers.EweParserProvider;

/**
 * @generated
 */
public class EweNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		EweDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		EweDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof EweNavigatorItem
				&& !isOwnView(((EweNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof EweNavigatorGroup) {
			EweNavigatorGroup group = (EweNavigatorGroup) element;
			return EweDiagramEditorPlugin.getInstance().getBundledImage(
					group.getIcon());
		}

		if (element instanceof EweNavigatorItem) {
			EweNavigatorItem navigatorItem = (EweNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		// Due to plugin.xml content will be called only for "own" views
		if (element instanceof IAdaptable) {
			View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null && isOwnView(view)) {
				return getImage(view);
			}
		}

		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (EweVisualIDRegistry.getVisualID(view)) {
		case CommitTransactionTaskEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?ewe?CommitTransactionTask", EweElementTypes.CommitTransactionTask_3016); //$NON-NLS-1$
		case FlockTaskEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?ewe?FlockTask", EweElementTypes.FlockTask_3008); //$NON-NLS-1$
		case StoreModelTaskEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?ewe?StoreModelTask", EweElementTypes.StoreModelTask_3012); //$NON-NLS-1$
		case EvlTaskEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?ewe?EvlTask", EweElementTypes.EvlTask_3005); //$NON-NLS-1$
		case EmlTaskEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?ewe?EmlTask", EweElementTypes.EmlTask_3002); //$NON-NLS-1$
		case LoadEMFModelTaskEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?ewe?LoadEMFModelTask", EweElementTypes.LoadEMFModelTask_3006); //$NON-NLS-1$
		case DisposeModelTaskEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?ewe?DisposeModelTask", EweElementTypes.DisposeModelTask_3014); //$NON-NLS-1$
		case EUnitTaskEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?ewe?EUnitTask", EweElementTypes.EUnitTask_3009); //$NON-NLS-1$
		case NestedElementEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?ewe?NestedElement", EweElementTypes.NestedElement_3018); //$NON-NLS-1$
		case EglTaskEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?ewe?EglTask", EweElementTypes.EglTask_3003); //$NON-NLS-1$
		case TaskFollowsEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?ewe?Task?follows", EweElementTypes.TaskFollows_4001); //$NON-NLS-1$
		case LoadModelTaskEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?ewe?LoadModelTask", EweElementTypes.LoadModelTask_3011); //$NON-NLS-1$
		case ProjectEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?ewe?Project", EweElementTypes.Project_1000); //$NON-NLS-1$
		case EclTaskEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?ewe?EclTask", EweElementTypes.EclTask_3010); //$NON-NLS-1$
		case RollbackTransactionTaskEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?ewe?RollbackTransactionTask", EweElementTypes.RollbackTransactionTask_3013); //$NON-NLS-1$
		case EtlTaskEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?ewe?EtlTask", EweElementTypes.EtlTask_3004); //$NON-NLS-1$
		case TargetDependsEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?ewe?Target?depends", EweElementTypes.TargetDepends_4002); //$NON-NLS-1$
		case TaskEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?ewe?Task", EweElementTypes.Task_3019); //$NON-NLS-1$
		case StartTransactionTaskEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?ewe?StartTransactionTask", EweElementTypes.StartTransactionTask_3015); //$NON-NLS-1$
		case TargetEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?ewe?Target", EweElementTypes.Target_2001); //$NON-NLS-1$
		case PropertyEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?ewe?Property", EweElementTypes.Property_3017); //$NON-NLS-1$
		case LoadXMLModelTaskEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?ewe?LoadXMLModelTask", EweElementTypes.LoadXMLModelTask_3007); //$NON-NLS-1$
		case EolTaskEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?ewe?EolTask", EweElementTypes.EolTask_3001); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = EweDiagramEditorPlugin.getInstance()
				.getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& EweElementTypes.isKnownElementType(elementType)) {
			image = EweElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public String getText(Object element) {
		if (element instanceof EweNavigatorGroup) {
			EweNavigatorGroup group = (EweNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof EweNavigatorItem) {
			EweNavigatorItem navigatorItem = (EweNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		// Due to plugin.xml content will be called only for "own" views
		if (element instanceof IAdaptable) {
			View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null && isOwnView(view)) {
				return getText(view);
			}
		}

		return super.getText(element);
	}

	/**
	 * @generated
	 */
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (EweVisualIDRegistry.getVisualID(view)) {
		case CommitTransactionTaskEditPart.VISUAL_ID:
			return getCommitTransactionTask_3016Text(view);
		case FlockTaskEditPart.VISUAL_ID:
			return getFlockTask_3008Text(view);
		case StoreModelTaskEditPart.VISUAL_ID:
			return getStoreModelTask_3012Text(view);
		case EvlTaskEditPart.VISUAL_ID:
			return getEvlTask_3005Text(view);
		case EmlTaskEditPart.VISUAL_ID:
			return getEmlTask_3002Text(view);
		case LoadEMFModelTaskEditPart.VISUAL_ID:
			return getLoadEMFModelTask_3006Text(view);
		case DisposeModelTaskEditPart.VISUAL_ID:
			return getDisposeModelTask_3014Text(view);
		case EUnitTaskEditPart.VISUAL_ID:
			return getEUnitTask_3009Text(view);
		case NestedElementEditPart.VISUAL_ID:
			return getNestedElement_3018Text(view);
		case EglTaskEditPart.VISUAL_ID:
			return getEglTask_3003Text(view);
		case TaskFollowsEditPart.VISUAL_ID:
			return getTaskFollows_4001Text(view);
		case LoadModelTaskEditPart.VISUAL_ID:
			return getLoadModelTask_3011Text(view);
		case ProjectEditPart.VISUAL_ID:
			return getProject_1000Text(view);
		case EclTaskEditPart.VISUAL_ID:
			return getEclTask_3010Text(view);
		case RollbackTransactionTaskEditPart.VISUAL_ID:
			return getRollbackTransactionTask_3013Text(view);
		case EtlTaskEditPart.VISUAL_ID:
			return getEtlTask_3004Text(view);
		case TargetDependsEditPart.VISUAL_ID:
			return getTargetDepends_4002Text(view);
		case TaskEditPart.VISUAL_ID:
			return getTask_3019Text(view);
		case StartTransactionTaskEditPart.VISUAL_ID:
			return getStartTransactionTask_3015Text(view);
		case TargetEditPart.VISUAL_ID:
			return getTarget_2001Text(view);
		case PropertyEditPart.VISUAL_ID:
			return getProperty_3017Text(view);
		case LoadXMLModelTaskEditPart.VISUAL_ID:
			return getLoadXMLModelTask_3007Text(view);
		case EolTaskEditPart.VISUAL_ID:
			return getEolTask_3001Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getCommitTransactionTask_3016Text(View view) {
		IParser parser = EweParserProvider.getParser(
				EweElementTypes.CommitTransactionTask_3016,
				view.getElement() != null ? view.getElement() : view,
				EweVisualIDRegistry
						.getType(CommitTransactionTaskNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EweDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5016); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFlockTask_3008Text(View view) {
		IParser parser = EweParserProvider.getParser(
				EweElementTypes.FlockTask_3008,
				view.getElement() != null ? view.getElement() : view,
				EweVisualIDRegistry.getType(FlockTaskSrcEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EweDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5008); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getStoreModelTask_3012Text(View view) {
		IParser parser = EweParserProvider.getParser(
				EweElementTypes.StoreModelTask_3012,
				view.getElement() != null ? view.getElement() : view,
				EweVisualIDRegistry
						.getType(StoreModelTaskNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EweDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5012); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEvlTask_3005Text(View view) {
		IParser parser = EweParserProvider.getParser(
				EweElementTypes.EvlTask_3005,
				view.getElement() != null ? view.getElement() : view,
				EweVisualIDRegistry.getType(EvlTaskSrcEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EweDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEmlTask_3002Text(View view) {
		IParser parser = EweParserProvider.getParser(
				EweElementTypes.EmlTask_3002,
				view.getElement() != null ? view.getElement() : view,
				EweVisualIDRegistry.getType(EmlTaskSrcEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EweDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getLoadEMFModelTask_3006Text(View view) {
		IParser parser = EweParserProvider.getParser(
				EweElementTypes.LoadEMFModelTask_3006,
				view.getElement() != null ? view.getElement() : view,
				EweVisualIDRegistry
						.getType(LoadEMFModelTaskNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EweDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDisposeModelTask_3014Text(View view) {
		IParser parser = EweParserProvider.getParser(
				EweElementTypes.DisposeModelTask_3014,
				view.getElement() != null ? view.getElement() : view,
				EweVisualIDRegistry
						.getType(DisposeModelTaskNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EweDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5014); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEUnitTask_3009Text(View view) {
		IParser parser = EweParserProvider.getParser(
				EweElementTypes.EUnitTask_3009,
				view.getElement() != null ? view.getElement() : view,
				EweVisualIDRegistry.getType(EUnitTaskSrcEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EweDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5009); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getNestedElement_3018Text(View view) {
		IParser parser = EweParserProvider.getParser(
				EweElementTypes.NestedElement_3018,
				view.getElement() != null ? view.getElement() : view,
				EweVisualIDRegistry
						.getType(NestedElementNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EweDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5018); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEglTask_3003Text(View view) {
		IParser parser = EweParserProvider.getParser(
				EweElementTypes.EglTask_3003,
				view.getElement() != null ? view.getElement() : view,
				EweVisualIDRegistry.getType(EglTaskSrcEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EweDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getTaskFollows_4001Text(View view) {
		IParser parser = EweParserProvider.getParser(
				EweElementTypes.TaskFollows_4001,
				view.getElement() != null ? view.getElement() : view,
				CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EweDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getLoadModelTask_3011Text(View view) {
		IParser parser = EweParserProvider.getParser(
				EweElementTypes.LoadModelTask_3011,
				view.getElement() != null ? view.getElement() : view,
				EweVisualIDRegistry
						.getType(LoadModelTaskNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EweDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5011); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getProject_1000Text(View view) {
		Project domainModelElement = (Project) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			EweDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEclTask_3010Text(View view) {
		IParser parser = EweParserProvider.getParser(
				EweElementTypes.EclTask_3010,
				view.getElement() != null ? view.getElement() : view,
				EweVisualIDRegistry.getType(EclTaskSrcEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EweDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5010); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRollbackTransactionTask_3013Text(View view) {
		IParser parser = EweParserProvider
				.getParser(
						EweElementTypes.RollbackTransactionTask_3013,
						view.getElement() != null ? view.getElement() : view,
						EweVisualIDRegistry
								.getType(RollbackTransactionTaskNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EweDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5013); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEtlTask_3004Text(View view) {
		IParser parser = EweParserProvider.getParser(
				EweElementTypes.EtlTask_3004,
				view.getElement() != null ? view.getElement() : view,
				EweVisualIDRegistry.getType(EtlTaskSrcEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EweDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getTargetDepends_4002Text(View view) {
		IParser parser = EweParserProvider.getParser(
				EweElementTypes.TargetDepends_4002,
				view.getElement() != null ? view.getElement() : view,
				CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EweDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getTask_3019Text(View view) {
		IParser parser = EweParserProvider.getParser(EweElementTypes.Task_3019,
				view.getElement() != null ? view.getElement() : view,
				EweVisualIDRegistry.getType(TaskNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EweDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5019); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getStartTransactionTask_3015Text(View view) {
		IParser parser = EweParserProvider.getParser(
				EweElementTypes.StartTransactionTask_3015,
				view.getElement() != null ? view.getElement() : view,
				EweVisualIDRegistry
						.getType(StartTransactionTaskNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EweDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5015); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getTarget_2001Text(View view) {
		IParser parser = EweParserProvider.getParser(
				EweElementTypes.Target_2001,
				view.getElement() != null ? view.getElement() : view,
				EweVisualIDRegistry.getType(TargetNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EweDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5020); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getProperty_3017Text(View view) {
		IParser parser = EweParserProvider.getParser(
				EweElementTypes.Property_3017,
				view.getElement() != null ? view.getElement() : view,
				EweVisualIDRegistry.getType(PropertyNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EweDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5017); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getLoadXMLModelTask_3007Text(View view) {
		IParser parser = EweParserProvider.getParser(
				EweElementTypes.LoadXMLModelTask_3007,
				view.getElement() != null ? view.getElement() : view,
				EweVisualIDRegistry
						.getType(LoadXMLModelTaskNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EweDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEolTask_3001Text(View view) {
		IParser parser = EweParserProvider.getParser(
				EweElementTypes.EolTask_3001,
				view.getElement() != null ? view.getElement() : view,
				EweVisualIDRegistry.getType(EolTaskSrcEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EweDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
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
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return ProjectEditPart.MODEL_ID.equals(EweVisualIDRegistry
				.getModelID(view));
	}

}
