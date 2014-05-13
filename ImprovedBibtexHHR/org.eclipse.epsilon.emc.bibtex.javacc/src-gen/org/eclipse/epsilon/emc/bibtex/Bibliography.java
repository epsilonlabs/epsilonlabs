/**
 */
package org.eclipse.epsilon.emc.bibtex;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.epsilon.emc.bibtex.parser.javacc.Node;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bibliography</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.emc.bibtex.Bibliography#getEntries <em>Entries</em>}</li>
 *   <li>{@link org.eclipse.epsilon.emc.bibtex.Bibliography#getContents <em>Contents</em>}</li>
 *   <li>{@link org.eclipse.epsilon.emc.bibtex.Bibliography#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.emc.bibtex.BibtexPackage#getBibliography()
 * @model superTypes="org.eclipse.epsilon.emc.bibtex.Node"
 * @generated
 */
public interface Bibliography extends EObject, Node {
	/**
	 * Returns the value of the '<em><b>Entries</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.emc.bibtex.Entry}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.epsilon.emc.bibtex.Entry#getBibliography <em>Bibliography</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entries</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entries</em>' containment reference list.
	 * @see org.eclipse.epsilon.emc.bibtex.BibtexPackage#getBibliography_Entries()
	 * @see org.eclipse.epsilon.emc.bibtex.Entry#getBibliography
	 * @model opposite="bibliography" containment="true"
	 * @generated
	 */
	EList<Entry> getEntries();

	/**
	 * Returns the value of the '<em><b>Contents</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.emc.bibtex.Content}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.epsilon.emc.bibtex.Content#getBibliography <em>Bibliography</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contents</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contents</em>' containment reference list.
	 * @see org.eclipse.epsilon.emc.bibtex.BibtexPackage#getBibliography_Contents()
	 * @see org.eclipse.epsilon.emc.bibtex.Content#getBibliography
	 * @model opposite="bibliography" containment="true"
	 * @generated
	 */
	EList<Content> getContents();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.epsilon.emc.bibtex.BibtexPackage#getBibliography_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.emc.bibtex.Bibliography#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Bibliography
