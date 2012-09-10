/*
 * 
 */
package ewe.diagram.part;

import java.util.Collections;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import ewe.diagram.providers.EweElementTypes;

/**
 * @generated
 */
public class EwePaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createObjects1Group());
		paletteRoot.add(createConnections2Group());
	}

	/**
	 * Creates "Objects" palette tool group
	 * @generated
	 */
	private PaletteContainer createObjects1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Objects1Group_title);
		paletteContainer.setId("createObjects1Group"); //$NON-NLS-1$
		paletteContainer.add(createCommitTransactionTask1CreationTool());
		paletteContainer.add(createDisposeModelTask2CreationTool());
		paletteContainer.add(createDisposeModelsTask3CreationTool());
		paletteContainer.add(createECLTask4CreationTool());
		paletteContainer.add(createEGLTask5CreationTool());
		paletteContainer.add(createEMLTask6CreationTool());
		paletteContainer.add(createEOLTask7CreationTool());
		paletteContainer.add(createETLTask8CreationTool());
		paletteContainer.add(createEUnitTask9CreationTool());
		paletteContainer.add(createEVLTask10CreationTool());
		paletteContainer.add(createFlockTask11CreationTool());
		paletteContainer.add(createLoadEMFModelTask12CreationTool());
		paletteContainer.add(createLoadModelTask13CreationTool());
		//paletteContainer.add(createNestedElement14CreationTool());
		paletteContainer.add(createRollbackTransactionTask15CreationTool());
		paletteContainer.add(createStartTransactionTask16CreationTool());
		paletteContainer.add(createStoreModelTask17CreationTool());
		paletteContainer.add(createTarget18CreationTool());
		paletteContainer.add(createTask19CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Connections" palette tool group
	 * @generated
	 */
	private PaletteContainer createConnections2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Connections2Group_title);
		paletteContainer.setId("createConnections2Group"); //$NON-NLS-1$
		paletteContainer.add(createDepends1CreationTool());
		paletteContainer.add(createFollows2CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCommitTransactionTask1CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.CommitTransactionTask1CreationTool_title,
				Messages.CommitTransactionTask1CreationTool_desc,
				Collections
						.singletonList(EweElementTypes.CommitTransactionTask_3015));
		entry.setId("createCommitTransactionTask1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EweElementTypes
				.getImageDescriptor(EweElementTypes.CommitTransactionTask_3015));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDisposeModelTask2CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.DisposeModelTask2CreationTool_title,
				Messages.DisposeModelTask2CreationTool_desc,
				Collections
						.singletonList(EweElementTypes.DisposeModelTask_3013));
		entry.setId("createDisposeModelTask2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EweElementTypes
				.getImageDescriptor(EweElementTypes.DisposeModelTask_3013));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDisposeModelsTask3CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.DisposeModelsTask3CreationTool_title,
				Messages.DisposeModelsTask3CreationTool_desc,
				Collections
						.singletonList(EweElementTypes.DisposeModelsTask_3016));
		entry.setId("createDisposeModelsTask3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EweElementTypes
				.getImageDescriptor(EweElementTypes.DisposeModelsTask_3016));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createECLTask4CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ECLTask4CreationTool_title,
				Messages.ECLTask4CreationTool_desc,
				Collections.singletonList(EweElementTypes.EclTask_3009));
		entry.setId("createECLTask4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EweElementTypes
				.getImageDescriptor(EweElementTypes.EclTask_3009));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEGLTask5CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.EGLTask5CreationTool_title,
				Messages.EGLTask5CreationTool_desc,
				Collections.singletonList(EweElementTypes.EglTask_3003));
		entry.setId("createEGLTask5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EweElementTypes
				.getImageDescriptor(EweElementTypes.EglTask_3003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEMLTask6CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.EMLTask6CreationTool_title,
				Messages.EMLTask6CreationTool_desc,
				Collections.singletonList(EweElementTypes.EmlTask_3002));
		entry.setId("createEMLTask6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EweElementTypes
				.getImageDescriptor(EweElementTypes.EmlTask_3002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEOLTask7CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.EOLTask7CreationTool_title,
				Messages.EOLTask7CreationTool_desc,
				Collections.singletonList(EweElementTypes.EolTask_3001));
		entry.setId("createEOLTask7CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EweElementTypes
				.getImageDescriptor(EweElementTypes.EolTask_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createETLTask8CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ETLTask8CreationTool_title,
				Messages.ETLTask8CreationTool_desc,
				Collections.singletonList(EweElementTypes.EtlTask_3004));
		entry.setId("createETLTask8CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EweElementTypes
				.getImageDescriptor(EweElementTypes.EtlTask_3004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEUnitTask9CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.EUnitTask9CreationTool_title,
				Messages.EUnitTask9CreationTool_desc,
				Collections.singletonList(EweElementTypes.EUnitTask_3008));
		entry.setId("createEUnitTask9CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EweElementTypes
				.getImageDescriptor(EweElementTypes.EUnitTask_3008));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEVLTask10CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.EVLTask10CreationTool_title,
				Messages.EVLTask10CreationTool_desc,
				Collections.singletonList(EweElementTypes.EvlTask_3005));
		entry.setId("createEVLTask10CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EweElementTypes
				.getImageDescriptor(EweElementTypes.EvlTask_3005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createFlockTask11CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.FlockTask11CreationTool_title,
				Messages.FlockTask11CreationTool_desc,
				Collections.singletonList(EweElementTypes.FlockTask_3007));
		entry.setId("createFlockTask11CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EweElementTypes
				.getImageDescriptor(EweElementTypes.FlockTask_3007));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createLoadEMFModelTask12CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.LoadEMFModelTask12CreationTool_title,
				Messages.LoadEMFModelTask12CreationTool_desc,
				Collections
						.singletonList(EweElementTypes.LoadEMFModelTask_3006));
		entry.setId("createLoadEMFModelTask12CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EweElementTypes
				.getImageDescriptor(EweElementTypes.LoadEMFModelTask_3006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createLoadModelTask13CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.LoadModelTask13CreationTool_title,
				Messages.LoadModelTask13CreationTool_desc,
				Collections.singletonList(EweElementTypes.LoadModelTask_3010));
		entry.setId("createLoadModelTask13CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EweElementTypes
				.getImageDescriptor(EweElementTypes.LoadModelTask_3010));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createNestedElement14CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.NestedElement14CreationTool_title,
				Messages.NestedElement14CreationTool_desc,
				Collections.singletonList(EweElementTypes.NestedElement_3017));
		entry.setId("createNestedElement14CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EweElementTypes
				.getImageDescriptor(EweElementTypes.NestedElement_3017));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRollbackTransactionTask15CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.RollbackTransactionTask15CreationTool_title,
				Messages.RollbackTransactionTask15CreationTool_desc,
				Collections
						.singletonList(EweElementTypes.RollbackTransactionTask_3012));
		entry.setId("createRollbackTransactionTask15CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EweElementTypes
				.getImageDescriptor(EweElementTypes.RollbackTransactionTask_3012));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createStartTransactionTask16CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.StartTransactionTask16CreationTool_title,
				Messages.StartTransactionTask16CreationTool_desc,
				Collections
						.singletonList(EweElementTypes.StartTransactionTask_3014));
		entry.setId("createStartTransactionTask16CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EweElementTypes
				.getImageDescriptor(EweElementTypes.StartTransactionTask_3014));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createStoreModelTask17CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.StoreModelTask17CreationTool_title,
				Messages.StoreModelTask17CreationTool_desc,
				Collections.singletonList(EweElementTypes.StoreModelTask_3011));
		entry.setId("createStoreModelTask17CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EweElementTypes
				.getImageDescriptor(EweElementTypes.StoreModelTask_3011));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createTarget18CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Target18CreationTool_title,
				Messages.Target18CreationTool_desc,
				Collections.singletonList(EweElementTypes.Target_2001));
		entry.setId("createTarget18CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EweElementTypes
				.getImageDescriptor(EweElementTypes.Target_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createTask19CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Task19CreationTool_title,
				Messages.Task19CreationTool_desc,
				Collections.singletonList(EweElementTypes.Task_3018));
		entry.setId("createTask19CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EweElementTypes
				.getImageDescriptor(EweElementTypes.Task_3018));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDepends1CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Depends1CreationTool_title,
				Messages.Depends1CreationTool_desc,
				Collections.singletonList(EweElementTypes.TargetDepends_4002));
		entry.setId("createDepends1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EweDiagramEditorPlugin
				.findImageDescriptor("/Epsilon_Workflow_Editor.edit/icons/full/obj16/Depends.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createFollows2CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Follows2CreationTool_title,
				Messages.Follows2CreationTool_desc,
				Collections.singletonList(EweElementTypes.TaskFollows_4001));
		entry.setId("createFollows2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EweDiagramEditorPlugin
				.findImageDescriptor("/Epsilon_Workflow_Editor.edit/icons/full/obj16/Follows.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private static class NodeToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List<IElementType> elementTypes;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description,
				List<IElementType> elementTypes) {
			super(title, description, null, null);
			this.elementTypes = elementTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}

	/**
	 * @generated
	 */
	private static class LinkToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List<IElementType> relationshipTypes;

		/**
		 * @generated
		 */
		private LinkToolEntry(String title, String description,
				List<IElementType> relationshipTypes) {
			super(title, description, null, null);
			this.relationshipTypes = relationshipTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}
}
