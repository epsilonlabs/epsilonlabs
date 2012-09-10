/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ewe.tests;

import ewe.EweFactory;
import ewe.Target;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Target</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class TargetTest extends TestCase
{

  /**
   * The fixture for this Target test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Target fixture = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args)
  {
    TestRunner.run(TargetTest.class);
  }

  /**
   * Constructs a new Target test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TargetTest(String name)
  {
    super(name);
  }

  /**
   * Sets the fixture for this Target test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void setFixture(Target fixture)
  {
    this.fixture = fixture;
  }

  /**
   * Returns the fixture for this Target test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Target getFixture()
  {
    return fixture;
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
    setFixture(EweFactory.eINSTANCE.createTarget());
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

} //TargetTest
