/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ewe;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Nested Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ewe.VariableNestedElement#getRef <em>Ref</em>}</li>
 *   <li>{@link ewe.VariableNestedElement#getAs <em>As</em>}</li>
 *   <li>{@link ewe.VariableNestedElement#getOptional <em>Optional</em>}</li>
 * </ul>
 * </p>
 *
 * @see ewe.EwePackage#getVariableNestedElement()
 * @model
 * @generated
 */
public interface VariableNestedElement extends EObject
{
  /**
   * Returns the value of the '<em><b>Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ref</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' attribute.
   * @see #setRef(String)
   * @see ewe.EwePackage#getVariableNestedElement_Ref()
   * @model
   * @generated
   */
  String getRef();

  /**
   * Sets the value of the '{@link ewe.VariableNestedElement#getRef <em>Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' attribute.
   * @see #getRef()
   * @generated
   */
  void setRef(String value);

  /**
   * Returns the value of the '<em><b>As</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>As</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>As</em>' attribute.
   * @see #setAs(String)
   * @see ewe.EwePackage#getVariableNestedElement_As()
   * @model
   * @generated
   */
  String getAs();

  /**
   * Sets the value of the '{@link ewe.VariableNestedElement#getAs <em>As</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>As</em>' attribute.
   * @see #getAs()
   * @generated
   */
  void setAs(String value);

  /**
   * Returns the value of the '<em><b>Optional</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Optional</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Optional</em>' attribute.
   * @see #setOptional(String)
   * @see ewe.EwePackage#getVariableNestedElement_Optional()
   * @model
   * @generated
   */
  String getOptional();

  /**
   * Sets the value of the '{@link ewe.VariableNestedElement#getOptional <em>Optional</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Optional</em>' attribute.
   * @see #getOptional()
   * @generated
   */
  void setOptional(String value);

} // VariableNestedElement
