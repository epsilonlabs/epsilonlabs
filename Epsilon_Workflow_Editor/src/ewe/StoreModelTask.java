/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ewe;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Store Model Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ewe.StoreModelTask#getModel <em>Model</em>}</li>
 *   <li>{@link ewe.StoreModelTask#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see ewe.EwePackage#getStoreModelTask()
 * @model annotation="gmf.node tool.name='Store Model Task'"
 * @generated
 */
public interface StoreModelTask extends EpsilonTask
{
  /**
   * Returns the value of the '<em><b>Model</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Model</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Model</em>' attribute.
   * @see #setModel(String)
   * @see ewe.EwePackage#getStoreModelTask_Model()
   * @model
   * @generated
   */
  String getModel();

  /**
   * Sets the value of the '{@link ewe.StoreModelTask#getModel <em>Model</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Model</em>' attribute.
   * @see #getModel()
   * @generated
   */
  void setModel(String value);

  /**
   * Returns the value of the '<em><b>Target</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' attribute.
   * @see #setTarget(String)
   * @see ewe.EwePackage#getStoreModelTask_Target()
   * @model
   * @generated
   */
  String getTarget();

  /**
   * Sets the value of the '{@link ewe.StoreModelTask#getTarget <em>Target</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' attribute.
   * @see #getTarget()
   * @generated
   */
  void setTarget(String value);

} // StoreModelTask
