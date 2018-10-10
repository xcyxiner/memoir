package com.britreasure.memoir;

import com.britreasure.memoir.config.StudentPropertiesTestJunit;
import com.britreasure.memoir.controller.HelloControllerTestJunit;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author xcyxiner
 * @create: 2018-10-09 下午5:36
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({StudentPropertiesTestJunit.class, HelloControllerTestJunit.class})
public class TestSuits {

}
