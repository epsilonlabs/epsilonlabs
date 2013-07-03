/**
 */
package org.eclipse.epsilon.emc.yed;

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
 *   <li>{@link org.eclipse.epsilon.emc.yed.Node#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.epsilon.emc.yed.Node#getSlots <em>Slots</em>}</li>
 *   <li>{@link org.eclipse.epsilon.emc.yed.Node#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.epsilon.emc.yed.Node#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link org.eclipse.epsilon.emc.yed.Node#getOutgoing <em>Outgoing</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.emc.yed.YedPackage#getNode()
 * @model
 * @generated
 */
public interface Node extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.eclipse.epsilon.emc.yed.YedPackage#getNode_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.emc.yed.Node#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Slots</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.emc.yed.Slot}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.epsilon.emc.yed.Slot#getOwningNode <em>Owning Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Slots</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Slots</em>' containment reference list.
	 * @see org.eclipse.epsilon.emc.yed.YedPackage#getNode_Slots()
	 * @see org.eclipse.epsilon.emc.yed.Slot#getOwningNode
	 * @model opposite="owningNode" containment="true"
	 * @generated
	 */
	EList<Slot> getSlots();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.epsilon.emc.yed.NodeType#getInstances <em>Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' container reference.
	 * @see #setType(NodeType)
	 * @see org.eclipse.epsilon.emc.yed.YedPackage#getNode_Type()
	 * @see org.eclipse.epsilon.emc.yed.NodeType#getInstances
	 * @model opposite="instances" transient="false"
	 * @generated
	 */
	NodeType getType();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.emc.yed.Node#getType <em>Type</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' container reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(NodeType value);

	/**
	 * Returns the value of the '<em><b>Incoming</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.emc.yed.Edge}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.epsilon.emc.yed.Edge#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming</em>' reference list.
	 * @see org.eclipse.epsilon.emc.yed.YedPackage#getNode_Incoming()
	 * @see org.eclipse.epsilon.emc.yed.Edge#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<Edge> getIncoming();

	/**
	 * Returns the value of the '<em><b>Outgoing</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.emc.yed.Edge}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing</em>' reference list.
	 * @see org.eclipse.epsilon.emc.yed.YedPackage#getNode_Outgoing()
	 * @model
	 * @generated
	 */
	EList<Edge> getOutgoing();

} // Node
