/**
 */
package org.eclipse.epsilon.evl.metamodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.epsilon.eol.metamodel.ModelElementType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.evl.metamodel.Context#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.epsilon.evl.metamodel.Context#getPre <em>Pre</em>}</li>
 *   <li>{@link org.eclipse.epsilon.evl.metamodel.Context#getPost <em>Post</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.evl.metamodel.EvlPackage#getContext()
 * @model
 * @generated
 */
public interface Context extends GuardedElement {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(ModelElementType)
	 * @see org.eclipse.epsilon.evl.metamodel.EvlPackage#getContext_Type()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ModelElementType getType();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.evl.metamodel.Context#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(ModelElementType value);

	/**
	 * Returns the value of the '<em><b>Pre</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.evl.metamodel.PreBlock}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pre</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pre</em>' containment reference list.
	 * @see org.eclipse.epsilon.evl.metamodel.EvlPackage#getContext_Pre()
	 * @model containment="true"
	 * @generated
	 */
	EList<PreBlock> getPre();

	/**
	 * Returns the value of the '<em><b>Post</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.evl.metamodel.PostBlock}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Post</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Post</em>' containment reference list.
	 * @see org.eclipse.epsilon.evl.metamodel.EvlPackage#getContext_Post()
	 * @model containment="true"
	 * @generated
	 */
	EList<PostBlock> getPost();

} // Context
