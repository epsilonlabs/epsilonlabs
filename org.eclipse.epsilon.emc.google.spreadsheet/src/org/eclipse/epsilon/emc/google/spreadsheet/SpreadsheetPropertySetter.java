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
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.java.JavaPropertySetter;

public class SpreadsheetPropertySetter extends JavaPropertySetter {
	
	protected SpreadsheetModel model;
	
	public SpreadsheetPropertySetter(SpreadsheetModel model) {
		this.model = model;
	}
	
	@Override
	public void invoke(Object value) throws EolRuntimeException {
		if (object instanceof Collection<?>) {
			Collection<?> c = (Collection<?>) object;
			// Edit every row in the collection
			for (Object obj : c) {
				SpreadsheetPropertySetter setter = new SpreadsheetPropertySetter(this.model);
				setter.property = this.property;
				setter.object = obj;
				setter.invoke(value);
			}
		} else if (object instanceof SpreadsheetRow) {
			SpreadsheetRow row = (SpreadsheetRow) object;
			SpreadsheetColumn column = row.getWorksheet().getColumn(property);
			
			if (column != null) {
				List<SpreadsheetReference> sourceRefs = row.getWorksheet().getModel().getReferencesBySource(row.getWorksheet(), column);
				List<SpreadsheetReference> targetRefs = row.getWorksheet().getModel().getReferencesByTarget(row.getWorksheet(), column);
				
				if (!sourceRefs.isEmpty()) {
					// This cell is a source of a reference, and may also be a target of a reference
					this.editReferencingCell(row, column, value);
				} else if (!targetRefs.isEmpty()) {
					// This cell is a target of a reference
					this.editReferencedCell(row, column, value);
				} else {
					// Setting a textual value
					ArrayList<String> valuesToWrite = null;
					
					// Extract the values to write
					if (column.isMany()) {
						valuesToWrite = new ArrayList<String>();
						for (String s : value.toString().split(column.getDelimiter())) {
							valuesToWrite.add(s);
						}
					} else {
						valuesToWrite = new ArrayList<String>(Arrays.asList(value.toString()));
					}
					
					row.writeVisibleCellValues(column, valuesToWrite);
				}
			} else {
				throw new EolRuntimeException("Column '" + property + "' could not be found.");
			}
		} else {
			throw new EolRuntimeException("Object '" + object + "' must be either a row or a collection of rows.");
		}
	}
	
	/*
	 * Entry point to the class - object and property fields are not public.
	 */
	public void editCell(SpreadsheetRow row, SpreadsheetColumn column, Object value) throws EolRuntimeException {
		this.object = row;
		this.property = column.getIdentifier();
		this.invoke(value);
	}
	
	/*
	 * Sets the value of the given cell (row and column) to the given value. This method must only be called on cells
	 * that are referencing other cells -- but they may be referenced by other cells as well.
	 */
	@SuppressWarnings("unchecked")
	public void editReferencingCell(SpreadsheetRow row, SpreadsheetColumn column, Object value) throws EolRuntimeException {
		List<SpreadsheetReference> refs = row.getWorksheet().getModel().getReferencesBySource(row.getWorksheet(), column);
		if (!refs.isEmpty()) {
			if (value != null && !value.toString().isEmpty()) {
				// Extract the provided referenced rows from 'value'
				ArrayList<SpreadsheetRow> referencedRows = new ArrayList<SpreadsheetRow>();
				if (value instanceof SpreadsheetRow) {
					referencedRows.add((SpreadsheetRow) value);
				} else if (value instanceof Collection<?>) {
					for (Object val : (Collection<Object>) value) {
						if (val instanceof SpreadsheetRow) {
							referencedRows.add((SpreadsheetRow) val);
						}
					}
				}
				
				// Only valid rows can be set as the targets of a referencing row
				if (referencedRows.isEmpty()) {
					throw new IllegalArgumentException("To edit a referencing cell that may contain many values, a valid SpreadsheetRow " +
												  	   "or a collection of SpreadsheetRows must be provided.");
				}
				
				HashSet<String> valuesToWrite = new HashSet<String>();
				
				// Iterate all given referenced rows
				boolean oneRowHandled = false;
				for (SpreadsheetRow referencedRow : referencedRows) {
					for (SpreadsheetReference ref : refs) {
						if (ref.getTargetWorksheet() == referencedRow.getWorksheet()) {
							// Get the value(s) from the referenced cell
							valuesToWrite.addAll(referencedRow.getAllVisibleCellValues(ref.getTargetColumn()));
							if (!column.isMany()) {
								oneRowHandled = true;
								break;
							}
						}
					}
					if (oneRowHandled) break;
				}
				
				if (!column.isMany()) {
					// Ensure that only one values is written to this cell
					if (valuesToWrite.size() > 1) {
						Iterator<String> it = valuesToWrite.iterator();
						String first_value = it.next();
						valuesToWrite = new HashSet<String>();
						valuesToWrite.add(first_value);
					}
				}
				
				// Determine if this cell is also a target of a reference
				List<SpreadsheetReference> targetRefs = row.getWorksheet().getModel().getReferencesByTarget(row.getWorksheet(), column);
				if (!targetRefs.isEmpty()) {
					this.editReferencedCell(row, column, new ArrayList<String>(valuesToWrite));
				} else {
					row.writeVisibleCellValues(column, new ArrayList<String>(valuesToWrite));
				}
			} else {
				throw new IllegalArgumentException("The value to be written to a referencing cell cannot be empty.");
			}
		} else {
			throw new EolRuntimeException("The method 'editReferencingCell' cannot be called on a cell that is not referencing.");
		}
	}
	
	/*
	 * Method for editing a cell (row and column) that is being referenced by other cells. If this cell is referencing
	 * any other cells, then this method should not be used (it will be handled by editReferencingCell).
	 */ 
	public void editReferencedCell(SpreadsheetRow row, SpreadsheetColumn column, Object value) throws EolRuntimeException {
		// Check if a TARGET of a reference is being edited, and the cell is not referencing anything else
		List<SpreadsheetReference> targetRefs = row.getWorksheet().getModel().getReferencesByTarget(row.getWorksheet(), column);
		List<SpreadsheetReference> sourceRefs = row.getWorksheet().getModel().getReferencesBySource(row.getWorksheet(), column);
		if (!targetRefs.isEmpty() && sourceRefs.isEmpty()) {
			if (value != null && !value.toString().isEmpty()) {
				// Get current cell values
				List<String> oldValues = row.getAllVisibleCellValues(column);
				
				// Extract values from 'value' to write to the cell
				List<String> newValues = new ArrayList<String>();
				if (column.isMany()) {
					for (String val : value.toString().split(column.getDelimiter())) {
						newValues.add(val);
					}
				} else {
					newValues.add(value.toString());
				}
				
				// Write new values
				row.writeVisibleCellValues(column, newValues);
				
				// Create a set of removed values
				HashSet<String> removedValues = new HashSet<String>();
				for (String oldValue : oldValues) {
					if (!newValues.contains(oldValue)) {
						removedValues.add(oldValue);
					}
				}
				
				// Iterate over all references
				for (SpreadsheetReference ref : targetRefs) {
					if (ref.isCascadingChanges()) {
						for (String removedValue : removedValues) {
							if (ref.isMany()) {
								if (row.getWorksheet().findRows(column, removedValue).size() > 1) {
									continue;
								}
							}
							
							// Find all rows of the source reference worksheet with any of the removed values
							ArrayList<SpreadsheetRow> referencingRows = new ArrayList<SpreadsheetRow>();
							referencingRows.addAll(ref.getSourceWorksheet().findRows(ref.getSourceColumn(), removedValue));
							
							// Iterate over the referencing rows
							for (SpreadsheetRow referencingRow : referencingRows) {
								// Remove the removed values
								HashSet<String> currentCellValues = new HashSet<String>(referencingRow.getAllVisibleCellValues(ref.getSourceColumn()));
								currentCellValues.removeAll(removedValues);
								
								// Add the new state of the cell to the referencing row
								currentCellValues.addAll(newValues);
								
								// Get the new referenced objects
								List<SpreadsheetRow> targetRows = new ArrayList<SpreadsheetRow>();
								for (String val : currentCellValues) {
									targetRows.addAll(ref.getTargetWorksheet().findRows(ref.getTargetColumn(), val));
								}
								
								// Edit the referencing row
								SpreadsheetPropertySetter setter = new SpreadsheetPropertySetter(this.model);
								setter.editCell(referencingRow, ref.getSourceColumn(), targetRows);
							}
						}
					}
				}
			} else {
				throw new IllegalArgumentException("The value to be written to a referenced cell cannot be empty.");
			}
		} else {
			throw new EolRuntimeException("The method 'editReferencedCell' cannot be called on a cell that is both being referenced and referencing.");
		}
	}
}
