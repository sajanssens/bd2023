package javabd.labs.h13_generics;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MyCollectionGenericTest {
    @Test
    void testCollection() {
        MyCollectionGeneric<String> c = new MyCollectionGeneric<>();
        c.add("1");
        c.add("2");
        c.add("3");
        c.add("4");
        c.add("5");

        for (int i = 0; i < c.getLength(); i++) {
            System.out.println(c.get(i));
        }

        assertThat(c.get(2)).isEqualTo("3");
        assertThat(c.getLength()).isEqualTo(5);
    }
}