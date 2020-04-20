package javabd.labs.h9_creatinganddestroyingobjects;

import javabd.labs.h7_objectorientation.Gender;
import javabd.labs.h8_referencetypes.Person;
import org.junit.jupiter.api.Test;

class PersonTest {

    @Test
    void testGC() throws InterruptedException {
        Person p = new Person("Jan", 45, Gender.MALE);
        System.out.println("1");
        p = null;
        System.out.println("2");
        System.gc();
        System.out.println("3");
        Thread.sleep(1000);
        System.out.println("4");
    }


}