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
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TrajectPrijsServiceTest {

    @Mock
    private TrajectNaarTrajectEenhedenService trajectNaarTrajectEenhedenService;
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
        when(trajectNaarTrajectEenhedenService.getTrajectEenheden(eq("AM"), eq("UT"))).thenReturn(5);
        when(trajectEenhedenNaarPrijsService.getPriceTrajectEenheden(eq(5))).thenReturn(4);

        int trajectPrijs = service.getTrajectPrijs("AM", "UT");
        assertThat(trajectPrijs, is(20));
    }

    @Test
    void getTrajectPrijsInvalidLocation() {
        when(trajectNaarTrajectEenhedenService.getTrajectEenheden(eq("XX"), anyString())).thenThrow(new InvalidLocationException());
        assertThrows(InvalidLocationException.class, () -> service.getTrajectPrijs("XX", "UT"));
    }
}