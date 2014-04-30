/**
 */
package org.eclipse.epsilon.eol.eol.metamodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.epsilon.eol.eol.metamodel.Block;
import org.eclipse.epsilon.eol.eol.metamodel.EolPackage;
import org.eclipse.epsilon.eol.eol.metamodel.Import;
import org.eclipse.epsilon.eol.eol.metamodel.ModelDeclarationStatement;
import org.eclipse.epsilon.eol.eol.metamodel.NameExpression;
import org.eclipse.epsilon.eol.eol.metamodel.OperationDefinition;
import org.eclipse.epsilon.eol.eol.metamodel.Program;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Program</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.eol.metamodel.impl.ProgramImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.eol.metamodel.impl.ProgramImpl#getImportedModules <em>Imported Modules</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.eol.metamodel.impl.ProgramImpl#getOperations <em>Operations</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.eol.metamodel.impl.ProgramImpl#getBlock <em>Block</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.eol.metamodel.impl.ProgramImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.eol.metamodel.impl.ProgramImpl#getModelDeclarations <em>Model Declarations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProgramImpl extends EolElementImpl implements Program {
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
	 * The cached value of the '{@link #getImportedModules() <em>Imported Modules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportedModules()
	 * @generated
	 * @ordered
	 */
	protected EList<Program> importedModules;

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
	 * The cached value of the '{@link #getBlock() <em>Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlock()
	 * @generated
	 * @ordered
	 */
	protected Block block;

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
	 * The cached value of the '{@link #getModelDeclarations() <em>Model Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelDeclarationStatement> modelDeclarations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProgramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EolPackage.Literals.PROGRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Import> getImports() {
		if (imports == null) {
			imports = new EObjectContainmentEList<Import>(Import.class, this, EolPackage.PROGRAM__IMPORTS);
		}
		return imports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Program> getImportedModules() {
		if (importedModules == null) {
			importedModules = new EObjectContainmentEList<Program>(Program.class, this, EolPackage.PROGRAM__IMPORTED_MODULES);
		}
		return importedModules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OperationDefinition> getOperations() {
		if (operations == null) {
			operations = new EObjectContainmentEList<OperationDefinition>(OperationDefinition.class, this, EolPackage.PROGRAM__OPERATIONS);
		}
		return operations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Block getBlock() {
		return block;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBlock(Block newBlock, NotificationChain msgs) {
		Block oldBlock = block;
		block = newBlock;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EolPackage.PROGRAM__BLOCK, oldBlock, newBlock);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBlock(Block newBlock) {
		if (newBlock != block) {
			NotificationChain msgs = null;
			if (block != null)
				msgs = ((InternalEObject)block).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EolPackage.PROGRAM__BLOCK, null, msgs);
			if (newBlock != null)
				msgs = ((InternalEObject)newBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EolPackage.PROGRAM__BLOCK, null, msgs);
			msgs = basicSetBlock(newBlock, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EolPackage.PROGRAM__BLOCK, newBlock, newBlock));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EolPackage.PROGRAM__NAME, oldName, newName);
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
				msgs = ((InternalEObject)name).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EolPackage.PROGRAM__NAME, null, msgs);
			if (newName != null)
				msgs = ((InternalEObject)newName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EolPackage.PROGRAM__NAME, null, msgs);
			msgs = basicSetName(newName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EolPackage.PROGRAM__NAME, newName, newName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelDeclarationStatement> getModelDeclarations() {
		if (modelDeclarations == null) {
			modelDeclarations = new EObjectContainmentEList<ModelDeclarationStatement>(ModelDeclarationStatement.class, this, EolPackage.PROGRAM__MODEL_DECLARATIONS);
		}
		return modelDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EolPackage.PROGRAM__IMPORTS:
				return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
			case EolPackage.PROGRAM__IMPORTED_MODULES:
				return ((InternalEList<?>)getImportedModules()).basicRemove(otherEnd, msgs);
			case EolPackage.PROGRAM__OPERATIONS:
				return ((InternalEList<?>)getOperations()).basicRemove(otherEnd, msgs);
			case EolPackage.PROGRAM__BLOCK:
				return basicSetBlock(null, msgs);
			case EolPackage.PROGRAM__NAME:
				return basicSetName(null, msgs);
			case EolPackage.PROGRAM__MODEL_DECLARATIONS:
				return ((InternalEList<?>)getModelDeclarations()).basicRemove(otherEnd, msgs);
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
			case EolPackage.PROGRAM__IMPORTS:
				return getImports();
			case EolPackage.PROGRAM__IMPORTED_MODULES:
				return getImportedModules();
			case EolPackage.PROGRAM__OPERATIONS:
				return getOperations();
			case EolPackage.PROGRAM__BLOCK:
				return getBlock();
			case EolPackage.PROGRAM__NAME:
				return getName();
			case EolPackage.PROGRAM__MODEL_DECLARATIONS:
				return getModelDeclarations();
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
			case EolPackage.PROGRAM__IMPORTS:
				getImports().clear();
				getImports().addAll((Collection<? extends Import>)newValue);
				return;
			case EolPackage.PROGRAM__IMPORTED_MODULES:
				getImportedModules().clear();
				getImportedModules().addAll((Collection<? extends Program>)newValue);
				return;
			case EolPackage.PROGRAM__OPERATIONS:
				getOperations().clear();
				getOperations().addAll((Collection<? extends OperationDefinition>)newValue);
				return;
			case EolPackage.PROGRAM__BLOCK:
				setBlock((Block)newValue);
				return;
			case EolPackage.PROGRAM__NAME:
				setName((NameExpression)newValue);
				return;
			case EolPackage.PROGRAM__MODEL_DECLARATIONS:
				getModelDeclarations().clear();
				getModelDeclarations().addAll((Collection<? extends ModelDeclarationStatement>)newValue);
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
			case EolPackage.PROGRAM__IMPORTS:
				getImports().clear();
				return;
			case EolPackage.PROGRAM__IMPORTED_MODULES:
				getImportedModules().clear();
				return;
			case EolPackage.PROGRAM__OPERATIONS:
				getOperations().clear();
				return;
			case EolPackage.PROGRAM__BLOCK:
				setBlock((Block)null);
				return;
			case EolPackage.PROGRAM__NAME:
				setName((NameExpression)null);
				return;
			case EolPackage.PROGRAM__MODEL_DECLARATIONS:
				getModelDeclarations().clear();
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
			case EolPackage.PROGRAM__IMPORTS:
				return imports != null && !imports.isEmpty();
			case EolPackage.PROGRAM__IMPORTED_MODULES:
				return importedModules != null && !importedModules.isEmpty();
			case EolPackage.PROGRAM__OPERATIONS:
				return operations != null && !operations.isEmpty();
			case EolPackage.PROGRAM__BLOCK:
				return block != null;
			case EolPackage.PROGRAM__NAME:
				return name != null;
			case EolPackage.PROGRAM__MODEL_DECLARATIONS:
				return modelDeclarations != null && !modelDeclarations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ProgramImpl
