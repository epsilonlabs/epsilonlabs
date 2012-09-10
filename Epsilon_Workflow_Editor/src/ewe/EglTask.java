/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ewe;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Egl Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ewe.EglTask#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see ewe.EwePackage#getEglTask()
 * @model annotation="gmf.node tool.name='EGL Task'"
 * @generated
 */
public interface EglTask extends ExecutableModelTask
{
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
   * @see ewe.EwePackage#getEglTask_Target()
   * @model required="true"
   * @generated
   */
  String getTarget();

  /**
   * Sets the value of the '{@link ewe.EglTask#getTarget <em>Target</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' attribute.
   * @see #getTarget()
   * @generated
   */
  void setTarget(String value);

} // EglTask
