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

public enum SpreadsheetDataType {

	STRING,
	INTEGER,
	BOOLEAN,
	DOUBLE,
	FLOAT;

	/*
	 * Converts the given SpreadsheetDataType to the corresponding internal representation. If it cannot
	 * be converted, then SpreadsheetConstants.DEFAULT_COL_DATATYPE is returned instead.
	 */
	public static SpreadsheetDataType convert(String colType) {
		if (colType != null) {
			String colTypeLow = colType.toLowerCase();
			if (colTypeLow.equals(SpreadsheetConstants.DT_STRING)) {
				return SpreadsheetDataType.STRING;
			} else if (colTypeLow.equals(SpreadsheetConstants.DT_INTEGER)) {
				return SpreadsheetDataType.INTEGER;
			} else if (colTypeLow.equals(SpreadsheetConstants.DT_BOOLEAN)) {
				return SpreadsheetDataType.BOOLEAN;
			} else if (colTypeLow.equals(SpreadsheetConstants.DT_DOUBLE)) {
				return SpreadsheetDataType.DOUBLE;
			} else if (colTypeLow.equals(SpreadsheetConstants.DT_FLOAT)) {
				return SpreadsheetDataType.FLOAT;
			};
		}
		return SpreadsheetConstants.DEFAULT_COL_DATATYPE;
	}
	
	/*
	 * Ensures that the given value conforms to the given SpreadsheetDataType If the value 
	 * does not conform or cannot be converted then the default value of the given 
	 * SpreadsheetDataType is returned.
	 */
	public static Object castColumnValue(SpreadsheetDataType dt, String value) {
		try {
			if (dt == SpreadsheetDataType.STRING) {
				return String.valueOf(value);
			} else if (dt == SpreadsheetDataType.INTEGER) {
				return Integer.parseInt(value);
			} else if (dt == SpreadsheetDataType.BOOLEAN) {
				return Boolean.parseBoolean(value);
			} else if (dt == SpreadsheetDataType.DOUBLE) {
				return Double.parseDouble(value);
			} else if (dt == SpreadsheetDataType.FLOAT) {
				return Float.parseFloat(value);
			} else {
				throw new Exception("Unknown data type: '" + dt + "'.");
			}
		} catch(NumberFormatException e) {
			return SpreadsheetDataType.getDefaultDTValue(dt);
		} catch(NullPointerException e) {
			return SpreadsheetDataType.getDefaultDTValue(dt);
		} catch(Exception e) {
			e.printStackTrace();
			return SpreadsheetDataType.getDefaultDTValue(dt);
		}
	}
	
	/*
	 * Returns the default value of the given SpreadsheetDataType. If an unknown data type
	 * is given, then SpreadsheetConstants.DEFAULT_DT_VALUE is returned instead.
	 */
	public static String getDefaultDTValue(SpreadsheetDataType dt) {
		if (dt == SpreadsheetDataType.STRING) {
			return SpreadsheetConstants.DEFAULT_DT_STRING;
		} else if (dt == SpreadsheetDataType.INTEGER) {
			return SpreadsheetConstants.DEFAULT_DT_INTEGER;
		} else if (dt == SpreadsheetDataType.BOOLEAN) {
			return SpreadsheetConstants.DEFAULT_DT_BOOLEAN;
		} else if (dt == SpreadsheetDataType.DOUBLE) {
			return SpreadsheetConstants.DEFAULT_DT_DOUBLE;
		} else if (dt == SpreadsheetDataType.FLOAT) {
			return SpreadsheetConstants.DEFAULT_DT_FLOAT;
		} else {
			return SpreadsheetConstants.DEFAULT_DT_VALUE;
		}
	}
	
	/*
	 * Returns a string representation of the given SpreadsheetDataType. If it is
	 * unknown, then null is returned.
	 */
	public static String formatAsString(SpreadsheetDataType dt) {
		if (dt == SpreadsheetDataType.STRING) {
			return "String";
		} else if (dt == SpreadsheetDataType.INTEGER) {
			return "Integer";
		} else if (dt == SpreadsheetDataType.BOOLEAN) {
			return "Boolean";
		} else if (dt == SpreadsheetDataType.DOUBLE) {
			return "Double";
		} else if (dt == SpreadsheetDataType.FLOAT) {
			return "Float";
		} else {
			return null;
		}
	}
}
