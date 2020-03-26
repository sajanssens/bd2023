package unittesting.slides.junit5;

import org.junit.jupiter.api.*;

class RenamingOfLifecycleNamesTest {
    @BeforeAll
    static void beforeAll() { System.out.println("beforeAll"); }
    @AfterAll
    static void afterAll() { System.out.println("afterAll"); }

    @BeforeEach
    void beforeEach() { System.out.println("beforeEach"); }
    @AfterEach
    void afterEach() { System.out.println("afterEach");}

    @RepeatedTest(2)
    void test(RepetitionInfo ri) {
        System.out.println("testing repetition " + ri.getCurrentRepetition());
    }
}
