package org.eclipse.epsilon.emc.metaedit;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.eclipse.epsilon.emc.metaedit.api.MEAny;
import org.eclipse.epsilon.emc.metaedit.api.MEOop;
import org.eclipse.epsilon.emc.metaedit.api.METype;
import org.eclipse.epsilon.emc.metaedit.api.MetaEditAPIPortType;



public class MEOopUtil {
	
	public static MEOop createMEOop(String s) {
		MEOop o = new MEOop();
		String[] parts = s.split("_");
		o.setAreaID(Integer.parseInt(parts[0]));
		o.setObjectID(Integer.parseInt(parts[1]));
		return o;
	}
	
	public static Object getPropertyValue(MEOop o, String property, MetaEditAPIPortType port) throws RemoteException {
		ArrayList<MEOop> properties = new ArrayList<MEOop>();
		
		for (MEOop p : port.allProperties(o)) {
			properties.add(p);
		}
		
		for (MEOop p : properties) {
			if (property.equals(port.typeName(port.type(p)))) {
				MEAny value = port.valueAt(o, properties.indexOf(p)+1);
				
				String valueType = value.getMeType();
				
				if (valueType.equalsIgnoreCase("OrderedCollection")) {
					ArrayList<MEOop> result = new ArrayList<MEOop>();
					for (String v : value.getMeValue().split(" ")) {
						if (v.trim().length() > 0)
						result.add(createMEOop(v));
					}
					return result;
				}
				else if (valueType.equals("Boolean")){
					return Boolean.parseBoolean(value.getMeValue());
				}
				else if (valueType.equals("String")) {
					return value.getMeValue().substring(1, value.getMeValue().length()-1);
				}
				else if (valueType.equals("MEOop")) {
					return createMEOop(value.getMeValue());
				}
				else if (valueType.equals("Integer")) {
					return Integer.parseInt(value.getMeValue());
				}
				else {
					System.err.println(valueType);
				}
				//System.err.println(port.typeName(port.type(p)));
				//System.err.println(value.getMeType()); // OrderedCollection
				//System.err.println(value);
				// Check out setValueAt for setting properties
				return value.getMeValue(); //port.userPrintString(p);
				// If type is not a primitive format is x_yyyy, need to create 
				// an MEOop manually (in this case meType is MEOop)
			}
		}
		return null;
	}
	
}
