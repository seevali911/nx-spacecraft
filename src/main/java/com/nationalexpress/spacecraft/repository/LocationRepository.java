package com.nationalexpress.spacecraft.repository;

import com.nationalexpress.spacecraft.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

    @Query(value = "SELECT * FROM location WHERE inUse='Y'", nativeQuery = true)
    List<Location> findAllInUseLocations();
}
