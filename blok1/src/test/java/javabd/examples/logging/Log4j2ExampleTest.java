package javabd.examples.logging;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Log4j2ExampleTest {

    @Test
    @Disabled
    public void log4j2Test() throws IOException, InterruptedException {
        Log4j2Example log4j2Example = new Log4j2Example();
        log4j2Example.logMethod();

        int linesInErrorLogFile = 0;

        Path errorLogPath = Paths.get("target", "error.log");
        linesInErrorLogFile += Files.lines(errorLogPath).count();
        assertTrue(Files.exists(errorLogPath));

        for (int i = 1; i < 4; i++) {
            Path path = Paths.get("target", "error-" + LocalDate.now() + "." + i + ".log");
            linesInErrorLogFile += Files.lines(path).count();
            assertTrue(Files.exists(path));
        }

        assertEquals(101, linesInErrorLogFile);
    }
}
