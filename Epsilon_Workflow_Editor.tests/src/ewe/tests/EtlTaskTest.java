/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ewe.tests;

import ewe.EtlTask;
import ewe.EweFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Etl Task</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class EtlTaskTest extends ExecutableModelTaskTest
{

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args)
  {
    TestRunner.run(EtlTaskTest.class);
  }

  /**
   * Constructs a new Etl Task test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EtlTaskTest(String name)
  {
    super(name);
  }

  /**
   * Returns the fixture for this Etl Task test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EtlTask getFixture()
  {
    return (EtlTask)fixture;
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
    setFixture(EweFactory.eINSTANCE.createEtlTask());
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

} //EtlTaskTest
