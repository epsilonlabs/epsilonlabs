/*
 * 
 */
package ewe.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import ewe.diagram.edit.commands.CommitTransactionTaskCreateCommand;
import ewe.diagram.edit.commands.DisposeModelTaskCreateCommand;
import ewe.diagram.edit.commands.DisposeModelsTaskCreateCommand;
import ewe.diagram.edit.commands.EUnitTaskCreateCommand;
import ewe.diagram.edit.commands.EclTaskCreateCommand;
import ewe.diagram.edit.commands.EglTaskCreateCommand;
import ewe.diagram.edit.commands.EmlTaskCreateCommand;
import ewe.diagram.edit.commands.EolTaskCreateCommand;
import ewe.diagram.edit.commands.EtlTaskCreateCommand;
import ewe.diagram.edit.commands.EvlTaskCreateCommand;
import ewe.diagram.edit.commands.FlockTaskCreateCommand;
import ewe.diagram.edit.commands.LoadEMFModelTaskCreateCommand;
import ewe.diagram.edit.commands.LoadModelTaskCreateCommand;
import ewe.diagram.edit.commands.NestedElementCreateCommand;
import ewe.diagram.edit.commands.RollbackTransactionTaskCreateCommand;
import ewe.diagram.edit.commands.StartTransactionTaskCreateCommand;
import ewe.diagram.edit.commands.StoreModelTaskCreateCommand;
import ewe.diagram.edit.commands.TaskCreateCommand;
import ewe.diagram.providers.EweElementTypes;

/**
 * @generated
 */
public class TargetTargetTargetTasksCompartmentItemSemanticEditPolicy extends
		EweBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public TargetTargetTargetTasksCompartmentItemSemanticEditPolicy() {
		super(EweElementTypes.Target_2001);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (EweElementTypes.EolTask_3001 == req.getElementType()) {
			return getGEFWrapper(new EolTaskCreateCommand(req));
		}
		if (EweElementTypes.EmlTask_3002 == req.getElementType()) {
			return getGEFWrapper(new EmlTaskCreateCommand(req));
		}
		if (EweElementTypes.EglTask_3003 == req.getElementType()) {
			return getGEFWrapper(new EglTaskCreateCommand(req));
		}
		if (EweElementTypes.EtlTask_3004 == req.getElementType()) {
			return getGEFWrapper(new EtlTaskCreateCommand(req));
		}
		if (EweElementTypes.EvlTask_3005 == req.getElementType()) {
			return getGEFWrapper(new EvlTaskCreateCommand(req));
		}
		if (EweElementTypes.LoadEMFModelTask_3006 == req.getElementType()) {
			return getGEFWrapper(new LoadEMFModelTaskCreateCommand(req));
		}
		if (EweElementTypes.FlockTask_3007 == req.getElementType()) {
			return getGEFWrapper(new FlockTaskCreateCommand(req));
		}
		if (EweElementTypes.EUnitTask_3008 == req.getElementType()) {
			return getGEFWrapper(new EUnitTaskCreateCommand(req));
		}
		if (EweElementTypes.EclTask_3009 == req.getElementType()) {
			return getGEFWrapper(new EclTaskCreateCommand(req));
		}
		if (EweElementTypes.LoadModelTask_3010 == req.getElementType()) {
			return getGEFWrapper(new LoadModelTaskCreateCommand(req));
		}
		if (EweElementTypes.StoreModelTask_3011 == req.getElementType()) {
			return getGEFWrapper(new StoreModelTaskCreateCommand(req));
		}
		if (EweElementTypes.RollbackTransactionTask_3012 == req
				.getElementType()) {
			return getGEFWrapper(new RollbackTransactionTaskCreateCommand(req));
		}
		if (EweElementTypes.DisposeModelTask_3013 == req.getElementType()) {
			return getGEFWrapper(new DisposeModelTaskCreateCommand(req));
		}
		if (EweElementTypes.StartTransactionTask_3014 == req.getElementType()) {
			return getGEFWrapper(new StartTransactionTaskCreateCommand(req));
		}
		if (EweElementTypes.CommitTransactionTask_3015 == req.getElementType()) {
			return getGEFWrapper(new CommitTransactionTaskCreateCommand(req));
		}
		if (EweElementTypes.DisposeModelsTask_3016 == req.getElementType()) {
			return getGEFWrapper(new DisposeModelsTaskCreateCommand(req));
		}
		if (EweElementTypes.NestedElement_3017 == req.getElementType()) {
			return getGEFWrapper(new NestedElementCreateCommand(req));
		}
		if (EweElementTypes.Task_3018 == req.getElementType()) {
			return getGEFWrapper(new TaskCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
