package javabd.examples.patterns.singleton;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

public class SingletonTest {

    @Test
    void testNormalClass() {
        NormalClass normalClass1 = new NormalClass("Ann");
        NormalClass normalClass2 = new NormalClass("Vincent");
        System.out.println("normalClass1 " + normalClass1);
        System.out.println("normalClass2 " + normalClass2);
        assertNotSame(normalClass1, normalClass2);
    }

    @Test
    void testSingleton() {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println("singleton1 " + singleton1);
        System.out.println("singleton2 " + singleton2);
        assertSame(singleton1, singleton2);
    }

    private static List<SingletonThreadingIssue> singletonThreadingIssueList = new ArrayList<>();

    @Test
    void testSingletonThreadingIssue() {
        new Thread(() -> singletonThreadingIssueList.add(SingletonThreadingIssue.getInstance())).start();
        new Thread(() -> singletonThreadingIssueList.add(SingletonThreadingIssue.getInstance())).start();

        await().atMost(5, TimeUnit.SECONDS).until(() -> singletonThreadingIssueList.size() == 2);

        SingletonThreadingIssue singleton0 = singletonThreadingIssueList.get(0);
        SingletonThreadingIssue singleton1 = singletonThreadingIssueList.get(1);

        System.out.println(singleton0);
        System.out.println(singleton1);
        assertNotSame(singleton0, singleton1);
    }

    private static List<SingletonThreadSafeSynchronized> singletonThreadSafeSynchronizedList = new ArrayList<>();

    @Test
    void testSingletonThreadSafeSynchronized() {
        new Thread(() -> singletonThreadSafeSynchronizedList.add(SingletonThreadSafeSynchronized.getInstance())).start();
        new Thread(() -> singletonThreadSafeSynchronizedList.add(SingletonThreadSafeSynchronized.getInstance())).start();

        await().atMost(5, TimeUnit.SECONDS).until(() -> singletonThreadSafeSynchronizedList.size() == 2);

        SingletonThreadSafeSynchronized singleton0 = singletonThreadSafeSynchronizedList.get(0);
        SingletonThreadSafeSynchronized singleton1 = singletonThreadSafeSynchronizedList.get(1);

        System.out.println(singleton0);
        System.out.println(singleton1);
        assertSame(singleton0, singleton1);
    }

    @Test
    void testSingletonThreadSafe() {
        SingletonThreadSafe singletonThreadSafe0 = SingletonThreadSafe.getInstance();
        SingletonThreadSafe singletonThreadSafe1 = SingletonThreadSafe.getInstance();
        // No lazy initialization, but also no need for locks
        assertSame(singletonThreadSafe0, singletonThreadSafe1);
    }

}
