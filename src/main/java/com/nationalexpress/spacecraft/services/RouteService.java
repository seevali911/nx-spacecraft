package com.nationalexpress.spacecraft.services;

import com.nationalexpress.spacecraft.model.Route;
import com.nationalexpress.spacecraft.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteService  {
    @Autowired
    RouteRepository routeRepository;

    public List<Route> findAllByDestinationId(int destinationId) {
        return routeRepository.findAllByDestinationId(destinationId);
    }

    public Optional<Route> findById(String id) {
        return routeRepository.findById(id);
    }

    public void save(Route route) {
        routeRepository.save(route);
    }
}
