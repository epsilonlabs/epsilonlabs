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
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.IPropertySetter;
import org.eclipse.epsilon.eol.models.ISearchableModel;
import org.eclipse.epsilon.eol.models.Model;

public abstract class SpreadsheetModel extends Model implements ISearchableModel {
	
	// Identifiers used for receiving parameters from Epsilon Development Tools
	public static final String SPREADSHEET_NAME = "SpreadsheetName";
		
	private ArrayList<SpreadsheetWorksheet> worksheets;
	private ArrayList<SpreadsheetReference> references;
	
	protected String spreadsheetName;
	protected ISpreadsheetMetadata metadata;
	
	public SpreadsheetModel() {
		super();
		
		this.worksheets = new ArrayList<SpreadsheetWorksheet>();
		this.references = new ArrayList<SpreadsheetReference>();
		this.spreadsheetName = null;
		this.metadata = null;
	}
	
	/*
	 * Returns all local representations of worksheets.
	 */
	public ArrayList<SpreadsheetWorksheet> getWorksheets() {
		return this.worksheets;
	}
	
	/*
	 * Adds the SpreadsheetWorksheet to the local collection of worksheet objects.
	 */
	public void addWorksheet(SpreadsheetWorksheet worksheet) {
		// Ignore worksheets that start with the predefined characters
    	String name = worksheet.getName();
    	if (name.trim().startsWith(SpreadsheetConstants.WSH_IGNORE_CHARS)) {
    		System.out.println("\t(!) Ignoring worksheet '" + name + "'");
    	} else {
    		this.worksheets.add(worksheet);
    	}
	}
	
	/*
	 * Returns all local representations of references.
	 */
	public ArrayList<SpreadsheetReference> getReferences() {
		return this.references;
	}
	
	/*
	 * Adds the SpreadsheetReference to the local collection of reference objects.
	 */
	public void addReference(SpreadsheetReference reference) {
		this.references.add(reference);
	}
	
	/*
	 * Returns the name of the spreadsheet.
	 */
	public String getSpreadsheetName() {
		return this.spreadsheetName;
	}
	
	/*
	 * Sets the name of the spreadsheet.
	 */
	public void setSpreadsheetName(String name) throws IllegalArgumentException {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Spreadsheet name must be set.");
		}
        this.spreadsheetName = name;
	}
	
	@Override
	public void load(StringProperties properties, String basePath) throws EolModelLoadingException {
		// This method is called when the model is created from the Epsilon Development Tools
		super.load(properties, basePath);
		
		this.setSpreadsheetName(properties.getProperty(SpreadsheetModel.SPREADSHEET_NAME));
	}
	
	@Override
	public Object getEnumerationValue(String enumeration, String label) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public Collection<SpreadsheetRow> allContents() {
		// Returns every row of every worksheet
		List<SpreadsheetRow> rows = new ArrayList<SpreadsheetRow>();
		for (SpreadsheetWorksheet worksheet : this.worksheets) {
			try {
				rows.addAll(worksheet.getRows());
			} catch(EolRuntimeException e) {
				e.printStackTrace();
				return null;
			}
		}
		return rows;
	}
	
	@Override
	public Collection<SpreadsheetRow> getAllOfType(String type) throws EolModelElementTypeNotFoundException {
		// Returns every row of the given worksheet
		try {
			SpreadsheetWorksheet ws = this.getWorksheetByType(type);
			return (ws != null) ? ws.getRows() : new ArrayList<SpreadsheetRow>();
		} catch (EolRuntimeException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Collection<SpreadsheetRow> getAllOfKind(String type) throws EolModelElementTypeNotFoundException {
		return this.getAllOfType(type);
	}

	@Override
	public Object getTypeOf(Object instance) {
		// Returns the worksheet that the row belongs to
		if (instance instanceof SpreadsheetRow) { 
			return ((SpreadsheetRow) instance).getWorksheet();
		}
		return null;
	}
	
	@Override
	public String getTypeNameOf(Object instance) {
		// Returns the name of the worksheet that the row belongs to
		if (instance instanceof SpreadsheetRow) {
			Object obj = this.getTypeOf(instance);
			if (obj != null) {
				return ((SpreadsheetWorksheet) obj).getName();
			}
		}
		return null;
	}
	
	@Override
	public Object createInstance(String type) throws EolModelElementTypeNotFoundException,
													 EolNotInstantiableModelElementTypeException {
		// Insert an empty row in the given worksheet, and return the SpreadsheetRow object
		return createInstance(type, Collections.emptyList());
	}
	
	@Override
	public Object createInstance(String type, Collection<Object> parameters) throws EolModelElementTypeNotFoundException {
		// Insert a new row in the worksheet where every column has a value given in the parameters collection
		SpreadsheetWorksheet ws = this.getWorksheetByType(type);
		if (ws != null) {
			if (!ws.existsInSpreadsheet) {
				ws.createInSpreadsheet();
			}
			return ws.addRow(parameters);
		} else {
			throw new EolModelElementTypeNotFoundException(type, this.name);
		}
	}
	
	@Override
	public Object getElementById(String id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getElementId(Object instance) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setElementId(Object instance, String newId) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void deleteElement(Object instance) throws EolRuntimeException {
		// Deletes the row from the worksheet it belongs to
		if (instance instanceof SpreadsheetRow) {
			SpreadsheetRow row = (SpreadsheetRow) instance;
			
			if (!row.getWorksheet().existsInSpreadsheet) {
				throw new EolRuntimeException("Cannot delete '" + row + "' because worksheet " + row.getWorksheet().getName() + " " +
											  "does not exist in spreadsheet '" + this.spreadsheetName + "'.");
			}
			
			SpreadsheetWorksheet worksheet = this.getWorksheetByType(row.getWorksheet().getName()); 
			
			if (worksheet != null) {
				worksheet.deleteRow(row);
			}
		}
	}
	
	@Override
	public boolean owns(Object instance) {
		if (instance instanceof SpreadsheetRow && ((SpreadsheetRow) instance).getWorksheet().getModel() == this) {
			return true;
		} else if (instance instanceof SpreadsheetWorksheet && ((SpreadsheetWorksheet) instance).getModel() == this) {
			return true;
		} else if (instance instanceof SpreadsheetModel && ((SpreadsheetModel) instance) == this) {
			return true;
		} else if (instance instanceof Collection<?>) {
			Collection<?> col = (Collection<?>)instance;
			Iterator<?> iCol = col.iterator();
			while (iCol.hasNext()) {
				Object obj = iCol.next();
				if (!(obj instanceof SpreadsheetRow)) return false;
			}
			return true;
		} else if (instance instanceof SpreadsheetColumn && ((SpreadsheetColumn) instance).getWorksheet().getModel() == this) {
			return true;
		}
		return false;
	}
	
	@Override
	@Deprecated
	public boolean isModelElement(Object instance) {
		// Returns true if row belongs to a worksheet that belongs to this spreadsheet
		return owns(instance);
	}
	
	@Override
	public boolean hasType(String type) {
		// Returns true if worksheet is part of this spreadsheet
		return this.getWorksheetByType(type) != null;
	}

	@Override
	public boolean isInstantiable(String type) {
		return hasType(type);
	}

	@Override
	public boolean store(String location) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean store() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public IPropertyGetter getPropertyGetter() {
		return new SpreadsheetPropertyGetter(this);
	}
	
	@Override
	public IPropertySetter getPropertySetter() {
		return new SpreadsheetPropertySetter(this);
	}
	
	/*
	 * Returns SpreadsheetWorksheet with the matching name. If no name is matched then returns 
	 * the first SpreadsheetWorksheet with the matching alias. If neither is matched then returns null.
	 */
	protected SpreadsheetWorksheet getWorksheetByType(String type) {
		if (type != null){
			for (SpreadsheetWorksheet sw : this.worksheets) {
				if (sw.getName().equals(type)) {
					return sw;
				}
			}
			for (SpreadsheetWorksheet sw : this.worksheets) {
				if (sw.getAlias() != null && sw.getAlias().equals(type)) {
					return sw;
				}
			}
		}
		return null;
	}
	
	/*
	 * Finds the reference defined between the given worksheets and columns. If none exists then
	 * returns null.
	 */
	protected SpreadsheetReference getReference(SpreadsheetWorksheet sourceWorksheet, SpreadsheetColumn sourceColumn, 
												SpreadsheetWorksheet targetWorksheet, SpreadsheetColumn targetColumn) {
		for (SpreadsheetReference ref : this.references) {
			if (ref.getSourceWorksheet() == sourceWorksheet && ref.getSourceColumn() == sourceColumn &&
				ref.getTargetWorksheet() == targetWorksheet && ref.getTargetColumn() == targetColumn) {
				return ref;
			}
		}
		return null;
	}
	
	/*
	 * Finds all references whose referencing worksheet matches 'worksheet'.
	 */
	protected List<SpreadsheetReference> getReferencesBySource(SpreadsheetWorksheet worksheet) {
		List<SpreadsheetReference> list = new ArrayList<SpreadsheetReference>();
		for (SpreadsheetReference ref : this.references) {
			if (ref.getSourceWorksheet() == worksheet) {
				list.add(ref);
			}
		}
		return list;
	}
	
	/*
	 * Finds all references whose referencing worksheet matches 'worksheet', and referencing column
	 * matches 'column'.
	 */
	protected List<SpreadsheetReference> getReferencesBySource(SpreadsheetWorksheet worksheet, SpreadsheetColumn column) {
		List<SpreadsheetReference> list = new ArrayList<SpreadsheetReference>();
		for (SpreadsheetReference ref : this.getReferencesBySource(worksheet)) {
			if (ref.getSourceColumn() == column) {
				list.add(ref);
			}
		}
		return list;
	}
	
	/*
	 * Finds all references whose referenced worksheet matches 'worksheet'.
	 */
	protected List<SpreadsheetReference> getReferencesByTarget(SpreadsheetWorksheet worksheet) {
		List<SpreadsheetReference> list = new ArrayList<SpreadsheetReference>();
		for (SpreadsheetReference ref : this.references) {
			if (ref.getTargetWorksheet() == worksheet) {
				list.add(ref);
			}
		}
		return list;
	}
	
	/*
	 * Finds all references whose referenced worksheet matches 'worksheet', and referenced column
	 * matches 'column'.
	 */
	protected List<SpreadsheetReference> getReferencesByTarget(SpreadsheetWorksheet worksheet, SpreadsheetColumn column) {
		List<SpreadsheetReference> list = new ArrayList<SpreadsheetReference>();
		for (SpreadsheetReference ref : this.getReferencesByTarget(worksheet)) {
			if (ref.getTargetColumn() == column) {
				list.add(ref);
			}
		}
		return list;
	}
	
}
