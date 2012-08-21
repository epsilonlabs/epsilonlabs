/*
 * 
 */
package ewe.diagram.edit.parts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

import ewe.diagram.edit.policies.PropertyItemSemanticEditPolicy;
import ewe.diagram.part.EweVisualIDRegistry;
import ewe.diagram.providers.EweElementTypes;

/**
 * @generated
 */
public class PropertyEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3017;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * @generated
	 */
	public PropertyEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new PropertyItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				EditPolicy result = child
						.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if (result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};
		return lep;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		return primaryShape = new PropertyFigure();
	}

	/**
	 * @generated
	 */
	public PropertyFigure getPrimaryShape() {
		return (PropertyFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof PropertyNameEditPart) {
			((PropertyNameEditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigurePropertyLabelFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof PropertyNameEditPart) {
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected NodeFigure createNodeFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	 * Default implementation treats passed figure as content pane.
	 * Respects layout one may have set for generated figure.
	 * @param nodeShape instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		if (nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(5);
			nodeShape.setLayoutManager(layout);
		}
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * @generated
	 */
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	protected void setForegroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setBackgroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setBackgroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineWidth(int width) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineWidth(width);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineType(int style) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineStyle(style);
		}
	}

	/**
	 * @generated
	 */
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(EweVisualIDRegistry
				.getType(PropertyNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSource() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(1);
		types.add(EweElementTypes.TaskFollows_4001);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSourceAndTarget(
			IGraphicalEditPart targetEditPart) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof EolTaskEditPart) {
			types.add(EweElementTypes.TaskFollows_4001);
		}
		if (targetEditPart instanceof EmlTaskEditPart) {
			types.add(EweElementTypes.TaskFollows_4001);
		}
		if (targetEditPart instanceof EglTaskEditPart) {
			types.add(EweElementTypes.TaskFollows_4001);
		}
		if (targetEditPart instanceof EtlTaskEditPart) {
			types.add(EweElementTypes.TaskFollows_4001);
		}
		if (targetEditPart instanceof EvlTaskEditPart) {
			types.add(EweElementTypes.TaskFollows_4001);
		}
		if (targetEditPart instanceof LoadEMFModelTaskEditPart) {
			types.add(EweElementTypes.TaskFollows_4001);
		}
		if (targetEditPart instanceof LoadXMLModelTaskEditPart) {
			types.add(EweElementTypes.TaskFollows_4001);
		}
		if (targetEditPart instanceof FlockTaskEditPart) {
			types.add(EweElementTypes.TaskFollows_4001);
		}
		if (targetEditPart instanceof EUnitTaskEditPart) {
			types.add(EweElementTypes.TaskFollows_4001);
		}
		if (targetEditPart instanceof EclTaskEditPart) {
			types.add(EweElementTypes.TaskFollows_4001);
		}
		if (targetEditPart instanceof LoadModelTaskEditPart) {
			types.add(EweElementTypes.TaskFollows_4001);
		}
		if (targetEditPart instanceof StoreModelTaskEditPart) {
			types.add(EweElementTypes.TaskFollows_4001);
		}
		if (targetEditPart instanceof RollbackTransactionTaskEditPart) {
			types.add(EweElementTypes.TaskFollows_4001);
		}
		if (targetEditPart instanceof DisposeModelTaskEditPart) {
			types.add(EweElementTypes.TaskFollows_4001);
		}
		if (targetEditPart instanceof StartTransactionTaskEditPart) {
			types.add(EweElementTypes.TaskFollows_4001);
		}
		if (targetEditPart instanceof CommitTransactionTaskEditPart) {
			types.add(EweElementTypes.TaskFollows_4001);
		}
		if (targetEditPart instanceof ewe.diagram.edit.parts.PropertyEditPart) {
			types.add(EweElementTypes.TaskFollows_4001);
		}
		if (targetEditPart instanceof NestedElementEditPart) {
			types.add(EweElementTypes.TaskFollows_4001);
		}
		if (targetEditPart instanceof TaskEditPart) {
			types.add(EweElementTypes.TaskFollows_4001);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == EweElementTypes.TaskFollows_4001) {
			types.add(EweElementTypes.EolTask_3001);
			types.add(EweElementTypes.EmlTask_3002);
			types.add(EweElementTypes.EglTask_3003);
			types.add(EweElementTypes.EtlTask_3004);
			types.add(EweElementTypes.EvlTask_3005);
			types.add(EweElementTypes.LoadEMFModelTask_3006);
			types.add(EweElementTypes.LoadXMLModelTask_3007);
			types.add(EweElementTypes.FlockTask_3008);
			types.add(EweElementTypes.EUnitTask_3009);
			types.add(EweElementTypes.EclTask_3010);
			types.add(EweElementTypes.LoadModelTask_3011);
			types.add(EweElementTypes.StoreModelTask_3012);
			types.add(EweElementTypes.RollbackTransactionTask_3013);
			types.add(EweElementTypes.DisposeModelTask_3014);
			types.add(EweElementTypes.StartTransactionTask_3015);
			types.add(EweElementTypes.CommitTransactionTask_3016);
			types.add(EweElementTypes.Property_3017);
			types.add(EweElementTypes.NestedElement_3018);
			types.add(EweElementTypes.Task_3019);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(1);
		types.add(EweElementTypes.TaskFollows_4001);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == EweElementTypes.TaskFollows_4001) {
			types.add(EweElementTypes.EolTask_3001);
			types.add(EweElementTypes.EmlTask_3002);
			types.add(EweElementTypes.EglTask_3003);
			types.add(EweElementTypes.EtlTask_3004);
			types.add(EweElementTypes.EvlTask_3005);
			types.add(EweElementTypes.LoadEMFModelTask_3006);
			types.add(EweElementTypes.LoadXMLModelTask_3007);
			types.add(EweElementTypes.FlockTask_3008);
			types.add(EweElementTypes.EUnitTask_3009);
			types.add(EweElementTypes.EclTask_3010);
			types.add(EweElementTypes.LoadModelTask_3011);
			types.add(EweElementTypes.StoreModelTask_3012);
			types.add(EweElementTypes.RollbackTransactionTask_3013);
			types.add(EweElementTypes.DisposeModelTask_3014);
			types.add(EweElementTypes.StartTransactionTask_3015);
			types.add(EweElementTypes.CommitTransactionTask_3016);
			types.add(EweElementTypes.Property_3017);
			types.add(EweElementTypes.NestedElement_3018);
			types.add(EweElementTypes.Task_3019);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class PropertyFigure extends RoundedRectangle {

		/**
		 * @generated
		 */
		private WrappingLabel fFigurePropertyLabelFigure;

		/**
		 * @generated
		 */
		public PropertyFigure() {
			this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(8),
					getMapMode().DPtoLP(8)));
			this.setLineWidth(2);
			this.setForegroundColor(THIS_FORE);
			this.setBackgroundColor(THIS_BACK);
			this.setBorder(new MarginBorder(getMapMode().DPtoLP(5),
					getMapMode().DPtoLP(5), getMapMode().DPtoLP(5),
					getMapMode().DPtoLP(5)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigurePropertyLabelFigure = new WrappingLabel();
			fFigurePropertyLabelFigure.setText("Property");

			this.add(fFigurePropertyLabelFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigurePropertyLabelFigure() {
			return fFigurePropertyLabelFigure;
		}

	}

	/**
	 * @generated
	 */
	static final Color THIS_FORE = new Color(null, 0, 0, 0);

	/**
	 * @generated
	 */
	static final Color THIS_BACK = new Color(null, 249, 249, 213);

}
