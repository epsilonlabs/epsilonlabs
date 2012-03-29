/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.epsilon.examples.standalone.metamodel.tree;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tree</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.examples.standalone.metamodel.tree.Tree#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.epsilon.examples.standalone.metamodel.tree.Tree#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.epsilon.examples.standalone.metamodel.tree.Tree#getLabel <em>Label</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.examples.standalone.metamodel.tree.TreePackage#getTree()
 * @model
 * @generated
 */
public interface Tree extends EObject {
	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.examples.standalone.metamodel.tree.Tree}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.epsilon.examples.standalone.metamodel.tree.Tree#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see org.eclipse.epsilon.examples.standalone.metamodel.tree.TreePackage#getTree_Children()
	 * @see org.eclipse.epsilon.examples.standalone.metamodel.tree.Tree#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<Tree> getChildren();

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.epsilon.examples.standalone.metamodel.tree.Tree#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(Tree)
	 * @see org.eclipse.epsilon.examples.standalone.metamodel.tree.TreePackage#getTree_Parent()
	 * @see org.eclipse.epsilon.examples.standalone.metamodel.tree.Tree#getChildren
	 * @model opposite="children" transient="false"
	 * @generated
	 */
	Tree getParent();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.examples.standalone.metamodel.tree.Tree#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(Tree value);

	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #setLabel(String)
	 * @see org.eclipse.epsilon.examples.standalone.metamodel.tree.TreePackage#getTree_Label()
	 * @model
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.examples.standalone.metamodel.tree.Tree#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

} // Tree
