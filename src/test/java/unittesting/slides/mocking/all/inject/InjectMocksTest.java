package unittesting.slides.mocking.all.inject;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class InjectMocksTest {
    @Mock private PersonDao personDao;

    @InjectMocks // creates service and sets dao on it
    private PersonService ps;

    @Test
    void testMock() {
        String text = "Hello from my mock";
        when(personDao.hello()).thenReturn(text);

        String actual = ps.sayHello();

        assertEquals(text, actual);
    }
}
