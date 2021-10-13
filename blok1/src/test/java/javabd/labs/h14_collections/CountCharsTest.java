package javabd.labs.h14_collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class CountCharsTest {

    private CountChars target;
    private final String hello_world = "Hello World";

    @BeforeEach
    void setUp() {
        target = new CountChars();
    }

    @Test
    void countClassicStyle() {
        long result = target.countClassicStyle(hello_world);

        assertThat(result).isEqualTo(8);
    }

    @Test
    void countStreamingStyle() {
        long result = target.countStreamingStyle(hello_world);

        assertThat(result).isEqualTo(8);
    }

    @Test
    void concordanceClassicStyle() {
        var result = target.concordanceClassicStyle(hello_world);

        assertThat(result).isNotEmpty().hasSize(7);
        assertThat(result).contains(entry('H', List.of(0)));
        assertThat(result).contains(entry('l', List.of(2, 3, 9)));
        assertThat(result).contains(entry('o', List.of(4, 7)));
    }

    @Test
    void concordanceStreamingStyle() {
        var result = target.concordanceStreamingStyle(hello_world);

        assertThat(result).isNotEmpty().hasSize(7);
        assertThat(result).contains(entry("H", List.of(0)));
        assertThat(result).contains(entry("l", List.of(2, 3, 9)));
        assertThat(result).contains(entry("o", List.of(4, 7)));
    }
}
