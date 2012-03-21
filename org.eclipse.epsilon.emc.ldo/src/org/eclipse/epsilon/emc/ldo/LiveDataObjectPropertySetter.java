package org.eclipse.epsilon.emc.ldo;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.AbstractPropertySetter;

public class LiveDataObjectPropertySetter extends AbstractPropertySetter {

	@Override
	public void invoke(Object value) throws EolRuntimeException {
		throw new EolRuntimeException("Object is read-only");
	}

}
