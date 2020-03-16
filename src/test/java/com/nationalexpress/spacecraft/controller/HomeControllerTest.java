package com.nationalexpress.spacecraft.controller;

import com.nationalexpress.spacecraft.model.Location;
import com.nationalexpress.spacecraft.model.Route;
import com.nationalexpress.spacecraft.repository.RouteRepository;
import com.nationalexpress.spacecraft.services.LocationService;
import com.nationalexpress.spacecraft.services.RouteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class HomeControllerTest {

    @InjectMocks
    HomeController controller;
    @Mock
    LocationService locationService;
    @Mock
    RouteService routeService;
    @Mock
    RouteRepository routeRepository;


    @Test
    public  void loadLocationsTest () {
        List<Location> locations = Arrays.asList(new Location(1, "Mars", "Y", "mars.png"), new Location(2, "Earth", "Y", "earth.png"));
        when(locationService.findAllInUseLocations()).thenReturn(locations);
        assertEquals(2, locationService.findAllInUseLocations().size());
    }


    @Test
    public  void loadLocationsTestWhenThereIsNoLocation () {
        List<Location> locations = Arrays.asList(new Location(-1, "No destinations available at the moment", "N", "dummy.png"));
        when(locationService.findAllInUseLocations()).thenReturn(locations);
        assertEquals(-1, locationService.findAllInUseLocations().get(0).getLocationId());
    }


    @Test
    public void getLocationByIdTest () {
        List<Route> routes = Arrays.asList(new Route.Builder("No route available").build());
        when(routeService.findAllByDestinationId(1)).thenReturn(routes);
        assertEquals("No route available", routeService.findAllByDestinationId(1).get(0).getRouteId());
    }


    @Test
    public void getLocationByIdTestWhenThereIsNoRoute () {
        List<Route> routes = Arrays.asList(new Route.Builder("NXinS10").build());
        when(routeService.findAllByDestinationId(1)).thenReturn(routes);
        assertEquals(1, routeService.findAllByDestinationId(1).size());
    }

    @Test
    public void getTimetableByRouteIdTest () {
        Route r = new Route.Builder("NXinS10").destination(1).departure(2).departingDay("Monday").build();
        when(routeService.findById("NXinS10")).thenReturn(Optional.of(r));
        assertEquals("Monday", routeService.findById("NXinS10").get().getDepartingDay());
    }

    @Test
    public void getTimetableByRouteIdTestWhenThereIsNoRoute() {
        Route r = new Route.Builder("No route available").build();
        when(routeService.findById("NON_EXIST_ROUTE_ID")).thenReturn(Optional.of(r));
        assertEquals("No route available", routeService.findById("NON_EXIST_ROUTE_ID").get().getRouteId());
    }

}
