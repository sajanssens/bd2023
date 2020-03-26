package unittesting.slides.mocking.all;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SpyVsMockExamplesTest {
    @Mock
    List<String> mockList;
    @Spy
    List<String> spyList = new ArrayList<>();

    @Test
    void testSpy() {
        when(spyList.size()).thenReturn(100);

        spyList.add("1");
        spyList.add("2");
        spyList.add("3");

        assertThat(spyList.size(), is(not(3)));
        assertThat(spyList.size(), is(100));
        assertThat(spyList.get(0), is("1"));

        spyList.forEach(System.out::println); // prints real list
    }

    @Test
    void testMock() {
        when(mockList.size()).thenReturn(100);

        mockList.add("1");
        mockList.add("2");
        mockList.add("3");

        assertThat(mockList.size(), is(not(3)));
        assertThat(mockList.size(), is(100));
        assertThat(mockList.get(0), is(not("1")));
        assertThat(mockList.get(0), is(nullValue()));

        mockList.forEach(System.out::println); // prints nothing
    }
}
