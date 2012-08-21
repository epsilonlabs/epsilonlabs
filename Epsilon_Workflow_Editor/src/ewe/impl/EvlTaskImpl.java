/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ewe.impl;

import ewe.EvlTask;
import ewe.EwePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Evl Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ewe.impl.EvlTaskImpl#isFailOnErrors <em>Fail On Errors</em>}</li>
 *   <li>{@link ewe.impl.EvlTaskImpl#isFailOnWarnings <em>Fail On Warnings</em>}</li>
 *   <li>{@link ewe.impl.EvlTaskImpl#isExportAsModel <em>Export As Model</em>}</li>
 *   <li>{@link ewe.impl.EvlTaskImpl#getExportConstraintTrace <em>Export Constraint Trace</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EvlTaskImpl extends ExecutableModelTaskImpl implements EvlTask
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
   * The default value of the '{@link #isFailOnWarnings() <em>Fail On Warnings</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isFailOnWarnings()
   * @generated
   * @ordered
   */
  protected static final boolean FAIL_ON_WARNINGS_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isFailOnWarnings() <em>Fail On Warnings</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isFailOnWarnings()
   * @generated
   * @ordered
   */
  protected boolean failOnWarnings = FAIL_ON_WARNINGS_EDEFAULT;

  /**
   * The default value of the '{@link #isExportAsModel() <em>Export As Model</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isExportAsModel()
   * @generated
   * @ordered
   */
  protected static final boolean EXPORT_AS_MODEL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isExportAsModel() <em>Export As Model</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isExportAsModel()
   * @generated
   * @ordered
   */
  protected boolean exportAsModel = EXPORT_AS_MODEL_EDEFAULT;

  /**
   * The default value of the '{@link #getExportConstraintTrace() <em>Export Constraint Trace</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExportConstraintTrace()
   * @generated
   * @ordered
   */
  protected static final String EXPORT_CONSTRAINT_TRACE_EDEFAULT = "";

  /**
   * The cached value of the '{@link #getExportConstraintTrace() <em>Export Constraint Trace</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExportConstraintTrace()
   * @generated
   * @ordered
   */
  protected String exportConstraintTrace = EXPORT_CONSTRAINT_TRACE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EvlTaskImpl()
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
    return EwePackage.Literals.EVL_TASK;
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
      eNotify(new ENotificationImpl(this, Notification.SET, EwePackage.EVL_TASK__FAIL_ON_ERRORS, oldFailOnErrors, failOnErrors));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isFailOnWarnings()
  {
    return failOnWarnings;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFailOnWarnings(boolean newFailOnWarnings)
  {
    boolean oldFailOnWarnings = failOnWarnings;
    failOnWarnings = newFailOnWarnings;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EwePackage.EVL_TASK__FAIL_ON_WARNINGS, oldFailOnWarnings, failOnWarnings));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isExportAsModel()
  {
    return exportAsModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExportAsModel(boolean newExportAsModel)
  {
    boolean oldExportAsModel = exportAsModel;
    exportAsModel = newExportAsModel;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EwePackage.EVL_TASK__EXPORT_AS_MODEL, oldExportAsModel, exportAsModel));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getExportConstraintTrace()
  {
    return exportConstraintTrace;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExportConstraintTrace(String newExportConstraintTrace)
  {
    String oldExportConstraintTrace = exportConstraintTrace;
    exportConstraintTrace = newExportConstraintTrace;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EwePackage.EVL_TASK__EXPORT_CONSTRAINT_TRACE, oldExportConstraintTrace, exportConstraintTrace));
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
      case EwePackage.EVL_TASK__FAIL_ON_ERRORS:
        return isFailOnErrors();
      case EwePackage.EVL_TASK__FAIL_ON_WARNINGS:
        return isFailOnWarnings();
      case EwePackage.EVL_TASK__EXPORT_AS_MODEL:
        return isExportAsModel();
      case EwePackage.EVL_TASK__EXPORT_CONSTRAINT_TRACE:
        return getExportConstraintTrace();
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
      case EwePackage.EVL_TASK__FAIL_ON_ERRORS:
        setFailOnErrors((Boolean)newValue);
        return;
      case EwePackage.EVL_TASK__FAIL_ON_WARNINGS:
        setFailOnWarnings((Boolean)newValue);
        return;
      case EwePackage.EVL_TASK__EXPORT_AS_MODEL:
        setExportAsModel((Boolean)newValue);
        return;
      case EwePackage.EVL_TASK__EXPORT_CONSTRAINT_TRACE:
        setExportConstraintTrace((String)newValue);
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
      case EwePackage.EVL_TASK__FAIL_ON_ERRORS:
        setFailOnErrors(FAIL_ON_ERRORS_EDEFAULT);
        return;
      case EwePackage.EVL_TASK__FAIL_ON_WARNINGS:
        setFailOnWarnings(FAIL_ON_WARNINGS_EDEFAULT);
        return;
      case EwePackage.EVL_TASK__EXPORT_AS_MODEL:
        setExportAsModel(EXPORT_AS_MODEL_EDEFAULT);
        return;
      case EwePackage.EVL_TASK__EXPORT_CONSTRAINT_TRACE:
        setExportConstraintTrace(EXPORT_CONSTRAINT_TRACE_EDEFAULT);
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
      case EwePackage.EVL_TASK__FAIL_ON_ERRORS:
        return failOnErrors != FAIL_ON_ERRORS_EDEFAULT;
      case EwePackage.EVL_TASK__FAIL_ON_WARNINGS:
        return failOnWarnings != FAIL_ON_WARNINGS_EDEFAULT;
      case EwePackage.EVL_TASK__EXPORT_AS_MODEL:
        return exportAsModel != EXPORT_AS_MODEL_EDEFAULT;
      case EwePackage.EVL_TASK__EXPORT_CONSTRAINT_TRACE:
        return EXPORT_CONSTRAINT_TRACE_EDEFAULT == null ? exportConstraintTrace != null : !EXPORT_CONSTRAINT_TRACE_EDEFAULT.equals(exportConstraintTrace);
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
    result.append(", failOnWarnings: ");
    result.append(failOnWarnings);
    result.append(", exportAsModel: ");
    result.append(exportAsModel);
    result.append(", exportConstraintTrace: ");
    result.append(exportConstraintTrace);
    result.append(')');
    return result.toString();
  }

} //EvlTaskImpl
