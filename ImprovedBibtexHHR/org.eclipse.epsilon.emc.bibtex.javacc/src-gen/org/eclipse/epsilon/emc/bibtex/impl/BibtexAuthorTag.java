/**
 * Copyright (c) 2013 Horacio Hoyos.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Horacio Hoyos - initial implementation
 * 
 */
package org.eclipse.epsilon.emc.bibtex.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.epsilon.emc.bibtex.AuthorTag;
import org.eclipse.epsilon.emc.bibtex.BibtexPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Author Tag</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class BibtexAuthorTag extends BibtexTag implements AuthorTag {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BibtexAuthorTag() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BibtexPackage.Literals.AUTHOR_TAG;
	}

} //BibtexAuthorTag
