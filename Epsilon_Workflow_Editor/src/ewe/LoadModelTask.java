/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ewe;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Load Model Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ewe.LoadModelTask#getParameters <em>Parameters</em>}</li>
 *   <li>{@link ewe.LoadModelTask#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see ewe.EwePackage#getLoadModelTask()
 * @model annotation="gmf.node tool.name='Load Model Task'"
 * @generated
 */
public interface LoadModelTask extends EpsilonTask
{
  /**
   * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
   * The list contents are of type {@link ewe.ParameterNestedElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameters</em>' containment reference list.
   * @see ewe.EwePackage#getLoadModelTask_Parameters()
   * @model containment="true"
   * @generated
   */
  EList<ParameterNestedElement> getParameters();

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
   * @see ewe.EwePackage#getLoadModelTask_Type()
   * @model
   * @generated
   */
  String getType();

  /**
   * Sets the value of the '{@link ewe.LoadModelTask#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see #getType()
   * @generated
   */
  void setType(String value);

} // LoadModelTask
