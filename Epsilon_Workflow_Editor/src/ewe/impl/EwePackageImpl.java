/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ewe.impl;

import ewe.Attribute;
import ewe.CommitTransactionTask;
import ewe.DisposeModelTask;
import ewe.DisposeModelsTask;
import ewe.EUnitTask;
import ewe.EclTask;
import ewe.EglTask;
import ewe.EmlTask;
import ewe.EolTask;
import ewe.EpsilonTask;
import ewe.EtlTask;
import ewe.EvlTask;
import ewe.EweFactory;
import ewe.EwePackage;
import ewe.ExecutableModelTask;
import ewe.ExportsNestedElement;
import ewe.FlockTask;
import ewe.LoadEMFModelTask;
import ewe.LoadModelTask;
import ewe.ModelNestedElement;
import ewe.NestedElement;
import ewe.ParameterNestedElement;
import ewe.Project;
import ewe.RollbackTransactionTask;
import ewe.StartTransactionTask;
import ewe.StoreModelTask;
import ewe.Target;
import ewe.Task;
import ewe.UsesNestedElement;
import ewe.VariableNestedElement;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EwePackageImpl extends EPackageImpl implements EwePackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass projectEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass taskEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass epsilonTaskEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass loadModelTaskEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass storeModelTaskEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass parameterNestedElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass variableNestedElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass exportsNestedElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass usesNestedElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modelNestedElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass executableModelTaskEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rollbackTransactionTaskEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass disposeModelTaskEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass startTransactionTaskEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass eolTaskEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass emlTaskEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass eglTaskEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass etlTaskEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass evlTaskEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass commitTransactionTaskEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass targetEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass loadEMFModelTaskEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass attributeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nestedElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass flockTaskEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass eUnitTaskEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass eclTaskEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass disposeModelsTaskEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see ewe.EwePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private EwePackageImpl()
  {
    super(eNS_URI, EweFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link EwePackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static EwePackage init()
  {
    if (isInited) return (EwePackage)EPackage.Registry.INSTANCE.getEPackage(EwePackage.eNS_URI);

    // Obtain or create and register package
    EwePackageImpl theEwePackage = (EwePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EwePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EwePackageImpl());

    isInited = true;

    // Create package meta-data objects
    theEwePackage.createPackageContents();

    // Initialize created meta-data
    theEwePackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theEwePackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(EwePackage.eNS_URI, theEwePackage);
    return theEwePackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getProject()
  {
    return projectEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getProject_Name()
  {
    return (EAttribute)projectEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProject_Targets()
  {
    return (EReference)projectEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProject_DefaultTarget()
  {
    return (EReference)projectEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTask()
  {
    return taskEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTask_Name()
  {
    return (EAttribute)taskEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTask_Follows()
  {
    return (EReference)taskEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTask_Follower()
  {
    return (EReference)taskEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTask_Attributes()
  {
    return (EReference)taskEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTask_Taskelements()
  {
    return (EReference)taskEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEpsilonTask()
  {
    return epsilonTaskEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLoadModelTask()
  {
    return loadModelTaskEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLoadModelTask_Parameters()
  {
    return (EReference)loadModelTaskEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLoadModelTask_Type()
  {
    return (EAttribute)loadModelTaskEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStoreModelTask()
  {
    return storeModelTaskEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStoreModelTask_Model()
  {
    return (EAttribute)storeModelTaskEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStoreModelTask_Target()
  {
    return (EAttribute)storeModelTaskEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParameterNestedElement()
  {
    return parameterNestedElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getParameterNestedElement_Name()
  {
    return (EAttribute)parameterNestedElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getParameterNestedElement_Value()
  {
    return (EAttribute)parameterNestedElementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVariableNestedElement()
  {
    return variableNestedElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVariableNestedElement_Ref()
  {
    return (EAttribute)variableNestedElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVariableNestedElement_As()
  {
    return (EAttribute)variableNestedElementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVariableNestedElement_Optional()
  {
    return (EAttribute)variableNestedElementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExportsNestedElement()
  {
    return exportsNestedElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUsesNestedElement()
  {
    return usesNestedElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModelNestedElement()
  {
    return modelNestedElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModelNestedElement_Ref()
  {
    return (EAttribute)modelNestedElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModelNestedElement_As()
  {
    return (EAttribute)modelNestedElementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExecutableModelTask()
  {
    return executableModelTaskEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getExecutableModelTask_Src()
  {
    return (EAttribute)executableModelTaskEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExecutableModelTask_Exports()
  {
    return (EReference)executableModelTaskEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExecutableModelTask_Uses()
  {
    return (EReference)executableModelTaskEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExecutableModelTask_Models()
  {
    return (EReference)executableModelTaskEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRollbackTransactionTask()
  {
    return rollbackTransactionTaskEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDisposeModelTask()
  {
    return disposeModelTaskEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDisposeModelTask_Model()
  {
    return (EAttribute)disposeModelTaskEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStartTransactionTask()
  {
    return startTransactionTaskEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStartTransactionTask_Models()
  {
    return (EAttribute)startTransactionTaskEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEolTask()
  {
    return eolTaskEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEmlTask()
  {
    return emlTaskEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEmlTask_UseMatchTrace()
  {
    return (EAttribute)emlTaskEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEmlTask_ExportTransformationTrace()
  {
    return (EAttribute)emlTaskEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEmlTask_ExportMergeTrace()
  {
    return (EAttribute)emlTaskEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEglTask()
  {
    return eglTaskEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEglTask_Target()
  {
    return (EAttribute)eglTaskEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEtlTask()
  {
    return etlTaskEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEtlTask_ExportTransformationTrace()
  {
    return (EAttribute)etlTaskEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEvlTask()
  {
    return evlTaskEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEvlTask_FailOnErrors()
  {
    return (EAttribute)evlTaskEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEvlTask_FailOnWarnings()
  {
    return (EAttribute)evlTaskEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEvlTask_ExportAsModel()
  {
    return (EAttribute)evlTaskEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEvlTask_ExportConstraintTrace()
  {
    return (EAttribute)evlTaskEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCommitTransactionTask()
  {
    return commitTransactionTaskEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTarget()
  {
    return targetEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTarget_TargetTasks()
  {
    return (EReference)targetEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTarget_Name()
  {
    return (EAttribute)targetEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTarget_ContainingProject()
  {
    return (EReference)targetEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTarget_Depends()
  {
    return (EReference)targetEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTarget_Description()
  {
    return (EAttribute)targetEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLoadEMFModelTask()
  {
    return loadEMFModelTaskEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLoadEMFModelTask_ModelFile()
  {
    return (EAttribute)loadEMFModelTaskEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLoadEMFModelTask_MetamodelFile()
  {
    return (EAttribute)loadEMFModelTaskEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLoadEMFModelTask_IsMetamodelFileBased()
  {
    return (EAttribute)loadEMFModelTaskEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLoadEMFModelTask_ReadOnLoad()
  {
    return (EAttribute)loadEMFModelTaskEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLoadEMFModelTask_MetamodelUri()
  {
    return (EAttribute)loadEMFModelTaskEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLoadEMFModelTask_StoreOnDisposal()
  {
    return (EAttribute)loadEMFModelTaskEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAttribute()
  {
    return attributeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAttribute_Name()
  {
    return (EAttribute)attributeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAttribute_Value()
  {
    return (EAttribute)attributeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNestedElement()
  {
    return nestedElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFlockTask()
  {
    return flockTaskEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFlockTask_OriginalModel()
  {
    return (EAttribute)flockTaskEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFlockTask_MigratedModel()
  {
    return (EAttribute)flockTaskEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEUnitTask()
  {
    return eUnitTaskEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEUnitTask_FailOnErrors()
  {
    return (EAttribute)eUnitTaskEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEUnitTask_Report()
  {
    return (EAttribute)eUnitTaskEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEUnitTask_ToDir()
  {
    return (EAttribute)eUnitTaskEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEUnitTask_Package()
  {
    return (EAttribute)eUnitTaskEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEclTask()
  {
    return eclTaskEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEclTask_UseMatchTrace()
  {
    return (EAttribute)eclTaskEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEclTask_ExportMatchTrace()
  {
    return (EAttribute)eclTaskEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDisposeModelsTask()
  {
    return disposeModelsTaskEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EweFactory getEweFactory()
  {
    return (EweFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    projectEClass = createEClass(PROJECT);
    createEAttribute(projectEClass, PROJECT__NAME);
    createEReference(projectEClass, PROJECT__TARGETS);
    createEReference(projectEClass, PROJECT__DEFAULT_TARGET);

    taskEClass = createEClass(TASK);
    createEAttribute(taskEClass, TASK__NAME);
    createEReference(taskEClass, TASK__FOLLOWS);
    createEReference(taskEClass, TASK__FOLLOWER);
    createEReference(taskEClass, TASK__ATTRIBUTES);
    createEReference(taskEClass, TASK__TASKELEMENTS);

    epsilonTaskEClass = createEClass(EPSILON_TASK);

    loadModelTaskEClass = createEClass(LOAD_MODEL_TASK);
    createEReference(loadModelTaskEClass, LOAD_MODEL_TASK__PARAMETERS);
    createEAttribute(loadModelTaskEClass, LOAD_MODEL_TASK__TYPE);

    storeModelTaskEClass = createEClass(STORE_MODEL_TASK);
    createEAttribute(storeModelTaskEClass, STORE_MODEL_TASK__MODEL);
    createEAttribute(storeModelTaskEClass, STORE_MODEL_TASK__TARGET);

    parameterNestedElementEClass = createEClass(PARAMETER_NESTED_ELEMENT);
    createEAttribute(parameterNestedElementEClass, PARAMETER_NESTED_ELEMENT__NAME);
    createEAttribute(parameterNestedElementEClass, PARAMETER_NESTED_ELEMENT__VALUE);

    variableNestedElementEClass = createEClass(VARIABLE_NESTED_ELEMENT);
    createEAttribute(variableNestedElementEClass, VARIABLE_NESTED_ELEMENT__REF);
    createEAttribute(variableNestedElementEClass, VARIABLE_NESTED_ELEMENT__AS);
    createEAttribute(variableNestedElementEClass, VARIABLE_NESTED_ELEMENT__OPTIONAL);

    exportsNestedElementEClass = createEClass(EXPORTS_NESTED_ELEMENT);

    usesNestedElementEClass = createEClass(USES_NESTED_ELEMENT);

    modelNestedElementEClass = createEClass(MODEL_NESTED_ELEMENT);
    createEAttribute(modelNestedElementEClass, MODEL_NESTED_ELEMENT__REF);
    createEAttribute(modelNestedElementEClass, MODEL_NESTED_ELEMENT__AS);

    executableModelTaskEClass = createEClass(EXECUTABLE_MODEL_TASK);
    createEAttribute(executableModelTaskEClass, EXECUTABLE_MODEL_TASK__SRC);
    createEReference(executableModelTaskEClass, EXECUTABLE_MODEL_TASK__EXPORTS);
    createEReference(executableModelTaskEClass, EXECUTABLE_MODEL_TASK__USES);
    createEReference(executableModelTaskEClass, EXECUTABLE_MODEL_TASK__MODELS);

    rollbackTransactionTaskEClass = createEClass(ROLLBACK_TRANSACTION_TASK);

    disposeModelTaskEClass = createEClass(DISPOSE_MODEL_TASK);
    createEAttribute(disposeModelTaskEClass, DISPOSE_MODEL_TASK__MODEL);

    startTransactionTaskEClass = createEClass(START_TRANSACTION_TASK);
    createEAttribute(startTransactionTaskEClass, START_TRANSACTION_TASK__MODELS);

    eolTaskEClass = createEClass(EOL_TASK);

    emlTaskEClass = createEClass(EML_TASK);
    createEAttribute(emlTaskEClass, EML_TASK__USE_MATCH_TRACE);
    createEAttribute(emlTaskEClass, EML_TASK__EXPORT_TRANSFORMATION_TRACE);
    createEAttribute(emlTaskEClass, EML_TASK__EXPORT_MERGE_TRACE);

    eglTaskEClass = createEClass(EGL_TASK);
    createEAttribute(eglTaskEClass, EGL_TASK__TARGET);

    etlTaskEClass = createEClass(ETL_TASK);
    createEAttribute(etlTaskEClass, ETL_TASK__EXPORT_TRANSFORMATION_TRACE);

    evlTaskEClass = createEClass(EVL_TASK);
    createEAttribute(evlTaskEClass, EVL_TASK__FAIL_ON_ERRORS);
    createEAttribute(evlTaskEClass, EVL_TASK__FAIL_ON_WARNINGS);
    createEAttribute(evlTaskEClass, EVL_TASK__EXPORT_AS_MODEL);
    createEAttribute(evlTaskEClass, EVL_TASK__EXPORT_CONSTRAINT_TRACE);

    commitTransactionTaskEClass = createEClass(COMMIT_TRANSACTION_TASK);

    targetEClass = createEClass(TARGET);
    createEReference(targetEClass, TARGET__TARGET_TASKS);
    createEAttribute(targetEClass, TARGET__NAME);
    createEReference(targetEClass, TARGET__CONTAINING_PROJECT);
    createEReference(targetEClass, TARGET__DEPENDS);
    createEAttribute(targetEClass, TARGET__DESCRIPTION);

    loadEMFModelTaskEClass = createEClass(LOAD_EMF_MODEL_TASK);
    createEAttribute(loadEMFModelTaskEClass, LOAD_EMF_MODEL_TASK__MODEL_FILE);
    createEAttribute(loadEMFModelTaskEClass, LOAD_EMF_MODEL_TASK__METAMODEL_FILE);
    createEAttribute(loadEMFModelTaskEClass, LOAD_EMF_MODEL_TASK__IS_METAMODEL_FILE_BASED);
    createEAttribute(loadEMFModelTaskEClass, LOAD_EMF_MODEL_TASK__READ_ON_LOAD);
    createEAttribute(loadEMFModelTaskEClass, LOAD_EMF_MODEL_TASK__METAMODEL_URI);
    createEAttribute(loadEMFModelTaskEClass, LOAD_EMF_MODEL_TASK__STORE_ON_DISPOSAL);

    attributeEClass = createEClass(ATTRIBUTE);
    createEAttribute(attributeEClass, ATTRIBUTE__NAME);
    createEAttribute(attributeEClass, ATTRIBUTE__VALUE);

    nestedElementEClass = createEClass(NESTED_ELEMENT);

    flockTaskEClass = createEClass(FLOCK_TASK);
    createEAttribute(flockTaskEClass, FLOCK_TASK__ORIGINAL_MODEL);
    createEAttribute(flockTaskEClass, FLOCK_TASK__MIGRATED_MODEL);

    eUnitTaskEClass = createEClass(EUNIT_TASK);
    createEAttribute(eUnitTaskEClass, EUNIT_TASK__FAIL_ON_ERRORS);
    createEAttribute(eUnitTaskEClass, EUNIT_TASK__REPORT);
    createEAttribute(eUnitTaskEClass, EUNIT_TASK__TO_DIR);
    createEAttribute(eUnitTaskEClass, EUNIT_TASK__PACKAGE);

    eclTaskEClass = createEClass(ECL_TASK);
    createEAttribute(eclTaskEClass, ECL_TASK__USE_MATCH_TRACE);
    createEAttribute(eclTaskEClass, ECL_TASK__EXPORT_MATCH_TRACE);

    disposeModelsTaskEClass = createEClass(DISPOSE_MODELS_TASK);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    epsilonTaskEClass.getESuperTypes().add(this.getTask());
    loadModelTaskEClass.getESuperTypes().add(this.getEpsilonTask());
    storeModelTaskEClass.getESuperTypes().add(this.getEpsilonTask());
    exportsNestedElementEClass.getESuperTypes().add(this.getVariableNestedElement());
    usesNestedElementEClass.getESuperTypes().add(this.getVariableNestedElement());
    executableModelTaskEClass.getESuperTypes().add(this.getEpsilonTask());
    rollbackTransactionTaskEClass.getESuperTypes().add(this.getEpsilonTask());
    disposeModelTaskEClass.getESuperTypes().add(this.getEpsilonTask());
    startTransactionTaskEClass.getESuperTypes().add(this.getEpsilonTask());
    eolTaskEClass.getESuperTypes().add(this.getExecutableModelTask());
    emlTaskEClass.getESuperTypes().add(this.getExecutableModelTask());
    eglTaskEClass.getESuperTypes().add(this.getExecutableModelTask());
    etlTaskEClass.getESuperTypes().add(this.getExecutableModelTask());
    evlTaskEClass.getESuperTypes().add(this.getExecutableModelTask());
    commitTransactionTaskEClass.getESuperTypes().add(this.getEpsilonTask());
    loadEMFModelTaskEClass.getESuperTypes().add(this.getLoadModelTask());
    nestedElementEClass.getESuperTypes().add(this.getTask());
    flockTaskEClass.getESuperTypes().add(this.getExecutableModelTask());
    eUnitTaskEClass.getESuperTypes().add(this.getExecutableModelTask());
    eclTaskEClass.getESuperTypes().add(this.getExecutableModelTask());
    disposeModelsTaskEClass.getESuperTypes().add(this.getEpsilonTask());

    // Initialize classes and features; add operations and parameters
    initEClass(projectEClass, Project.class, "Project", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getProject_Name(), ecorePackage.getEString(), "name", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getProject_Targets(), this.getTarget(), this.getTarget_ContainingProject(), "targets", null, 1, -1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getProject_DefaultTarget(), this.getTarget(), null, "defaultTarget", null, 1, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(taskEClass, Task.class, "Task", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTask_Name(), ecorePackage.getEString(), "name", null, 0, 1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTask_Follows(), this.getTask(), this.getTask_Follower(), "follows", null, 0, 1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTask_Follower(), this.getTask(), this.getTask_Follows(), "follower", null, 0, 1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTask_Attributes(), this.getAttribute(), null, "attributes", null, 0, -1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTask_Taskelements(), this.getNestedElement(), null, "taskelements", null, 0, -1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(epsilonTaskEClass, EpsilonTask.class, "EpsilonTask", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(loadModelTaskEClass, LoadModelTask.class, "LoadModelTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLoadModelTask_Parameters(), this.getParameterNestedElement(), null, "parameters", null, 0, -1, LoadModelTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLoadModelTask_Type(), ecorePackage.getEString(), "type", null, 0, 1, LoadModelTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(storeModelTaskEClass, StoreModelTask.class, "StoreModelTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getStoreModelTask_Model(), ecorePackage.getEString(), "model", null, 0, 1, StoreModelTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getStoreModelTask_Target(), ecorePackage.getEString(), "target", null, 0, 1, StoreModelTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(parameterNestedElementEClass, ParameterNestedElement.class, "ParameterNestedElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getParameterNestedElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, ParameterNestedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getParameterNestedElement_Value(), ecorePackage.getEString(), "value", null, 0, 1, ParameterNestedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(variableNestedElementEClass, VariableNestedElement.class, "VariableNestedElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVariableNestedElement_Ref(), ecorePackage.getEString(), "ref", null, 0, 1, VariableNestedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVariableNestedElement_As(), ecorePackage.getEString(), "as", null, 0, 1, VariableNestedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVariableNestedElement_Optional(), ecorePackage.getEString(), "optional", null, 0, 1, VariableNestedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(exportsNestedElementEClass, ExportsNestedElement.class, "ExportsNestedElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(usesNestedElementEClass, UsesNestedElement.class, "UsesNestedElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(modelNestedElementEClass, ModelNestedElement.class, "ModelNestedElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getModelNestedElement_Ref(), ecorePackage.getEString(), "ref", null, 1, 1, ModelNestedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getModelNestedElement_As(), ecorePackage.getEString(), "as", null, 0, 1, ModelNestedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(executableModelTaskEClass, ExecutableModelTask.class, "ExecutableModelTask", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getExecutableModelTask_Src(), ecorePackage.getEString(), "src", null, 1, 1, ExecutableModelTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getExecutableModelTask_Exports(), this.getExportsNestedElement(), null, "exports", null, 0, -1, ExecutableModelTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getExecutableModelTask_Uses(), this.getUsesNestedElement(), null, "uses", null, 0, -1, ExecutableModelTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getExecutableModelTask_Models(), this.getModelNestedElement(), null, "models", null, 0, -1, ExecutableModelTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(rollbackTransactionTaskEClass, RollbackTransactionTask.class, "RollbackTransactionTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(disposeModelTaskEClass, DisposeModelTask.class, "DisposeModelTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDisposeModelTask_Model(), ecorePackage.getEString(), "model", null, 0, 1, DisposeModelTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(startTransactionTaskEClass, StartTransactionTask.class, "StartTransactionTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getStartTransactionTask_Models(), ecorePackage.getEString(), "models", null, 0, -1, StartTransactionTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(eolTaskEClass, EolTask.class, "EolTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(emlTaskEClass, EmlTask.class, "EmlTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEmlTask_UseMatchTrace(), ecorePackage.getEString(), "useMatchTrace", null, 0, 1, EmlTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getEmlTask_ExportTransformationTrace(), ecorePackage.getEString(), "exportTransformationTrace", null, 0, 1, EmlTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getEmlTask_ExportMergeTrace(), ecorePackage.getEString(), "exportMergeTrace", null, 0, 1, EmlTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(eglTaskEClass, EglTask.class, "EglTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEglTask_Target(), ecorePackage.getEString(), "target", null, 1, 1, EglTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(etlTaskEClass, EtlTask.class, "EtlTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEtlTask_ExportTransformationTrace(), ecorePackage.getEString(), "exportTransformationTrace", null, 0, 1, EtlTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(evlTaskEClass, EvlTask.class, "EvlTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEvlTask_FailOnErrors(), ecorePackage.getEBoolean(), "failOnErrors", null, 0, 1, EvlTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getEvlTask_FailOnWarnings(), ecorePackage.getEBoolean(), "failOnWarnings", null, 0, 1, EvlTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getEvlTask_ExportAsModel(), ecorePackage.getEBoolean(), "exportAsModel", null, 0, 1, EvlTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getEvlTask_ExportConstraintTrace(), ecorePackage.getEString(), "exportConstraintTrace", "", 0, 1, EvlTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(commitTransactionTaskEClass, CommitTransactionTask.class, "CommitTransactionTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(targetEClass, Target.class, "Target", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTarget_TargetTasks(), this.getTask(), null, "targetTasks", null, 1, -1, Target.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTarget_Name(), ecorePackage.getEString(), "name", null, 0, 1, Target.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTarget_ContainingProject(), this.getProject(), this.getProject_Targets(), "containingProject", null, 1, 1, Target.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTarget_Depends(), this.getTarget(), null, "depends", null, 0, -1, Target.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTarget_Description(), ecorePackage.getEString(), "description", null, 0, 1, Target.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(loadEMFModelTaskEClass, LoadEMFModelTask.class, "LoadEMFModelTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLoadEMFModelTask_ModelFile(), ecorePackage.getEString(), "modelFile", "", 1, 1, LoadEMFModelTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLoadEMFModelTask_MetamodelFile(), ecorePackage.getEString(), "metamodelFile", null, 0, 1, LoadEMFModelTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLoadEMFModelTask_IsMetamodelFileBased(), ecorePackage.getEBoolean(), "isMetamodelFileBased", null, 0, 1, LoadEMFModelTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLoadEMFModelTask_ReadOnLoad(), ecorePackage.getEBoolean(), "readOnLoad", null, 0, 1, LoadEMFModelTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLoadEMFModelTask_MetamodelUri(), ecorePackage.getEString(), "metamodelUri", null, 0, 1, LoadEMFModelTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLoadEMFModelTask_StoreOnDisposal(), ecorePackage.getEBoolean(), "storeOnDisposal", null, 0, 1, LoadEMFModelTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(attributeEClass, Attribute.class, "Attribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAttribute_Name(), ecorePackage.getEString(), "name", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAttribute_Value(), ecorePackage.getEString(), "value", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nestedElementEClass, NestedElement.class, "NestedElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(flockTaskEClass, FlockTask.class, "FlockTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFlockTask_OriginalModel(), ecorePackage.getEString(), "originalModel", null, 0, 1, FlockTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFlockTask_MigratedModel(), ecorePackage.getEString(), "migratedModel", null, 0, 1, FlockTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(eUnitTaskEClass, EUnitTask.class, "EUnitTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEUnitTask_FailOnErrors(), ecorePackage.getEBoolean(), "failOnErrors", null, 0, 1, EUnitTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getEUnitTask_Report(), ecorePackage.getEString(), "report", "no", 0, 1, EUnitTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getEUnitTask_ToDir(), ecorePackage.getEString(), "toDir", null, 0, 1, EUnitTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getEUnitTask_Package(), ecorePackage.getEString(), "package", null, 0, 1, EUnitTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(eclTaskEClass, EclTask.class, "EclTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEclTask_UseMatchTrace(), ecorePackage.getEString(), "useMatchTrace", null, 0, 1, EclTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getEclTask_ExportMatchTrace(), ecorePackage.getEString(), "exportMatchTrace", null, 0, 1, EclTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(disposeModelsTaskEClass, DisposeModelsTask.class, "DisposeModelsTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(eNS_URI);

    // Create annotations
    // gmf.diagram
    createGmfAnnotations();
    // gmf.node
    createGmf_1Annotations();
    // http:///org/eclipse/emf/ecore/util/ExtendedMetaData
    createExtendedMetaDataAnnotations();
    // gmf.link
    createGmf_2Annotations();
    // gmf.compartment
    createGmf_3Annotations();
  }

  /**
   * Initializes the annotations for <b>gmf.diagram</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void createGmfAnnotations()
  {
    String source = "gmf.diagram";		
    addAnnotation
      (projectEClass, 
       source, 
       new String[] 
       {
       "note", "Root class"
       });																									
  }

  /**
   * Initializes the annotations for <b>gmf.node</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void createGmf_1Annotations()
  {
    String source = "gmf.node";			
    addAnnotation
      (taskEClass, 
       source, 
       new String[] 
       {
       "label", "name",
       "border.width", "2",
       "border.color", "0,0,0",
       "color", "249,249,213"
       });				
    addAnnotation
      (loadModelTaskEClass, 
       source, 
       new String[] 
       {
       "tool.name", "Load Model Task"
       });		
    addAnnotation
      (storeModelTaskEClass, 
       source, 
       new String[] 
       {
       "tool.name", "Store Model Task"
       });		
    addAnnotation
      (getParameterNestedElement_Name(), 
       source, 
       new String[] 
       {
       "label", "name"
       });		
    addAnnotation
      (executableModelTaskEClass, 
       source, 
       new String[] 
       {
       "label", "src"
       });		
    addAnnotation
      (rollbackTransactionTaskEClass, 
       source, 
       new String[] 
       {
       "tool.name", "Rollback Transaction Task"
       });		
    addAnnotation
      (disposeModelTaskEClass, 
       source, 
       new String[] 
       {
       "tool.name", "Dispose Model Task"
       });		
    addAnnotation
      (startTransactionTaskEClass, 
       source, 
       new String[] 
       {
       "tool.name", "Start Transaction Task"
       });		
    addAnnotation
      (eolTaskEClass, 
       source, 
       new String[] 
       {
       "tool.name", "EOL Task"
       });		
    addAnnotation
      (emlTaskEClass, 
       source, 
       new String[] 
       {
       "tool.name", "EML Task"
       });		
    addAnnotation
      (eglTaskEClass, 
       source, 
       new String[] 
       {
       "tool.name", "EGL Task"
       });		
    addAnnotation
      (etlTaskEClass, 
       source, 
       new String[] 
       {
       "tool.name", "ETL Task"
       });		
    addAnnotation
      (evlTaskEClass, 
       source, 
       new String[] 
       {
       "tool.name", "EVL Task"
       });		
    addAnnotation
      (commitTransactionTaskEClass, 
       source, 
       new String[] 
       {
       "tool.name", "Commit Transaction Task"
       });		
    addAnnotation
      (targetEClass, 
       source, 
       new String[] 
       {
       "label", "name",
       "border.width", "2",
       "border.color", "0,0,0"
       });					
    addAnnotation
      (loadEMFModelTaskEClass, 
       source, 
       new String[] 
       {
       "tool.name", "Load EMF Model Task"
       });		
    addAnnotation
      (flockTaskEClass, 
       source, 
       new String[] 
       {
       "tool.name", "Flock Task"
       });		
    addAnnotation
      (eUnitTaskEClass, 
       source, 
       new String[] 
       {
       "tool.name", "EUnit Task"
       });		
    addAnnotation
      (eclTaskEClass, 
       source, 
       new String[] 
       {
       "tool.name", "ECL Task"
       });		
    addAnnotation
      (disposeModelsTaskEClass, 
       source, 
       new String[] 
       {
       "tool.name", "Dispose Models Task"
       });
  }

  /**
   * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void createExtendedMetaDataAnnotations()
  {
    String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";				
    addAnnotation
      (getTask_Name(), 
       source, 
       new String[] 
       {
       "namespace", ""
       });																							
  }

  /**
   * Initializes the annotations for <b>gmf.link</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void createGmf_2Annotations()
  {
    String source = "gmf.link";					
    addAnnotation
      (getTask_Follows(), 
       source, 
       new String[] 
       {
       "label", "follows",
       "target.decoration", "arrow",
       "style", "dash",
       "width", "2",
       "tool.small.bundle", "Epsilon_Workflow_Editor.edit",
       "tool.small.path", "icons/full/obj16/Follows.gif"
       });																		
    addAnnotation
      (getTarget_Depends(), 
       source, 
       new String[] 
       {
       "label", "depends",
       "target.decoration", "filledclosedarrow",
       "style", "dash",
       "width", "3",
       "tool.small.bundle", "Epsilon_Workflow_Editor.edit",
       "tool.small.path", "icons/full/obj16/Depends.gif"
       });					
  }

  /**
   * Initializes the annotations for <b>gmf.compartment</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void createGmf_3Annotations()
  {
    String source = "gmf.compartment";																				
    addAnnotation
      (getTarget_TargetTasks(), 
       source, 
       new String[] 
       {
       "note", "targetTasks"
       });		
    addAnnotation
      (getTarget_ContainingProject(), 
       source, 
       new String[] 
       {
       "note", "targets"
       });						
  }

} //EwePackageImpl
