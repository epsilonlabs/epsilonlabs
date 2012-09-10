/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ewe;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EUnit Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ewe.EUnitTask#isFailOnErrors <em>Fail On Errors</em>}</li>
 *   <li>{@link ewe.EUnitTask#getReport <em>Report</em>}</li>
 *   <li>{@link ewe.EUnitTask#getToDir <em>To Dir</em>}</li>
 *   <li>{@link ewe.EUnitTask#getPackage <em>Package</em>}</li>
 * </ul>
 * </p>
 *
 * @see ewe.EwePackage#getEUnitTask()
 * @model annotation="gmf.node tool.name='EUnit Task'"
 * @generated
 */
public interface EUnitTask extends ExecutableModelTask
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
   * @see ewe.EwePackage#getEUnitTask_FailOnErrors()
   * @model
   * @generated
   */
  boolean isFailOnErrors();

  /**
   * Sets the value of the '{@link ewe.EUnitTask#isFailOnErrors <em>Fail On Errors</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fail On Errors</em>' attribute.
   * @see #isFailOnErrors()
   * @generated
   */
  void setFailOnErrors(boolean value);

  /**
   * Returns the value of the '<em><b>Report</b></em>' attribute.
   * The default value is <code>"no"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Report</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Report</em>' attribute.
   * @see #setReport(String)
   * @see ewe.EwePackage#getEUnitTask_Report()
   * @model default="no"
   * @generated
   */
  String getReport();

  /**
   * Sets the value of the '{@link ewe.EUnitTask#getReport <em>Report</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Report</em>' attribute.
   * @see #getReport()
   * @generated
   */
  void setReport(String value);

  /**
   * Returns the value of the '<em><b>To Dir</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>To Dir</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>To Dir</em>' attribute.
   * @see #setToDir(String)
   * @see ewe.EwePackage#getEUnitTask_ToDir()
   * @model
   * @generated
   */
  String getToDir();

  /**
   * Sets the value of the '{@link ewe.EUnitTask#getToDir <em>To Dir</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>To Dir</em>' attribute.
   * @see #getToDir()
   * @generated
   */
  void setToDir(String value);

  /**
   * Returns the value of the '<em><b>Package</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Package</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Package</em>' attribute.
   * @see #setPackage(String)
   * @see ewe.EwePackage#getEUnitTask_Package()
   * @model
   * @generated
   */
  String getPackage();

  /**
   * Sets the value of the '{@link ewe.EUnitTask#getPackage <em>Package</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Package</em>' attribute.
   * @see #getPackage()
   * @generated
   */
  void setPackage(String value);

} // EUnitTask
