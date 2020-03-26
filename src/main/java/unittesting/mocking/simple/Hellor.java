package unittesting.mocking.simple;

public class Hellor {

    private ExternalSystem externalSystem = new ExternalSystem();

    public String hello() {
        String message = externalSystem.get();
        return message;
    }

    public String hello(int i) {
        return externalSystem.get() + i;
    }
}
