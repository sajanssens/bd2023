package unittesting.slides.junit5;

public class NoEntityFoundException extends RuntimeException {
    public NoEntityFoundException(String m) {
        super(m);
    }
}
