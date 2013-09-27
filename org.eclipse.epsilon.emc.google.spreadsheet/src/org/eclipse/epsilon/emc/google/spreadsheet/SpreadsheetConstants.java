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

public class SpreadsheetConstants {

	public static final String ORM_REFERENCE_SEP = "->";
	
	public static final String DT_STRING = "string";
	public static final String DT_INTEGER = "integer";
	public static final String DT_BOOLEAN = "boolean";
	public static final String DT_DOUBLE = "double";
	public static final String DT_FLOAT = "float";
	
	public static final boolean DEFAULT_WORKSHEET_DT_STRICT = false;
	public static final boolean DEFAULT_WORKSHEET_CREATE_ON_LOAD = false;
	public static final int DEFAULT_WORKSHEET_COLS = 10;
	public static final int DEFAULT_WORKSHEET_ROWS = 20;
	
	public static final String DEFAULT_DT_STRING = " ";
	public static final String DEFAULT_DT_INTEGER = "0";
	public static final String DEFAULT_DT_BOOLEAN = "true";
	public static final String DEFAULT_DT_DOUBLE = "0"; // 0.0d displayed as 0 in spreadsheets
	public static final String DEFAULT_DT_FLOAT = "0"; // 0.0f displayed as 0 in spreadsheets
	public static final String DEFAULT_DT_VALUE = " ";
	
	public static final SpreadsheetDataType DEFAULT_COL_DATATYPE = SpreadsheetDataType.STRING;
	public static final boolean DEFAULT_COL_MANY = false;
	public static final String DEFAULT_COL_DELIMITER = ",";
	public static final String PREFIX_COL = "c_";
	public static final String PREFIX_VAL = "v_";
	
	public static final boolean DEFAULT_REF_MANY = false;
	public static final boolean DEFAULT_REF_CASCADE = false;
	
	public static final String WSH_IGNORE_CHARS = "--";
}
