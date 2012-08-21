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
		paletteContainer.add(createECLTask3CreationTool());
		paletteContainer.add(createEGLTask4CreationTool());
		paletteContainer.add(createEMLTask5CreationTool());
		paletteContainer.add(createEOLTask6CreationTool());
		paletteContainer.add(createETLTask7CreationTool());
		paletteContainer.add(createEUnitTask8CreationTool());
		paletteContainer.add(createEVLTask9CreationTool());
		paletteContainer.add(createFlockTask10CreationTool());
		paletteContainer.add(createLoadEMFModelTask11CreationTool());
		paletteContainer.add(createLoadModelTask12CreationTool());
		paletteContainer.add(createLoadXMLModelTask13CreationTool());
		//paletteContainer.add(createNestedElement14CreationTool());
		paletteContainer.add(createProperty15CreationTool());
		paletteContainer.add(createRollbackTransactionTask16CreationTool());
		paletteContainer.add(createStartTransactionTask17CreationTool());
		paletteContainer.add(createStoreModelTask18CreationTool());
		paletteContainer.add(createTarget19CreationTool());
		paletteContainer.add(createTask20CreationTool());
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
						.singletonList(EweElementTypes.CommitTransactionTask_3016));
		entry.setId("createCommitTransactionTask1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EweElementTypes
				.getImageDescriptor(EweElementTypes.CommitTransactionTask_3016));
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
						.singletonList(EweElementTypes.DisposeModelTask_3014));
		entry.setId("createDisposeModelTask2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EweElementTypes
				.getImageDescriptor(EweElementTypes.DisposeModelTask_3014));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createECLTask3CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ECLTask3CreationTool_title,
				Messages.ECLTask3CreationTool_desc,
				Collections.singletonList(EweElementTypes.EclTask_3010));
		entry.setId("createECLTask3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EweElementTypes
				.getImageDescriptor(EweElementTypes.EclTask_3010));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEGLTask4CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.EGLTask4CreationTool_title,
				Messages.EGLTask4CreationTool_desc,
				Collections.singletonList(EweElementTypes.EglTask_3003));
		entry.setId("createEGLTask4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EweElementTypes
				.getImageDescriptor(EweElementTypes.EglTask_3003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEMLTask5CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.EMLTask5CreationTool_title,
				Messages.EMLTask5CreationTool_desc,
				Collections.singletonList(EweElementTypes.EmlTask_3002));
		entry.setId("createEMLTask5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EweElementTypes
				.getImageDescriptor(EweElementTypes.EmlTask_3002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEOLTask6CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.EOLTask6CreationTool_title,
				Messages.EOLTask6CreationTool_desc,
				Collections.singletonList(EweElementTypes.EolTask_3001));
		entry.setId("createEOLTask6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EweElementTypes
				.getImageDescriptor(EweElementTypes.EolTask_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createETLTask7CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ETLTask7CreationTool_title,
				Messages.ETLTask7CreationTool_desc,
				Collections.singletonList(EweElementTypes.EtlTask_3004));
		entry.setId("createETLTask7CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EweElementTypes
				.getImageDescriptor(EweElementTypes.EtlTask_3004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEUnitTask8CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.EUnitTask8CreationTool_title,
				Messages.EUnitTask8CreationTool_desc,
				Collections.singletonList(EweElementTypes.EUnitTask_3009));
		entry.setId("createEUnitTask8CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EweElementTypes
				.getImageDescriptor(EweElementTypes.EUnitTask_3009));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEVLTask9CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.EVLTask9CreationTool_title,
				Messages.EVLTask9CreationTool_desc,
				Collections.singletonList(EweElementTypes.EvlTask_3005));
		entry.setId("createEVLTask9CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EweElementTypes
				.getImageDescriptor(EweElementTypes.EvlTask_3005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createFlockTask10CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.FlockTask10CreationTool_title,
				Messages.FlockTask10CreationTool_desc,
				Collections.singletonList(EweElementTypes.FlockTask_3008));
		entry.setId("createFlockTask10CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EweElementTypes
				.getImageDescriptor(EweElementTypes.FlockTask_3008));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createLoadEMFModelTask11CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.LoadEMFModelTask11CreationTool_title,
				Messages.LoadEMFModelTask11CreationTool_desc,
				Collections
						.singletonList(EweElementTypes.LoadEMFModelTask_3006));
		entry.setId("createLoadEMFModelTask11CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EweElementTypes
				.getImageDescriptor(EweElementTypes.LoadEMFModelTask_3006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createLoadModelTask12CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.LoadModelTask12CreationTool_title,
				Messages.LoadModelTask12CreationTool_desc,
				Collections.singletonList(EweElementTypes.LoadModelTask_3011));
		entry.setId("createLoadModelTask12CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EweElementTypes
				.getImageDescriptor(EweElementTypes.LoadModelTask_3011));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createLoadXMLModelTask13CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.LoadXMLModelTask13CreationTool_title,
				Messages.LoadXMLModelTask13CreationTool_desc,
				Collections
						.singletonList(EweElementTypes.LoadXMLModelTask_3007));
		entry.setId("createLoadXMLModelTask13CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EweElementTypes
				.getImageDescriptor(EweElementTypes.LoadXMLModelTask_3007));
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
				Collections.singletonList(EweElementTypes.NestedElement_3018));
		entry.setId("createNestedElement14CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EweElementTypes
				.getImageDescriptor(EweElementTypes.NestedElement_3018));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createProperty15CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Property15CreationTool_title,
				Messages.Property15CreationTool_desc,
				Collections.singletonList(EweElementTypes.Property_3017));
		entry.setId("createProperty15CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EweElementTypes
				.getImageDescriptor(EweElementTypes.Property_3017));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRollbackTransactionTask16CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.RollbackTransactionTask16CreationTool_title,
				Messages.RollbackTransactionTask16CreationTool_desc,
				Collections
						.singletonList(EweElementTypes.RollbackTransactionTask_3013));
		entry.setId("createRollbackTransactionTask16CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EweElementTypes
				.getImageDescriptor(EweElementTypes.RollbackTransactionTask_3013));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createStartTransactionTask17CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.StartTransactionTask17CreationTool_title,
				Messages.StartTransactionTask17CreationTool_desc,
				Collections
						.singletonList(EweElementTypes.StartTransactionTask_3015));
		entry.setId("createStartTransactionTask17CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EweElementTypes
				.getImageDescriptor(EweElementTypes.StartTransactionTask_3015));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createStoreModelTask18CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.StoreModelTask18CreationTool_title,
				Messages.StoreModelTask18CreationTool_desc,
				Collections.singletonList(EweElementTypes.StoreModelTask_3012));
		entry.setId("createStoreModelTask18CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EweElementTypes
				.getImageDescriptor(EweElementTypes.StoreModelTask_3012));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createTarget19CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Target19CreationTool_title,
				Messages.Target19CreationTool_desc,
				Collections.singletonList(EweElementTypes.Target_2001));
		entry.setId("createTarget19CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EweElementTypes
				.getImageDescriptor(EweElementTypes.Target_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createTask20CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Task20CreationTool_title,
				Messages.Task20CreationTool_desc,
				Collections.singletonList(EweElementTypes.Task_3019));
		entry.setId("createTask20CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EweElementTypes
				.getImageDescriptor(EweElementTypes.Task_3019));
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
