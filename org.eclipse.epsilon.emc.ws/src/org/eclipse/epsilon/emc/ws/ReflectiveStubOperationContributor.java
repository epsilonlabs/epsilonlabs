package org.eclipse.epsilon.emc.ws;

import javax.wsdl.BindingOperation;
import javax.wsdl.Port;

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
		ReflectiveStub stub = (ReflectiveStub) target;
		Port port = (Port) stub.getService().getPorts().values().iterator().next();
		for (Object o : port.getBinding().getBindingOperations()) {
			BindingOperation bindingOperation = (BindingOperation) o;
			if (bindingOperation.getName().equals(name)) {
				return new RemoteObjectMethod(target, bindingOperation);
			}
		}
		return null;
	}
	
}
