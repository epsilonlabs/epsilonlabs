/**
 */
package org.eclipse.epsilon.emc.yed;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.emc.yed.NodeType#getInstances <em>Instances</em>}</li>
 *   <li>{@link org.eclipse.epsilon.emc.yed.NodeType#getSlotPrototypes <em>Slot Prototypes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.emc.yed.YedPackage#getNodeType()
 * @model
 * @generated
 */
public interface NodeType extends Type {
	/**
	 * Returns the value of the '<em><b>Instances</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.emc.yed.Node}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.epsilon.emc.yed.Node#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instances</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instances</em>' reference list.
	 * @see org.eclipse.epsilon.emc.yed.YedPackage#getNodeType_Instances()
	 * @see org.eclipse.epsilon.emc.yed.Node#getType
	 * @model opposite="type"
	 * @generated
	 */
	EList<Node> getInstances();

	/**
	 * Returns the value of the '<em><b>Slot Prototypes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.emc.yed.SlotPrototype}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.epsilon.emc.yed.SlotPrototype#getOwningType <em>Owning Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Slot Prototypes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Slot Prototypes</em>' containment reference list.
	 * @see org.eclipse.epsilon.emc.yed.YedPackage#getNodeType_SlotPrototypes()
	 * @see org.eclipse.epsilon.emc.yed.SlotPrototype#getOwningType
	 * @model opposite="owningType" containment="true"
	 * @generated
	 */
	EList<SlotPrototype> getSlotPrototypes();

} // NodeType
