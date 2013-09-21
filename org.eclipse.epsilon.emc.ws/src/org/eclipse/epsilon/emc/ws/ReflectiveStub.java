package org.eclipse.epsilon.emc.ws;

import javax.wsdl.Service;

public class ReflectiveStub {
	
	protected Service service = null;
	
	public ReflectiveStub(Service service) {
		this.service = service;
	}
	
	public Service getService() {
		return service;
	}
	
}
