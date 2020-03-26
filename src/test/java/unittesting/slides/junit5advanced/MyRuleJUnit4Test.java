package unittesting.slides.junit5advanced;

import org.junit.Rule;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyRuleJUnit4Test {

    private static final Logger LOG = LoggerFactory.getLogger(MyRuleJUnit4Test.class);

    @Rule
    public MyRuleJUnit4 myRuleJUnit4 = new MyRuleJUnit4("Standalone rule");

    @Test
    public void testMyRuleJUnit4() { LOG.debug("testMyRuleJUnit4 called"); }
}