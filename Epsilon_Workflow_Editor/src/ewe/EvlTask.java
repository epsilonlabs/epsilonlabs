/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ewe;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Evl Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ewe.EvlTask#isFailOnErrors <em>Fail On Errors</em>}</li>
 *   <li>{@link ewe.EvlTask#isFailOnWarnings <em>Fail On Warnings</em>}</li>
 *   <li>{@link ewe.EvlTask#isExportAsModel <em>Export As Model</em>}</li>
 *   <li>{@link ewe.EvlTask#getExportConstraintTrace <em>Export Constraint Trace</em>}</li>
 * </ul>
 * </p>
 *
 * @see ewe.EwePackage#getEvlTask()
 * @model annotation="gmf.node tool.name='EVL Task'"
 * @generated
 */
public interface EvlTask extends ExecutableModelTask
{
  /**
   * Returns the value of the '<em><b>Fail On Errors</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fail On Errors</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fail On Errors</em>' attribute.
   * @see #setFailOnErrors(boolean)
   * @see ewe.EwePackage#getEvlTask_FailOnErrors()
   * @model
   * @generated
   */
  boolean isFailOnErrors();

  /**
   * Sets the value of the '{@link ewe.EvlTask#isFailOnErrors <em>Fail On Errors</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fail On Errors</em>' attribute.
   * @see #isFailOnErrors()
   * @generated
   */
  void setFailOnErrors(boolean value);

  /**
   * Returns the value of the '<em><b>Fail On Warnings</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fail On Warnings</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fail On Warnings</em>' attribute.
   * @see #setFailOnWarnings(boolean)
   * @see ewe.EwePackage#getEvlTask_FailOnWarnings()
   * @model
   * @generated
   */
  boolean isFailOnWarnings();

  /**
   * Sets the value of the '{@link ewe.EvlTask#isFailOnWarnings <em>Fail On Warnings</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fail On Warnings</em>' attribute.
   * @see #isFailOnWarnings()
   * @generated
   */
  void setFailOnWarnings(boolean value);

  /**
   * Returns the value of the '<em><b>Export As Model</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Export As Model</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Export As Model</em>' attribute.
   * @see #setExportAsModel(boolean)
   * @see ewe.EwePackage#getEvlTask_ExportAsModel()
   * @model
   * @generated
   */
  boolean isExportAsModel();

  /**
   * Sets the value of the '{@link ewe.EvlTask#isExportAsModel <em>Export As Model</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Export As Model</em>' attribute.
   * @see #isExportAsModel()
   * @generated
   */
  void setExportAsModel(boolean value);

  /**
   * Returns the value of the '<em><b>Export Constraint Trace</b></em>' attribute.
   * The default value is <code>""</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Export Constraint Trace</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Export Constraint Trace</em>' attribute.
   * @see #setExportConstraintTrace(String)
   * @see ewe.EwePackage#getEvlTask_ExportConstraintTrace()
   * @model default=""
   * @generated
   */
  String getExportConstraintTrace();

  /**
   * Sets the value of the '{@link ewe.EvlTask#getExportConstraintTrace <em>Export Constraint Trace</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Export Constraint Trace</em>' attribute.
   * @see #getExportConstraintTrace()
   * @generated
   */
  void setExportConstraintTrace(String value);

} // EvlTask
