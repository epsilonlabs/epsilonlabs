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

import java.util.HashMap;
import java.util.Map;

import org.apache.tools.ant.Project;

/**
 * A registry of artifact handlers to make managing them easier.
 * 
 * @author zschaler
 * 
 */
public class ArtifactHandlerRegistry {

	private static Map<Project, ArtifactHandlerRegistry> s_mpSingleton = new HashMap<Project, ArtifactHandlerRegistry>();

	/**
	 * There's only one registry per project.
	 */
	public static ArtifactHandlerRegistry getInstance(Project project) {
		ArtifactHandlerRegistry ahrTentative = s_mpSingleton.get(project);
		if (ahrTentative == null) {
			ahrTentative = new ArtifactHandlerRegistry();
			s_mpSingleton.put(project, ahrTentative);
		}
		return ahrTentative;
	}

	private static final String JAVA15_HANDLER = "java15";
	private static final String XML_HANDLER = "xml";
	private static final String CSHARP_HANDLER = "csharp";

	private Map<String, ArtifactHandler> mpRegistry = new HashMap<String, ArtifactHandler>();

	private ArtifactHandlerRegistry() {
		super();
		register(JAVA15_HANDLER, new Java15Handler());
		register(XML_HANDLER, new XmlHandler());
		register(CSHARP_HANDLER, new CSharpHandler());
	}

	public ArtifactHandler getHandler(String handlerID) {
		return mpRegistry.get(handlerID);
	}

	public void register(String handlerID, ArtifactHandler handler) {
		mpRegistry.put(handlerID, handler);
	}
}
