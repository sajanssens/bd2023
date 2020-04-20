package unittesting.slides.matchers.assertj.assertions;

import org.assertj.core.api.AbstractAssert;

public class NotANumberChecker extends AbstractAssert<NotANumberChecker, Double> {

    public NotANumberChecker(Double actual) {
        super(actual, NotANumberChecker.class);
    }

    public static NotANumberChecker assertThat(Double actual) {
        return new NotANumberChecker(actual);
    }

    public NotANumberChecker isNotANumber() {
        if (!actual.isNaN()) {
            failWithMessage("Expected NaN but was <%s>", actual);
        }
        return this;
    }
}