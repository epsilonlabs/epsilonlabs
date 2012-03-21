package org.eclipse.epsilon.emc.ldo;

import org.eclipse.epsilon.eol.exceptions.EolInternalException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.AbstractPropertyGetter;

public class LiveDataObjectPropertyGetter extends AbstractPropertyGetter {

	@Override
	public Object invoke(Object object, String property)
			throws EolRuntimeException {
		
		try {
			return ((LiveDataObject) object).get(property);
		} catch (Exception e) {
			throw new EolInternalException(e);
		}
		
	}

}
