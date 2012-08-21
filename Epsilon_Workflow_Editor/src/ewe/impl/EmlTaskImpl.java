/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ewe.impl;

import ewe.EmlTask;
import ewe.EwePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Eml Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ewe.impl.EmlTaskImpl#getUseMatchTrace <em>Use Match Trace</em>}</li>
 *   <li>{@link ewe.impl.EmlTaskImpl#getExportTransformationTrace <em>Export Transformation Trace</em>}</li>
 *   <li>{@link ewe.impl.EmlTaskImpl#getExportMergeTrace <em>Export Merge Trace</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EmlTaskImpl extends ExecutableModelTaskImpl implements EmlTask
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
   * The default value of the '{@link #getExportMergeTrace() <em>Export Merge Trace</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExportMergeTrace()
   * @generated
   * @ordered
   */
  protected static final String EXPORT_MERGE_TRACE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getExportMergeTrace() <em>Export Merge Trace</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExportMergeTrace()
   * @generated
   * @ordered
   */
  protected String exportMergeTrace = EXPORT_MERGE_TRACE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EmlTaskImpl()
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
    return EwePackage.Literals.EML_TASK;
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
      eNotify(new ENotificationImpl(this, Notification.SET, EwePackage.EML_TASK__USE_MATCH_TRACE, oldUseMatchTrace, useMatchTrace));
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
      eNotify(new ENotificationImpl(this, Notification.SET, EwePackage.EML_TASK__EXPORT_TRANSFORMATION_TRACE, oldExportTransformationTrace, exportTransformationTrace));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getExportMergeTrace()
  {
    return exportMergeTrace;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExportMergeTrace(String newExportMergeTrace)
  {
    String oldExportMergeTrace = exportMergeTrace;
    exportMergeTrace = newExportMergeTrace;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EwePackage.EML_TASK__EXPORT_MERGE_TRACE, oldExportMergeTrace, exportMergeTrace));
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
      case EwePackage.EML_TASK__USE_MATCH_TRACE:
        return getUseMatchTrace();
      case EwePackage.EML_TASK__EXPORT_TRANSFORMATION_TRACE:
        return getExportTransformationTrace();
      case EwePackage.EML_TASK__EXPORT_MERGE_TRACE:
        return getExportMergeTrace();
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
      case EwePackage.EML_TASK__USE_MATCH_TRACE:
        setUseMatchTrace((String)newValue);
        return;
      case EwePackage.EML_TASK__EXPORT_TRANSFORMATION_TRACE:
        setExportTransformationTrace((String)newValue);
        return;
      case EwePackage.EML_TASK__EXPORT_MERGE_TRACE:
        setExportMergeTrace((String)newValue);
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
      case EwePackage.EML_TASK__USE_MATCH_TRACE:
        setUseMatchTrace(USE_MATCH_TRACE_EDEFAULT);
        return;
      case EwePackage.EML_TASK__EXPORT_TRANSFORMATION_TRACE:
        setExportTransformationTrace(EXPORT_TRANSFORMATION_TRACE_EDEFAULT);
        return;
      case EwePackage.EML_TASK__EXPORT_MERGE_TRACE:
        setExportMergeTrace(EXPORT_MERGE_TRACE_EDEFAULT);
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
      case EwePackage.EML_TASK__USE_MATCH_TRACE:
        return USE_MATCH_TRACE_EDEFAULT == null ? useMatchTrace != null : !USE_MATCH_TRACE_EDEFAULT.equals(useMatchTrace);
      case EwePackage.EML_TASK__EXPORT_TRANSFORMATION_TRACE:
        return EXPORT_TRANSFORMATION_TRACE_EDEFAULT == null ? exportTransformationTrace != null : !EXPORT_TRANSFORMATION_TRACE_EDEFAULT.equals(exportTransformationTrace);
      case EwePackage.EML_TASK__EXPORT_MERGE_TRACE:
        return EXPORT_MERGE_TRACE_EDEFAULT == null ? exportMergeTrace != null : !EXPORT_MERGE_TRACE_EDEFAULT.equals(exportMergeTrace);
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
    result.append(", exportTransformationTrace: ");
    result.append(exportTransformationTrace);
    result.append(", exportMergeTrace: ");
    result.append(exportMergeTrace);
    result.append(')');
    return result.toString();
  }

} //EmlTaskImpl
