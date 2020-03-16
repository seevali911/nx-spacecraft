package com.nationalexpress.spacecraft.services;

import com.nationalexpress.spacecraft.model.Location;
import com.nationalexpress.spacecraft.services.LocationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class LocationServiceTest {

    LocationService locationService;

    @BeforeEach
    public void setup () {
        locationService = mock(LocationService.class);
    }

    @Test
    @DisplayName("All locations test")
    public void testFindAllInUseLocations () {
        List<Location> locations = Arrays.asList(new Location(1, "Mars", "Y", "mars.png"));
        when(locationService.findAllInUseLocations()).thenReturn(locations);
        Assertions.assertEquals(Arrays.asList(new Location(1, "Mars", "Y", "mars.png")),
                                        locationService.findAllInUseLocations());
    }
}
