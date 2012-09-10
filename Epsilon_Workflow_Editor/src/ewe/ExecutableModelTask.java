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
 * A representation of the model object '<em><b>Executable Model Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ewe.ExecutableModelTask#getSrc <em>Src</em>}</li>
 *   <li>{@link ewe.ExecutableModelTask#getExports <em>Exports</em>}</li>
 *   <li>{@link ewe.ExecutableModelTask#getUses <em>Uses</em>}</li>
 *   <li>{@link ewe.ExecutableModelTask#getModels <em>Models</em>}</li>
 * </ul>
 * </p>
 *
 * @see ewe.EwePackage#getExecutableModelTask()
 * @model abstract="true"
 *        annotation="gmf.node label='src'"
 * @generated
 */
public interface ExecutableModelTask extends EpsilonTask
{
  /**
   * Returns the value of the '<em><b>Src</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Src</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Src</em>' attribute.
   * @see #setSrc(String)
   * @see ewe.EwePackage#getExecutableModelTask_Src()
   * @model required="true"
   * @generated
   */
  String getSrc();

  /**
   * Sets the value of the '{@link ewe.ExecutableModelTask#getSrc <em>Src</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Src</em>' attribute.
   * @see #getSrc()
   * @generated
   */
  void setSrc(String value);

  /**
   * Returns the value of the '<em><b>Exports</b></em>' containment reference list.
   * The list contents are of type {@link ewe.ExportsNestedElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exports</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exports</em>' containment reference list.
   * @see ewe.EwePackage#getExecutableModelTask_Exports()
   * @model containment="true"
   * @generated
   */
  EList<ExportsNestedElement> getExports();

  /**
   * Returns the value of the '<em><b>Uses</b></em>' containment reference list.
   * The list contents are of type {@link ewe.UsesNestedElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Uses</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Uses</em>' containment reference list.
   * @see ewe.EwePackage#getExecutableModelTask_Uses()
   * @model containment="true"
   * @generated
   */
  EList<UsesNestedElement> getUses();

  /**
   * Returns the value of the '<em><b>Models</b></em>' containment reference list.
   * The list contents are of type {@link ewe.ModelNestedElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Models</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Models</em>' containment reference list.
   * @see ewe.EwePackage#getExecutableModelTask_Models()
   * @model containment="true"
   * @generated
   */
  EList<ModelNestedElement> getModels();

} // ExecutableModelTask
