package org.eclipse.epsilon.emc.jdbc;

import java.sql.SQLException;

import org.eclipse.epsilon.eol.exceptions.EolInternalException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.AbstractPropertyGetter;

public class ResultPropertyGetter extends AbstractPropertyGetter {
	
	@Override
	public Object invoke(Object object, String property)
			throws EolRuntimeException {
		
		if (object instanceof ResultSetList) {
			ResultSetList resultSetList = (ResultSetList) object;
			return new PrimitiveValuesList(resultSetList.getModel(), resultSetList.getTable(), 
					property, resultSetList.getCondition(), resultSetList.getParameters(), false);
		}
		else {
			try {
				return ((Result) object).getValue(property);
			} catch (SQLException e) {
				throw new EolInternalException(e);
			}
		}
	}

}
