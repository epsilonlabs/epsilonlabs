/**
 */
package org.eclipse.epsilon.eol.metamodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.EolElement#getContainer <em>Container</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.EolElement#getLine <em>Line</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.EolElement#getColumn <em>Column</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.EolElement#getUri <em>Uri</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.EolElement#getRegion <em>Region</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getEolElement()
 * @model abstract="true"
 * @generated
 */
public interface EolElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' reference.
	 * @see #setContainer(EolElement)
	 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getEolElement_Container()
	 * @model
	 * @generated
	 */
	EolElement getContainer();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.metamodel.EolElement#getContainer <em>Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(EolElement value);

	/**
	 * Returns the value of the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Line</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Line</em>' attribute.
	 * @see #setLine(int)
	 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getEolElement_Line()
	 * @model
	 * @generated
	 */
	int getLine();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.metamodel.EolElement#getLine <em>Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line</em>' attribute.
	 * @see #getLine()
	 * @generated
	 */
	void setLine(int value);

	/**
	 * Returns the value of the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Column</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Column</em>' attribute.
	 * @see #setColumn(int)
	 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getEolElement_Column()
	 * @model
	 * @generated
	 */
	int getColumn();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.metamodel.EolElement#getColumn <em>Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Column</em>' attribute.
	 * @see #getColumn()
	 * @generated
	 */
	void setColumn(int value);

	/**
	 * Returns the value of the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uri</em>' attribute.
	 * @see #setUri(String)
	 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getEolElement_Uri()
	 * @model
	 * @generated
	 */
	String getUri();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.metamodel.EolElement#getUri <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
	void setUri(String value);

	/**
	 * Returns the value of the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Region</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Region</em>' containment reference.
	 * @see #setRegion(TextRegion)
	 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getEolElement_Region()
	 * @model containment="true"
	 * @generated
	 */
	TextRegion getRegion();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.metamodel.EolElement#getRegion <em>Region</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Region</em>' containment reference.
	 * @see #getRegion()
	 * @generated
	 */
	void setRegion(TextRegion value);

} // EolElement
