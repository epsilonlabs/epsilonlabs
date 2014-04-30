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

import java.io.StringBufferInputStream;

import tmp.generated_java15.Java15Parser;
import tmp.generated_java15.SimplePrintVisitor;
import cide.gparser.OffsetCharStream;
import cide.gparser.ParseException;
import de.ovgu.cide.fstgen.ast.FSTNode;
import de.ovgu.cide.fstgen.ast.FSTNonTerminal;

/**
 * FST handler for Java files.
 * 
 * @author zschaler
 */
@SuppressWarnings("deprecation")
public class Java15Handler implements ArtifactHandler {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.epsilon.egl.symmetric_ao.tasks.superimpose.ArtifactHandler
	 * #print(de.ovgu.cide.fstgen.ast.FSTNode)
	 */
	@Override
	public String print(FSTNode fst) {
		SimplePrintVisitor visitor = new SimplePrintVisitor();
		visitor.visit((FSTNonTerminal) fst);
		return visitor.getResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.epsilon.egl.symmetric_ao.tasks.superimpose.ArtifactHandler
	 * #process(java.lang.String)
	 */
	@Override
	public FSTNode process(String content) throws ParseException {
		// Code copied and adjusted from FeatureHouse's JavaBuilder.
		Java15Parser p = new Java15Parser(new OffsetCharStream(
				new StringBufferInputStream(content)));
		p.CompilationUnit(false);
		return p.getRoot();
	}
}