package org.eclipse.epsilon.emc.metaedit;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;

import org.eclipse.epsilon.emc.metaedit.api.MEAny;
import org.eclipse.epsilon.emc.metaedit.api.MEOop;
import org.eclipse.epsilon.emc.metaedit.api.METype;
import org.eclipse.epsilon.emc.metaedit.api.MetaEditAPIPortType;
import org.eclipse.epsilon.eol.exceptions.EolInternalException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.AbstractPropertyGetter;



public class MetaEditPropertyGetter extends AbstractPropertyGetter {

	protected MetaEditAPIPortType port = null;
	protected MetaEditModel model = null;
	
	@Override
	public Object invoke(Object object, String property)
			throws EolRuntimeException {
		
		try {
			MEOop np = (MEOop) object;
			
			Object propertyValue = MEOopUtil.getPropertyValue(np, property, port);
			if (propertyValue != null) return propertyValue;
		
			if (model.isRelationship(np)) {
				METype roleType = new METype(property);
				MEOop[] roles = port.rolesForRel(model.graph, np, roleType);
				if (roles.length > 0) {
					MEOop role = roles[0];
					return port.objsForRole(model.graph, role, new METype("NonProperty"))[0];
				}
			}
			else {
				METype roleType = new METype(property);
				MEOop[] roles = port.rolesForObj(model.graph, np, roleType);
				if (roles.length > 0) {
					ArrayList<MEOop> relationships = new ArrayList<MEOop>();
					for (MEOop role : roles) {
						relationships.add(port.relsForRole(model.graph, role, new METype("NonProperty"))[0]);
					}
					return relationships;
				}
				else {
					return Collections.EMPTY_LIST;
				}
			}
			
			System.err.println("Returning null...");
			return null;
		
		}
		
		catch (RemoteException ex) {
			throw new EolInternalException(ex);
		}
	}

	public MetaEditAPIPortType getPort() {
		return port;
	}
	
	public void setPort(MetaEditAPIPortType port) {
		this.port = port;
	}
	
	public MetaEditModel getModel() {
		return model;
	}
	
	public void setModel(MetaEditModel model) {
		this.model = model;
	}
	
}
