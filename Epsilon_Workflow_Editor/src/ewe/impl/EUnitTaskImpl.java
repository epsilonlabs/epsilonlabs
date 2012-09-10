/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ewe.impl;

import ewe.EUnitTask;
import ewe.EwePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EUnit Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ewe.impl.EUnitTaskImpl#isFailOnErrors <em>Fail On Errors</em>}</li>
 *   <li>{@link ewe.impl.EUnitTaskImpl#getReport <em>Report</em>}</li>
 *   <li>{@link ewe.impl.EUnitTaskImpl#getToDir <em>To Dir</em>}</li>
 *   <li>{@link ewe.impl.EUnitTaskImpl#getPackage <em>Package</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EUnitTaskImpl extends ExecutableModelTaskImpl implements EUnitTask
{
  /**
   * The default value of the '{@link #isFailOnErrors() <em>Fail On Errors</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isFailOnErrors()
   * @generated
   * @ordered
   */
  protected static final boolean FAIL_ON_ERRORS_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isFailOnErrors() <em>Fail On Errors</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isFailOnErrors()
   * @generated
   * @ordered
   */
  protected boolean failOnErrors = FAIL_ON_ERRORS_EDEFAULT;

  /**
   * The default value of the '{@link #getReport() <em>Report</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReport()
   * @generated
   * @ordered
   */
  protected static final String REPORT_EDEFAULT = "no";

  /**
   * The cached value of the '{@link #getReport() <em>Report</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReport()
   * @generated
   * @ordered
   */
  protected String report = REPORT_EDEFAULT;

  /**
   * The default value of the '{@link #getToDir() <em>To Dir</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getToDir()
   * @generated
   * @ordered
   */
  protected static final String TO_DIR_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getToDir() <em>To Dir</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getToDir()
   * @generated
   * @ordered
   */
  protected String toDir = TO_DIR_EDEFAULT;

  /**
   * The default value of the '{@link #getPackage() <em>Package</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPackage()
   * @generated
   * @ordered
   */
  protected static final String PACKAGE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPackage() <em>Package</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPackage()
   * @generated
   * @ordered
   */
  protected String package_ = PACKAGE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EUnitTaskImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return EwePackage.Literals.EUNIT_TASK;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isFailOnErrors()
  {
    return failOnErrors;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFailOnErrors(boolean newFailOnErrors)
  {
    boolean oldFailOnErrors = failOnErrors;
    failOnErrors = newFailOnErrors;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EwePackage.EUNIT_TASK__FAIL_ON_ERRORS, oldFailOnErrors, failOnErrors));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getReport()
  {
    return report;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReport(String newReport)
  {
    String oldReport = report;
    report = newReport;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EwePackage.EUNIT_TASK__REPORT, oldReport, report));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getToDir()
  {
    return toDir;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setToDir(String newToDir)
  {
    String oldToDir = toDir;
    toDir = newToDir;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EwePackage.EUNIT_TASK__TO_DIR, oldToDir, toDir));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPackage()
  {
    return package_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPackage(String newPackage)
  {
    String oldPackage = package_;
    package_ = newPackage;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EwePackage.EUNIT_TASK__PACKAGE, oldPackage, package_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case EwePackage.EUNIT_TASK__FAIL_ON_ERRORS:
        return isFailOnErrors();
      case EwePackage.EUNIT_TASK__REPORT:
        return getReport();
      case EwePackage.EUNIT_TASK__TO_DIR:
        return getToDir();
      case EwePackage.EUNIT_TASK__PACKAGE:
        return getPackage();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case EwePackage.EUNIT_TASK__FAIL_ON_ERRORS:
        setFailOnErrors((Boolean)newValue);
        return;
      case EwePackage.EUNIT_TASK__REPORT:
        setReport((String)newValue);
        return;
      case EwePackage.EUNIT_TASK__TO_DIR:
        setToDir((String)newValue);
        return;
      case EwePackage.EUNIT_TASK__PACKAGE:
        setPackage((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case EwePackage.EUNIT_TASK__FAIL_ON_ERRORS:
        setFailOnErrors(FAIL_ON_ERRORS_EDEFAULT);
        return;
      case EwePackage.EUNIT_TASK__REPORT:
        setReport(REPORT_EDEFAULT);
        return;
      case EwePackage.EUNIT_TASK__TO_DIR:
        setToDir(TO_DIR_EDEFAULT);
        return;
      case EwePackage.EUNIT_TASK__PACKAGE:
        setPackage(PACKAGE_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case EwePackage.EUNIT_TASK__FAIL_ON_ERRORS:
        return failOnErrors != FAIL_ON_ERRORS_EDEFAULT;
      case EwePackage.EUNIT_TASK__REPORT:
        return REPORT_EDEFAULT == null ? report != null : !REPORT_EDEFAULT.equals(report);
      case EwePackage.EUNIT_TASK__TO_DIR:
        return TO_DIR_EDEFAULT == null ? toDir != null : !TO_DIR_EDEFAULT.equals(toDir);
      case EwePackage.EUNIT_TASK__PACKAGE:
        return PACKAGE_EDEFAULT == null ? package_ != null : !PACKAGE_EDEFAULT.equals(package_);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (failOnErrors: ");
    result.append(failOnErrors);
    result.append(", report: ");
    result.append(report);
    result.append(", toDir: ");
    result.append(toDir);
    result.append(", package: ");
    result.append(package_);
    result.append(')');
    return result.toString();
  }

} //EUnitTaskImpl
