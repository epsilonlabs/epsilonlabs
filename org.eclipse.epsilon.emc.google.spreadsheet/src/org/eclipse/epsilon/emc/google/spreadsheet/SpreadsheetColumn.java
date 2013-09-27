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

public class SpreadsheetColumn {

	protected SpreadsheetWorksheet worksheet;
	protected int index;
	protected String name;
	protected String alias;
	protected SpreadsheetDataType dataType;
	protected boolean many;
	protected String delimiter;
	
	public SpreadsheetColumn(SpreadsheetWorksheet worksheet, int index) {
		if (index < 1) {
			throw new IllegalArgumentException("Column indexing begins with 1.");
		}
		this.worksheet = worksheet;
		this.index = index;
		this.name = null;
		this.alias = null;
		this.dataType = SpreadsheetConstants.DEFAULT_COL_DATATYPE;
		this.many = SpreadsheetConstants.DEFAULT_COL_MANY;
		this.delimiter = SpreadsheetConstants.DEFAULT_COL_DELIMITER;
	}
	
	/*
	 * Returns the worksheet this column belongs to.
	 */
	public SpreadsheetWorksheet getWorksheet() {
		return this.worksheet;
	}
	
	/*
	 * Returns the column index of the column.
	 */
	public int getIndex() {
		return this.index;
	}
	
	/*
	 * Returns the column name of the column.
	 */
	public String getName() {
		return this.name;
	}
	
	/*
	 * Returns the column alias of the column.
	 */
	public String getAlias() {
		return this.alias;
	}
	
	/*
	 * Returns the data type of the column.
	 */
	public SpreadsheetDataType getDataType() {
		return this.dataType;
	}
	
	/*
	 * Returns whether the column may contain many values.
	 */
	public boolean isMany() {
		return this.many;
	}
	
	/*
	 * Returns the delimiter used for separating the individual cell values.
	 */
	public String getDelimiter() {
		return this.delimiter;
	}
	
	/*
	 * Sets the name of the column.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/*
	 * Sets the alias of the column.
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	/*
	 * Sets the data type of the column.
	 */
	public void setDataType(SpreadsheetDataType dt) {
		this.dataType = dt;
	}
	
	/*
	 * Sets whether the column contains many values.
	 */
	public void setMany(Boolean many) {
		this.many = many;
	}
	
	/*
	 * Sets the delimiter of the values stored in individual cells of the column.
	 */
	public void setDelimiter(String delimiter) {
		this.delimiter = delimiter;
	}
	
	/*
	 * Column can be identified either by its name, alias or prefixed column index.
	 */
	public boolean isIdentifiableBy(String identifier) {
		try {
			if (identifier != null) {
				return (this.name != null && this.name.equals(identifier) || 
						this.alias != null && this.alias.equals(identifier) ||
						((identifier.startsWith(SpreadsheetConstants.PREFIX_COL) && 
								this.index == Integer.parseInt(identifier.substring(SpreadsheetConstants.PREFIX_COL.length())))));
			}
		} catch (NumberFormatException e) {
			// Ignore
		}
		return false;
	}
	
	/*
	 * Returns an identifier of the column. If name is set then it is returned, otherwise if
	 * alias is set then it is returned. If neither is set then prefixed column index is returned.
	 */
	public String getIdentifier() {
		if (this.name != null) {
			return this.name;
		} else if (this.alias != null) {
			return this.alias;
		} else {
			return SpreadsheetConstants.PREFIX_COL + Integer.toString(this.index);
		}
	}
	
	@Override
	public String toString() {
		String ret = Integer.toString(this.index) + ": [";
		if (this.name != null) {
			ret += "name='" + this.name + "', ";
		}
		if (this.alias != null) {
			ret += "alias='" + this.alias + "', ";
		}
		if (this.dataType != null) {
			ret += "dataType='" + SpreadsheetDataType.formatAsString(this.dataType) + "', ";
		}
		ret += "many='" + Boolean.toString(many) + "', ";
		ret += "delimiter='" + this.delimiter + "'";
		return ret + "]";  
	}
}
