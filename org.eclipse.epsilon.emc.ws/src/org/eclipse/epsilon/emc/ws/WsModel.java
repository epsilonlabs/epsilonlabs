package org.eclipse.epsilon.emc.ws;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.wsdl.Definition;
import javax.wsdl.Service;
import javax.wsdl.factory.WSDLFactory;
import javax.xml.namespace.QName;

import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.eol.execute.operations.contributors.IOperationContributorProvider;
import org.eclipse.epsilon.eol.execute.operations.contributors.OperationContributor;
import org.eclipse.epsilon.eol.models.Model;

public class WsModel extends Model implements IOperationContributorProvider {
	
	protected String wsdl = null;
	protected Definition definition = null;
	protected List<ReflectiveStub> stubs = new ArrayList<ReflectiveStub>();
	protected ReflectiveStubOperationContributor operationContributor = new ReflectiveStubOperationContributor();
	
	public static void main(String[] args) throws Exception {
		
		WsModel model = new WsModel();
		model.setWsdl("/Users/dimitrioskolovos/Projects/Eclipse/adt-bundle-mac-x86_64-20130219/eclipse/workspace/com.example.calculatorservice/WebContent/wsdl/Calculator.wsdl");
		model.load();
		
		EolModule module = new EolModule();
		module.parse("var c : new CalculatorService; c.add(1, 2);");
		module.getContext().getModelRepository().addModel(model);
		module.execute();
		
	}
	
	@Override
	public void load() throws EolModelLoadingException {
		try {
			definition = WSDLFactory.newInstance().newWSDLReader().readWSDL(wsdl);
		}
		catch (Exception ex) {
			throw new EolModelLoadingException(ex, this);
		}
	}
	
	public void run() {
		
	}
	
	@Override
	public Collection<?> allContents() {
		return stubs;
	}

	@Override
	public Object createInstance(String type) throws EolModelElementTypeNotFoundException, EolNotInstantiableModelElementTypeException {
		ReflectiveStub stub = new ReflectiveStub(serviceForName(type));
		stubs.add(stub);
		return stub;
	}

	@Override
	public void deleteElement(Object e) throws EolRuntimeException {
		stubs.remove(e);
	}

	@Override
	public Collection<?> getAllOfKind(String type) throws EolModelElementTypeNotFoundException {
		return getAllOfType(type);
	}

	@Override
	public Collection<?> getAllOfType(String type) throws EolModelElementTypeNotFoundException {
		Service service = serviceForName(type);
		List<ReflectiveStub> ofType = new ArrayList<ReflectiveStub>();
		for (ReflectiveStub stub : stubs) {
			if (stub.getService() == service) {
				ofType.add(stub);
			}
		}
		return ofType;
	}

	@Override
	public Object getElementById(String arg0) {
		return null;
	}

	@Override
	public String getElementId(Object arg0) {
		return null;
	}

	@Override
	public Object getEnumerationValue(String arg0, String arg1) throws EolEnumerationValueNotFoundException {
		return null;
	}

	@Override
	public String getTypeNameOf(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasType(String type) {
		return serviceForName(type) != null;
	}
	
	protected Service serviceForName(String serviceName) {
		Map<?, ?> services = definition.getAllServices();
		for (Object key : services.keySet()) {
			if (key instanceof QName) {
				QName name = (QName) key;
				if (name.getLocalPart().equals(serviceName)) {
					return (Service) services.get(key);
				}
			}
		}
		return null;
	}
	
	@Override
	public boolean isInstantiable(String arg0) {
		return true;
	}

	@Override
	public boolean owns(Object o) {
		return stubs.contains(o);
	}

	@Override
	public void setElementId(Object arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean store() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean store(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void setWsdl(String wsdl) {
		this.wsdl = wsdl;
	}
	
	public String getWsdl() {
		return wsdl;
	}

	@Override
	public OperationContributor getOperationContributor() {
		return operationContributor;
	}

}
