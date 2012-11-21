/**
 */
package testm2;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>WP</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link testm2.WP#getTasks <em>Tasks</em>}</li>
 *   <li>{@link testm2.WP#getTitle <em>Title</em>}</li>
 *   <li>{@link testm2.WP#getLeader <em>Leader</em>}</li>
 *   <li>{@link testm2.WP#getType <em>Type</em>}</li>
 *   <li>{@link testm2.WP#getEffort <em>Effort</em>}</li>
 *   <li>{@link testm2.WP#getDeliverables <em>Deliverables</em>}</li>
 * </ul>
 * </p>
 *
 * @see testm2.Testm2Package#getWP()
 * @model
 * @generated
 */
public interface WP extends EObject {
	/**
	 * Returns the value of the '<em><b>Tasks</b></em>' containment reference list.
	 * The list contents are of type {@link testm2.Task}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tasks</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tasks</em>' containment reference list.
	 * @see testm2.Testm2Package#getWP_Tasks()
	 * @model containment="true"
	 * @generated
	 */
	EList<Task> getTasks();

	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see testm2.Testm2Package#getWP_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link testm2.WP#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Leader</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Leader</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Leader</em>' reference.
	 * @see #setLeader(Partner)
	 * @see testm2.Testm2Package#getWP_Leader()
	 * @model
	 * @generated
	 */
	Partner getLeader();

	/**
	 * Sets the value of the '{@link testm2.WP#getLeader <em>Leader</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Leader</em>' reference.
	 * @see #getLeader()
	 * @generated
	 */
	void setLeader(Partner value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see testm2.Testm2Package#getWP_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link testm2.WP#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Effort</b></em>' containment reference list.
	 * The list contents are of type {@link testm2.Effort}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Effort</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Effort</em>' containment reference list.
	 * @see testm2.Testm2Package#getWP_Effort()
	 * @model containment="true"
	 * @generated
	 */
	EList<Effort> getEffort();

	/**
	 * Returns the value of the '<em><b>Deliverables</b></em>' containment reference list.
	 * The list contents are of type {@link testm2.Deliverable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deliverables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deliverables</em>' containment reference list.
	 * @see testm2.Testm2Package#getWP_Deliverables()
	 * @model containment="true"
	 * @generated
	 */
	EList<Deliverable> getDeliverables();

} // WP
