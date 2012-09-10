/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ewe.tests;

import ewe.EweFactory;
import ewe.StoreModelTask;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Store Model Task</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class StoreModelTaskTest extends EpsilonTaskTest
{

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args)
  {
    TestRunner.run(StoreModelTaskTest.class);
  }

  /**
   * Constructs a new Store Model Task test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StoreModelTaskTest(String name)
  {
    super(name);
  }

  /**
   * Returns the fixture for this Store Model Task test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected StoreModelTask getFixture()
  {
    return (StoreModelTask)fixture;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see junit.framework.TestCase#setUp()
   * @generated
   */
  @Override
  protected void setUp() throws Exception
  {
    setFixture(EweFactory.eINSTANCE.createStoreModelTask());
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see junit.framework.TestCase#tearDown()
   * @generated
   */
  @Override
  protected void tearDown() throws Exception
  {
    setFixture(null);
  }

} //StoreModelTaskTest
