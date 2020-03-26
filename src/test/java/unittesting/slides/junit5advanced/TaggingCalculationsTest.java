package unittesting.slides.junit5advanced;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("calculations")
class TaggingCalculationsTest {

    @Test
    @Tag("taxes")
    void testingTaxCalculation() {
        System.out.println("testingTaxCalculation");
    }

    @Test
    @Tag("vat")
    void testingVatCalculation() {
        System.out.println("testingVatCalculation");
    }

}

@Tag("model")
@Tag("surefire")
class TaggingModelTest {

    @Test
    void testingTaxEntity() {
        System.out.println("testingTaxEntity");
    }
}
