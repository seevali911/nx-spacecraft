package com.nationalexpress.spacecraft.repository;

import com.nationalexpress.spacecraft.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RouteRepository extends JpaRepository<Route, String> {

    @Query(value = "SELECT * FROM route WHERE destination=?1", nativeQuery = true)
    List<Route> findAllByDestinationId(int destinationId);

}
