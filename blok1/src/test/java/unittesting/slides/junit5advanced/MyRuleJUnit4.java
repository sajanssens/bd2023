package unittesting.slides.junit5advanced;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyRuleJUnit4 implements TestRule {

    private static final Logger LOG = LoggerFactory.getLogger(MyRuleJUnit4.class);
    private final String message;

    public MyRuleJUnit4(String message) {
        this.message = message;
    }

    @Override
    public Statement apply(Statement base, Description description) {
        log("Before apply " + message, description);
        try {
            return new Statement() {
                @Override
                public void evaluate() throws Throwable {
                    log("Before evaluate " + message, description);
                    base.evaluate();
                    log("After evaluate " + message, description);
                }
            };
        } finally {
            log("After apply " + message, description);
        }
    }

    private void log(String msg, Description description) {
        LOG.debug(msg + description.getMethodName());
    }
}
