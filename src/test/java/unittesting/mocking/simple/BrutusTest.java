package unittesting.mocking.simple;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BrutusTest {

    @Mock
    Hellor helloMock /*= mock(Hellor.class)*/; // 1 create mock

    @InjectMocks
    Brutus target = new Brutus();

    @BeforeEach
    void setUp() {
        // target.setHello(helloMock);
        when(helloMock.hello()).thenReturn("Daisy"); // 2 program mock
    }

    @Test
    public void test() {
        assertEquals("Daisy", target.bruter()); // 3 mock is called (by target)
        verify(helloMock, times(1)).hello(); // 4 verify
    }

}