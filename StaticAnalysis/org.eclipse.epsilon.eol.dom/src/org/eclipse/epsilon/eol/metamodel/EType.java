/**
 */
package org.eclipse.epsilon.eol.metamodel;

import org.eclipse.emf.ecore.EClassifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EType</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.EType#getEcoreType <em>Ecore Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.eol.eol.EolPackage#getEType()
 * @model
 * @generated
 */
public interface EType extends Type {
	/**
	 * Returns the value of the '<em><b>Ecore Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ecore Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ecore Type</em>' reference.
	 * @see #setEcoreType(EClassifier)
	 * @see org.eclipse.epsilon.eol.eol.EolPackage#getEType_EcoreType()
	 * @model required="true"
	 * @generated
	 */
	EClassifier getEcoreType();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.metamodel.EType#getEcoreType <em>Ecore Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ecore Type</em>' reference.
	 * @see #getEcoreType()
	 * @generated
	 */
	void setEcoreType(EClassifier value);

} // EType
