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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

public abstract class SpreadsheetRow {
	
	protected SpreadsheetWorksheet worksheet;
	
	public SpreadsheetRow(SpreadsheetWorksheet worksheet) {
		this.worksheet = worksheet;
	}
	
	/*
	 * Returns the worksheet this row belongs to.
	 */
	public SpreadsheetWorksheet getWorksheet() {
		return this.worksheet;
	}
	
	/*
	 * Returns the visible value of the cell that corresponds to the given SpreadsheetColumn.
	 */
	public abstract String getVisibleCellValue(SpreadsheetColumn column);
	
	/*
	 * Returns a list of all visible values of the cell that corresponds to the given 
	 * SpreadsheetColumn. If the column is many=true, then the list contains all individual 
	 * elements of the cell.
	 */
	public List<String> getAllVisibleCellValues(SpreadsheetColumn column) {
		String cellValue = this.getVisibleCellValue(column);
		List<String> values = new ArrayList<String>();
		
		if (cellValue != null) {
			if (column.isMany()) {
				for (String s : cellValue.split(column.getDelimiter())) {
					values.add(s);
				}
			} else {
				values.add(cellValue);
			}
		}
		
		return values;
	}
	
	/*
	 * Writes the given values to the cell that corresponds to the given SpreadsheetColumn.
	 */
	public void writeVisibleCellValues(SpreadsheetColumn column, List<String> valuesToWrite) throws EolRuntimeException {
		if (valuesToWrite.isEmpty()) {
			this.overwriteCellValue(column, SpreadsheetConstants.DEFAULT_DT_VALUE);
			return;
		}
		
		if (!column.isMany()) {
			String value = valuesToWrite.get(0);
			
			// Ensure data type conformance
			if (column.getWorksheet().isDataTypeStrict()) {
				value = SpreadsheetDataType.castColumnValue(column.getDataType(), value).toString();
			}
			
			// Write the value
			this.overwriteCellValue(column, value);
		} else {
			// Ensure only unique values are written to the cell
			HashSet<String> valueSet = new HashSet<String>(valuesToWrite);
			
			// Concatenate the values to write
			String valueToWrite = null;
			for (String val : valueSet) {
				if (column.getWorksheet().isDataTypeStrict()) {
					val = SpreadsheetDataType.castColumnValue(column.getDataType(), val).toString();
				}
				
				if (valueToWrite == null) {
					valueToWrite = val;
				} else {
					valueToWrite += column.getDelimiter() + val;
				}
			}
			
			// Write the new value to the cell
			this.overwriteCellValue(column, valueToWrite);
		}
	}
	
	/*
	 * Overwrites the existing visible value of the cell that corresponds to the SpreadsheetColumn
	 * with the given value.
	 */
	public abstract void overwriteCellValue(SpreadsheetColumn column, String value) throws EolRuntimeException;
	
	@Override
	public String toString(){
		String ret = this.worksheet.getName() + " [";
		boolean commaSet = false;
		StringBuffer buf = new StringBuffer();
		for (SpreadsheetColumn c : this.worksheet.getHeader()) {
			String headerName = c.getIdentifier();
			String cellValue = this.getVisibleCellValue(c);

			if (cellValue != null){
				if (commaSet) buf.append(", ");
				buf.append(headerName + "='" + cellValue+"'");
				commaSet = true;
			}
		}
		ret += buf.toString();
		return ret + "]";
	}
}
