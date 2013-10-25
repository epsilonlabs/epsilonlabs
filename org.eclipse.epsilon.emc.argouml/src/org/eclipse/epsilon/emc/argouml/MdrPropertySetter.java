/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.emc.argouml;

import java.util.Collection;

import javax.jmi.model.StructuralFeature;
import javax.jmi.reflect.RefObject;

import org.eclipse.epsilon.eol.exceptions.EolIllegalPropertyAssignmentException;
import org.eclipse.epsilon.eol.exceptions.EolIllegalPropertyException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.AbstractPropertySetter;
import org.eclipse.epsilon.eol.execute.introspection.IReflectivePropertySetter;

public class MdrPropertySetter extends AbstractPropertySetter implements IReflectivePropertySetter {

	public void invoke(Object value) throws EolRuntimeException {
		RefObject refObject = (RefObject) object;
		
		StructuralFeature feature = MdrUtil.getStructuralFeature(refObject,property);
		
		if (feature != null) {
			if (MdrUtil.isMany(feature)){
				
				//Collection sourceValues = (Collection) refObject.refGetValue(feature);
				
				MdrPropertyGetter getter = new MdrPropertyGetter();
				Collection sourceValues = (Collection) getter.invoke(refObject, property);
				
				if (value instanceof Collection){
					MdrUtil.setCollectionValues((Collection)value,sourceValues);
				}
				else {
					throw new EolIllegalPropertyAssignmentException(
							this.getProperty(), this.getAst());
				}
			}
			else { 
				if (value != null) refObject.refSetValue(property, value);
			}
		}
		else {
			throw new EolIllegalPropertyException(object, property, ast, context);
		}
	}

	public Object coerce(Object value) throws EolIllegalPropertyException {
		return value;
	}

	public boolean conforms(Object value) throws EolIllegalPropertyException {
		return true;
	}
}
