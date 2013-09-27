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
import java.util.List;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.java.JavaPropertyGetter;

public class SpreadsheetPropertyGetter extends JavaPropertyGetter {

	protected SpreadsheetModel model;
	
	public SpreadsheetPropertyGetter(SpreadsheetModel model) {
		this.model = model;
	}
	
	@Override
	public Object invoke(Object rowObj, String colIdentifier) throws EolRuntimeException {
		if (rowObj instanceof Collection<?>) {
			Collection<?> collection = (Collection<?>) rowObj;
			List<Object> retList = new ArrayList<Object>();
			
			// Query every row of the collection
			for (Object obj : collection) {
				Object result = this.invoke(obj,colIdentifier);
				if (obj instanceof SpreadsheetRow) {
					retList.add(result);
				}
			}
			
			return retList;
		} else if (rowObj instanceof SpreadsheetRow) {
			SpreadsheetRow row = (SpreadsheetRow) rowObj;
			
			// Ensure that the row belongs to this spreadsheet
			if (this.model.getWorksheetByType(row.getWorksheet().getName()) == null) {
				throw new EolRuntimeException("Row '" + row + "'is contained by worksheet '" + row.getWorksheet() + "' " +
											  "that is NOT part of spreadsheet '" + row.getWorksheet().getModel().getName() + "'.");
			}
			
			// Check if the visible cell value is being accessed directly
			boolean readVisibleValue = false;
			if (colIdentifier.startsWith(SpreadsheetConstants.PREFIX_VAL)) {
				readVisibleValue = true;
				colIdentifier = colIdentifier.substring(SpreadsheetConstants.PREFIX_VAL.length());
			}
			
			// Ensure that the column is valid and part of the worksheet
			SpreadsheetColumn c = row.getWorksheet().getColumn(colIdentifier);
			if (c != null) {
				// Get the values contained by the cell
				List<Object> cellValues = new ArrayList<Object>(row.getAllVisibleCellValues(c));
				List<Object> returnObjects = null;
				
				// Check if the row's worksheet and column are a source of a reference
				List<SpreadsheetReference> refs = this.model.getReferencesBySource(row.getWorksheet(), c);
				if (!refs.isEmpty() && !readVisibleValue) {
					// Returning a list of referenced rows
					List<Object> rowsToReturn = new ArrayList<Object>();
					
					if (!cellValues.isEmpty()) {
						// Iterate over all rows that each source value references
						for (SpreadsheetReference ref : refs) {
							// Referencing cell may contain many values
							for (Object valueObj : cellValues) {
								String value = valueObj.toString();
								
								// Find all rows being referenced
								for (SpreadsheetRow r : ref.getTargetWorksheet().findRows(ref.getTargetColumn(), value)) {
									rowsToReturn.add(r);
									// If reference is one-to-one, return at most one referenced row for each value
									if (!ref.isMany()) break;
								}
							}
						}
					}
					
					returnObjects = rowsToReturn;
				} else {
					// Column is a plain textual value
					returnObjects = cellValues;
				}
				
				// Determine the output
				if (returnObjects != null && !returnObjects.isEmpty()) {
					if (c.isMany()) {
						return returnObjects;
					} else {
						return returnObjects.get(0);
					}
				} else {
					if (c.isMany()) {
						return new ArrayList<Object>();
					} else {
						return null;
					}
				}
			} else {
				throw new EolRuntimeException("Property '" + colIdentifier + "' not found in object '" + rowObj.toString() + "'");
			}
		}

		return super.invoke(rowObj, colIdentifier);
	}
	
}
