package unittesting.slides.mocking.simple;

public class ExternalSystem {

    public String get() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
        return "hello from database";
    }

}
