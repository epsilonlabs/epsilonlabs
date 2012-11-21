/**
 */
package testm2;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Effort</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link testm2.Effort#getPartner <em>Partner</em>}</li>
 *   <li>{@link testm2.Effort#getMonths <em>Months</em>}</li>
 * </ul>
 * </p>
 *
 * @see testm2.Testm2Package#getEffort()
 * @model
 * @generated
 */
public interface Effort extends EObject {
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
	 * @see testm2.Testm2Package#getEffort_Partner()
	 * @model
	 * @generated
	 */
	Partner getPartner();

	/**
	 * Sets the value of the '{@link testm2.Effort#getPartner <em>Partner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Partner</em>' reference.
	 * @see #getPartner()
	 * @generated
	 */
	void setPartner(Partner value);

	/**
	 * Returns the value of the '<em><b>Months</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Months</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Months</em>' attribute.
	 * @see #setMonths(float)
	 * @see testm2.Testm2Package#getEffort_Months()
	 * @model
	 * @generated
	 */
	float getMonths();

	/**
	 * Sets the value of the '{@link testm2.Effort#getMonths <em>Months</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Months</em>' attribute.
	 * @see #getMonths()
	 * @generated
	 */
	void setMonths(float value);

} // Effort
