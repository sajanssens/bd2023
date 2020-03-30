package javabd.labs.h10_inheritance.micro;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {
    private RegularCard regularCard;
    private GoldCard goldCard;

    @BeforeEach
    void setup() {
        // Given
        regularCard = new RegularCard(1234, "Robert", 1000);
        goldCard = new GoldCard(1234, "Robert", 1000, 10);
    }

    @Test
    @DisplayName("Testing pay() of RegularCard")
    void regularCardPayTest() {
        // When
        boolean actualResult1 = regularCard.pay(500);
        double actualResult2 = regularCard.getCredit();
        boolean actualResult3 = regularCard.pay(1500);

        // Then
        assertAll(
                () -> assertTrue(actualResult1),
                () -> assertEquals(500, actualResult2),
                () -> assertFalse(actualResult3)
        );
    }

    //TODO Add toStringRegularCardTest

    @Test
    @DisplayName("Testing pay() of GoldCard")
    void goldCardPayTest() {
        // When
        boolean actualResult1 = goldCard.pay(500);
        double actualResult2 = goldCard.getCredit();
        boolean actualResult3 = goldCard.pay(1500);

        // Then
        assertAll(
                () -> assertTrue(actualResult1),
                () -> assertEquals(550, actualResult2),
                () -> assertFalse(actualResult3)
        );
    }

    @Test
    @DisplayName("Testing setDiscount() with amount > 30 of GoldCard")
    void goldCardSetDiscountTest() throws ArgumentOutOfRangeException {
        // When
        ArgumentOutOfRangeException e = assertThrows(ArgumentOutOfRangeException.class, () -> goldCard.setDiscount(50));
        String actualResult = e.getMessage();
        String expectedResult = "Invalid discount has been assigned!";

        // Then
        assertEquals(expectedResult, actualResult);
    }

    // Test discount percentage
    @Test
    @DisplayName("Testing getDiscountPercentage() of GoldCard")
    void goldCardDiscountPercentageTest() {
        // When
        double actualResult1 = goldCard.getDiscountPercentage();
        goldCard.setDiscount(30);
        double actualResult2 = goldCard.getDiscountPercentage();

        // Then
        assertAll(
                () -> assertEquals(0.9D, actualResult1),
                () -> assertEquals(0.7D, actualResult2)
        );
    }

    //TODO Add toStringGoldCardTest

    //TODO Add microClientAdministrationCardLookupTest

    //TODO Add microClientAdministrationPerformPaymentTest
}