/**
 */
package org.eclipse.epsilon.emc.graphml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Edge Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.emc.graphml.EdgeType#getSourcePrototype <em>Source Prototype</em>}</li>
 *   <li>{@link org.eclipse.epsilon.emc.graphml.EdgeType#getTargetPrototype <em>Target Prototype</em>}</li>
 *   <li>{@link org.eclipse.epsilon.emc.graphml.EdgeType#getRoleInSourcePrototype <em>Role In Source Prototype</em>}</li>
 *   <li>{@link org.eclipse.epsilon.emc.graphml.EdgeType#getRoleInTargetPrototype <em>Role In Target Prototype</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.emc.graphml.GraphmlPackage#getEdgeType()
 * @model
 * @generated
 */
public interface EdgeType extends NodeType {
	/**
	 * Returns the value of the '<em><b>Source Prototype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Prototype</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Prototype</em>' reference.
	 * @see #setSourcePrototype(SlotPrototype)
	 * @see org.eclipse.epsilon.emc.graphml.GraphmlPackage#getEdgeType_SourcePrototype()
	 * @model
	 * @generated
	 */
	SlotPrototype getSourcePrototype();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.emc.graphml.EdgeType#getSourcePrototype <em>Source Prototype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Prototype</em>' reference.
	 * @see #getSourcePrototype()
	 * @generated
	 */
	void setSourcePrototype(SlotPrototype value);

	/**
	 * Returns the value of the '<em><b>Target Prototype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Prototype</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Prototype</em>' reference.
	 * @see #setTargetPrototype(SlotPrototype)
	 * @see org.eclipse.epsilon.emc.graphml.GraphmlPackage#getEdgeType_TargetPrototype()
	 * @model
	 * @generated
	 */
	SlotPrototype getTargetPrototype();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.emc.graphml.EdgeType#getTargetPrototype <em>Target Prototype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Prototype</em>' reference.
	 * @see #getTargetPrototype()
	 * @generated
	 */
	void setTargetPrototype(SlotPrototype value);

	/**
	 * Returns the value of the '<em><b>Role In Source Prototype</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Role In Source Prototype</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role In Source Prototype</em>' containment reference.
	 * @see #setRoleInSourcePrototype(SlotPrototype)
	 * @see org.eclipse.epsilon.emc.graphml.GraphmlPackage#getEdgeType_RoleInSourcePrototype()
	 * @model containment="true"
	 * @generated
	 */
	SlotPrototype getRoleInSourcePrototype();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.emc.graphml.EdgeType#getRoleInSourcePrototype <em>Role In Source Prototype</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Role In Source Prototype</em>' containment reference.
	 * @see #getRoleInSourcePrototype()
	 * @generated
	 */
	void setRoleInSourcePrototype(SlotPrototype value);

	/**
	 * Returns the value of the '<em><b>Role In Target Prototype</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Role In Target Prototype</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role In Target Prototype</em>' containment reference.
	 * @see #setRoleInTargetPrototype(SlotPrototype)
	 * @see org.eclipse.epsilon.emc.graphml.GraphmlPackage#getEdgeType_RoleInTargetPrototype()
	 * @model containment="true"
	 * @generated
	 */
	SlotPrototype getRoleInTargetPrototype();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.emc.graphml.EdgeType#getRoleInTargetPrototype <em>Role In Target Prototype</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Role In Target Prototype</em>' containment reference.
	 * @see #getRoleInTargetPrototype()
	 * @generated
	 */
	void setRoleInTargetPrototype(SlotPrototype value);

} // EdgeType
