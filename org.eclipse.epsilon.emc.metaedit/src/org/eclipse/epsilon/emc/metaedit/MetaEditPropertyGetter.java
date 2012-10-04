package org.eclipse.epsilon.emc.metaedit;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;

import org.eclipse.epsilon.eol.exceptions.EolInternalException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.AbstractPropertyGetter;

import com.metacase.API.MEAny;
import com.metacase.API.MEOop;
import com.metacase.API.METype;
import com.metacase.API.MetaEditAPIPortType;

public class MetaEditPropertyGetter extends AbstractPropertyGetter {

	protected MetaEditAPIPortType port = null;
	protected MetaEditModel model = null;
	
	@Override
	public Object invoke(Object object, String property)
			throws EolRuntimeException {
		
		try {
			MEOop np = (MEOop) object;
			
			ArrayList<MEOop> properties = new ArrayList<MEOop>();
			
			for (MEOop p : port.allProperties(np)) {
				properties.add(p);
			}
			
			for (MEOop p : properties) {
				if (property.equals(port.typeName(port.type(p)))) {
					//MEAny value = port.valueAt(np, properties.indexOf(p)+1);
					// Check out setValueAt for setting properties
					return port.userPrintString(p);
					// If type is not a primitive format is x_yyyy, need to create 
					// an MEOop manually (in this case meType is MEOop)
				}
			}
		
			if (model.isRelationship(np)) {
				METype roleType = new METype(property);
				MEOop[] roles = port.rolesForRel(model.model, np, roleType);
				if (roles.length > 0) {
					MEOop role = roles[0];
					return port.objsForRole(model.model, role, new METype("NonProperty"))[0];
				}
			}
			else {
				METype roleType = new METype(property);
				MEOop[] roles = port.rolesForObj(model.model, np, roleType);
				if (roles.length > 0) {
					ArrayList<MEOop> relationships = new ArrayList<MEOop>();
					for (MEOop role : roles) {
						relationships.add(port.relsForRole(model.model, role, new METype("NonProperty"))[0]);
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
