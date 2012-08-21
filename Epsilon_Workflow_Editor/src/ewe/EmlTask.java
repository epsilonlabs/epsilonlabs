/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ewe;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Eml Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ewe.EmlTask#getUseMatchTrace <em>Use Match Trace</em>}</li>
 *   <li>{@link ewe.EmlTask#getExportTransformationTrace <em>Export Transformation Trace</em>}</li>
 *   <li>{@link ewe.EmlTask#getExportMergeTrace <em>Export Merge Trace</em>}</li>
 * </ul>
 * </p>
 *
 * @see ewe.EwePackage#getEmlTask()
 * @model annotation="gmf.node tool.name='EML Task'"
 * @generated
 */
public interface EmlTask extends ExecutableModelTask
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
   * @see ewe.EwePackage#getEmlTask_UseMatchTrace()
   * @model
   * @generated
   */
  String getUseMatchTrace();

  /**
   * Sets the value of the '{@link ewe.EmlTask#getUseMatchTrace <em>Use Match Trace</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Use Match Trace</em>' attribute.
   * @see #getUseMatchTrace()
   * @generated
   */
  void setUseMatchTrace(String value);

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
   * @see ewe.EwePackage#getEmlTask_ExportTransformationTrace()
   * @model
   * @generated
   */
  String getExportTransformationTrace();

  /**
   * Sets the value of the '{@link ewe.EmlTask#getExportTransformationTrace <em>Export Transformation Trace</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Export Transformation Trace</em>' attribute.
   * @see #getExportTransformationTrace()
   * @generated
   */
  void setExportTransformationTrace(String value);

  /**
   * Returns the value of the '<em><b>Export Merge Trace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Export Merge Trace</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Export Merge Trace</em>' attribute.
   * @see #setExportMergeTrace(String)
   * @see ewe.EwePackage#getEmlTask_ExportMergeTrace()
   * @model
   * @generated
   */
  String getExportMergeTrace();

  /**
   * Sets the value of the '{@link ewe.EmlTask#getExportMergeTrace <em>Export Merge Trace</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Export Merge Trace</em>' attribute.
   * @see #getExportMergeTrace()
   * @generated
   */
  void setExportMergeTrace(String value);

} // EmlTask
