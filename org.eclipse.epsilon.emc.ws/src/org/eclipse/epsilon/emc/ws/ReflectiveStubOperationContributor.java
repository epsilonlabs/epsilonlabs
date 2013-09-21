package org.eclipse.epsilon.emc.ws;

import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.introspection.java.ObjectMethod;
import org.eclipse.epsilon.eol.execute.operations.contributors.OperationContributor;

public class ReflectiveStubOperationContributor extends OperationContributor {

	@Override
	public boolean contributesTo(Object o) {
		return o instanceof ReflectiveStub;
	}
	
	@Override
	public ObjectMethod findContributedMethodForEvaluatedParameters(Object target, String name, Object[] parameters, IEolContext context) {
		return new RemoteObjectMethod(target, name);
	}
	
}
