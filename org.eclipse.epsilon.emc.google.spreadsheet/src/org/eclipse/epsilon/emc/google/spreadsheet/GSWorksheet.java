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

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.epsilon.emc.google.spreadsheet.ISpreadsheetMetadata.SpreadsheetColumnMetadata;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;

import com.google.gdata.data.spreadsheet.CellEntry;
import com.google.gdata.data.spreadsheet.CellFeed;
import com.google.gdata.data.spreadsheet.ListEntry;
import com.google.gdata.data.spreadsheet.ListFeed;
import com.google.gdata.data.spreadsheet.WorksheetEntry;
import com.google.gdata.util.ServiceException;

public class GSWorksheet extends SpreadsheetWorksheet {

	public boolean hasGoogleIdsSet;
	
	protected WorksheetEntry worksheetEntry;
	protected ListFeed listFeed;
	
	// Indicates whether the visible worksheet has any column name; set to false when a column with a name is added
	private boolean headerEmpty;
	
	public GSWorksheet(GSModel model, WorksheetEntry worksheetEntry, boolean existsInSpreadsheet) throws Exception {
		super(model, worksheetEntry.getTitle().getPlainText(), existsInSpreadsheet);
		this.worksheetEntry = worksheetEntry;
		this.headerEmpty = true;
		this.hasGoogleIdsSet = false;
		
		if (this.existsInSpreadsheet) {
			this.initialiseListFeed();
			this.loadHeader();
		}
	}
	
	@Override
	protected void createInSpreadsheet() throws RuntimeException {
		try {
			// Create the worksheet
			URL worksheetFeedUrl = ((GSModel) this.model).spreadsheetEntry.getWorksheetFeedUrl(); 
			this.worksheetEntry = ((GSModel) this.model).spreadsheetService.insert(worksheetFeedUrl, this.worksheetEntry);
			
			this.existsInSpreadsheet = true;
			
			if (this.headerEmpty) {
				// Worksheet is completely empty - insert a value in the header row, otherwise list feed uses the header row
				CellFeed cf = this.fetchCellFeed(1, true);
				CellEntry cellEntry = new CellEntry (1, 1, "TEMP");
				cf.insert(cellEntry);
			} else {
				// Write any known column names
				CellFeed cf = this.fetchCellFeed(1, true);
				for (SpreadsheetColumn c : this.getHeader()) {
					if (c.getName() != null && !c.getName().isEmpty()) {
						CellEntry cellEntry = new CellEntry (1, c.getIndex(), c.getName());
						cf.insert(cellEntry);
					}
				}
			}
			
			// Update the worksheet entry to reflect the new state
			this.worksheetEntry = this.worksheetEntry.getSelf();
			
			// Set up the worksheet
			this.initialiseListFeed();
		} catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	private void initialiseListFeed() throws Exception {
		URL listFeedUrl = new URL(this.worksheetEntry.getListFeedUrl().toString());// + "?return-empty=true");
		this.listFeed = ((GSModel) this.model).spreadsheetService.getFeed(listFeedUrl, ListFeed.class);
	}
	
	@Override
	protected void loadHeader() throws EolModelLoadingException {
		try {
			// Ensure the header is loaded for a worksheet that exists in the spreadsheet
			if (!this.existsInSpreadsheet) {
				throw new Exception(this.nonexistentWorksheetMessage());
			}
			
			// First row is the header row
			CellFeed cellFeed = this.fetchCellFeed(1,true);
			if(cellFeed != null){
				// Determine the size of the header row
				int indexOfLast = 0;
				for (CellEntry cell : cellFeed.getEntries()) {
					if(cell.getCell().getValue() != null){
						indexOfLast = cell.getCell().getCol();
					}
				}
				// Get columns
				for (CellEntry entry : cellFeed.getEntries()) {
					if (entry.getCell().getCol() > indexOfLast) break;
					// Get column name
					String name = entry.getCell().getValue();
					if (name != null && !name.isEmpty()) {
						// Get column position
						int index = entry.getCell().getCol();
						// Add the column to the worksheet
						SpreadsheetColumnMetadata c = new SpreadsheetColumnMetadata();
						c.index = Integer.toString(index);
						c.name = name;
						this.addColumn(c);
					}
				}
			} else {
				throw new Exception("Google cell feed failed to load the header row.");
			}

		} catch (Exception e) {
			throw new EolModelLoadingException(e, this.model);
		}
	}
	
	/*
	 * Returns a cell feed of the row with the given index. If the flag is set to true, then
	 * the cell feed will also include empty cells.
	 */
	private CellFeed fetchCellFeed(int rowIndex, boolean returnEmpty) throws EolRuntimeException {
		try {
			URL cellFeedUrl = new URI(this.worksheetEntry.getCellFeedUrl().toString() +
	  				  				  "?min-row="+Integer.toString(rowIndex) + 
	  				  				  "&max-row="+Integer.toString(rowIndex) +
	  				  				  "&return-empty="+Boolean.toString(returnEmpty)).toURL();
			CellFeed cellFeed = ((GSModel) this.model).spreadsheetService.getFeed(cellFeedUrl, CellFeed.class);
			return (cellFeed.getEntries().size() == 0) ? null : cellFeed;
		} catch(Exception e){
			throw new EolRuntimeException(e.getMessage());
		}
	}
	
	/*
	 * Override the parent method to validate whether column names have been set such that it is
	 * possible to determine whether the header row is completely empty in the worksheet.
	 */
	@Override
	public SpreadsheetColumn addColumn(SpreadsheetColumnMetadata cObj) throws EolModelLoadingException {
		SpreadsheetColumn c = super.addColumn(cObj);
		if (c.getName() != null && !c.getName().isEmpty()) {
			this.headerEmpty = false;
		}
		return c;
	}
	
	@Override
	public SpreadsheetColumn createColumn(int colIndex) {
		return new GSColumn(this, colIndex);
	}
	
	@Override
	public List<SpreadsheetRow> getRows() throws EolRuntimeException {
		// Ensure the worksheet exists in the spreadsheet
		if (!this.existsInSpreadsheet) {
			throw new EolRuntimeException("Cannot retrieve rows: " + this.nonexistentWorksheetMessage());
		}
		
		// Ensure the worksheet knows its column ids
		if (!this.hasGoogleIdsSet) {
			this.getGoogleColumnIds();
		}
		
		// Get and return all of the rows
		List<SpreadsheetRow> rows = new ArrayList<SpreadsheetRow>();
		for (ListEntry r : this.listFeed.getEntries()) {
			rows.add(new GSRow(this, r));
		}
		
		return rows;
	}
	
	/*
	 * Loads the column ids from Google.
	 */
	protected void getGoogleColumnIds() throws EolModelLoadingException {
		try {
			System.out.print("Loading Google ids for '" + this.getName() + "'... ");
			
			// Ensure the worksheet exists in the spreadsheet
			if (!this.existsInSpreadsheet) {
				throw new RuntimeException(this.nonexistentWorksheetMessage());
			}
			
			// Reset the flag early to avoid cycles
			this.hasGoogleIdsSet = true;
			
			// Position of the last header column
			int maxColIndex = this.getHeader().last().getIndex();
			
			// Determine the first blank row
			int rowIndex = this.getRows().size() + 2;
			
			// If the worksheet dimensions are smaller than the first blank row, then expand the worksheet
			if (this.worksheetEntry.getRowCount() < rowIndex) {
				this.worksheetEntry.setRowCount(rowIndex);
				this.worksheetEntry = this.worksheetEntry.update();
			}
			
			// Fill the first spare row with temporary values
			URL cellFeedUrl = new URI(this.worksheetEntry.getCellFeedUrl().toString() +
	  				  				  "?min-row="+Integer.toString(rowIndex) + 
	  				  				  "&max-row="+Integer.toString(rowIndex) +
	  				  				  "&min-col=1" +
	  				  				  "&max-col=" + Integer.toString(maxColIndex) +
	  				  				  "&return-empty=true").toURL();
		    CellFeed cellFeed = ((GSModel) this.model).spreadsheetService.getFeed(cellFeedUrl, CellFeed.class);
		    for (CellEntry cell : cellFeed.getEntries()) {
		        cell.changeInputValueLocal("TEMP");
		        cell.update();
		    }
		    
		    GSRow row = null;
			
			// Get the row from the worksheet to populate the Google Unique Id set
			URL listFeedUrl = new URL(this.worksheetEntry.getListFeedUrl().toString() + 
									  "?start-index=" + Integer.toString(rowIndex - 1) + 
									  "&max-results=1");
			ListFeed lf = ((GSModel) model).spreadsheetService.getFeed(listFeedUrl, ListFeed.class);
			List<ListEntry> list = lf.getEntries();
			if (list.size() == 1) {
				ListEntry le = list.get(0);
				int colIndex = 1;
				// Iterate over all returned tags - Google preserves column ordering in the set
				Iterator<String> it = le.getCustomElements().getTags().iterator();
				while (it.hasNext()) {
					GSColumn c = (GSColumn) this.getColumn(colIndex);
					
					// If the column is known, then associate the id with it
					if (c != null) {
						c.setGoogleColumnId(it.next());
					} else {
						it.next();
					}
					
					// Stop once the final known column is reached
					if (colIndex == maxColIndex) break;
					
					colIndex++;
				}
				row = new GSRow(this, le);
			} else {
				throw new Exception("List feed failed to return the row of temporary values for learning the Unique Column Ids.");
			}
			
			// Delete the temporary row
			this.removeRow(row);
		} catch (Exception e) {
			throw new EolModelLoadingException(e, this.model);
		}
		System.out.println("<< done");
		System.out.println(this);
	}
	
	@Override
	protected SpreadsheetRow insertRow(HashMap<SpreadsheetColumn,String> values) {
		try {
			// Ensure the worksheet exists in the spreadsheet
			if (!this.existsInSpreadsheet) {
				throw new RuntimeException(this.nonexistentWorksheetMessage());
			}
			
			// Ensure the worksheet knows its column IDs
			if (!this.hasGoogleIdsSet) {
				this.getGoogleColumnIds();
			}
			
			// Create a Google representation of the new row
			ListEntry row = new ListEntry();
			for (SpreadsheetColumn sc : values.keySet()) {
				GSColumn c = (GSColumn) sc;
				row.getCustomElements().setValueLocal(c.getGoogleColumnId(), values.get(sc));
			}
			
			// Insert the row
			row = ((GSModel) this.model).spreadsheetService.insert(this.worksheetEntry.getListFeedUrl(), row);
			
			// Update the worksheet entry and list feed entry
			this.getSelf();
		    
		    return new GSRow(this,row);
		} catch(Exception e) {
			return null;
		}
	}
	
	/*
	 * Updates the local worksheet and list feed entries.
	 */
	protected void getSelf() throws Exception {
		this.worksheetEntry = this.worksheetEntry.getSelf();
		this.listFeed = this.listFeed.getSelf();
	}
	
	@Override
	public void removeRow(SpreadsheetRow row) throws EolRuntimeException {
		try {
			if (row != null) {
				((GSRow) row).listEntry.delete();
				// Refresh the local worksheet and list feed entries to reflect the change
				this.getSelf();
			}
		} catch (IOException e) {
			// Do nothing
		} catch (ServiceException e) {
			// Do nothing
		} catch (Exception e) {
			throw new EolRuntimeException(e.getMessage());
		}
	}

	@Override
	public List<SpreadsheetRow> findRows(SpreadsheetColumn column, String value) throws EolRuntimeException {
		List<SpreadsheetRow> rows = new ArrayList<SpreadsheetRow>();
		
		// Ensure the worksheet exists in the spreadsheet
		if (!this.existsInSpreadsheet) {
			//throw new EolRuntimeException(this.nonexistentWorksheetMessage());
			return rows;
		}
		
		// Ensure the worksheet knows its column ids
		if (!this.hasGoogleIdsSet) {
			this.getGoogleColumnIds();
		}
		
		if (!(column instanceof GSColumn)) {
			throw new RuntimeException("The given column must be of type GSColumn.");
		}
		
		GSColumn c = (GSColumn) column;
		if (c.isMany()) {
			// Get all rows contained by the worksheet to check every cell manually
			for (SpreadsheetRow r : this.getRows()) {
				// Get all visible values
				List<String> cellValues = r.getAllVisibleCellValues(c);
				// Mark row to be returned if the search value is in the cell
				if (cellValues.contains(value)) {
					rows.add(r);
				}
			}
		} else {
			try {
				// Use Google's structured query feature to search for the value
				URL listFeedUrl = new URI(this.worksheetEntry.getListFeedUrl().toString() 
										  + "?sq=" + c.getGoogleColumnId() + "==" 
										  + URLEncoder.encode("\""+value+"\"","UTF-8")).toURL();
				ListFeed lf = ((GSModel) this.model).spreadsheetService.getFeed(listFeedUrl, ListFeed.class);
				for (ListEntry r : lf.getEntries()) {
					rows.add(new GSRow(this, r));
				}
			} catch(Exception e) {
				throw new EolRuntimeException(e.getMessage());
			}
		}
		return rows;
	}
	
	private String nonexistentWorksheetMessage() {
		return "Worksheet '" + this.getName() + "' does not exist in spreadsheet '" + this.model.spreadsheetName + "'.";
	}
	
	public void deleteWorksheet() throws IOException, ServiceException {
		this.worksheetEntry.delete();
	}
}
