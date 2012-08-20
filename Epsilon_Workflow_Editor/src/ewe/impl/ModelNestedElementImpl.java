/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ewe.impl;

import ewe.EwePackage;
import ewe.ModelNestedElement;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Nested Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ewe.impl.ModelNestedElementImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link ewe.impl.ModelNestedElementImpl#getAs <em>As</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelNestedElementImpl extends EObjectImpl implements ModelNestedElement
{
  /**
   * The default value of the '{@link #getRef() <em>Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRef()
   * @generated
   * @ordered
   */
  protected static final String REF_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRef() <em>Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRef()
   * @generated
   * @ordered
   */
  protected String ref = REF_EDEFAULT;

  /**
   * The default value of the '{@link #getAs() <em>As</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAs()
   * @generated
   * @ordered
   */
  protected static final String AS_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getAs() <em>As</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAs()
   * @generated
   * @ordered
   */
  protected String as = AS_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ModelNestedElementImpl()
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
    return EwePackage.Literals.MODEL_NESTED_ELEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getRef()
  {
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRef(String newRef)
  {
    String oldRef = ref;
    ref = newRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EwePackage.MODEL_NESTED_ELEMENT__REF, oldRef, ref));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getAs()
  {
    return as;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAs(String newAs)
  {
    String oldAs = as;
    as = newAs;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EwePackage.MODEL_NESTED_ELEMENT__AS, oldAs, as));
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
      case EwePackage.MODEL_NESTED_ELEMENT__REF:
        return getRef();
      case EwePackage.MODEL_NESTED_ELEMENT__AS:
        return getAs();
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
      case EwePackage.MODEL_NESTED_ELEMENT__REF:
        setRef((String)newValue);
        return;
      case EwePackage.MODEL_NESTED_ELEMENT__AS:
        setAs((String)newValue);
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
      case EwePackage.MODEL_NESTED_ELEMENT__REF:
        setRef(REF_EDEFAULT);
        return;
      case EwePackage.MODEL_NESTED_ELEMENT__AS:
        setAs(AS_EDEFAULT);
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
      case EwePackage.MODEL_NESTED_ELEMENT__REF:
        return REF_EDEFAULT == null ? ref != null : !REF_EDEFAULT.equals(ref);
      case EwePackage.MODEL_NESTED_ELEMENT__AS:
        return AS_EDEFAULT == null ? as != null : !AS_EDEFAULT.equals(as);
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
    result.append(" (ref: ");
    result.append(ref);
    result.append(", as: ");
    result.append(as);
    result.append(')');
    return result.toString();
  }

} //ModelNestedElementImpl
