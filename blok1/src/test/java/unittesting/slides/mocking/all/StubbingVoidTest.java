package unittesting.slides.mocking.all;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.atomic.AtomicInteger;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StubbingVoidTest {

    @Mock GetSet mock;

    private AtomicInteger counter = new AtomicInteger(0);
    private Object argument;

    @BeforeEach void beforeEach() { counter = new AtomicInteger(0); }

    @Test
    void testStubbingVoidMethod() {
        doNothing().when(mock).setString(anyString()); // however, this is Mockito's default behaviour

        mock.setString("Jan");
        mock.setString("Piet");

        verify(mock, times(2)).setString(anyString());
    }

    @Test
    void testStubbingVoidMethodWithSideEffects() {
        // when/thenReturn cannot be applied on void methods, so this doesn't work:
        // when(mock.setString(anyString())).thenReturn(void?);

        // doAnswer provides a "different kind of when", so this does work:
        doAnswer(this::executeSomeMockBehaviour).when(mock).setString(anyString());

        mock.setString("Piet");

        assertThat(counter.get(), is(1));
        // also, System.out.println("s=" + s); is called
    }

    @Test
    void testCaptureArgsWithDoAnswer() {
        doAnswer(in -> argument = in.getArgument(0)).when(mock).setString(anyString());

        mock.setString("Piet");

        assertThat(argument.toString(), is("Piet"));
    }

    @Test
    void testCaptureArgsWithCaptor() {
        ArgumentCaptor<String> valueCapture = ArgumentCaptor.forClass(String.class);
        doNothing().when(mock).setString(valueCapture.capture());

        mock.setString("b");

        assertThat(valueCapture.getValue(), is("b"));
    }

    @Test
    void testThrowing() {
        doThrow(new RuntimeException()).when(mock).setString(anyString());
        assertThrows(RuntimeException.class, () -> mock.setString("a")); //throws RuntimeException
    }

    private Object executeSomeMockBehaviour(InvocationOnMock s) {
        System.out.println("s=" + s);
        return counter.getAndIncrement();
    }
}
