/**
 */
package org.eclipse.epsilon.emc.yed;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Slot</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.emc.yed.Slot#getValues <em>Values</em>}</li>
 *   <li>{@link org.eclipse.epsilon.emc.yed.Slot#getPrototype <em>Prototype</em>}</li>
 *   <li>{@link org.eclipse.epsilon.emc.yed.Slot#getOwningNode <em>Owning Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.emc.yed.YedPackage#getSlot()
 * @model
 * @generated
 */
public interface Slot extends EObject {
	/**
	 * Returns the value of the '<em><b>Values</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Object}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' attribute list.
	 * @see org.eclipse.epsilon.emc.yed.YedPackage#getSlot_Values()
	 * @model
	 * @generated
	 */
	EList<Object> getValues();

	/**
	 * Returns the value of the '<em><b>Prototype</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.epsilon.emc.yed.SlotPrototype#getSlots <em>Slots</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prototype</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prototype</em>' reference.
	 * @see #setPrototype(SlotPrototype)
	 * @see org.eclipse.epsilon.emc.yed.YedPackage#getSlot_Prototype()
	 * @see org.eclipse.epsilon.emc.yed.SlotPrototype#getSlots
	 * @model opposite="slots"
	 * @generated
	 */
	SlotPrototype getPrototype();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.emc.yed.Slot#getPrototype <em>Prototype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prototype</em>' reference.
	 * @see #getPrototype()
	 * @generated
	 */
	void setPrototype(SlotPrototype value);

	/**
	 * Returns the value of the '<em><b>Owning Node</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.epsilon.emc.yed.Node#getSlots <em>Slots</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Node</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Node</em>' container reference.
	 * @see #setOwningNode(Node)
	 * @see org.eclipse.epsilon.emc.yed.YedPackage#getSlot_OwningNode()
	 * @see org.eclipse.epsilon.emc.yed.Node#getSlots
	 * @model opposite="slots" transient="false"
	 * @generated
	 */
	Node getOwningNode();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.emc.yed.Slot#getOwningNode <em>Owning Node</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Node</em>' container reference.
	 * @see #getOwningNode()
	 * @generated
	 */
	void setOwningNode(Node value);

} // Slot
