/**
 */
package org.eclipse.epsilon.eol.dom;

import org.eclipse.emf.ecore.EClassifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Element Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.dom.ModelElementType#getEcoreType <em>Ecore Type</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.dom.ModelElementType#getResolvedModelDeclaration <em>Resolved Model Declaration</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.dom.ModelElementType#getModelName <em>Model Name</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.dom.ModelElementType#getElementName <em>Element Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.eol.dom.EolPackage#getModelElementType()
 * @model
 * @generated
 */
public interface ModelElementType extends Type {
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
	 * @see org.eclipse.epsilon.eol.dom.EolPackage#getModelElementType_EcoreType()
	 * @model
	 * @generated
	 */
	EClassifier getEcoreType();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.dom.ModelElementType#getEcoreType <em>Ecore Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ecore Type</em>' reference.
	 * @see #getEcoreType()
	 * @generated
	 */
	void setEcoreType(EClassifier value);

	/**
	 * Returns the value of the '<em><b>Resolved Model Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resolved Model Declaration</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resolved Model Declaration</em>' reference.
	 * @see #setResolvedModelDeclaration(ModelDeclarationStatement)
	 * @see org.eclipse.epsilon.eol.dom.EolPackage#getModelElementType_ResolvedModelDeclaration()
	 * @model
	 * @generated
	 */
	ModelDeclarationStatement getResolvedModelDeclaration();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.dom.ModelElementType#getResolvedModelDeclaration <em>Resolved Model Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resolved Model Declaration</em>' reference.
	 * @see #getResolvedModelDeclaration()
	 * @generated
	 */
	void setResolvedModelDeclaration(ModelDeclarationStatement value);

	/**
	 * Returns the value of the '<em><b>Model Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Name</em>' attribute.
	 * @see #setModelName(String)
	 * @see org.eclipse.epsilon.eol.dom.EolPackage#getModelElementType_ModelName()
	 * @model
	 * @generated
	 */
	String getModelName();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.dom.ModelElementType#getModelName <em>Model Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Name</em>' attribute.
	 * @see #getModelName()
	 * @generated
	 */
	void setModelName(String value);

	/**
	 * Returns the value of the '<em><b>Element Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Name</em>' attribute.
	 * @see #setElementName(String)
	 * @see org.eclipse.epsilon.eol.dom.EolPackage#getModelElementType_ElementName()
	 * @model
	 * @generated
	 */
	String getElementName();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.dom.ModelElementType#getElementName <em>Element Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Name</em>' attribute.
	 * @see #getElementName()
	 * @generated
	 */
	void setElementName(String value);

} // ModelElementType
