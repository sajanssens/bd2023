package unittesting.slides.mocking.simple;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import unittesting.slides.mocking.simple.Brutus;
import unittesting.slides.mocking.simple.Hellor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BrutusTest {

    @Mock
    Hellor helloMock; // 1 create mock

    @InjectMocks
    Brutus target = new Brutus();

    @Test
    public void test() {
        when(helloMock.hello()).thenReturn("Daisy"); // 2 program mock
        assertEquals("Daisy", target.bruter()); // 3 mock is called (by target)
        verify(helloMock, times(1)).hello(); // 4 verify
    }

    @Test
    public void testWithArg() {
        ArgumentCaptor<Integer> arg = ArgumentCaptor.forClass(Integer.class);
        when(helloMock.hello(arg.capture())).thenReturn("Daisy 2"); // 2 program mock

        assertEquals("Daisy 2", target.bruter(3)); // 3 mock is called (by target)
        assertThat(arg.getValue()).isEqualTo(6);

        verify(helloMock, times(1)).hello(anyInt()); // 4 verify
    }

}