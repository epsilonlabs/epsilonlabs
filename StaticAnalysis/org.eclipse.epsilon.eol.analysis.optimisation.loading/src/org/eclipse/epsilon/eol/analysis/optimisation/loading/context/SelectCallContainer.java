package org.eclipse.epsilon.eol.analysis.optimisation.loading.context;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.epsilon.eol.metamodel.FOLMethodCallExpression;

public class SelectCallContainer {

	protected HashMap<FOLMethodCallExpression, ArrayList<EffectiveFeature>> map = new HashMap<FOLMethodCallExpression, ArrayList<EffectiveFeature>>();
	
	
}
