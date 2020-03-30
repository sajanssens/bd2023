package javabd.labs.h8_referencetypes;

import javabd.labs.h7_objectorientation.Gender;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testToString() {
        Person p = new Person("Jan", 45);
        p.setGender(Gender.MALE);
        System.out.println(p);
    }

    @Test
    void testEquals() {
        Person p1 = new Person("Jan", 45);
        Person p2 = new Person("Jan", 45);
        Person p3 = new Person("Piet", 44);
        p3.setGender(Gender.MALE);

        assertEquals(p1, p2);
        assertNotEquals(p1, p3);
        assertFalse(p1.equals(""));
    }

    @Test
    void testHashcode() {
        Person p1 = new Person("Jan", 45);
        Person p2 = new Person("Jan", 45);
        Person p3 = new Person("Piet", 44);
        p3.setGender(Gender.MALE);

        assertEquals(p1.hashCode(), p2.hashCode());
        assertNotEquals(p1.hashCode(), p3.hashCode());
    }

    @Test
    void testReflection() {
        // Person p1 = new Person("Jan", 45);

        Method[] declaredMethods = Person.class.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method.getName());
            Annotation[] declaredAnnotations = method.getAnnotations();
            for (Annotation declaredAnnotation : declaredAnnotations) {
                System.out.println(declaredAnnotation.toString());
            }
        }

        Field[] declaredFields = Person.class.getDeclaredFields();
        for (Field f : declaredFields) {
            System.out.println(f.getName());
        }
    }
}