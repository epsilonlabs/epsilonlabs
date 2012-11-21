/**
 */
package testm2;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Deliverable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link testm2.Deliverable#getTitle <em>Title</em>}</li>
 *   <li>{@link testm2.Deliverable#getDue <em>Due</em>}</li>
 *   <li>{@link testm2.Deliverable#getNature <em>Nature</em>}</li>
 *   <li>{@link testm2.Deliverable#getDissemination <em>Dissemination</em>}</li>
 *   <li>{@link testm2.Deliverable#getPartner <em>Partner</em>}</li>
 * </ul>
 * </p>
 *
 * @see testm2.Testm2Package#getDeliverable()
 * @model
 * @generated
 */
public interface Deliverable extends EObject {
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
	 * @see testm2.Testm2Package#getDeliverable_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link testm2.Deliverable#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Due</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Due</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Due</em>' attribute.
	 * @see #setDue(int)
	 * @see testm2.Testm2Package#getDeliverable_Due()
	 * @model
	 * @generated
	 */
	int getDue();

	/**
	 * Sets the value of the '{@link testm2.Deliverable#getDue <em>Due</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Due</em>' attribute.
	 * @see #getDue()
	 * @generated
	 */
	void setDue(int value);

	/**
	 * Returns the value of the '<em><b>Nature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nature</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nature</em>' attribute.
	 * @see #setNature(String)
	 * @see testm2.Testm2Package#getDeliverable_Nature()
	 * @model
	 * @generated
	 */
	String getNature();

	/**
	 * Sets the value of the '{@link testm2.Deliverable#getNature <em>Nature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nature</em>' attribute.
	 * @see #getNature()
	 * @generated
	 */
	void setNature(String value);

	/**
	 * Returns the value of the '<em><b>Dissemination</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dissemination</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dissemination</em>' attribute.
	 * @see #setDissemination(String)
	 * @see testm2.Testm2Package#getDeliverable_Dissemination()
	 * @model
	 * @generated
	 */
	String getDissemination();

	/**
	 * Sets the value of the '{@link testm2.Deliverable#getDissemination <em>Dissemination</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dissemination</em>' attribute.
	 * @see #getDissemination()
	 * @generated
	 */
	void setDissemination(String value);

	/**
	 * Returns the value of the '<em><b>Partner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Partner</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Partner</em>' reference.
	 * @see #setPartner(Partner)
	 * @see testm2.Testm2Package#getDeliverable_Partner()
	 * @model
	 * @generated
	 */
	Partner getPartner();

	/**
	 * Sets the value of the '{@link testm2.Deliverable#getPartner <em>Partner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Partner</em>' reference.
	 * @see #getPartner()
	 * @generated
	 */
	void setPartner(Partner value);

} // Deliverable
