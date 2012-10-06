package org.eclipse.epsilon.emc.metaedit;

import java.rmi.RemoteException;

import org.eclipse.epsilon.emc.metaedit.api.MEOop;
import org.eclipse.epsilon.emc.metaedit.api.MetaEditAPIPortType;
import org.eclipse.epsilon.eol.execute.prettyprinting.PrettyPrinter;



public class MetaEditPrettyPrinter implements PrettyPrinter {
	
	protected MetaEditAPIPortType port = null;
	
	public MetaEditPrettyPrinter(MetaEditAPIPortType port) {
		this.port = port;
	}
	
	@Override
	public boolean appliesTo(Object o) {
		return o instanceof MEOop;
	}

	@Override
	public String print(Object o) {
		try {
			return port.userPrintString((MEOop) o);
		} catch (RemoteException e) {
			return e.getMessage();
		}
	}

}
