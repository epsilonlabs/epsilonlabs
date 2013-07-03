/**
 */
package org.eclipse.epsilon.emc.graphml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.emc.graphml.CompositeType#getTypes <em>Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.emc.graphml.GraphmlPackage#getCompositeType()
 * @model
 * @generated
 */
public interface CompositeType extends Type {
	/**
	 * Returns the value of the '<em><b>Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.emc.graphml.Type}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Types</em>' containment reference list.
	 * @see org.eclipse.epsilon.emc.graphml.GraphmlPackage#getCompositeType_Types()
	 * @model containment="true"
	 * @generated
	 */
	EList<Type> getTypes();

} // CompositeType
