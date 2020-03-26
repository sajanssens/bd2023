package unittesting.slides.mocking.all;

import org.hamcrest.Factory;
import org.mockito.ArgumentMatcher;

public class IsValidString implements ArgumentMatcher<String> {

    @Override
    public boolean matches(String s) { return s.length() > 5; }

    @Factory
    public static ArgumentMatcher<String> isValid() {
        return new IsValidString();
    }

    @Override
    public String toString() { return "not > 5"; }
}
