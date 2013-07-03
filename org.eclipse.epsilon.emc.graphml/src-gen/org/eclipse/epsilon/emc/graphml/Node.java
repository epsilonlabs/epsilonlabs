/**
 */
package org.eclipse.epsilon.emc.graphml;

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
 *   <li>{@link org.eclipse.epsilon.emc.graphml.Node#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.epsilon.emc.graphml.Node#getSlots <em>Slots</em>}</li>
 *   <li>{@link org.eclipse.epsilon.emc.graphml.Node#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.emc.graphml.GraphmlPackage#getNode()
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
	 * @see org.eclipse.epsilon.emc.graphml.GraphmlPackage#getNode_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.emc.graphml.Node#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Slots</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.emc.graphml.Slot}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.epsilon.emc.graphml.Slot#getOwningNode <em>Owning Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Slots</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Slots</em>' containment reference list.
	 * @see org.eclipse.epsilon.emc.graphml.GraphmlPackage#getNode_Slots()
	 * @see org.eclipse.epsilon.emc.graphml.Slot#getOwningNode
	 * @model opposite="owningNode" containment="true"
	 * @generated
	 */
	EList<Slot> getSlots();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.epsilon.emc.graphml.NodeType#getInstances <em>Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(NodeType)
	 * @see org.eclipse.epsilon.emc.graphml.GraphmlPackage#getNode_Type()
	 * @see org.eclipse.epsilon.emc.graphml.NodeType#getInstances
	 * @model opposite="instances"
	 * @generated
	 */
	NodeType getType();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.emc.graphml.Node#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(NodeType value);

} // Node
