package unittesting.slides.junit5advanced;

import org.junit.jupiter.api.extension.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.extension.ExtensionContext.Namespace.create;

public class MyExtension implements BeforeEachCallback, AfterEachCallback, BeforeAllCallback, AfterAllCallback {

    private static final Logger LOG = LoggerFactory.getLogger(MyExtension.class);

    private final String SOMETHING = "something";
    private final String SOMETHINGELSE = "somethingelse";
    private ExtensionContext.Namespace COM_EXAMPLE = create("com.example");

    @Override
    public void beforeEach(ExtensionContext context) {
        context.getStore(COM_EXAMPLE).put(SOMETHING, 42);
        log("beforeEach called");
    }

    @Override
    public void afterEach(ExtensionContext context) {
        Object something = context.getStore(COM_EXAMPLE).get(SOMETHING);
        log("afterEach called; something = " + something);
    }

    @Override
    public void beforeAll(ExtensionContext context) {
        context.getStore(COM_EXAMPLE).put(SOMETHINGELSE, 666);
        log("beforeAll called");
    }

    @Override
    public void afterAll(ExtensionContext context) {
        Object somethingelse = context.getStore(COM_EXAMPLE).get(SOMETHINGELSE);
        log("afterAll called; somethingelse = " + somethingelse);
    }

    private void log(String msg) {
        LOG.debug(msg);
    }
}
