/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ewe.tests;

import ewe.EmlTask;
import ewe.EweFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Eml Task</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class EmlTaskTest extends ExecutableModelTaskTest
{

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args)
  {
    TestRunner.run(EmlTaskTest.class);
  }

  /**
   * Constructs a new Eml Task test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EmlTaskTest(String name)
  {
    super(name);
  }

  /**
   * Returns the fixture for this Eml Task test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EmlTask getFixture()
  {
    return (EmlTask)fixture;
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
    setFixture(EweFactory.eINSTANCE.createEmlTask());
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

} //EmlTaskTest
