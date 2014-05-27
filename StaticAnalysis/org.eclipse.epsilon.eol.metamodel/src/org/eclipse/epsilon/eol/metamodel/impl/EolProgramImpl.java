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

import org.eclipse.epsilon.eol.metamodel.Block;
import org.eclipse.epsilon.eol.metamodel.EOLLibraryModule;
import org.eclipse.epsilon.eol.metamodel.EolPackage;
import org.eclipse.epsilon.eol.metamodel.EolProgram;
import org.eclipse.epsilon.eol.metamodel.Import;
import org.eclipse.epsilon.eol.metamodel.ModelDeclarationStatement;
import org.eclipse.epsilon.eol.metamodel.NameExpression;
import org.eclipse.epsilon.eol.metamodel.OperationDefinition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Program</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.EolProgramImpl#getModelDeclarations <em>Model Declarations</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.EolProgramImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.EolProgramImpl#getOperations <em>Operations</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.EolProgramImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.EolProgramImpl#getImportedModules <em>Imported Modules</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.EolProgramImpl#getBlock <em>Block</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EolProgramImpl extends EolElementImpl implements EolProgram {
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
	 * The cached value of the '{@link #getImportedModules() <em>Imported Modules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportedModules()
	 * @generated
	 * @ordered
	 */
	protected EList<EolProgram> importedModules;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EolProgramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EolPackage.Literals.EOL_PROGRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelDeclarationStatement> getModelDeclarations() {
		if (modelDeclarations == null) {
			modelDeclarations = new EObjectContainmentEList<ModelDeclarationStatement>(ModelDeclarationStatement.class, this, EolPackage.EOL_PROGRAM__MODEL_DECLARATIONS);
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
			imports = new EObjectContainmentEList<Import>(Import.class, this, EolPackage.EOL_PROGRAM__IMPORTS);
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
			operations = new EObjectContainmentEList<OperationDefinition>(OperationDefinition.class, this, EolPackage.EOL_PROGRAM__OPERATIONS);
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EolPackage.EOL_PROGRAM__NAME, oldName, newName);
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
				msgs = ((InternalEObject)name).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EolPackage.EOL_PROGRAM__NAME, null, msgs);
			if (newName != null)
				msgs = ((InternalEObject)newName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EolPackage.EOL_PROGRAM__NAME, null, msgs);
			msgs = basicSetName(newName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EolPackage.EOL_PROGRAM__NAME, newName, newName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EolProgram> getImportedModules() {
		if (importedModules == null) {
			importedModules = new EObjectContainmentEList<EolProgram>(EolProgram.class, this, EolPackage.EOL_PROGRAM__IMPORTED_MODULES);
		}
		return importedModules;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EolPackage.EOL_PROGRAM__BLOCK, oldBlock, newBlock);
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
				msgs = ((InternalEObject)block).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EolPackage.EOL_PROGRAM__BLOCK, null, msgs);
			if (newBlock != null)
				msgs = ((InternalEObject)newBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EolPackage.EOL_PROGRAM__BLOCK, null, msgs);
			msgs = basicSetBlock(newBlock, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EolPackage.EOL_PROGRAM__BLOCK, newBlock, newBlock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EolPackage.EOL_PROGRAM__MODEL_DECLARATIONS:
				return ((InternalEList<?>)getModelDeclarations()).basicRemove(otherEnd, msgs);
			case EolPackage.EOL_PROGRAM__IMPORTS:
				return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
			case EolPackage.EOL_PROGRAM__OPERATIONS:
				return ((InternalEList<?>)getOperations()).basicRemove(otherEnd, msgs);
			case EolPackage.EOL_PROGRAM__NAME:
				return basicSetName(null, msgs);
			case EolPackage.EOL_PROGRAM__IMPORTED_MODULES:
				return ((InternalEList<?>)getImportedModules()).basicRemove(otherEnd, msgs);
			case EolPackage.EOL_PROGRAM__BLOCK:
				return basicSetBlock(null, msgs);
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
			case EolPackage.EOL_PROGRAM__MODEL_DECLARATIONS:
				return getModelDeclarations();
			case EolPackage.EOL_PROGRAM__IMPORTS:
				return getImports();
			case EolPackage.EOL_PROGRAM__OPERATIONS:
				return getOperations();
			case EolPackage.EOL_PROGRAM__NAME:
				return getName();
			case EolPackage.EOL_PROGRAM__IMPORTED_MODULES:
				return getImportedModules();
			case EolPackage.EOL_PROGRAM__BLOCK:
				return getBlock();
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
			case EolPackage.EOL_PROGRAM__MODEL_DECLARATIONS:
				getModelDeclarations().clear();
				getModelDeclarations().addAll((Collection<? extends ModelDeclarationStatement>)newValue);
				return;
			case EolPackage.EOL_PROGRAM__IMPORTS:
				getImports().clear();
				getImports().addAll((Collection<? extends Import>)newValue);
				return;
			case EolPackage.EOL_PROGRAM__OPERATIONS:
				getOperations().clear();
				getOperations().addAll((Collection<? extends OperationDefinition>)newValue);
				return;
			case EolPackage.EOL_PROGRAM__NAME:
				setName((NameExpression)newValue);
				return;
			case EolPackage.EOL_PROGRAM__IMPORTED_MODULES:
				getImportedModules().clear();
				getImportedModules().addAll((Collection<? extends EolProgram>)newValue);
				return;
			case EolPackage.EOL_PROGRAM__BLOCK:
				setBlock((Block)newValue);
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
			case EolPackage.EOL_PROGRAM__MODEL_DECLARATIONS:
				getModelDeclarations().clear();
				return;
			case EolPackage.EOL_PROGRAM__IMPORTS:
				getImports().clear();
				return;
			case EolPackage.EOL_PROGRAM__OPERATIONS:
				getOperations().clear();
				return;
			case EolPackage.EOL_PROGRAM__NAME:
				setName((NameExpression)null);
				return;
			case EolPackage.EOL_PROGRAM__IMPORTED_MODULES:
				getImportedModules().clear();
				return;
			case EolPackage.EOL_PROGRAM__BLOCK:
				setBlock((Block)null);
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
			case EolPackage.EOL_PROGRAM__MODEL_DECLARATIONS:
				return modelDeclarations != null && !modelDeclarations.isEmpty();
			case EolPackage.EOL_PROGRAM__IMPORTS:
				return imports != null && !imports.isEmpty();
			case EolPackage.EOL_PROGRAM__OPERATIONS:
				return operations != null && !operations.isEmpty();
			case EolPackage.EOL_PROGRAM__NAME:
				return name != null;
			case EolPackage.EOL_PROGRAM__IMPORTED_MODULES:
				return importedModules != null && !importedModules.isEmpty();
			case EolPackage.EOL_PROGRAM__BLOCK:
				return block != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == EOLLibraryModule.class) {
			switch (derivedFeatureID) {
				case EolPackage.EOL_PROGRAM__MODEL_DECLARATIONS: return EolPackage.EOL_LIBRARY_MODULE__MODEL_DECLARATIONS;
				case EolPackage.EOL_PROGRAM__IMPORTS: return EolPackage.EOL_LIBRARY_MODULE__IMPORTS;
				case EolPackage.EOL_PROGRAM__OPERATIONS: return EolPackage.EOL_LIBRARY_MODULE__OPERATIONS;
				case EolPackage.EOL_PROGRAM__NAME: return EolPackage.EOL_LIBRARY_MODULE__NAME;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == EOLLibraryModule.class) {
			switch (baseFeatureID) {
				case EolPackage.EOL_LIBRARY_MODULE__MODEL_DECLARATIONS: return EolPackage.EOL_PROGRAM__MODEL_DECLARATIONS;
				case EolPackage.EOL_LIBRARY_MODULE__IMPORTS: return EolPackage.EOL_PROGRAM__IMPORTS;
				case EolPackage.EOL_LIBRARY_MODULE__OPERATIONS: return EolPackage.EOL_PROGRAM__OPERATIONS;
				case EolPackage.EOL_LIBRARY_MODULE__NAME: return EolPackage.EOL_PROGRAM__NAME;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //EolProgramImpl
