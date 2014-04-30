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

import java.util.ArrayList;
import java.util.List;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.Task;

/**
 * ANT Task allowing the registration of new artifact handlers for
 * superimposition merge.
 * 
 * @author zschaler
 */
public class RegisterArtifactHandlers extends Task {

	public static class AHDescriptor {

		/**
		 * The artifact handler ID
		 */
		private String sArtifactID;

		/**
		 * The class name of the class of the artifact handler.
		 */
		private String sAHClassName;

		/**
		 * Set the ID under which this artifact handler should be registered.
		 * 
		 * @param sName
		 */
		public void setName(String sName) {
			sArtifactID = sName;
		}

		/**
		 * Set the name of a subclass of ArtifactHandler, which implements this
		 * artifact handler.
		 * 
		 * @param sClass
		 */
		public void setClass(String sClass) {
			sAHClassName = sClass;
		}

		/**
		 * Used to register the described artifact handler for a given project.
		 * 
		 * @param p
		 * 
		 * @throws ClassNotFoundException
		 * @throws InstantiationException
		 * @throws IllegalAccessException
		 */
		public void registerHandler(Project p) throws ClassNotFoundException,
				InstantiationException, IllegalAccessException {
			@SuppressWarnings("rawtypes")
			Class cHandler = Class.forName(sAHClassName);
			if (ArtifactHandler.class.isAssignableFrom(cHandler)) {
				ArtifactHandlerRegistry.getInstance(p).register(sArtifactID,
						(ArtifactHandler) cHandler.newInstance());
			} else {
				throw new IllegalArgumentException("Class " + sAHClassName
						+ " is not a valid artifact-handler class.");
			}
		}
	}

	private List<AHDescriptor> lAHDescs = new ArrayList<AHDescriptor>();

	public AHDescriptor createArtifact() {
		AHDescriptor ahdNew = new AHDescriptor();
		lAHDescs.add(ahdNew);
		return ahdNew;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.tools.ant.Task#execute()
	 */
	@Override
	public void execute() throws BuildException {
		for (AHDescriptor ahdCurrent : lAHDescs) {
			try {
				ahdCurrent.registerHandler(getProject());
			} catch (Exception e) {
				throw new BuildException(e);
			}
		}
	}
}