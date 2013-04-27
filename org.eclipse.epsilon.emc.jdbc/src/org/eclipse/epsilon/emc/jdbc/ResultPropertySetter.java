package org.eclipse.epsilon.emc.jdbc;

import java.sql.SQLException;

import org.eclipse.epsilon.eol.exceptions.EolInternalException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.AbstractPropertySetter;

public class ResultPropertySetter extends AbstractPropertySetter {

	@Override
	public void invoke(Object value) throws EolRuntimeException {
		try {
			((Result) object).setValue(property, value);
		} catch (SQLException e) {
			throw new EolInternalException(e);
		}
	}

}
