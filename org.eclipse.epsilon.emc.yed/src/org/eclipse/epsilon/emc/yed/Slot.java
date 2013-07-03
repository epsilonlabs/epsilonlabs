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
 *   <li>{@link org.eclipse.epsilon.emc.yed.Slot#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.epsilon.emc.yed.Slot#getValue <em>Value</em>}</li>
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
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.epsilon.emc.yed.YedPackage#getSlot_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.emc.yed.Slot#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(Object)
	 * @see org.eclipse.epsilon.emc.yed.YedPackage#getSlot_Value()
	 * @model
	 * @generated
	 */
	Object getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.emc.yed.Slot#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Object value);

	/**
	 * Returns the value of the '<em><b>Prototype</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.epsilon.emc.yed.SlotPrototype#getSlots <em>Slots</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prototype</em>' reference list isn't clear,
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
