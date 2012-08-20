/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ewe;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see ewe.EwePackage
 * @generated
 */
public interface EweFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  EweFactory eINSTANCE = ewe.impl.EweFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Project</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Project</em>'.
   * @generated
   */
  Project createProject();

  /**
   * Returns a new object of class '<em>Task</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Task</em>'.
   * @generated
   */
  Task createTask();

  /**
   * Returns a new object of class '<em>Load Model Task</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Load Model Task</em>'.
   * @generated
   */
  LoadModelTask createLoadModelTask();

  /**
   * Returns a new object of class '<em>Store Model Task</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Store Model Task</em>'.
   * @generated
   */
  StoreModelTask createStoreModelTask();

  /**
   * Returns a new object of class '<em>Parameter Nested Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Parameter Nested Element</em>'.
   * @generated
   */
  ParameterNestedElement createParameterNestedElement();

  /**
   * Returns a new object of class '<em>Variable Nested Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Variable Nested Element</em>'.
   * @generated
   */
  VariableNestedElement createVariableNestedElement();

  /**
   * Returns a new object of class '<em>Exports Nested Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Exports Nested Element</em>'.
   * @generated
   */
  ExportsNestedElement createExportsNestedElement();

  /**
   * Returns a new object of class '<em>Uses Nested Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Uses Nested Element</em>'.
   * @generated
   */
  UsesNestedElement createUsesNestedElement();

  /**
   * Returns a new object of class '<em>Model Nested Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model Nested Element</em>'.
   * @generated
   */
  ModelNestedElement createModelNestedElement();

  /**
   * Returns a new object of class '<em>Rollback Transaction Task</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rollback Transaction Task</em>'.
   * @generated
   */
  RollbackTransactionTask createRollbackTransactionTask();

  /**
   * Returns a new object of class '<em>Dispose Model Task</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Dispose Model Task</em>'.
   * @generated
   */
  DisposeModelTask createDisposeModelTask();

  /**
   * Returns a new object of class '<em>Start Transaction Task</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Start Transaction Task</em>'.
   * @generated
   */
  StartTransactionTask createStartTransactionTask();

  /**
   * Returns a new object of class '<em>Eol Task</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Eol Task</em>'.
   * @generated
   */
  EolTask createEolTask();

  /**
   * Returns a new object of class '<em>Eml Task</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Eml Task</em>'.
   * @generated
   */
  EmlTask createEmlTask();

  /**
   * Returns a new object of class '<em>Egl Task</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Egl Task</em>'.
   * @generated
   */
  EglTask createEglTask();

  /**
   * Returns a new object of class '<em>Etl Task</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Etl Task</em>'.
   * @generated
   */
  EtlTask createEtlTask();

  /**
   * Returns a new object of class '<em>Evl Task</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Evl Task</em>'.
   * @generated
   */
  EvlTask createEvlTask();

  /**
   * Returns a new object of class '<em>Commit Transaction Task</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Commit Transaction Task</em>'.
   * @generated
   */
  CommitTransactionTask createCommitTransactionTask();

  /**
   * Returns a new object of class '<em>Property</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Property</em>'.
   * @generated
   */
  Property createProperty();

  /**
   * Returns a new object of class '<em>Target</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Target</em>'.
   * @generated
   */
  Target createTarget();

  /**
   * Returns a new object of class '<em>Load EMF Model Task</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Load EMF Model Task</em>'.
   * @generated
   */
  LoadEMFModelTask createLoadEMFModelTask();

  /**
   * Returns a new object of class '<em>Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Attribute</em>'.
   * @generated
   */
  Attribute createAttribute();

  /**
   * Returns a new object of class '<em>Load XML Model Task</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Load XML Model Task</em>'.
   * @generated
   */
  LoadXMLModelTask createLoadXMLModelTask();

  /**
   * Returns a new object of class '<em>Nested Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Nested Element</em>'.
   * @generated
   */
  NestedElement createNestedElement();

  /**
   * Returns a new object of class '<em>Flock Task</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Flock Task</em>'.
   * @generated
   */
  FlockTask createFlockTask();

  /**
   * Returns a new object of class '<em>EUnit Task</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>EUnit Task</em>'.
   * @generated
   */
  EUnitTask createEUnitTask();

  /**
   * Returns a new object of class '<em>Ecl Task</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Ecl Task</em>'.
   * @generated
   */
  EclTask createEclTask();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  EwePackage getEwePackage();

} //EweFactory
