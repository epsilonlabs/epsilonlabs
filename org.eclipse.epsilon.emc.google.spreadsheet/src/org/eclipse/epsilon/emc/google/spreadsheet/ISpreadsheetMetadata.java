/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Martins Francis - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.emc.google.spreadsheet;

import java.util.List;

public interface ISpreadsheetMetadata {

	/*
	 * Gets every worksheet meta-data specified in the ORM meta-data source.
	 * 
	 * @return List<SpreadsheetWorksheetMetadata>
	 * @throws IllegalArgumentException if the specified worksheet meta-data is invalid.
	 */
	public List<SpreadsheetWorksheetMetadata> getWorksheets() throws IllegalArgumentException;
	
	public class SpreadsheetWorksheetMetadata {
		protected String name = null;
		protected String alias = null;
		protected String dataTypeStrict = null;
		protected String createOnLoad = null;
	}
	
	/*
	 * Gets every column meta-data specified in the ORM meta-data source for the worksheet
	 * identifiable by the given 'name'.
	 * 
	 * @return List<SpreadsheetColumnMetadata>
	 * @throws IllegalArgumentException if the specified column meta-data is invalid.
	 */
	public List<SpreadsheetColumnMetadata> getColumns(String name) throws IllegalArgumentException;
	
	public class SpreadsheetColumnMetadata {
		protected String index = null;
		protected String name = null;
		protected String alias = null;
		protected String dataType = null;
		protected String many = null;
		protected String delimiter = null;
	}
	
	/*
	 * Gets every reference specified in the ORM meta-data source.
	 * 
	 * @return List<SpreadsheetReferenceMetadata>
	 * @throws IllegalArgumentException if a specified reference is invalid.
	 */
	public List<SpreadsheetReferenceMetadata> getReferences() throws IllegalArgumentException;
	
	public class SpreadsheetReferenceMetadata {
		protected String source = null;
		protected String target = null;
		protected String many = null;
		protected String cascadeChanges = null;
	}
}
