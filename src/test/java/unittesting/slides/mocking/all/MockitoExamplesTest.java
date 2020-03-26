package unittesting.slides.mocking.all;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;
import static unittesting.slides.mocking.all.IsValidString.isValid;

public class MockitoExamplesTest {

    @Test
    void testBasicsUsingVerify() {
        //mockList creation
        List mockedList = mock(List.class);

        //using mockList object
        mockedList.add("one");
        mockedList.clear();

        //verification
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }

    @Test
    void testBasicsStubbing() {
        LinkedList mockedList = mock(LinkedList.class);

        //stubbing
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());

        //following prints "first"
        assertEquals("first", mockedList.get(0));

        //following throws runtime exception
        assertThrows(RuntimeException.class, () -> mockedList.get(1)); //throws RuntimeException

        //following prints "null" because get(999) was not stubbed
        assertNull(mockedList.get(999));
    }

    @Test
    void testArgumentMatchers() {
        LinkedList<String> mockedList = mock(LinkedList.class);

        // stubbing using built-in anyInt() argument matcher
        when(mockedList.get(anyInt())).thenReturn("e");
        // isValid() is a custom matcher implementation
        when(mockedList.contains(argThat(isValid()))).thenReturn(false);

        assertEquals("e", mockedList.get(999));
        assertFalse(mockedList.contains("123456"));

        //you can also verify using an argument matcher
        verify(mockedList).get(anyInt());
        //argument matchers can also be written as Java 8 Lambdas
        verify(mockedList).contains(argThat(str -> str.toString().length() > 5));
    }

    @Test
    void testTimes() {
        LinkedList<String> mockedList = mock(LinkedList.class);

        mockedList.add("once");

        mockedList.add("twice");
        mockedList.add("twice");

        verify(mockedList).add("once"); //times(1) is default
        //exact number of invocations verification
        verify(mockedList, times(2)).add("twice");
        //verification using never(). never() is alias of times(0)
        verify(mockedList, never()).add("never happened");

        //verification using atLeast()/atMost()
        verify(mockedList, atLeastOnce()).add("twice");
        verify(mockedList, atLeast(2)).add("twice");
        verify(mockedList, atMost(5)).add("twice");
    }

    @Test
    void testThrowing() {
        LinkedList<String> mockedList = mock(LinkedList.class);
        doThrow(new RuntimeException()).when(mockedList).clear();
        assertThrows(RuntimeException.class, mockedList::clear); //throws RuntimeException
    }

    @Test
    void testDoReturn() {
        LinkedList<String> mockedList = mock(LinkedList.class);
        doReturn("a").when(mockedList).get(anyInt()); // not much different from thenReturn in this case
        assertThat(mockedList.get(1), is("a"));
    }

    @Test
    void testStubbingConsecutiveCalls() {
        LinkedList<String> mockedList = mock(LinkedList.class);

        when(mockedList.get(anyInt()))
                .thenReturn("a")
                .thenReturn("b")
                .thenReturn("c");

        assertThat(mockedList.get(1), is("a"));
        assertThat(mockedList.get(12), is("b"));
        assertThat(mockedList.get(144), is("c"));
        assertThat(mockedList.get(0), is("c")); // last stub wins
    }

    @Test
    void testStubbingConsecutiveCalls2() {
        LinkedList<String> mockedList = mock(LinkedList.class);

        when(mockedList.get(anyInt())).thenReturn("a");
        when(mockedList.get(anyInt())).thenReturn("b");

        assertThat(mockedList.get(1), is(not(("a")))); // last stub wins
        assertThat(mockedList.get(1), is("b"));  // last stub wins
    }

}
