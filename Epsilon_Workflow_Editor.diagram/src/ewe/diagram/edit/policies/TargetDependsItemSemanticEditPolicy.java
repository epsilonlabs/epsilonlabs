/*
 * 
 */
package ewe.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

import ewe.diagram.providers.EweElementTypes;

/**
 * @generated
 */
public class TargetDependsItemSemanticEditPolicy extends
		EweBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public TargetDependsItemSemanticEditPolicy() {
		super(EweElementTypes.TargetDepends_4002);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return getGEFWrapper(new DestroyReferenceCommand(req));
	}

}
