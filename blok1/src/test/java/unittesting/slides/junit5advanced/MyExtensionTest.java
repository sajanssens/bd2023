package unittesting.slides.junit5advanced;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ExtendWith(MyExtension.class)
class MyExtensionTest {
    private static final Logger LOG = LoggerFactory.getLogger(MyRuleJUnit4.class);

    @Test void testMyExtension() { LOG.debug("testMyExtension called"); }

}

