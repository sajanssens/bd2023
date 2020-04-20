package javabd.examples.patterns.singleton;

public class SingletonThreadSafeSynchronized {
    private static SingletonThreadSafeSynchronized instance;

    private SingletonThreadSafeSynchronized() {

    }

    public static SingletonThreadSafeSynchronized getInstance() {
        if (instance == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (SingletonThreadSafeSynchronized.class) {
                if (instance == null) {
                    System.out.println("Creating new instance " + SingletonThreadSafeSynchronized.class.getSimpleName());
                    instance = new SingletonThreadSafeSynchronized();
                }
            }
        }
        return instance;
    }
}
