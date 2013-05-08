package org.eclipse.epsilon.mgl.engine;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.operations.contributors.OperationContributor;
import org.eclipse.epsilon.eol.types.EolModelElementType;

public class ModelElementTypeOperationContributor extends OperationContributor {

	@Override
	public boolean contributesTo(Object target) {
		return target instanceof EolModelElementType;
	}
	
	public Object generate(int instances) throws EolRuntimeException {
		return generate(instances, instances);
	}
	
	public Object generate(int lower, int upper) throws EolRuntimeException {
		EolModelElementType type = (EolModelElementType) target;
		
		if (upper == 1) {
			return type.createInstance();
		}
		else {
			List<Object> instances = new ArrayList<Object>();
			for (int i=0;i<upper;i++) {
				instances.add(type.createInstance());
			}
			return instances;
		}
	}

}
