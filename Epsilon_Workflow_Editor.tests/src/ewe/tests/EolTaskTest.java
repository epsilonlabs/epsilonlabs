/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ewe.tests;

import ewe.EolTask;
import ewe.EweFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Eol Task</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class EolTaskTest extends ExecutableModelTaskTest
{

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args)
  {
    TestRunner.run(EolTaskTest.class);
  }

  /**
   * Constructs a new Eol Task test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EolTaskTest(String name)
  {
    super(name);
  }

  /**
   * Returns the fixture for this Eol Task test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EolTask getFixture()
  {
    return (EolTask)fixture;
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
    setFixture(EweFactory.eINSTANCE.createEolTask());
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

} //EolTaskTest
