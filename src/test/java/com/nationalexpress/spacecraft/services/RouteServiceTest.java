package com.nationalexpress.spacecraft.services;

import com.nationalexpress.spacecraft.model.Route;
import com.nationalexpress.spacecraft.repository.RouteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class RouteServiceTest {
    @InjectMocks
    RouteService routeService;

    @Mock
    RouteRepository repository;


    @Test
    @DisplayName("Find all destinations by destination id")
    public void testFindAllByDestinationId() {
        List<Route> actual = Arrays.asList(new Route.Builder("No route available").build());
        when(routeService.findAllByDestinationId(1)).thenReturn(actual);
        Assertions.assertEquals(Arrays.asList(new Route.Builder("No route available").build()), actual);
    }

    @Test
    @DisplayName("Find by route id")
    public void testFindByIdReturnsCorrectId() {
        when(routeService.findById("NXinS1")).thenReturn(Optional.of(new Route.Builder("NXinS1").build()));
        Assertions.assertEquals("NXinS1", routeService.findById("NXinS1").get().getRouteId());
    }

    @Test
    @DisplayName("save method test")
    public void testThatSaveIsCalled() {
        Route r = new Route.Builder("NO route").departure(1).destination(1).departingDay("Monday").leg1(1).build();
        routeService.save(r);
        verify(repository).save(r);
    }
}
