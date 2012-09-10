/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ewe.impl;

import ewe.EwePackage;
import ewe.ExecutableModelTask;
import ewe.ExportsNestedElement;
import ewe.ModelNestedElement;
import ewe.UsesNestedElement;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Executable Model Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ewe.impl.ExecutableModelTaskImpl#getSrc <em>Src</em>}</li>
 *   <li>{@link ewe.impl.ExecutableModelTaskImpl#getExports <em>Exports</em>}</li>
 *   <li>{@link ewe.impl.ExecutableModelTaskImpl#getUses <em>Uses</em>}</li>
 *   <li>{@link ewe.impl.ExecutableModelTaskImpl#getModels <em>Models</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ExecutableModelTaskImpl extends EpsilonTaskImpl implements ExecutableModelTask
{
  /**
   * The default value of the '{@link #getSrc() <em>Src</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSrc()
   * @generated
   * @ordered
   */
  protected static final String SRC_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSrc() <em>Src</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSrc()
   * @generated
   * @ordered
   */
  protected String src = SRC_EDEFAULT;

  /**
   * The cached value of the '{@link #getExports() <em>Exports</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExports()
   * @generated
   * @ordered
   */
  protected EList<ExportsNestedElement> exports;

  /**
   * The cached value of the '{@link #getUses() <em>Uses</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUses()
   * @generated
   * @ordered
   */
  protected EList<UsesNestedElement> uses;

  /**
   * The cached value of the '{@link #getModels() <em>Models</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModels()
   * @generated
   * @ordered
   */
  protected EList<ModelNestedElement> models;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExecutableModelTaskImpl()
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
    return EwePackage.Literals.EXECUTABLE_MODEL_TASK;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getSrc()
  {
    return src;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSrc(String newSrc)
  {
    String oldSrc = src;
    src = newSrc;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EwePackage.EXECUTABLE_MODEL_TASK__SRC, oldSrc, src));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ExportsNestedElement> getExports()
  {
    if (exports == null)
    {
      exports = new EObjectContainmentEList<ExportsNestedElement>(ExportsNestedElement.class, this, EwePackage.EXECUTABLE_MODEL_TASK__EXPORTS);
    }
    return exports;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UsesNestedElement> getUses()
  {
    if (uses == null)
    {
      uses = new EObjectContainmentEList<UsesNestedElement>(UsesNestedElement.class, this, EwePackage.EXECUTABLE_MODEL_TASK__USES);
    }
    return uses;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ModelNestedElement> getModels()
  {
    if (models == null)
    {
      models = new EObjectContainmentEList<ModelNestedElement>(ModelNestedElement.class, this, EwePackage.EXECUTABLE_MODEL_TASK__MODELS);
    }
    return models;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case EwePackage.EXECUTABLE_MODEL_TASK__EXPORTS:
        return ((InternalEList<?>)getExports()).basicRemove(otherEnd, msgs);
      case EwePackage.EXECUTABLE_MODEL_TASK__USES:
        return ((InternalEList<?>)getUses()).basicRemove(otherEnd, msgs);
      case EwePackage.EXECUTABLE_MODEL_TASK__MODELS:
        return ((InternalEList<?>)getModels()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case EwePackage.EXECUTABLE_MODEL_TASK__SRC:
        return getSrc();
      case EwePackage.EXECUTABLE_MODEL_TASK__EXPORTS:
        return getExports();
      case EwePackage.EXECUTABLE_MODEL_TASK__USES:
        return getUses();
      case EwePackage.EXECUTABLE_MODEL_TASK__MODELS:
        return getModels();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case EwePackage.EXECUTABLE_MODEL_TASK__SRC:
        setSrc((String)newValue);
        return;
      case EwePackage.EXECUTABLE_MODEL_TASK__EXPORTS:
        getExports().clear();
        getExports().addAll((Collection<? extends ExportsNestedElement>)newValue);
        return;
      case EwePackage.EXECUTABLE_MODEL_TASK__USES:
        getUses().clear();
        getUses().addAll((Collection<? extends UsesNestedElement>)newValue);
        return;
      case EwePackage.EXECUTABLE_MODEL_TASK__MODELS:
        getModels().clear();
        getModels().addAll((Collection<? extends ModelNestedElement>)newValue);
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
      case EwePackage.EXECUTABLE_MODEL_TASK__SRC:
        setSrc(SRC_EDEFAULT);
        return;
      case EwePackage.EXECUTABLE_MODEL_TASK__EXPORTS:
        getExports().clear();
        return;
      case EwePackage.EXECUTABLE_MODEL_TASK__USES:
        getUses().clear();
        return;
      case EwePackage.EXECUTABLE_MODEL_TASK__MODELS:
        getModels().clear();
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
      case EwePackage.EXECUTABLE_MODEL_TASK__SRC:
        return SRC_EDEFAULT == null ? src != null : !SRC_EDEFAULT.equals(src);
      case EwePackage.EXECUTABLE_MODEL_TASK__EXPORTS:
        return exports != null && !exports.isEmpty();
      case EwePackage.EXECUTABLE_MODEL_TASK__USES:
        return uses != null && !uses.isEmpty();
      case EwePackage.EXECUTABLE_MODEL_TASK__MODELS:
        return models != null && !models.isEmpty();
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
    result.append(" (src: ");
    result.append(src);
    result.append(')');
    return result.toString();
  }

} //ExecutableModelTaskImpl
