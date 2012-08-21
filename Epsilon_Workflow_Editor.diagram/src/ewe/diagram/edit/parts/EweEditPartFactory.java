/*
 * 
 */
package ewe.diagram.edit.parts;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import ewe.diagram.part.EweVisualIDRegistry;

/**
 * @generated
 */
public class EweEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (EweVisualIDRegistry.getVisualID(view)) {

			case ProjectEditPart.VISUAL_ID:
				return new ProjectEditPart(view);

			case TargetEditPart.VISUAL_ID:
				return new TargetEditPart(view);

			case TargetNameEditPart.VISUAL_ID:
				return new TargetNameEditPart(view);

			case EolTaskEditPart.VISUAL_ID:
				return new EolTaskEditPart(view);

			case EolTaskSrcEditPart.VISUAL_ID:
				return new EolTaskSrcEditPart(view);

			case EmlTaskEditPart.VISUAL_ID:
				return new EmlTaskEditPart(view);

			case EmlTaskSrcEditPart.VISUAL_ID:
				return new EmlTaskSrcEditPart(view);

			case EglTaskEditPart.VISUAL_ID:
				return new EglTaskEditPart(view);

			case EglTaskSrcEditPart.VISUAL_ID:
				return new EglTaskSrcEditPart(view);

			case EtlTaskEditPart.VISUAL_ID:
				return new EtlTaskEditPart(view);

			case EtlTaskSrcEditPart.VISUAL_ID:
				return new EtlTaskSrcEditPart(view);

			case EvlTaskEditPart.VISUAL_ID:
				return new EvlTaskEditPart(view);

			case EvlTaskSrcEditPart.VISUAL_ID:
				return new EvlTaskSrcEditPart(view);

			case LoadEMFModelTaskEditPart.VISUAL_ID:
				return new LoadEMFModelTaskEditPart(view);

			case LoadEMFModelTaskNameEditPart.VISUAL_ID:
				return new LoadEMFModelTaskNameEditPart(view);

			case LoadXMLModelTaskEditPart.VISUAL_ID:
				return new LoadXMLModelTaskEditPart(view);

			case LoadXMLModelTaskNameEditPart.VISUAL_ID:
				return new LoadXMLModelTaskNameEditPart(view);

			case FlockTaskEditPart.VISUAL_ID:
				return new FlockTaskEditPart(view);

			case FlockTaskSrcEditPart.VISUAL_ID:
				return new FlockTaskSrcEditPart(view);

			case EUnitTaskEditPart.VISUAL_ID:
				return new EUnitTaskEditPart(view);

			case EUnitTaskSrcEditPart.VISUAL_ID:
				return new EUnitTaskSrcEditPart(view);

			case EclTaskEditPart.VISUAL_ID:
				return new EclTaskEditPart(view);

			case EclTaskSrcEditPart.VISUAL_ID:
				return new EclTaskSrcEditPart(view);

			case LoadModelTaskEditPart.VISUAL_ID:
				return new LoadModelTaskEditPart(view);

			case LoadModelTaskNameEditPart.VISUAL_ID:
				return new LoadModelTaskNameEditPart(view);

			case StoreModelTaskEditPart.VISUAL_ID:
				return new StoreModelTaskEditPart(view);

			case StoreModelTaskNameEditPart.VISUAL_ID:
				return new StoreModelTaskNameEditPart(view);

			case RollbackTransactionTaskEditPart.VISUAL_ID:
				return new RollbackTransactionTaskEditPart(view);

			case RollbackTransactionTaskNameEditPart.VISUAL_ID:
				return new RollbackTransactionTaskNameEditPart(view);

			case DisposeModelTaskEditPart.VISUAL_ID:
				return new DisposeModelTaskEditPart(view);

			case DisposeModelTaskNameEditPart.VISUAL_ID:
				return new DisposeModelTaskNameEditPart(view);

			case StartTransactionTaskEditPart.VISUAL_ID:
				return new StartTransactionTaskEditPart(view);

			case StartTransactionTaskNameEditPart.VISUAL_ID:
				return new StartTransactionTaskNameEditPart(view);

			case CommitTransactionTaskEditPart.VISUAL_ID:
				return new CommitTransactionTaskEditPart(view);

			case CommitTransactionTaskNameEditPart.VISUAL_ID:
				return new CommitTransactionTaskNameEditPart(view);

			case PropertyEditPart.VISUAL_ID:
				return new PropertyEditPart(view);

			case PropertyNameEditPart.VISUAL_ID:
				return new PropertyNameEditPart(view);

			case NestedElementEditPart.VISUAL_ID:
				return new NestedElementEditPart(view);

			case NestedElementNameEditPart.VISUAL_ID:
				return new NestedElementNameEditPart(view);

			case TaskEditPart.VISUAL_ID:
				return new TaskEditPart(view);

			case TaskNameEditPart.VISUAL_ID:
				return new TaskNameEditPart(view);

			case TargetTargetTargetTasksCompartmentEditPart.VISUAL_ID:
				return new TargetTargetTargetTasksCompartmentEditPart(view);

			case TaskFollowsEditPart.VISUAL_ID:
				return new TaskFollowsEditPart(view);

			case TaskFollowsExternalLabelEditPart.VISUAL_ID:
				return new TaskFollowsExternalLabelEditPart(view);

			case TargetDependsEditPart.VISUAL_ID:
				return new TargetDependsEditPart(view);

			case TargetDependsExternalLabelEditPart.VISUAL_ID:
				return new TargetDependsExternalLabelEditPart(view);

			}
		}
		return createUnrecognizedEditPart(context, model);
	}

	/**
	 * @generated
	 */
	private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
		// Handle creation of unrecognized child node EditParts here
		return null;
	}

	/**
	 * @generated
	 */
	public static CellEditorLocator getTextCellEditorLocator(
			ITextAwareEditPart source) {
		if (source.getFigure() instanceof WrappingLabel)
			return new TextCellEditorLocator((WrappingLabel) source.getFigure());
		else {
			return new LabelCellEditorLocator((Label) source.getFigure());
		}
	}

	/**
	 * @generated
	 */
	static private class TextCellEditorLocator implements CellEditorLocator {

		/**
		 * @generated
		 */
		private WrappingLabel wrapLabel;

		/**
		 * @generated
		 */
		public TextCellEditorLocator(WrappingLabel wrapLabel) {
			this.wrapLabel = wrapLabel;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getWrapLabel() {
			return wrapLabel;
		}

		/**
		 * @generated
		 */
		public void relocate(CellEditor celleditor) {
			Text text = (Text) celleditor.getControl();
			Rectangle rect = getWrapLabel().getTextBounds().getCopy();
			getWrapLabel().translateToAbsolute(rect);
			if (!text.getFont().isDisposed()) {
				if (getWrapLabel().isTextWrapOn()
						&& getWrapLabel().getText().length() > 0) {
					rect.setSize(new Dimension(text.computeSize(rect.width,
							SWT.DEFAULT)));
				} else {
					int avr = FigureUtilities.getFontMetrics(text.getFont())
							.getAverageCharWidth();
					rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT,
							SWT.DEFAULT)).expand(avr * 2, 0));
				}
			}
			if (!rect.equals(new Rectangle(text.getBounds()))) {
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
			}
		}
	}

	/**
	 * @generated
	 */
	private static class LabelCellEditorLocator implements CellEditorLocator {

		/**
		 * @generated
		 */
		private Label label;

		/**
		 * @generated
		 */
		public LabelCellEditorLocator(Label label) {
			this.label = label;
		}

		/**
		 * @generated
		 */
		public Label getLabel() {
			return label;
		}

		/**
		 * @generated
		 */
		public void relocate(CellEditor celleditor) {
			Text text = (Text) celleditor.getControl();
			Rectangle rect = getLabel().getTextBounds().getCopy();
			getLabel().translateToAbsolute(rect);
			if (!text.getFont().isDisposed()) {
				int avr = FigureUtilities.getFontMetrics(text.getFont())
						.getAverageCharWidth();
				rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT,
						SWT.DEFAULT)).expand(avr * 2, 0));
			}
			if (!rect.equals(new Rectangle(text.getBounds()))) {
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
			}
		}
	}
}
