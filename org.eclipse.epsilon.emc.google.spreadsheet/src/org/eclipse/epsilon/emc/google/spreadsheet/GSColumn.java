/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *     Martins Francis - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.emc.google.spreadsheet;

public class GSColumn extends SpreadsheetColumn {
	
	private String googleColumnId;
	
	public GSColumn(GSWorksheet worksheet, int colIndex) {
		super(worksheet, colIndex);
		
		this.googleColumnId = null;
	}
	
	public String getGoogleColumnId() {
		return this.googleColumnId;
	}
	
	public void setGoogleColumnId(String id) {
		this.googleColumnId = id;
	}
	
	/*@Override
	public String toString() {
		String ret = super.toString();
		ret += " GSID='" + this.googleColumnId + "'; ";
		return ret;
	}*/
}
