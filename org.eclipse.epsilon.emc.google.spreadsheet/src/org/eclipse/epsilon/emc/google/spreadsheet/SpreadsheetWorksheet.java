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
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import org.eclipse.epsilon.emc.google.spreadsheet.ISpreadsheetMetadata.SpreadsheetColumnMetadata;
import org.eclipse.epsilon.emc.google.spreadsheet.ISpreadsheetMetadata.SpreadsheetWorksheetMetadata;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.types.EolMap;

public abstract class SpreadsheetWorksheet {

	protected SpreadsheetModel model;
	protected TreeSet<SpreadsheetColumn> header;
	protected boolean existsInSpreadsheet;
	protected String name;
	protected String alias;
	protected boolean dataTypeStrict;
	
	public SpreadsheetWorksheet(SpreadsheetModel model, String name, boolean existsInSpreadsheet) throws IllegalArgumentException {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Worksheet is missing its name.");
		}
		
		this.model = model;
		this.name = name;
		this.alias = null;
		this.existsInSpreadsheet = existsInSpreadsheet;
		this.dataTypeStrict = SpreadsheetConstants.DEFAULT_WORKSHEET_DT_STRICT;
		this.header = new TreeSet<SpreadsheetColumn>(new SpreadsheetColumnComparator());
	}
	
	/*
	 * Returns the Model this worksheet belongs to.
	 */
	public SpreadsheetModel getModel() {
		return this.model;
	}
	
	/*
	 * Returns the local representation of the worksheet's header.
	 */
	public TreeSet<SpreadsheetColumn> getHeader() {
		return this.header;
	}
	
	/*
	 * Returns whether this worksheet exists in the spreadsheet (model) or not.
	 */
	public boolean existsInSpreadsheet() {
		return this.existsInSpreadsheet;
	}
	
	/*
	 * Returns the name of the worksheet.
	 */
	public String getName() {
		return this.name;
	}
	
	/*
	 * Returns the alias of the worksheet.
	 */
	public String getAlias() {
		return this.alias;
	}
	
	/*
	 * Returns whether the worksheet is data type strict.
	 */
	public boolean isDataTypeStrict() {
		return this.dataTypeStrict;
	}
	
	/*
	 * Creates the worksheet in the spreadsheet.
	 */
	protected abstract void createInSpreadsheet() throws RuntimeException;
	
	/*
	 * Loads header row information -- index and name -- from the spreadsheet if the worksheet exists in the spreadsheet.
	 */
	protected abstract void loadHeader() throws EolModelLoadingException;
	
	/*
	 * Adds worksheet meta-data to the worksheet.
	 */
	protected void addMetadata(SpreadsheetWorksheetMetadata metadata) throws IllegalArgumentException {
		if (this.name.equals(metadata.name)) {
			if (metadata.alias != null && !metadata.alias.isEmpty()) {
				this.alias = metadata.alias;
			}
			
			if (metadata.dataTypeStrict != null && !metadata.dataTypeStrict.isEmpty()) {
				this.dataTypeStrict = Boolean.parseBoolean(metadata.dataTypeStrict);
			}
		} else {
			throw new IllegalArgumentException("The meta-data provided for worksheet '" + this.name + "' " +
											   "is actually for worksheet '" + metadata.name + "'.");
		}
	}
	
	/*
	 * Gets the header column with the matching column identifier.
	 * 
	 * @param identifier
	 * @return Column corresponding to the given identifier, or null if none exists.
	 */
	public SpreadsheetColumn getColumn(String identifier) {
		for (SpreadsheetColumn c : this.header) {
			if (c.isIdentifiableBy(identifier)) {
				return c;
			}
		}
		return null;
	}
	
	/*
	 * Gets the header column with the matching column index.
	 * 
	 * @param index
	 * @return Column corresponding to the given index, or null if none exists.
	 */
	public SpreadsheetColumn getColumn(int index) {
		for (SpreadsheetColumn c : this.header) {
			if (c.getIndex() == index) {
				return c;
			}
		}
		return null;
	}
	
	/*
	 * Adds information about an existing header column to the worksheet. If the column described by cObj
	 * does not exist then it is created.
	 * 
	 * @param cObj The SpreadsheetColumnObject containing information about the column.
	 * @return SpreadsheetColumn
	 */
	protected SpreadsheetColumn addColumn(SpreadsheetColumnMetadata cObj) throws EolModelLoadingException {
		try {
			// Validation check
			try {
				if (cObj.index != null) {
					Integer.parseInt(cObj.index);
				}
			} catch(NumberFormatException e) {
				throw new Exception("The index '" + cObj.index + "' specified for worksheet '" + this.name + "' " +
									"is not numeric.");
			}
			
			// Find (or create) the correct column object
			SpreadsheetColumn column = null;
			if (cObj.index != null) {
				column = this.getColumn(Integer.parseInt(cObj.index));
			}
			if (column == null && cObj.name != null) {
				column = this.getColumn(cObj.name);
			}
			if (column == null) {
				// Don't know of such column
				if (cObj.index != null) {
					// Create the column with the specified index
					column = this.createColumn(Integer.parseInt(cObj.index));
					this.header.add(column);
				} else{
					throw new Exception("Unable to construct column for worksheet '" + this.name + "' - index is unknown.");
				}
			}
			
			// Extract the additional column information
			if (cObj.name != null && !cObj.name.isEmpty()) {
				// If column contains a dash then set the name to only contain the characters up to the first dash
				String[] split_name = cObj.name.split("-");
				if (split_name.length != 0) {
					String name = split_name[0].trim();
					if (name.isEmpty()) {
						name = null;
					}
					column.setName(name);
				} else if (split_name.length == 0) { // Name is starting with a dash..
					column.setName(null);
				} else {
					column.setName(cObj.name);
				}
			}
			
			if (cObj.alias != null && !cObj.alias.isEmpty()) {
				column.setAlias(cObj.alias);
			}
			
			column.setDataType(SpreadsheetDataType.convert(cObj.dataType));
			
			if (cObj.many != null && !cObj.many.isEmpty()) {
				column.setMany(Boolean.parseBoolean(cObj.many));
			}
			
			if (cObj.delimiter != null && !cObj.delimiter.isEmpty()) {
				column.setDelimiter(cObj.delimiter);
			}
			
			return column;
		} catch(Exception e) {
			throw new EolModelLoadingException(e, this.model);
		}
	}
	
	/*
	 * Creates a column with the specified column index.
	 * 
	 * @param index The index of the column.
	 * @return The created column object.
	 */
	protected abstract SpreadsheetColumn createColumn(int index);
	
	/*
	 * Gets all rows contained by the worksheet.
	 * 
	 * @return List of all rows contained by the worksheet.
	 */
	protected abstract List<SpreadsheetRow> getRows() throws EolRuntimeException;
	
	/*
	 * Adds a row consisting of the given values to the worksheet. The collection of parameters may be empty.
	 * If 'parameters' is not empty, then it must contain a single EolMap that pairs columns and values to be
	 * written to the worksheet.
	 * 
	 * @param parameters The list of parameters provided in EOL during instantiation.
	 * @return The newly created row.
	 */
	@SuppressWarnings("unchecked")
	public Object addRow(Collection<Object> parameters) {
		Iterator<Object> param_it = parameters.iterator();
		HashMap<String,Object> eolMap = null;
		
		// Create local representation of the EolMap
		if (!parameters.isEmpty()) {
			Object first_param = param_it.next();
			if (first_param instanceof EolMap) {
				eolMap = (HashMap<String, Object>) first_param;
			} else {
				throw new IllegalArgumentException("An EOL map must be provided as the only argument when writing a " +
												   "row to a worksheet. Received: '" + parameters + "'");
			}
		} else {
			eolMap = new HashMap<String,Object>();
		}
		
		// Values that will actually be written to the corresponding columns
		HashMap<SpreadsheetColumn,String> valuesToInsert = new HashMap<SpreadsheetColumn,String>();
		
		// Iterate over every known column
		Iterator<SpreadsheetColumn> headerIt = this.header.iterator();
		while (headerIt.hasNext()) {
			SpreadsheetColumn c = headerIt.next();
			boolean colHasValueInEolMap = false;
			
			// Iterate over every pair in the EolMap to see of this column has been assigned a value
			for (String key : eolMap.keySet()) {
				SpreadsheetColumn colInEolMap = this.getColumn(key);
				if (c == colInEolMap) {
					colHasValueInEolMap = true;
					
					// The value to be written to the cell can be a String/Number or an EolObject
					Object keyValue = eolMap.get(key);
					
					// Check if the cell is a source of a reference
					List<SpreadsheetReference> refs = this.model.getReferencesBySource(this, c);
					if (!refs.isEmpty()) {
						// Prepare a collection of all rows specified as arguments
						ArrayList<Object> rows = new ArrayList<Object>();
						if (keyValue instanceof SpreadsheetRow) {
							rows.add(keyValue);
						} else if (keyValue instanceof Collection<?>) {
							for (Object val : (Collection<Object>) keyValue) {
								if (val instanceof SpreadsheetRow) {
									rows.add(val);
								}
							}
						}
						
						if (rows.isEmpty()) {
							throw new IllegalArgumentException("A row or a collection of rows must be provided when " +
															   "setting the value of the referencing cell '" + c.getIdentifier() + "'. " +
															   "Received: '" + keyValue + "'.");
						}
						
						// Iterate over the rows and prepare a set of unique values to write to the cell
						HashSet<Object> valueSet = new HashSet<Object>();
						for (Object row : rows) {
							SpreadsheetRow r = (SpreadsheetRow) row;
							
							// Iterate over all references that possibly associate this cell with the row 
							// (don't know the target column)
							boolean rowInserted = false;
							for (SpreadsheetReference ref : refs) {
								if (ref.getTargetWorksheet() == r.getWorksheet()) {
									try {
										// Extract the value that is being set for this column, if any
										Object value = this.model.getPropertyGetter().invoke(row, ref.getTargetColumn().getIdentifier());
										if (value instanceof Collection<?>) {
											for (Object obj : (Collection<Object>) value) {
												valueSet.add(obj);
												if (!c.isMany()) break; // Insert the first value only
											}
										} else {
											valueSet.add(value);
										}
										rowInserted = true;
									} catch (EolRuntimeException e) {
										e.printStackTrace();
										return null;
									}
								} else {
									continue;
								}
							}
							
							if (rowInserted && !c.isMany()) break; // Only insert the first row
						}
						
						// Prepare the value to insert
						String valueToInsert = null;
						for (Object value : valueSet) {
							if (valueToInsert == null) {
								valueToInsert = value.toString();
							} else {
								valueToInsert += c.getDelimiter() + value.toString();
							}
						}
						
						valuesToInsert.put(c,valueToInsert);
					} else {
						// This is a plain text cell
						String valueToInsert = null;
						
						if (c.isMany() && this.dataTypeStrict) {
							// Ensure every value specified for the cell conforms to the data type of the column
							for (String val : keyValue.toString().split(c.getDelimiter())) {
								String castValue = SpreadsheetDataType.castColumnValue(c.getDataType(), val).toString();
								if (valueToInsert == null) {
									valueToInsert = castValue;
								} else {
									valueToInsert += c.getDelimiter() + castValue;
								}
							}
						} else if (this.dataTypeStrict) {
							// Ensure the value conforms to the data type of the column
							valueToInsert = SpreadsheetDataType.castColumnValue(c.getDataType(), keyValue.toString()).toString();
						} else {
							if (!keyValue.toString().isEmpty()) {
								// Insert the given value
								valueToInsert = keyValue.toString();
							} else {
								// Insert default cell value
								valueToInsert = SpreadsheetConstants.DEFAULT_DT_VALUE;
							}
						}
						
						valuesToInsert.put(c,valueToInsert);
					}

					break;
				}
			}
			
			if (!colHasValueInEolMap) {
				// Insert default value in the cell, even if it is referencing another cell
				String value = SpreadsheetConstants.DEFAULT_DT_VALUE;
				if (this.dataTypeStrict) {
					value = SpreadsheetDataType.getDefaultDTValue(c.getDataType());
				}
				valuesToInsert.put(c, value);
			}
		}
		
		return this.insertRow(valuesToInsert);
	}
	
	/*
	 * Inserts the given values in the corresponding columns.
	 * 
	 * @param values The map of worksheet's columns and values to insert.
	 * @return The newly created row.
	 */
	protected abstract SpreadsheetRow insertRow(HashMap<SpreadsheetColumn,String> values);
	
	/*
	 * Deletes the specified row from the worksheet.
	 * 
	 * @param row The row to delete.
	 */
	public void deleteRow(SpreadsheetRow row) throws EolRuntimeException {
		if (row.getWorksheet() == this) {
			ArrayList<SpreadsheetRow> rowsToDelete = new ArrayList<SpreadsheetRow>();
			
			// See if row contains one or more columns which are a target of some reference
			List<SpreadsheetReference> refs = this.model.getReferencesByTarget(row.getWorksheet());
			for (SpreadsheetReference ref : refs) {
				// Row is target of ref
				if (ref.isCascadingChanges()) {
					List<String> tCellValues = row.getAllVisibleCellValues(ref.getTargetColumn());
					
					// Iterate over every value of the target cell
					for (String targetCellValue : tCellValues) {
						if (ref.isMany()) {
							// Check if the target worksheet contains any other row with this value
							if (this.findRows(ref.getTargetColumn(), targetCellValue).size() <= 1) {
								continue; // Skip to the next value
							}
						}
						
						// Remove the value from the referencing row
						List<SpreadsheetRow> rows = ref.getSourceWorksheet().findRows(ref.getSourceColumn(), targetCellValue);
						if (ref.getSourceColumn().isMany()) {
							for (SpreadsheetRow sourceRow : rows) {
								// Get the current set of cell values
								List<String> oldSourceValues = sourceRow.getAllVisibleCellValues(ref.getSourceColumn());
								
								if (oldSourceValues.size() == 1) {
									// Delete the whole row, because the referencing cell will become empty
									rowsToDelete.add(sourceRow);
								} else {
									// Remove the value being deleted
									oldSourceValues.remove(targetCellValue);
									
									// Put the cell values back together
									List<SpreadsheetRow> targetRows = new ArrayList<SpreadsheetRow>();
									for (String val : oldSourceValues) {
										targetRows.addAll(ref.getTargetWorksheet().findRows(ref.getTargetColumn(), val));
									}
									
									if (targetRows.isEmpty()) {
										// Delete the row if no target values
										sourceRow.getWorksheet().deleteRow(sourceRow);
									} else {
										// Edit the value of the cell
										SpreadsheetPropertySetter setter = new SpreadsheetPropertySetter(this.model);
										setter.editReferencingCell(sourceRow, ref.getSourceColumn(), targetRows);
									}
								}
							}
						} else {
							rowsToDelete.addAll(rows);
						}
					}
				}
			}
			
			// Delete rows
			for (SpreadsheetRow r : rowsToDelete) {
				r.getWorksheet().model.deleteElement(r);
			}
			
			this.removeRow(row);
		}
	}
	
	/*
	 * Removes the specified row from the worksheet.
	 * 
	 * @param row The row to remove.
	 */
	public abstract void removeRow(SpreadsheetRow row) throws EolRuntimeException;
	
	/*
	 * Finds all rows in the worksheet whose cell, corresponding to the given column, matches the provided value
	 * including if the column may contain many values.
	 * 
	 * @param column The column to be searched.
	 * @param value The value to search for in the specified column.
	 * @return List of rows whose cells, corresponding to the column, contain the searched value.
	 */
	public abstract List<SpreadsheetRow> findRows(SpreadsheetColumn column, String value) throws EolRuntimeException;
	
	@Override
	public String toString() {
		String ret = this.name + " [";
		if (this.alias != null) {
			ret += "alias='" + this.alias + "', ";
		}
		ret += "dataTypeStrict='" + Boolean.toString(this.dataTypeStrict) + "' ";
		StringBuffer buf = new StringBuffer();
		for (SpreadsheetColumn c : this.header) {
			buf.append(c.toString());
		}
		ret += buf.toString();
		return ret + "]\n";
	}
}
