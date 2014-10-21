package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.standard.library.collection.handlers.old;

import java.util.ArrayList;

import org.eclipse.epsilon.eol.metamodel.*;

public class IsDefinedHandler extends AnyOperationHandler{

	public IsDefinedHandler(LibraryOperationHandlerContext context)
	{
		this.contextType = context.getEolFactory().createAnyType();
		this.name = "isDefined";
		this.argTypes = new ArrayList<Type>();
		this.returnType = context.getEolFactory().createBooleanType();
	}

	@Override
	public void handle(MethodCallExpression call,
			LibraryOperationHandlerContext context) {
		BooleanType type = context.getEolFactory().createBooleanType();
		context.setAssets(type, call);
		call.setResolvedType(type);
	}

}
