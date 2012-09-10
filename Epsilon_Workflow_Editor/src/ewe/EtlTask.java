/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ewe;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Etl Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ewe.EtlTask#getExportTransformationTrace <em>Export Transformation Trace</em>}</li>
 * </ul>
 * </p>
 *
 * @see ewe.EwePackage#getEtlTask()
 * @model annotation="gmf.node tool.name='ETL Task'"
 * @generated
 */
public interface EtlTask extends ExecutableModelTask
{
  /**
   * Returns the value of the '<em><b>Export Transformation Trace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Export Transformation Trace</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Export Transformation Trace</em>' attribute.
   * @see #setExportTransformationTrace(String)
   * @see ewe.EwePackage#getEtlTask_ExportTransformationTrace()
   * @model
   * @generated
   */
  String getExportTransformationTrace();

  /**
   * Sets the value of the '{@link ewe.EtlTask#getExportTransformationTrace <em>Export Transformation Trace</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Export Transformation Trace</em>' attribute.
   * @see #getExportTransformationTrace()
   * @generated
   */
  void setExportTransformationTrace(String value);

} // EtlTask
