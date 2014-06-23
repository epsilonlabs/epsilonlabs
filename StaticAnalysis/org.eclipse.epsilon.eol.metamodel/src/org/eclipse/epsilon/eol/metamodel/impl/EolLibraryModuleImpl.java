/**
 */
package org.eclipse.epsilon.eol.metamodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.epsilon.eol.metamodel.EolLibraryModule;
import org.eclipse.epsilon.eol.metamodel.EolPackage;
import org.eclipse.epsilon.eol.metamodel.Import;
import org.eclipse.epsilon.eol.metamodel.ModelDeclarationStatement;
import org.eclipse.epsilon.eol.metamodel.NameExpression;
import org.eclipse.epsilon.eol.metamodel.OperationDefinition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Library Module</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.EolLibraryModuleImpl#getModelDeclarations <em>Model Declarations</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.EolLibraryModuleImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.EolLibraryModuleImpl#getOperations <em>Operations</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.EolLibraryModuleImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EolLibraryModuleImpl extends EolElementImpl implements EolLibraryModule {
	/**
	 * The cached value of the '{@link #getModelDeclarations() <em>Model Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelDeclarationStatement> modelDeclarations;

	/**
	 * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImports()
	 * @generated
	 * @ordered
	 */
	protected EList<Import> imports;

	/**
	 * The cached value of the '{@link #getOperations() <em>Operations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<OperationDefinition> operations;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected NameExpression name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EolLibraryModuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EolPackage.Literals.EOL_LIBRARY_MODULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelDeclarationStatement> getModelDeclarations() {
		if (modelDeclarations == null) {
			modelDeclarations = new EObjectContainmentEList<ModelDeclarationStatement>(ModelDeclarationStatement.class, this, EolPackage.EOL_LIBRARY_MODULE__MODEL_DECLARATIONS);
		}
		return modelDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Import> getImports() {
		if (imports == null) {
			imports = new EObjectContainmentEList<Import>(Import.class, this, EolPackage.EOL_LIBRARY_MODULE__IMPORTS);
		}
		return imports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OperationDefinition> getOperations() {
		if (operations == null) {
			operations = new EObjectContainmentEList<OperationDefinition>(OperationDefinition.class, this, EolPackage.EOL_LIBRARY_MODULE__OPERATIONS);
		}
		return operations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NameExpression getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetName(NameExpression newName, NotificationChain msgs) {
		NameExpression oldName = name;
		name = newName;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EolPackage.EOL_LIBRARY_MODULE__NAME, oldName, newName);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(NameExpression newName) {
		if (newName != name) {
			NotificationChain msgs = null;
			if (name != null)
				msgs = ((InternalEObject)name).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EolPackage.EOL_LIBRARY_MODULE__NAME, null, msgs);
			if (newName != null)
				msgs = ((InternalEObject)newName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EolPackage.EOL_LIBRARY_MODULE__NAME, null, msgs);
			msgs = basicSetName(newName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EolPackage.EOL_LIBRARY_MODULE__NAME, newName, newName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EolPackage.EOL_LIBRARY_MODULE__MODEL_DECLARATIONS:
				return ((InternalEList<?>)getModelDeclarations()).basicRemove(otherEnd, msgs);
			case EolPackage.EOL_LIBRARY_MODULE__IMPORTS:
				return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
			case EolPackage.EOL_LIBRARY_MODULE__OPERATIONS:
				return ((InternalEList<?>)getOperations()).basicRemove(otherEnd, msgs);
			case EolPackage.EOL_LIBRARY_MODULE__NAME:
				return basicSetName(null, msgs);
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
			case EolPackage.EOL_LIBRARY_MODULE__MODEL_DECLARATIONS:
				return getModelDeclarations();
			case EolPackage.EOL_LIBRARY_MODULE__IMPORTS:
				return getImports();
			case EolPackage.EOL_LIBRARY_MODULE__OPERATIONS:
				return getOperations();
			case EolPackage.EOL_LIBRARY_MODULE__NAME:
				return getName();
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
			case EolPackage.EOL_LIBRARY_MODULE__MODEL_DECLARATIONS:
				getModelDeclarations().clear();
				getModelDeclarations().addAll((Collection<? extends ModelDeclarationStatement>)newValue);
				return;
			case EolPackage.EOL_LIBRARY_MODULE__IMPORTS:
				getImports().clear();
				getImports().addAll((Collection<? extends Import>)newValue);
				return;
			case EolPackage.EOL_LIBRARY_MODULE__OPERATIONS:
				getOperations().clear();
				getOperations().addAll((Collection<? extends OperationDefinition>)newValue);
				return;
			case EolPackage.EOL_LIBRARY_MODULE__NAME:
				setName((NameExpression)newValue);
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
			case EolPackage.EOL_LIBRARY_MODULE__MODEL_DECLARATIONS:
				getModelDeclarations().clear();
				return;
			case EolPackage.EOL_LIBRARY_MODULE__IMPORTS:
				getImports().clear();
				return;
			case EolPackage.EOL_LIBRARY_MODULE__OPERATIONS:
				getOperations().clear();
				return;
			case EolPackage.EOL_LIBRARY_MODULE__NAME:
				setName((NameExpression)null);
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
			case EolPackage.EOL_LIBRARY_MODULE__MODEL_DECLARATIONS:
				return modelDeclarations != null && !modelDeclarations.isEmpty();
			case EolPackage.EOL_LIBRARY_MODULE__IMPORTS:
				return imports != null && !imports.isEmpty();
			case EolPackage.EOL_LIBRARY_MODULE__OPERATIONS:
				return operations != null && !operations.isEmpty();
			case EolPackage.EOL_LIBRARY_MODULE__NAME:
				return name != null;
		}
		return super.eIsSet(featureID);
	}

} //EolLibraryModuleImpl
