package javabd.examples.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4j2Example {
    // SLF4J is a facade to use different logging frameworks
    Logger log = LoggerFactory.getLogger(this.getClass().getName());

    public void logMethod() throws InterruptedException {
        log.info("This is an info message");
        log.debug("This is a debug message");
        log.error("Error! Error!");
        for (int i = 0; i < 100; i++) {
            log.error("Error! Error! inside loop");
        }
    }
}
