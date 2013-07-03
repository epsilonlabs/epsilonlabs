/**
 */
package org.eclipse.epsilon.emc.graphml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Slot Prototype</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.emc.graphml.SlotPrototype#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.epsilon.emc.graphml.SlotPrototype#isMany <em>Many</em>}</li>
 *   <li>{@link org.eclipse.epsilon.emc.graphml.SlotPrototype#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.epsilon.emc.graphml.SlotPrototype#getOwningType <em>Owning Type</em>}</li>
 *   <li>{@link org.eclipse.epsilon.emc.graphml.SlotPrototype#getSlots <em>Slots</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.emc.graphml.GraphmlPackage#getSlotPrototype()
 * @model
 * @generated
 */
public interface SlotPrototype extends EObject {
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
	 * @see org.eclipse.epsilon.emc.graphml.GraphmlPackage#getSlotPrototype_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.emc.graphml.SlotPrototype#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Many</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Many</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Many</em>' attribute.
	 * @see #setMany(boolean)
	 * @see org.eclipse.epsilon.emc.graphml.GraphmlPackage#getSlotPrototype_Many()
	 * @model default="false"
	 * @generated
	 */
	boolean isMany();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.emc.graphml.SlotPrototype#isMany <em>Many</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Many</em>' attribute.
	 * @see #isMany()
	 * @generated
	 */
	void setMany(boolean value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(Type)
	 * @see org.eclipse.epsilon.emc.graphml.GraphmlPackage#getSlotPrototype_Type()
	 * @model
	 * @generated
	 */
	Type getType();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.emc.graphml.SlotPrototype#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Type value);

	/**
	 * Returns the value of the '<em><b>Owning Type</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.epsilon.emc.graphml.NodeType#getSlotPrototypes <em>Slot Prototypes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Type</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Type</em>' container reference.
	 * @see #setOwningType(NodeType)
	 * @see org.eclipse.epsilon.emc.graphml.GraphmlPackage#getSlotPrototype_OwningType()
	 * @see org.eclipse.epsilon.emc.graphml.NodeType#getSlotPrototypes
	 * @model opposite="slotPrototypes" transient="false"
	 * @generated
	 */
	NodeType getOwningType();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.emc.graphml.SlotPrototype#getOwningType <em>Owning Type</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Type</em>' container reference.
	 * @see #getOwningType()
	 * @generated
	 */
	void setOwningType(NodeType value);

	/**
	 * Returns the value of the '<em><b>Slots</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.emc.graphml.Slot}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.epsilon.emc.graphml.Slot#getPrototype <em>Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Slots</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Slots</em>' reference list.
	 * @see org.eclipse.epsilon.emc.graphml.GraphmlPackage#getSlotPrototype_Slots()
	 * @see org.eclipse.epsilon.emc.graphml.Slot#getPrototype
	 * @model opposite="prototype"
	 * @generated
	 */
	EList<Slot> getSlots();

} // SlotPrototype
