package unittesting.slides.mocking.simple;

public class Hellor {

    private ExternalSystem externalSystem = new ExternalSystem();

    public String hello() {
        return externalSystem.get();
    }

    public String hello(int i) {
        return externalSystem.get() + i;
    }
}
