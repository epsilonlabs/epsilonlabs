/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ewe.impl;

import ewe.Attribute;
import ewe.EwePackage;
import ewe.NestedElement;
import ewe.Task;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ewe.impl.TaskImpl#getName <em>Name</em>}</li>
 *   <li>{@link ewe.impl.TaskImpl#getFollows <em>Follows</em>}</li>
 *   <li>{@link ewe.impl.TaskImpl#getFollower <em>Follower</em>}</li>
 *   <li>{@link ewe.impl.TaskImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link ewe.impl.TaskImpl#getTaskelements <em>Taskelements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TaskImpl extends EObjectImpl implements Task
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getFollows() <em>Follows</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFollows()
   * @generated
   * @ordered
   */
  protected Task follows;

  /**
   * The cached value of the '{@link #getFollower() <em>Follower</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFollower()
   * @generated
   * @ordered
   */
  protected Task follower;

  /**
   * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttributes()
   * @generated
   * @ordered
   */
  protected EList<Attribute> attributes;

  /**
   * The cached value of the '{@link #getTaskelements() <em>Taskelements</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTaskelements()
   * @generated
   * @ordered
   */
  protected EList<NestedElement> taskelements;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TaskImpl()
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
    return EwePackage.Literals.TASK;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EwePackage.TASK__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Task getFollows()
  {
    if (follows != null && follows.eIsProxy())
    {
      InternalEObject oldFollows = (InternalEObject)follows;
      follows = (Task)eResolveProxy(oldFollows);
      if (follows != oldFollows)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, EwePackage.TASK__FOLLOWS, oldFollows, follows));
      }
    }
    return follows;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Task basicGetFollows()
  {
    return follows;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFollows(Task newFollows, NotificationChain msgs)
  {
    Task oldFollows = follows;
    follows = newFollows;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EwePackage.TASK__FOLLOWS, oldFollows, newFollows);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFollows(Task newFollows)
  {
    if (newFollows != follows)
    {
      NotificationChain msgs = null;
      if (follows != null)
        msgs = ((InternalEObject)follows).eInverseRemove(this, EwePackage.TASK__FOLLOWER, Task.class, msgs);
      if (newFollows != null)
        msgs = ((InternalEObject)newFollows).eInverseAdd(this, EwePackage.TASK__FOLLOWER, Task.class, msgs);
      msgs = basicSetFollows(newFollows, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EwePackage.TASK__FOLLOWS, newFollows, newFollows));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Task getFollower()
  {
    if (follower != null && follower.eIsProxy())
    {
      InternalEObject oldFollower = (InternalEObject)follower;
      follower = (Task)eResolveProxy(oldFollower);
      if (follower != oldFollower)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, EwePackage.TASK__FOLLOWER, oldFollower, follower));
      }
    }
    return follower;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Task basicGetFollower()
  {
    return follower;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFollower(Task newFollower, NotificationChain msgs)
  {
    Task oldFollower = follower;
    follower = newFollower;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EwePackage.TASK__FOLLOWER, oldFollower, newFollower);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFollower(Task newFollower)
  {
    if (newFollower != follower)
    {
      NotificationChain msgs = null;
      if (follower != null)
        msgs = ((InternalEObject)follower).eInverseRemove(this, EwePackage.TASK__FOLLOWS, Task.class, msgs);
      if (newFollower != null)
        msgs = ((InternalEObject)newFollower).eInverseAdd(this, EwePackage.TASK__FOLLOWS, Task.class, msgs);
      msgs = basicSetFollower(newFollower, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EwePackage.TASK__FOLLOWER, newFollower, newFollower));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Attribute> getAttributes()
  {
    if (attributes == null)
    {
      attributes = new EObjectContainmentEList<Attribute>(Attribute.class, this, EwePackage.TASK__ATTRIBUTES);
    }
    return attributes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<NestedElement> getTaskelements()
  {
    if (taskelements == null)
    {
      taskelements = new EObjectContainmentEList<NestedElement>(NestedElement.class, this, EwePackage.TASK__TASKELEMENTS);
    }
    return taskelements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case EwePackage.TASK__FOLLOWS:
        if (follows != null)
          msgs = ((InternalEObject)follows).eInverseRemove(this, EwePackage.TASK__FOLLOWER, Task.class, msgs);
        return basicSetFollows((Task)otherEnd, msgs);
      case EwePackage.TASK__FOLLOWER:
        if (follower != null)
          msgs = ((InternalEObject)follower).eInverseRemove(this, EwePackage.TASK__FOLLOWS, Task.class, msgs);
        return basicSetFollower((Task)otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
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
      case EwePackage.TASK__FOLLOWS:
        return basicSetFollows(null, msgs);
      case EwePackage.TASK__FOLLOWER:
        return basicSetFollower(null, msgs);
      case EwePackage.TASK__ATTRIBUTES:
        return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
      case EwePackage.TASK__TASKELEMENTS:
        return ((InternalEList<?>)getTaskelements()).basicRemove(otherEnd, msgs);
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
      case EwePackage.TASK__NAME:
        return getName();
      case EwePackage.TASK__FOLLOWS:
        if (resolve) return getFollows();
        return basicGetFollows();
      case EwePackage.TASK__FOLLOWER:
        if (resolve) return getFollower();
        return basicGetFollower();
      case EwePackage.TASK__ATTRIBUTES:
        return getAttributes();
      case EwePackage.TASK__TASKELEMENTS:
        return getTaskelements();
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
      case EwePackage.TASK__NAME:
        setName((String)newValue);
        return;
      case EwePackage.TASK__FOLLOWS:
        setFollows((Task)newValue);
        return;
      case EwePackage.TASK__FOLLOWER:
        setFollower((Task)newValue);
        return;
      case EwePackage.TASK__ATTRIBUTES:
        getAttributes().clear();
        getAttributes().addAll((Collection<? extends Attribute>)newValue);
        return;
      case EwePackage.TASK__TASKELEMENTS:
        getTaskelements().clear();
        getTaskelements().addAll((Collection<? extends NestedElement>)newValue);
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
      case EwePackage.TASK__NAME:
        setName(NAME_EDEFAULT);
        return;
      case EwePackage.TASK__FOLLOWS:
        setFollows((Task)null);
        return;
      case EwePackage.TASK__FOLLOWER:
        setFollower((Task)null);
        return;
      case EwePackage.TASK__ATTRIBUTES:
        getAttributes().clear();
        return;
      case EwePackage.TASK__TASKELEMENTS:
        getTaskelements().clear();
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
      case EwePackage.TASK__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case EwePackage.TASK__FOLLOWS:
        return follows != null;
      case EwePackage.TASK__FOLLOWER:
        return follower != null;
      case EwePackage.TASK__ATTRIBUTES:
        return attributes != null && !attributes.isEmpty();
      case EwePackage.TASK__TASKELEMENTS:
        return taskelements != null && !taskelements.isEmpty();
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
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //TaskImpl
