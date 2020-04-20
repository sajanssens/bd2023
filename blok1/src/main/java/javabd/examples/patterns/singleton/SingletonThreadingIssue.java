package javabd.examples.patterns.singleton;

public class SingletonThreadingIssue {
    private static SingletonThreadingIssue instance;

    private SingletonThreadingIssue() {

    }

    public static SingletonThreadingIssue getInstance() {
        if (instance == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Creating new instance " + SingletonThreadingIssue.class.getSimpleName());
            instance = new SingletonThreadingIssue();
        }
        return instance;
    }
}
