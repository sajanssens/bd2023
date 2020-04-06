package javabd.labs.h14_collections;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class MyCollectionGenericTest {

    @Test
    void testCollection() {
        MyCollectionGeneric<String> c = new MyCollectionGeneric<>();
        c.add("1");
        c.add("2");
        c.add("3");
        c.add("4");
        c.add("5");

        assertThat(c.getLength(), is(5));
        assertFalse(c.isEmpty());

        c.remove("3");
        assertThat(c.getLength(), is(4));
        assertThat(c.get(3), is("5"));
        assertFalse(c.contains("3"));

        assertTrue(c.containsAll(Arrays.asList("1", "2")));

        c.addAll(Arrays.asList("10", "20"));
        assertThat(c.getLength(), is(6));
        assertTrue(c.containsAll(Arrays.asList("10", "20")));

        c.removeAll(Arrays.asList("10", "20"));
        assertThat(c.getLength(), is(4));
        assertFalse(c.containsAll(Arrays.asList("10", "20")));

        c.retainAll(Arrays.asList("1", "2"));
        assertThat(c.getLength(), is(2));
        assertTrue(c.containsAll(Arrays.asList("1", "2")));
        assertFalse(c.containsAll(Arrays.asList("4", "5", "10", "20")));

        System.out.println("c.toArray():");
        Object[] objects = c.toArray();
        for (Object object : objects) {
            System.out.println(object);
        }

        System.out.println("c.toArray(new String[c.size()]):");
        String[] strings = c.toArray(new String[c.size()]);
        for (String object : strings) {
            System.out.println(object);
        }
        System.out.println("c.iterator():");
        Iterator<String> iterator = c.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("c foreach:");
        for (String s : c) {
            System.out.println(s);
        }

    }
}