package unittesting.labs.lab2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import unittesting.slides.mocking.all.lab.InvalidLocationException;
import unittesting.slides.mocking.all.lab.TrajectEenhedenNaarPrijsService;
import unittesting.slides.mocking.all.lab.TrajectNaarTrajectEenhedenService;
import unittesting.slides.mocking.all.lab.TrajectPrijsService;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TrajectPrijsServiceTest {

    // @Mock
    private TrajectNaarTrajectEenhedenService trajectNaarTrajectEenhedenService = mock(TrajectNaarTrajectEenhedenService.class);
    @Mock
    private TrajectEenhedenNaarPrijsService trajectEenhedenNaarPrijsService;

    private TrajectPrijsService service;

    @BeforeEach
    public void setup() {
        this.service = new TrajectPrijsService();
        service.setTrajectEenhedenNaarPrijsService(this.trajectEenhedenNaarPrijsService);
        service.setTrajectNaarTrajectEenhedenService(this.trajectNaarTrajectEenhedenService);
    }

    @Test
    void getTrajectPrijs() {
        // given
        when(trajectNaarTrajectEenhedenService.getTrajectEenheden(any(), eq("UT"))).thenReturn(5);
        when(trajectEenhedenNaarPrijsService.getPriceTrajectEenheden(eq(5))).thenReturn(4);

        // when
        int trajectPrijs = service.getTrajectPrijs("AM", "UT");

        // then
        assertThat(trajectPrijs, is(20));
    }

    @Test
    void getTrajectPrijsInvalidLocation() {
        //given
        when(trajectNaarTrajectEenhedenService.getTrajectEenheden(eq("XX"), anyString())).thenThrow(new InvalidLocationException());

        assertThrows(/*then*/ InvalidLocationException.class, () -> /*when: */ service.getTrajectPrijs("XX", "UT"));
    }
}
