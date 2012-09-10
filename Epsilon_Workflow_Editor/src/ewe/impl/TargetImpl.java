/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ewe.impl;

import ewe.EwePackage;
import ewe.Project;
import ewe.Target;
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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Target</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ewe.impl.TargetImpl#getTargetTasks <em>Target Tasks</em>}</li>
 *   <li>{@link ewe.impl.TargetImpl#getName <em>Name</em>}</li>
 *   <li>{@link ewe.impl.TargetImpl#getContainingProject <em>Containing Project</em>}</li>
 *   <li>{@link ewe.impl.TargetImpl#getDepends <em>Depends</em>}</li>
 *   <li>{@link ewe.impl.TargetImpl#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TargetImpl extends EObjectImpl implements Target
{
  /**
   * The cached value of the '{@link #getTargetTasks() <em>Target Tasks</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTargetTasks()
   * @generated
   * @ordered
   */
  protected EList<Task> targetTasks;

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
   * The cached value of the '{@link #getDepends() <em>Depends</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDepends()
   * @generated
   * @ordered
   */
  protected EList<Target> depends;

  /**
   * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected static final String DESCRIPTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected String description = DESCRIPTION_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TargetImpl()
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
    return EwePackage.Literals.TARGET;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Task> getTargetTasks()
  {
    if (targetTasks == null)
    {
      targetTasks = new EObjectContainmentEList<Task>(Task.class, this, EwePackage.TARGET__TARGET_TASKS);
    }
    return targetTasks;
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
      eNotify(new ENotificationImpl(this, Notification.SET, EwePackage.TARGET__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Project getContainingProject()
  {
    if (eContainerFeatureID() != EwePackage.TARGET__CONTAINING_PROJECT) return null;
    return (Project)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetContainingProject(Project newContainingProject, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newContainingProject, EwePackage.TARGET__CONTAINING_PROJECT, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setContainingProject(Project newContainingProject)
  {
    if (newContainingProject != eInternalContainer() || (eContainerFeatureID() != EwePackage.TARGET__CONTAINING_PROJECT && newContainingProject != null))
    {
      if (EcoreUtil.isAncestor(this, newContainingProject))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newContainingProject != null)
        msgs = ((InternalEObject)newContainingProject).eInverseAdd(this, EwePackage.PROJECT__TARGETS, Project.class, msgs);
      msgs = basicSetContainingProject(newContainingProject, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EwePackage.TARGET__CONTAINING_PROJECT, newContainingProject, newContainingProject));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Target> getDepends()
  {
    if (depends == null)
    {
      depends = new EObjectResolvingEList<Target>(Target.class, this, EwePackage.TARGET__DEPENDS);
    }
    return depends;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDescription()
  {
    return description;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDescription(String newDescription)
  {
    String oldDescription = description;
    description = newDescription;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EwePackage.TARGET__DESCRIPTION, oldDescription, description));
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
      case EwePackage.TARGET__CONTAINING_PROJECT:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetContainingProject((Project)otherEnd, msgs);
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
      case EwePackage.TARGET__TARGET_TASKS:
        return ((InternalEList<?>)getTargetTasks()).basicRemove(otherEnd, msgs);
      case EwePackage.TARGET__CONTAINING_PROJECT:
        return basicSetContainingProject(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs)
  {
    switch (eContainerFeatureID())
    {
      case EwePackage.TARGET__CONTAINING_PROJECT:
        return eInternalContainer().eInverseRemove(this, EwePackage.PROJECT__TARGETS, Project.class, msgs);
    }
    return super.eBasicRemoveFromContainerFeature(msgs);
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
      case EwePackage.TARGET__TARGET_TASKS:
        return getTargetTasks();
      case EwePackage.TARGET__NAME:
        return getName();
      case EwePackage.TARGET__CONTAINING_PROJECT:
        return getContainingProject();
      case EwePackage.TARGET__DEPENDS:
        return getDepends();
      case EwePackage.TARGET__DESCRIPTION:
        return getDescription();
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
      case EwePackage.TARGET__TARGET_TASKS:
        getTargetTasks().clear();
        getTargetTasks().addAll((Collection<? extends Task>)newValue);
        return;
      case EwePackage.TARGET__NAME:
        setName((String)newValue);
        return;
      case EwePackage.TARGET__CONTAINING_PROJECT:
        setContainingProject((Project)newValue);
        return;
      case EwePackage.TARGET__DEPENDS:
        getDepends().clear();
        getDepends().addAll((Collection<? extends Target>)newValue);
        return;
      case EwePackage.TARGET__DESCRIPTION:
        setDescription((String)newValue);
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
      case EwePackage.TARGET__TARGET_TASKS:
        getTargetTasks().clear();
        return;
      case EwePackage.TARGET__NAME:
        setName(NAME_EDEFAULT);
        return;
      case EwePackage.TARGET__CONTAINING_PROJECT:
        setContainingProject((Project)null);
        return;
      case EwePackage.TARGET__DEPENDS:
        getDepends().clear();
        return;
      case EwePackage.TARGET__DESCRIPTION:
        setDescription(DESCRIPTION_EDEFAULT);
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
      case EwePackage.TARGET__TARGET_TASKS:
        return targetTasks != null && !targetTasks.isEmpty();
      case EwePackage.TARGET__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case EwePackage.TARGET__CONTAINING_PROJECT:
        return getContainingProject() != null;
      case EwePackage.TARGET__DEPENDS:
        return depends != null && !depends.isEmpty();
      case EwePackage.TARGET__DESCRIPTION:
        return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
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
    result.append(", description: ");
    result.append(description);
    result.append(')');
    return result.toString();
  }

} //TargetImpl
