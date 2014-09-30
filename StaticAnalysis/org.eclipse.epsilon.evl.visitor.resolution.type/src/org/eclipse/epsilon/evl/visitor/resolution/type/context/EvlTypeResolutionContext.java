package org.eclipse.epsilon.evl.visitor.resolution.type.context;

import java.util.HashMap;

import org.eclipse.epsilon.eol.visitor.resolution.type.context.TypeResolutionContext;
import org.eclipse.epsilon.evl.metamodel.Context;
import org.eclipse.epsilon.evl.metamodel.Invariant;
import org.eclipse.epsilon.evl.visitor.resolution.type.hanlder.SatisfiesAllHandler;
import org.eclipse.epsilon.evl.visitor.resolution.type.hanlder.SatisfiesHandler;
import org.eclipse.epsilon.evl.visitor.resolution.type.hanlder.SatisfiesOneHandler;

public class EvlTypeResolutionContext extends TypeResolutionContext{

	protected HashMap<Context, InvariantHolder> invHolderMap = new HashMap<Context, InvariantHolder>();
	protected Context currentContext = null;
	protected Invariant currentInvariant = null;
	
	public EvlTypeResolutionContext(org.eclipse.epsilon.eol.EolLibraryModule module)
	{
		this.module = module;
		operationDefinitionControl.getHandlerFactory().addHandler(new SatisfiesHandler(this));
		operationDefinitionControl.getHandlerFactory().addHandler(new SatisfiesAllHandler(this));
		operationDefinitionControl.getHandlerFactory().addHandler(new SatisfiesOneHandler(this));
		
		operationDefinitionControl.getStandardLibraryOperationDefinitionContainer().registerOperation(this.getClass(), "EvlOperations.eol");
	}
	
	public void insertInv(Context context, String name, Invariant inv)
	{
		InvariantHolder holder = invHolderMap.get(context);
		if (holder != null) {
			if (holder.getInv(name) == null) {
				holder.insertInv(name, inv);
			}
		}
		else {
			InvariantHolder h = new InvariantHolder();
			h.insertInv(name, inv);
			invHolderMap.put(context, h);
		}
	}
	
	public Invariant getInv(Context context, String name)
	{
		InvariantHolder holder = invHolderMap.get(context);
		if (holder != null) {
			return holder.getInv(name);
		}
		else {
			return null;
		}
	}
	
	public void setCurrentContext(Context currentContext) {
		this.currentContext = currentContext;
	}
	
	public Context getCurrentContext() {
		return currentContext;
	}
	
	public void setCurrentInvariant(Invariant currentInvariant) {
		this.currentInvariant = currentInvariant;
	}
	
	public Invariant getCurrentInvariant() {
		return currentInvariant;
	}
	
}
