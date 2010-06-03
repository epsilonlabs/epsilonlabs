package org.eclipse.epsilon.emc.htmlunit;

import java.lang.reflect.Method;

import org.eclipse.epsilon.eol.execute.introspection.java.JavaPropertyGetter;

public class HtmlUnitModelPropertyGetter extends JavaPropertyGetter {
	
	@Override
	protected Method getMethodFor(Object object, String property) {
		Method method = super.getMethodFor(object, property + "Attribute");
		if (method == null) {
			method = super.getMethodFor(object, property);
		}
		return method;
	}
	
}
