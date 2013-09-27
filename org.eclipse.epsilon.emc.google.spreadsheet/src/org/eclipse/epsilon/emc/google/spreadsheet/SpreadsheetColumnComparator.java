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

import java.util.Comparator;

public class SpreadsheetColumnComparator implements Comparator<SpreadsheetColumn> {

	/**
	 * SpreadsheetColumn objects are ordered by their indices in ascending order.
	 */
	@Override
	public int compare(SpreadsheetColumn c1, SpreadsheetColumn c2) {
		if (c1.getIndex() > c2.getIndex()) {
			return 1;
		} else if (c1.getIndex() < c2.getIndex()) {
			return -1;
		} else {
			return 0;
		}
	}

}
