/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ewe.impl;

import ewe.EclTask;
import ewe.EwePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ecl Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ewe.impl.EclTaskImpl#getUseMatchTrace <em>Use Match Trace</em>}</li>
 *   <li>{@link ewe.impl.EclTaskImpl#getExportMatchTrace <em>Export Match Trace</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EclTaskImpl extends ExecutableModelTaskImpl implements EclTask
{
  /**
   * The default value of the '{@link #getUseMatchTrace() <em>Use Match Trace</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUseMatchTrace()
   * @generated
   * @ordered
   */
  protected static final String USE_MATCH_TRACE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getUseMatchTrace() <em>Use Match Trace</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUseMatchTrace()
   * @generated
   * @ordered
   */
  protected String useMatchTrace = USE_MATCH_TRACE_EDEFAULT;

  /**
   * The default value of the '{@link #getExportMatchTrace() <em>Export Match Trace</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExportMatchTrace()
   * @generated
   * @ordered
   */
  protected static final String EXPORT_MATCH_TRACE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getExportMatchTrace() <em>Export Match Trace</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExportMatchTrace()
   * @generated
   * @ordered
   */
  protected String exportMatchTrace = EXPORT_MATCH_TRACE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EclTaskImpl()
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
    return EwePackage.Literals.ECL_TASK;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getUseMatchTrace()
  {
    return useMatchTrace;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUseMatchTrace(String newUseMatchTrace)
  {
    String oldUseMatchTrace = useMatchTrace;
    useMatchTrace = newUseMatchTrace;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EwePackage.ECL_TASK__USE_MATCH_TRACE, oldUseMatchTrace, useMatchTrace));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getExportMatchTrace()
  {
    return exportMatchTrace;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExportMatchTrace(String newExportMatchTrace)
  {
    String oldExportMatchTrace = exportMatchTrace;
    exportMatchTrace = newExportMatchTrace;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EwePackage.ECL_TASK__EXPORT_MATCH_TRACE, oldExportMatchTrace, exportMatchTrace));
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
      case EwePackage.ECL_TASK__USE_MATCH_TRACE:
        return getUseMatchTrace();
      case EwePackage.ECL_TASK__EXPORT_MATCH_TRACE:
        return getExportMatchTrace();
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
      case EwePackage.ECL_TASK__USE_MATCH_TRACE:
        setUseMatchTrace((String)newValue);
        return;
      case EwePackage.ECL_TASK__EXPORT_MATCH_TRACE:
        setExportMatchTrace((String)newValue);
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
      case EwePackage.ECL_TASK__USE_MATCH_TRACE:
        setUseMatchTrace(USE_MATCH_TRACE_EDEFAULT);
        return;
      case EwePackage.ECL_TASK__EXPORT_MATCH_TRACE:
        setExportMatchTrace(EXPORT_MATCH_TRACE_EDEFAULT);
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
      case EwePackage.ECL_TASK__USE_MATCH_TRACE:
        return USE_MATCH_TRACE_EDEFAULT == null ? useMatchTrace != null : !USE_MATCH_TRACE_EDEFAULT.equals(useMatchTrace);
      case EwePackage.ECL_TASK__EXPORT_MATCH_TRACE:
        return EXPORT_MATCH_TRACE_EDEFAULT == null ? exportMatchTrace != null : !EXPORT_MATCH_TRACE_EDEFAULT.equals(exportMatchTrace);
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
    result.append(" (useMatchTrace: ");
    result.append(useMatchTrace);
    result.append(", exportMatchTrace: ");
    result.append(exportMatchTrace);
    result.append(')');
    return result.toString();
  }

} //EclTaskImpl
