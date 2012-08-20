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
 * A representation of the model object '<em><b>Model Nested Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ewe.ModelNestedElement#getRef <em>Ref</em>}</li>
 *   <li>{@link ewe.ModelNestedElement#getAs <em>As</em>}</li>
 * </ul>
 * </p>
 *
 * @see ewe.EwePackage#getModelNestedElement()
 * @model
 * @generated
 */
public interface ModelNestedElement extends EObject
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
   * @see ewe.EwePackage#getModelNestedElement_Ref()
   * @model
   * @generated
   */
  String getRef();

  /**
   * Sets the value of the '{@link ewe.ModelNestedElement#getRef <em>Ref</em>}' attribute.
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
   * @see ewe.EwePackage#getModelNestedElement_As()
   * @model
   * @generated
   */
  String getAs();

  /**
   * Sets the value of the '{@link ewe.ModelNestedElement#getAs <em>As</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>As</em>' attribute.
   * @see #getAs()
   * @generated
   */
  void setAs(String value);

} // ModelNestedElement
