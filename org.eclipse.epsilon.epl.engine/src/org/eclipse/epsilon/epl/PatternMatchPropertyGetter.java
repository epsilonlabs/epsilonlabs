package org.eclipse.epsilon.epl;

import org.eclipse.epsilon.eol.exceptions.EolIllegalPropertyException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.introspection.AbstractPropertyGetter;

public class PatternMatchPropertyGetter extends AbstractPropertyGetter {

	@Override
	public Object invoke(Object object, String property)
			throws EolRuntimeException {
		PatternMatch match = (PatternMatch) object;
		Variable component = match.getComponent(property);
		if (component != null) {
			return component.getValue();
		}
		else throw new EolIllegalPropertyException(object, property, ast, context);
	}

}
