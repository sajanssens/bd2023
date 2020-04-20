package javabd.labs.h12_annotations.lab;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyClass1Test {

    @Test
    public void testThrowsNumberFormatException() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            throw new NumberFormatException();
        });

    }
}