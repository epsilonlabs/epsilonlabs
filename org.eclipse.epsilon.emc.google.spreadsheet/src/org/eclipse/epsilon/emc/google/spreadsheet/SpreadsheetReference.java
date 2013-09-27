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

import org.eclipse.epsilon.emc.google.spreadsheet.ISpreadsheetMetadata.SpreadsheetReferenceMetadata;

public class SpreadsheetReference {

	protected SpreadsheetModel model;
	protected SpreadsheetWorksheet sourceWorksheet;
	protected SpreadsheetWorksheet targetWorksheet;
	protected SpreadsheetColumn sourceColumn;
	protected SpreadsheetColumn targetColumn;
	protected boolean many;
	protected boolean cascadeChanges;
	
	/*
	 * Constructs an object representing a reference between two worksheet objects and two column objects,
	 * as specified in the provided meta-data object.
	 * 
	 * @throws IllegalArgumentException if the meta-data contains unidentifiable worksheets or columns, if
	 * a reference is specified between two equal worksheets and columns, or if the reference column data types
	 * are in conflict.
	 */
	public SpreadsheetReference(SpreadsheetModel model, SpreadsheetReferenceMetadata reference) throws IllegalArgumentException {
		this.model = model;
		
		// Set the reference relation
		if (reference.many != null && !reference.many.isEmpty()) {
			this.many = Boolean.parseBoolean(reference.many);
		} else {
			this.many = SpreadsheetConstants.DEFAULT_REF_MANY; 
		}
		
		// Set the "cascade changes" flag
		if (reference.cascadeChanges != null && !reference.cascadeChanges.isEmpty()) {
			this.cascadeChanges = Boolean.parseBoolean(reference.cascadeChanges);
		} else {
			this.cascadeChanges = SpreadsheetConstants.DEFAULT_REF_CASCADE;   
		}
		
		if (reference.source == null || reference.target == null) {
			throw new IllegalArgumentException("Reference source or target have not been defined.");
		}
		
		// Set the source of the reference
		ExtractedReference sRef = this.extractReference(reference.source);
		this.sourceWorksheet = sRef.worksheet;
		this.sourceColumn = sRef.column;
		
		// Set the target of the reference
		ExtractedReference tRef = this.extractReference(reference.target);
		this.targetWorksheet = tRef.worksheet;
		this.targetColumn = tRef.column;
		
		// Check that reference worksheets are defined
		if (this.sourceWorksheet == null || this.targetWorksheet == null) {
			throw new IllegalArgumentException("Reference source or target worksheet could not be found.");
		}
		
		// Check that reference columns are defined
		if (this.sourceColumn == null || this.targetColumn == null) {
			throw new IllegalArgumentException("Reference source or target column could not be found.");
		}
		
		// Check that reference is not defined between two equal worksheets and columns
		if (this.sourceWorksheet == this.targetWorksheet && this.sourceColumn == this.targetColumn) {
			throw new IllegalArgumentException("Illegal reference construct: - source and target of the reference are equal." +
											   "Source: '" + reference.source + "', " +
											   "Target: '" + reference.target + "'");
		}
		
		// Ensure that reference column data types do not clash
		if (this.sourceColumn.getDataType() != this.targetColumn.getDataType()) {
			throw new IllegalArgumentException("Reference column data types do not match. " +
								"Source data type: '" + this.sourceColumn.getDataType() + "', " +
								"Target data type: '" + this.targetColumn.getDataType() + "'");
		}
	}
	
	/* Finds the worksheet and column corresponding to the plain text reference provided as an argument */
	protected ExtractedReference extractReference(String plainRef) {
		ExtractedReference exRef = new ExtractedReference();
		String[] refArr = plainRef.split(SpreadsheetConstants.ORM_REFERENCE_SEP);
		if (refArr.length == 2) {
			SpreadsheetWorksheet worksheet = this.model.getWorksheetByType(refArr[0]);
			exRef.worksheet = worksheet;
			if (worksheet != null) {
				exRef.column = worksheet.getColumn(refArr[1]);
			}
		}
		return exRef;
	}
	
	/*
	 * Returns the model the reference belongs to.
	 */
	public SpreadsheetModel getModel() {
		return this.model;
	}
	
	/*
	 * Returns the referencing worksheet.
	 */
	public SpreadsheetWorksheet getSourceWorksheet() {
		return this.sourceWorksheet;
	}
	
	/*
	 * Returns the referencing column.
	 */
	public SpreadsheetColumn getSourceColumn() {
		return this.sourceColumn;
	}
	
	/*
	 * Returns the referenced worksheet.
	 */
	public SpreadsheetWorksheet getTargetWorksheet() {
		return this.targetWorksheet;
	}
	
	/*
	 * Returns the referenced column.
	 */
	public SpreadsheetColumn getTargetColumn() {
		return this.targetColumn;
	}
	
	/*
	 * Returns true if reference is one-to-many or false if one-to-one.
	 */
	public boolean isMany() {
		return this.many;
	}
	
	/*
	 * Returns whether the reference target must cascade changes.
	 */
	public boolean isCascadingChanges() {
		return this.cascadeChanges;
	}
	
	/*
	 * Local representation of a reference end.
	 */
	protected static class ExtractedReference {
		SpreadsheetWorksheet worksheet = null;
		SpreadsheetColumn column = null;
	}
	
	@Override
	public String toString(){
		return "source='" + this.sourceWorksheet.getName() + SpreadsheetConstants.ORM_REFERENCE_SEP + 
				this.sourceColumn.getIdentifier() + "', " +
				"target='" + this.targetWorksheet.getName() + SpreadsheetConstants.ORM_REFERENCE_SEP + 
				this.targetColumn.getIdentifier() + "', " +
				"many='" + Boolean.toString(this.many) + "', " +
				"cascadeChanges='" + Boolean.toString(this.cascadeChanges) + "';";
	}
}
