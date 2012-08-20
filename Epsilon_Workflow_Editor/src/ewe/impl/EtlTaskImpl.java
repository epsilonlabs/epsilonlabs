/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ewe.impl;

import ewe.EtlTask;
import ewe.EwePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Etl Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ewe.impl.EtlTaskImpl#getExportTransformationTrace <em>Export Transformation Trace</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EtlTaskImpl extends ExecutableModelTaskImpl implements EtlTask
{
  /**
   * The default value of the '{@link #getExportTransformationTrace() <em>Export Transformation Trace</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExportTransformationTrace()
   * @generated
   * @ordered
   */
  protected static final String EXPORT_TRANSFORMATION_TRACE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getExportTransformationTrace() <em>Export Transformation Trace</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExportTransformationTrace()
   * @generated
   * @ordered
   */
  protected String exportTransformationTrace = EXPORT_TRANSFORMATION_TRACE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EtlTaskImpl()
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
    return EwePackage.Literals.ETL_TASK;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getExportTransformationTrace()
  {
    return exportTransformationTrace;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExportTransformationTrace(String newExportTransformationTrace)
  {
    String oldExportTransformationTrace = exportTransformationTrace;
    exportTransformationTrace = newExportTransformationTrace;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EwePackage.ETL_TASK__EXPORT_TRANSFORMATION_TRACE, oldExportTransformationTrace, exportTransformationTrace));
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
      case EwePackage.ETL_TASK__EXPORT_TRANSFORMATION_TRACE:
        return getExportTransformationTrace();
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
      case EwePackage.ETL_TASK__EXPORT_TRANSFORMATION_TRACE:
        setExportTransformationTrace((String)newValue);
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
      case EwePackage.ETL_TASK__EXPORT_TRANSFORMATION_TRACE:
        setExportTransformationTrace(EXPORT_TRANSFORMATION_TRACE_EDEFAULT);
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
      case EwePackage.ETL_TASK__EXPORT_TRANSFORMATION_TRACE:
        return EXPORT_TRANSFORMATION_TRACE_EDEFAULT == null ? exportTransformationTrace != null : !EXPORT_TRANSFORMATION_TRACE_EDEFAULT.equals(exportTransformationTrace);
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
    result.append(" (exportTransformationTrace: ");
    result.append(exportTransformationTrace);
    result.append(')');
    return result.toString();
  }

} //EtlTaskImpl
