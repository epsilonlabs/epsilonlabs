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

public class ORMConstants extends SpreadsheetConstants {

	/*
	 * XML elements and attributes
	 */
	public static final String ORM_WORKSHEET = "worksheet";
	public static final String ORM_COLUMN = "column";
	public static final String ORM_REFERENCE = "reference";
	
	public static final String ORM_WORKSHEET_NAME = "name";
	public static final String ORM_WORKSHEET_ALIAS = "alias";
	public static final String ORM_WORKSHEET_DTSTRICT = "dataTypeStrict";
	public static final String ORM_WORKSHEET_CREATE = "createOnLoad";
	
	public static final String ORM_COL_INDEX = "index";
	public static final String ORM_COL_NAME = "name";
	public static final String ORM_COL_ALIAS = "alias";
	public static final String ORM_COL_DATA_TYPE = "dataType";
	public static final String ORM_COL_MANY = "many";
	public static final String ORM_COL_DELIMITER = "delimiter";
	
	public static final String ORM_REF_SOURCE = "source";
	public static final String ORM_REF_TARGET = "target";
	public static final String ORM_REF_MANY = "many";
	public static final String ORM_REF_CASCADE = "cascadeChanges";
	
}
