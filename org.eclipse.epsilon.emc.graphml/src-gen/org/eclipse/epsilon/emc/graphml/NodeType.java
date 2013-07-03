/**
 */
package org.eclipse.epsilon.emc.graphml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.emc.graphml.NodeType#getInstances <em>Instances</em>}</li>
 *   <li>{@link org.eclipse.epsilon.emc.graphml.NodeType#getSlotPrototypes <em>Slot Prototypes</em>}</li>
 *   <li>{@link org.eclipse.epsilon.emc.graphml.NodeType#getSuperTypes <em>Super Types</em>}</li>
 *   <li>{@link org.eclipse.epsilon.emc.graphml.NodeType#getSubTypes <em>Sub Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.emc.graphml.GraphmlPackage#getNodeType()
 * @model
 * @generated
 */
public interface NodeType extends Type {
	/**
	 * Returns the value of the '<em><b>Instances</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.emc.graphml.Node}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.epsilon.emc.graphml.Node#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instances</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instances</em>' reference list.
	 * @see org.eclipse.epsilon.emc.graphml.GraphmlPackage#getNodeType_Instances()
	 * @see org.eclipse.epsilon.emc.graphml.Node#getType
	 * @model opposite="type"
	 * @generated
	 */
	EList<Node> getInstances();

	/**
	 * Returns the value of the '<em><b>Slot Prototypes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.emc.graphml.SlotPrototype}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.epsilon.emc.graphml.SlotPrototype#getOwningType <em>Owning Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Slot Prototypes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Slot Prototypes</em>' containment reference list.
	 * @see org.eclipse.epsilon.emc.graphml.GraphmlPackage#getNodeType_SlotPrototypes()
	 * @see org.eclipse.epsilon.emc.graphml.SlotPrototype#getOwningType
	 * @model opposite="owningType" containment="true"
	 * @generated
	 */
	EList<SlotPrototype> getSlotPrototypes();

	/**
	 * Returns the value of the '<em><b>Super Types</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.emc.graphml.NodeType}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.epsilon.emc.graphml.NodeType#getSubTypes <em>Sub Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Types</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Types</em>' reference list.
	 * @see org.eclipse.epsilon.emc.graphml.GraphmlPackage#getNodeType_SuperTypes()
	 * @see org.eclipse.epsilon.emc.graphml.NodeType#getSubTypes
	 * @model opposite="subTypes"
	 * @generated
	 */
	EList<NodeType> getSuperTypes();

	/**
	 * Returns the value of the '<em><b>Sub Types</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.emc.graphml.NodeType}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.epsilon.emc.graphml.NodeType#getSuperTypes <em>Super Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Types</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Types</em>' reference list.
	 * @see org.eclipse.epsilon.emc.graphml.GraphmlPackage#getNodeType_SubTypes()
	 * @see org.eclipse.epsilon.emc.graphml.NodeType#getSuperTypes
	 * @model opposite="superTypes"
	 * @generated
	 */
	EList<NodeType> getSubTypes();

} // NodeType
