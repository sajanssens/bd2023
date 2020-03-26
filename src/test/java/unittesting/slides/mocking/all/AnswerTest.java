package unittesting.slides.mocking.all;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AnswerTest {
    private String theString;

    @Mock
    GetSet mock;

    @Test
    void testAnswer() {
        doAnswer(new Answer<Object>() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                return captureString(invocation);
            }
        }).when(mock).setString(anyString());

        when(mock.getString()).thenAnswer(new Answer<String>() {
            @Override
            public String answer(InvocationOnMock invocation) throws Throwable {
                return theString;
            }
        });

        mock.setString("foo");
        assertEquals("foo", mock.getString());

        mock.setString("bar");
        assertEquals("bar", mock.getString());
    }


    @Test
    void testAnswerJava8() {
        doAnswer(this::captureString).when(mock).setString(anyString());
        when(mock.getString()).thenAnswer(in -> theString);

        mock.setString("foo");
        assertEquals("foo", mock.getString());

        mock.setString("bar");
        assertEquals("bar", mock.getString());
    }

    @Test
    void testAnswerJava8WithArgsAndReturnValue() {
        when(mock.doSomething(anyString())).thenAnswer(in -> "called with " + in.getArgument(0));
        assertEquals(mock.doSomething("abc"), "called with abc");
    }

    private Object captureString(InvocationOnMock in) {
        theString = in.getArgument(0);
        return null;
    }
}
