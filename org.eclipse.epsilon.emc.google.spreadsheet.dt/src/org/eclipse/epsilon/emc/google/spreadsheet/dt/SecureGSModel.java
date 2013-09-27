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
package org.eclipse.epsilon.emc.google.spreadsheet.dt;

import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.google.spreadsheet.GSModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.equinox.security.storage.ISecurePreferences;
import org.eclipse.equinox.security.storage.SecurePreferencesFactory;
import org.eclipse.equinox.security.storage.StorageException;

public class SecureGSModel extends GSModel {
	
	@Override
	public void load(StringProperties properties, String basePath) throws EolModelLoadingException {
		try {
			// Extract password from vault
			String password = this.loadPassword(properties);
			
			if (password == null) {
				throw new Exception("Google account password for account username '" + 
									properties.getProperty(GSModel.USERNAME) + "' not found.");
			}
			
			// Provide the password as an argument to the GS driver
			properties.put(GSModel.PASSWORD, password);

			// Call the GS driver
			super.load(properties, basePath);
		} catch(Exception e) {
			throw new EolModelLoadingException(e, this);
		}
	}
	
	/*
	 * Returns the password stored by the GUI.
	 */
	public String loadPassword(StringProperties properties) throws StorageException {
		ISecurePreferences preferences = SecurePreferencesFactory.getDefault();
		if (preferences != null) {
			// Password is stored in the vault associated with the Google username
			String username = properties.getProperty(GSModel.USERNAME);
			if (preferences.nodeExists(username)) {
				ISecurePreferences node = preferences.node(username);
				return node.get(GSModel.PASSWORD, null);
			} else {
				throw new RuntimeException("Equinox Security could not find Google account password for username '" + username + "'.");
			}
		} else {
			throw new RuntimeException("Equinox Security was unable to create secure preferences using default location.");
		}
	}

}
