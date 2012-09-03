/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.epsilon.eol.dom;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Import</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.dom.Import#getImported <em>Imported</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.eol.dom.DomPackage#getImport()
 * @model
 * @generated
 */
public interface Import extends DomElement {
	/**
	 * Returns the value of the '<em><b>Imported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imported</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imported</em>' attribute.
	 * @see #setImported(String)
	 * @see org.eclipse.epsilon.eol.dom.DomPackage#getImport_Imported()
	 * @model
	 * @generated
	 */
	String getImported();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.dom.Import#getImported <em>Imported</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Imported</em>' attribute.
	 * @see #getImported()
	 * @generated
	 */
	void setImported(String value);

} // Import
