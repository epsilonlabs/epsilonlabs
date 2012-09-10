/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ewe.impl;

import ewe.EwePackage;
import ewe.FlockTask;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Flock Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ewe.impl.FlockTaskImpl#getOriginalModel <em>Original Model</em>}</li>
 *   <li>{@link ewe.impl.FlockTaskImpl#getMigratedModel <em>Migrated Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FlockTaskImpl extends ExecutableModelTaskImpl implements FlockTask
{
  /**
   * The default value of the '{@link #getOriginalModel() <em>Original Model</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOriginalModel()
   * @generated
   * @ordered
   */
  protected static final String ORIGINAL_MODEL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOriginalModel() <em>Original Model</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOriginalModel()
   * @generated
   * @ordered
   */
  protected String originalModel = ORIGINAL_MODEL_EDEFAULT;

  /**
   * The default value of the '{@link #getMigratedModel() <em>Migrated Model</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMigratedModel()
   * @generated
   * @ordered
   */
  protected static final String MIGRATED_MODEL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getMigratedModel() <em>Migrated Model</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMigratedModel()
   * @generated
   * @ordered
   */
  protected String migratedModel = MIGRATED_MODEL_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FlockTaskImpl()
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
    return EwePackage.Literals.FLOCK_TASK;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getOriginalModel()
  {
    return originalModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOriginalModel(String newOriginalModel)
  {
    String oldOriginalModel = originalModel;
    originalModel = newOriginalModel;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EwePackage.FLOCK_TASK__ORIGINAL_MODEL, oldOriginalModel, originalModel));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getMigratedModel()
  {
    return migratedModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMigratedModel(String newMigratedModel)
  {
    String oldMigratedModel = migratedModel;
    migratedModel = newMigratedModel;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EwePackage.FLOCK_TASK__MIGRATED_MODEL, oldMigratedModel, migratedModel));
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
      case EwePackage.FLOCK_TASK__ORIGINAL_MODEL:
        return getOriginalModel();
      case EwePackage.FLOCK_TASK__MIGRATED_MODEL:
        return getMigratedModel();
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
      case EwePackage.FLOCK_TASK__ORIGINAL_MODEL:
        setOriginalModel((String)newValue);
        return;
      case EwePackage.FLOCK_TASK__MIGRATED_MODEL:
        setMigratedModel((String)newValue);
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
      case EwePackage.FLOCK_TASK__ORIGINAL_MODEL:
        setOriginalModel(ORIGINAL_MODEL_EDEFAULT);
        return;
      case EwePackage.FLOCK_TASK__MIGRATED_MODEL:
        setMigratedModel(MIGRATED_MODEL_EDEFAULT);
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
      case EwePackage.FLOCK_TASK__ORIGINAL_MODEL:
        return ORIGINAL_MODEL_EDEFAULT == null ? originalModel != null : !ORIGINAL_MODEL_EDEFAULT.equals(originalModel);
      case EwePackage.FLOCK_TASK__MIGRATED_MODEL:
        return MIGRATED_MODEL_EDEFAULT == null ? migratedModel != null : !MIGRATED_MODEL_EDEFAULT.equals(migratedModel);
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
    result.append(" (originalModel: ");
    result.append(originalModel);
    result.append(", migratedModel: ");
    result.append(migratedModel);
    result.append(')');
    return result.toString();
  }

} //FlockTaskImpl
