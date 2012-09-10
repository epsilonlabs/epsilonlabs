/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ewe;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Flock Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ewe.FlockTask#getOriginalModel <em>Original Model</em>}</li>
 *   <li>{@link ewe.FlockTask#getMigratedModel <em>Migrated Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see ewe.EwePackage#getFlockTask()
 * @model annotation="gmf.node tool.name='Flock Task'"
 * @generated
 */
public interface FlockTask extends ExecutableModelTask
{
  /**
   * Returns the value of the '<em><b>Original Model</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Original Model</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Original Model</em>' attribute.
   * @see #setOriginalModel(String)
   * @see ewe.EwePackage#getFlockTask_OriginalModel()
   * @model
   * @generated
   */
  String getOriginalModel();

  /**
   * Sets the value of the '{@link ewe.FlockTask#getOriginalModel <em>Original Model</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Original Model</em>' attribute.
   * @see #getOriginalModel()
   * @generated
   */
  void setOriginalModel(String value);

  /**
   * Returns the value of the '<em><b>Migrated Model</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Migrated Model</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Migrated Model</em>' attribute.
   * @see #setMigratedModel(String)
   * @see ewe.EwePackage#getFlockTask_MigratedModel()
   * @model
   * @generated
   */
  String getMigratedModel();

  /**
   * Sets the value of the '{@link ewe.FlockTask#getMigratedModel <em>Migrated Model</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Migrated Model</em>' attribute.
   * @see #getMigratedModel()
   * @generated
   */
  void setMigratedModel(String value);

} // FlockTask
