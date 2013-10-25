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

import org.eclipse.epsilon.eol.exceptions.EolIllegalPropertyException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.AbstractPropertyGetter;

public class MdrPropertyGetter extends AbstractPropertyGetter{

	public Object invoke(Object object, String property) throws EolRuntimeException {

		RefObject refObject = (RefObject) object;
		
		StructuralFeature sf = MdrUtil.getStructuralFeature(refObject,property);
		
		if (sf != null) {
			
			if (MdrUtil.isMany(sf)){
				return (Collection) refObject.refGetValue(sf);
				//Collection values = (Collection) refObject.refGetValue(sf);
				//if (sf.getMultiplicity().isOrdered() && sf.getMultiplicity().isUnique()) return new EolOrderedSet(values);
				//else if (sf.getMultiplicity().isOrdered()) return new EolSequence(values);
				//else if (sf.getMultiplicity().isUnique()) return new EolSet(values);
				//else return new EolBag(values);
				
			}
			else {
				return refObject.refGetValue(sf);
			}
		}
		else {
			throw new EolIllegalPropertyException(object, property, ast, context);
		}
	}

}
