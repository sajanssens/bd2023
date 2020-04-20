package javabd.examples.patterns.singleton;

public class SingletonThreadSafe {
    private static final SingletonThreadSafe instance = new SingletonThreadSafe();

    private SingletonThreadSafe() {
    }

    public static SingletonThreadSafe getInstance() {
        return instance;
    }
}
