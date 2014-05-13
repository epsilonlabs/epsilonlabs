/**
 */
package org.eclipse.epsilon.emc.bibtex;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.epsilon.emc.bibtex.parser.javacc.Node;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.emc.bibtex.Entry#getBibliography <em>Bibliography</em>}</li>
 *   <li>{@link org.eclipse.epsilon.emc.bibtex.Entry#getTags <em>Tags</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.emc.bibtex.BibtexPackage#getEntry()
 * @model abstract="true" superTypes="org.eclipse.epsilon.emc.bibtex.Node"
 * @generated
 */
public interface Entry extends EObject, Node {
	/**
	 * Returns the value of the '<em><b>Bibliography</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.epsilon.emc.bibtex.Bibliography#getEntries <em>Entries</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bibliography</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bibliography</em>' container reference.
	 * @see #setBibliography(Bibliography)
	 * @see org.eclipse.epsilon.emc.bibtex.BibtexPackage#getEntry_Bibliography()
	 * @see org.eclipse.epsilon.emc.bibtex.Bibliography#getEntries
	 * @model opposite="entries" required="true" transient="false"
	 * @generated
	 */
	Bibliography getBibliography();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.emc.bibtex.Entry#getBibliography <em>Bibliography</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bibliography</em>' container reference.
	 * @see #getBibliography()
	 * @generated
	 */
	void setBibliography(Bibliography value);

	/**
	 * Returns the value of the '<em><b>Tags</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.emc.bibtex.Tag}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.epsilon.emc.bibtex.Tag#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tags</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tags</em>' containment reference list.
	 * @see org.eclipse.epsilon.emc.bibtex.BibtexPackage#getEntry_Tags()
	 * @see org.eclipse.epsilon.emc.bibtex.Tag#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Tag> getTags();

} // Entry
