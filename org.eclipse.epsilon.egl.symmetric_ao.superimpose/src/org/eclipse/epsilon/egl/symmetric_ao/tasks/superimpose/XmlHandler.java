/**
 * Copyright (C) 2010 Lancaster University.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or 
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the 
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License 
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors:
 * 
 *   Steffen Zschaler -- Initial Implementation
 */
package org.eclipse.epsilon.egl.symmetric_ao.tasks.superimpose;

import de.ovgu.cide.fstgen.ast.FSTNode;

/**
 * Artifact handler for XML files.
 * 
 * @author zschaler
 */
public class XmlHandler implements ArtifactHandler {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.epsilon.egl.symmetric_ao.tasks.superimpose.ArtifactHandler
	 * #print(de.ovgu.cide.fstgen.ast.FSTNode)
	 */
	@Override
	public String print(FSTNode fst) {
		// TODO: Implement XML handling
		throw new UnsupportedOperationException(
				"XML merging not currently supported.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.epsilon.egl.symmetric_ao.tasks.superimpose.ArtifactHandler
	 * #process(java.lang.String)
	 */
	@Override
	public FSTNode process(String content) {
		// TODO: Implement XML handling
		throw new UnsupportedOperationException(
				"XML merging not currently supported.");
	}

}
