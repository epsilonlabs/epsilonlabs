package org.eclipse.epsilon.coverage.test.unit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ EOLCoverageTest.class, ECLCoverageTest.class, ETLCoverageTest.class })
public class EpsilonCoverageUnitTestSuite {

}
