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

import cide.gparser.ParseException;
import de.ovgu.cide.fstgen.ast.FSTNode;

/**
 * A simplified replacement for FSTComp's artifact builders and printers.
 * Instead of processing complete files and directories of files, this simply
 * processes a single file's contents. Maintenance of the external hierarchy of
 * FSTNodes is left completely to the caller.
 * 
 * @author zschaler
 */
public interface ArtifactHandler {
	/**
	 * Process the given string as the content of a feature and return a
	 * corresponding FSTNode that can later be used for merging.
	 * 
	 * @throws ParseException
	 *             if the provided contents cannot be parsed successfully
	 */
	public FSTNode process(String sContent) throws ParseException;

	/**
	 * Transform a given feature structure tree into a String representation.
	 * For example, an FST of a class file will be transformed into a String of
	 * the contents of that class file.
	 */
	public String print(FSTNode fst);
}