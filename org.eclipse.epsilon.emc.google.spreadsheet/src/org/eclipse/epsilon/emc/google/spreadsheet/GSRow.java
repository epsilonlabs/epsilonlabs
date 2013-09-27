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

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

import com.google.gdata.data.spreadsheet.ListEntry;

public class GSRow extends SpreadsheetRow {

	protected ListEntry listEntry;
	
	public GSRow(GSWorksheet worksheet, ListEntry listEntry) {
		super(worksheet);

		this.listEntry = listEntry;
	}
	
	@Override
	public String getVisibleCellValue(SpreadsheetColumn column) {
		if (column instanceof GSColumn) {
			GSColumn c = (GSColumn) column;
			return this.listEntry.getCustomElements().getValue(c.getGoogleColumnId());
		} else {
			throw new RuntimeException("Received '" + column.getClass() + "' where a GSColumn object was expected.");
		}
	}

	@Override
	public void overwriteCellValue(SpreadsheetColumn column, String value) throws EolRuntimeException {
		if (column instanceof GSColumn) {
			try {
				if (value == null) {
					value = SpreadsheetDataType.getDefaultDTValue(column.getDataType());
				}
			    this.listEntry.getCustomElements().setValueLocal(((GSColumn) column).getGoogleColumnId(), value);
			    this.listEntry = this.listEntry.update();
			    ((GSWorksheet) column.getWorksheet()).getSelf();
			} catch(Exception e) {
				throw new EolRuntimeException(e.getMessage());
			}
		} else {
			throw new RuntimeException("Received '" + column.getClass() + "' where a GSColumn object was expected.");
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof SpreadsheetRow) {
			return this.listEntry.getId().equals(((GSRow) obj).listEntry.getId());
		} else {
			return false;
		}
	}
	
}
