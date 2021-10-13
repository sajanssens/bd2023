package unittesting.labs.lab2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import unittesting.labs.lab2.mocking.lab.PrijsService;
import unittesting.labs.lab2.mocking.lab.ZoneService;
import unittesting.slides.mocking.all.lab.TrajectPrijsService;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.AdditionalMatchers.gt;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TrajectPrijsServiceTest {

    @Mock
    private ZoneService zoneService;
    @Mock
    private PrijsService prijsService;

    @InjectMocks
    private TrajectPrijsService service;

    @Test
    void getTrajectPrijs() {
        // order from generic to specific!
        when(zoneService.getAantalZones(anyString(), anyString())).thenReturn(10);
        when(zoneService.getAantalZones(eq("UTR"), eq("AMS"))).thenReturn(4);
        when(zoneService.getAantalZones(eq("AMS"), eq("DHG"))).thenReturn(5);

        when(prijsService.getZoneprijs(eq(4))).thenReturn(6);
        when(prijsService.getZoneprijs(eq(5))).thenReturn(5);
        when(prijsService.getZoneprijs(gt(5))).thenReturn(3);

        double trajectPrijs = service.getTrajectPrijs("GRO", "LEE");
        assertThat(trajectPrijs, is(30d));

        trajectPrijs = service.getTrajectPrijs("UTR", "AMS");
        assertThat(trajectPrijs, is(24d));

        trajectPrijs = service.getTrajectPrijs("AMS", "DHG");
        assertThat(trajectPrijs, is(25d));

        verify(zoneService, times(3)).getAantalZones(anyString(), anyString());
        verify(prijsService, times(3)).getZoneprijs(anyInt());
    }

    @Test
    void getTrajectPrijsInvalidLocation() {
        assertThrows(IllegalArgumentException.class, () -> service.getTrajectPrijs("XX", "UTR"));
        assertThrows(IllegalArgumentException.class, () -> service.getTrajectPrijs("UTR", "XX"));
    }
}
