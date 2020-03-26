package unittesting.slides.mocking.all.inject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class NoInjectMocksTest {
    @Mock private PersonDao personDao;

    private PersonService ps = new PersonService();

    @BeforeEach
    public void init() { ps.setPersonDao(personDao); }

    @Test
    void testMock() {
        String text = "Hello from my mock";
        when(personDao.hello()).thenReturn(text);

        String actual = ps.sayHello();

        assertEquals(text, actual);
    }
}
