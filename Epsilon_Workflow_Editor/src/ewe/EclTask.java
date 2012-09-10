/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ewe;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ecl Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ewe.EclTask#getUseMatchTrace <em>Use Match Trace</em>}</li>
 *   <li>{@link ewe.EclTask#getExportMatchTrace <em>Export Match Trace</em>}</li>
 * </ul>
 * </p>
 *
 * @see ewe.EwePackage#getEclTask()
 * @model annotation="gmf.node tool.name='ECL Task'"
 * @generated
 */
public interface EclTask extends ExecutableModelTask
{
  /**
   * Returns the value of the '<em><b>Use Match Trace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Use Match Trace</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Use Match Trace</em>' attribute.
   * @see #setUseMatchTrace(String)
   * @see ewe.EwePackage#getEclTask_UseMatchTrace()
   * @model
   * @generated
   */
  String getUseMatchTrace();

  /**
   * Sets the value of the '{@link ewe.EclTask#getUseMatchTrace <em>Use Match Trace</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Use Match Trace</em>' attribute.
   * @see #getUseMatchTrace()
   * @generated
   */
  void setUseMatchTrace(String value);

  /**
   * Returns the value of the '<em><b>Export Match Trace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Export Match Trace</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Export Match Trace</em>' attribute.
   * @see #setExportMatchTrace(String)
   * @see ewe.EwePackage#getEclTask_ExportMatchTrace()
   * @model
   * @generated
   */
  String getExportMatchTrace();

  /**
   * Sets the value of the '{@link ewe.EclTask#getExportMatchTrace <em>Export Match Trace</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Export Match Trace</em>' attribute.
   * @see #getExportMatchTrace()
   * @generated
   */
  void setExportMatchTrace(String value);

} // EclTask
