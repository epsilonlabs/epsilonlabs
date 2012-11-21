/**
 */
package testm2.impl;

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

import testm2.Deliverable;
import testm2.Effort;
import testm2.Partner;
import testm2.Task;
import testm2.Testm2Package;
import testm2.WP;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>WP</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link testm2.impl.WPImpl#getTasks <em>Tasks</em>}</li>
 *   <li>{@link testm2.impl.WPImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link testm2.impl.WPImpl#getLeader <em>Leader</em>}</li>
 *   <li>{@link testm2.impl.WPImpl#getType <em>Type</em>}</li>
 *   <li>{@link testm2.impl.WPImpl#getEffort <em>Effort</em>}</li>
 *   <li>{@link testm2.impl.WPImpl#getDeliverables <em>Deliverables</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WPImpl extends EObjectImpl implements WP {
	/**
	 * The cached value of the '{@link #getTasks() <em>Tasks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTasks()
	 * @generated
	 * @ordered
	 */
	protected EList<Task> tasks;

	/**
	 * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String TITLE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected String title = TITLE_EDEFAULT;
	/**
	 * The cached value of the '{@link #getLeader() <em>Leader</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeader()
	 * @generated
	 * @ordered
	 */
	protected Partner leader;
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEffort() <em>Effort</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEffort()
	 * @generated
	 * @ordered
	 */
	protected EList<Effort> effort;

	/**
	 * The cached value of the '{@link #getDeliverables() <em>Deliverables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeliverables()
	 * @generated
	 * @ordered
	 */
	protected EList<Deliverable> deliverables;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WPImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Testm2Package.Literals.WP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Task> getTasks() {
		if (tasks == null) {
			tasks = new EObjectContainmentEList<Task>(Task.class, this, Testm2Package.WP__TASKS);
		}
		return tasks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTitle(String newTitle) {
		String oldTitle = title;
		title = newTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Testm2Package.WP__TITLE, oldTitle, title));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Partner getLeader() {
		if (leader != null && leader.eIsProxy()) {
			InternalEObject oldLeader = (InternalEObject)leader;
			leader = (Partner)eResolveProxy(oldLeader);
			if (leader != oldLeader) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Testm2Package.WP__LEADER, oldLeader, leader));
			}
		}
		return leader;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Partner basicGetLeader() {
		return leader;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeader(Partner newLeader) {
		Partner oldLeader = leader;
		leader = newLeader;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Testm2Package.WP__LEADER, oldLeader, leader));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Testm2Package.WP__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Effort> getEffort() {
		if (effort == null) {
			effort = new EObjectContainmentEList<Effort>(Effort.class, this, Testm2Package.WP__EFFORT);
		}
		return effort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Deliverable> getDeliverables() {
		if (deliverables == null) {
			deliverables = new EObjectContainmentEList<Deliverable>(Deliverable.class, this, Testm2Package.WP__DELIVERABLES);
		}
		return deliverables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Testm2Package.WP__TASKS:
				return ((InternalEList<?>)getTasks()).basicRemove(otherEnd, msgs);
			case Testm2Package.WP__EFFORT:
				return ((InternalEList<?>)getEffort()).basicRemove(otherEnd, msgs);
			case Testm2Package.WP__DELIVERABLES:
				return ((InternalEList<?>)getDeliverables()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Testm2Package.WP__TASKS:
				return getTasks();
			case Testm2Package.WP__TITLE:
				return getTitle();
			case Testm2Package.WP__LEADER:
				if (resolve) return getLeader();
				return basicGetLeader();
			case Testm2Package.WP__TYPE:
				return getType();
			case Testm2Package.WP__EFFORT:
				return getEffort();
			case Testm2Package.WP__DELIVERABLES:
				return getDeliverables();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Testm2Package.WP__TASKS:
				getTasks().clear();
				getTasks().addAll((Collection<? extends Task>)newValue);
				return;
			case Testm2Package.WP__TITLE:
				setTitle((String)newValue);
				return;
			case Testm2Package.WP__LEADER:
				setLeader((Partner)newValue);
				return;
			case Testm2Package.WP__TYPE:
				setType((String)newValue);
				return;
			case Testm2Package.WP__EFFORT:
				getEffort().clear();
				getEffort().addAll((Collection<? extends Effort>)newValue);
				return;
			case Testm2Package.WP__DELIVERABLES:
				getDeliverables().clear();
				getDeliverables().addAll((Collection<? extends Deliverable>)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case Testm2Package.WP__TASKS:
				getTasks().clear();
				return;
			case Testm2Package.WP__TITLE:
				setTitle(TITLE_EDEFAULT);
				return;
			case Testm2Package.WP__LEADER:
				setLeader((Partner)null);
				return;
			case Testm2Package.WP__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case Testm2Package.WP__EFFORT:
				getEffort().clear();
				return;
			case Testm2Package.WP__DELIVERABLES:
				getDeliverables().clear();
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case Testm2Package.WP__TASKS:
				return tasks != null && !tasks.isEmpty();
			case Testm2Package.WP__TITLE:
				return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
			case Testm2Package.WP__LEADER:
				return leader != null;
			case Testm2Package.WP__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case Testm2Package.WP__EFFORT:
				return effort != null && !effort.isEmpty();
			case Testm2Package.WP__DELIVERABLES:
				return deliverables != null && !deliverables.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (title: ");
		result.append(title);
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //WPImpl
