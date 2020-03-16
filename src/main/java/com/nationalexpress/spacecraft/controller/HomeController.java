package com.nationalexpress.spacecraft.controller;

import com.nationalexpress.spacecraft.model.Location;
import com.nationalexpress.spacecraft.model.Route;
import com.nationalexpress.spacecraft.services.IEntertainment;
import com.nationalexpress.spacecraft.services.LastFm;
import com.nationalexpress.spacecraft.services.LocationService;
import com.nationalexpress.spacecraft.services.RouteService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller("/")
public class HomeController {

    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    LocationService locationService;

    @Autowired
    RouteService routeService;

    @GetMapping("/")
    @ApiOperation(value = "Returns all available destinations", notes = "This method returns all in use destinations.")
    public String loadLocations(Model model) {
        try {
            List<Location> locations = locationService.findAllInUseLocations();
            model.addAttribute("locations", locations);

        } catch (Exception e) {
            log.error(String.format("Error retrieving locations from database. Error returned was {0}", e.getMessage()));
            model.addAttribute("locations", Arrays.asList(new Location(-1, "No destinations available at the moment", "N", "dummy.png")));
            return "index";
        }

        return "index";
    }

    @ApiOperation(value = "Returns all available routes for the selected destinations",
            notes = "This method returns all available routes for the selected destinations. Destination id should be passed in as a path variable.")
    @GetMapping("/locations/{id}")
    public String getLocationById(Model model, @PathVariable("id") int id) {
        try {
            List<Route> routes = routeService.findAllByDestinationId(id);
            model.addAttribute("routes", routes);
            model.addAttribute("routeId", id);
        } catch (Exception e) {
            log.error(String.format("Error retrieving routes from database. Error returned was {0}", e.getMessage()));
            model.addAttribute("routes", new Route.Builder("No route available").build());
            return "route";
        }
        return "route";
    }

    @ApiOperation(value = "Timetable for the selected route", notes = "Static timetable for all the routes. Route id should be passed in as a path variable.")
    @GetMapping("/locations/{id}/timetable")
    public String getTimetableByRouteId(Model model, @PathVariable("id") String id) {
        try {
            Optional<Route> selectedRoute = routeService.findById(id);
            if (selectedRoute.isPresent()) {
                model.addAttribute("route", selectedRoute.get());
            } else {
                model.addAttribute("route", new Route.Builder("No route available").build());
            }

        } catch (Exception e) {
            log.error(String.format("Error retrieving routes from database. Error returned was {0}", e.getMessage()));
            model.addAttribute("routes", new Route.Builder("No route available"));
            return "timetable";
        }
        return "timetable";
    }

    @ApiOperation(value = "Add entertainment provider to the selected route",
            notes = "This method will decorate the route with selected entertainment provider. Route id should be passed in as a path variable.")
    @GetMapping("/locations/{id}/entertainment")
    public String addEntertainment(Model model, @PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        try {
            List<Route> routes = routeService.findAllByDestinationId(id);
            model.addAttribute("routes", routes);
            redirectAttributes.addFlashAttribute("flash.message", "Entertainment has been added to the route.");

            for (Route route : routes) {
                IEntertainment iRoute = route;
                iRoute = new LastFm(iRoute);
                route.setEntertainmentProvider(iRoute.providers());
                routeService.save(route);
            }

        } catch (Exception e) {
            log.error(String.format("Error retrieving routes from database. Error returned was {0}", e.getMessage()));
            model.addAttribute("routes", new Route.Builder("No route available"));
            return "route";
        }
        return "redirect:/locations/"+id;
    }
}
