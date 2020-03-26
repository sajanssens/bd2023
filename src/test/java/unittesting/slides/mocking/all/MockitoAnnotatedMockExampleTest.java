package unittesting.slides.mocking.all;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.LinkedList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MockitoAnnotatedMockExampleTest {

    @Mock
    private LinkedList<String> mockedList;

    @Test
    void testSomething() {
        String expected = "e";
        when(mockedList.get(anyInt())).thenReturn(expected);

        String actual = mockedList.get(1);

        assertThat(actual, is(expected));
        verify(mockedList).get(eq((1)));
    }

    @Test
    void testSomethingElseToShowThatMockIsReset() {
        String expected = "f";
        when(mockedList.get(anyInt())).thenReturn(expected);

        String actual = mockedList.get(1);

        assertThat(actual, is(not("e"))); // mockList is automatically reset for each test
        assertThat(actual, is(expected));
        verify(mockedList).get(eq((1)));
    }

}
