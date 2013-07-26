package org.eclipse.epsilon.emc.incquery;

import org.eclipse.epsilon.emc.emf.EmfPropertyGetter;
import org.eclipse.epsilon.eol.exceptions.EolIllegalPropertyException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.incquery.patternlanguage.patternLanguage.Variable;
import org.eclipse.incquery.tooling.ui.queryexplorer.content.matcher.ObservablePatternMatch;

public class IncQueryPropertyGetter extends EmfPropertyGetter {

	@Override
	public Object invoke(Object object, String property)
			throws EolRuntimeException {
		
		System.err.println("Getting property " + property + " of " + object);
		
		if (object instanceof ObservablePatternMatch) {
			ObservablePatternMatch match = (ObservablePatternMatch) object;
			
			Object result = match.getPatternMatch().get(property);
			
			if (result == null) {
				for (Variable variable : match.getPatternMatch().pattern().getParameters()) {
					if (variable.getName().equals(property)) return result;
				}
			}
			else {
				return result;
			}
			
			throw new EolIllegalPropertyException(match, property, ast, context);
		}
		else return super.invoke(object, property);
		
	}

}
