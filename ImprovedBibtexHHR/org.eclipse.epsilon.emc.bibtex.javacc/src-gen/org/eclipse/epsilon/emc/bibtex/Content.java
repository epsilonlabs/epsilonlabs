/**
 */
package org.eclipse.epsilon.emc.bibtex;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.epsilon.emc.bibtex.parser.javacc.Node;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Content</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.emc.bibtex.Content#getContent <em>Content</em>}</li>
 *   <li>{@link org.eclipse.epsilon.emc.bibtex.Content#getBibliography <em>Bibliography</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.emc.bibtex.BibtexPackage#getContent()
 * @model abstract="true" superTypes="org.eclipse.epsilon.emc.bibtex.Node"
 * @generated
 */
public interface Content extends EObject, Node {
	/**
	 * Returns the value of the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content</em>' attribute.
	 * @see #setContent(String)
	 * @see org.eclipse.epsilon.emc.bibtex.BibtexPackage#getContent_Content()
	 * @model
	 * @generated
	 */
	String getContent();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.emc.bibtex.Content#getContent <em>Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content</em>' attribute.
	 * @see #getContent()
	 * @generated
	 */
	void setContent(String value);

	/**
	 * Returns the value of the '<em><b>Bibliography</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.epsilon.emc.bibtex.Bibliography#getContents <em>Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bibliography</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bibliography</em>' container reference.
	 * @see #setBibliography(Bibliography)
	 * @see org.eclipse.epsilon.emc.bibtex.BibtexPackage#getContent_Bibliography()
	 * @see org.eclipse.epsilon.emc.bibtex.Bibliography#getContents
	 * @model opposite="contents" required="true" transient="false"
	 * @generated
	 */
	Bibliography getBibliography();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.emc.bibtex.Content#getBibliography <em>Bibliography</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bibliography</em>' container reference.
	 * @see #getBibliography()
	 * @generated
	 */
	void setBibliography(Bibliography value);

} // Content
