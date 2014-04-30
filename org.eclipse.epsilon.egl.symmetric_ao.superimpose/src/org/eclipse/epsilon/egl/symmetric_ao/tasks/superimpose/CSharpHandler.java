/**
 * Copyright (C) 2014 King's College London.
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

import tmp.generated_csharp.CSharpParser;
import tmp.generated_csharp.SimplePrintVisitor;
import cide.gparser.OffsetCharStream;
import cide.gparser.ParseException;
import de.ovgu.cide.fstgen.ast.FSTNode;
import de.ovgu.cide.fstgen.ast.FSTNonTerminal;

/**
 * FST handler for CSharp files.
 * 
 * @author zschaler
 */
@SuppressWarnings("deprecation")
public class CSharpHandler implements ArtifactHandler {

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
		// Code copied and adjusted from FeatureHouse's CSharpBuilder.
		CSharpParser p = new CSharpParser(new OffsetCharStream(
				new StringBufferInputStream(content)));
		p.compilation_unit(false);
		return p.getRoot();
	}
}