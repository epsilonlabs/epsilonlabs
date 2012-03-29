/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.epsilon.examples.standalone.metamodel.graph;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.examples.standalone.metamodel.graph.Node#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.epsilon.examples.standalone.metamodel.graph.Node#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link org.eclipse.epsilon.examples.standalone.metamodel.graph.Node#getIncoming <em>Incoming</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.examples.standalone.metamodel.graph.GraphPackage#getNode()
 * @model
 * @generated
 */
public interface Node extends EObject {
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
	 * @see org.eclipse.epsilon.examples.standalone.metamodel.graph.GraphPackage#getNode_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.examples.standalone.metamodel.graph.Node#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Outgoing</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.examples.standalone.metamodel.graph.Edge}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.epsilon.examples.standalone.metamodel.graph.Edge#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing</em>' containment reference list.
	 * @see org.eclipse.epsilon.examples.standalone.metamodel.graph.GraphPackage#getNode_Outgoing()
	 * @see org.eclipse.epsilon.examples.standalone.metamodel.graph.Edge#getSource
	 * @model opposite="source" containment="true"
	 * @generated
	 */
	EList<Edge> getOutgoing();

	/**
	 * Returns the value of the '<em><b>Incoming</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.examples.standalone.metamodel.graph.Edge}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.epsilon.examples.standalone.metamodel.graph.Edge#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming</em>' reference list.
	 * @see org.eclipse.epsilon.examples.standalone.metamodel.graph.GraphPackage#getNode_Incoming()
	 * @see org.eclipse.epsilon.examples.standalone.metamodel.graph.Edge#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<Edge> getIncoming();

} // Node
