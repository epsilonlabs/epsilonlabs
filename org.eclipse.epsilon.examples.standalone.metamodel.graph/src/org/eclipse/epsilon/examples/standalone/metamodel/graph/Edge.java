/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.epsilon.examples.standalone.metamodel.graph;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.examples.standalone.metamodel.graph.Edge#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.epsilon.examples.standalone.metamodel.graph.Edge#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.examples.standalone.metamodel.graph.GraphPackage#getEdge()
 * @model
 * @generated
 */
public interface Edge extends EObject {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.epsilon.examples.standalone.metamodel.graph.Node#getOutgoing <em>Outgoing</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' container reference.
	 * @see #setSource(Node)
	 * @see org.eclipse.epsilon.examples.standalone.metamodel.graph.GraphPackage#getEdge_Source()
	 * @see org.eclipse.epsilon.examples.standalone.metamodel.graph.Node#getOutgoing
	 * @model opposite="outgoing" transient="false"
	 * @generated
	 */
	Node getSource();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.examples.standalone.metamodel.graph.Edge#getSource <em>Source</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' container reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Node value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.epsilon.examples.standalone.metamodel.graph.Node#getIncoming <em>Incoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Node)
	 * @see org.eclipse.epsilon.examples.standalone.metamodel.graph.GraphPackage#getEdge_Target()
	 * @see org.eclipse.epsilon.examples.standalone.metamodel.graph.Node#getIncoming
	 * @model opposite="incoming"
	 * @generated
	 */
	Node getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.examples.standalone.metamodel.graph.Edge#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Node value);

} // Edge
